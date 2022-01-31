package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ao;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements t
{
  private static List<ao> mda = new ArrayList();
  private boolean mdb = false;
  private boolean mdc = false;
  private List<bi> mdd = new LinkedList();
  
  public g()
  {
    this(false);
  }
  
  public g(boolean paramBoolean)
  {
    this.mdb = paramBoolean;
    this.mdc = false;
    this.mdd = new LinkedList();
  }
  
  public static void a(ao paramao)
  {
    synchronized (mda)
    {
      if (!mda.contains(paramao)) {
        mda.add(paramao);
      }
      return;
    }
  }
  
  public static void b(ao paramao)
  {
    synchronized (mda)
    {
      mda.remove(paramao);
      return;
    }
  }
  
  public final void a(bi parambi, cd paramcd)
  {
    if (this.mdb) {
      y.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
    }
    for (;;)
    {
      return;
      synchronized (mda)
      {
        if (mda.isEmpty())
        {
          y.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
          return;
        }
      }
      if ((parambi.field_isSend != 0) || (parambi.field_status == 4))
      {
        y.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        return;
      }
      ??? = aa.a(paramcd.svF);
      ??? = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic(new bq.a((String)???).aco(""));
      if ((??? != null) && (!((bq)???).cvY()))
      {
        y.d("MicroMsg.SyncMessageNotifier", "account no notification");
        return;
      }
      if (this.mdc) {
        break;
      }
      this.mdc = true;
      Object localObject2 = new ArrayList();
      synchronized (mda)
      {
        Iterator localIterator = mda.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((ao)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ao)((Iterator)???).next();
        new ah(((ao)localObject2).getLooper()).post(new g.2(this, paramcd, (ao)localObject2, parambi));
      }
    }
    this.mdd.add(parambi);
  }
  
  public final void bhP()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.mdd);
    this.mdd.clear();
    if (localLinkedList.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      synchronized (mda)
      {
        Iterator localIterator = mda.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((ao)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ao)((Iterator)???).next();
        new ah(((ao)localObject2).getLooper()).post(new g.1(this, (ao)localObject2, localList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */