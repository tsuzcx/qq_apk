package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
  implements com.tencent.mm.ak.g
{
  Object cRu;
  public a hxH;
  private boolean hxI;
  Set<String> hxJ;
  public LinkedList<b> hxK;
  
  public h()
  {
    AppMethodBeat.i(124070);
    this.cRu = new Object();
    this.hxH = new a((byte)0);
    this.hxI = false;
    this.hxJ = new HashSet();
    this.hxK = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<dzk> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.cRu)
      {
        ArrayList localArrayList = new ArrayList(this.hxK);
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
    synchronized (this.cRu)
    {
      if (!this.hxK.contains(paramb))
      {
        Iterator localIterator = this.hxK.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (bs.nullAsNil(paramb.aCI()).equals(bs.nullAsNil(localb.aCI()))))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.aCI() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.hxK.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void aCH()
  {
    AppMethodBeat.i(209530);
    if ((!this.hxI) && (com.tencent.mm.kernel.g.ab(f.class) != null))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.hxI = true;
      ((f)com.tencent.mm.kernel.g.ab(f.class)).aVd();
    }
    AppMethodBeat.o(209530);
  }
  
  public final void aZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (bs.isNullOrNil(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new aa(paramString1, paramString2);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString2, 0);
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.hxK.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.cRu)
    {
      if (this.hxK.contains(paramb)) {
        this.hxK.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(209529);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(209529);
      return;
    }
    if (this.hxJ.contains(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(209529);
      return;
    }
    this.hxJ.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ac(paramString1, (LinkedList)localObject, localLinkedList);
    ((ac)localObject).tag = paramString2;
    com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.hxK.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(209529);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124075);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      d(null);
      if (paramn.getType() == 675) {
        this.hxJ.remove(((ac)paramn).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    j localj = p.aBw();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    dzk localdzk;
    com.tencent.mm.aj.i locali;
    if (paramn.getType() == 672)
    {
      if (((ab)paramn).aCS() == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ab)paramn).aCS().Fdu;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localdzk = (dzk)localIterator.next();
        localLinkedList.add(new g(localdzk.GfE, ((ab)paramn).hyx, localdzk.tia, localdzk.Nickname, localdzk.GfF, l));
        if (localj != null)
        {
          locali = new com.tencent.mm.aj.i();
          locali.username = localdzk.GfE;
          locali.huE = localdzk.tia;
          locali.ez(false);
          locali.exK = 3;
          localj.b(locali);
          p.aBy().zW(localdzk.GfE);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(af.aCV().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramn.getType() == 675)
      {
        this.hxJ.remove(((ac)paramn).tag);
        if (((ac)paramn).aCT() == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ac)paramn).aCT().Fdu;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localdzk = (dzk)localIterator.next();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localdzk.GfE, ((ac)paramn).tag, Integer.valueOf(localdzk.GfF), localdzk.tia });
          localLinkedList.add(new g(localdzk.GfE, ((ac)paramn).hyx, localdzk.tia, localdzk.Nickname, localdzk.GfF, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localdzk.GfE;
            locali.huE = localdzk.tia;
            locali.ez(false);
            locali.exK = 3;
            localj.b(locali);
            p.aBy().zW(localdzk.GfE);
          }
        }
      }
      else if (paramn.getType() == 674)
      {
        if (((aa)paramn).aCR() == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((aa)paramn).aCR().Fdu;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localdzk = (dzk)localIterator.next();
          localLinkedList.add(new g(localdzk.GfE, ((aa)paramn).hyx, localdzk.tia, localdzk.Nickname, localdzk.GfF, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localdzk.GfE;
            locali.huE = localdzk.tia;
            locali.ez(false);
            locali.exK = 3;
            localj.b(locali);
            p.aBy().zW(localdzk.GfE);
          }
        }
      }
    }
  }
  
  public final boolean ox(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.hxH.hxL;
  }
  
  public static final class a
  {
    public String appId;
    boolean hxL = false;
    public int hxM;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(209528);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.hxM + ", " + this.hxL + "}";
      AppMethodBeat.o(209528);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String aCI();
    
    public abstract void e(LinkedList<dzk> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.h
 * JD-Core Version:    0.7.0.1
 */