package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.u;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.expt.b.b.a;
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
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import junit.framework.Assert;
import kotlin.x;

public class h
{
  public static int cxa;
  private static final a qRq;
  private static final ConcurrentHashMap<n, HashSet<b>> qRr;
  private static final ConcurrentHashMap<n, Queue<ah>> qRs;
  private static final ConcurrentHashMap<n, Queue<v>> qRt;
  private static final ConcurrentHashMap<n, AppBrandPreloadProfiler> qRu;
  private static volatile boolean qRv;
  private static volatile boolean qRw;
  private static volatile boolean qRx;
  private static volatile int qRy;
  
  static
  {
    AppMethodBeat.i(48405);
    cxa = -1;
    qRq = new a();
    qRr = new ConcurrentHashMap();
    qRs = new ConcurrentHashMap();
    qRt = new ConcurrentHashMap();
    qRu = new ConcurrentHashMap();
    qRs.put(n.qRT, new ConcurrentLinkedQueue());
    qRs.put(n.qRS, new ConcurrentLinkedQueue());
    qRt.put(n.qRT, new ConcurrentLinkedQueue());
    qRt.put(n.qRS, new ConcurrentLinkedQueue());
    qRr.put(n.qRT, new HashSet());
    qRr.put(n.qRS, new HashSet());
    qRv = false;
    qRw = false;
    qRx = false;
    qRy = 2147483647;
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
  
  private static void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(284329);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished level:%d type [%s]", new Object[] { Integer.valueOf(paramInt), paramn.name() });
    ((AppBrandPreloadProfiler)qRu.get(paramn)).ciV();
    qRu.get(paramn);
    AppBrandPreloadProfiler.y(new kotlin.g.a.a() {});
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
    int i;
    if (paramn == n.qRT)
    {
      i = 6;
      ((com.tencent.mm.plugin.report.service.h)localObject).el(915, i);
      if (paramInt != 2) {
        break label184;
      }
    }
    for (;;)
    {
      try
      {
        qRq.a(paramn, c.qRI);
        localObject = new LinkedList((Collection)qRr.get(paramn));
        ((HashSet)qRr.get(paramn)).clear();
        localObject = ((Collection)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label208;
        }
        b localb = (b)((Iterator)localObject).next();
        if (localb == null) {
          continue;
        }
        localb.NR();
        continue;
        i = 1;
        break;
      }
      finally
      {
        label184:
        AppMethodBeat.o(284329);
      }
      qRq.a(paramn, c.qRH);
    }
    label208:
    LooperCompat.addMainLooperIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.g localg = com.tencent.mm.plugin.appbrand.page.g.qpr;
        com.tencent.mm.plugin.appbrand.page.g.a(this.nCb);
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(284329);
  }
  
  private static void a(n paramn, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(284321);
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    qRu.put(paramn, localAppBrandPreloadProfiler);
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.h.IzE;
    if (paramn == n.qRT) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.el(915, i);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      a(paramInt, paramn);
      AppMethodBeat.o(284321);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48370);
        for (;;)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
            ((AppBrandPreloadProfiler)h.bvo().get(this.nCb)).startTime = SystemClock.elapsedRealtime();
            com.tencent.mm.plugin.expansions.a.dbd();
            MMHandlerThread.setCurrentPriority(-2);
            try
            {
              WxaCommLibRuntimeReader.tA();
              ad.bOR();
              if (this.nCb == n.qRT)
              {
                h.access$200();
                h.access$300();
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                return;
              }
            }
            catch (Throwable localThrowable1)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", new Object[] { android.util.Log.getStackTraceString(localThrowable1) });
              h.m(this.nCb);
              return;
            }
            localObject = new com.tencent.luggage.sdk.h.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249343);
                h.b(h.1.this.val$level, h.1.this.nCb);
                AppMethodBeat.o(249343);
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
                h.n(h.1.this.nCb);
                this.qRA.Sz();
                AppMethodBeat.o(48369);
              }
            };
            if (!ac.bEh()) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
            MMHandlerThread.postToMainThread(local2);
          }
          catch (Throwable localThrowable2)
          {
            Object localObject;
            Runnable local2;
            h.m(this.nCb);
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
            localThrowable2.Sz();
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
              AppMethodBeat.i(278573);
              h.o(h.1.this.nCb);
              this.qRA.Sz();
              AppMethodBeat.o(278573);
            }
          };
          com.tencent.e.h.ZvG.d((Runnable)localObject, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
          MMHandlerThread.setCurrentPriority(10);
          AppMethodBeat.o(48370);
          return;
          ac.a(new ac.a()
          {
            public final void bCM()
            {
              AppMethodBeat.i(278307);
              com.tencent.mm.plugin.appbrand.report.quality.b.cik();
              com.tencent.mm.plugin.appbrand.report.quality.c.a(true, null, this.qRB, p.chH());
              MMHandlerThread.postToMainThread(this.qRC);
              AppMethodBeat.o(278307);
            }
            
            public final void bCN()
            {
              AppMethodBeat.i(278308);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
              MMHandlerThread.postToMainThread(this.qRC);
              AppMethodBeat.o(278308);
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
    com.tencent.luggage.sdk.h.d.a("preload AppBrandUI classes", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        try
        {
          if (this.nCe.qRm != null) {
            Class.forName(this.nCe.qRm).newInstance();
          }
          if (this.nCe.qRn != null) {
            Class.forName(this.nCe.qRn).newInstance();
          }
          AppMethodBeat.o(48373);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: ", new Object[] { localClassNotFoundException });
          AppMethodBeat.o(48373);
          return;
        }
        catch (InstantiationException localInstantiationException)
        {
          break label60;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          label60:
          break label60;
        }
      }
    });
    AppMethodBeat.o(284321);
  }
  
  public static void a(n paramn, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(284319);
    a(paramn, paramb, paramBoolean, null, 2);
    AppMethodBeat.o(284319);
  }
  
  public static void a(n paramn, b paramb, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(284320);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s] level = [%d], force[%b]", new Object[] { paramn.name(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramn == n.qRU)
    {
      paramn = new IllegalArgumentException("can not preload with a specific service type");
      AppMethodBeat.o(284320);
      throw paramn;
    }
    c localc;
    try
    {
      if ((qRq.q(paramn)) && (paramBoolean)) {
        c(paramn);
      }
      localc = qRq.p(paramn);
      if ((localc == c.qRF) || (localc == c.qRG) || ((localc == c.qRH) && (paramInt >= 2)))
      {
        if (paramb != null) {
          ((HashSet)qRr.get(paramn)).add(paramb);
        }
        qRq.a(paramn, c.qRG);
      }
      if (localc == c.qRG)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: type [%s] is preloading, just return", new Object[] { paramn.name() });
        AppMethodBeat.o(284320);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(284320);
    }
    if ((localc == c.qRI) || ((localc == c.qRH) && (paramInt < 2)))
    {
      if (paramb != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: [%s] [%d] preload finished", new Object[] { paramn.name(), Integer.valueOf(paramInt) });
        paramb.NR();
      }
      AppMethodBeat.o(284320);
      return;
    }
    a(paramn, paramAppBrandPreloadProfiler, paramInt);
    AppMethodBeat.o(284320);
  }
  
  public static boolean a(n paramn, b paramb, String paramString)
  {
    AppMethodBeat.i(284323);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s], sCacheServices.size[%d], sCachePageView.size[%d], message[%s]", new Object[] { qRq.p(paramn).name(), Integer.valueOf(((Queue)qRt.get(paramn)).size()), Integer.valueOf(((Queue)qRs.get(paramn)).size()), Util.nullAsNil(paramString) });
        if (qRq.p(paramn) == c.qRG)
        {
          ((HashSet)qRr.get(paramn)).add(paramb);
          ((AppBrandPreloadProfiler)qRu.get(paramn)).qRp = SystemClock.elapsedRealtime();
          return true;
        }
        if (!b.ciL()) {
          break label292;
        }
        if (qRq.p(paramn) == c.qRF)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          ((HashSet)qRr.get(paramn)).add(paramb);
          qRq.a(paramn, c.qRG);
          i = 1;
          if (i != 0)
          {
            a(paramn, null, 2);
            AppMethodBeat.o(284323);
            return true;
          }
        }
        else
        {
          if ((!qRq.q(paramn)) || (i(paramn) != null)) {
            break label292;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          c(paramn);
          ((HashSet)qRr.get(paramn)).add(paramb);
          qRq.a(paramn, c.qRG);
          i = 1;
          continue;
        }
        AppMethodBeat.o(284323);
      }
      finally
      {
        AppMethodBeat.o(284323);
      }
      return false;
      label292:
      int i = 0;
    }
  }
  
  private static void c(n paramn)
  {
    try
    {
      AppMethodBeat.i(284315);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "reset() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      qRq.a(paramn, c.qRF);
      AppMethodBeat.o(284315);
      return;
    }
    finally
    {
      paramn = finally;
      throw paramn;
    }
  }
  
  /* Error */
  private static n[] ciW()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 518
    //   6: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 76	com/tencent/mm/plugin/appbrand/task/h:qRt	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: getstatic 94	com/tencent/mm/plugin/appbrand/task/n:qRS	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   15: invokevirtual 521	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   18: ifeq +136 -> 154
    //   21: getstatic 76	com/tencent/mm/plugin/appbrand/task/h:qRt	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: getstatic 94	com/tencent/mm/plugin/appbrand/task/n:qRS	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   27: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 392	java/util/Queue
    //   33: invokeinterface 524 1 0
    //   38: ifne +116 -> 154
    //   41: iconst_1
    //   42: istore_0
    //   43: getstatic 76	com/tencent/mm/plugin/appbrand/task/h:qRt	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: getstatic 84	com/tencent/mm/plugin/appbrand/task/n:qRT	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   49: invokevirtual 521	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   52: ifeq +107 -> 159
    //   55: getstatic 76	com/tencent/mm/plugin/appbrand/task/h:qRt	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: getstatic 84	com/tencent/mm/plugin/appbrand/task/n:qRT	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   61: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 392	java/util/Queue
    //   67: invokeinterface 524 1 0
    //   72: ifne +87 -> 159
    //   75: iconst_1
    //   76: istore_1
    //   77: new 526	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 527	java/util/ArrayList:<init>	()V
    //   84: astore_3
    //   85: iload_0
    //   86: ifeq +13 -> 99
    //   89: aload_3
    //   90: getstatic 94	com/tencent/mm/plugin/appbrand/task/n:qRS	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   93: invokeinterface 530 2 0
    //   98: pop
    //   99: iload_1
    //   100: ifeq +13 -> 113
    //   103: aload_3
    //   104: getstatic 84	com/tencent/mm/plugin/appbrand/task/n:qRT	Lcom/tencent/mm/plugin/appbrand/task/n;
    //   107: invokeinterface 530 2 0
    //   112: pop
    //   113: aload_3
    //   114: invokeinterface 531 1 0
    //   119: iconst_2
    //   120: if_icmpgt +44 -> 164
    //   123: iconst_1
    //   124: istore_2
    //   125: iload_2
    //   126: invokestatic 537	junit/framework/Assert:assertTrue	(Z)V
    //   129: aload_3
    //   130: iconst_0
    //   131: anewarray 80	com/tencent/mm/plugin/appbrand/task/n
    //   134: invokeinterface 541 2 0
    //   139: checkcast 543	[Lcom/tencent/mm/plugin/appbrand/task/n;
    //   142: astore_3
    //   143: ldc_w 518
    //   146: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static n[] ciX()
  {
    try
    {
      AppMethodBeat.i(284317);
      a locala = qRq;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = locala.qRE.entrySet().iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)((Map.Entry)localIterator.next()).getKey();
        if (locala.q(localn)) {
          localArrayList.add(localn);
        }
      }
      arrayOfn = (n[])localArrayList.toArray(new n[0]);
    }
    finally {}
    n[] arrayOfn;
    AppMethodBeat.o(284317);
    return arrayOfn;
  }
  
  public static void ciY()
  {
    for (;;)
    {
      int i;
      n localn;
      Object localObject2;
      try
      {
        AppMethodBeat.i(48384);
        n[] arrayOfn = ciW();
        int j = arrayOfn.length;
        i = 0;
        if (i >= j) {
          break label153;
        }
        localn = arrayOfn[i];
        if (!j(localn)) {
          break label163;
        }
        localObject2 = (Queue)qRt.get(localn);
        if (localObject2 != null)
        {
          localObject2 = ((Queue)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ((v)((Iterator)localObject2).next()).cleanup();
            continue;
          }
        }
        localObject2 = (Queue)qRs.get(localn);
      }
      finally {}
      if (localObject2 != null)
      {
        localObject2 = ((Queue)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ah)((Iterator)localObject2).next()).cleanup();
        }
      }
      a(localn, null, true);
      break label163;
      label153:
      AppMethodBeat.o(48384);
      return;
      label163:
      i += 1;
    }
  }
  
  public static boolean ciZ()
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
  
  private static void d(n paramn)
  {
    AppMethodBeat.i(284322);
    Queue localQueue = (Queue)Objects.requireNonNull(qRt.get(paramn));
    if (!localQueue.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload services skipped cause already cached");
      com.tencent.mm.plugin.report.service.h.IzE.el(915, 34);
      AppMethodBeat.o(284322);
      return;
    }
    v localv = (v)org.a.a.ce(paramn.qRW).iVg().object;
    localv.a(WxaCommLibRuntimeReader.bHe());
    localv.adD();
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBd, 1) == 1)
      {
        u localu = (u)localv.getJsRuntime().Q(u.class);
        if (localu != null) {
          localu.pause();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preLoadServices() try invoke timer.pause() exception=%s", new Object[] { localException });
      }
    }
    localQueue.add(localv);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { paramn });
    AppMethodBeat.o(284322);
  }
  
  public static com.tencent.mm.vending.g.c<Void> e(n paramn)
  {
    AppMethodBeat.i(284324);
    try
    {
      if (qRq.p(paramn) == c.qRG)
      {
        f localf = com.tencent.mm.cw.g.ijP();
        Object localObject = localf.ieE();
        ((com.tencent.mm.vending.g.b)localObject).ieD();
        localObject = new b()
        {
          public final void NR()
          {
            AppMethodBeat.i(48374);
            this.cyp.resume();
            AppMethodBeat.o(48374);
          }
        };
        ((HashSet)qRr.get(paramn)).add(localObject);
        return localf;
      }
      paramn = com.tencent.mm.cw.g.ijP();
      return paramn;
    }
    finally
    {
      AppMethodBeat.o(284324);
    }
  }
  
  public static AppBrandPreloadProfiler f(n paramn)
  {
    AppMethodBeat.i(284325);
    paramn = (AppBrandPreloadProfiler)qRu.get(paramn);
    AppMethodBeat.o(284325);
    return paramn;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c g(n paramn)
  {
    AppMethodBeat.i(284326);
    Assert.assertNotSame(paramn, n.qRU);
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.report.service.h localh;
    if (paramn == n.qRT)
    {
      i = 12;
      ((com.tencent.mm.plugin.report.service.h)localObject).el(915, i);
      localh = null;
      Queue localQueue = (Queue)qRt.get(paramn);
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
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (paramn != n.qRT) {
          break label145;
        }
      }
    }
    label145:
    for (int i = 7;; i = 2)
    {
      localh.el(915, i);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getServices: ret = [%s]", new Object[] { localObject });
      AppMethodBeat.o(284326);
      return localObject;
      i = 10;
      break;
    }
  }
  
  public static ah h(n paramn)
  {
    AppMethodBeat.i(284327);
    Assert.assertNotSame(paramn, n.qRU);
    Queue localQueue = (Queue)qRs.get(paramn);
    Object localObject = null;
    paramn = localObject;
    if (localQueue != null)
    {
      paramn = localObject;
      if (!localQueue.isEmpty())
      {
        paramn = (ah)localQueue.poll();
        Assert.assertTrue(localQueue.isEmpty());
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPageView: [%s]", new Object[] { paramn });
    AppMethodBeat.o(284327);
    return paramn;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c i(n paramn)
  {
    AppMethodBeat.i(284328);
    Assert.assertNotSame(paramn, n.qRU);
    paramn = (Queue)qRt.get(paramn);
    if ((paramn != null) && (!paramn.isEmpty()))
    {
      paramn = (com.tencent.mm.plugin.appbrand.service.c)paramn.peek();
      AppMethodBeat.o(284328);
      return paramn;
    }
    AppMethodBeat.o(284328);
    return null;
  }
  
  public static boolean j(n paramn)
  {
    try
    {
      AppMethodBeat.i(284330);
      boolean bool = qRq.q(paramn);
      AppMethodBeat.o(284330);
      return bool;
    }
    finally
    {
      paramn = finally;
      throw paramn;
    }
  }
  
  public static boolean k(n paramn)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(284332);
        boolean bool;
        if (!j(paramn))
        {
          AppMethodBeat.o(284332);
          bool = true;
          return bool;
        }
        com.tencent.mm.plugin.appbrand.service.c localc = i(paramn);
        Assert.assertNotSame(paramn, n.qRU);
        localObject = (Queue)qRs.get(paramn);
        if ((localObject != null) && (!((Queue)localObject).isEmpty()))
        {
          localObject = (ah)((Queue)localObject).peek();
          if (paramn == n.qRT)
          {
            if (localc == null)
            {
              AppMethodBeat.o(284332);
              bool = true;
              continue;
            }
            AppMethodBeat.o(284332);
            bool = false;
            continue;
          }
          if (paramn == n.qRS)
          {
            if ((localc == null) || (localObject == null))
            {
              AppMethodBeat.o(284332);
              bool = true;
              continue;
            }
            AppMethodBeat.o(284332);
            bool = false;
            continue;
          }
          paramn = new IllegalStateException("not supported type: " + paramn.name());
          AppMethodBeat.o(284332);
          throw paramn;
        }
      }
      finally {}
      Object localObject = null;
    }
  }
  
  public static c l(n paramn)
  {
    AppMethodBeat.i(284333);
    paramn = qRq.p(paramn);
    AppMethodBeat.o(284333);
    return paramn;
  }
  
  static final class a
  {
    final Map<n, h.c> qRE;
    
    public a()
    {
      AppMethodBeat.i(264419);
      this.qRE = new ConcurrentHashMap();
      this.qRE.put(n.qRS, h.c.qRF);
      this.qRE.put(n.qRT, h.c.qRF);
      AppMethodBeat.o(264419);
    }
    
    public final void a(n paramn, h.c paramc)
    {
      AppMethodBeat.i(264421);
      this.qRE.put(paramn, paramc);
      AppMethodBeat.o(264421);
    }
    
    public final h.c p(n paramn)
    {
      AppMethodBeat.i(264420);
      paramn = (h.c)this.qRE.get(paramn);
      AppMethodBeat.o(264420);
      return paramn;
    }
    
    public final boolean q(n paramn)
    {
      AppMethodBeat.i(264422);
      paramn = (h.c)this.qRE.get(paramn);
      if ((paramn == h.c.qRI) || (paramn == h.c.qRH))
      {
        AppMethodBeat.o(264422);
        return true;
      }
      AppMethodBeat.o(264422);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void NR();
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(48380);
      qRF = new c("NOT_PRELOAD", 0);
      qRG = new c("PRELOADING", 1);
      qRH = new c("PRELOADED_DOWNGRADE", 2);
      qRI = new c("PRELOADED_FULL", 3);
      qRJ = new c[] { qRF, qRG, qRH, qRI };
      AppMethodBeat.o(48380);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */