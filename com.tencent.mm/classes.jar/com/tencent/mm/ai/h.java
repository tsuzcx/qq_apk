package com.tencent.mm.ai;

import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.cln;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
  implements f
{
  Object bjn = new Object();
  Set<String> egk = new HashSet();
  public LinkedList<h.a> egl = new LinkedList();
  
  private void d(LinkedList<cln> paramLinkedList)
  {
    for (;;)
    {
      int i;
      synchronized (this.bjn)
      {
        ArrayList localArrayList = new ArrayList(this.egl);
        i = 0;
        if (i < localArrayList.size())
        {
          h.a locala = (h.a)localArrayList.get(i);
          if (locala != null) {
            locala.e(paramLinkedList);
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
    }
  }
  
  public final void a(h.a parama)
  {
    synchronized (this.bjn)
    {
      if (!this.egl.contains(parama))
      {
        Iterator localIterator = this.egl.iterator();
        while (localIterator.hasNext())
        {
          h.a locala = (h.a)localIterator.next();
          if ((parama != null) && (locala != null) && (bk.pm(parama.Mq()).equals(bk.pm(locala.Mq()))))
          {
            y.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { parama.Mq() });
            return;
          }
        }
        this.egl.add(parama);
      }
      return;
    }
  }
  
  public final void al(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      return;
    }
    paramString2 = new u(paramString1, paramString2);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString2, 0);
    y.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.egl.size()) });
  }
  
  public final void am(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      return;
    }
    if (this.egk.contains(paramString2))
    {
      y.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      return;
    }
    this.egk.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    localObject = new w(paramString1, (LinkedList)localObject);
    ((w)localObject).tag = paramString2;
    com.tencent.mm.kernel.g.DO().dJT.a((m)localObject, 0);
    y.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.egl.size()) });
  }
  
  public final void b(h.a parama)
  {
    synchronized (this.bjn)
    {
      if (this.egl.contains(parama)) {
        this.egl.remove(parama);
      }
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      y.e("MicroMsg.BizKFService", "scene == null");
      d(null);
    }
    do
    {
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      y.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      d(null);
    } while (paramm.getType() != 675);
    this.egk.remove(((w)paramm).tag);
    return;
    y.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    com.tencent.mm.ag.i locali = o.Kh();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    cln localcln;
    com.tencent.mm.ag.h localh;
    if (paramm.getType() == 672)
    {
      if (((v)paramm).Mu() == null)
      {
        y.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        d(null);
        return;
      }
      paramString = ((v)paramm).Mu().tos;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        y.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localcln = (cln)localIterator.next();
        localLinkedList.add(new g(localcln.tYK, ((v)paramm).egK, localcln.kSF, localcln.tqh, 1, l));
        if (locali != null)
        {
          localh = new com.tencent.mm.ag.h();
          localh.username = localcln.tYK;
          localh.ebS = localcln.kSF;
          localh.bK(false);
          localh.cCq = 3;
          locali.a(localh);
          o.Kj().kc(localcln.tYK);
        }
      }
    }
    for (;;)
    {
      y.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(z.Mx().f(localLinkedList)) });
      d(paramString);
      return;
      if (paramm.getType() == 675)
      {
        this.egk.remove(((w)paramm).tag);
        if (((w)paramm).Mv() == null)
        {
          y.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
          d(null);
          return;
        }
        paramString = ((w)paramm).Mv().tos;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          y.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localcln = (cln)localIterator.next();
          y.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", new Object[] { localcln.tYK, ((w)paramm).tag });
          localLinkedList.add(new g(localcln.tYK, ((w)paramm).egK, localcln.kSF, localcln.tqh, ((w)paramm).egL, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.ag.h();
            localh.username = localcln.tYK;
            localh.ebS = localcln.kSF;
            localh.bK(false);
            localh.cCq = 3;
            locali.a(localh);
            o.Kj().kc(localcln.tYK);
          }
        }
      }
      else if (paramm.getType() == 674)
      {
        if (((u)paramm).Mt() == null)
        {
          y.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
          d(null);
          return;
        }
        paramString = ((u)paramm).Mt().tos;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          y.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localcln = (cln)localIterator.next();
          localLinkedList.add(new g(localcln.tYK, ((u)paramm).egK, localcln.kSF, localcln.tqh, 2, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.ag.h();
            localh.username = localcln.tYK;
            localh.ebS = localcln.kSF;
            localh.bK(false);
            localh.cCq = 3;
            locali.a(localh);
            o.Kj().kc(localcln.tYK);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.h
 * JD-Core Version:    0.7.0.1
 */