package com.tencent.matrix.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.a.a.a.g;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.a.l;
import com.tencent.matrix.a.a.a.m;
import com.tencent.matrix.a.a.a.n;
import com.tencent.matrix.a.a.c.a;
import com.tencent.matrix.a.a.c.a.1;
import com.tencent.matrix.a.b.h.a;
import com.tencent.matrix.report.d.a;
import com.tencent.matrix.report.d.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static int cYK = 50;
  private static long cYL = 300000L;
  private static long cYM = 6000L;
  private static long cYN = 1000L;
  private static long cYO = 120000L;
  private static long cYP = 2000L;
  private static boolean cYQ = false;
  private static long cYR = 2L;
  private static int cYS = 100;
  private static int cYT = 200;
  private static int cYU = 50;
  private static long cYV = 104857600L;
  private static long cYW = 1800000L;
  private static boolean cYX = false;
  private static boolean cYY = false;
  private static String cYZ = "";
  private static long cZa;
  private static Handler cZb;
  private static AtomicBoolean cZc;
  private static com.tencent.matrix.report.c cZd;
  private static com.tencent.matrix.a.c cZe;
  private static AtomicBoolean cZf;
  
  public static com.tencent.matrix.a.c WS()
  {
    if ((cZe == null) && (com.tencent.matrix.b.Vt())) {
      cZe = (com.tencent.matrix.a.c)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.a.c.class);
    }
    if ((cZe != null) && (cZe.isPluginStopped())) {
      return null;
    }
    return cZe;
  }
  
  public static com.tencent.matrix.a.c WT()
  {
    af.a(5, new ac()
    {
      public final void a(com.tencent.mm.cd.a paramAnonymousa)
      {
        a.Xk();
      }
      
      public final void b(com.tencent.mm.cd.a paramAnonymousa) {}
    });
    com.tencent.matrix.a.b.h.a(new h.a()
    {
      public final void onError(final int paramAnonymousInt, final String paramAnonymousString)
      {
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            int i = paramAnonymousInt;
            String str1 = paramAnonymousString;
            a.Xf();
            if (a.WU())
            {
              String str2 = com.tencent.matrix.report.d.Xs();
              int j = com.tencent.matrix.report.d.VO();
              int k = com.tencent.matrix.report.d.Xu();
              String str3 = com.tencent.matrix.report.d.Xt();
              Log.i("Matrix.battery.BatteryReporter", "#statJiffiesParseErrorR2");
              d.b.a(d.b.access$100(), str2, str1, j, k, "statError2", 0L, "mode", i, "", 0L, str3, "", 0L, 0L, 0L);
            }
          }
        });
      }
    });
    cZd = new com.tencent.matrix.report.c();
    int i11 = 1;
    int i10 = 1;
    int i9 = 1;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 1;
    int i4 = 1;
    int i3 = 1;
    int i2 = 0;
    int i1 = 0;
    int n = 1;
    int m = 10000;
    int k = 5000;
    long l3 = 30000L;
    long l2 = 1200000L;
    long l1 = 1800000L;
    long l4 = 120000L;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    Object localObject2 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
    label388:
    label437:
    label455:
    label499:
    Object localObject1;
    label612:
    int i;
    label648:
    int j;
    if (localObject2 != null)
    {
      i10 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTg, 1);
      i11 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTh, 1);
      i8 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTi, 0);
      i7 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTj, 0);
      l3 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTs, 30000L);
      l2 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTt, 1200000L);
      l1 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTu, 1800000L);
      cYK = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTw, 50);
      cYL = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTz, 300000L);
      cYM = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTx, 6000L);
      cYN = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTy, 1000L);
      cYO = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTB, 120000L);
      cYP = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTA, 2000L);
      if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTD, 0) == 1)
      {
        bool1 = true;
        cYQ = bool1;
        l4 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTE, 120000L);
        cYR = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTF, 2);
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTI, 0) != 1) {
          break label1088;
        }
        bool2 = true;
        cYS = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTG, 100);
        cYT = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTJ, 200);
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTK, 1) != 1) {
          break label1094;
        }
        bool3 = true;
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTL, 0) != 1) {
          break label1100;
        }
        bool1 = true;
        i9 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTk, 1);
        i6 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTl, 0);
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTM, 0) != 1) {
          break label1106;
        }
        bool4 = true;
        cZf = new AtomicBoolean(bool4);
        cYU = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTC, 50);
        i5 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTm, 1);
        i4 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTn, 1);
        i3 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTo, 1);
        i2 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTp, 0);
        cYV = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTH, 104857600L);
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTN, 0) != 1) {
          break label1112;
        }
        bool4 = true;
        localObject1 = b.a.vTN;
        if ((!com.tencent.mm.compatible.util.k.avQ()) && (!Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("honor".toLowerCase()))) {
          break label1118;
        }
        i = 1;
        j = ((com.tencent.mm.plugin.expt.b.b)localObject2).a((b.a)localObject1, i);
        if (((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTP, 0) != 1) {
          break label1123;
        }
        bool5 = true;
        label677:
        cYW = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTQ, 1800000L);
        i1 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTq, 0);
        localObject1 = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTR, "");
        m = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTS, 10000);
        k = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTT, 5000);
        n = ((com.tencent.mm.plugin.expt.b.b)localObject2).a(b.a.vTr, 1);
        if (!"1".equals(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_notify_trace_enable", "0", false, true))) {
          break label1129;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label786:
      WV();
      localObject2 = new c.a();
      if (i10 == 1) {
        ((c.a)localObject2).aa(g.class);
      }
      if (i11 == 1)
      {
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.d.class);
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.f.class);
      }
      if (i8 == 1) {
        ((c.a)localObject2).aa(m.class);
      }
      if (i7 == 1) {
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.c.class);
      }
      if (i9 == 1) {
        ((c.a)localObject2).aa(f.class);
      }
      if (i6 == 1) {
        ((c.a)localObject2).aa(e.class);
      }
      if (i2 == 1) {
        ((c.a)localObject2).aa(l.class);
      }
      if (i4 == 1) {
        ((c.a)localObject2).aa(n.class);
      }
      if (i3 == 1) {
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.h.class);
      }
      if (i5 == 1)
      {
        if (Build.VERSION.SDK_INT < 26) {
          break label1134;
        }
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.e.class);
      }
      Object localObject3;
      for (;;)
      {
        if ((i1 != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label1146;
        }
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.i.class);
        localObject1 = ((String)localObject1).split(";");
        i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject3 = localObject1[i1];
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (((c.a)localObject2).cTZ.cTW == Collections.EMPTY_LIST) {
              ((c.a)localObject2).cTZ.cTW = new ArrayList();
            }
            ((c.a)localObject2).cTZ.cTW.add(localObject3);
          }
          i1 += 1;
        }
        bool1 = false;
        break;
        label1088:
        bool2 = false;
        break label388;
        label1094:
        bool3 = false;
        break label437;
        label1100:
        bool1 = false;
        break label455;
        label1106:
        bool4 = false;
        break label499;
        label1112:
        bool4 = false;
        break label612;
        label1118:
        i = 0;
        break label648;
        label1123:
        bool5 = false;
        break label677;
        label1129:
        i = 0;
        break label786;
        label1134:
        Log.w("Matrix.battery.BatteryCanaryConfigs", "only support bluetooth monitoring >= android 8.0 for the moment");
      }
      label1146:
      if ((n == 1) && (MMApplicationContext.isMainProcess())) {
        ((c.a)localObject2).aa(c.class);
      }
      if (i == 1) {
        ((c.a)localObject2).aa(com.tencent.matrix.a.a.a.k.class);
      }
      if (!bool4) {
        com.tencent.matrix.report.a.Xr();
      }
      if (cYY)
      {
        localObject1 = new HandlerThread("battery-dump");
        ((HandlerThread)localObject1).start();
        cZb = new Handler(((HandlerThread)localObject1).getLooper());
      }
      if ((com.tencent.mm.protocal.d.RAG) || (com.tencent.mm.protocal.d.RAH)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (!BuildInfo.IS_ARM64)) {
          ((c.a)localObject2).eS("TaskSchedulerFo");
        }
        if (TextUtils.isEmpty(cYZ)) {
          break;
        }
        localObject1 = cYZ.split(";");
        n = localObject1.length;
        i = 0;
        while (i < n)
        {
          localObject3 = localObject1[i].trim();
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((c.a)localObject2).eS((String)localObject3);
          }
          i += 1;
        }
        if (((com.tencent.mm.protocal.d.RAD & 0xFF) >= 48) && ((com.tencent.mm.protocal.d.RAD & 0xFF) <= 51)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      ((c.a)localObject2).cTZ.cTM = false;
      localObject1 = cZd;
      ((c.a)localObject2).cTZ.cTz = ((com.tencent.matrix.a.a.b)localObject1);
      l4 = Math.max(l4, 60000L);
      if (l4 > 0L) {
        ((c.a)localObject2).cTZ.cTB = l4;
      }
      l3 = Math.max(l3, 5000L);
      if (l3 > 0L) {
        ((c.a)localObject2).cTZ.cTD = l3;
      }
      ((c.a)localObject2).cTZ.cTK = bool3;
      l2 = Math.max(l2, 60000L);
      if (l2 > 0L) {
        ((c.a)localObject2).cTZ.cTE = l2;
      }
      ((c.a)localObject2).cTZ.cTL = bool1;
      l1 = Math.max(l1, 60000L);
      if (l1 > 0L) {
        ((c.a)localObject2).cTZ.cTF = l1;
      }
      localObject1 = ((c.a)localObject2).eQ("MicroMsg.MMAutoAuth").eQ("PlatformComm").eR("MicroMsg.JsApiSetKeepScreenOn").eR("QQBrowserVideo");
      bool1 = WU();
      ((c.a)localObject1).cTZ.cTN = bool1;
      localObject2 = new Callable() {};
      ((c.a)localObject1).cTZ.cTA = ((Callable)localObject2);
      i = Math.max(cYT, 20);
      if (i >= 10) {
        ((c.a)localObject1).cTZ.cTG = i;
      }
      ((c.a)localObject1).cTZ.cTO = bool2;
      i = cYS;
      ((c.a)localObject1).cTZ.cTH = i;
      ((c.a)localObject1).cTZ.cTQ = bool4;
      if (j >= 0) {
        ((c.a)localObject1).cTZ.cTR = j;
      }
      ((c.a)localObject1).cTZ.cTS = bool5;
      if (m > 1000) {
        ((c.a)localObject1).cTZ.cTI = m;
      }
      if (k > 1000) {
        ((c.a)localObject1).cTZ.cTJ = k;
      }
      Collections.sort(((c.a)localObject1).cTZ.cTY, new c.a.1((c.a)localObject1));
      return new com.tencent.matrix.a.c(((c.a)localObject1).cTZ);
      localObject1 = "";
      j = 0;
      i = 0;
    }
  }
  
  public static boolean WU()
  {
    if (cZc != null) {
      return cZc.get();
    }
    Object localObject = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
    if (localObject != null) {}
    for (int i = Math.max(((com.tencent.mm.plugin.expt.b.b)localObject).a(b.a.vTv, 50000), 100);; i = 50000)
    {
      boolean bool = jB(i);
      d.a.cW(bool);
      localObject = new AtomicBoolean(bool);
      cZc = (AtomicBoolean)localObject;
      return ((AtomicBoolean)localObject).get();
    }
  }
  
  static void WV()
  {
    try
    {
      cYX = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_min_report", "0", false, true).equals("1");
      cYY = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_dump_debug", "0", false, true).equals("1");
      if (com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_thread_watch", "0", false, true).equals("1"))
      {
        cYZ = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_thread_watch_list", "", false, true);
        return;
      }
      cYZ = "";
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Matrix.battery.BatteryCanaryConfigs", localException, "refreshCliCfg error", new Object[0]);
    }
  }
  
  public static int WW()
  {
    return Math.max(cYK, 0);
  }
  
  public static long WX()
  {
    return Math.max(cYL, 10000L);
  }
  
  public static long WY()
  {
    return Math.max(cYM, 1000L);
  }
  
  public static long WZ()
  {
    return Math.max(cYN, 500L);
  }
  
  public static long Xa()
  {
    return Math.max(cYO, 10000L);
  }
  
  public static long Xb()
  {
    return Math.max(cYP, 1000L);
  }
  
  public static long Xc()
  {
    return Math.max(cYR, 2L);
  }
  
  public static int Xd()
  {
    return Math.max(cYU, 5);
  }
  
  public static long Xe()
  {
    return Math.max(cYV, 1048576L);
  }
  
  public static boolean Xf()
  {
    return false;
  }
  
  public static boolean Xg()
  {
    return false;
  }
  
  public static boolean Xh()
  {
    return cYX;
  }
  
  static boolean Xi()
  {
    return (cZf != null) && (!cZf.get());
  }
  
  static boolean Xj()
  {
    return (cZf != null) && (cZf.get());
  }
  
  private static boolean jB(int paramInt)
  {
    double d = Math.random();
    if ((paramInt > 0) && (d < 1.0D / paramInt))
    {
      Log.i("Matrix.battery.BatteryCanaryConfigs", "dice hit, go kv stat!");
      return true;
    }
    return false;
  }
  
  public static boolean jC(int paramInt)
  {
    try
    {
      boolean bool = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_battery_opt_".concat(String.valueOf(paramInt)), "1", false, true).equals("1");
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Matrix.battery.BatteryCanaryConfigs", localException, "tryOptimize expt error, id = ".concat(String.valueOf(paramInt)), new Object[0]);
    }
    return false;
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Long> cZi;
    public j.a.c.b<Integer> cZj;
    
    public static a Xl()
    {
      a locala = new a();
      locala.cZi = j.a.c.b.c(Long.valueOf(a.cZa));
      locala.cZj = j.a.c.b.c(Integer.valueOf(com.tencent.mm.a.a.eYj));
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */