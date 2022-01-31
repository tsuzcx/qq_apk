package com.tencent.mm.plugin.appbrand.appusage;

import a.d.b.g;
import a.n;
import android.os.Looper;
import android.support.v7.g.d;
import com.tencent.mm.ck.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.b.e(com.tencent.mm.plugin.appbrand.a.b.class)
public final class c
  implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b
{
  public static final c.a fHR = new c.a((byte)0);
  private final LinkedList<bvj> fHP = new LinkedList();
  private final am fHQ = new am(Looper.getMainLooper(), (am.a)new c.d(this), false);
  
  public final void Ey()
  {
    ??? = com.tencent.mm.plugin.appbrand.app.e.abf().wh("AppBrandCollectionModifyQueue");
    if (??? != null) {
      if (???.length != 0) {
        break label99;
      }
    }
    label99:
    for (int i = 1;; i = 0) {
      if (i == 0)
      {
        com.tencent.mm.plugin.appbrand.app.e.abf().clear("AppBrandCollectionModifyQueue");
        try
        {
          db localdb = new db();
          localdb.aH((byte[])???);
          synchronized (this.fHP)
          {
            this.fHP.addAll((Collection)localdb.dtH);
            return;
          }
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = " + localException);
        }
      }
    }
  }
  
  public final void Ez()
  {
    db localdb = new db();
    synchronized (this.fHP)
    {
      localdb.dtH.addAll((Collection)this.fHP);
      if (localdb.dtH.isEmpty()) {}
    }
  }
  
  public final void a(z.b paramb)
  {
    g.k(paramb, "reason");
    y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.fHQ.stopTimer();
    LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.fHP)
    {
      localLinkedList2.addAll((Collection)this.fHP);
      this.fHP.clear();
      n localn = n.xoh;
      if (localLinkedList2.isEmpty())
      {
        y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.fJL + "], queue empty");
        if ((g.e(paramb, z.b.fJH)) || (g.e(paramb, z.b.fJI)))
        {
          paramb = ae.fJQ;
          ae.a.bK(2, 2);
        }
        return;
      }
    }
    y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.fJL + "], queue_size=" + localLinkedList2.size());
    new z((List)localLinkedList2, paramb.fJL).Km().j((com.tencent.mm.vending.c.a)new c.e(this, paramb, localLinkedList2));
  }
  
  public final void a(bvj parambvj, z.b paramb)
  {
    g.k(parambvj, "op");
    g.k(paramb, "reason");
    synchronized (this.fHP)
    {
      this.fHP.addLast(parambvj);
      parambvj = n.xoh;
      switch (d.fHS[paramb.ordinal()])
      {
      default: 
        a(paramb);
        return;
      }
    }
    this.fHQ.hq(30000L);
  }
  
  public final boolean a(android.support.v7.g.c.b paramb, List<? extends LocalUsageInfo> arg2, List<? extends LocalUsageInfo> paramList2, c.b paramb1)
  {
    g.k(paramb, "diff");
    g.k(???, "oldList");
    g.k(paramList2, "newList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)???);
    PInt localPInt = new PInt(0);
    synchronized (this.fHP)
    {
      paramb.a((d)new c.c(this, paramb, localPInt, paramList2, paramb1, localArrayList));
      paramb = n.xoh;
      if (localPInt.value > 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */