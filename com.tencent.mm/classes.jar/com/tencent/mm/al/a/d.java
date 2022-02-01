package com.tencent.mm.al.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
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
  public ISQLiteDatabase db;
  final MStorageEvent<a, d.a.b> iNS;
  private AtomicLong iPI;
  
  static
  {
    AppMethodBeat.i(124212);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "BizChatInfo") };
    AppMethodBeat.o(124212);
  }
  
  public d(ISQLiteDatabase arg1)
  {
    super(???, c.info, "BizChatInfo", null);
    AppMethodBeat.i(124203);
    this.iPI = new AtomicLong(-1L);
    this.iNS = new MStorageEvent() {};
    this.db = ???;
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.iPI)
    {
      Cursor localCursor = this.db.rawQuery("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.iPI.get())
        {
          this.iPI.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      Log.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(l1)));
      AppMethodBeat.o(124203);
      return;
    }
  }
  
  private long baz()
  {
    AppMethodBeat.i(124211);
    synchronized (this.iPI)
    {
      long l = this.iPI.incrementAndGet();
      Log.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(124211);
      return l;
    }
  }
  
  public final boolean Am(long paramLong)
  {
    AppMethodBeat.i(124208);
    c localc = bs(paramLong);
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.iPE = localc.field_bizChatLocalId;
      localb.brandName = localc.field_brandUserName;
      localb.iPO = d.a.a.iPL;
      localb.iPP = localc;
      this.iNS.event(localb);
      this.iNS.doNotify();
    }
    AppMethodBeat.o(124208);
    return bool;
  }
  
  public final c NE(String paramString)
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
    if (this.iNS != null) {
      this.iNS.remove(parama);
    }
    AppMethodBeat.o(124205);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124204);
    this.iNS.add(parama, paramLooper);
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
    Object localObject = NE(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(124209);
      return true;
    }
    paramc.field_bizChatLocalId = baz();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).iPE = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).brandName = paramc.field_brandUserName;
      ((d.a.b)localObject).iPO = d.a.a.iPK;
      ((d.a.b)localObject).iPP = paramc;
      this.iNS.event(localObject);
      this.iNS.doNotify();
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
    Object localObject = bs(paramc.field_bizChatLocalId);
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
        ((d.a.b)localObject).iPE = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).brandName = paramc.field_brandUserName;
        ((d.a.b)localObject).iPO = d.a.a.iPM;
        ((d.a.b)localObject).iPP = paramc;
        this.iNS.event(localObject);
        this.iNS.doNotify();
      }
      AppMethodBeat.o(124210);
      return bool;
      paramc.field_chatNamePY = f.Sh(paramc.field_chatName);
    }
  }
  
  public final c bs(long paramLong)
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
        iPK = new a("INSTERT", 0);
        iPL = new a("DELETE", 1);
        iPM = new a("UPDATE", 2);
        iPN = new a[] { iPK, iPL, iPM };
        AppMethodBeat.o(124202);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String brandName;
      public long iPE;
      public d.a.a iPO;
      public c iPP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.d
 * JD-Core Version:    0.7.0.1
 */