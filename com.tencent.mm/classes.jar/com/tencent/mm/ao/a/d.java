package com.tencent.mm.ao.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ah;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends MAutoStorage<ah>
{
  public static final String[] SQL_CREATE;
  private static AtomicLong lFY;
  public ISQLiteDatabase db;
  final MStorageEvent<a, d.a.b> lEj;
  
  static
  {
    AppMethodBeat.i(124212);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "BizChatInfo") };
    lFY = new AtomicLong(-1L);
    AppMethodBeat.o(124212);
  }
  
  public d(ISQLiteDatabase arg1)
  {
    super(???, c.info, "BizChatInfo", null);
    AppMethodBeat.i(124203);
    this.lEj = new MStorageEvent() {};
    this.db = ???;
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    label201:
    for (;;)
    {
      synchronized (lFY)
      {
        Cursor localCursor = this.db.rawQuery("select max(bizChatLocalId) from BizChatInfo", null, 2);
        if (localCursor.moveToFirst())
        {
          l2 = localCursor.getInt(0);
          l1 = lFY.get();
          if (l2 <= l1) {
            break label201;
          }
          lFY.set(l2);
          break label201;
          localCursor.close();
          Log.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id=%d, last max=%d, db=%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), toString() });
          AppMethodBeat.o(124203);
          return;
        }
      }
      long l1 = 0L;
      long l2 = 0L;
    }
  }
  
  private long bjO()
  {
    AppMethodBeat.i(124211);
    synchronized (lFY)
    {
      long l = lFY.incrementAndGet();
      Log.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d, db=%s", new Object[] { Long.valueOf(l), toString() });
      AppMethodBeat.o(124211);
      return l;
    }
  }
  
  public final boolean Gu(long paramLong)
  {
    AppMethodBeat.i(124208);
    c localc = bF(paramLong);
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.lFU = localc.field_bizChatLocalId;
      localb.fzM = localc.field_brandUserName;
      localb.lGe = d.a.a.lGb;
      localb.lGf = localc;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124208);
    return bool;
  }
  
  public final c Va(String paramString)
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
    if (this.lEj != null) {
      this.lEj.remove(parama);
    }
    AppMethodBeat.o(124205);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124204);
    this.lEj.add(parama, paramLooper);
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
    Object localObject = Va(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(124209);
      return true;
    }
    paramc.field_bizChatLocalId = bjO();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).lFU = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).fzM = paramc.field_brandUserName;
      ((d.a.b)localObject).lGe = d.a.a.lGa;
      ((d.a.b)localObject).lGf = paramc;
      this.lEj.event(localObject);
      this.lEj.doNotify();
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
    Object localObject = bF(paramc.field_bizChatLocalId);
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
        ((d.a.b)localObject).lFU = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).fzM = paramc.field_brandUserName;
        ((d.a.b)localObject).lGe = d.a.a.lGc;
        ((d.a.b)localObject).lGf = paramc;
        this.lEj.event(localObject);
        this.lEj.doNotify();
      }
      AppMethodBeat.o(124210);
      return bool;
      paramc.field_chatNamePY = f.ZJ(paramc.field_chatName);
    }
  }
  
  public final c bF(long paramLong)
  {
    AppMethodBeat.i(124206);
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124206);
    return localc;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(124202);
        lGa = new a("INSTERT", 0);
        lGb = new a("DELETE", 1);
        lGc = new a("UPDATE", 2);
        lGd = new a[] { lGa, lGb, lGc };
        AppMethodBeat.o(124202);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String fzM;
      public long lFU;
      public d.a.a lGe;
      public c lGf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.d
 * JD-Core Version:    0.7.0.1
 */