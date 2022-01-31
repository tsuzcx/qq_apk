package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f
{
  public byte[] eKs;
  public List<n> kkT;
  private List<WeakReference<d>> kkV;
  public com.tencent.mm.plugin.card.sharecard.model.e kpD;
  private int kpE;
  public int kpF;
  public ak mHandler;
  private Runnable mRunnable;
  public List<n> pendingList;
  
  public a()
  {
    AppMethodBeat.i(87972);
    this.eKs = new byte[0];
    this.kkV = new ArrayList();
    this.kpE = 0;
    this.kpF = 5;
    this.mHandler = new ak(Looper.getMainLooper());
    this.mRunnable = new a.1(this);
    this.pendingList = am.bcm().bcb();
    this.kkT = new ArrayList();
    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.RK().eHt.a(903, this);
    AppMethodBeat.o(87972);
  }
  
  private ArrayList<n> K(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(87976);
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      int i;
      synchronized (this.eKs)
      {
        if (this.pendingList.size() == 0)
        {
          ab.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
          AppMethodBeat.o(87976);
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
          if ((??? != null) && (localLinkedList.get(j) != null) && (((String)???).equals(((n)localLinkedList.get(j)).field_card_id))) {
            localArrayList.add(localLinkedList.get(j));
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87976);
    return localArrayList;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(87979);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(paramd));
    AppMethodBeat.o(87979);
  }
  
  public final void a(cbv arg1)
  {
    AppMethodBeat.i(87973);
    if (??? == null)
    {
      ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
      AppMethodBeat.o(87973);
      return;
    }
    Object localObject1 = am.bcl().HZ(???.cHn);
    String str = ???.cHn;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((ShareCardInfo)localObject1).field_updateSeq)
    {
      ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.xyE) });
      if ((localObject1 == null) || (((ShareCardInfo)localObject1).field_updateSeq != ???.xyE)) {
        break;
      }
      ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
      AppMethodBeat.o(87973);
      return;
    }
    localObject1 = n.c(???);
    synchronized (this.eKs)
    {
      if (this.pendingList.contains(localObject1))
      {
        AppMethodBeat.o(87973);
        return;
      }
      if (this.kkT.contains(localObject1))
      {
        AppMethodBeat.o(87973);
        return;
      }
      this.pendingList.add(localObject1);
      ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bcm().insert((c)localObject1)) });
      AppMethodBeat.o(87973);
      return;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(87980);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87980);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        d locald = (d)localWeakReference.get();
        if ((locald != null) && (locald.equals(paramd)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(87980);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87980);
  }
  
  public final void bbq()
  {
    AppMethodBeat.i(87974);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.eKs)
    {
      if (this.pendingList.size() == 0)
      {
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
        AppMethodBeat.o(87974);
        return;
      }
      localLinkedList1.addAll(this.pendingList);
      if (this.kpD != null)
      {
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
        AppMethodBeat.o(87974);
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
    this.kpD = new com.tencent.mm.plugin.card.sharecard.model.e(localLinkedList2);
    g.RK().eHt.a(this.kpD, 0);
    AppMethodBeat.o(87974);
  }
  
  public final void bcy()
  {
    AppMethodBeat.i(87977);
    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - this.kpE;
    int i;
    if (this.kpF <= 0)
    {
      i = 5;
      if (k < i) {
        break label86;
      }
      com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
      g.RK().eHt.a(localh, 0);
    }
    for (;;)
    {
      this.kpE = j;
      AppMethodBeat.o(87977);
      return;
      i = this.kpF;
      break;
      label86:
      ab.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(k)));
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler.postDelayed(this.mRunnable, i * 1000);
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(87978);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87978);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (d)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d)localObject).bbo();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87978);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    AppMethodBeat.i(87975);
    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.kpD = null;
    n localn;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramm = K(((com.tencent.mm.plugin.card.sharecard.model.e)paramm).kon);
      synchronized (this.eKs)
      {
        if (paramm.size() > 0)
        {
          this.pendingList.removeAll(paramm);
          this.kkT.addAll(paramm);
        }
        ??? = am.bcm();
        if (paramm.size() == 0)
        {
          ab.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
          AppMethodBeat.o(87975);
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
          ???.update(localn, new String[0]);
        }
      }
      AppMethodBeat.o(87975);
      return;
    }
    paramm = K(((com.tencent.mm.plugin.card.sharecard.model.e)paramm).koo);
    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramm.size()) });
    for (;;)
    {
      synchronized (this.eKs)
      {
        this.pendingList.removeAll(paramm);
        long l1 = System.currentTimeMillis();
        long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
        ??? = am.bcm();
        if (paramm.size() == 0)
        {
          ab.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
          g.RL().eHS.nY(l2);
          ab.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bbq();
          onChange();
          AppMethodBeat.o(87975);
          return;
        }
      }
      paramm = paramm.iterator();
      while (paramm.hasNext())
      {
        localn = (n)paramm.next();
        if (localn != null) {
          ???.delete(localn, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a
 * JD-Core Version:    0.7.0.1
 */