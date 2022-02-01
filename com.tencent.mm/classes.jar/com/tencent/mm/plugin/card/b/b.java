package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.al.g
{
  public byte[] lock;
  public List<ak> npY;
  private s npZ;
  public List<WeakReference<d>> nqa;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.nqa = new ArrayList();
    this.pendingList = am.bIW().bIT();
    this.npY = new ArrayList();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    com.tencent.mm.kernel.g.afA().gcy.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void bIj()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhu, Integer.valueOf(1))).intValue();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    com.tencent.mm.plugin.card.model.ad localad = new com.tencent.mm.plugin.card.model.ad(am.bJb().fjD, am.bJb().fjE, i);
    com.tencent.mm.kernel.g.afA().gcy.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public static void yP(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public final void a(rq arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.bIV().Qt(???.CSs);
    String str = ???.CSs;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.CSt) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.CSt)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
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
      if (this.npY.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bIW().insert((com.tencent.mm.sdk.e.c)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void bIi()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.npZ != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      AppMethodBeat.o(112577);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.pendingList.size() <= 10) {
      localLinkedList.addAll(this.pendingList);
    }
    for (;;)
    {
      this.npZ = new s(localLinkedList);
      com.tencent.mm.kernel.g.afA().gcy.a(this.npZ, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.npY.clear();
    if (this.npZ != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(this.npZ);
    }
    com.tencent.mm.kernel.g.afA().gcy.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.npZ = null;
    paramString = ((s)???).ntB;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.lock;
      if (paramString != null) {}
      try
      {
        if (paramString.size() > 0)
        {
          this.pendingList.removeAll(paramString);
          this.npY.addAll(paramString);
        }
        ??? = am.bIW();
        if ((paramString == null) || (paramString.size() == 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
        ??? = am.bIW();
        if ((paramString == null) || (paramString.size() == 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          com.tencent.mm.kernel.g.afB().gda.mX(l2);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bIi();
          if (this.nqa == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.nqa.size()) {
            break;
          }
          paramString = (WeakReference)this.nqa.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.bIg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.b
 * JD-Core Version:    0.7.0.1
 */