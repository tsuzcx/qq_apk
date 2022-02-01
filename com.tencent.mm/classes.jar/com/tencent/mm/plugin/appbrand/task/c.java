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
import d.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  private static final Queue<q> kPP;
  private static c.b lvE;
  private static final HashSet<a> lvF;
  private static final Queue<ae> lvG;
  private static volatile AppBrandPreloadProfiler lvH;
  private static volatile e lvI;
  private static volatile boolean lvJ;
  private static volatile boolean lvK;
  private static volatile boolean lvL;
  private static volatile int lvM;
  
  static
  {
    AppMethodBeat.i(48405);
    lvE = c.b.lvT;
    lvF = new HashSet();
    lvG = new ConcurrentLinkedQueue();
    kPP = new ConcurrentLinkedQueue();
    lvH = null;
    lvI = e.lwz;
    lvJ = false;
    lvK = false;
    lvL = false;
    lvM = 2147483647;
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
      paramString1 = bt.u("Unknown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(48397);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(e parame, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(196122);
    if ((lvI != e.lwz) && (lvE != c.b.lvV))
    {
      parame = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
      AppMethodBeat.o(196122);
      throw parame;
    }
    if ((parame != e.lwz) && (lvE == c.b.lvV) && (lvI != parame))
    {
      parame = new IllegalStateException("downgraded, but try preload again with a different service");
      AppMethodBeat.o(196122);
      throw parame;
    }
    lvI = parame;
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    lvH = localAppBrandPreloadProfiler;
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.h.vKh;
    if (parame == e.lwy) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.dB(915, i);
      ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      tU(paramInt);
      AppMethodBeat.o(196122);
      return;
    }
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.plugin.expansions.a.cba();
            c.bnz().startTime = SystemClock.elapsedRealtime();
            ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            aq.Wk(-2);
            try
            {
              WxaCommLibRuntimeReader.tP();
              ac.aWU();
              if (this.iJw == e.lwy)
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
                AppMethodBeat.i(196114);
                c.nv(c.1.this.iJz);
                AppMethodBeat.o(196114);
              }
            }, 2);
            local2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48369);
                aq.Wk(-8);
                c.Kr();
                this.lvO.countDown();
                AppMethodBeat.o(48369);
              }
            };
            if (paramInt < 2) {
              continue;
            }
            if (!x.aNI()) {
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
            if (!bu.eGT()) {
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
            aq.Wk(10);
            AppMethodBeat.o(48370);
          }
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196117);
              c.access$600();
              this.lvO.countDown();
              AppMethodBeat.o(196117);
            }
          };
          com.tencent.e.h.Iye.f((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          aq.Wk(10);
          AppMethodBeat.o(48370);
          return;
          x.a(new x.a()
          {
            public final void aMx()
            {
              AppMethodBeat.i(196115);
              com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
              com.tencent.mm.plugin.appbrand.report.quality.b.a(true, null, this.lvP, n.bmm());
              aq.f(this.lvQ);
              AppMethodBeat.o(196115);
            }
            
            public final void aMy()
            {
              AppMethodBeat.i(196116);
              ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              aq.f(this.lvQ);
              AppMethodBeat.o(196116);
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
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196118);
            Iterator localIterator = f.bnH().iterator();
            while (localIterator.hasNext())
            {
              i locali = (i)localIterator.next();
              if (bt.nullAsNil(locali.lwO).equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName)) {
                try
                {
                  locali.lwN.newInstance();
                }
                catch (Throwable localThrowable) {}
              }
            }
            AppMethodBeat.o(196118);
          }
        });
        AppMethodBeat.o(48373);
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
    AppMethodBeat.o(196122);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(196120);
    a(parame, parama, paramBoolean, null, 2);
    AppMethodBeat.o(196120);
  }
  
  public static void a(e parame, a parama, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(196121);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { parame.name() });
    c.b localb;
    try
    {
      if (((lvE == c.b.lvW) || (lvE == c.b.lvV)) && (paramBoolean)) {
        reset();
      }
      localb = lvE;
      if ((localb == c.b.lvT) || (localb == c.b.lvU) || ((localb == c.b.lvV) && (paramInt >= 2)))
      {
        if (parama != null) {
          lvF.add(parama);
        }
        lvE = c.b.lvU;
      }
      if (localb == c.b.lvU)
      {
        AppMethodBeat.o(196121);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(196121);
    }
    if ((localb == c.b.lvW) || ((localb == c.b.lvV) && (paramInt < 2)))
    {
      if (parama != null) {
        parama.onReady();
      }
      AppMethodBeat.o(196121);
      return;
    }
    int i;
    if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      i = paramInt;
      if (!bu.eGT()) {}
    }
    else
    {
      parama = com.tencent.mm.plugin.appbrand.app.d.iJD;
      parama = com.tencent.mm.plugin.appbrand.app.d.Km();
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
    AppMethodBeat.o(196121);
  }
  
  public static boolean a(e parame, a parama)
  {
    AppMethodBeat.i(48386);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", new Object[] { lvE.name() });
        if ((lvE == c.b.lvU) && (parame == lvI))
        {
          lvF.add(parama);
          lvH.lvD = SystemClock.elapsedRealtime();
          return true;
        }
        if (!a.bnl()) {
          break label220;
        }
        if (lvE == c.b.lvT)
        {
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          lvF.add(parama);
          lvE = c.b.lvU;
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
          if (((lvE != c.b.lvV) && (lvE != c.b.lvW)) || ((lvI == parame) && (kPP.peek() != null))) {
            break label220;
          }
          ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          reset();
          lvF.add(parama);
          lvE = c.b.lvU;
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
  public static boolean aNI()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 67	com/tencent/mm/plugin/appbrand/task/c:lvE	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   6: getstatic 327	com/tencent/mm/plugin/appbrand/task/c$b:lvW	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   9: if_acmpeq +16 -> 25
    //   12: getstatic 67	com/tencent/mm/plugin/appbrand/task/c:lvE	Lcom/tencent/mm/plugin/appbrand/task/c$b;
    //   15: astore_1
    //   16: getstatic 269	com/tencent/mm/plugin/appbrand/task/c$b:lvV	Lcom/tencent/mm/plugin/appbrand/task/c$b;
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
  
  public static void bnq()
  {
    try
    {
      AppMethodBeat.i(48384);
      if ((!aNI()) || (kPP.size() <= 0)) {
        break label96;
      }
      while (!kPP.isEmpty()) {
        ((q)kPP.poll()).cleanup();
      }
      if (lvG.isEmpty()) {
        break label88;
      }
    }
    finally {}
    for (;;)
    {
      ((ae)lvG.poll()).cleanup();
    }
    label88:
    a(lvI, null, true);
    label96:
    AppMethodBeat.o(48384);
  }
  
  private static void bnr()
  {
    AppMethodBeat.i(48385);
    if (kPP.size() > 0)
    {
      AppMethodBeat.o(48385);
      return;
    }
    q localq = (q)org.a.a.bA(lvI.lwB).fMX().object;
    localq.a(WxaCommLibRuntimeReader.aPU());
    localq.MX();
    kPP.add(localq);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { lvI });
    AppMethodBeat.o(48385);
  }
  
  public static com.tencent.mm.vending.g.c<Void> bns()
  {
    AppMethodBeat.i(48387);
    try
    {
      if (lvE == c.b.lvU)
      {
        localf = com.tencent.mm.co.g.fkM();
        Object localObject2 = localf.fhl();
        ((com.tencent.mm.vending.g.b)localObject2).fhk();
        localObject2 = new a()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48374);
            this.cgd.resume();
            AppMethodBeat.o(48374);
          }
        };
        lvF.add(localObject2);
        return localf;
      }
      com.tencent.mm.co.f localf = com.tencent.mm.co.g.fkM();
      return localf;
    }
    finally
    {
      AppMethodBeat.o(48387);
    }
  }
  
  public static AppBrandPreloadProfiler bnt()
  {
    return lvH;
  }
  
  public static ae bnu()
  {
    AppMethodBeat.i(196124);
    ae localae = (ae)lvG.poll();
    AppMethodBeat.o(196124);
    return localae;
  }
  
  public static q bnv()
  {
    AppMethodBeat.i(48390);
    q localq = (q)kPP.peek();
    AppMethodBeat.o(48390);
    return localq;
  }
  
  /* Error */
  public static boolean bnw()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 578
    //   6: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 506	com/tencent/mm/plugin/appbrand/task/c:aNI	()Z
    //   12: ifeq +27 -> 39
    //   15: getstatic 81	com/tencent/mm/plugin/appbrand/task/c:kPP	Ljava/util/Queue;
    //   18: invokeinterface 126 1 0
    //   23: ifle +16 -> 39
    //   26: iconst_1
    //   27: istore_0
    //   28: ldc_w 578
    //   31: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_0
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_0
    //   41: ldc_w 578
    //   44: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean bnx()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(48394);
        if (c.b.lvT == lvE)
        {
          AppMethodBeat.o(48394);
          return bool;
        }
        if ((aNI()) && (lvG.size() <= 0) && (kPP.size() <= 0))
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
  
  public static boolean bny()
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
    AppMethodBeat.i(196123);
    Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
    if (parame == e.lwy) {}
    for (int i = 12;; i = 10)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).dB(915, i);
      try
      {
        localObject = lvE;
        if (localObject != c.b.lvT) {
          break;
        }
        ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader not preload, just return null");
        AppMethodBeat.o(196123);
        return null;
      }
      finally
      {
        AppMethodBeat.o(196123);
      }
    }
    if (localObject == c.b.lvU)
    {
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        parame = new IllegalStateException("getServices when preloading");
        AppMethodBeat.o(196123);
        throw parame;
      }
      ad.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
      AppMethodBeat.o(196123);
      return null;
    }
    if (parame != lvI)
    {
      ad.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
      AppMethodBeat.o(196123);
      return null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.service.c)kPP.poll();
    com.tencent.mm.plugin.report.service.h localh;
    if (localObject != null)
    {
      localh = com.tencent.mm.plugin.report.service.h.vKh;
      if (parame != e.lwy) {
        break label213;
      }
    }
    label213:
    for (i = 7;; i = 2)
    {
      localh.dB(915, i);
      AppMethodBeat.o(196123);
      return localObject;
    }
  }
  
  public static q d(e parame)
  {
    AppMethodBeat.i(48391);
    if (e.lwz == parame)
    {
      AppMethodBeat.o(48391);
      return null;
    }
    Iterator localIterator = kPP.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.getClass() == parame.lwB)
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
      lvE = c.b.lvT;
      lvF.clear();
      lvG.clear();
      kPP.clear();
      lvH = null;
      lvI = e.lwz;
      AppMethodBeat.o(48381);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void tT(int paramInt)
  {
    AppMethodBeat.i(196125);
    if (aq.isMainThread())
    {
      tU(paramInt);
      AppMethodBeat.o(196125);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48375);
        c.tV(this.iJz);
        AppMethodBeat.o(48375);
      }
    });
    AppMethodBeat.o(196125);
  }
  
  private static void tU(int paramInt)
  {
    AppMethodBeat.i(196126);
    ad.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished");
    lvH.bnp();
    AppBrandPreloadProfiler.p(new d.g.a.a() {});
    Object localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
    int i;
    if (lvI == e.lwy)
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
        lvE = c.b.lvW;
        localObject1 = new LinkedList(lvF);
        lvF.clear();
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
        AppMethodBeat.o(196126);
      }
      lvE = c.b.lvV;
    }
    label154:
    com.tencent.mm.sdk.f.c.a(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.d.a(c.bnA());
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(196126);
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */