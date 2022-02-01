package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.am.h
{
  public List<WeakReference<d>> eNV;
  public byte[] lock;
  public List<ak> pendingList;
  public List<ak> wre;
  private com.tencent.mm.plugin.card.model.s wrf;
  
  public a()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.eNV = new ArrayList();
    this.pendingList = am.dkK().dkH();
    this.wre = new ArrayList();
    Log.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    com.tencent.mm.kernel.h.baD().mCm.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void Ih(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    com.tencent.mm.kernel.h.baD().mCm.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public static void djX()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJt, Integer.valueOf(1))).intValue();
    Log.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    ad localad = new ad(am.dkP().lsz, am.dkP().lsA, i);
    com.tencent.mm.kernel.h.baD().mCm.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public final void a(wu arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      Log.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.dkJ().akC(???.YSF);
    String str = ???.YSF;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.Zez) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.Zez)) {
        break;
      }
      Log.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
      AppMethodBeat.o(112576);
      return;
    }
    localObject1 = ak.b(???);
    synchronized (this.lock)
    {
      if (this.pendingList.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      if (this.wre.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.dkK().insert((IAutoDBItem)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.wre.clear();
    if (this.wrf != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(this.wrf);
    }
    com.tencent.mm.kernel.h.baD().mCm.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void djW()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      Log.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.wrf != null)
    {
      Log.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      AppMethodBeat.o(112577);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.pendingList.size() <= 10) {
      localLinkedList.addAll(this.pendingList);
    }
    for (;;)
    {
      this.wrf = new com.tencent.mm.plugin.card.model.s(localLinkedList);
      com.tencent.mm.kernel.h.baD().mCm.a(this.wrf, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wrf = null;
    paramString = ((com.tencent.mm.plugin.card.model.s)???).wuD;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.lock;
      if (paramString != null) {}
      try
      {
        if (paramString.size() > 0)
        {
          this.pendingList.removeAll(paramString);
          this.wre.addAll(paramString);
        }
        ??? = am.dkK();
        if ((paramString == null) || (paramString.size() == 0))
        {
          Log.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
          AppMethodBeat.o(112578);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(112578);
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localak = (ak)paramString.next();
        if (localak != null)
        {
          localak.field_retryCount += 1;
          ???.update(localak, new String[0]);
        }
      }
      AppMethodBeat.o(112578);
      return;
    }
    if (paramString == null)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
        ??? = am.dkK();
        if ((paramString == null) || (paramString.size() == 0))
        {
          Log.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
          Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          djW();
          if (this.eNV == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.eNV.size()) {
            break;
          }
          paramString = (WeakReference)this.eNV.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.djU();
            }
          }
          paramInt1 += 1;
          continue;
          paramInt1 = paramString.size();
        }
      }
      localak = (ak)paramString.next();
      if (localak != null) {
        ???.delete(localak, new String[0]);
      }
    }
    AppMethodBeat.o(112578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.a
 * JD-Core Version:    0.7.0.1
 */