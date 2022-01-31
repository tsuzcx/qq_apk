package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements f
{
  public byte[] dMQ = new byte[0];
  public List<WeakReference<d>> fKm = new ArrayList();
  public List<ak> ijT = am.aAt().aAq();
  public List<ak> ijU = new ArrayList();
  private s ijV;
  
  public b()
  {
    y.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[] { Integer.valueOf(this.ijT.size()) });
    g.DO().dJT.a(559, this);
  }
  
  public static void oM(int paramInt)
  {
    w localw = new w(paramInt);
    g.DO().dJT.a(localw, 0);
  }
  
  public final void azK()
  {
    if (this.ijT.size() == 0)
    {
      y.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
      return;
    }
    if (this.ijV != null)
    {
      y.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.ijT.size() <= 10) {
      localLinkedList.addAll(this.ijT);
    }
    for (;;)
    {
      this.ijV = new s(localLinkedList);
      g.DO().dJT.a(this.ijV, 0);
      return;
      localLinkedList.addAll(this.ijT.subList(0, 10));
    }
  }
  
  public final void detach()
  {
    this.ijT.clear();
    this.ijU.clear();
    if (this.ijV != null) {
      g.DO().dJT.c(this.ijV);
    }
    g.DO().dJT.b(559, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m arg4)
  {
    int i = 0;
    y.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ijV = null;
    paramString = ((s)???).inu;
    ak localak;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ??? = this.dMQ;
      if (paramString != null) {}
      for (;;)
      {
        try
        {
          if (paramString.size() > 0)
          {
            this.ijT.removeAll(paramString);
            this.ijU.addAll(paramString);
          }
          ??? = am.aAt();
          if ((paramString == null) || (paramString.size() == 0))
          {
            y.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            return;
          }
        }
        finally {}
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localak = (ak)paramString.next();
          if (localak != null)
          {
            localak.field_retryCount += 1;
            ???.c(localak, new String[0]);
          }
        }
      }
    }
    if (paramString == null)
    {
      paramInt1 = 0;
      y.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramString == null) {}
    }
    for (;;)
    {
      synchronized (this.dMQ)
      {
        this.ijT.removeAll(paramString);
        long l1 = System.currentTimeMillis();
        long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
        ??? = am.aAt();
        if ((paramString == null) || (paramString.size() == 0))
        {
          y.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
          g.DP().dKu.hI(l2);
          y.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          azK();
          if (this.fKm == null) {
            break;
          }
          paramInt1 = i;
          if (paramInt1 >= this.fKm.size()) {
            break;
          }
          paramString = (WeakReference)this.fKm.get(paramInt1);
          if (paramString != null)
          {
            paramString = (d)paramString.get();
            if (paramString != null) {
              paramString.azI();
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
          ???.a(localak, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.b
 * JD-Core Version:    0.7.0.1
 */