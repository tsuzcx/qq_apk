package com.tencent.mm.aj.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends j<com.tencent.mm.g.c.ab>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final l<d.a, d.a.b> fuL;
  private AtomicLong fxu;
  
  static
  {
    AppMethodBeat.i(11527);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "BizChatInfo") };
    AppMethodBeat.o(11527);
  }
  
  public d(com.tencent.mm.sdk.e.e arg1)
  {
    super(???, c.info, "BizChatInfo", null);
    AppMethodBeat.i(11518);
    this.fxu = new AtomicLong(-1L);
    this.fuL = new d.1(this);
    this.db = ???;
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.fxu)
    {
      Cursor localCursor = this.db.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.fxu.get())
        {
          this.fxu.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(l1)));
      AppMethodBeat.o(11518);
      return;
    }
  }
  
  private long afz()
  {
    AppMethodBeat.i(11526);
    synchronized (this.fxu)
    {
      long l = this.fxu.incrementAndGet();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(11526);
      return l;
    }
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(11520);
    if (this.fuL != null) {
      this.fuL.remove(parama);
    }
    AppMethodBeat.o(11520);
  }
  
  public final void a(d.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(11519);
    this.fuL.a(parama, paramLooper);
    AppMethodBeat.o(11519);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(11524);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
      AppMethodBeat.o(11524);
      return false;
    }
    if (bo.isNullOrNil(paramc.field_bizChatServId))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
      AppMethodBeat.o(11524);
      return false;
    }
    Object localObject = sl(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      AppMethodBeat.o(11524);
      return true;
    }
    paramc.field_bizChatLocalId = afz();
    boolean bool = super.insert(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).fxq = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).cqQ = paramc.field_brandUserName;
      ((d.a.b)localObject).fxA = d.a.a.fxw;
      ((d.a.b)localObject).fxB = paramc;
      this.fuL.cy(localObject);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11524);
    return bool;
  }
  
  public final c aG(long paramLong)
  {
    AppMethodBeat.i(11521);
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.get(localc, new String[0]);
    AppMethodBeat.o(11521);
    return localc;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(11525);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      AppMethodBeat.o(11525);
      return false;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      AppMethodBeat.o(11525);
      return false;
    }
    Object localObject = aG(paramc.field_bizChatLocalId);
    if ((!bo.isNullOrNil(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      AppMethodBeat.o(11525);
      return false;
    }
    if ((paramc == null) || (bo.isNullOrNil(paramc.field_chatName))) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramc);
      if (bool)
      {
        e.g(paramc);
        localObject = new d.a.b();
        ((d.a.b)localObject).fxq = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).cqQ = paramc.field_brandUserName;
        ((d.a.b)localObject).fxA = d.a.a.fxy;
        ((d.a.b)localObject).fxB = paramc;
        this.fuL.cy(localObject);
        this.fuL.doNotify();
      }
      AppMethodBeat.o(11525);
      return bool;
      paramc.field_chatNamePY = g.wq(paramc.field_chatName);
    }
  }
  
  public final boolean gG(long paramLong)
  {
    AppMethodBeat.i(11523);
    c localc = aG(paramLong);
    boolean bool = super.delete(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.fxq = localc.field_bizChatLocalId;
      localb.cqQ = localc.field_brandUserName;
      localb.fxA = d.a.a.fxx;
      localb.fxB = localc;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11523);
    return bool;
  }
  
  public final c sl(String paramString)
  {
    AppMethodBeat.i(11522);
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("select * ");
    ((StringBuilder)localObject3).append(" from BizChatInfo");
    ((StringBuilder)localObject3).append(" where bizChatServId = '").append(paramString).append("' ");
    ((StringBuilder)localObject3).append(" limit 1");
    paramString = ((StringBuilder)localObject3).toString();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
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
    AppMethodBeat.o(11522);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.d
 * JD-Core Version:    0.7.0.1
 */