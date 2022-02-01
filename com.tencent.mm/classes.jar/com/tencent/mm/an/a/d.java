package com.tencent.mm.an.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends MAutoStorage<ai>
{
  public static final String[] SQL_CREATE;
  private static final AtomicLong oxF;
  public ISQLiteDatabase db;
  final MStorageEvent<a, d.a.b> ovQ;
  
  static
  {
    AppMethodBeat.i(124212);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "BizChatInfo") };
    oxF = new AtomicLong(-1L);
    AppMethodBeat.o(124212);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "BizChatInfo", null);
    AppMethodBeat.i(124203);
    this.ovQ = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    paramISQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    paramISQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (oxF)
    {
      long l1 = oxF.get();
      paramISQLiteDatabase = localCursor;
      try
      {
        localCursor = this.db.rawQuery("select max(bizChatLocalId) from BizChatInfo", null, 2);
        long l2 = l1;
        paramISQLiteDatabase = localCursor;
        if (localCursor.moveToFirst())
        {
          paramISQLiteDatabase = localCursor;
          int i = localCursor.getInt(0);
          l2 = i;
        }
        com.tencent.g.c.f.z(localCursor);
        l1 = l2;
        l2 = Math.max(l1, bHA());
        if (l2 > oxF.get())
        {
          oxF.set(l2);
          iJ(l2);
        }
        Log.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id=%d, last max=%d, db=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), toString() });
        AppMethodBeat.o(124203);
        return;
      }
      finally {}
    }
  }
  
  private static long bHA()
  {
    long l1 = -1L;
    AppMethodBeat.i(239489);
    try
    {
      long l2 = MultiProcessMMKV.getMMKV("BizChatInfo", 2).getLong("max_biz_chat_local_id", -1L);
      l1 = l2;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.BizChatInfoStorage", "get max biz chat local id", new Object[] { localObject });
      }
    }
    AppMethodBeat.o(239489);
    return l1;
  }
  
  private long bHz()
  {
    AppMethodBeat.i(124211);
    synchronized (oxF)
    {
      long l = oxF.incrementAndGet();
      iJ(l);
      Log.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d, db=%s", new Object[] { Long.valueOf(l), toString() });
      AppMethodBeat.o(124211);
      return l;
    }
  }
  
  private static void iJ(long paramLong)
  {
    AppMethodBeat.i(239493);
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("BizChatInfo", 2);
      if (paramLong > localMultiProcessMMKV.getLong("max_biz_chat_local_id", -1L)) {
        localMultiProcessMMKV.putLong("max_biz_chat_local_id", paramLong);
      }
      AppMethodBeat.o(239493);
      return;
    }
    finally
    {
      Log.e("MicroMsg.BizChatInfoStorage", "set max biz chat local id", new Object[] { localObject });
      AppMethodBeat.o(239493);
    }
  }
  
  public final c MZ(String paramString)
  {
    AppMethodBeat.i(124207);
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("select * ");
    ((StringBuilder)localObject3).append(" from BizChatInfo");
    ((StringBuilder)localObject3).append(" where bizChatServId = '").append(paramString).append("' ");
    ((StringBuilder)localObject3).append(" limit 1");
    paramString = ((StringBuilder)localObject3).toString();
    Log.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
    localObject3 = rawQuery(paramString, new String[0]);
    paramString = localObject2;
    if (localObject3 != null)
    {
      paramString = localObject1;
      if (((Cursor)localObject3).moveToFirst())
      {
        paramString = new c();
        paramString.convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(124207);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124205);
    if (this.ovQ != null) {
      this.ovQ.remove(parama);
    }
    AppMethodBeat.o(124205);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124204);
    this.ovQ.add(parama, paramLooper);
    AppMethodBeat.o(124204);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(124209);
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124209);
      return false;
    }
    if (Util.isNullOrNil(paramc.field_bizChatServId))
    {
      Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
      AppMethodBeat.o(124209);
      return false;
    }
    Object localObject = MZ(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(124209);
      return true;
    }
    paramc.field_bizChatLocalId = bHz();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).oxB = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).hEy = paramc.field_brandUserName;
      ((d.a.b)localObject).oxL = d.a.a.oxH;
      ((d.a.b)localObject).oxM = paramc;
      this.ovQ.event(localObject);
      this.ovQ.doNotify();
    }
    AppMethodBeat.o(124209);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(124210);
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      AppMethodBeat.o(124210);
      return false;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      Log.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      AppMethodBeat.o(124210);
      return false;
    }
    Object localObject = dW(paramc.field_bizChatLocalId);
    if (localObject == null)
    {
      Log.e("MicroMsg.BizChatInfoStorage", "update bizchat localid not exist");
      AppMethodBeat.o(124210);
      return false;
    }
    if ((!Util.isNullOrNil(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      Log.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      AppMethodBeat.o(124210);
      return false;
    }
    if ((paramc == null) || (Util.isNullOrNil(paramc.field_chatName))) {
      Log.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramc);
      if (bool)
      {
        e.g(paramc);
        localObject = new d.a.b();
        ((d.a.b)localObject).oxB = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).hEy = paramc.field_brandUserName;
        ((d.a.b)localObject).oxL = d.a.a.oxJ;
        ((d.a.b)localObject).oxM = paramc;
        this.ovQ.event(localObject);
        this.ovQ.doNotify();
      }
      AppMethodBeat.o(124210);
      return bool;
      paramc.field_chatNamePY = com.tencent.mm.platformtools.f.RZ(paramc.field_chatName);
    }
  }
  
  public final c dW(long paramLong)
  {
    AppMethodBeat.i(124206);
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124206);
    return localc;
  }
  
  public final boolean iE(long paramLong)
  {
    AppMethodBeat.i(124208);
    c localc = dW(paramLong);
    if (localc == null)
    {
      Log.i("MicroMsg.BizChatInfoStorage", "no such bizChat");
      AppMethodBeat.o(124208);
      return false;
    }
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.oxB = localc.field_bizChatLocalId;
      localb.hEy = localc.field_brandUserName;
      localb.oxL = d.a.a.oxI;
      localb.oxM = localc;
      this.ovQ.event(localb);
      this.ovQ.doNotify();
    }
    AppMethodBeat.o(124208);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(124202);
        oxH = new a("INSTERT", 0);
        oxI = new a("DELETE", 1);
        oxJ = new a("UPDATE", 2);
        oxK = new a[] { oxH, oxI, oxJ };
        AppMethodBeat.o(124202);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String hEy;
      public long oxB;
      public d.a.a oxL;
      public c oxM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.d
 * JD-Core Version:    0.7.0.1
 */