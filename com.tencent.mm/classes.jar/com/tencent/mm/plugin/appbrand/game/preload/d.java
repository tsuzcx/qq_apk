package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.m.e.b;
import com.tencent.mm.plugin.appbrand.m.e.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.o.a.b;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.plugin.appbrand.o.m;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static volatile d kmS;
  public boolean hasInit;
  public o jCo;
  public m kmT;
  public com.tencent.mm.plugin.appbrand.o.a kmU;
  public p kmV;
  public c kmW;
  public CopyOnWriteArrayList<String> kmX;
  public boolean kmY;
  public boolean kmZ;
  public AtomicInteger kna;
  public AtomicInteger knb;
  public AtomicInteger knc;
  public AtomicInteger knd;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.kmX = new CopyOnWriteArrayList();
    this.kmY = false;
    this.kmZ = false;
    AppMethodBeat.o(45286);
  }
  
  public static String aOC()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.btf();
    localObject = com.tencent.mm.plugin.appbrand.o.c.bte();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static d bhx()
  {
    AppMethodBeat.i(45287);
    if (kmS == null) {}
    try
    {
      if (kmS == null) {
        kmS = new d();
      }
      d locald = kmS;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static void gk(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.bhz().knn = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public static void s(o paramo)
  {
    AppMethodBeat.i(188236);
    Iterator localIterator;
    try
    {
      if ((kmS == null) || (kmS.jCo != paramo)) {
        break label180;
      }
      if (kmS.kmT == null) {
        break label176;
      }
      paramo = kmS.kmT;
      synchronized (paramo.lVC)
      {
        localIterator = paramo.lVC.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).isRunning = false;
        }
      }
      paramo.lVC.clear();
    }
    finally
    {
      AppMethodBeat.o(188236);
    }
    synchronized (paramo.lWA)
    {
      localIterator = paramo.lWA.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).isRunning = false;
      }
    }
    paramo.lWA.clear();
    kmS.jCo = null;
    label176:
    kmS = null;
    label180:
    AppMethodBeat.o(188236);
  }
  
  public final void bhy()
  {
    AppMethodBeat.i(45290);
    if ((this.kmX != null) && (this.kmX.size() == 0))
    {
      if ((this.jCo == null) || (this.jCo.getAppConfig() == null))
      {
        ad.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.jCo.getAppConfig().jVB;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        ad.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
        if (localObject1 != null) {
          localObject1 = ((ArrayList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label301;
          }
          final String str1 = (String)((Iterator)localObject1).next();
          ad.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str1 });
          Object localObject2 = this.jCo;
          if ((localObject2 == null) || (((o)localObject2).aXb() == null))
          {
            ad.e("MicroMsg.WAGamePreloadManager", "runtime(%s) or sysConfig null", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          if ((((AppBrandRuntime)localObject2).SB) || (((o)localObject2).isDestroyed()))
          {
            ad.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
          }
          else
          {
            bf.N((AppBrandRuntime)localObject2);
            String str2 = ((o)localObject2).aXb().jYh.cg(((AppBrandRuntime)localObject2).mAppId, str1);
            i.aPK(str1);
            if (e.c.lUF == null)
            {
              ad.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            }
            else
            {
              localObject2 = e.c.lUF.j((AppBrandRuntime)localObject2, str2);
              ((com.tencent.mm.plugin.appbrand.m.e)localObject2).a(new e.b()
              {
                public final void OX(String paramAnonymousString)
                {
                  AppMethodBeat.i(45282);
                  ad.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str1, paramAnonymousString });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(45282);
                }
                
                public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
                {
                  AppMethodBeat.i(188235);
                  ad.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { str1 });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(188235);
                }
                
                public final void a(com.tencent.mm.plugin.appbrand.m.c paramAnonymousc)
                {
                  AppMethodBeat.i(45283);
                  ad.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                  AppMethodBeat.o(45283);
                }
              });
              ((com.tencent.mm.plugin.appbrand.m.e)localObject2).start();
            }
          }
        }
      }
    }
    label301:
    AppMethodBeat.o(45290);
  }
  
  public final boolean isDownloading(String paramString)
  {
    AppMethodBeat.i(45288);
    synchronized (this.kmX)
    {
      if (this.kmX != null)
      {
        if (this.kmX.contains(paramString))
        {
          ad.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.kmX.size()) });
          this.knd.addAndGet(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */