package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.k;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.fmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
  implements com.tencent.mm.an.i
{
  Object fnq;
  public a lEA;
  private boolean lEB;
  Set<String> lEC;
  public LinkedList<b> lED;
  
  public i()
  {
    AppMethodBeat.i(124070);
    this.fnq = new Object();
    this.lEA = new a((byte)0);
    this.lEB = false;
    this.lEC = new HashSet();
    this.lED = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<fmr> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.fnq)
      {
        ArrayList localArrayList = new ArrayList(this.lED);
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
    synchronized (this.fnq)
    {
      if (!this.lED.contains(paramb))
      {
        Iterator localIterator = this.lED.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (Util.nullAsNil(paramb.bjj()).equals(Util.nullAsNil(localb.bjj()))))
          {
            Log.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.bjj() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.lED.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.fnq)
    {
      if (this.lED.contains(paramb)) {
        this.lED.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new ab(paramString1, paramString2);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString2, 0);
    Log.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.lED.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void bji()
  {
    AppMethodBeat.i(206395);
    if ((!this.lEB) && (com.tencent.mm.kernel.h.ae(f.class) != null))
    {
      Log.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.lEB = true;
      ((f)com.tencent.mm.kernel.h.ae(f.class)).a(z.qPh);
    }
    AppMethodBeat.o(206395);
  }
  
  public final void j(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(206389);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(206389);
      return;
    }
    if (this.lEC.contains(paramString2))
    {
      Log.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(206389);
      return;
    }
    this.lEC.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ac(paramString1, (LinkedList)localObject, localLinkedList);
    ((ac)localObject).tag = paramString2;
    com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
    Log.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.lED.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(206389);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
        this.lEC.remove(((ac)paramq).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    Log.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    k localk = com.tencent.mm.am.q.bhP();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    if (paramq.getType() == 672)
    {
      AppMethodBeat.o(124075);
      throw null;
    }
    Iterator localIterator;
    fmr localfmr;
    com.tencent.mm.am.j localj;
    if (paramq.getType() == 675)
    {
      this.lEC.remove(((ac)paramq).tag);
      if (((ac)paramq).bjs() == null)
      {
        Log.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ac)paramq).bjs().Twv;
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
        localfmr = (fmr)localIterator.next();
        Log.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localfmr.ULp, ((ac)paramq).tag, Integer.valueOf(localfmr.ULq), localfmr.CNM });
        localLinkedList.add(new h(localfmr.ULp, ((ac)paramq).lFl, localfmr.CNM, localfmr.Nickname, localfmr.ULq, l));
        if (localk != null)
        {
          localj = new com.tencent.mm.am.j();
          localj.username = localfmr.ULp;
          localj.lBd = localfmr.CNM;
          localj.gg(false);
          localj.hDc = 3;
          localk.b(localj);
          com.tencent.mm.am.q.bhR().Rv(localfmr.ULp);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(af.bju().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramq.getType() == 674)
      {
        if (((ab)paramq).bjr() == null)
        {
          Log.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ab)paramq).bjr().Twv;
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
          localfmr = (fmr)localIterator.next();
          localLinkedList.add(new h(localfmr.ULp, ((ab)paramq).lFl, localfmr.CNM, localfmr.Nickname, localfmr.ULq, l));
          if (localk != null)
          {
            localj = new com.tencent.mm.am.j();
            localj.username = localfmr.ULp;
            localj.lBd = localfmr.CNM;
            localj.gg(false);
            localj.hDc = 3;
            localk.b(localj);
            com.tencent.mm.am.q.bhR().Rv(localfmr.ULp);
          }
        }
      }
    }
  }
  
  public final boolean vM(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.lEA.lEE;
  }
  
  public static final class a
  {
    public String appId;
    public int cBU;
    boolean lEE = false;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(206008);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.cBU + ", " + this.lEE + "}";
      AppMethodBeat.o(206008);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String bjj();
    
    public abstract void e(LinkedList<fmr> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.i
 * JD-Core Version:    0.7.0.1
 */