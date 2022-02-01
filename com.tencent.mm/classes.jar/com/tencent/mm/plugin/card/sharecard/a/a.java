package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f
{
  public byte[] lock;
  public ap mHandler;
  private Runnable mRunnable;
  public com.tencent.mm.plugin.card.sharecard.model.e oBr;
  private int oBs;
  public int oBt;
  public List<com.tencent.mm.plugin.card.sharecard.model.n> owt;
  private List<WeakReference<d>> owv;
  public List<com.tencent.mm.plugin.card.sharecard.model.n> pendingList;
  
  public a()
  {
    AppMethodBeat.i(112911);
    this.lock = new byte[0];
    this.owv = new ArrayList();
    this.oBs = 0;
    this.oBt = 5;
    this.mHandler = new ap(Looper.getMainLooper());
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112909);
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
        com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
        g.ajB().gAO.a(localh, 0);
        AppMethodBeat.o(112909);
      }
    };
    this.pendingList = am.bUW().bUL();
    this.owt = new ArrayList();
    ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.ajB().gAO.a(1132, this);
    AppMethodBeat.o(112911);
  }
  
  private ArrayList<com.tencent.mm.plugin.card.sharecard.model.n> Q(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112915);
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.pendingList.size() == 0)
        {
          ad.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
          AppMethodBeat.o(112915);
          return localArrayList;
        }
        localLinkedList.addAll(this.pendingList);
        i = 0;
        if (i >= paramLinkedList.size()) {
          break;
        }
        ??? = (String)paramLinkedList.get(i);
        int j = 0;
        if (j < localLinkedList.size())
        {
          if ((??? != null) && (localLinkedList.get(j) != null) && (((String)???).equals(((com.tencent.mm.plugin.card.sharecard.model.n)localLinkedList.get(j)).field_card_id))) {
            localArrayList.add(localLinkedList.get(j));
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112915);
    return localArrayList;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(112918);
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(paramd));
    AppMethodBeat.o(112918);
  }
  
  public final void a(ddj arg1)
  {
    AppMethodBeat.i(112912);
    if (??? == null)
    {
      ad.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
      AppMethodBeat.o(112912);
      return;
    }
    Object localObject1 = am.bUV().YE(???.dHX);
    String str = ???.dHX;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((ShareCardInfo)localObject1).field_updateSeq)
    {
      ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.seq) });
      if ((localObject1 == null) || (((ShareCardInfo)localObject1).field_updateSeq != ???.seq)) {
        break;
      }
      ad.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
      AppMethodBeat.o(112912);
      return;
    }
    localObject1 = com.tencent.mm.plugin.card.sharecard.model.n.c(???);
    synchronized (this.lock)
    {
      if (this.pendingList.contains(localObject1))
      {
        AppMethodBeat.o(112912);
        return;
      }
      if (this.owt.contains(localObject1))
      {
        AppMethodBeat.o(112912);
        return;
      }
      this.pendingList.add(localObject1);
      ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bUW().insert((c)localObject1)) });
      AppMethodBeat.o(112912);
      return;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(112919);
    if (this.owv == null)
    {
      AppMethodBeat.o(112919);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
      if (localWeakReference != null)
      {
        d locald = (d)localWeakReference.get();
        if ((locald != null) && (locald.equals(paramd)))
        {
          this.owv.remove(localWeakReference);
          AppMethodBeat.o(112919);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112919);
  }
  
  public final void bUa()
  {
    AppMethodBeat.i(112913);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.lock)
    {
      if (this.pendingList.size() == 0)
      {
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
        AppMethodBeat.o(112913);
        return;
      }
      localLinkedList1.addAll(this.pendingList);
      if (this.oBr != null)
      {
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
        AppMethodBeat.o(112913);
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
        localLinkedList2.add(((com.tencent.mm.plugin.card.sharecard.model.n)((LinkedList)???).get(i)).field_card_id);
        i += 1;
      }
      ((LinkedList)???).addAll(localLinkedList2.subList(0, 10));
    }
    this.oBr = new com.tencent.mm.plugin.card.sharecard.model.e(localLinkedList2);
    g.ajB().gAO.a(this.oBr, 0);
    AppMethodBeat.o(112913);
  }
  
  public final void bVo()
  {
    AppMethodBeat.i(112916);
    ad.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - this.oBs;
    int i;
    if (this.oBt <= 0)
    {
      i = 5;
      if (k < i) {
        break label86;
      }
      com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
      g.ajB().gAO.a(localh, 0);
    }
    for (;;)
    {
      this.oBs = j;
      AppMethodBeat.o(112916);
      return;
      i = this.oBt;
      break;
      label86:
      ad.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(k)));
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler.postDelayed(this.mRunnable, i * 1000);
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112917);
    if (this.owv == null)
    {
      AppMethodBeat.o(112917);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (d)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d)localObject).bTY();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112917);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(112914);
    ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oBr = null;
    com.tencent.mm.plugin.card.sharecard.model.n localn;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramn = Q(((com.tencent.mm.plugin.card.sharecard.model.e)paramn).ozU);
      synchronized (this.lock)
      {
        if (paramn.size() > 0)
        {
          this.pendingList.removeAll(paramn);
          this.owt.addAll(paramn);
        }
        ??? = am.bUW();
        if (paramn.size() == 0)
        {
          ad.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
          AppMethodBeat.o(112914);
          return;
        }
      }
      paramn = paramn.iterator();
      while (paramn.hasNext())
      {
        localn = (com.tencent.mm.plugin.card.sharecard.model.n)paramn.next();
        if (localn != null)
        {
          localn.field_retryCount += 1;
          ???.update(localn, new String[0]);
        }
      }
      AppMethodBeat.o(112914);
      return;
    }
    paramn = Q(((com.tencent.mm.plugin.card.sharecard.model.e)paramn).ozV);
    ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramn.size()) });
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramn);
        long l1 = System.currentTimeMillis();
        long l2 = g.ajC().gBq.xO(Thread.currentThread().getId());
        ??? = am.bUW();
        if (paramn.size() == 0)
        {
          ad.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
          g.ajC().gBq.sJ(l2);
          ad.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bUa();
          onChange();
          AppMethodBeat.o(112914);
          return;
        }
      }
      paramn = paramn.iterator();
      while (paramn.hasNext())
      {
        localn = (com.tencent.mm.plugin.card.sharecard.model.n)paramn.next();
        if (localn != null) {
          ???.delete(localn, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a
 * JD-Core Version:    0.7.0.1
 */