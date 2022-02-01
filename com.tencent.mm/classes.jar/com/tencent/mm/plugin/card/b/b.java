package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  public List<ak> oCV;
  private s oCW;
  public List<WeakReference<d>> oCX;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.oCX = new ArrayList();
    this.pendingList = am.bWd().bWa();
    this.oCV = new ArrayList();
    ae.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.ajQ().gDv.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void AA(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    g.ajQ().gDv.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public static void bVq()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)g.ajR().ajA().get(am.a.ILX, Integer.valueOf(1))).intValue();
    ae.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    ad localad = new ad(am.bWi().fHj, am.bWi().fHk, i);
    g.ajQ().gDv.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public final void a(tw arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      ae.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.bWc().Zf(???.Gaq);
    String str = ???.Gaq;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      ae.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.GkL) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.GkL)) {
        break;
      }
      ae.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
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
      if (this.oCV.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      ae.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bWd().insert((com.tencent.mm.sdk.e.c)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void bVp()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      ae.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.oCW != null)
    {
      ae.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      AppMethodBeat.o(112577);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.pendingList.size() <= 10) {
      localLinkedList.addAll(this.pendingList);
    }
    for (;;)
    {
      this.oCW = new s(localLinkedList);
      g.ajQ().gDv.a(this.oCW, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.oCV.clear();
    if (this.oCW != null) {
      g.ajQ().gDv.a(this.oCW);
    }
    g.ajQ().gDv.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    ae.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oCW = null;
    paramString = ((s)???).oGx;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.lock;
      if (paramString != null) {}
      try
      {
        if (paramString.size() > 0)
        {
          this.pendingList.removeAll(paramString);
          this.oCV.addAll(paramString);
        }
        ??? = am.bWd();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ae.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
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
      ae.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.pendingList.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = g.ajR().gDX.yi(Thread.currentThread().getId());
        ??? = am.bWd();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ae.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          g.ajR().gDX.sW(l2);
          ae.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bVp();
          if (this.oCX == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.oCX.size()) {
            break;
          }
          paramString = (WeakReference)this.oCX.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.bVn();
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