package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.i
{
  Object duI;
  public a iOj;
  private boolean iOk;
  Set<String> iOl;
  public LinkedList<b> iOm;
  
  public i()
  {
    AppMethodBeat.i(124070);
    this.duI = new Object();
    this.iOj = new a((byte)0);
    this.iOk = false;
    this.iOl = new HashSet();
    this.iOm = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<fbw> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.duI)
      {
        ArrayList localArrayList = new ArrayList(this.iOm);
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
    synchronized (this.duI)
    {
      if (!this.iOm.contains(paramb))
      {
        Iterator localIterator = this.iOm.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (Util.nullAsNil(paramb.aZT()).equals(Util.nullAsNil(localb.aZT()))))
          {
            Log.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.aZT() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.iOm.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void aZS()
  {
    AppMethodBeat.i(212168);
    if ((!this.iOk) && (g.af(f.class) != null))
    {
      Log.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.iOk = true;
      ((f)g.af(f.class)).a(z.nMP);
    }
    AppMethodBeat.o(212168);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.duI)
    {
      if (this.iOm.contains(paramb)) {
        this.iOm.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new ab(paramString1, paramString2);
    g.aAg().hqi.a(paramString2, 0);
    Log.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.iOm.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void j(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(212167);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(212167);
      return;
    }
    if (this.iOl.contains(paramString2))
    {
      Log.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(212167);
      return;
    }
    this.iOl.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ad(paramString1, (LinkedList)localObject, localLinkedList);
    ((ad)localObject).tag = paramString2;
    g.aAg().hqi.a((q)localObject, 0);
    Log.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.iOm.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(212167);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(124075);
    Log.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      d(null);
      if (paramq.getType() == 675) {
        this.iOl.remove(((ad)paramq).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    Log.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    com.tencent.mm.aj.j localj = p.aYB();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    fbw localfbw;
    com.tencent.mm.aj.i locali;
    if (paramq.getType() == 672)
    {
      if (((ac)paramq).bad() == null)
      {
        Log.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ac)paramq).bad().MlC;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        Log.e("MicroMsg.BizKFService", "empty workers");
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localfbw = (fbw)localIterator.next();
        localLinkedList.add(new h(localfbw.NxV, ((ac)paramq).brandUsername, localfbw.xJE, localfbw.Nickname, localfbw.NxW, l));
        if (localj != null)
        {
          locali = new com.tencent.mm.aj.i();
          locali.username = localfbw.NxV;
          locali.iKW = localfbw.xJE;
          locali.fv(false);
          locali.fuz = 3;
          localj.b(locali);
          p.aYD().Mh(localfbw.NxV);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(ag.bag().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramq.getType() == 675)
      {
        this.iOl.remove(((ad)paramq).tag);
        if (((ad)paramq).bae() == null)
        {
          Log.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ad)paramq).bae().MlC;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          Log.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localfbw = (fbw)localIterator.next();
          Log.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localfbw.NxV, ((ad)paramq).tag, Integer.valueOf(localfbw.NxW), localfbw.xJE });
          localLinkedList.add(new h(localfbw.NxV, ((ad)paramq).brandUsername, localfbw.xJE, localfbw.Nickname, localfbw.NxW, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localfbw.NxV;
            locali.iKW = localfbw.xJE;
            locali.fv(false);
            locali.fuz = 3;
            localj.b(locali);
            p.aYD().Mh(localfbw.NxV);
          }
        }
      }
      else if (paramq.getType() == 674)
      {
        if (((ab)paramq).bac() == null)
        {
          Log.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ab)paramq).bac().MlC;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          Log.e("MicroMsg.BizKFService", "empty workers");
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localfbw = (fbw)localIterator.next();
          localLinkedList.add(new h(localfbw.NxV, ((ab)paramq).brandUsername, localfbw.xJE, localfbw.Nickname, localfbw.NxW, l));
          if (localj != null)
          {
            locali = new com.tencent.mm.aj.i();
            locali.username = localfbw.NxV;
            locali.iKW = localfbw.xJE;
            locali.fv(false);
            locali.fuz = 3;
            localj.b(locali);
            p.aYD().Mh(localfbw.NxV);
          }
        }
      }
    }
  }
  
  public final boolean sP(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.iOj.iOn;
  }
  
  public static final class a
  {
    public String appId;
    boolean iOn = false;
    public int iOo;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(212166);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.iOo + ", " + this.iOn + "}";
      AppMethodBeat.o(212166);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String aZT();
    
    public abstract void e(LinkedList<fbw> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.i
 * JD-Core Version:    0.7.0.1
 */