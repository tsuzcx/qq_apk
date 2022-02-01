package com.tencent.mm.al.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends j<ag>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final l<a, d.a.b> hSD;
  private AtomicLong hUv;
  
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
    this.hUv = new AtomicLong(-1L);
    this.hSD = new l() {};
    this.db = ???;
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.hUv)
    {
      Cursor localCursor = this.db.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.hUv.get())
        {
          this.hUv.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      ae.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(l1)));
      AppMethodBeat.o(124203);
      return;
    }
  }
  
  private long aGG()
  {
    AppMethodBeat.i(124211);
    synchronized (this.hUv)
    {
      long l = this.hUv.incrementAndGet();
      ae.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(124211);
      return l;
    }
  }
  
  public final c EQ(String paramString)
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
    ae.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
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
    if (this.hSD != null) {
      this.hSD.remove(parama);
    }
    AppMethodBeat.o(124205);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124204);
    this.hSD.a(parama, paramLooper);
    AppMethodBeat.o(124204);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(124209);
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124209);
      return false;
    }
    if (bu.isNullOrNil(paramc.field_bizChatServId))
    {
      ae.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
      AppMethodBeat.o(124209);
      return false;
    }
    Object localObject = EQ(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      ae.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(124209);
      return true;
    }
    paramc.field_bizChatLocalId = aGG();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).hUr = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).dpI = paramc.field_brandUserName;
      ((d.a.b)localObject).hUB = d.a.a.hUx;
      ((d.a.b)localObject).hUC = paramc;
      this.hSD.dW(localObject);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(124209);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(124210);
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      AppMethodBeat.o(124210);
      return false;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      ae.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      AppMethodBeat.o(124210);
      return false;
    }
    Object localObject = bd(paramc.field_bizChatLocalId);
    if ((!bu.isNullOrNil(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      ae.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      AppMethodBeat.o(124210);
      return false;
    }
    if ((paramc == null) || (bu.isNullOrNil(paramc.field_chatName))) {
      ae.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramc);
      if (bool)
      {
        e.g(paramc);
        localObject = new d.a.b();
        ((d.a.b)localObject).hUr = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).dpI = paramc.field_brandUserName;
        ((d.a.b)localObject).hUB = d.a.a.hUz;
        ((d.a.b)localObject).hUC = paramc;
        this.hSD.dW(localObject);
        this.hSD.doNotify();
      }
      AppMethodBeat.o(124210);
      return bool;
      paramc.field_chatNamePY = f.Jk(paramc.field_chatName);
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
  
  public final boolean sg(long paramLong)
  {
    AppMethodBeat.i(124208);
    c localc = bd(paramLong);
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.hUr = localc.field_bizChatLocalId;
      localb.dpI = localc.field_brandUserName;
      localb.hUB = d.a.a.hUy;
      localb.hUC = localc;
      this.hSD.dW(localb);
      this.hSD.doNotify();
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
        hUx = new a("INSTERT", 0);
        hUy = new a("DELETE", 1);
        hUz = new a("UPDATE", 2);
        hUA = new a[] { hUx, hUy, hUz };
        AppMethodBeat.o(124202);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String dpI;
      public d.a.a hUB;
      public c hUC;
      public long hUr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.d
 * JD-Core Version:    0.7.0.1
 */