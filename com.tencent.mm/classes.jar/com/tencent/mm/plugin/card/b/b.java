package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.ak.g
{
  public byte[] lock;
  public List<ak> nSY;
  private s nSZ;
  public List<WeakReference<d>> nTa;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.nTa = new ArrayList();
    this.pendingList = am.bQj().bQg();
    this.nSY = new ArrayList();
    ac.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    com.tencent.mm.kernel.g.agQ().ghe.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void bPw()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFj, Integer.valueOf(1))).intValue();
    ac.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    ad localad = new ad(am.bQo().fmX, am.bQo().fmY, i);
    com.tencent.mm.kernel.g.agQ().ghe.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public static void zF(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public final void a(sa arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      ac.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.bQi().UF(???.Eld);
    String str = ???.Eld;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      ac.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.Ele) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.Ele)) {
        break;
      }
      ac.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
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
      if (this.nSY.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      ac.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bQj().insert((com.tencent.mm.sdk.e.c)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void bPv()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      ac.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.nSZ != null)
    {
      ac.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      AppMethodBeat.o(112577);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.pendingList.size() <= 10) {
      localLinkedList.addAll(this.pendingList);
    }
    for (;;)
    {
      this.nSZ = new s(localLinkedList);
      com.tencent.mm.kernel.g.agQ().ghe.a(this.nSZ, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.nSY.clear();
    if (this.nSZ != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.nSZ);
    }
    com.tencent.mm.kernel.g.agQ().ghe.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    ac.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.nSZ = null;
    paramString = ((s)???).nWB;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.lock;
      if (paramString != null) {}
      try
      {
        if (paramString.size() > 0)
        {
          this.pendingList.removeAll(paramString);
          this.nSY.addAll(paramString);
        }
        ??? = am.bQj();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ac.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
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
      ac.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
        ??? = am.bQj();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ac.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          com.tencent.mm.kernel.g.agR().ghG.qL(l2);
          ac.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bPv();
          if (this.nTa == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.nTa.size()) {
            break;
          }
          paramString = (WeakReference)this.nTa.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.bPt();
            }
          }
          paramInt1 += 1;
          continue;
          paramInt1 = paramString.size();
        }
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localak = (ak)paramString.next();
        if (localak != null) {
          ???.delete(localak, new String[0]);
        }
      }
    }
    AppMethodBeat.o(112578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.b
 * JD-Core Version:    0.7.0.1
 */