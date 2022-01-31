package com.tencent.mm.ai.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.h.c.aa;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends i<aa>
{
  public static final String[] dXp = { i.a(c.buS, "BizChatInfo") };
  public com.tencent.mm.sdk.e.e dXw;
  final k<a, d.a.b> eeJ = new d.1(this);
  private AtomicLong ehq = new AtomicLong(-1L);
  
  public d(com.tencent.mm.sdk.e.e arg1)
  {
    super(???, c.buS, "BizChatInfo", null);
    this.dXw = ???;
    ???.gk("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.gk("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.gk("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.ehq)
    {
      Cursor localCursor = this.dXw.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.ehq.get())
        {
          this.ehq.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      y.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + l1);
      return;
    }
  }
  
  private long MP()
  {
    synchronized (this.ehq)
    {
      long l = this.ehq.incrementAndGet();
      y.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      return l;
    }
  }
  
  public final void a(a parama)
  {
    if (this.eeJ != null) {
      this.eeJ.remove(parama);
    }
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    this.eeJ.a(parama, paramLooper);
  }
  
  public final boolean a(c paramc)
  {
    boolean bool1 = false;
    if (paramc == null) {
      y.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
    }
    boolean bool2;
    do
    {
      return bool1;
      if (bk.bl(paramc.field_bizChatServId))
      {
        y.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
        return false;
      }
      localObject = lp(paramc.field_bizChatServId);
      if (localObject != null)
      {
        paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
        y.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
        return true;
      }
      paramc.field_bizChatLocalId = MP();
      bool2 = super.b(paramc);
      bool1 = bool2;
    } while (!bool2);
    Object localObject = new d.a.b();
    ((d.a.b)localObject).ehm = paramc.field_bizChatLocalId;
    ((d.a.b)localObject).bJw = paramc.field_brandUserName;
    ((d.a.b)localObject).ehw = d.a.a.ehs;
    ((d.a.b)localObject).ehx = paramc;
    this.eeJ.bV(localObject);
    this.eeJ.doNotify();
    return bool2;
  }
  
  public final c aj(long paramLong)
  {
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.b(localc, new String[0]);
    return localc;
  }
  
  public final boolean b(c paramc)
  {
    boolean bool1 = false;
    if (paramc == null)
    {
      y.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      return bool1;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      y.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      return false;
    }
    Object localObject = aj(paramc.field_bizChatLocalId);
    if ((!bk.bl(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      y.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      return false;
    }
    if ((paramc == null) || (bk.bl(paramc.field_chatName))) {
      y.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool2 = super.a(paramc);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      e.g(paramc);
      localObject = new d.a.b();
      ((d.a.b)localObject).ehm = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).bJw = paramc.field_brandUserName;
      ((d.a.b)localObject).ehw = d.a.a.ehu;
      ((d.a.b)localObject).ehx = paramc;
      this.eeJ.bV(localObject);
      this.eeJ.doNotify();
      return bool2;
      paramc.field_chatNamePY = g.oY(paramc.field_chatName);
    }
  }
  
  public final boolean bL(long paramLong)
  {
    c localc = aj(paramLong);
    boolean bool = super.a(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.ehm = localc.field_bizChatLocalId;
      localb.bJw = localc.field_brandUserName;
      localb.ehw = d.a.a.eht;
      localb.ehx = localc;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final c lp(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("select * ");
    ((StringBuilder)localObject3).append(" from BizChatInfo");
    ((StringBuilder)localObject3).append(" where bizChatServId = '").append(paramString).append("' ");
    ((StringBuilder)localObject3).append(" limit 1");
    paramString = ((StringBuilder)localObject3).toString();
    y.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
    localObject3 = rawQuery(paramString, new String[0]);
    paramString = localObject2;
    if (localObject3 != null)
    {
      paramString = localObject1;
      if (((Cursor)localObject3).moveToFirst())
      {
        paramString = new c();
        paramString.d((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(d.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.a.d
 * JD-Core Version:    0.7.0.1
 */