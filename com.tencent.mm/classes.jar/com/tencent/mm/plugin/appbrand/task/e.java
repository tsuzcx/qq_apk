package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
{
  private static e.c iJZ;
  private static final HashSet<e.a> iKa;
  private static final Queue<v> iKb;
  private static final Queue<r> iKc;
  private static volatile String iKd;
  private static volatile String iKe;
  private static volatile AppBrandPreloadProfiler iKf;
  private static volatile g iKg;
  private static volatile boolean iKh;
  private static volatile boolean iKi;
  private static volatile boolean iKj;
  private static volatile int iKk;
  
  static
  {
    AppMethodBeat.i(132822);
    iJZ = e.c.iKr;
    iKa = new HashSet();
    iKb = new ConcurrentLinkedQueue();
    iKc = new ConcurrentLinkedQueue();
    iKd = null;
    iKe = null;
    iKf = null;
    iKg = g.iKU;
    iKh = false;
    iKi = false;
    iKj = false;
    iKk = 2147483647;
    AppMethodBeat.o(132822);
  }
  
  public static void EO(String paramString)
  {
    try
    {
      iKd = paramString;
      iKe = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static v EP(String paramString)
  {
    AppMethodBeat.i(132809);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(iKd)))
    {
      AppMethodBeat.o(132809);
      return null;
    }
    iKd = paramString;
    paramString = (v)iKb.poll();
    AppMethodBeat.o(132809);
    return paramString;
  }
  
  private static void Ss()
  {
    AppMethodBeat.i(132810);
    if (al.isMainThread())
    {
      done();
      AppMethodBeat.o(132810);
      return;
    }
    al.d(new e.2());
    AppMethodBeat.o(132810);
  }
  
  public static c a(String paramString, g paramg)
  {
    int j = 2;
    AppMethodBeat.i(143573);
    Object localObject = h.qsU;
    if (paramg == g.iKT) {}
    for (int i = 12;; i = 10)
    {
      ((h)localObject).cT(915, i);
      try
      {
        localObject = iJZ;
        if (localObject != e.c.iKr) {
          break;
        }
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader not preload, just return null");
        AppMethodBeat.o(143573);
        return null;
      }
      finally
      {
        AppMethodBeat.o(143573);
      }
    }
    if (localObject == e.c.iKs)
    {
      if ((f.IS_FLAVOR_RED) || (f.DEBUG))
      {
        paramString = new IllegalStateException("getServices when preloading");
        AppMethodBeat.o(143573);
        throw paramString;
      }
      ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
      AppMethodBeat.o(143573);
      return null;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(iKe)))
    {
      ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "CurrentService is occupied req = [%s] cur = [%s]", new Object[] { paramString, iKe });
      AppMethodBeat.o(143573);
      return null;
    }
    if (paramg != iKg)
    {
      ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
      AppMethodBeat.o(143573);
      return null;
    }
    iKe = paramString;
    paramString = (c)iKc.poll();
    if (paramString != null)
    {
      localObject = h.qsU;
      i = j;
      if (paramg == g.iKT) {
        i = 7;
      }
      ((h)localObject).cT(915, i);
    }
    AppMethodBeat.o(143573);
    return paramString;
  }
  
  private static String a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(132814);
    if ((paramLong1 != 9223372036854775807L) && (paramLong2 != 9223372036854775807L))
    {
      AppMethodBeat.o(132814);
      return String.valueOf(paramLong2 - paramLong1);
    }
    String str1;
    if (paramLong1 == 9223372036854775807L)
    {
      str1 = "?";
      if (paramLong2 != 9223372036854775807L) {
        break label101;
      }
    }
    label101:
    for (String str2 = "?";; str2 = "ok")
    {
      paramString1 = bo.p("Unkown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      AppMethodBeat.o(132814);
      return paramString1;
      str1 = "ok";
      break;
    }
  }
  
  private static void a(AppBrandPreloadProfiler paramAppBrandPreloadProfiler, g paramg)
  {
    AppMethodBeat.i(132813);
    if (paramAppBrandPreloadProfiler == null)
    {
      ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadProfile]" + "AppBrandPreloadProfiler == null");
      AppMethodBeat.o(132813);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[PreloadProfile]").append(" ");
    if (paramg == null)
    {
      paramg = "Unknown";
      paramg = localStringBuilder.append(bo.p("Preload for [%s]Type | ", new Object[] { paramg }));
      if (paramAppBrandPreloadProfiler.iJW != 9223372036854775807L) {
        break label284;
      }
    }
    label284:
    for (long l = -1L;; l = paramAppBrandPreloadProfiler.iJW)
    {
      ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", bo.p("Preload request at [%d] | ", new Object[] { Long.valueOf(l) }) + bo.p("Process prepared cost [%s]ms | ", new Object[] { a(paramAppBrandPreloadProfiler.iJW, "req", paramAppBrandPreloadProfiler.iJX, "proc") }) + bo.p("Trans-thread prepared cost [%s]ms | ", new Object[] { a(paramAppBrandPreloadProfiler.iJX, "proc", paramAppBrandPreloadProfiler.startTime, "start") }) + bo.p("Preload prepared cost [%s]ms | ", new Object[] { a(paramAppBrandPreloadProfiler.startTime, "start", paramAppBrandPreloadProfiler.endTime, "end") }) + bo.p("All cost [%s]ms ", new Object[] { a(paramAppBrandPreloadProfiler.iJW, "req", paramAppBrandPreloadProfiler.endTime, "end") }));
      AppMethodBeat.o(132813);
      return;
      paramg = paramg.name();
      break;
    }
  }
  
  private static void a(g paramg, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    AppMethodBeat.i(132805);
    if (iKg != g.iKU)
    {
      paramg = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
      AppMethodBeat.o(132805);
      throw paramg;
    }
    iKg = paramg;
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    iKf = localAppBrandPreloadProfiler;
    paramAppBrandPreloadProfiler = h.qsU;
    if (paramg == g.iKT) {}
    for (int i = 5;; i = 0)
    {
      paramAppBrandPreloadProfiler.cT(915, i);
      ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new e.1(paramg));
      AppMethodBeat.o(132805);
      return;
    }
  }
  
  public static void a(g paramg, e.a parama, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    AppMethodBeat.i(132804);
    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { paramg.name() });
    e.c localc;
    try
    {
      if ((iJZ == e.c.iKt) && (paramBoolean)) {
        reset();
      }
      localc = iJZ;
      if ((localc == e.c.iKr) || (localc == e.c.iKs))
      {
        if (parama != null) {
          iKa.add(parama);
        }
        iJZ = e.c.iKs;
      }
      if (localc == e.c.iKs)
      {
        AppMethodBeat.o(132804);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(132804);
    }
    if (localc == e.c.iKt)
    {
      if (parama != null) {
        parama.onReady();
      }
      AppMethodBeat.o(132804);
      return;
    }
    a(paramg, paramAppBrandPreloadProfiler);
    AppMethodBeat.o(132804);
  }
  
  public static boolean a(g paramg, e.a parama)
  {
    AppMethodBeat.i(132807);
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", new Object[] { iJZ.name() });
        if ((iJZ == e.c.iKs) && (paramg == iKg))
        {
          iKa.add(parama);
          iKf.iJY = SystemClock.elapsedRealtime();
          return true;
        }
        if (!b.aLC()) {
          break label210;
        }
        if (iJZ == e.c.iKr)
        {
          ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (not preload currently)");
          iKa.add(parama);
          iJZ = e.c.iKs;
          i = 1;
          if (i != 0)
          {
            a(paramg, null);
            AppMethodBeat.o(132807);
            return true;
          }
        }
        else
        {
          if ((iJZ != e.c.iKt) || ((iKg == paramg) && (iKc.peek() != null))) {
            break label210;
          }
          ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (preloaded)");
          reset();
          iKa.add(parama);
          iJZ = e.c.iKs;
          i = 1;
          continue;
        }
        AppMethodBeat.o(132807);
      }
      finally
      {
        AppMethodBeat.o(132807);
      }
      return false;
      label210:
      int i = 0;
    }
  }
  
  private static void aLJ()
  {
    AppMethodBeat.i(132806);
    if (iKc.size() > 0)
    {
      AppMethodBeat.o(132806);
      return;
    }
    if (iKg == g.iKT) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.b();; localObject = new c())
    {
      ((r)localObject).Do();
      iKc.add(localObject);
      AppMethodBeat.o(132806);
      return;
    }
  }
  
  public static AppBrandPreloadProfiler aLK()
  {
    return iKf;
  }
  
  public static r aLL()
  {
    AppMethodBeat.i(143574);
    try
    {
      r localr = (r)iKc.peek();
      return localr;
    }
    finally
    {
      AppMethodBeat.o(143574);
    }
  }
  
  public static boolean aLM()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(132812);
        if (e.c.iKr == iJZ)
        {
          AppMethodBeat.o(132812);
          return bool;
        }
        if ((aul()) && (iKb.size() <= 0) && (iKc.size() <= 0))
        {
          AppMethodBeat.o(132812);
          continue;
        }
        bool = false;
      }
      finally {}
      AppMethodBeat.o(132812);
    }
  }
  
  public static boolean aLN()
  {
    return iKi;
  }
  
  /* Error */
  public static boolean aul()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/tencent/mm/plugin/appbrand/task/e:iJZ	Lcom/tencent/mm/plugin/appbrand/task/e$c;
    //   6: astore_1
    //   7: getstatic 353	com/tencent/mm/plugin/appbrand/task/e$c:iKt	Lcom/tencent/mm/plugin/appbrand/task/e$c;
    //   10: astore_2
    //   11: aload_1
    //   12: aload_2
    //   13: if_acmpne +10 -> 23
    //   16: iconst_1
    //   17: istore_0
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_0
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_0
    //   25: goto -7 -> 18
    //   28: astore_1
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	8	0	bool	boolean
    //   6	6	1	localc1	e.c
    //   28	5	1	localObject	Object
    //   10	3	2	localc2	e.c
    // Exception table:
    //   from	to	target	type
    //   3	11	28	finally
  }
  
  private static void done()
  {
    AppMethodBeat.i(132811);
    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
    iKf.aLG();
    Object localObject1 = h.qsU;
    int i;
    if (iKg == g.iKT) {
      i = 6;
    }
    for (;;)
    {
      ((h)localObject1).cT(915, i);
      a(iKf, iKg);
      localObject1 = new LinkedList();
      try
      {
        iJZ = e.c.iKt;
        ((Collection)localObject1).addAll(iKa);
        iKa.clear();
        localObject1 = ((Collection)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            e.a locala = (e.a)((Iterator)localObject1).next();
            if (locala != null)
            {
              locala.onReady();
              continue;
              i = 1;
              break;
            }
          }
        }
      }
      finally
      {
        AppMethodBeat.o(132811);
      }
    }
    AppMethodBeat.o(132811);
  }
  
  private static void reset()
  {
    try
    {
      AppMethodBeat.i(132803);
      iJZ = e.c.iKr;
      iKa.clear();
      iKb.clear();
      iKc.clear();
      iKd = null;
      iKe = null;
      iKf = null;
      iKg = g.iKU;
      AppMethodBeat.o(132803);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */