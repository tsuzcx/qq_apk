package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.m.e.b;
import com.tencent.mm.plugin.appbrand.m.e.c;
import com.tencent.mm.plugin.appbrand.o.a.b;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  private static volatile d kqi;
  public boolean hasInit;
  public p jFm;
  public com.tencent.mm.plugin.appbrand.o.m kqj;
  public com.tencent.mm.plugin.appbrand.o.a kqk;
  public q kql;
  public c kqm;
  public CopyOnWriteArrayList<String> kqn;
  public boolean kqo;
  public boolean kqp;
  public AtomicInteger kqq;
  public AtomicInteger kqr;
  public AtomicInteger kqs;
  public AtomicInteger kqt;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.kqn = new CopyOnWriteArrayList();
    this.kqo = false;
    this.kqp = false;
    AppMethodBeat.o(45286);
  }
  
  public static String aOZ()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.btQ();
    localObject = com.tencent.mm.plugin.appbrand.o.c.btP();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static d bif()
  {
    AppMethodBeat.i(45287);
    if (kqi == null) {}
    try
    {
      if (kqi == null) {
        kqi = new d();
      }
      d locald = kqi;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.bih().kqD = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public static void t(p paramp)
  {
    AppMethodBeat.i(222362);
    Iterator localIterator;
    try
    {
      if ((kqi == null) || (kqi.jFm != paramp)) {
        break label180;
      }
      if (kqi.kqj == null) {
        break label176;
      }
      paramp = kqi.kqj;
      synchronized (paramp.mag)
      {
        localIterator = paramp.mag.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).isRunning = false;
        }
      }
      paramp.mag.clear();
    }
    finally
    {
      AppMethodBeat.o(222362);
    }
    synchronized (paramp.mbg)
    {
      localIterator = paramp.mbg.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).isRunning = false;
      }
    }
    paramp.mbg.clear();
    kqi.jFm = null;
    label176:
    kqi = null;
    label180:
    AppMethodBeat.o(222362);
  }
  
  public final void big()
  {
    AppMethodBeat.i(45290);
    if ((this.kqn != null) && (this.kqn.size() == 0))
    {
      if ((this.jFm == null) || (this.jFm.getAppConfig() == null))
      {
        ae.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.jFm.getAppConfig().jYS;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        ae.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
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
          ae.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str1 });
          Object localObject2 = this.jFm;
          if ((localObject2 == null) || (((p)localObject2).aXw() == null))
          {
            ae.e("MicroMsg.WAGamePreloadManager", "runtime(%s) or sysConfig null", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          if ((((AppBrandRuntime)localObject2).SB) || (((p)localObject2).isDestroyed()))
          {
            ae.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
          }
          else
          {
            bg.L((AppBrandRuntime)localObject2);
            String str2 = ((p)localObject2).aXw().kbw.ch(((AppBrandRuntime)localObject2).mAppId, str1);
            o.aRh(str1);
            if (e.c.lZi == null)
            {
              ae.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            }
            else
            {
              localObject2 = e.c.lZi.j((AppBrandRuntime)localObject2, str2);
              ((com.tencent.mm.plugin.appbrand.m.e)localObject2).a(new e.b()
              {
                public final void PF(String paramAnonymousString)
                {
                  AppMethodBeat.i(45282);
                  ae.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str1, paramAnonymousString });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(45282);
                }
                
                public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
                {
                  AppMethodBeat.i(222361);
                  ae.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { str1 });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(222361);
                }
                
                public final void a(com.tencent.mm.plugin.appbrand.m.c paramAnonymousc)
                {
                  AppMethodBeat.i(45283);
                  ae.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
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
    synchronized (this.kqn)
    {
      if (this.kqn != null)
      {
        if (this.kqn.contains(paramString))
        {
          ae.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.kqn.size()) });
          this.kqt.addAndGet(1);
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