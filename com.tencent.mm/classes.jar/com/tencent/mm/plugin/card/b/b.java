package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h;
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
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements f
{
  public byte[] eKs;
  public List<ak> kkT;
  private s kkU;
  public List<WeakReference<d>> kkV;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(87630);
    this.eKs = new byte[0];
    this.kkV = new ArrayList();
    this.pendingList = am.bce().bcb();
    this.kkT = new ArrayList();
    ab.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.RK().eHt.a(559, this);
    AppMethodBeat.o(87630);
  }
  
  public static void bbr()
  {
    AppMethodBeat.i(87636);
    int i = ((Integer)g.RL().Ru().get(ac.a.yyZ, Integer.valueOf(1))).intValue();
    ab.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    ad localad = new ad(am.bcj().dZu, am.bcj().dZv, i);
    g.RK().eHt.a(localad, 0);
    AppMethodBeat.o(87636);
  }
  
  public static void sW(int paramInt)
  {
    AppMethodBeat.i(87635);
    w localw = new w(paramInt);
    g.RK().eHt.a(localw, 0);
    AppMethodBeat.o(87635);
  }
  
  public final void a(pi arg1)
  {
    AppMethodBeat.i(87632);
    if (??? == null)
    {
      ab.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(87632);
      return;
    }
    Object localObject1 = am.bcd().HJ(???.wGN);
    String str = ???.wGN;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      ab.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.wGO) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.wGO)) {
        break;
      }
      ab.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
      AppMethodBeat.o(87632);
      return;
    }
    localObject1 = ak.b(???);
    synchronized (this.eKs)
    {
      if (this.pendingList.contains(localObject1))
      {
        AppMethodBeat.o(87632);
        return;
      }
      if (this.kkT.contains(localObject1))
      {
        AppMethodBeat.o(87632);
        return;
      }
      this.pendingList.add(localObject1);
      ab.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.bce().insert((com.tencent.mm.sdk.e.c)localObject1)) });
      AppMethodBeat.o(87632);
      return;
    }
  }
  
  public final void bbq()
  {
    AppMethodBeat.i(87633);
    if (this.pendingList.size() == 0)
    {
      ab.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(87633);
      return;
    }
    if (this.kkU != null)
    {
      ab.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      AppMethodBeat.o(87633);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.pendingList.size() <= 10) {
      localLinkedList.addAll(this.pendingList);
    }
    for (;;)
    {
      this.kkU = new s(localLinkedList);
      g.RK().eHt.a(this.kkU, 0);
      AppMethodBeat.o(87633);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(87631);
    this.pendingList.clear();
    this.kkT.clear();
    if (this.kkU != null) {
      g.RK().eHt.a(this.kkU);
    }
    g.RK().eHt.b(559, this);
    AppMethodBeat.o(87631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m arg4)
  {
    int i = 0;
    AppMethodBeat.i(87634);
    ab.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.kkU = null;
    paramString = ((s)???).koo;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.eKs;
      if (paramString != null) {}
      try
      {
        if (paramString.size() > 0)
        {
          this.pendingList.removeAll(paramString);
          this.kkT.addAll(paramString);
        }
        ??? = am.bce();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ab.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
          AppMethodBeat.o(87634);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(87634);
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
      AppMethodBeat.o(87634);
      return;
    }
    if (paramString == null)
    {
      paramInt1 = 0;
      ab.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.eKs)
      {
        this.pendingList.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
        ??? = am.bce();
        if ((paramString == null) || (paramString.size() == 0))
        {
          ab.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          g.RL().eHS.nY(l2);
          ab.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          bbq();
          if (this.kkV == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.kkV.size()) {
            break;
          }
          paramString = (WeakReference)this.kkV.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.bbo();
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
    AppMethodBeat.o(87634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.b
 * JD-Core Version:    0.7.0.1
 */