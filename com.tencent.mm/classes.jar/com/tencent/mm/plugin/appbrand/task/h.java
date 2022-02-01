package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.ag.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.n.u;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.LooperCompat;
import com.tencent.xweb.ao;
import com.tencent.xweb.x5.a.e;
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

public class h
{
  public static int epc;
  private static final a tVY;
  private static final ConcurrentHashMap<l, HashSet<h.b>> tVZ;
  private static final ConcurrentHashMap<l, Queue<com.tencent.mm.plugin.appbrand.page.ah>> tWa;
  private static final ConcurrentHashMap<l, Queue<y>> tWb;
  private static final ConcurrentHashMap<l, AppBrandPreloadProfiler> tWc;
  private static volatile boolean tWd;
  private static volatile boolean tWe;
  
  static
  {
    AppMethodBeat.i(48405);
    epc = -1;
    tVY = new a();
    tVZ = new ConcurrentHashMap();
    tWa = new ConcurrentHashMap();
    tWb = new ConcurrentHashMap();
    tWc = new ConcurrentHashMap();
    com.tencent.mm.plugin.appbrand.d.cbf();
    tWa.put(l.tWx, new ConcurrentLinkedQueue());
    tWa.put(l.tWw, new ConcurrentLinkedQueue());
    tWb.put(l.tWx, new ConcurrentLinkedQueue());
    tWb.put(l.tWw, new ConcurrentLinkedQueue());
    tVZ.put(l.tWx, new HashSet());
    tVZ.put(l.tWw, new HashSet());
    tWd = false;
    tWe = false;
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
  
  private static void a(int paramInt, l paraml)
  {
    AppMethodBeat.i(318675);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished level:%d type [%s]", new Object[] { Integer.valueOf(paramInt), paraml.name() });
    ((AppBrandPreloadProfiler)tWc.get(paraml)).cJQ();
    tWc.get(paraml);
    AppBrandPreloadProfiler.at(new kotlin.g.a.a() {});
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    int i;
    if (paraml == l.tWx)
    {
      i = 6;
      ((com.tencent.mm.plugin.report.service.h)localObject).kJ(915, i);
      if (paramInt != 2) {
        break label184;
      }
    }
    for (;;)
    {
      try
      {
        tVY.a(paraml, c.tWo);
        localObject = new LinkedList((Collection)tVZ.get(paraml));
        ((HashSet)tVZ.get(paraml)).clear();
        localObject = ((Collection)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label208;
        }
        h.b localb = (h.b)((Iterator)localObject).next();
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
        AppMethodBeat.o(318675);
      }
      tVY.a(paraml, c.tWn);
    }
    label208:
    LooperCompat.addMainLooperIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(48377);
        com.tencent.mm.plugin.appbrand.page.h localh = com.tencent.mm.plugin.appbrand.page.h.ttR;
        com.tencent.mm.plugin.appbrand.page.h.a(h.this);
        AppMethodBeat.o(48377);
        return false;
      }
    });
    AppMethodBeat.o(318675);
  }
  
  private static void a(l paraml, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final int paramInt)
  {
    AppMethodBeat.i(318611);
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.level = paramInt;
    tWc.put(paraml, localAppBrandPreloadProfiler);
    paramAppBrandPreloadProfiler = com.tencent.mm.plugin.report.service.h.OAn;
    if (paraml == l.tWx) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.kJ(915, i);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      if (paramInt != 0) {
        break;
      }
      a(paramInt, paraml);
      AppMethodBeat.o(318611);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 37
        //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 45
        //   7: ldc 47
        //   9: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: invokestatic 56	com/tencent/mm/plugin/appbrand/task/h:bTA	()Ljava/util/concurrent/ConcurrentHashMap;
        //   15: aload_0
        //   16: getfield 29	com/tencent/mm/plugin/appbrand/task/h$1:qBq	Lcom/tencent/mm/plugin/appbrand/task/l;
        //   19: invokevirtual 62	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   22: checkcast 64	com/tencent/mm/plugin/appbrand/task/AppBrandPreloadProfiler
        //   25: invokestatic 70	android/os/SystemClock:elapsedRealtime	()J
        //   28: putfield 74	com/tencent/mm/plugin/appbrand/task/AppBrandPreloadProfiler:startTime	J
        //   31: iconst_1
        //   32: invokestatic 80	com/tencent/mm/plugin/expansions/e:requestSync	(Z)Z
        //   35: pop
        //   36: bipush 254
        //   38: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   41: iconst_1
        //   42: invokestatic 91	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fn	(Z)V
        //   45: invokestatic 97	com/tencent/mm/plugin/appbrand/n/ad:cpf	()Ljava/lang/String;
        //   48: pop
        //   49: aload_0
        //   50: getfield 29	com/tencent/mm/plugin/appbrand/task/h$1:qBq	Lcom/tencent/mm/plugin/appbrand/task/l;
        //   53: getstatic 102	com/tencent/mm/plugin/appbrand/task/l:tWx	Lcom/tencent/mm/plugin/appbrand/task/l;
        //   56: if_acmpne +75 -> 131
        //   59: invokestatic 105	com/tencent/mm/plugin/appbrand/task/h:access$200	()V
        //   62: ldc 45
        //   64: ldc 107
        //   66: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   69: ldc 45
        //   71: ldc 109
        //   73: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   76: bipush 10
        //   78: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   81: ldc 37
        //   83: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   86: return
        //   87: astore_1
        //   88: ldc 45
        //   90: ldc 114
        //   92: iconst_1
        //   93: anewarray 4	java/lang/Object
        //   96: dup
        //   97: iconst_0
        //   98: aload_1
        //   99: invokestatic 120	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   102: aastore
        //   103: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   106: aload_0
        //   107: getfield 29	com/tencent/mm/plugin/appbrand/task/h$1:qBq	Lcom/tencent/mm/plugin/appbrand/task/l;
        //   110: invokestatic 128	com/tencent/mm/plugin/appbrand/task/h:m	(Lcom/tencent/mm/plugin/appbrand/task/l;)V
        //   113: ldc 45
        //   115: ldc 109
        //   117: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   120: bipush 10
        //   122: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   125: ldc 37
        //   127: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   130: return
        //   131: new 130	com/tencent/luggage/sdk/h/b
        //   134: dup
        //   135: new 13	com/tencent/mm/plugin/appbrand/task/h$1$1
        //   138: dup
        //   139: aload_0
        //   140: invokespecial 133	com/tencent/mm/plugin/appbrand/task/h$1$1:<init>	(Lcom/tencent/mm/plugin/appbrand/task/h$1;)V
        //   143: iconst_2
        //   144: invokespecial 136	com/tencent/luggage/sdk/h/b:<init>	(Ljava/lang/Runnable;I)V
        //   147: astore_1
        //   148: aload_0
        //   149: getfield 31	com/tencent/mm/plugin/appbrand/task/h$1:val$level	I
        //   152: iconst_2
        //   153: if_icmplt +132 -> 285
        //   156: new 15	com/tencent/mm/plugin/appbrand/task/h$1$2
        //   159: dup
        //   160: aload_0
        //   161: aload_1
        //   162: invokespecial 139	com/tencent/mm/plugin/appbrand/task/h$1$2:<init>	(Lcom/tencent/mm/plugin/appbrand/task/h$1;Lcom/tencent/luggage/sdk/h/b;)V
        //   165: astore_2
        //   166: invokestatic 145	com/tencent/mm/plugin/appbrand/ag:cdu	()Z
        //   169: ifeq +54 -> 223
        //   172: ldc 45
        //   174: ldc 147
        //   176: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   179: aload_2
        //   180: invokestatic 151	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   183: new 19	com/tencent/mm/plugin/appbrand/task/h$1$4
        //   186: dup
        //   187: aload_0
        //   188: aload_1
        //   189: invokespecial 152	com/tencent/mm/plugin/appbrand/task/h$1$4:<init>	(Lcom/tencent/mm/plugin/appbrand/task/h$1;Lcom/tencent/luggage/sdk/h/b;)V
        //   192: astore_1
        //   193: getstatic 158	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
        //   196: aload_1
        //   197: ldc 160
        //   199: invokeinterface 166 3 0
        //   204: pop
        //   205: ldc 45
        //   207: ldc 109
        //   209: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   212: bipush 10
        //   214: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   217: ldc 37
        //   219: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   222: return
        //   223: new 17	com/tencent/mm/plugin/appbrand/task/h$1$3
        //   226: dup
        //   227: aload_0
        //   228: invokestatic 171	java/lang/System:currentTimeMillis	()J
        //   231: aload_2
        //   232: invokespecial 174	com/tencent/mm/plugin/appbrand/task/h$1$3:<init>	(Lcom/tencent/mm/plugin/appbrand/task/h$1;JLjava/lang/Runnable;)V
        //   235: invokestatic 177	com/tencent/mm/plugin/appbrand/ag:a	(Lcom/tencent/mm/plugin/appbrand/ag$a;)V
        //   238: goto -55 -> 183
        //   241: astore_1
        //   242: aload_0
        //   243: getfield 29	com/tencent/mm/plugin/appbrand/task/h$1:qBq	Lcom/tencent/mm/plugin/appbrand/task/l;
        //   246: invokestatic 128	com/tencent/mm/plugin/appbrand/task/h:m	(Lcom/tencent/mm/plugin/appbrand/task/l;)V
        //   249: invokestatic 182	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
        //   252: ifeq +47 -> 299
        //   255: new 21	com/tencent/mm/plugin/appbrand/task/h$1$5
        //   258: dup
        //   259: aload_0
        //   260: aload_1
        //   261: invokespecial 185	com/tencent/mm/plugin/appbrand/task/h$1$5:<init>	(Lcom/tencent/mm/plugin/appbrand/task/h$1;Ljava/lang/Throwable;)V
        //   264: invokestatic 151	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   267: ldc 45
        //   269: ldc 109
        //   271: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   274: bipush 10
        //   276: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   279: ldc 37
        //   281: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   284: return
        //   285: ldc 45
        //   287: ldc 187
        //   289: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   292: aload_1
        //   293: invokevirtual 190	com/tencent/luggage/sdk/h/b:asP	()V
        //   296: goto -113 -> 183
        //   299: ldc 45
        //   301: aload_1
        //   302: ldc 192
        //   304: iconst_0
        //   305: anewarray 4	java/lang/Object
        //   308: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   311: goto -44 -> 267
        //   314: astore_1
        //   315: ldc 45
        //   317: ldc 109
        //   319: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   322: bipush 10
        //   324: invokestatic 85	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
        //   327: ldc 37
        //   329: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   332: aload_1
        //   333: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	334	0	this	1
        //   87	12	1	localThrowable1	Throwable
        //   147	50	1	localObject1	Object
        //   241	61	1	localThrowable2	Throwable
        //   314	19	1	localObject2	Object
        //   165	67	2	local2	2
        // Exception table:
        //   from	to	target	type
        //   41	49	87	finally
        //   5	41	241	finally
        //   49	69	241	finally
        //   88	113	241	finally
        //   131	183	241	finally
        //   183	205	241	finally
        //   223	238	241	finally
        //   285	296	241	finally
        //   242	267	314	finally
        //   299	311	314	finally
      }
    }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
    com.tencent.luggage.sdk.h.d.a("preload AppBrandUI classes", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48373);
        try
        {
          if (h.this.tVU != null) {
            Class.forName(h.this.tVU).newInstance();
          }
          if (h.this.tVV != null) {
            Class.forName(h.this.tVV).newInstance();
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
    AppMethodBeat.o(318611);
  }
  
  public static void a(l paraml, h.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(318598);
    a(paraml, paramb, paramBoolean, null, 2);
    AppMethodBeat.o(318598);
  }
  
  public static void a(l paraml, h.b paramb, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, int paramInt)
  {
    AppMethodBeat.i(318605);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s] level = [%d], force[%b]", new Object[] { paraml.name(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paraml == l.tWy)
    {
      paraml = new IllegalArgumentException("can not preload with a specific service type");
      AppMethodBeat.o(318605);
      throw paraml;
    }
    c localc;
    try
    {
      if ((tVY.q(paraml)) && (paramBoolean)) {
        c(paraml);
      }
      localc = tVY.p(paraml);
      if ((localc == c.tWl) || (localc == c.tWm) || ((localc == c.tWn) && (paramInt >= 2)))
      {
        if (paramb != null) {
          ((HashSet)tVZ.get(paraml)).add(paramb);
        }
        tVY.a(paraml, c.tWm);
      }
      if (localc == c.tWm)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: type [%s] is preloading, just return", new Object[] { paraml.name() });
        AppMethodBeat.o(318605);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(318605);
    }
    if ((localc == c.tWo) || ((localc == c.tWn) && (paramInt < 2)))
    {
      if (paramb != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: [%s] [%d] preload finished", new Object[] { paraml.name(), Integer.valueOf(paramInt) });
        paramb.onReady();
      }
      AppMethodBeat.o(318605);
      return;
    }
    a(paraml, paramAppBrandPreloadProfiler, paramInt);
    AppMethodBeat.o(318605);
  }
  
  public static boolean a(l paraml, h.b paramb, String paramString)
  {
    AppMethodBeat.i(318637);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s], sCacheServices.size[%d], sCachePageView.size[%d], message[%s]", new Object[] { tVY.p(paraml).name(), Integer.valueOf(((Queue)tWb.get(paraml)).size()), Integer.valueOf(((Queue)tWa.get(paraml)).size()), Util.nullAsNil(paramString) });
        if (tVY.p(paraml) == c.tWm)
        {
          ((HashSet)tVZ.get(paraml)).add(paramb);
          ((AppBrandPreloadProfiler)tWc.get(paraml)).tVX = SystemClock.elapsedRealtime();
          return true;
        }
        if (!b.cJE()) {
          break label292;
        }
        if (tVY.p(paraml) == c.tWl)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (not preload currently)");
          ((HashSet)tVZ.get(paraml)).add(paramb);
          tVY.a(paraml, c.tWm);
          i = 1;
          if (i != 0)
          {
            a(paraml, null, 2);
            AppMethodBeat.o(318637);
            return true;
          }
        }
        else
        {
          if ((!tVY.q(paraml)) || (i(paraml) != null)) {
            break label292;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[ForcePreload] wait preload (preloaded)");
          c(paraml);
          ((HashSet)tVZ.get(paraml)).add(paramb);
          tVY.a(paraml, c.tWm);
          i = 1;
          continue;
        }
        AppMethodBeat.o(318637);
      }
      finally
      {
        AppMethodBeat.o(318637);
      }
      return false;
      label292:
      int i = 0;
    }
  }
  
  private static void c(l paraml)
  {
    try
    {
      AppMethodBeat.i(318587);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "reset() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      tVY.a(paraml, c.tWl);
      AppMethodBeat.o(318587);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  /* Error */
  private static l[] cJR()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 470
    //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 73	com/tencent/mm/plugin/appbrand/task/h:tWb	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: getstatic 96	com/tencent/mm/plugin/appbrand/task/l:tWw	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   15: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   18: ifeq +136 -> 154
    //   21: getstatic 73	com/tencent/mm/plugin/appbrand/task/h:tWb	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: getstatic 96	com/tencent/mm/plugin/appbrand/task/l:tWw	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   27: invokevirtual 154	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 389	java/util/Queue
    //   33: invokeinterface 476 1 0
    //   38: ifne +116 -> 154
    //   41: iconst_1
    //   42: istore_0
    //   43: getstatic 73	com/tencent/mm/plugin/appbrand/task/h:tWb	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: getstatic 86	com/tencent/mm/plugin/appbrand/task/l:tWx	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   49: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   52: ifeq +107 -> 159
    //   55: getstatic 73	com/tencent/mm/plugin/appbrand/task/h:tWb	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: getstatic 86	com/tencent/mm/plugin/appbrand/task/l:tWx	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   61: invokevirtual 154	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 389	java/util/Queue
    //   67: invokeinterface 476 1 0
    //   72: ifne +87 -> 159
    //   75: iconst_1
    //   76: istore_1
    //   77: new 478	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 479	java/util/ArrayList:<init>	()V
    //   84: astore_3
    //   85: iload_0
    //   86: ifeq +13 -> 99
    //   89: aload_3
    //   90: getstatic 96	com/tencent/mm/plugin/appbrand/task/l:tWw	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   93: invokeinterface 482 2 0
    //   98: pop
    //   99: iload_1
    //   100: ifeq +13 -> 113
    //   103: aload_3
    //   104: getstatic 86	com/tencent/mm/plugin/appbrand/task/l:tWx	Lcom/tencent/mm/plugin/appbrand/task/l;
    //   107: invokeinterface 482 2 0
    //   112: pop
    //   113: aload_3
    //   114: invokeinterface 483 1 0
    //   119: iconst_2
    //   120: if_icmpgt +44 -> 164
    //   123: iconst_1
    //   124: istore_2
    //   125: iload_2
    //   126: invokestatic 489	junit/framework/Assert:assertTrue	(Z)V
    //   129: aload_3
    //   130: iconst_0
    //   131: anewarray 82	com/tencent/mm/plugin/appbrand/task/l
    //   134: invokeinterface 493 2 0
    //   139: checkcast 495	[Lcom/tencent/mm/plugin/appbrand/task/l;
    //   142: astore_3
    //   143: ldc_w 470
    //   146: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static l[] cJS()
  {
    try
    {
      AppMethodBeat.i(318594);
      a locala = tVY;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = locala.tWk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)((Map.Entry)localIterator.next()).getKey();
        if (locala.q(locall)) {
          localArrayList.add(locall);
        }
      }
      arrayOfl = (l[])localArrayList.toArray(new l[0]);
    }
    finally {}
    l[] arrayOfl;
    AppMethodBeat.o(318594);
    return arrayOfl;
  }
  
  public static void cJT()
  {
    for (;;)
    {
      int i;
      l locall;
      Object localObject2;
      try
      {
        AppMethodBeat.i(48384);
        l[] arrayOfl = cJR();
        int j = arrayOfl.length;
        i = 0;
        if (i >= j) {
          break label153;
        }
        locall = arrayOfl[i];
        if (!j(locall)) {
          break label163;
        }
        localObject2 = (Queue)tWb.get(locall);
        if (localObject2 != null)
        {
          localObject2 = ((Queue)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ((y)((Iterator)localObject2).next()).cleanup();
            continue;
          }
        }
        localObject2 = (Queue)tWa.get(locall);
      }
      finally {}
      if (localObject2 != null)
      {
        localObject2 = ((Queue)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((com.tencent.mm.plugin.appbrand.page.ah)((Iterator)localObject2).next()).cleanup();
        }
      }
      a(locall, null, true);
      break label163;
      label153:
      AppMethodBeat.o(48384);
      return;
      label163:
      i += 1;
    }
  }
  
  public static boolean cJU()
  {
    AppMethodBeat.i(48395);
    if (ao.kgl())
    {
      AppMethodBeat.o(48395);
      return true;
    }
    if (ao.kgm())
    {
      if (ao.getUsingTbsCoreVersion(MMApplicationContext.getContext()) == 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
        AppMethodBeat.o(48395);
        return true;
      }
      if (!e.canOpenWebPlus(MMApplicationContext.getContext()))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
        AppMethodBeat.o(48395);
        return true;
      }
    }
    AppMethodBeat.o(48395);
    return false;
  }
  
  private static void d(l paraml)
  {
    AppMethodBeat.i(318628);
    Queue localQueue = (Queue)Objects.requireNonNull((Queue)tWb.get(paraml));
    if (!localQueue.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload services skipped cause already cached");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(915, 34);
      AppMethodBeat.o(318628);
      return;
    }
    y localy = (y)org.a.a.cQ(paraml.tWA).kJE().object;
    localy.b(WxaCommLibRuntimeReader.cgA());
    localy.aFB();
    try
    {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOW, 1) == 1)
      {
        u localu = (u)localy.getJsRuntime().Z(u.class);
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
    localQueue.add(localy);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", new Object[] { paraml });
    AppMethodBeat.o(318628);
  }
  
  public static com.tencent.mm.vending.g.c<Void> e(l paraml)
  {
    AppMethodBeat.i(318645);
    try
    {
      if (tVY.p(paraml) == c.tWm)
      {
        f localf = g.jPX();
        Object localObject = localf.jJL();
        ((com.tencent.mm.vending.g.b)localObject).jJK();
        localObject = new h.b()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48374);
            h.this.resume();
            AppMethodBeat.o(48374);
          }
        };
        ((HashSet)tVZ.get(paraml)).add(localObject);
        return localf;
      }
      paraml = g.jPX();
      return paraml;
    }
    finally
    {
      AppMethodBeat.o(318645);
    }
  }
  
  public static AppBrandPreloadProfiler f(l paraml)
  {
    AppMethodBeat.i(318648);
    paraml = (AppBrandPreloadProfiler)tWc.get(paraml);
    AppMethodBeat.o(318648);
    return paraml;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c g(l paraml)
  {
    AppMethodBeat.i(318655);
    Assert.assertNotSame(paraml, l.tWy);
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h localh;
    if (paraml == l.tWx)
    {
      i = 12;
      ((com.tencent.mm.plugin.report.service.h)localObject).kJ(915, i);
      localh = null;
      Queue localQueue = (Queue)tWb.get(paraml);
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
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (paraml != l.tWx) {
          break label145;
        }
      }
    }
    label145:
    for (int i = 7;; i = 2)
    {
      localh.kJ(915, i);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getServices: ret = [%s]", new Object[] { localObject });
      AppMethodBeat.o(318655);
      return localObject;
      i = 10;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.page.ah h(l paraml)
  {
    AppMethodBeat.i(318663);
    Assert.assertNotSame(paraml, l.tWy);
    Queue localQueue = (Queue)tWa.get(paraml);
    Object localObject = null;
    paraml = localObject;
    if (localQueue != null)
    {
      paraml = localObject;
      if (!localQueue.isEmpty())
      {
        paraml = (com.tencent.mm.plugin.appbrand.page.ah)localQueue.poll();
        Assert.assertTrue(localQueue.isEmpty());
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPageView: [%s]", new Object[] { paraml });
    AppMethodBeat.o(318663);
    return paraml;
  }
  
  public static com.tencent.mm.plugin.appbrand.service.c i(l paraml)
  {
    AppMethodBeat.i(318667);
    Assert.assertNotSame(paraml, l.tWy);
    paraml = (Queue)tWb.get(paraml);
    if ((paraml != null) && (!paraml.isEmpty()))
    {
      paraml = (com.tencent.mm.plugin.appbrand.service.c)paraml.peek();
      AppMethodBeat.o(318667);
      return paraml;
    }
    AppMethodBeat.o(318667);
    return null;
  }
  
  public static boolean j(l paraml)
  {
    try
    {
      AppMethodBeat.i(318679);
      boolean bool = tVY.q(paraml);
      AppMethodBeat.o(318679);
      return bool;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public static boolean k(l paraml)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(318693);
        boolean bool;
        if (!j(paraml))
        {
          AppMethodBeat.o(318693);
          bool = true;
          return bool;
        }
        com.tencent.mm.plugin.appbrand.service.c localc = i(paraml);
        Assert.assertNotSame(paraml, l.tWy);
        localObject = (Queue)tWa.get(paraml);
        if ((localObject != null) && (!((Queue)localObject).isEmpty()))
        {
          localObject = (com.tencent.mm.plugin.appbrand.page.ah)((Queue)localObject).peek();
          if (paraml == l.tWx)
          {
            if (localc == null)
            {
              AppMethodBeat.o(318693);
              bool = true;
              continue;
            }
            AppMethodBeat.o(318693);
            bool = false;
            continue;
          }
          if (paraml == l.tWw)
          {
            if ((localc == null) || (localObject == null))
            {
              AppMethodBeat.o(318693);
              bool = true;
              continue;
            }
            AppMethodBeat.o(318693);
            bool = false;
            continue;
          }
          paraml = new IllegalStateException("not supported type: " + paraml.name());
          AppMethodBeat.o(318693);
          throw paraml;
        }
      }
      finally {}
      Object localObject = null;
    }
  }
  
  public static c l(l paraml)
  {
    AppMethodBeat.i(318704);
    paraml = tVY.p(paraml);
    AppMethodBeat.o(318704);
    return paraml;
  }
  
  static final class a
  {
    final Map<l, h.c> tWk;
    
    public a()
    {
      AppMethodBeat.i(318560);
      this.tWk = new ConcurrentHashMap();
      this.tWk.put(l.tWw, h.c.tWl);
      this.tWk.put(l.tWx, h.c.tWl);
      AppMethodBeat.o(318560);
    }
    
    public final void a(l paraml, h.c paramc)
    {
      AppMethodBeat.i(318570);
      this.tWk.put(paraml, paramc);
      AppMethodBeat.o(318570);
    }
    
    public final h.c p(l paraml)
    {
      AppMethodBeat.i(318566);
      paraml = (h.c)this.tWk.get(paraml);
      AppMethodBeat.o(318566);
      return paraml;
    }
    
    public final boolean q(l paraml)
    {
      AppMethodBeat.i(318573);
      paraml = (h.c)this.tWk.get(paraml);
      if ((paraml == h.c.tWo) || (paraml == h.c.tWn))
      {
        AppMethodBeat.o(318573);
        return true;
      }
      AppMethodBeat.o(318573);
      return false;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(48380);
      tWl = new c("NOT_PRELOAD", 0);
      tWm = new c("PRELOADING", 1);
      tWn = new c("PRELOADED_DOWNGRADE", 2);
      tWo = new c("PRELOADED_FULL", 3);
      tWp = new c[] { tWl, tWm, tWn, tWo };
      AppMethodBeat.o(48380);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */