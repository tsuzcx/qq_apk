package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements i
{
  public byte[] lock;
  public List<ak> pQE;
  private s pQF;
  public List<WeakReference<d>> pQG;
  public List<ak> pendingList;
  
  public b()
  {
    AppMethodBeat.i(112574);
    this.lock = new byte[0];
    this.pQG = new ArrayList();
    this.pendingList = am.ctR().ctO();
    this.pQE = new ArrayList();
    Log.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.pendingList.size()) });
    g.aAg().hqi.a(1074, this);
    AppMethodBeat.o(112574);
  }
  
  public static void Ef(int paramInt)
  {
    AppMethodBeat.i(112579);
    w localw = new w(paramInt);
    g.aAg().hqi.a(localw, 0);
    AppMethodBeat.o(112579);
  }
  
  public static void cte()
  {
    AppMethodBeat.i(112580);
    int i = ((Integer)g.aAh().azQ().get(ar.a.NTZ, Integer.valueOf(1))).intValue();
    Log.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(i)));
    ad localad = new ad(am.ctW().gmu, am.ctW().gmv, i);
    g.aAg().hqi.a(localad, 0);
    AppMethodBeat.o(112580);
  }
  
  public final void a(vb arg1)
  {
    AppMethodBeat.i(112576);
    if (??? == null)
    {
      Log.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
      AppMethodBeat.o(112576);
      return;
    }
    Object localObject1 = am.ctQ().ajk(???.KUk);
    String str = ???.KUk;
    if (localObject1 == null) {}
    for (long l = 0L;; l = ((CardInfo)localObject1).field_updateSeq)
    {
      Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(???.Lfn) });
      if ((localObject1 == null) || (((CardInfo)localObject1).field_updateSeq != ???.Lfn)) {
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
      if (this.pQE.contains(localObject1))
      {
        AppMethodBeat.o(112576);
        return;
      }
      this.pendingList.add(localObject1);
      Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.ctR().insert((IAutoDBItem)localObject1)) });
      AppMethodBeat.o(112576);
      return;
    }
  }
  
  public final void ctd()
  {
    AppMethodBeat.i(112577);
    if (this.pendingList.size() == 0)
    {
      Log.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      AppMethodBeat.o(112577);
      return;
    }
    if (this.pQF != null)
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
      this.pQF = new s(localLinkedList);
      g.aAg().hqi.a(this.pQF, 0);
      AppMethodBeat.o(112577);
      return;
      localLinkedList.addAll(this.pendingList.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(112575);
    this.pendingList.clear();
    this.pQE.clear();
    if (this.pQF != null) {
      g.aAg().hqi.a(this.pQF);
    }
    g.aAg().hqi.b(1074, this);
    AppMethodBeat.o(112575);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q arg4)
  {
    int i = 0;
    AppMethodBeat.i(112578);
    Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pQF = null;
    paramString = ((s)???).pUd;
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
          this.pQE.addAll(paramString);
        }
        ??? = am.ctR();
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
        long l2 = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        ??? = am.ctR();
        if ((paramString == null) || (paramString.size() == 0))
        {
          Log.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          g.aAh().hqK.endTransaction(l2);
          Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          ctd();
          if (this.pQG == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.pQG.size()) {
            break;
          }
          paramString = (WeakReference)this.pQG.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.ctb();
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