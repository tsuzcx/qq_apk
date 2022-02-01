package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements f
{
  public byte[] lock;
  public List<ak> owt;
  private s owu;
  public List<WeakReference<d>> owv;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.owv = new ArrayList();
    this.pendingList = am.bUO().bUL();
    this.owt = new ArrayList();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.ajB().gAO.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void Ao(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    g.ajB().gAO.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public static void bUb()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)g.ajC().ajl().get(al.a.IrB, Integer.valueOf(1))).intValue();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    com.tencent.mm.plugin.card.model.ad localad = new com.tencent.mm.plugin.card.model.ad(am.bUT().fFf, am.bUT().fFg, i);
    g.ajB().gAO.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public final void a(tu arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.bUN().Yo(???.FHU);
    String str = ???.FHU;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.FSm) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.FSm)) {
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
      if (this.owt.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bUO().insert((com.tencent.mm.sdk.e.c)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void bUa()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.owu != null)
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
      this.owu = new s(localLinkedList);
      g.ajB().gAO.a(this.owu, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.owt.clear();
    if (this.owu != null) {
      g.ajB().gAO.a(this.owu);
    }
    g.ajB().gAO.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.owu = null;
    paramString = ((s)???).ozV;
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
          this.owt.addAll(paramString);
        }
        ??? = am.bUO();
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
        long l2 = g.ajC().gBq.xO(Thread.currentThread().getId());
        ??? = am.bUO();
        if ((paramString == null) || (paramString.size() == 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          g.ajC().gBq.sJ(l2);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bUa();
          if (this.owv == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.owv.size()) {
            break;
          }
          paramString = (WeakReference)this.owv.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.bTY();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.b
 * JD-Core Version:    0.7.0.1
 */