package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.o.e.b;
import com.tencent.mm.plugin.appbrand.o.e.c;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.b.a;
import com.tencent.mm.plugin.appbrand.q.m;
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
  private static volatile d jsk;
  public boolean hasInit;
  public o joZ;
  public m jsl;
  public com.tencent.mm.plugin.appbrand.q.a jsm;
  public p jsn;
  public c jso;
  public CopyOnWriteArrayList<String> jsp;
  public boolean jsq;
  public boolean jsr;
  public AtomicInteger jss;
  public AtomicInteger jst;
  public AtomicInteger jsu;
  public AtomicInteger jsv;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.jsp = new CopyOnWriteArrayList();
    this.jsq = false;
    this.jsr = false;
    AppMethodBeat.o(45286);
  }
  
  public static void B(o paramo)
  {
    AppMethodBeat.i(195777);
    Iterator localIterator;
    try
    {
      if ((jsk == null) || (jsk.joZ != paramo)) {
        break label180;
      }
      if (jsk.jsl == null) {
        break label176;
      }
      paramo = jsk.jsl;
      synchronized (paramo.kUF)
      {
        localIterator = paramo.kUF.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).isRunning = false;
        }
      }
      paramo.kUF.clear();
    }
    finally
    {
      AppMethodBeat.o(195777);
    }
    synchronized (paramo.kVC)
    {
      localIterator = paramo.kVC.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).isRunning = false;
      }
    }
    paramo.kVC.clear();
    jsk.joZ = null;
    label176:
    jsk = null;
    label180:
    AppMethodBeat.o(195777);
  }
  
  public static String aEB()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.q.c.bim();
    localObject = com.tencent.mm.plugin.appbrand.q.c.bil();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static d aWV()
  {
    AppMethodBeat.i(45287);
    if (jsk == null) {}
    try
    {
      if (jsk == null) {
        jsk = new d();
      }
      d locald = jsk;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static void fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.aWX().jsF = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public final void aWW()
  {
    AppMethodBeat.i(45290);
    if ((this.jsp != null) && (this.jsp.size() == 0))
    {
      if ((this.joZ == null) || (this.joZ.getAppConfig() == null))
      {
        ad.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.joZ.getAppConfig().jbs;
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
            break label257;
          }
          final String str = (String)((Iterator)localObject1).next();
          ad.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str });
          be.T(this.joZ);
          if ((this.joZ == null) || (this.joZ.aNb() == null))
          {
            ad.e("MicroMsg.WAGamePreloadManager", "runtime or sysConfig null");
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          Object localObject2 = this.joZ.aNb().jdS.bV(this.joZ.mAppId, str);
          i.aEN(str);
          if (e.c.kTR == null)
          {
            ad.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
          }
          else
          {
            localObject2 = e.c.kTR.j(this.joZ, (String)localObject2);
            ((com.tencent.mm.plugin.appbrand.o.e)localObject2).a(new e.b()
            {
              public final void Hz(String paramAnonymousString)
              {
                AppMethodBeat.i(45282);
                ad.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                d.a(d.this).addAndGet(1);
                AppMethodBeat.o(45282);
              }
              
              public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(195776);
                ad.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { str });
                d.a(d.this).addAndGet(1);
                AppMethodBeat.o(195776);
              }
              
              public final void a(com.tencent.mm.plugin.appbrand.o.c paramAnonymousc)
              {
                AppMethodBeat.i(45283);
                ad.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                AppMethodBeat.o(45283);
              }
            });
            ((com.tencent.mm.plugin.appbrand.o.e)localObject2).start();
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
    synchronized (this.jsp)
    {
      if (this.jsp != null)
      {
        if (this.jsp.contains(paramString))
        {
          ad.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.jsp.size()) });
          this.jsv.addAndGet(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */