package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
  implements com.tencent.mm.al.f
{
  Object dcK;
  public a hQc;
  private boolean hQd;
  Set<String> hQe;
  public LinkedList<b> hQf;
  
  public i()
  {
    AppMethodBeat.i(124070);
    this.dcK = new Object();
    this.hQc = new a((byte)0);
    this.hQd = false;
    this.hQe = new HashSet();
    this.hQf = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<efo> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.dcK)
      {
        ArrayList localArrayList = new ArrayList(this.hQf);
        i = 0;
        if (i < localArrayList.size())
        {
          b localb = (b)localArrayList.get(i);
          if (localb != null) {
            localb.e(paramLinkedList);
          }
        }
        else
        {
          AppMethodBeat.o(124076);
          return;
        }
      }
      i += 1;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(124071);
    synchronized (this.dcK)
    {
      if (!this.hQf.contains(paramb))
      {
        Iterator localIterator = this.hQf.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (bt.nullAsNil(paramb.aFL()).equals(bt.nullAsNil(localb.aFL()))))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.aFL() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.hQf.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void aFK()
  {
    AppMethodBeat.i(207179);
    if ((!this.hQd) && (g.ab(com.tencent.mm.plugin.appbrand.service.f.class) != null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.hQd = true;
      ((com.tencent.mm.plugin.appbrand.service.f)g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYx();
    }
    AppMethodBeat.o(207179);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.dcK)
    {
      if (this.hQf.contains(paramb)) {
        this.hQf.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void ba(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (bt.isNullOrNil(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new ab(paramString1, paramString2);
    g.ajB().gAO.a(paramString2, 0);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.hQf.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(207178);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(207178);
      return;
    }
    if (this.hQe.contains(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(207178);
      return;
    }
    this.hQe.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ad(paramString1, (LinkedList)localObject, localLinkedList);
    ((ad)localObject).tag = paramString2;
    g.ajB().gAO.a((n)localObject, 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.hQf.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(207178);
  }
  
  public final boolean oY(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.hQc.hQg;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124075);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      d(null);
      if (paramn.getType() == 675) {
        this.hQe.remove(((ad)paramn).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    com.tencent.mm.ak.j localj = p.aEx();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    efo localefo;
    com.tencent.mm.ak.i locali;
    if (paramn.getType() == 672)
    {
      if (((ac)paramn).aFV() == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ac)paramn).aFV().GMX;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localefo = (efo)localIterator.next();
        localLinkedList.add(new h(localefo.HQN, ((ac)paramn).hQR, localefo.ufR, localefo.Nickname, localefo.HQO, l));
        if (localj != null)
        {
          locali = new com.tencent.mm.ak.i();
          locali.username = localefo.HQN;
          locali.hMW = localefo.ufR;
          locali.eB(false);
          locali.ePj = 3;
          localj.b(locali);
          p.aEz().CV(localefo.HQN);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(ag.aFY().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramn.getType() == 675)
      {
        this.hQe.remove(((ad)paramn).tag);
        if (((ad)paramn).aFW() == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ad)paramn).aFW().GMX;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localefo = (efo)localIterator.next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localefo.HQN, ((ad)paramn).tag, Integer.valueOf(localefo.HQO), localefo.ufR });
          localLinkedList.add(new h(localefo.HQN, ((ad)paramn).hQR, localefo.ufR, localefo.Nickname, localefo.HQO, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.ak.i();
            locali.username = localefo.HQN;
            locali.hMW = localefo.ufR;
            locali.eB(false);
            locali.ePj = 3;
            localj.b(locali);
            p.aEz().CV(localefo.HQN);
          }
        }
      }
      else if (paramn.getType() == 674)
      {
        if (((ab)paramn).aFU() == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ab)paramn).aFU().GMX;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localefo = (efo)localIterator.next();
          localLinkedList.add(new h(localefo.HQN, ((ab)paramn).hQR, localefo.ufR, localefo.Nickname, localefo.HQO, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.ak.i();
            locali.username = localefo.HQN;
            locali.hMW = localefo.ufR;
            locali.eB(false);
            locali.ePj = 3;
            localj.b(locali);
            p.aEz().CV(localefo.HQN);
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public String appId;
    boolean hQg = false;
    public int hQh;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(207177);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.hQh + ", " + this.hQg + "}";
      AppMethodBeat.o(207177);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String aFL();
    
    public abstract void e(LinkedList<efo> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.i
 * JD-Core Version:    0.7.0.1
 */