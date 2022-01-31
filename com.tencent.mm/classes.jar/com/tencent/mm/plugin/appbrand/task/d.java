package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d
{
  private static d.b hbg = d.b.hbw;
  private static final HashSet<a> hbh = new HashSet();
  private static final Queue<q> hbi = new ConcurrentLinkedQueue();
  private static final Queue<o> hbj = new ConcurrentLinkedQueue();
  private static volatile String hbk = null;
  private static volatile String hbl = null;
  private static volatile AppBrandPreloadProfiler hbm = null;
  private static volatile f hbn = f.hbW;
  private static final com.tencent.mm.sdk.b.c hbo = new d.2();
  private static volatile boolean hbp = false;
  private static volatile boolean hbq = false;
  private static volatile boolean hbr = false;
  private static volatile int hbs = 2147483647;
  
  private static void Eo()
  {
    if (ai.isMainThread())
    {
      done();
      return;
    }
    ai.d(new Runnable()
    {
      public final void run() {}
    });
  }
  
  public static p a(String paramString, f paramf)
  {
    Object localObject = null;
    do
    {
      do
      {
        d.b localb;
        try
        {
          localb = hbg;
          if (localb == d.b.hbw)
          {
            y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader not preload, just return null");
            return localObject;
          }
        }
        finally {}
        if (localb == d.b.hbx)
        {
          if ((com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.d.DEBUG)) {
            throw new IllegalStateException("getServices when preloading");
          }
          y.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
          return null;
        }
      } while ((!bk.bl(paramString)) && (paramString.equals(hbl)));
      if (paramf != hbn)
      {
        y.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
        return null;
      }
      hbl = paramString;
      paramString = (p)hbj.poll();
      localObject = paramString;
    } while (hbj.poll() == null);
    localObject = h.nFQ;
    if (paramf == f.hbV) {}
    for (long l = 7L;; l = 2L)
    {
      ((h)localObject).h(915L, l, 1L);
      return paramString;
    }
  }
  
  private static String a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    if ((paramLong1 != 9223372036854775807L) && (paramLong2 != 9223372036854775807L)) {
      return String.valueOf(paramLong2 - paramLong1);
    }
    String str1;
    if (paramLong1 == 9223372036854775807L)
    {
      str1 = "?";
      if (paramLong2 != 9223372036854775807L) {
        break label83;
      }
    }
    label83:
    for (String str2 = "?";; str2 = "ok")
    {
      return bk.q("Unkown(%s=%s,%s=%s)", new Object[] { paramString1, str1, paramString2, str2 });
      str1 = "ok";
      break;
    }
  }
  
  public static void a(f paramf, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandPreloader.preload serviceType = [%s]", new Object[] { paramf.name() });
    do
    {
      try
      {
        if ((hbg == d.b.hby) && (paramBoolean)) {
          reset();
        }
        localObject = hbg;
        if ((localObject == d.b.hbw) || (localObject == d.b.hbx)) {
          hbg = d.b.hbx;
        }
        if (localObject == d.b.hbx) {
          return;
        }
      }
      finally {}
    } while (localObject == d.b.hby);
    if (hbn != f.hbW) {
      throw new IllegalStateException("AppBrandPreloader.preload preload sServiceType is nil");
    }
    hbn = paramf;
    Object localObject = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localObject = new AppBrandPreloadProfiler();
    }
    hbm = (AppBrandPreloadProfiler)localObject;
    paramAppBrandPreloadProfiler = h.nFQ;
    if (paramf == f.hbV) {}
    for (long l = 5L;; l = 0L)
    {
      paramAppBrandPreloadProfiler.h(915L, l, 1L);
      y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
      com.tencent.mm.plugin.appbrand.v.c.DS().O(new d.1(paramf));
      return;
    }
  }
  
  public static boolean a(a parama)
  {
    try
    {
      y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", new Object[] { hbg.name() });
      if (hbg == d.b.hbx)
      {
        hbh.add(parama);
        hbm.hbf = SystemClock.elapsedRealtime();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  /* Error */
  public static boolean aaE()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/tencent/mm/plugin/appbrand/task/d:hbg	Lcom/tencent/mm/plugin/appbrand/task/d$b;
    //   6: astore_1
    //   7: getstatic 253	com/tencent/mm/plugin/appbrand/task/d$b:hby	Lcom/tencent/mm/plugin/appbrand/task/d$b;
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
    //   6	6	1	localb1	d.b
    //   28	5	1	localObject	Object
    //   10	3	2	localb2	d.b
    // Exception table:
    //   from	to	target	type
    //   3	11	28	finally
  }
  
  private static void aoD()
  {
    if (hbj.size() > 0) {
      return;
    }
    if (hbn == f.hbV) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.c();; localObject = new p())
    {
      ((o)localObject).EV();
      hbj.add(localObject);
      return;
    }
  }
  
  public static AppBrandPreloadProfiler aoE()
  {
    return hbm;
  }
  
  public static boolean aoF()
  {
    return hbq;
  }
  
  private static void done()
  {
    y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
    hbm.endTime = SystemClock.elapsedRealtime();
    Object localObject1 = h.nFQ;
    if (hbn == f.hbV) {
      l = 6L;
    }
    label398:
    for (;;)
    {
      ((h)localObject1).h(915L, l, 1L);
      Object localObject3 = hbm;
      localObject1 = hbn;
      if (localObject3 == null)
      {
        y.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadProfile]" + "AppBrandPreloadProfiler == null");
        localObject1 = new LinkedList();
      }
      StringBuilder localStringBuilder;
      label191:
      try
      {
        hbg = d.b.hby;
        ((Collection)localObject1).addAll(hbh);
        hbh.clear();
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (a)((Iterator)localObject1).next();
          if (localObject3 != null) {
            ((a)localObject3).onReady();
          }
        }
        l = 1L;
      }
      finally {}
    }
    localStringBuilder = new StringBuilder().append("[PreloadProfile]").append(" ");
    if (localObject1 == null)
    {
      localObject1 = "Unknown";
      localObject1 = localStringBuilder.append(bk.q("Preload for [%s]Type | ", new Object[] { localObject1 }));
      if (((AppBrandPreloadProfiler)localObject3).hbd != 9223372036854775807L) {
        break label398;
      }
    }
    for (long l = -1L;; l = ((AppBrandPreloadProfiler)localObject3).hbd)
    {
      y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", bk.q("Preload request at [%d] | ", new Object[] { Long.valueOf(l) }) + bk.q("Process prepared cost [%s]ms | ", new Object[] { a(((AppBrandPreloadProfiler)localObject3).hbd, "req", ((AppBrandPreloadProfiler)localObject3).hbe, "proc") }) + bk.q("Trans-thread prepared cost [%s]ms | ", new Object[] { a(((AppBrandPreloadProfiler)localObject3).hbe, "proc", ((AppBrandPreloadProfiler)localObject3).startTime, "start") }) + bk.q("Preload prepared cost [%s]ms | ", new Object[] { a(((AppBrandPreloadProfiler)localObject3).startTime, "start", ((AppBrandPreloadProfiler)localObject3).endTime, "end") }) + bk.q("All cost [%s]ms ", new Object[] { a(((AppBrandPreloadProfiler)localObject3).hbd, "req", ((AppBrandPreloadProfiler)localObject3).endTime, "end") }));
      break;
      localObject1 = ((f)localObject1).name();
      break label191;
    }
  }
  
  private static void reset()
  {
    try
    {
      hbg = d.b.hbw;
      hbh.clear();
      hbi.clear();
      hbj.clear();
      hbk = null;
      hbl = null;
      hbm = null;
      hbn = f.hbW;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void wj(String paramString)
  {
    try
    {
      hbk = paramString;
      hbl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static q wk(String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.equals(hbk))) {
      return null;
    }
    hbk = paramString;
    return (q)hbi.poll();
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d
 * JD-Core Version:    0.7.0.1
 */