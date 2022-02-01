package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.LooperCompat;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import junit.framework.Assert;
import kotlin.x;

public class e
{
  private static final a nOG;
  private static final ConcurrentHashMap<g, HashSet<b>> nOH;
  private static final ConcurrentHashMap<g, Queue<ag>> nOI;
  private static final ConcurrentHashMap<g, Queue<s>> nOJ;
  private static final ConcurrentHashMap<g, AppBrandPreloadProfiler> nOK;
  private static volatile boolean nOL;
  private static volatile boolean nOM;
  private static volatile boolean nON;
  private static volatile int nOO;
  
  static
  {
    AppMethodBeat.i(48405);
    nOG = new a();
    nOH = new ConcurrentHashMap();
    nOI = new ConcurrentHashMap();
    nOJ = new ConcurrentHashMap();
    nOK = new ConcurrentHashMap();
    nOI.put(g.nPE, new ConcurrentLinkedQueue());
    nOI.put(g.nPD, new ConcurrentLinkedQueue());
    nOJ.put(g.nPE, new ConcurrentLinkedQueue());
    nOJ.put(g.nPD, new ConcurrentLinkedQueue());
    nOH.put(g.nPE, new HashSet());
    nOH.put(g.nPD, new HashSet());
    nOL = false;
    nOM = false;
    nON = false;
    nOO = 2147483647;
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
      paramString1 = Util.safeFormatString("Unknown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(48397);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(int paramInt, g paramg)
  {
    AppMethodBeat.i(227463);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished level:%d type [%s]", new Object[] { Integer.valueOf(paramInt), paramg.name() });
    ((AppBrandPreloadProfiler)nOK.get(paramg)).bVN();
    nOK.get(paramg);
    AppBrandPreloadProfiler.A(new kotlin.g.a.a() {});
    Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
    int i;
    if (paramg == g.nPE)
    {
      i = 6;
      ((com.tencent.mm.plugin.report.service.h)localObject).dN(915, i);
      if (paramInt != 2) {
        break label184;
      }
    }
    for (;;)
    {
      try
      {
        nOG.a(paramg, c.nOZ);
        localObject = new LinkedList((Collection)nOH.get(paramg));
        ((HashSet)nOH.get(paramg)).clear();
        localObject = ((Collection)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label208;
        }
        b localb = (b)((Iterator)localObject).next();
        if (localb == null) {
          continue;
        }
        localb.onReady();
        continue;
        i = 1;
        break;
      }
      finally
      {
        label184:
        AppMethodBeat.o(227463);
      }
      nOG.a(paramg, c.nOY);
    }
    label208:
    LooperCompat.addMainLooperIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.g localg = com.tencent.mm.plugin.appbrand.page.g.nnK;
        com.tencent.mm.plugin.appbrand.page.g.a(this.kIl);
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(227463);
  }
  
  private static void a(g paramg, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(227455);
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    nOK.put(paramg, localAppBrandPreloadProfiler);
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.h.CyF;
    if (paramg == g.nPE) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.dN(915, i);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      a(paramInt, paramg);
      AppMethodBeat.o(227455);
      return;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            ((AppBrandPreloadProfiler)e.bly().get(this.kIl)).startTime = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.expansions.a.cMp();
            MMHandlerThread.setCurrentPriority(-2);
            try
            {
              WxaCommLibRuntimeReader.vC();
              ad.bDt();
              if (this.kIl == g.nPE)
              {
                e.access$200();
                e.access$300();
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", new Object[] { android.util.Log.getStackTraceString(localThrowable1) });
              e.n(this.kIl);
              return;
            }
            localObject = new k(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(227440);
                e.b(e.1.this.kIn, e.1.this.kIl);
                AppMethodBeat.o(227440);
              }
            }, 2);
            if (paramInt < 2) {
              continue;
            }
            local2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48369);
                MMHandlerThread.setCurrentPriority(-8);
                e.o(e.1.this.kIl);
                this.nOQ.countDown();
                AppMethodBeat.o(48369);
              }
            };
            if (!y.btj()) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
            MMHandlerThread.postToMainThread(local2);
          }
          catch (Throwable localThrowable2)
          {
            Object localObject;
            Runnable local2;
            e.n(this.kIl);
            if (!WeChatEnvironment.hasDebugger()) {
              break label320;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                throw localThrowable2;
              }
            });
            return;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: skip preload webView");
            localThrowable2.countDown();
            continue;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
            MMHandlerThread.setCurrentPriority(10);
            AppMethodBeat.o(48370);
          }
          localObject = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(227443);
              e.p(e.1.this.kIl);
              this.nOQ.countDown();
              AppMethodBeat.o(227443);
            }
          };
          com.tencent.f.h.RTc.b((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          MMHandlerThread.setCurrentPriority(10);
          AppMethodBeat.o(48370);
          return;
          y.a(new y.a()
          {
            public final void brW()
            {
              AppMethodBeat.i(227441);
              com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
              com.tencent.mm.plugin.appbrand.report.quality.c.a(true, null, this.nOR, o.bUx());
              MMHandlerThread.postToMainThread(this.nOS);
              AppMethodBeat.o(227441);
            }
            
            public final void brX()
            {
              AppMethodBeat.i(227442);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              MMHandlerThread.postToMainThread(this.nOS);
              AppMethodBeat.o(227442);
            }
          });
        }
        for (;;)
        {
          label320:
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", localThrowable3, "[NOT CRASH]", new Object[0]);
        }
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(227444);
            Iterator localIterator = h.bWd().iterator();
            while (localIterator.hasNext())
            {
              n localn = (n)localIterator.next();
              if (Util.nullAsNil(localn.nQm).equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName)) {
                try
                {
                  localn.nQl.newInstance();
                  if ((localn instanceof m)) {
                    ((m)localn).nQi.newInstance();
                  }
                }
                catch (Throwable localThrowable) {}
              }
            }
            AppMethodBeat.o(227444);
          }
        });
        AppMethodBeat.o(48373);
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
    AppMethodBeat.o(227455);
  }
  
  public static void a(g paramg, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(227453);
    a(paramg, paramb, paramBoolean, null, 2);
    AppMethodBeat.o(227453);
  }
  
  public static void a(g paramg, b paramb, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(227454);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s] level = [%d], force[%b]", new Object[] { paramg.name(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramg == g.nPF)
    {
      paramg = new IllegalArgumentException("can not preload with a specific service type");
      AppMethodBeat.o(227454);
      throw paramg;
    }
    c localc;
    try
    {
      if ((nOG.r(paramg)) && (paramBoolean)) {
        d(paramg);
      }
      localc = nOG.q(paramg);
      if ((localc == c.nOW) || (localc == c.nOX) || ((localc == c.nOY) && (paramInt >= 2)))
      {
        if (paramb != null) {
          ((HashSet)nOH.get(paramg)).add(paramb);
        }
        nOG.a(paramg, c.nOX);
      }
      if (localc == c.nOX)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: type [%s] is preloading, just return", new Object[] { paramg.name() });
        AppMethodBeat.o(227454);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(227454);
    }
    if ((localc == c.nOZ) || ((localc == c.nOY) && (paramInt < 2)))
    {
      if (paramb != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: [%s] [%d] preload finished", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
        paramb.onReady();
      }
      AppMethodBeat.o(227454);
      return;
    }
    a(paramg, paramAppBrandPreloadProfiler, paramInt);
    AppMethodBeat.o(227454);
  }
  
  public static boolean a(g paramg, b paramb, String paramString)
  {
    AppMethodBeat.i(227457);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s], sCacheServices.size[%d], sCachePageView.size[%d], message[%s]", new Object[] { nOG.q(paramg).name(), Integer.valueOf(((Queue)nOJ.get(paramg)).size()), Integer.valueOf(((Queue)nOI.get(paramg)).size()), Util.nullAsNil(paramString) });
        if (nOG.q(paramg) == c.nOX)
        {
          ((HashSet)nOH.get(paramg)).add(paramb);
          ((AppBrandPreloadProfiler)nOK.get(paramg)).nOF = SystemClock.elapsedRealtime();
          return true;
        }
        if (!b.bVE()) {
          break label292;
        }
        if (nOG.q(paramg) == c.nOW)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          ((HashSet)nOH.get(paramg)).add(paramb);
          nOG.a(paramg, c.nOX);
          i = 1;
          if (i != 0)
          {
            a(paramg, null, 2);
            AppMethodBeat.o(227457);
            return true;
          }
        }
        else
        {
          if ((!nOG.r(paramg)) || (j(paramg) != null)) {
            break label292;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          d(paramg);
          ((HashSet)nOH.get(paramg)).add(paramb);
          nOG.a(paramg, c.nOX);
          i = 1;
          continue;
        }
        AppMethodBeat.o(227457);
      }
      finally
      {
        AppMethodBeat.o(227457);
      }
      return false;
      label292:
      int i = 0;
    }
  }
  
  /* Error */
  private static g[] bVO()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 492
    //   6: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 75	com/tencent/mm/plugin/appbrand/task/e:nOJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: getstatic 93	com/tencent/mm/plugin/appbrand/task/g:nPD	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   15: invokevirtual 495	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   18: ifeq +136 -> 154
    //   21: getstatic 75	com/tencent/mm/plugin/appbrand/task/e:nOJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: getstatic 93	com/tencent/mm/plugin/appbrand/task/g:nPD	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   27: invokevirtual 156	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 384	java/util/Queue
    //   33: invokeinterface 498 1 0
    //   38: ifne +116 -> 154
    //   41: iconst_1
    //   42: istore_0
    //   43: getstatic 75	com/tencent/mm/plugin/appbrand/task/e:nOJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: getstatic 83	com/tencent/mm/plugin/appbrand/task/g:nPE	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   49: invokevirtual 495	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   52: ifeq +107 -> 159
    //   55: getstatic 75	com/tencent/mm/plugin/appbrand/task/e:nOJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: getstatic 83	com/tencent/mm/plugin/appbrand/task/g:nPE	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   61: invokevirtual 156	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 384	java/util/Queue
    //   67: invokeinterface 498 1 0
    //   72: ifne +87 -> 159
    //   75: iconst_1
    //   76: istore_1
    //   77: new 500	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 501	java/util/ArrayList:<init>	()V
    //   84: astore_3
    //   85: iload_0
    //   86: ifeq +13 -> 99
    //   89: aload_3
    //   90: getstatic 93	com/tencent/mm/plugin/appbrand/task/g:nPD	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   93: invokeinterface 504 2 0
    //   98: pop
    //   99: iload_1
    //   100: ifeq +13 -> 113
    //   103: aload_3
    //   104: getstatic 83	com/tencent/mm/plugin/appbrand/task/g:nPE	Lcom/tencent/mm/plugin/appbrand/task/g;
    //   107: invokeinterface 504 2 0
    //   112: pop
    //   113: aload_3
    //   114: invokeinterface 505 1 0
    //   119: iconst_2
    //   120: if_icmpgt +44 -> 164
    //   123: iconst_1
    //   124: istore_2
    //   125: iload_2
    //   126: invokestatic 511	junit/framework/Assert:assertTrue	(Z)V
    //   129: aload_3
    //   130: iconst_0
    //   131: anewarray 79	com/tencent/mm/plugin/appbrand/task/g
    //   134: invokeinterface 515 2 0
    //   139: checkcast 517	[Lcom/tencent/mm/plugin/appbrand/task/g;
    //   142: astore_3
    //   143: ldc_w 492
    //   146: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: ldc 2
    //   151: monitorexit
    //   152: aload_3
    //   153: areturn
    //   154: iconst_0
    //   155: istore_0
    //   156: goto -113 -> 43
    //   159: iconst_0
    //   160: istore_1
    //   161: goto -84 -> 77
    //   164: iconst_0
    //   165: istore_2
    //   166: goto -41 -> 125
    //   169: astore_3
    //   170: ldc 2
    //   172: monitorexit
    //   173: aload_3
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	114	0	i	int
    //   76	85	1	j	int
    //   124	42	2	bool	boolean
    //   84	69	3	localObject1	Object
    //   169	5	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	41	169	finally
    //   43	75	169	finally
    //   77	85	169	finally
    //   89	99	169	finally
    //   103	113	169	finally
    //   113	123	169	finally
    //   125	149	169	finally
  }
  
  public static g[] bVP()
  {
    try
    {
      AppMethodBeat.i(227452);
      a locala = nOG;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = locala.nOV.entrySet().iterator();
      while (localIterator.hasNext())
      {
        g localg = (g)((Map.Entry)localIterator.next()).getKey();
        if (locala.r(localg)) {
          localArrayList.add(localg);
        }
      }
      arrayOfg = (g[])localArrayList.toArray(new g[0]);
    }
    finally {}
    g[] arrayOfg;
    AppMethodBeat.o(227452);
    return arrayOfg;
  }
  
  public static void bVQ()
  {
    for (;;)
    {
      int i;
      g localg;
      Object localObject2;
      try
      {
        AppMethodBeat.i(48384);
        g[] arrayOfg = bVO();
        int j = arrayOfg.length;
        i = 0;
        if (i >= j) {
          break label153;
        }
        localg = arrayOfg[i];
        if (!k(localg)) {
          break label163;
        }
        localObject2 = (Queue)nOJ.get(localg);
        if (localObject2 != null)
        {
          localObject2 = ((Queue)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ((s)((Iterator)localObject2).next()).cleanup();
            continue;
          }
        }
        localObject2 = (Queue)nOI.get(localg);
      }
      finally {}
      if (localObject2 != null)
      {
        localObject2 = ((Queue)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ag)((Iterator)localObject2).next()).cleanup();
        }
      }
      a(localg, null, true);
      break label163;
      label153:
      AppMethodBeat.o(48384);
      return;
      label163:
      i += 1;
    }
  }
  
  public static boolean bVR()
  {
    AppMethodBeat.i(48395);
    if (WebView.isSys())
    {
      AppMethodBeat.o(48395);
      return true;
    }
    if (WebView.isX5())
    {
      if (WebView.getUsingTbsCoreVersion(MMApplicationContext.getContext()) == 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
        AppMethodBeat.o(48395);
        return true;
      }
      if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(MMApplicationContext.getContext()))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
        AppMethodBeat.o(48395);
        return true;
      }
    }
    AppMethodBeat.o(48395);
    return false;
  }
  
  private static void d(g paramg)
  {
    try
    {
      AppMethodBeat.i(227450);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "reset() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      nOG.a(paramg, c.nOW);
      AppMethodBeat.o(227450);
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  private static void e(g paramg)
  {
    AppMethodBeat.i(227456);
    Queue localQueue = (Queue)nOJ.get(paramg);
    if (!localQueue.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload services skipped cause already cached");
      com.tencent.mm.plugin.report.service.h.CyF.dN(915, 34);
      AppMethodBeat.o(227456);
      return;
    }
    s locals = (s)org.a.a.bF(paramg.nPH).hPX().object;
    locals.a(WxaCommLibRuntimeReader.bvW());
    locals.YU();
    localQueue.add(locals);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { paramg });
    AppMethodBeat.o(227456);
  }
  
  public static com.tencent.mm.vending.g.c<Void> f(g paramg)
  {
    AppMethodBeat.i(227458);
    try
    {
      if (nOG.q(paramg) == c.nOX)
      {
        f localf = com.tencent.mm.co.g.hio();
        Object localObject = localf.hdx();
        ((com.tencent.mm.vending.g.b)localObject).hdw();
        localObject = new b()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48374);
            this.czt.resume();
            AppMethodBeat.o(48374);
          }
        };
        ((HashSet)nOH.get(paramg)).add(localObject);
        return localf;
      }
      paramg = com.tencent.mm.co.g.hio();
      return paramg;
    }
    finally
    {
      AppMethodBeat.o(227458);
    }
  }
  
  public static AppBrandPreloadProfiler g(g paramg)
  {
    AppMethodBeat.i(227459);
    paramg = (AppBrandPreloadProfiler)nOK.get(paramg);
    AppMethodBeat.o(227459);
    return paramg;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c h(g paramg)
  {
    AppMethodBeat.i(227460);
    Assert.assertNotSame(paramg, g.nPF);
    Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
    com.tencent.mm.plugin.report.service.h localh;
    if (paramg == g.nPE)
    {
      i = 12;
      ((com.tencent.mm.plugin.report.service.h)localObject).dN(915, i);
      localh = null;
      Queue localQueue = (Queue)nOJ.get(paramg);
      localObject = localh;
      if (localQueue != null)
      {
        localObject = localh;
        if (!localQueue.isEmpty())
        {
          localObject = (com.tencent.mm.plugin.appbrand.service.c)localQueue.poll();
          Assert.assertTrue(localQueue.isEmpty());
        }
      }
      if (localObject != null)
      {
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (paramg != g.nPE) {
          break label145;
        }
      }
    }
    label145:
    for (int i = 7;; i = 2)
    {
      localh.dN(915, i);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getServices: ret = [%s]", new Object[] { localObject });
      AppMethodBeat.o(227460);
      return localObject;
      i = 10;
      break;
    }
  }
  
  public static ag i(g paramg)
  {
    AppMethodBeat.i(227461);
    Assert.assertNotSame(paramg, g.nPF);
    Queue localQueue = (Queue)nOI.get(paramg);
    Object localObject = null;
    paramg = localObject;
    if (localQueue != null)
    {
      paramg = localObject;
      if (!localQueue.isEmpty())
      {
        paramg = (ag)localQueue.poll();
        Assert.assertTrue(localQueue.isEmpty());
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPageView: [%s]", new Object[] { paramg });
    AppMethodBeat.o(227461);
    return paramg;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c j(g paramg)
  {
    AppMethodBeat.i(227462);
    Assert.assertNotSame(paramg, g.nPF);
    paramg = (Queue)nOJ.get(paramg);
    if ((paramg != null) && (!paramg.isEmpty()))
    {
      paramg = (com.tencent.mm.plugin.appbrand.service.c)paramg.peek();
      AppMethodBeat.o(227462);
      return paramg;
    }
    AppMethodBeat.o(227462);
    return null;
  }
  
  public static boolean k(g paramg)
  {
    try
    {
      AppMethodBeat.i(227464);
      boolean bool = nOG.r(paramg);
      AppMethodBeat.o(227464);
      return bool;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public static boolean l(g paramg)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(227465);
        boolean bool;
        if (!k(paramg))
        {
          AppMethodBeat.o(227465);
          bool = true;
          return bool;
        }
        com.tencent.mm.plugin.appbrand.service.c localc = j(paramg);
        Assert.assertNotSame(paramg, g.nPF);
        localObject = (Queue)nOI.get(paramg);
        if ((localObject != null) && (!((Queue)localObject).isEmpty()))
        {
          localObject = (ag)((Queue)localObject).peek();
          if (paramg == g.nPE)
          {
            if (localc == null)
            {
              AppMethodBeat.o(227465);
              bool = true;
              continue;
            }
            AppMethodBeat.o(227465);
            bool = false;
            continue;
          }
          if (paramg == g.nPD)
          {
            if ((localc == null) || (localObject == null))
            {
              AppMethodBeat.o(227465);
              bool = true;
              continue;
            }
            AppMethodBeat.o(227465);
            bool = false;
            continue;
          }
          paramg = new IllegalStateException("not supported type: " + paramg.name());
          AppMethodBeat.o(227465);
          throw paramg;
        }
      }
      finally {}
      Object localObject = null;
    }
  }
  
  public static c m(g paramg)
  {
    AppMethodBeat.i(227466);
    paramg = nOG.q(paramg);
    AppMethodBeat.o(227466);
    return paramg;
  }
  
  static final class a
  {
    final Map<g, e.c> nOV;
    
    public a()
    {
      AppMethodBeat.i(227446);
      this.nOV = new ConcurrentHashMap();
      this.nOV.put(g.nPD, e.c.nOW);
      this.nOV.put(g.nPE, e.c.nOW);
      AppMethodBeat.o(227446);
    }
    
    public final void a(g paramg, e.c paramc)
    {
      AppMethodBeat.i(227448);
      this.nOV.put(paramg, paramc);
      AppMethodBeat.o(227448);
    }
    
    public final e.c q(g paramg)
    {
      AppMethodBeat.i(227447);
      paramg = (e.c)this.nOV.get(paramg);
      AppMethodBeat.o(227447);
      return paramg;
    }
    
    public final boolean r(g paramg)
    {
      AppMethodBeat.i(227449);
      paramg = (e.c)this.nOV.get(paramg);
      if ((paramg == e.c.nOZ) || (paramg == e.c.nOY))
      {
        AppMethodBeat.o(227449);
        return true;
      }
      AppMethodBeat.o(227449);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onReady();
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(48380);
      nOW = new c("NOT_PRELOAD", 0);
      nOX = new c("PRELOADING", 1);
      nOY = new c("PRELOADED_DOWNGRADE", 2);
      nOZ = new c("PRELOADED_FULL", 3);
      nPa = new c[] { nOW, nOX, nOY, nOZ };
      AppMethodBeat.o(48380);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */