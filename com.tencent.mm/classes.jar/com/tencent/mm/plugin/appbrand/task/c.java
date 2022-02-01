package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebView;
import d.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  private static final Queue<ae> lXA;
  private static volatile AppBrandPreloadProfiler lXB;
  private static volatile e lXC;
  private static volatile boolean lXD;
  private static volatile boolean lXE;
  private static volatile boolean lXF;
  private static volatile int lXG;
  private static b lXy;
  private static final HashSet<a> lXz;
  private static final Queue<q> lro;
  
  static
  {
    AppMethodBeat.i(48405);
    lXy = b.lXN;
    lXz = new HashSet();
    lXA = new ConcurrentLinkedQueue();
    lro = new ConcurrentLinkedQueue();
    lXB = null;
    lXC = e.lYt;
    lXD = false;
    lXE = false;
    lXF = false;
    lXG = 2147483647;
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
      paramString1 = bs.u("Unknown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(48397);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(e parame, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(186966);
    if ((lXC != e.lYt) && (lXy != b.lXP))
    {
      parame = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
      AppMethodBeat.o(186966);
      throw parame;
    }
    if ((parame != e.lYt) && (lXy == b.lXP) && (lXC != parame))
    {
      parame = new IllegalStateException("downgraded, but try preload again with a different service");
      AppMethodBeat.o(186966);
      throw parame;
    }
    lXC = parame;
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    lXB = localAppBrandPreloadProfiler;
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.h.wUl;
    if (parame == e.lYs) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.dB(915, i);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      uM(paramInt);
      AppMethodBeat.o(186966);
      return;
    }
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.plugin.expansions.a.cij();
            c.buv().startTime = SystemClock.elapsedRealtime();
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            ap.Yt(-2);
            try
            {
              WxaCommLibRuntimeReader.tX();
              com.tencent.mm.plugin.appbrand.jsruntime.ac.bdS();
              if (this.jjC == e.lYs)
              {
                c.access$200();
                c.access$300();
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", new Object[] { Log.getStackTraceString(localThrowable1) });
              c.access$100();
              return;
            }
            localObject = new j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186958);
                c.oj(c.1.this.jjF);
                AppMethodBeat.o(186958);
              }
            }, 2);
            local2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48369);
                ap.Yt(-8);
                c.Kb();
                this.lXI.countDown();
                AppMethodBeat.o(48369);
              }
            };
            if (paramInt < 2) {
              continue;
            }
            if (!x.aUy()) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
            ap.f(local2);
          }
          catch (Throwable localThrowable2)
          {
            Object localObject;
            Runnable local2;
            c.access$100();
            if (!bt.eWo()) {
              break label302;
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                throw localThrowable2;
              }
            });
            return;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: skip preload webView");
            localThrowable2.countDown();
            continue;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
            ap.Yt(10);
            AppMethodBeat.o(48370);
          }
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186961);
              c.access$600();
              this.lXI.countDown();
              AppMethodBeat.o(186961);
            }
          };
          com.tencent.e.h.JZN.f((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          ap.Yt(10);
          AppMethodBeat.o(48370);
          return;
          x.a(new x.a()
          {
            public final void aTn()
            {
              AppMethodBeat.i(186959);
              com.tencent.mm.plugin.appbrand.report.quality.a.btI();
              com.tencent.mm.plugin.appbrand.report.quality.b.a(true, null, this.lXJ, m.bti());
              ap.f(this.lXK);
              AppMethodBeat.o(186959);
            }
            
            public final void aTo()
            {
              AppMethodBeat.i(186960);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              ap.f(this.lXK);
              AppMethodBeat.o(186960);
            }
          });
        }
        for (;;)
        {
          label302:
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", localThrowable3, "[NOT CRASH]", new Object[0]);
        }
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186962);
            Iterator localIterator = f.buD().iterator();
            while (localIterator.hasNext())
            {
              i locali = (i)localIterator.next();
              if (bs.nullAsNil(locali.lYI).equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).mProcessName)) {
                try
                {
                  locali.lYH.newInstance();
                }
                catch (Throwable localThrowable) {}
              }
            }
            AppMethodBeat.o(186962);
          }
        });
        AppMethodBeat.o(48373);
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
    AppMethodBeat.o(186966);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(186964);
    a(parame, parama, paramBoolean, null, 2);
    AppMethodBeat.o(186964);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(186965);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { parame.name() });
    b localb;
    try
    {
      if (((lXy == b.lXQ) || (lXy == b.lXP)) && (paramBoolean)) {
        reset();
      }
      localb = lXy;
      if ((localb == b.lXN) || (localb == b.lXO) || ((localb == b.lXP) && (paramInt >= 2)))
      {
        if (parama != null) {
          lXz.add(parama);
        }
        lXy = b.lXO;
      }
      if (localb == b.lXO)
      {
        AppMethodBeat.o(186965);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(186965);
    }
    if ((localb == b.lXQ) || ((localb == b.lXP) && (paramInt < 2)))
    {
      if (parama != null) {
        parama.onReady();
      }
      AppMethodBeat.o(186965);
      return;
    }
    int i;
    if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      i = paramInt;
      if (!bt.eWo()) {}
    }
    else
    {
      parama = com.tencent.mm.plugin.appbrand.app.d.jjJ;
      parama = com.tencent.mm.plugin.appbrand.app.d.JW();
      i = paramInt;
      if (parama != null)
      {
        i = paramInt;
        if (!parama.getBoolean("is_pre_load_downgrade_env", false)) {
          i = parama.getInt("pre_load_level", 2);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: level = %d", new Object[] { Integer.valueOf(i) });
    a(parame, paramAppBrandPreloadProfiler, i);
    AppMethodBeat.o(186965);
  }
  
  public static boolean a(e parame, a parama)
  {
    AppMethodBeat.i(48386);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", new Object[] { lXy.name() });
        if ((lXy == b.lXO) && (parame == lXC))
        {
          lXz.add(parama);
          lXB.lXx = SystemClock.elapsedRealtime();
          return true;
        }
        if (!a.buh()) {
          break label220;
        }
        if (lXy == b.lXN)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          lXz.add(parama);
          lXy = b.lXO;
          i = 1;
          if (i != 0)
          {
            a(parame, null, 2);
            AppMethodBeat.o(48386);
            return true;
          }
        }
        else
        {
          if (((lXy != b.lXP) && (lXy != b.lXQ)) || ((lXC == parame) && (lro.peek() != null))) {
            break label220;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          reset();
          lXz.add(parama);
          lXy = b.lXO;
          i = 1;
          continue;
        }
        AppMethodBeat.o(48386);
      }
      finally
      {
        AppMethodBeat.o(48386);
      }
      return false;
      label220:
      int i = 0;
    }
  }
  
  /* Error */
  public static boolean aUy()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 68	com/tencent/mm/plugin/appbrand/task/c:lXy	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   6: getstatic 328	com/tencent/mm/plugin/appbrand/task/c$b:lXQ	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   9: if_acmpeq +16 -> 25
    //   12: getstatic 68	com/tencent/mm/plugin/appbrand/task/c:lXy	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   15: astore_1
    //   16: getstatic 270	com/tencent/mm/plugin/appbrand/task/c$b:lXP	Lcom/tencent/mm/plugin/appbrand/task/c$b;
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
  
  public static void bum()
  {
    try
    {
      AppMethodBeat.i(48384);
      if ((!aUy()) || (lro.size() <= 0)) {
        break label96;
      }
      while (!lro.isEmpty()) {
        ((q)lro.poll()).cleanup();
      }
      if (lXA.isEmpty()) {
        break label88;
      }
    }
    finally {}
    for (;;)
    {
      ((ae)lXA.poll()).cleanup();
    }
    label88:
    a(lXC, null, true);
    label96:
    AppMethodBeat.o(48384);
  }
  
  private static void bun()
  {
    AppMethodBeat.i(48385);
    if (lro.size() > 0)
    {
      AppMethodBeat.o(48385);
      return;
    }
    q localq = (q)org.a.a.bD(lXC.lYv).gfN().object;
    localq.a(WxaCommLibRuntimeReader.aWM());
    localq.MV();
    lro.add(localq);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { lXC });
    AppMethodBeat.o(48385);
  }
  
  public static com.tencent.mm.vending.g.c<Void> buo()
  {
    AppMethodBeat.i(48387);
    try
    {
      if (lXy == b.lXO)
      {
        localf = com.tencent.mm.cn.g.fBc();
        Object localObject2 = localf.fxn();
        ((com.tencent.mm.vending.g.b)localObject2).fxm();
        localObject2 = new a()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48374);
            this.cda.resume();
            AppMethodBeat.o(48374);
          }
        };
        lXz.add(localObject2);
        return localf;
      }
      com.tencent.mm.cn.f localf = com.tencent.mm.cn.g.fBc();
      return localf;
    }
    finally
    {
      AppMethodBeat.o(48387);
    }
  }
  
  public static AppBrandPreloadProfiler bup()
  {
    return lXB;
  }
  
  public static ae buq()
  {
    AppMethodBeat.i(186968);
    ae localae = (ae)lXA.poll();
    AppMethodBeat.o(186968);
    return localae;
  }
  
  public static q bur()
  {
    AppMethodBeat.i(48390);
    q localq = (q)lro.peek();
    AppMethodBeat.o(48390);
    return localq;
  }
  
  /* Error */
  public static boolean bus()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 577
    //   6: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 505	com/tencent/mm/plugin/appbrand/task/c:aUy	()Z
    //   12: ifeq +27 -> 39
    //   15: getstatic 82	com/tencent/mm/plugin/appbrand/task/c:lro	Ljava/util/Queue;
    //   18: invokeinterface 127 1 0
    //   23: ifle +16 -> 39
    //   26: iconst_1
    //   27: istore_0
    //   28: ldc_w 577
    //   31: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_0
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_0
    //   41: ldc_w 577
    //   44: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -13 -> 34
    //   50: astore_1
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	14	0	bool	boolean
    //   50	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	26	50	finally
    //   28	34	50	finally
    //   41	47	50	finally
  }
  
  public static boolean but()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(48394);
        if (b.lXN == lXy)
        {
          AppMethodBeat.o(48394);
          return bool;
        }
        if ((aUy()) && (lXA.size() <= 0) && (lro.size() <= 0))
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
  
  public static boolean buu()
  {
    AppMethodBeat.i(48395);
    if (WebView.isSys())
    {
      AppMethodBeat.o(48395);
      return true;
    }
    if (WebView.isX5())
    {
      if (WebView.getUsingTbsCoreVersion(ai.getContext()) == 0)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
        AppMethodBeat.o(48395);
        return true;
      }
      if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ai.getContext()))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
        AppMethodBeat.o(48395);
        return true;
      }
    }
    AppMethodBeat.o(48395);
    return false;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c c(e parame)
  {
    AppMethodBeat.i(186967);
    Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
    if (parame == e.lYs) {}
    for (int i = 12;; i = 10)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).dB(915, i);
      try
      {
        localObject = lXy;
        if (localObject != b.lXN) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader not preload, just return null");
        AppMethodBeat.o(186967);
        return null;
      }
      finally
      {
        AppMethodBeat.o(186967);
      }
    }
    if (localObject == b.lXO)
    {
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        parame = new IllegalStateException("getServices when preloading");
        AppMethodBeat.o(186967);
        throw parame;
      }
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
      AppMethodBeat.o(186967);
      return null;
    }
    if (parame != lXC)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
      AppMethodBeat.o(186967);
      return null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.service.c)lro.poll();
    com.tencent.mm.plugin.report.service.h localh;
    if (localObject != null)
    {
      localh = com.tencent.mm.plugin.report.service.h.wUl;
      if (parame != e.lYs) {
        break label213;
      }
    }
    label213:
    for (i = 7;; i = 2)
    {
      localh.dB(915, i);
      AppMethodBeat.o(186967);
      return localObject;
    }
  }
  
  public static q d(e parame)
  {
    AppMethodBeat.i(48391);
    if (e.lYt == parame)
    {
      AppMethodBeat.o(48391);
      return null;
    }
    Iterator localIterator = lro.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.getClass() == parame.lYv)
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
      lXy = b.lXN;
      lXz.clear();
      lXA.clear();
      lro.clear();
      lXB = null;
      lXC = e.lYt;
      AppMethodBeat.o(48381);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void uL(int paramInt)
  {
    AppMethodBeat.i(186969);
    if (ap.isMainThread())
    {
      uM(paramInt);
      AppMethodBeat.o(186969);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48375);
        c.uN(this.jjF);
        AppMethodBeat.o(48375);
      }
    });
    AppMethodBeat.o(186969);
  }
  
  private static void uM(int paramInt)
  {
    AppMethodBeat.i(186970);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished");
    lXB.bul();
    AppBrandPreloadProfiler.t(new d.g.a.a() {});
    Object localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
    int i;
    if (lXC == e.lYs)
    {
      i = 6;
      ((com.tencent.mm.plugin.report.service.h)localObject1).dB(915, i);
      if (paramInt != 2) {
        break label133;
      }
    }
    for (;;)
    {
      try
      {
        lXy = b.lXQ;
        localObject1 = new LinkedList(lXz);
        lXz.clear();
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
        AppMethodBeat.o(186970);
      }
      lXy = b.lXP;
    }
    label154:
    com.tencent.mm.sdk.f.c.a(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.d.a(c.buw());
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(186970);
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(48380);
      lXN = new b("NOT_PRELOAD", 0);
      lXO = new b("PRELOADING", 1);
      lXP = new b("PRELOADED_DOWNGRADE", 2);
      lXQ = new b("PRELOADED_FULL", 3);
      lXR = new b[] { lXN, lXO, lXP, lXQ };
      AppMethodBeat.o(48380);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */