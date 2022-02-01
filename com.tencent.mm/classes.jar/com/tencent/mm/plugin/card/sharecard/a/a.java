package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
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
  public aq mHandler;
  private Runnable mRunnable;
  public List<com.tencent.mm.plugin.card.sharecard.model.n> oCV;
  private List<WeakReference<d>> oCX;
  public com.tencent.mm.plugin.card.sharecard.model.e oHT;
  private int oHU;
  public int oHV;
  public List<com.tencent.mm.plugin.card.sharecard.model.n> pendingList;
  
  public a()
  {
    AppMethodBeat.i(112911);
    this.lock = new byte[0];
    this.oCX = new ArrayList();
    this.oHU = 0;
    this.oHV = 5;
    this.mHandler = new aq(Looper.getMainLooper());
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112909);
        ae.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
        com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
        g.ajQ().gDv.a(localh, 0);
        AppMethodBeat.o(112909);
      }
    };
    this.pendingList = am.bWl().bWa();
    this.oCV = new ArrayList();
    ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.ajQ().gDv.a(1132, this);
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
          ae.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
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
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(paramd));
    AppMethodBeat.o(112918);
  }
  
  public final void a(ded arg1)
  {
    AppMethodBeat.i(112912);
    if (??? == null)
    {
      ae.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
      AppMethodBeat.o(112912);
      return;
    }
    Object localObject1 = am.bWk().Zv(???.dJb);
    String str = ???.dJb;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((ShareCardInfo)localObject1).field_updateSeq)
    {
      ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.seq) });
      if ((localObject1 == null) || (((ShareCardInfo)localObject1).field_updateSeq != ???.seq)) {
        break;
      }
      ae.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
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
      if (this.oCV.contains(localObject1))
      {
        AppMethodBeat.o(112912);
        return;
      }
      this.pendingList.add(localObject1);
      ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bWl().insert((c)localObject1)) });
      AppMethodBeat.o(112912);
      return;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(112919);
    if (this.oCX == null)
    {
      AppMethodBeat.o(112919);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null)
      {
        d locald = (d)localWeakReference.get();
        if ((locald != null) && (locald.equals(paramd)))
        {
          this.oCX.remove(localWeakReference);
          AppMethodBeat.o(112919);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112919);
  }
  
  public final void bVp()
  {
    AppMethodBeat.i(112913);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.lock)
    {
      if (this.pendingList.size() == 0)
      {
        ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
        AppMethodBeat.o(112913);
        return;
      }
      localLinkedList1.addAll(this.pendingList);
      if (this.oHT != null)
      {
        ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
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
    this.oHT = new com.tencent.mm.plugin.card.sharecard.model.e(localLinkedList2);
    g.ajQ().gDv.a(this.oHT, 0);
    AppMethodBeat.o(112913);
  }
  
  public final void bWD()
  {
    AppMethodBeat.i(112916);
    ae.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - this.oHU;
    int i;
    if (this.oHV <= 0)
    {
      i = 5;
      if (k < i) {
        break label86;
      }
      com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
      g.ajQ().gDv.a(localh, 0);
    }
    for (;;)
    {
      this.oHU = j;
      AppMethodBeat.o(112916);
      return;
      i = this.oHV;
      break;
      label86:
      ae.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(k)));
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler.postDelayed(this.mRunnable, i * 1000);
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112917);
    if (this.oCX == null)
    {
      AppMethodBeat.o(112917);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (d)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d)localObject).bVn();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112917);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(112914);
    ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oHT = null;
    com.tencent.mm.plugin.card.sharecard.model.n localn;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramn = Q(((com.tencent.mm.plugin.card.sharecard.model.e)paramn).oGw);
      synchronized (this.lock)
      {
        if (paramn.size() > 0)
        {
          this.pendingList.removeAll(paramn);
          this.oCV.addAll(paramn);
        }
        ??? = am.bWl();
        if (paramn.size() == 0)
        {
          ae.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
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
    paramn = Q(((com.tencent.mm.plugin.card.sharecard.model.e)paramn).oGx);
    ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramn.size()) });
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramn);
        long l1 = System.currentTimeMillis();
        long l2 = g.ajR().gDX.yi(Thread.currentThread().getId());
        ??? = am.bWl();
        if (paramn.size() == 0)
        {
          ae.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
          g.ajR().gDX.sW(l2);
          ae.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bVp();
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