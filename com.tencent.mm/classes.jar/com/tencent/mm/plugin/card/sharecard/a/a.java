package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.e;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.am.h
{
  private List<WeakReference<d>> eNV;
  public byte[] lock;
  public MMHandler mHandler;
  private Runnable mRunnable;
  public List<n> pendingList;
  public List<n> wre;
  public e wwg;
  private int wwh;
  public int wwi;
  
  public a()
  {
    AppMethodBeat.i(112911);
    this.lock = new byte[0];
    this.eNV = new ArrayList();
    this.wwh = 0;
    this.wwi = 5;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112909);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
        com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
        com.tencent.mm.kernel.h.baD().mCm.a(localh, 0);
        AppMethodBeat.o(112909);
      }
    };
    this.pendingList = am.dkS().dkH();
    this.wre = new ArrayList();
    Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    com.tencent.mm.kernel.h.baD().mCm.a(1132, this);
    AppMethodBeat.o(112911);
  }
  
  private ArrayList<n> S(LinkedList<String> paramLinkedList)
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
          Log.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
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
          if ((??? != null) && (localLinkedList.get(j) != null) && (((String)???).equals(((n)localLinkedList.get(j)).field_card_id))) {
            localArrayList.add((n)localLinkedList.get(j));
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
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(paramd));
    AppMethodBeat.o(112918);
  }
  
  public final void a(fbi arg1)
  {
    AppMethodBeat.i(112912);
    if (??? == null)
    {
      Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
      AppMethodBeat.o(112912);
      return;
    }
    Object localObject1 = am.dkR().akS(???.iaI);
    String str = ???.iaI;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((ShareCardInfo)localObject1).field_updateSeq)
    {
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.seq) });
      if ((localObject1 == null) || (((ShareCardInfo)localObject1).field_updateSeq != ???.seq)) {
        break;
      }
      Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
      AppMethodBeat.o(112912);
      return;
    }
    localObject1 = n.c(???);
    synchronized (this.lock)
    {
      if (this.pendingList.contains(localObject1))
      {
        AppMethodBeat.o(112912);
        return;
      }
      if (this.wre.contains(localObject1))
      {
        AppMethodBeat.o(112912);
        return;
      }
      this.pendingList.add(localObject1);
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[] { Boolean.valueOf(am.dkS().insert((IAutoDBItem)localObject1)) });
      AppMethodBeat.o(112912);
      return;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(112919);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112919);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null)
      {
        d locald = (d)localWeakReference.get();
        if ((locald != null) && (locald.equals(paramd)))
        {
          this.eNV.remove(localWeakReference);
          AppMethodBeat.o(112919);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112919);
  }
  
  public final void djW()
  {
    AppMethodBeat.i(112913);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.lock)
    {
      if (this.pendingList.size() == 0)
      {
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
        AppMethodBeat.o(112913);
        return;
      }
      localLinkedList1.addAll(this.pendingList);
      if (this.wwg != null)
      {
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
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
        localLinkedList2.add(((n)((LinkedList)???).get(i)).field_card_id);
        i += 1;
      }
      ((LinkedList)???).addAll(localLinkedList2.subList(0, 10));
    }
    this.wwg = new e(localLinkedList2);
    com.tencent.mm.kernel.h.baD().mCm.a(this.wwg, 0);
    AppMethodBeat.o(112913);
  }
  
  public final void dln()
  {
    AppMethodBeat.i(112916);
    Log.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - this.wwh;
    int i;
    if (this.wwi <= 0)
    {
      i = 5;
      if (k < i) {
        break label86;
      }
      com.tencent.mm.plugin.card.sharecard.model.h localh = new com.tencent.mm.plugin.card.sharecard.model.h();
      com.tencent.mm.kernel.h.baD().mCm.a(localh, 0);
    }
    for (;;)
    {
      this.wwh = j;
      AppMethodBeat.o(112916);
      return;
      i = this.wwi;
      break;
      label86:
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(k)));
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler.postDelayed(this.mRunnable, i * 1000);
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112917);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112917);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (d)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d)localObject).djU();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112917);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, p paramp)
  {
    AppMethodBeat.i(112914);
    Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wwg = null;
    n localn;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramp = S(((e)paramp).wuC);
      ??? = this.lock;
      if (paramp != null) {}
      try
      {
        if (paramp.size() > 0)
        {
          this.pendingList.removeAll(paramp);
          this.wre.addAll(paramp);
        }
        ??? = am.dkS();
        if ((paramp == null) || (paramp.size() == 0))
        {
          Log.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
          AppMethodBeat.o(112914);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(112914);
      }
      paramp = paramp.iterator();
      while (paramp.hasNext())
      {
        localn = (n)paramp.next();
        if (localn != null)
        {
          localn.field_retryCount += 1;
          ???.update(localn, new String[0]);
        }
      }
      AppMethodBeat.o(112914);
      return;
    }
    paramp = S(((e)paramp).wuD);
    if (paramp == null)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramp == null) {}
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramp);
        long l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
        ??? = am.dkS();
        if ((paramp == null) || (paramp.size() == 0))
        {
          Log.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
          Log.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          djW();
          onChange();
          AppMethodBeat.o(112914);
          return;
          paramInt1 = paramp.size();
        }
      }
      localn = (n)paramp.next();
      if (localn != null) {
        ???.delete(localn, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a
 * JD-Core Version:    0.7.0.1
 */