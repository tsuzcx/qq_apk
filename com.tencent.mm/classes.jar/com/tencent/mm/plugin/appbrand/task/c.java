package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebView;
import d.z;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  private static final Queue<q> lQy;
  private static c.b mxn;
  private static final HashSet<a> mxo;
  private static final Queue<ae> mxp;
  private static volatile AppBrandPreloadProfiler mxq;
  private static volatile e mxr;
  private static volatile boolean mxs;
  private static volatile boolean mxt;
  private static volatile boolean mxu;
  private static volatile int mxv;
  
  static
  {
    AppMethodBeat.i(48405);
    mxn = c.b.mxC;
    mxo = new HashSet();
    mxp = new ConcurrentLinkedQueue();
    lQy = new ConcurrentLinkedQueue();
    mxq = null;
    mxr = e.myi;
    mxs = false;
    mxt = false;
    mxu = false;
    mxv = 2147483647;
    AppMethodBeat.o(48405);
  }
  
  private static String a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(48397);
    if ((paramLong1 != 9223372036854775807L) && (paramLong2 != 9223372036854775807L))
    {
      AppMethodBeat.o(48397);
      return String.valueOf(paramLong2 - paramLong1);
    }
    String str1;
    if (paramLong1 == 9223372036854775807L)
    {
      str1 = "?";
      if (paramLong2 != 9223372036854775807L) {
        break label100;
      }
    }
    label100:
    for (String str2 = "?";; str2 = "ok")
    {
      paramString1 = bt.x("Unknown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(48397);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(e parame, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(188769);
    if ((mxr != e.myi) && (mxn != c.b.mxE))
    {
      parame = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
      AppMethodBeat.o(188769);
      throw parame;
    }
    if ((parame != e.myi) && (mxn == c.b.mxE) && (mxr != parame))
    {
      parame = new IllegalStateException("downgraded, but try preload again with a different service");
      AppMethodBeat.o(188769);
      throw parame;
    }
    mxr = parame;
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    mxq = localAppBrandPreloadProfiler;
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.g.yhR;
    if (parame == e.myh) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.dD(915, i);
      ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      vq(paramInt);
      AppMethodBeat.o(188769);
      return;
    }
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.plugin.expansions.a.cmN();
            c.byA().startTime = SystemClock.elapsedRealtime();
            ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            aq.aay(-2);
            try
            {
              WxaCommLibRuntimeReader.vw();
              ac.bhw();
              if (this.jDq == e.myh)
              {
                c.access$200();
                c.access$300();
                ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              ad.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", new Object[] { Log.getStackTraceString(localThrowable1) });
              c.access$100();
              return;
            }
            localObject = new j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(188761);
                c.oJ(c.1.this.jDt);
                AppMethodBeat.o(188761);
              }
            }, 2);
            local2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48369);
                aq.aay(-8);
                c.LA();
                this.mxx.countDown();
                AppMethodBeat.o(48369);
              }
            };
            if (paramInt < 2) {
              continue;
            }
            if (!x.aXK()) {
              continue;
            }
            ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
            aq.f(local2);
          }
          catch (Throwable localThrowable2)
          {
            Object localObject;
            Runnable local2;
            c.access$100();
            if (!bu.flY()) {
              break label302;
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                throw localThrowable2;
              }
            });
            return;
            ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: skip preload webView");
            localThrowable2.countDown();
            continue;
          }
          finally
          {
            ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
            aq.aay(10);
            AppMethodBeat.o(48370);
          }
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188764);
              c.access$600();
              this.mxx.countDown();
              AppMethodBeat.o(188764);
            }
          };
          com.tencent.e.h.LTJ.f((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          aq.aay(10);
          AppMethodBeat.o(48370);
          return;
          x.a(new x.a()
          {
            public final void aWv()
            {
              AppMethodBeat.i(188762);
              com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
              com.tencent.mm.plugin.appbrand.report.quality.b.a(true, null, this.mxy, n.bxn());
              aq.f(this.mxz);
              AppMethodBeat.o(188762);
            }
            
            public final void aWw()
            {
              AppMethodBeat.i(188763);
              ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              aq.f(this.mxz);
              AppMethodBeat.o(188763);
            }
          });
        }
        for (;;)
        {
          label302:
          ad.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", localThrowable3, "[NOT CRASH]", new Object[0]);
        }
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188765);
            Iterator localIterator = f.byH().iterator();
            while (localIterator.hasNext())
            {
              i locali = (i)localIterator.next();
              if (bt.nullAsNil(locali.myy).equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName)) {
                try
                {
                  locali.myx.newInstance();
                }
                catch (Throwable localThrowable) {}
              }
            }
            AppMethodBeat.o(188765);
          }
        });
        AppMethodBeat.o(48373);
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
    AppMethodBeat.o(188769);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(188767);
    a(parame, parama, paramBoolean, null, 2);
    AppMethodBeat.o(188767);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(188768);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { parame.name() });
    c.b localb;
    try
    {
      if (((mxn == c.b.mxF) || (mxn == c.b.mxE)) && (paramBoolean)) {
        reset();
      }
      localb = mxn;
      if ((localb == c.b.mxC) || (localb == c.b.mxD) || ((localb == c.b.mxE) && (paramInt >= 2)))
      {
        if (parama != null) {
          mxo.add(parama);
        }
        mxn = c.b.mxD;
      }
      if (localb == c.b.mxD)
      {
        AppMethodBeat.o(188768);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(188768);
    }
    if ((localb == c.b.mxF) || ((localb == c.b.mxE) && (paramInt < 2)))
    {
      if (parama != null) {
        parama.onReady();
      }
      AppMethodBeat.o(188768);
      return;
    }
    int i;
    if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.i.DEBUG))
    {
      i = paramInt;
      if (!bu.flY()) {}
    }
    else
    {
      parama = com.tencent.mm.plugin.appbrand.app.d.jDy;
      parama = com.tencent.mm.plugin.appbrand.app.d.Lv();
      i = paramInt;
      if (parama != null)
      {
        i = paramInt;
        if (!parama.getBoolean("is_pre_load_downgrade_env", false)) {
          i = parama.getInt("pre_load_level", 2);
        }
      }
    }
    ad.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: level = %d", new Object[] { Integer.valueOf(i) });
    a(parame, paramAppBrandPreloadProfiler, i);
    AppMethodBeat.o(188768);
  }
  
  public static boolean a(e parame, a parama, String paramString)
  {
    AppMethodBeat.i(188770);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s], sCacheServices.size[%d], sCachePageView.size[%d], message[%s]", new Object[] { mxn.name(), Integer.valueOf(lQy.size()), Integer.valueOf(mxp.size()), bt.nullAsNil(paramString) });
        if ((mxn == c.b.mxD) && (parame == mxr))
        {
          mxo.add(parama);
          mxq.mxm = SystemClock.elapsedRealtime();
          return true;
        }
        if (!a.bym()) {
          break label255;
        }
        if (mxn == c.b.mxC)
        {
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          mxo.add(parama);
          mxn = c.b.mxD;
          i = 1;
          if (i != 0)
          {
            a(parame, null, 2);
            AppMethodBeat.o(188770);
            return true;
          }
        }
        else
        {
          if (((mxn != c.b.mxE) && (mxn != c.b.mxF)) || ((mxr == parame) && (lQy.peek() != null))) {
            break label255;
          }
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          reset();
          mxo.add(parama);
          mxn = c.b.mxD;
          i = 1;
          continue;
        }
        AppMethodBeat.o(188770);
      }
      finally
      {
        AppMethodBeat.o(188770);
      }
      return false;
      label255:
      int i = 0;
    }
  }
  
  /* Error */
  public static boolean aXK()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/tencent/mm/plugin/appbrand/task/c:mxn	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   6: getstatic 325	com/tencent/mm/plugin/appbrand/task/c$b:mxF	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   9: if_acmpeq +16 -> 25
    //   12: getstatic 65	com/tencent/mm/plugin/appbrand/task/c:mxn	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   15: astore_1
    //   16: getstatic 267	com/tencent/mm/plugin/appbrand/task/c$b:mxE	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   19: astore_2
    //   20: aload_1
    //   21: aload_2
    //   22: if_acmpne +10 -> 32
    //   25: iconst_1
    //   26: istore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_0
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_0
    //   34: goto -7 -> 27
    //   37: astore_1
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	8	0	bool	boolean
    //   15	6	1	localb1	c.b
    //   37	5	1	localObject	Object
    //   19	3	2	localb2	c.b
    // Exception table:
    //   from	to	target	type
    //   3	20	37	finally
  }
  
  public static e byr()
  {
    try
    {
      e locale = mxr;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bys()
  {
    try
    {
      AppMethodBeat.i(48384);
      if ((!aXK()) || (lQy.size() <= 0)) {
        break label96;
      }
      while (!lQy.isEmpty()) {
        ((q)lQy.poll()).cleanup();
      }
      if (mxp.isEmpty()) {
        break label88;
      }
    }
    finally {}
    for (;;)
    {
      ((ae)mxp.poll()).cleanup();
    }
    label88:
    a(mxr, null, true);
    label96:
    AppMethodBeat.o(48384);
  }
  
  private static void byt()
  {
    AppMethodBeat.i(48385);
    if (lQy.size() > 0)
    {
      AppMethodBeat.o(48385);
      return;
    }
    q localq = (q)org.a.a.bF(mxr.myk).gyr().object;
    localq.a(WxaCommLibRuntimeReader.baj());
    localq.OE();
    lQy.add(localq);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { mxr });
    AppMethodBeat.o(48385);
  }
  
  public static com.tencent.mm.vending.g.c<Void> byu()
  {
    AppMethodBeat.i(48387);
    try
    {
      if (mxn == c.b.mxD)
      {
        localf = com.tencent.mm.cn.g.fSm();
        Object localObject2 = localf.fOa();
        ((com.tencent.mm.vending.g.b)localObject2).fNZ();
        localObject2 = new c.3((com.tencent.mm.vending.g.b)localObject2);
        mxo.add(localObject2);
        return localf;
      }
      com.tencent.mm.cn.f localf = com.tencent.mm.cn.g.fSm();
      return localf;
    }
    finally
    {
      AppMethodBeat.o(48387);
    }
  }
  
  public static AppBrandPreloadProfiler byv()
  {
    return mxq;
  }
  
  public static ae byw()
  {
    AppMethodBeat.i(188773);
    ae localae = (ae)mxp.poll();
    AppMethodBeat.o(188773);
    return localae;
  }
  
  public static q byx()
  {
    AppMethodBeat.i(48390);
    q localq = (q)lQy.peek();
    AppMethodBeat.o(48390);
    return localq;
  }
  
  public static boolean byy()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(48394);
        if (c.b.mxC == mxn)
        {
          AppMethodBeat.o(48394);
          return bool;
        }
        if ((aXK()) && (mxp.size() <= 0) && (lQy.size() <= 0))
        {
          AppMethodBeat.o(48394);
          continue;
        }
        bool = false;
      }
      finally {}
      AppMethodBeat.o(48394);
    }
  }
  
  public static boolean byz()
  {
    AppMethodBeat.i(48395);
    if (WebView.isSys())
    {
      AppMethodBeat.o(48395);
      return true;
    }
    if (WebView.isX5())
    {
      if (WebView.getUsingTbsCoreVersion(aj.getContext()) == 0)
      {
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
        AppMethodBeat.o(48395);
        return true;
      }
      if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(aj.getContext()))
      {
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
        AppMethodBeat.o(48395);
        return true;
      }
    }
    AppMethodBeat.o(48395);
    return false;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c c(e parame)
  {
    AppMethodBeat.i(188771);
    try
    {
      c.b localb = mxn;
      ad.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, preloadState:%s", new Object[] { localb.name() });
      if ((localb == c.b.mxC) || (localb == c.b.mxD))
      {
        AppMethodBeat.o(188771);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(188771);
    }
    if (parame != mxr)
    {
      ad.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, service type not match, serviceType:%s", new Object[] { parame });
      AppMethodBeat.o(188771);
      return null;
    }
    parame = (com.tencent.mm.plugin.appbrand.service.c)lQy.peek();
    ad.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, service:%s", new Object[] { parame });
    AppMethodBeat.o(188771);
    return parame;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c d(e parame)
  {
    AppMethodBeat.i(188772);
    Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
    if (parame == e.myh) {}
    for (int i = 12;; i = 10)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).dD(915, i);
      try
      {
        localObject = mxn;
        if (localObject != c.b.mxC) {
          break;
        }
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader not preload, just return null");
        AppMethodBeat.o(188772);
        return null;
      }
      finally
      {
        AppMethodBeat.o(188772);
      }
    }
    if (localObject == c.b.mxD)
    {
      if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
      {
        parame = new IllegalStateException("getServices when preloading");
        AppMethodBeat.o(188772);
        throw parame;
      }
      ad.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
      AppMethodBeat.o(188772);
      return null;
    }
    if (parame != mxr)
    {
      ad.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
      AppMethodBeat.o(188772);
      return null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.service.c)lQy.poll();
    com.tencent.mm.plugin.report.service.g localg;
    if (localObject != null)
    {
      localg = com.tencent.mm.plugin.report.service.g.yhR;
      if (parame != e.myh) {
        break label213;
      }
    }
    label213:
    for (i = 7;; i = 2)
    {
      localg.dD(915, i);
      AppMethodBeat.o(188772);
      return localObject;
    }
  }
  
  public static q e(e parame)
  {
    AppMethodBeat.i(48391);
    if (e.myi == parame)
    {
      AppMethodBeat.o(48391);
      return null;
    }
    Iterator localIterator = lQy.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.getClass() == parame.myk)
      {
        AppMethodBeat.o(48391);
        return localq;
      }
    }
    AppMethodBeat.o(48391);
    return null;
  }
  
  private static void reset()
  {
    try
    {
      AppMethodBeat.i(48381);
      mxn = c.b.mxC;
      mxo.clear();
      mxp.clear();
      lQy.clear();
      mxq = null;
      mxr = e.myi;
      AppMethodBeat.o(48381);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void vp(int paramInt)
  {
    AppMethodBeat.i(188774);
    if (aq.isMainThread())
    {
      vq(paramInt);
      AppMethodBeat.o(188774);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48375);
        c.vr(this.jDt);
        AppMethodBeat.o(48375);
      }
    });
    AppMethodBeat.o(188774);
  }
  
  private static void vq(int paramInt)
  {
    AppMethodBeat.i(188775);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished");
    mxq.byq();
    AppBrandPreloadProfiler.v(new d.g.a.a() {});
    Object localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
    int i;
    if (mxr == e.myh)
    {
      i = 6;
      ((com.tencent.mm.plugin.report.service.g)localObject1).dD(915, i);
      if (paramInt != 2) {
        break label133;
      }
    }
    for (;;)
    {
      try
      {
        mxn = c.b.mxF;
        localObject1 = new LinkedList(mxo);
        mxo.clear();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label154;
        }
        a locala = (a)((Iterator)localObject1).next();
        if (locala == null) {
          continue;
        }
        locala.onReady();
        continue;
        i = 1;
        break;
      }
      finally
      {
        label133:
        AppMethodBeat.o(188775);
      }
      mxn = c.b.mxE;
    }
    label154:
    com.tencent.mm.sdk.f.c.a(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.d.a(c.byB());
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(188775);
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */