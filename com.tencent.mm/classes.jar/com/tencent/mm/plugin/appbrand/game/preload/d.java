package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.n.e.b;
import com.tencent.mm.plugin.appbrand.n.e.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.appbrand.p.b.a;
import com.tencent.mm.plugin.appbrand.p.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static volatile d jSE;
  public boolean hasInit;
  public o jPl;
  public m jSF;
  public com.tencent.mm.plugin.appbrand.p.a jSG;
  public p jSH;
  public c jSI;
  public CopyOnWriteArrayList<String> jSJ;
  public boolean jSK;
  public boolean jSL;
  public AtomicInteger jSM;
  public AtomicInteger jSN;
  public AtomicInteger jSO;
  public AtomicInteger jSP;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.jSJ = new CopyOnWriteArrayList();
    this.jSK = false;
    this.jSL = false;
    AppMethodBeat.o(45286);
  }
  
  public static void B(o paramo)
  {
    AppMethodBeat.i(186537);
    Iterator localIterator;
    try
    {
      if ((jSE == null) || (jSE.jPl != paramo)) {
        break label180;
      }
      if (jSE.jSF == null) {
        break label176;
      }
      paramo = jSE.jSF;
      synchronized (paramo.lwp)
      {
        localIterator = paramo.lwp.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).isRunning = false;
        }
      }
      paramo.lwp.clear();
    }
    finally
    {
      AppMethodBeat.o(186537);
    }
    synchronized (paramo.lxm)
    {
      localIterator = paramo.lxm.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).isRunning = false;
      }
    }
    paramo.lxm.clear();
    jSE.jPl = null;
    label176:
    jSE = null;
    label180:
    AppMethodBeat.o(186537);
  }
  
  public static String aLs()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.p.c.bpg();
    localObject = com.tencent.mm.plugin.appbrand.p.c.bpf();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static d bdT()
  {
    AppMethodBeat.i(45287);
    if (jSE == null) {}
    try
    {
      if (jSE == null) {
        jSE = new d();
      }
      d locald = jSE;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.bdV().jSZ = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public final void bdU()
  {
    AppMethodBeat.i(45290);
    if ((this.jSJ != null) && (this.jSJ.size() == 0))
    {
      if ((this.jPl == null) || (this.jPl.getAppConfig() == null))
      {
        ac.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.jPl.getAppConfig().jBF;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        ac.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
        if (localObject1 != null) {
          localObject1 = ((ArrayList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label257;
          }
          final String str = (String)((Iterator)localObject1).next();
          ac.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str });
          be.T(this.jPl);
          if ((this.jPl == null) || (this.jPl.aTR() == null))
          {
            ac.e("MicroMsg.WAGamePreloadManager", "runtime or sysConfig null");
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          Object localObject2 = this.jPl.aTR().jEg.ce(this.jPl.mAppId, str);
          i.aKe(str);
          if (e.c.lvw == null)
          {
            ac.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
          }
          else
          {
            localObject2 = e.c.lvw.j(this.jPl, (String)localObject2);
            ((com.tencent.mm.plugin.appbrand.n.e)localObject2).a(new e.b()
            {
              public final void LD(String paramAnonymousString)
              {
                AppMethodBeat.i(45282);
                ac.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                d.a(d.this).addAndGet(1);
                AppMethodBeat.o(45282);
              }
              
              public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(186536);
                ac.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { str });
                d.a(d.this).addAndGet(1);
                AppMethodBeat.o(186536);
              }
              
              public final void a(com.tencent.mm.plugin.appbrand.n.c paramAnonymousc)
              {
                AppMethodBeat.i(45283);
                ac.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                AppMethodBeat.o(45283);
              }
            });
            ((com.tencent.mm.plugin.appbrand.n.e)localObject2).start();
          }
        }
      }
    }
    label257:
    AppMethodBeat.o(45290);
  }
  
  public final boolean isDownloading(String paramString)
  {
    AppMethodBeat.i(45288);
    synchronized (this.jSJ)
    {
      if (this.jSJ != null)
      {
        if (this.jSJ.contains(paramString))
        {
          ac.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.jSJ.size()) });
          this.jSP.addAndGet(1);
          AppMethodBeat.o(45288);
          return true;
        }
        AppMethodBeat.o(45288);
        return false;
      }
      AppMethodBeat.o(45288);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */