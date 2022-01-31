package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.k.e.a;
import com.tencent.mm.plugin.appbrand.k.e.b;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class d
{
  private static volatile d htW;
  public boolean hasInit;
  public com.tencent.mm.plugin.appbrand.o htX;
  public m htY;
  public com.tencent.mm.plugin.appbrand.m.a htZ;
  public com.tencent.mm.plugin.appbrand.appstorage.o hua;
  public c hub;
  public CopyOnWriteArrayList<String> huc;
  public boolean hud;
  public AtomicInteger hue;
  public AtomicInteger huf;
  public AtomicInteger hug;
  public AtomicInteger huh;
  
  private d()
  {
    AppMethodBeat.i(130297);
    this.hasInit = false;
    this.huc = new CopyOnWriteArrayList();
    this.hud = false;
    AppMethodBeat.o(130297);
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.m.a parama, String paramString)
  {
    AppMethodBeat.i(130300);
    if (parama.isl) {}
    for (boolean bool = false; (bool) && (!j.c(parama.bDC, paramString)); bool = parama.ism)
    {
      ab.i("MicroMsg.WAGamePreloadManager", "not in domain url %s", new Object[] { paramString });
      AppMethodBeat.o(130300);
      return false;
    }
    AppMethodBeat.o(130300);
    return true;
  }
  
  public static d aAQ()
  {
    AppMethodBeat.i(130298);
    if (htW == null) {}
    try
    {
      if (htW == null) {
        htW = new d();
      }
      d locald = htW;
      AppMethodBeat.o(130298);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(130298);
    }
  }
  
  public static String aAR()
  {
    AppMethodBeat.i(130301);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.m.c.aIh();
    localObject = com.tencent.mm.plugin.appbrand.m.c.aIg();
    AppMethodBeat.o(130301);
    return localObject;
  }
  
  public static void dX(boolean paramBoolean)
  {
    AppMethodBeat.i(130303);
    e.aAT().hur = paramBoolean;
    AppMethodBeat.o(130303);
  }
  
  public final void aAS()
  {
    AppMethodBeat.i(130302);
    if ((this.huc != null) && (this.huc.size() == 0))
    {
      if ((this.htX == null) || (this.htX.getAppConfig() == null))
      {
        ab.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(130302);
        return;
      }
      Object localObject1 = this.htX.getAppConfig().hgW;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        ab.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
        if (localObject1 != null) {
          localObject1 = ((ArrayList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label215;
          }
          final String str = (String)((Iterator)localObject1).next();
          ab.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str });
          Object localObject2 = this.htX.atR().hiX.yK(str);
          g.getMD5(str);
          if (e.b.irV == null)
          {
            ab.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          localObject2 = e.b.irV.i(this.htX, (String)localObject2);
          ((com.tencent.mm.plugin.appbrand.k.e)localObject2).a(new e.a()
          {
            public final void a(com.tencent.mm.plugin.appbrand.k.c paramAnonymousc)
            {
              AppMethodBeat.i(130294);
              ab.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
              AppMethodBeat.o(130294);
            }
            
            public final void dO(String paramAnonymousString)
            {
              AppMethodBeat.i(130293);
              ab.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
              d.a(d.this).addAndGet(1);
              AppMethodBeat.o(130293);
            }
          });
          ((com.tencent.mm.plugin.appbrand.k.e)localObject2).start();
        }
      }
    }
    label215:
    AppMethodBeat.o(130302);
  }
  
  public final boolean isDownloading(String paramString)
  {
    AppMethodBeat.i(130299);
    synchronized (this.huc)
    {
      if (this.huc != null)
      {
        if (this.huc.contains(paramString))
        {
          ab.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.huc.size()) });
          this.huh.addAndGet(1);
          AppMethodBeat.o(130299);
          return true;
        }
        AppMethodBeat.o(130299);
        return false;
      }
      AppMethodBeat.o(130299);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */