package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
  implements f
{
  Object ceY;
  Set<String> fwm;
  public LinkedList<h.a> fwn;
  
  public h()
  {
    AppMethodBeat.i(11385);
    this.ceY = new Object();
    this.fwm = new HashSet();
    this.fwn = new LinkedList();
    AppMethodBeat.o(11385);
  }
  
  private void d(LinkedList<czd> paramLinkedList)
  {
    AppMethodBeat.i(11391);
    for (;;)
    {
      int i;
      synchronized (this.ceY)
      {
        ArrayList localArrayList = new ArrayList(this.fwn);
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
          AppMethodBeat.o(11391);
          return;
        }
      }
      i += 1;
    }
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(11386);
    synchronized (this.ceY)
    {
      if (!this.fwn.contains(parama))
      {
        Iterator localIterator = this.fwn.iterator();
        while (localIterator.hasNext())
        {
          h.a locala = (h.a)localIterator.next();
          if ((locala != null) && (bo.nullAsNil(parama.aeZ()).equals(bo.nullAsNil(locala.aeZ()))))
          {
            ab.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { parama.aeZ() });
            AppMethodBeat.o(11386);
            return;
          }
        }
        this.fwn.add(parama);
      }
      AppMethodBeat.o(11386);
      return;
    }
  }
  
  public final void aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11388);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(11388);
      return;
    }
    paramString2 = new u(paramString1, paramString2);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString2, 0);
    ab.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.fwn.size()) });
    AppMethodBeat.o(11388);
  }
  
  public final void aC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11389);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(11389);
      return;
    }
    if (this.fwm.contains(paramString2))
    {
      ab.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(11389);
      return;
    }
    this.fwm.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    localObject = new w(paramString1, (LinkedList)localObject);
    ((w)localObject).tag = paramString2;
    com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
    ab.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.fwn.size()) });
    AppMethodBeat.o(11389);
  }
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(11387);
    synchronized (this.ceY)
    {
      if (this.fwn.contains(parama)) {
        this.fwn.remove(parama);
      }
      AppMethodBeat.o(11387);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(11390);
    ab.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(11390);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      d(null);
      if (paramm.getType() == 675) {
        this.fwm.remove(((w)paramm).tag);
      }
      AppMethodBeat.o(11390);
      return;
    }
    ab.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    com.tencent.mm.ah.i locali = o.adg();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    czd localczd;
    com.tencent.mm.ah.h localh;
    if (paramm.getType() == 672)
    {
      if (((v)paramm).afe() == null)
      {
        ab.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        d(null);
        AppMethodBeat.o(11390);
        return;
      }
      paramString = ((v)paramm).afe().xom;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ab.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(11390);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localczd = (czd)localIterator.next();
        localLinkedList.add(new g(localczd.ygd, ((v)paramm).fwO, localczd.nqE, localczd.Nickname, 1, l));
        if (locali != null)
        {
          localh = new com.tencent.mm.ah.h();
          localh.username = localczd.ygd;
          localh.fsk = localczd.nqE;
          localh.cM(false);
          localh.dqB = 3;
          locali.b(localh);
          o.adi().qV(localczd.ygd);
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(z.afh().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(11390);
      return;
      if (paramm.getType() == 675)
      {
        this.fwm.remove(((w)paramm).tag);
        if (((w)paramm).aff() == null)
        {
          ab.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
          d(null);
          AppMethodBeat.o(11390);
          return;
        }
        paramString = ((w)paramm).aff().xom;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ab.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(11390);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localczd = (czd)localIterator.next();
          ab.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", new Object[] { localczd.ygd, ((w)paramm).tag });
          localLinkedList.add(new g(localczd.ygd, ((w)paramm).fwO, localczd.nqE, localczd.Nickname, ((w)paramm).fwP, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.ah.h();
            localh.username = localczd.ygd;
            localh.fsk = localczd.nqE;
            localh.cM(false);
            localh.dqB = 3;
            locali.b(localh);
            o.adi().qV(localczd.ygd);
          }
        }
      }
      else if (paramm.getType() == 674)
      {
        if (((u)paramm).afd() == null)
        {
          ab.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
          d(null);
          AppMethodBeat.o(11390);
          return;
        }
        paramString = ((u)paramm).afd().xom;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ab.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(11390);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localczd = (czd)localIterator.next();
          localLinkedList.add(new g(localczd.ygd, ((u)paramm).fwO, localczd.nqE, localczd.Nickname, 2, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.ah.h();
            localh.username = localczd.ygd;
            localh.fsk = localczd.nqE;
            localh.cM(false);
            localh.dqB = 3;
            locali.b(localh);
            o.adi().qV(localczd.ygd);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.h
 * JD-Core Version:    0.7.0.1
 */