package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f
{
  public byte[] dMQ = new byte[0];
  private List<WeakReference<d>> fKm = new ArrayList();
  public List<n> ijT = am.aAB().aAq();
  public List<n> ijU = new ArrayList();
  public com.tencent.mm.plugin.card.sharecard.model.e iow;
  private int iox = 0;
  public int ioy = 5;
  public ah mHandler = new ah(Looper.getMainLooper());
  private Runnable mRunnable = new a.1(this);
  
  public a()
  {
    y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[] { Integer.valueOf(this.ijT.size()) });
    g.DO().dJT.a(903, this);
  }
  
  private ArrayList<n> K(LinkedList<String> paramLinkedList)
  {
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      int i;
      synchronized (this.dMQ)
      {
        if (this.ijT.size() == 0)
        {
          y.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
          return localArrayList;
        }
        localLinkedList.addAll(this.ijT);
        i = 0;
        if (i >= paramLinkedList.size()) {
          break;
        }
        ??? = (String)paramLinkedList.get(i);
        int j = 0;
        if (j < localLinkedList.size())
        {
          if ((??? != null) && (localLinkedList.get(j) != null) && (((String)???).equals(((n)localLinkedList.get(j)).field_card_id))) {
            localArrayList.add(localLinkedList.get(j));
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final void a(d paramd)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (paramd != null) {
      this.fKm.add(new WeakReference(paramd));
    }
  }
  
  public final void aAN()
  {
    y.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - this.iox;
    int i;
    if (this.ioy <= 0)
    {
      i = 5;
      if (k < i) {
        break label73;
      }
      com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
      g.DO().dJT.a(localh, 0);
    }
    for (;;)
    {
      this.iox = j;
      return;
      i = this.ioy;
      break;
      label73:
      y.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is " + k);
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler.postDelayed(this.mRunnable, i * 1000);
    }
  }
  
  public final void axs()
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (d)((WeakReference)localObject).get();
          if (localObject != null) {
            ((d)localObject).azI();
          }
        }
        i += 1;
      }
    }
  }
  
  public final void azK()
  {
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.dMQ)
    {
      if (this.ijT.size() == 0)
      {
        y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
        return;
      }
      localLinkedList1.addAll(this.ijT);
      if (this.iow != null)
      {
        y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
        return;
      }
    }
    ??? = new LinkedList();
    if (localCollection.size() <= 10) {
      ((LinkedList)???).addAll(localCollection);
    }
    LinkedList localLinkedList2;
    for (;;)
    {
      localLinkedList2 = new LinkedList();
      int i = 0;
      while (i < ((LinkedList)???).size())
      {
        localLinkedList2.add(((n)((LinkedList)???).get(i)).field_card_id);
        i += 1;
      }
      ((LinkedList)???).addAll(localLinkedList2.subList(0, 10));
    }
    this.iow = new com.tencent.mm.plugin.card.sharecard.model.e(localLinkedList2);
    g.DO().dJT.a(this.iow, 0);
  }
  
  public final void b(d paramd)
  {
    if ((this.fKm == null) || (paramd == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null)
        {
          d locald = (d)localWeakReference.get();
          if ((locald != null) && (locald.equals(paramd)))
          {
            this.fKm.remove(localWeakReference);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iow = null;
    n localn;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramm = K(((com.tencent.mm.plugin.card.sharecard.model.e)paramm).jdField_int);
      for (;;)
      {
        synchronized (this.dMQ)
        {
          if (paramm.size() > 0)
          {
            this.ijT.removeAll(paramm);
            this.ijU.addAll(paramm);
          }
          ??? = am.aAB();
          if (paramm.size() == 0)
          {
            y.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
          }
        }
        paramm = paramm.iterator();
        while (paramm.hasNext())
        {
          localn = (n)paramm.next();
          if (localn != null)
          {
            localn.field_retryCount += 1;
            ???.c(localn, new String[0]);
          }
        }
      }
    }
    paramm = K(((com.tencent.mm.plugin.card.sharecard.model.e)paramm).inu);
    y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramm.size()) });
    for (;;)
    {
      synchronized (this.dMQ)
      {
        this.ijT.removeAll(paramm);
        long l1 = System.currentTimeMillis();
        long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
        ??? = am.aAB();
        if (paramm.size() == 0)
        {
          y.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
          g.DP().dKu.hI(l2);
          y.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          azK();
          axs();
          return;
        }
      }
      paramm = paramm.iterator();
      while (paramm.hasNext())
      {
        localn = (n)paramm.next();
        if (localn != null) {
          ???.a(localn, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a
 * JD-Core Version:    0.7.0.1
 */