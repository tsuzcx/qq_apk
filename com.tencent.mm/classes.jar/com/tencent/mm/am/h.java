package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
  implements com.tencent.mm.al.g
{
  Object cTX;
  public a gXi;
  private boolean gXj;
  Set<String> gXk;
  public LinkedList<b> gXl;
  
  public h()
  {
    AppMethodBeat.i(124070);
    this.cTX = new Object();
    this.gXi = new a((byte)0);
    this.gXj = false;
    this.gXk = new HashSet();
    this.gXl = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<dtt> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.cTX)
      {
        ArrayList localArrayList = new ArrayList(this.gXl);
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
    synchronized (this.cTX)
    {
      if (!this.gXl.contains(paramb))
      {
        Iterator localIterator = this.gXl.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (bt.nullAsNil(paramb.avQ()).equals(bt.nullAsNil(localb.avQ()))))
          {
            ad.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.avQ() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.gXl.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void aR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new aa(paramString1, paramString2);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString2, 0);
    ad.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.gXl.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void avP()
  {
    AppMethodBeat.i(191054);
    if ((!this.gXj) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class) != null))
    {
      ad.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.gXj = true;
      ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).aOn();
    }
    AppMethodBeat.o(191054);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.cTX)
    {
      if (this.gXl.contains(paramb)) {
        this.gXl.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(191053);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(191053);
      return;
    }
    if (this.gXk.contains(paramString2))
    {
      ad.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(191053);
      return;
    }
    this.gXk.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ac(paramString1, (LinkedList)localObject, localLinkedList);
    ((ac)localObject).tag = paramString2;
    com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
    ad.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.gXl.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(191053);
  }
  
  public final boolean nJ(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.gXi.gXm;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124075);
    ad.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ad.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      d(null);
      if (paramn.getType() == 675) {
        this.gXk.remove(((ac)paramn).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    ad.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    j localj = p.auF();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    dtt localdtt;
    com.tencent.mm.ak.i locali;
    if (paramn.getType() == 672)
    {
      if (((ab)paramn).awa() == null)
      {
        ad.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ab)paramn).awa().DHZ;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ad.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localdtt = (dtt)localIterator.next();
        localLinkedList.add(new g(localdtt.EIs, ((ab)paramn).gXY, localdtt.sah, localdtt.Nickname, localdtt.EIt, l));
        if (localj != null)
        {
          locali = new com.tencent.mm.ak.i();
          locali.username = localdtt.EIs;
          locali.gUf = localdtt.sah;
          locali.ee(false);
          locali.evo = 3;
          localj.b(locali);
          p.auH().vQ(localdtt.EIs);
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(af.awd().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramn.getType() == 675)
      {
        this.gXk.remove(((ac)paramn).tag);
        if (((ac)paramn).awb() == null)
        {
          ad.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ac)paramn).awb().DHZ;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ad.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localdtt = (dtt)localIterator.next();
          ad.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localdtt.EIs, ((ac)paramn).tag, Integer.valueOf(localdtt.EIt), localdtt.sah });
          localLinkedList.add(new g(localdtt.EIs, ((ac)paramn).gXY, localdtt.sah, localdtt.Nickname, localdtt.EIt, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.ak.i();
            locali.username = localdtt.EIs;
            locali.gUf = localdtt.sah;
            locali.ee(false);
            locali.evo = 3;
            localj.b(locali);
            p.auH().vQ(localdtt.EIs);
          }
        }
      }
      else if (paramn.getType() == 674)
      {
        if (((aa)paramn).avZ() == null)
        {
          ad.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((aa)paramn).avZ().DHZ;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ad.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localdtt = (dtt)localIterator.next();
          localLinkedList.add(new g(localdtt.EIs, ((aa)paramn).gXY, localdtt.sah, localdtt.Nickname, localdtt.EIt, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.ak.i();
            locali.username = localdtt.EIs;
            locali.gUf = localdtt.sah;
            locali.ee(false);
            locali.evo = 3;
            localj.b(locali);
            p.auH().vQ(localdtt.EIs);
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public String appId;
    boolean gXm = false;
    public int gXn;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(191052);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.gXn + ", " + this.gXm + "}";
      AppMethodBeat.o(191052);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String avQ();
    
    public abstract void e(LinkedList<dtt> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.h
 * JD-Core Version:    0.7.0.1
 */