package com.tencent.matrix.c;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.g.a;
import com.tencent.matrix.a.b.a.g.a.a;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.b.a.i;
import com.tencent.matrix.a.b.b.a.1;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static long cUQ = 300000L;
  private static long cUR = 6000L;
  private static long cUS = 120000L;
  private static long cUT = 2000L;
  private static boolean cUU = false;
  private static long cUV = 2L;
  private static int cUW = 100;
  private static int cUX = 200;
  private static long cUY;
  private static AtomicBoolean cUZ;
  private static com.tencent.matrix.b.b cVa;
  
  public static boolean SA()
  {
    if (cUZ != null) {
      return cUZ.get();
    }
    Object localObject = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    if (localObject != null) {}
    for (int i = Math.max(((com.tencent.mm.plugin.expt.b.b)localObject).a(com.tencent.mm.plugin.expt.b.b.a.sjh, 10000), 100);; i = 10000)
    {
      boolean bool = ip(i);
      com.tencent.matrix.report.a.a.cC(bool);
      localObject = new AtomicBoolean(bool);
      cUZ = (AtomicBoolean)localObject;
      return ((AtomicBoolean)localObject).get();
    }
  }
  
  public static long SB()
  {
    return Math.max(cUQ, 10000L);
  }
  
  public static long SC()
  {
    return Math.max(cUR, 1000L);
  }
  
  public static long SD()
  {
    return Math.max(cUS, 10000L);
  }
  
  public static long SE()
  {
    return Math.max(cUT, 1000L);
  }
  
  public static boolean SF()
  {
    return cUU;
  }
  
  public static long SG()
  {
    return Math.max(cUV, 2L);
  }
  
  public static com.tencent.matrix.a.b Sz()
  {
    ab.a(5, new y()
    {
      public final void a(com.tencent.mm.bw.a paramAnonymousa)
      {
        a.SH();
      }
      
      public final void b(com.tencent.mm.bw.a paramAnonymousa) {}
    });
    ApplicationGlobal.context().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      private static void ey(String paramAnonymousString)
      {
        if (!com.tencent.matrix.b.isInstalled()) {}
        Object localObject;
        do
        {
          do
          {
            return;
            localObject = (com.tencent.matrix.a.b)com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
          } while ((localObject == null) || (((com.tencent.matrix.a.b)localObject).isPluginStopped()));
          localObject = (com.tencent.matrix.a.b.a.c)((com.tencent.matrix.a.b)localObject).cQh.aa(com.tencent.matrix.a.b.a.c.class);
        } while (localObject == null);
        ((com.tencent.matrix.a.b.a.c)localObject).eq(paramAnonymousString);
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = paramAnonymousActivity.getClass().getName() + "@" + paramAnonymousActivity.hashCode();
        Log.i("Matrix.battery.Lifecycle", "#onStarted: ".concat(String.valueOf(paramAnonymousActivity)));
        ey(paramAnonymousActivity);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        Log.i("Matrix.battery.Lifecycle", "#onStopped: ".concat(String.valueOf(paramAnonymousActivity.getClass().getName() + "@" + paramAnonymousActivity.hashCode())));
      }
    });
    cVa = new com.tencent.matrix.b.b();
    int n = 1;
    int m = 1;
    int k = 1;
    int j = 1;
    long l3 = 30000L;
    long l2 = 1200000L;
    long l1 = 1800000L;
    long l4 = 120000L;
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    if (localObject1 != null)
    {
      n = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.siZ, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sja, 1);
      k = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjb, 1);
      j = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjc, 1);
      l3 = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sje, 30000L);
      l2 = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjf, 1200000L);
      l1 = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjg, 1800000L);
      cUQ = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjj, 300000L);
      cUR = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sji, 6000L);
      cUS = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjl, 120000L);
      cUT = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjk, 2000L);
      if (((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjm, 0) == 1)
      {
        bool1 = true;
        cUU = bool1;
        l4 = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjn, 120000L);
        cUV = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjo, 2);
        if (((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjq, 0) != 1) {
          break label778;
        }
        bool1 = true;
        label316:
        cUW = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjp, 100);
        cUX = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjr, 200);
        if (((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjs, 1) != 1) {
          break label784;
        }
        bool2 = true;
        label365:
        if (((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjt, 0) != 1) {
          break label790;
        }
        bool3 = true;
      }
    }
    label383:
    for (int i = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.sjd, 1);; i = 1)
    {
      localObject1 = new com.tencent.matrix.a.b.b.a();
      if (n == 1) {
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(e.class);
      }
      if (m == 1)
      {
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(com.tencent.matrix.a.b.a.c.class);
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(d.class);
      }
      if (k == 1) {
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(i.class);
      }
      if (j == 1) {
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(com.tencent.matrix.a.b.a.b.class);
      }
      if (i == 1) {
        ((com.tencent.matrix.a.b.b.a)localObject1).Z(c.class);
      }
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRU = false;
      Object localObject2 = cVa;
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRJ = ((com.tencent.matrix.a.b.a)localObject2);
      l4 = Math.max(l4, 60000L);
      if (l4 > 0L) {
        ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRL = l4;
      }
      l3 = Math.max(l3, 5000L);
      if (l3 > 0L) {
        ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRN = l3;
      }
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRS = bool2;
      l2 = Math.max(l2, 60000L);
      if (l2 > 0L) {
        ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRO = l2;
      }
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRT = bool3;
      l1 = Math.max(l1, 60000L);
      if (l1 > 0L) {
        ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRP = l1;
      }
      localObject1 = ((com.tencent.matrix.a.b.b.a)localObject1).eo("MicroMsg.MMAutoAuth").eo("PlatformComm").ep("MicroMsg.JsApiSetKeepScreenOn").ep("QQBrowserVideo");
      bool2 = SA();
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRV = bool2;
      localObject2 = new Callable() {};
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRK = ((Callable)localObject2);
      i = Math.max(cUX, 20);
      if (i >= 10) {
        ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRQ = i;
      }
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRW = bool1;
      i = cUW;
      ((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRR = i;
      Collections.sort(((com.tencent.matrix.a.b.b.a)localObject1).cSa.cRZ, new b.a.1((com.tencent.matrix.a.b.b.a)localObject1));
      return new com.tencent.matrix.a.b(((com.tencent.matrix.a.b.b.a)localObject1).cSa);
      bool1 = false;
      break;
      bool1 = false;
      break label316;
      bool2 = false;
      break label365;
      bool3 = false;
      break label383;
    }
  }
  
  private static boolean ip(int paramInt)
  {
    double d = Math.random();
    if ((paramInt > 0) && (d < 1.0D / paramInt))
    {
      Log.i("Matrix.battery.BatteryCanaryConfigs", "dice hit, go kv stat!");
      return true;
    }
    return false;
  }
  
  public static final class a
    extends g.a<a>
  {
    public g.a.c.b<Long> cVb;
    public g.a.c.b<Integer> cVc;
    
    public static a SI()
    {
      a locala = new a();
      locala.cVb = g.a.c.b.b(Long.valueOf(a.cUY));
      locala.cVc = g.a.c.b.b(Integer.valueOf(com.tencent.mm.a.a.dgC));
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */