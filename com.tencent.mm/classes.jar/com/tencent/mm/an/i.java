package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.gjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
  implements com.tencent.mm.am.h
{
  Object hrB;
  public a owh;
  private boolean owi;
  Set<String> owj;
  public LinkedList<b> owk;
  
  public i()
  {
    AppMethodBeat.i(124070);
    this.hrB = new Object();
    this.owh = new a((byte)0);
    this.owi = false;
    this.owj = new HashSet();
    this.owk = new LinkedList();
    AppMethodBeat.o(124070);
  }
  
  private void d(LinkedList<gjj> paramLinkedList)
  {
    AppMethodBeat.i(124076);
    for (;;)
    {
      int i;
      synchronized (this.hrB)
      {
        ArrayList localArrayList = new ArrayList(this.owk);
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
    synchronized (this.hrB)
    {
      if (!this.owk.contains(paramb))
      {
        Iterator localIterator = this.owk.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb != null) && (Util.nullAsNil(paramb.bGT()).equals(Util.nullAsNil(localb.bGT()))))
          {
            Log.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { paramb.bGT() });
            AppMethodBeat.o(124071);
            return;
          }
        }
        this.owk.add(paramb);
      }
      AppMethodBeat.o(124071);
      return;
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124072);
    synchronized (this.hrB)
    {
      if (this.owk.contains(paramb)) {
        this.owk.remove(paramb);
      }
      AppMethodBeat.o(124072);
      return;
    }
  }
  
  public final void bGS()
  {
    AppMethodBeat.i(239465);
    if ((!this.owi) && (com.tencent.mm.kernel.h.ax(g.class) != null))
    {
      Log.i("MicroMsg.BizKFService", "alvinluo checkAndPreloadKFGuideAppBrand");
      this.owi = true;
      ((g)com.tencent.mm.kernel.h.ax(g.class)).a(com.tencent.mm.plugin.appbrand.service.ab.tTY);
    }
    AppMethodBeat.o(239465);
  }
  
  public final void bu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124073);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
      AppMethodBeat.o(124073);
      return;
    }
    paramString2 = new ab(paramString1, paramString2);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString2, 0);
    Log.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[] { paramString1, Integer.valueOf(this.owk.size()) });
    AppMethodBeat.o(124073);
  }
  
  public final void m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(239457);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(239457);
      return;
    }
    if (this.owj.contains(paramString2))
    {
      Log.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      AppMethodBeat.o(239457);
      return;
    }
    this.owj.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramInt));
    localObject = new ac(paramString1, (LinkedList)localObject, localLinkedList);
    ((ac)localObject).tag = paramString2;
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    Log.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d, kfType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.owk.size()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(239457);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(124075);
    Log.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.e("MicroMsg.BizKFService", "scene == null");
      d(null);
      AppMethodBeat.o(124075);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
      d(null);
      if (paramp.getType() == 675) {
        this.owj.remove(((ac)paramp).tag);
      }
      AppMethodBeat.o(124075);
      return;
    }
    Log.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    k localk = q.bFE();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    if (paramp.getType() == 672)
    {
      AppMethodBeat.o(124075);
      throw null;
    }
    Iterator localIterator;
    gjj localgjj;
    com.tencent.mm.modelavatar.j localj;
    if (paramp.getType() == 675)
    {
      this.owj.remove(((ac)paramp).tag);
      if (((ac)paramp).bHc() == null)
      {
        Log.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramp.getType()) });
        d(null);
        AppMethodBeat.o(124075);
        return;
      }
      paramString = ((ac)paramp).bHc().aaLc;
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
        localgjj = (gjj)localIterator.next();
        Log.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s, kfType: %d, headUrl: %s", new Object[] { localgjj.acfC, ((ac)paramp).tag, Integer.valueOf(localgjj.acfD), localgjj.IHW });
        localLinkedList.add(new h(localgjj.acfC, ((ac)paramp).owR, localgjj.IHW, localgjj.Nickname, localgjj.acfD, l));
        if (localk != null)
        {
          localj = new com.tencent.mm.modelavatar.j();
          localj.username = localgjj.acfC;
          localj.osM = localgjj.IHW;
          localj.gX(false);
          localj.jZY = 3;
          localk.b(localj);
          q.bFG().LC(localgjj.acfC);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(af.bHe().f(localLinkedList)) });
      d(paramString);
      AppMethodBeat.o(124075);
      return;
      if (paramp.getType() == 674)
      {
        if (((ab)paramp).bHb() == null)
        {
          Log.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramp.getType()) });
          d(null);
          AppMethodBeat.o(124075);
          return;
        }
        paramString = ((ab)paramp).bHb().aaLc;
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
          localgjj = (gjj)localIterator.next();
          localLinkedList.add(new h(localgjj.acfC, ((ab)paramp).owR, localgjj.IHW, localgjj.Nickname, localgjj.acfD, l));
          if (localk != null)
          {
            localj = new com.tencent.mm.modelavatar.j();
            localj.username = localgjj.acfC;
            localj.osM = localgjj.IHW;
            localj.gX(false);
            localj.jZY = 3;
            localk.b(localj);
            q.bFG().LC(localgjj.acfC);
          }
        }
      }
    }
  }
  
  public final boolean vR(int paramInt)
  {
    if (paramInt != 2) {
      return false;
    }
    return this.owh.owl;
  }
  
  public static final class a
  {
    public String appId;
    public int euz;
    boolean owl = false;
    public String path;
    
    public final String toString()
    {
      AppMethodBeat.i(239464);
      String str = "BizKFGuideAppBrandInfo{" + this.appId + ", " + this.path + ", " + this.euz + ", " + this.owl + "}";
      AppMethodBeat.o(239464);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract String bGT();
    
    public abstract void e(LinkedList<gjj> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.i
 * JD-Core Version:    0.7.0.1
 */