package com.tencent.mm.am.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends j<ag>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final l<a, d.a.b> hPL;
  private AtomicLong hRD;
  
  static
  {
    AppMethodBeat.i(124212);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "BizChatInfo") };
    AppMethodBeat.o(124212);
  }
  
  public d(com.tencent.mm.sdk.e.e arg1)
  {
    super(???, c.info, "BizChatInfo", null);
    AppMethodBeat.i(124203);
    this.hRD = new AtomicLong(-1L);
    this.hPL = new l() {};
    this.db = ???;
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.hRD)
    {
      Cursor localCursor = this.db.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.hRD.get())
        {
          this.hRD.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      ad.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(l1)));
      AppMethodBeat.o(124203);
      return;
    }
  }
  
  private long aGq()
  {
    AppMethodBeat.i(124211);
    synchronized (this.hRD)
    {
      long l = this.hRD.incrementAndGet();
      ad.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(124211);
      return l;
    }
  }
  
  public final c Eo(String paramString)
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
    ad.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
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
    if (this.hPL != null) {
      this.hPL.remove(parama);
    }
    AppMethodBeat.o(124205);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124204);
    this.hPL.a(parama, paramLooper);
    AppMethodBeat.o(124204);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(124209);
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124209);
      return false;
    }
    if (bt.isNullOrNil(paramc.field_bizChatServId))
    {
      ad.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
      AppMethodBeat.o(124209);
      return false;
    }
    Object localObject = Eo(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      ad.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(124209);
      return true;
    }
    paramc.field_bizChatLocalId = aGq();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).hRz = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).doD = paramc.field_brandUserName;
      ((d.a.b)localObject).hRJ = d.a.a.hRF;
      ((d.a.b)localObject).hRK = paramc;
      this.hPL.dV(localObject);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124209);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(124210);
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      AppMethodBeat.o(124210);
      return false;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      ad.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      AppMethodBeat.o(124210);
      return false;
    }
    Object localObject = bd(paramc.field_bizChatLocalId);
    if ((!bt.isNullOrNil(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      ad.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      AppMethodBeat.o(124210);
      return false;
    }
    if ((paramc == null) || (bt.isNullOrNil(paramc.field_chatName))) {
      ad.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramc);
      if (bool)
      {
        e.g(paramc);
        localObject = new d.a.b();
        ((d.a.b)localObject).hRz = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).doD = paramc.field_brandUserName;
        ((d.a.b)localObject).hRJ = d.a.a.hRH;
        ((d.a.b)localObject).hRK = paramc;
        this.hPL.dV(localObject);
        this.hPL.doNotify();
      }
      AppMethodBeat.o(124210);
      return bool;
      paramc.field_chatNamePY = f.IL(paramc.field_chatName);
    }
  }
  
  public final c bd(long paramLong)
  {
    AppMethodBeat.i(124206);
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124206);
    return localc;
  }
  
  public final boolean rT(long paramLong)
  {
    AppMethodBeat.i(124208);
    c localc = bd(paramLong);
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.hRz = localc.field_bizChatLocalId;
      localb.doD = localc.field_brandUserName;
      localb.hRJ = d.a.a.hRG;
      localb.hRK = localc;
      this.hPL.dV(localb);
      this.hPL.doNotify();
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
        hRF = new a("INSTERT", 0);
        hRG = new a("DELETE", 1);
        hRH = new a("UPDATE", 2);
        hRI = new a[] { hRF, hRG, hRH };
        AppMethodBeat.o(124202);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String doD;
      public d.a.a hRJ;
      public c hRK;
      public long hRz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.d
 * JD-Core Version:    0.7.0.1
 */