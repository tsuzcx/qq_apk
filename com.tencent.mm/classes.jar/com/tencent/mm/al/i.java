package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.f
{
  Object ddM;
  public a hSU;
  private boolean hSV;
  Set<String> hSW;
  public LinkedList<b> hSX;
  
  public i()
  {
    AppMethodBeat.i(124070);
    this.ddM = new Object();
    this.hSU = new a((byte)0);
    this.hSV = false;
    this.hSW = new HashSet();
    this.hSX = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<ehf> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.ddM)
      {
        ArrayList localArrayList = new ArrayList(this.hSX);
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
    synchronized (this.ddM)
    {
      if (!this.hSX.contains(paramb))
      {
        Iterator localIterator = this.hSX.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (bu.nullAsNil(paramb.aGb()).equals(bu.nullAsNil(localb.aGb()))))
          {
            ae.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.aGb() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.hSX.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void aGa()
  {
    AppMethodBeat.i(188877);
    if ((!this.hSV) && (g.ab(com.tencent.mm.plugin.appbrand.service.f.class) != null))
    {
      ae.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.hSV = true;
      ((com.tencent.mm.plugin.appbrand.service.f)g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYS();
    }
    AppMethodBeat.o(188877);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.ddM)
    {
      if (this.hSX.contains(paramb)) {
        this.hSX.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void ba(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new ab(paramString1, paramString2);
    g.ajQ().gDv.a(paramString2, 0);
    ae.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.hSX.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(188876);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(188876);
      return;
    }
    if (this.hSW.contains(paramString2))
    {
      ae.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(188876);
      return;
    }
    this.hSW.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ad(paramString1, (LinkedList)localObject, localLinkedList);
    ((ad)localObject).tag = paramString2;
    g.ajQ().gDv.a((n)localObject, 0);
    ae.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.hSX.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(188876);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124075);
    ae.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      d(null);
      if (paramn.getType() == 675) {
        this.hSW.remove(((ad)paramn).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    ae.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    com.tencent.mm.aj.j localj = p.aEN();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    ehf localehf;
    com.tencent.mm.aj.i locali;
    if (paramn.getType() == 672)
    {
      if (((ac)paramn).aGl() == null)
      {
        ae.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ac)paramn).aGl().Hgx;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ae.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localehf = (ehf)localIterator.next();
        localLinkedList.add(new h(localehf.IkU, ((ac)paramn).hTJ, localehf.urn, localehf.Nickname, localehf.IkV, l));
        if (localj != null)
        {
          locali = new com.tencent.mm.aj.i();
          locali.username = localehf.IkU;
          locali.hPP = localehf.urn;
          locali.eD(false);
          locali.eQU = 3;
          localj.b(locali);
          p.aEP().Dx(localehf.IkU);
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(ag.aGo().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramn.getType() == 675)
      {
        this.hSW.remove(((ad)paramn).tag);
        if (((ad)paramn).aGm() == null)
        {
          ae.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ad)paramn).aGm().Hgx;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ae.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localehf = (ehf)localIterator.next();
          ae.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localehf.IkU, ((ad)paramn).tag, Integer.valueOf(localehf.IkV), localehf.urn });
          localLinkedList.add(new h(localehf.IkU, ((ad)paramn).hTJ, localehf.urn, localehf.Nickname, localehf.IkV, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localehf.IkU;
            locali.hPP = localehf.urn;
            locali.eD(false);
            locali.eQU = 3;
            localj.b(locali);
            p.aEP().Dx(localehf.IkU);
          }
        }
      }
      else if (paramn.getType() == 674)
      {
        if (((ab)paramn).aGk() == null)
        {
          ae.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ab)paramn).aGk().Hgx;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ae.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localehf = (ehf)localIterator.next();
          localLinkedList.add(new h(localehf.IkU, ((ab)paramn).hTJ, localehf.urn, localehf.Nickname, localehf.IkV, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localehf.IkU;
            locali.hPP = localehf.urn;
            locali.eD(false);
            locali.eQU = 3;
            localj.b(locali);
            p.aEP().Dx(localehf.IkU);
          }
        }
      }
    }
  }
  
  public final boolean pb(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.hSU.hSY;
  }
  
  public static final class a
  {
    public String appId;
    boolean hSY = false;
    public int hSZ;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(188875);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.hSZ + ", " + this.hSY + "}";
      AppMethodBeat.o(188875);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String aGb();
    
    public abstract void e(LinkedList<ehf> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.i
 * JD-Core Version:    0.7.0.1
 */