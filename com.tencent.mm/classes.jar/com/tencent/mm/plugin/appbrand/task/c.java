package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
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
  private static final Queue<r> lUZ;
  private static b mCk;
  private static final HashSet<a> mCl;
  private static final Queue<com.tencent.mm.plugin.appbrand.page.ad> mCm;
  private static volatile AppBrandPreloadProfiler mCn;
  private static volatile e mCo;
  private static volatile boolean mCp;
  private static volatile boolean mCq;
  private static volatile boolean mCr;
  private static volatile int mCs;
  
  static
  {
    AppMethodBeat.i(48405);
    mCk = b.mCz;
    mCl = new HashSet();
    mCm = new ConcurrentLinkedQueue();
    lUZ = new ConcurrentLinkedQueue();
    mCn = null;
    mCo = e.mDg;
    mCp = false;
    mCq = false;
    mCr = false;
    mCs = 2147483647;
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
      paramString1 = bu.x("Unknown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(48397);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(e parame, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(222988);
    if ((mCo != e.mDg) && (mCk != b.mCB))
    {
      parame = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
      AppMethodBeat.o(222988);
      throw parame;
    }
    if ((parame != e.mDg) && (mCk == b.mCB) && (mCo != parame))
    {
      parame = new IllegalStateException("downgraded, but try preload again with a different service");
      AppMethodBeat.o(222988);
      throw parame;
    }
    mCo = parame;
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    mCn = localAppBrandPreloadProfiler;
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.g.yxI;
    if (parame == e.mDf) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.dD(915, i);
      ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      vv(paramInt);
      AppMethodBeat.o(222988);
      return;
    }
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.plugin.expansions.a.cod();
            c.bzu().startTime = SystemClock.elapsedRealtime();
            ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            ar.abe(-2);
            try
            {
              WxaCommLibRuntimeReader.vw();
              com.tencent.mm.plugin.appbrand.jsruntime.ad.bie();
              if (this.jGo == e.mDf)
              {
                c.access$200();
                c.access$300();
                ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              ae.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", new Object[] { Log.getStackTraceString(localThrowable1) });
              c.access$100();
              return;
            }
            localObject = new k(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(222980);
                c.oM(c.1.this.jGr);
                AppMethodBeat.o(222980);
              }
            }, 2);
            local2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48369);
                ar.abe(-8);
                c.LI();
                this.mCu.countDown();
                AppMethodBeat.o(48369);
              }
            };
            if (paramInt < 2) {
              continue;
            }
            if (!x.aYd()) {
              continue;
            }
            ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
            ar.f(local2);
          }
          catch (Throwable localThrowable2)
          {
            Object localObject;
            Runnable local2;
            c.access$100();
            if (!bv.fpT()) {
              break label302;
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                throw localThrowable2;
              }
            });
            return;
            ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: skip preload webView");
            localThrowable2.countDown();
            continue;
          }
          finally
          {
            ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
            ar.abe(10);
            AppMethodBeat.o(48370);
          }
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222983);
              c.access$600();
              this.mCu.countDown();
              AppMethodBeat.o(222983);
            }
          };
          com.tencent.e.h.MqF.f((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          ar.abe(10);
          AppMethodBeat.o(48370);
          return;
          x.a(new x.a()
          {
            public final void aWX()
            {
              AppMethodBeat.i(222981);
              com.tencent.mm.plugin.appbrand.report.quality.a.byG();
              com.tencent.mm.plugin.appbrand.report.quality.b.a(true, null, this.mCv, n.byg());
              ar.f(this.mCw);
              AppMethodBeat.o(222981);
            }
            
            public final void aWY()
            {
              AppMethodBeat.i(222982);
              ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              ar.f(this.mCw);
              AppMethodBeat.o(222982);
            }
          });
        }
        for (;;)
        {
          label302:
          ae.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", localThrowable3, "[NOT CRASH]", new Object[0]);
        }
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222984);
            Iterator localIterator = f.bzC().iterator();
            while (localIterator.hasNext())
            {
              i locali = (i)localIterator.next();
              if (bu.nullAsNil(locali.mDw).equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName)) {
                try
                {
                  locali.mDv.newInstance();
                }
                catch (Throwable localThrowable) {}
              }
            }
            AppMethodBeat.o(222984);
          }
        });
        AppMethodBeat.o(48373);
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
    AppMethodBeat.o(222988);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(222986);
    a(parame, parama, paramBoolean, null, 2);
    AppMethodBeat.o(222986);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(222987);
    ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { parame.name() });
    b localb;
    try
    {
      if (((mCk == b.mCC) || (mCk == b.mCB)) && (paramBoolean)) {
        reset();
      }
      localb = mCk;
      if ((localb == b.mCz) || (localb == b.mCA) || ((localb == b.mCB) && (paramInt >= 2)))
      {
        if (parama != null) {
          mCl.add(parama);
        }
        mCk = b.mCA;
      }
      if (localb == b.mCA)
      {
        AppMethodBeat.o(222987);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(222987);
    }
    if ((localb == b.mCC) || ((localb == b.mCB) && (paramInt < 2)))
    {
      if (parama != null) {
        parama.onReady();
      }
      AppMethodBeat.o(222987);
      return;
    }
    int i;
    if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE) && (!j.DEBUG))
    {
      i = paramInt;
      if (!bv.fpT()) {}
    }
    else
    {
      parama = com.tencent.mm.plugin.appbrand.app.d.jGw;
      parama = com.tencent.mm.plugin.appbrand.app.d.LD();
      i = paramInt;
      if (parama != null)
      {
        i = paramInt;
        if (!parama.getBoolean("is_pre_load_downgrade_env", false)) {
          i = parama.getInt("pre_load_level", 2);
        }
      }
    }
    ae.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: level = %d", new Object[] { Integer.valueOf(i) });
    a(parame, paramAppBrandPreloadProfiler, i);
    AppMethodBeat.o(222987);
  }
  
  public static boolean a(e parame, a parama, String paramString)
  {
    AppMethodBeat.i(222989);
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s], sCacheServices.size[%d], sCachePageView.size[%d], message[%s]", new Object[] { mCk.name(), Integer.valueOf(lUZ.size()), Integer.valueOf(mCm.size()), bu.nullAsNil(paramString) });
        if ((mCk == b.mCA) && (parame == mCo))
        {
          mCl.add(parama);
          mCn.mCj = SystemClock.elapsedRealtime();
          return true;
        }
        if (!a.bzf()) {
          break label255;
        }
        if (mCk == b.mCz)
        {
          ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          mCl.add(parama);
          mCk = b.mCA;
          i = 1;
          if (i != 0)
          {
            a(parame, null, 2);
            AppMethodBeat.o(222989);
            return true;
          }
        }
        else
        {
          if (((mCk != b.mCB) && (mCk != b.mCC)) || ((mCo == parame) && (lUZ.peek() != null))) {
            break label255;
          }
          ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          reset();
          mCl.add(parama);
          mCk = b.mCA;
          i = 1;
          continue;
        }
        AppMethodBeat.o(222989);
      }
      finally
      {
        AppMethodBeat.o(222989);
      }
      return false;
      label255:
      int i = 0;
    }
  }
  
  /* Error */
  public static boolean aYd()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 68	com/tencent/mm/plugin/appbrand/task/c:mCk	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   6: getstatic 328	com/tencent/mm/plugin/appbrand/task/c$b:mCC	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   9: if_acmpeq +16 -> 25
    //   12: getstatic 68	com/tencent/mm/plugin/appbrand/task/c:mCk	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   15: astore_1
    //   16: getstatic 270	com/tencent/mm/plugin/appbrand/task/c$b:mCB	Lcom/tencent/mm/plugin/appbrand/task/c$b;
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
    //   15	6	1	localb1	b
    //   37	5	1	localObject	Object
    //   19	3	2	localb2	b
    // Exception table:
    //   from	to	target	type
    //   3	20	37	finally
  }
  
  public static e bzk()
  {
    try
    {
      e locale = mCo;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bzl()
  {
    try
    {
      AppMethodBeat.i(48384);
      if ((!aYd()) || (lUZ.size() <= 0)) {
        break label96;
      }
      while (!lUZ.isEmpty()) {
        ((r)lUZ.poll()).cleanup();
      }
      if (mCm.isEmpty()) {
        break label88;
      }
    }
    finally {}
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.page.ad)mCm.poll()).cleanup();
    }
    label88:
    a(mCo, null, true);
    label96:
    AppMethodBeat.o(48384);
  }
  
  private static void bzm()
  {
    AppMethodBeat.i(48385);
    if (lUZ.size() > 0)
    {
      AppMethodBeat.o(48385);
      return;
    }
    r localr = (r)org.a.a.bF(mCo.mDi).gCT().object;
    localr.a(WxaCommLibRuntimeReader.baI());
    localr.OC();
    lUZ.add(localr);
    ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { mCo });
    AppMethodBeat.o(48385);
  }
  
  public static com.tencent.mm.vending.g.c<Void> bzn()
  {
    AppMethodBeat.i(48387);
    try
    {
      if (mCk == b.mCA)
      {
        localf = com.tencent.mm.cm.g.fWL();
        Object localObject2 = localf.fSv();
        ((com.tencent.mm.vending.g.b)localObject2).fSu();
        localObject2 = new a()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48374);
            this.cnt.resume();
            AppMethodBeat.o(48374);
          }
        };
        mCl.add(localObject2);
        return localf;
      }
      com.tencent.mm.cm.f localf = com.tencent.mm.cm.g.fWL();
      return localf;
    }
    finally
    {
      AppMethodBeat.o(48387);
    }
  }
  
  public static AppBrandPreloadProfiler bzo()
  {
    return mCn;
  }
  
  public static com.tencent.mm.plugin.appbrand.page.ad bzp()
  {
    AppMethodBeat.i(222992);
    com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)mCm.poll();
    AppMethodBeat.o(222992);
    return localad;
  }
  
  public static r bzq()
  {
    AppMethodBeat.i(48390);
    r localr = (r)lUZ.peek();
    AppMethodBeat.o(48390);
    return localr;
  }
  
  public static boolean bzr()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(48394);
        if (b.mCz == mCk)
        {
          AppMethodBeat.o(48394);
          return bool;
        }
        if ((aYd()) && (mCm.size() <= 0) && (lUZ.size() <= 0))
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
  
  public static boolean bzs()
  {
    AppMethodBeat.i(48395);
    if (WebView.isSys())
    {
      AppMethodBeat.o(48395);
      return true;
    }
    if (WebView.isX5())
    {
      if (WebView.getUsingTbsCoreVersion(ak.getContext()) == 0)
      {
        ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
        AppMethodBeat.o(48395);
        return true;
      }
      if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ak.getContext()))
      {
        ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
        AppMethodBeat.o(48395);
        return true;
      }
    }
    AppMethodBeat.o(48395);
    return false;
  }
  
  public static b bzt()
  {
    AppMethodBeat.i(222995);
    try
    {
      b localb = b.valueOf(mCk.name());
      return localb;
    }
    finally
    {
      AppMethodBeat.o(222995);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c c(e parame)
  {
    AppMethodBeat.i(222990);
    try
    {
      b localb = mCk;
      ae.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, preloadState:%s", new Object[] { localb.name() });
      if ((localb == b.mCz) || (localb == b.mCA))
      {
        ae.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, preloadState:".concat(String.valueOf(localb)));
        AppMethodBeat.o(222990);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(222990);
    }
    if (parame != mCo)
    {
      ae.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, service type not match, serviceType:%s", new Object[] { parame });
      AppMethodBeat.o(222990);
      return null;
    }
    parame = (com.tencent.mm.plugin.appbrand.service.c)lUZ.peek();
    ae.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPreloadedServiceIfAvailable, service:%s", new Object[] { parame });
    AppMethodBeat.o(222990);
    return parame;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c d(e parame)
  {
    AppMethodBeat.i(222991);
    Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
    if (parame == e.mDf) {}
    for (int i = 12;; i = 10)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).dD(915, i);
      try
      {
        localObject = mCk;
        if (localObject != b.mCz) {
          break;
        }
        ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader not preload, just return null");
        AppMethodBeat.o(222991);
        return null;
      }
      finally
      {
        AppMethodBeat.o(222991);
      }
    }
    if (localObject == b.mCA)
    {
      if ((j.IS_FLAVOR_RED) || (j.DEBUG))
      {
        parame = new IllegalStateException("getServices when preloading");
        AppMethodBeat.o(222991);
        throw parame;
      }
      ae.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
      AppMethodBeat.o(222991);
      return null;
    }
    if (parame != mCo)
    {
      ae.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
      AppMethodBeat.o(222991);
      return null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.service.c)lUZ.poll();
    com.tencent.mm.plugin.report.service.g localg;
    if (localObject != null)
    {
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (parame != e.mDf) {
        break label213;
      }
    }
    label213:
    for (i = 7;; i = 2)
    {
      localg.dD(915, i);
      AppMethodBeat.o(222991);
      return localObject;
    }
  }
  
  public static r e(e parame)
  {
    AppMethodBeat.i(48391);
    if (e.mDg == parame)
    {
      AppMethodBeat.o(48391);
      return null;
    }
    Iterator localIterator = lUZ.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getClass() == parame.mDi)
      {
        AppMethodBeat.o(48391);
        return localr;
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
      mCk = b.mCz;
      mCl.clear();
      mCm.clear();
      lUZ.clear();
      mCn = null;
      mCo = e.mDg;
      AppMethodBeat.o(48381);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void vu(int paramInt)
  {
    AppMethodBeat.i(222993);
    if (ar.isMainThread())
    {
      vv(paramInt);
      AppMethodBeat.o(222993);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48375);
        c.vw(this.jGr);
        AppMethodBeat.o(48375);
      }
    });
    AppMethodBeat.o(222993);
  }
  
  private static void vv(int paramInt)
  {
    AppMethodBeat.i(222994);
    ae.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished");
    mCn.bzj();
    AppBrandPreloadProfiler.w(new d.g.a.a() {});
    Object localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
    int i;
    if (mCo == e.mDf)
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
        mCk = b.mCC;
        localObject1 = new LinkedList(mCl);
        mCl.clear();
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
        AppMethodBeat.o(222994);
      }
      mCk = b.mCB;
    }
    label154:
    com.tencent.mm.sdk.f.c.a(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.c.a(c.bzv());
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(222994);
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(48380);
      mCz = new b("NOT_PRELOAD", 0);
      mCA = new b("PRELOADING", 1);
      mCB = new b("PRELOADED_DOWNGRADE", 2);
      mCC = new b("PRELOADED_FULL", 3);
      mCD = new b[] { mCz, mCA, mCB, mCC };
      AppMethodBeat.o(48380);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */