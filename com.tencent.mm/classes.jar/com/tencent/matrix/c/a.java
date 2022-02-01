package com.tencent.matrix.c;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.matrix.a.a.a.g;
import com.tencent.matrix.a.a.a.j;
import com.tencent.matrix.a.a.a.k;
import com.tencent.matrix.a.a.a.m.a;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.a.a.n;
import com.tencent.matrix.a.a.a.o;
import com.tencent.matrix.a.a.a.p;
import com.tencent.matrix.a.a.a.q;
import com.tencent.matrix.a.a.c.a.1;
import com.tencent.matrix.a.b.l.b;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.report.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.wxperf.thread.ThreadInspect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static int eVB = 50;
  private static long eVC = 300000L;
  private static long eVD = 6000L;
  private static long eVE = 1000L;
  private static long eVF = 120000L;
  private static long eVG = 2000L;
  private static boolean eVH = false;
  private static long eVI = 2L;
  private static int eVJ = 100;
  private static int eVK = 200;
  private static int eVL = 50;
  private static long eVM = 104857600L;
  private static long eVN = 60000L;
  private static boolean eVO = false;
  private static boolean eVP = false;
  private static boolean eVQ = false;
  private static boolean eVR = true;
  private static String eVS = "";
  private static int eVT = 100;
  private static int eVU = 10;
  private static long eVV;
  private static Handler eVW;
  private static AtomicBoolean eVX;
  private static com.tencent.matrix.report.d eVY;
  private static com.tencent.matrix.a.c eVZ;
  private static AtomicBoolean eWa;
  
  private static boolean axU()
  {
    if ((WeChatEnvironment.hasDebugger()) || (WeChatEnvironment.isCoolassistEnv())) {}
    while ((com.tencent.mm.protocal.d.Yxk) || (com.tencent.mm.protocal.d.Yxl)) {
      return true;
    }
    return false;
  }
  
  public static com.tencent.matrix.a.c axV()
  {
    if ((eVZ == null) && (com.tencent.matrix.c.isInstalled())) {
      eVZ = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
    }
    if ((eVZ != null) && (eVZ.isPluginStopped())) {
      return null;
    }
    return eVZ;
  }
  
  public static com.tencent.matrix.a.c axW()
  {
    af.a(5, new ac()
    {
      public final void a(com.tencent.mm.bx.a paramAnonymousa)
      {
        a.ayv();
      }
      
      public final void b(com.tencent.mm.bx.a paramAnonymousa) {}
    });
    com.tencent.matrix.a.b.l.a(new l.b()
    {
      public final void onError(final int paramAnonymousInt, final String paramAnonymousString)
      {
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            int i = paramAnonymousInt;
            String str1 = paramAnonymousString;
            if (a.axX())
            {
              String str2 = com.tencent.matrix.report.c.a.ayX();
              int j = com.tencent.matrix.report.c.a.awy();
              int k = com.tencent.matrix.a.b.b.bW(MMApplicationContext.getContext());
              String str3 = com.tencent.matrix.report.e.ayY();
              Log.i("Matrix.battery.BatteryReporter", "#statJiffiesParseErrorR2");
              e.b.a(e.b.access$000(), str2, str1, j, k, "statError2", 0L, "mode", i, "", 0L, str3, "", 0L, 0L, 0L, "");
            }
          }
        });
      }
    });
    eVY = new com.tencent.matrix.report.d();
    int i13 = 1;
    int i12 = 1;
    int i11 = 1;
    int i10 = 1;
    int i9 = 1;
    int i8 = 1;
    int i7 = 1;
    int i4 = 1;
    int i3 = 1;
    int i6 = 1;
    boolean bool5 = true;
    boolean bool2 = true;
    int j = 0;
    int i = 0;
    int i5 = 0;
    int i2 = 0;
    boolean bool3 = false;
    boolean bool1 = false;
    int i1 = 0;
    boolean bool4 = false;
    int n = 10000;
    int m = 5000;
    long l3 = 30000L;
    Object localObject2 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
    label180:
    label228:
    int k;
    label259:
    label410:
    Object localObject1;
    label387:
    label429:
    label459:
    label496:
    long l2;
    long l1;
    long l4;
    int i14;
    boolean bool6;
    if (localObject2 != null)
    {
      i12 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlK, 1);
      if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmm, 1) == 1)
      {
        bool1 = true;
        i13 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlL, 1);
        if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmo, 1) != 1) {
          break label1216;
        }
        bool2 = true;
        i11 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlO, 1);
        i4 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlV, 1);
        if (!"1".equals(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_battery_ipc_task_enable", "1", false, true))) {
          break label1222;
        }
        i = 1;
        i10 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlP, 1);
        if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmq, 1) != 1) {
          break label1227;
        }
        bool3 = true;
        eWa = new AtomicBoolean(bool3);
        i9 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlQ, 1);
        i8 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlR, 1);
        i7 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlS, 1);
        i6 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlT, 1);
        n = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlM, 0);
        k = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlN, 0);
        boolean bool7 = "1".equals(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_battery_bg_loop_r_enable", "0", false, true));
        if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmh, 0) != 1) {
          break label1233;
        }
        bool3 = true;
        eVH = bool3;
        if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmr, 0) != 1) {
          break label1239;
        }
        bool3 = true;
        localObject1 = com.tencent.mm.plugin.expt.b.c.a.zmr;
        if ((!com.tencent.mm.compatible.util.l.aQo()) && (!com.tencent.mm.compatible.util.l.aQp())) {
          break label1245;
        }
        j = 1;
        i1 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a((com.tencent.mm.plugin.expt.b.c.a)localObject1, j);
        if (((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmt, 0) != 1) {
          break label1250;
        }
        bool4 = true;
        i5 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlU, 0);
        if (!"1".equals(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_battery_notify_trace_enable", "0", false, true))) {
          break label1256;
        }
        j = 1;
        l3 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlW, 30000L);
        l2 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlX, 1200000L);
        l1 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zlY, 1800000L);
        eVB = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zma, 50);
        eVC = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmd, 300000L);
        eVD = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmb, 6000L);
        eVE = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmc, 1000L);
        eVF = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmf, 120000L);
        eVG = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zme, 2000L);
        l4 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmi, 120000L);
        eVI = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmj, 2);
        eVJ = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmk, 100);
        eVK = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmn, 200);
        eVL = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmg, 50);
        eVM = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zml, 104857600L);
        eVN = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmu, 60000L);
        localObject1 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmv, "");
        i14 = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmw, 10000);
        m = ((com.tencent.mm.plugin.expt.b.c)localObject2).a(com.tencent.mm.plugin.expt.b.c.a.zmx, 5000);
        bool6 = bool3;
        i2 = j;
        i3 = i;
        bool5 = bool2;
        bool2 = bool1;
        j = n;
        i = k;
        bool3 = bool7;
        bool1 = bool6;
        n = i14;
      }
    }
    for (;;)
    {
      axY();
      if (eVR) {
        ThreadInspect.init();
      }
      localObject2 = new com.tencent.matrix.a.a.c.a();
      ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.i.class);
      if (axU())
      {
        k = 1;
        label861:
        bool6 = bool1;
        int i15 = i;
        i14 = j;
        if (k != 0) {
          if (!com.tencent.mm.compatible.util.l.aQo())
          {
            bool6 = bool1;
            i15 = i;
            i14 = j;
            if (!com.tencent.mm.compatible.util.l.aQp()) {}
          }
          else
          {
            bool6 = bool1;
            i15 = i;
            i14 = j;
            if (Build.VERSION.SDK_INT <= 29)
            {
              i14 = 1;
              i15 = 1;
              bool6 = true;
            }
          }
        }
        if (i12 == 1)
        {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(j.class);
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(g.class);
        }
        if (i13 == 1)
        {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.d.class);
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.h.class);
        }
        if (i14 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(p.class);
        }
        if (i15 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.c.class);
        }
        if (i11 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(i.class);
        }
        if (i10 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(h.class);
        }
        if (i6 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(o.class);
        }
        if (i8 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(q.class);
        }
        if (i7 == 1) {
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(k.class);
        }
        if (i9 == 1)
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label1295;
          }
          ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.e.class);
        }
      }
      Object localObject3;
      for (;;)
      {
        if ((i5 != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label1307;
        }
        ((com.tencent.matrix.a.a.c.a)localObject2).ak(com.tencent.matrix.a.a.a.l.class);
        localObject1 = ((String)localObject1).split(";");
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePy == Collections.EMPTY_LIST) {
              ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePy = new ArrayList();
            }
            ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePy.add(localObject3);
          }
          i += 1;
        }
        bool1 = false;
        break;
        label1216:
        bool2 = false;
        break label180;
        label1222:
        i = 0;
        break label228;
        label1227:
        bool3 = false;
        break label259;
        label1233:
        bool3 = false;
        break label387;
        label1239:
        bool3 = false;
        break label410;
        label1245:
        j = 0;
        break label429;
        label1250:
        bool4 = false;
        break label459;
        label1256:
        j = 0;
        break label496;
        if (((com.tencent.mm.protocal.d.Yxh & 0xFF) >= 48) && ((com.tencent.mm.protocal.d.Yxh & 0xFF) <= 51))
        {
          k = 1;
          break label861;
        }
        k = 0;
        break label861;
        label1295:
        Log.w("Matrix.battery.BatteryCanaryConfigs", "only support bluetooth monitoring >= android 8.0 for the moment");
      }
      label1307:
      if ((i4 == 1) && (MMApplicationContext.isMainProcess())) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ak(f.class);
      }
      if (i2 == 1) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ak(n.class);
      }
      if (i3 == 1) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ak(d.class);
      }
      if (!bool6) {
        com.tencent.matrix.report.a.ayW();
      }
      if (eVP)
      {
        localObject1 = new HandlerThread("battery-dump");
        ((HandlerThread)localObject1).start();
        eVW = new Handler(((HandlerThread)localObject1).getLooper());
      }
      if ((eVQ) && (!TextUtils.isEmpty(eVS)))
      {
        localObject1 = eVS.split(";");
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i].trim();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePz == Collections.EMPTY_LIST) {
              ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePz = new ArrayList();
            }
            ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePz.add(localObject3);
          }
          i += 1;
        }
      }
      ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePo = false;
      localObject1 = eVY;
      ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePb = ((com.tencent.matrix.a.a.b)localObject1);
      l4 = Math.max(l4, 60000L);
      if (l4 > 0L) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePd = l4;
      }
      l3 = Math.max(l3, 5000L);
      if (l3 > 0L) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePf = l3;
      }
      ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePm = bool5;
      l2 = Math.max(l2, 60000L);
      if (l2 > 0L) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePg = l2;
      }
      ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePn = bool3;
      l1 = Math.max(l1, 60000L);
      if (l1 > 0L) {
        ((com.tencent.matrix.a.a.c.a)localObject2).ePB.ePh = l1;
      }
      localObject1 = ((com.tencent.matrix.a.a.c.a)localObject2).gp("MicroMsg.MMAutoAuth").gp("PlatformComm").gq("MicroMsg.JsApiSetKeepScreenOn").gq("QQBrowserVideo");
      bool1 = axX();
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePp = bool1;
      localObject2 = new Callable() {};
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePc = ((Callable)localObject2);
      i = Math.max(eVK, 20);
      if (i >= 10) {
        ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePi = i;
      }
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePq = bool2;
      i = eVJ;
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePj = i;
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePs = bool6;
      if (i1 >= 0) {
        ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePt = i1;
      }
      ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePu = bool4;
      if (n > 1000) {
        ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePk = n;
      }
      if (m > 1000) {
        ((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePl = m;
      }
      Collections.sort(((com.tencent.matrix.a.a.c.a)localObject1).ePB.ePA, new c.a.1((com.tencent.matrix.a.a.c.a)localObject1));
      return new com.tencent.matrix.a.c(((com.tencent.matrix.a.a.c.a)localObject1).ePB);
      localObject1 = "";
      l4 = 120000L;
      l1 = 1800000L;
      l2 = 1200000L;
    }
  }
  
  public static boolean axX()
  {
    if (eVX != null) {
      return eVX.get();
    }
    Object localObject = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
    if (localObject != null) {}
    for (int i = Math.max(((com.tencent.mm.plugin.expt.b.c)localObject).a(com.tencent.mm.plugin.expt.b.c.a.zlZ, 50000), 100);; i = 50000)
    {
      boolean bool = nh(i);
      e.a.dF(bool);
      localObject = new AtomicBoolean(bool);
      eVX = (AtomicBoolean)localObject;
      return ((AtomicBoolean)localObject).get();
    }
  }
  
  /* Error */
  static void axY()
  {
    // Byte code:
    //   0: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   3: ldc_w 618
    //   6: ldc 212
    //   8: iconst_0
    //   9: iconst_1
    //   10: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   13: ldc 212
    //   15: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: putstatic 103	com/tencent/matrix/c/a:eVR	Z
    //   21: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   24: ldc_w 620
    //   27: ldc 212
    //   29: iconst_0
    //   30: iconst_1
    //   31: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   34: bipush 50
    //   36: invokestatic 626	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   39: putstatic 109	com/tencent/matrix/c/a:eVT	I
    //   42: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   45: ldc_w 628
    //   48: ldc 212
    //   50: iconst_0
    //   51: iconst_1
    //   52: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   55: iconst_5
    //   56: invokestatic 626	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   59: putstatic 111	com/tencent/matrix/c/a:eVU	I
    //   62: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   65: ldc_w 630
    //   68: ldc_w 264
    //   71: iconst_0
    //   72: iconst_1
    //   73: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   76: ldc 212
    //   78: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: putstatic 97	com/tencent/matrix/c/a:eVO	Z
    //   84: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   87: ldc_w 632
    //   90: ldc_w 264
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   98: ldc 212
    //   100: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: putstatic 99	com/tencent/matrix/c/a:eVP	Z
    //   106: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   109: ldc_w 634
    //   112: ldc_w 264
    //   115: iconst_0
    //   116: iconst_1
    //   117: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   120: astore_3
    //   121: ldc 212
    //   123: aload_3
    //   124: invokevirtual 638	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   127: ifne +262 -> 389
    //   130: invokestatic 372	com/tencent/matrix/c/a:axU	()Z
    //   133: ifeq +106 -> 239
    //   136: goto +253 -> 389
    //   139: iload_2
    //   140: putstatic 101	com/tencent/matrix/c/a:eVQ	Z
    //   143: iload_2
    //   144: ifeq +100 -> 244
    //   147: ldc_w 640
    //   150: aload_3
    //   151: invokevirtual 638	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   154: ifne +90 -> 244
    //   157: iconst_1
    //   158: istore_2
    //   159: iload_2
    //   160: putstatic 101	com/tencent/matrix/c/a:eVQ	Z
    //   163: iload_2
    //   164: ifeq +85 -> 249
    //   167: invokestatic 218	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   170: ldc_w 642
    //   173: ldc 105
    //   175: iconst_0
    //   176: iconst_1
    //   177: invokevirtual 223	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   180: putstatic 107	com/tencent/matrix/c/a:eVS	Ljava/lang/String;
    //   183: invokestatic 546	com/tencent/matrix/c/a:axX	()Z
    //   186: ifne +9 -> 195
    //   189: invokestatic 372	com/tencent/matrix/c/a:axU	()Z
    //   192: ifeq +164 -> 356
    //   195: invokestatic 646	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   198: invokestatic 652	com/tencent/matrix/a/b/j:ce	(Landroid/content/Context;)Lcom/tencent/matrix/a/b/j;
    //   201: astore_3
    //   202: iconst_0
    //   203: istore_0
    //   204: iload_0
    //   205: aload_3
    //   206: invokevirtual 656	com/tencent/matrix/a/b/j:axr	()I
    //   209: if_icmpge +66 -> 275
    //   212: new 658	com/tencent/matrix/a/b/e
    //   215: dup
    //   216: iload_0
    //   217: aload_3
    //   218: aload_3
    //   219: iload_0
    //   220: invokevirtual 662	com/tencent/matrix/a/b/j:nd	(I)I
    //   223: invokevirtual 665	com/tencent/matrix/a/b/j:nf	(I)I
    //   226: invokespecial 668	com/tencent/matrix/a/b/e:<init>	(II)V
    //   229: invokevirtual 671	com/tencent/matrix/a/b/e:axt	()V
    //   232: iload_0
    //   233: iconst_1
    //   234: iadd
    //   235: istore_0
    //   236: goto -32 -> 204
    //   239: iconst_0
    //   240: istore_2
    //   241: goto -102 -> 139
    //   244: iconst_0
    //   245: istore_2
    //   246: goto -87 -> 159
    //   249: ldc 105
    //   251: putstatic 107	com/tencent/matrix/c/a:eVS	Ljava/lang/String;
    //   254: goto -71 -> 183
    //   257: astore_3
    //   258: ldc_w 443
    //   261: aload_3
    //   262: ldc_w 673
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 677	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -89 -> 183
    //   275: iconst_1
    //   276: istore_0
    //   277: aload_3
    //   278: getfield 681	com/tencent/matrix/a/b/j:eTN	[Lcom/tencent/matrix/a/b/j$a;
    //   281: arraylength
    //   282: newarray int
    //   284: astore 4
    //   286: iconst_0
    //   287: istore_1
    //   288: iload_1
    //   289: aload 4
    //   291: arraylength
    //   292: if_icmpge +37 -> 329
    //   295: aload 4
    //   297: iload_1
    //   298: aload_3
    //   299: iload_1
    //   300: invokevirtual 665	com/tencent/matrix/a/b/j:nf	(I)I
    //   303: iastore
    //   304: iload_1
    //   305: iconst_1
    //   306: iadd
    //   307: istore_1
    //   308: goto -20 -> 288
    //   311: astore 4
    //   313: ldc_w 683
    //   316: aload 4
    //   318: invokevirtual 688	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   321: invokestatic 693	com/tencent/matrix/report/e$b$b:S	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: iconst_0
    //   325: istore_0
    //   326: goto -49 -> 277
    //   329: new 695	com/tencent/matrix/a/b/f
    //   332: dup
    //   333: invokestatic 700	android/os/Process:myPid	()I
    //   336: aload 4
    //   338: invokespecial 703	com/tencent/matrix/a/b/f:<init>	(I[I)V
    //   341: invokevirtual 704	com/tencent/matrix/a/b/f:axt	()V
    //   344: iload_0
    //   345: ifeq +11 -> 356
    //   348: ldc_w 706
    //   351: ldc 105
    //   353: invokestatic 693	com/tencent/matrix/report/e$b$b:S	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: return
    //   357: astore_3
    //   358: ldc_w 708
    //   361: aload_3
    //   362: invokevirtual 688	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   365: invokestatic 693	com/tencent/matrix/report/e$b$b:S	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: iconst_0
    //   369: istore_0
    //   370: goto -26 -> 344
    //   373: astore_3
    //   374: ldc_w 710
    //   377: aload_3
    //   378: invokevirtual 688	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   381: invokestatic 693	com/tencent/matrix/report/e$b$b:S	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: iconst_0
    //   385: istore_0
    //   386: goto -42 -> 344
    //   389: iconst_1
    //   390: istore_2
    //   391: goto -252 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   203	183	0	i	int
    //   287	21	1	j	int
    //   139	252	2	bool	boolean
    //   120	99	3	localObject1	Object
    //   257	42	3	localException	Exception
    //   357	5	3	localObject2	Object
    //   373	5	3	localObject3	Object
    //   284	12	4	arrayOfInt1	int[]
    //   311	26	4	arrayOfInt2	int[]
    // Exception table:
    //   from	to	target	type
    //   0	136	257	java/lang/Exception
    //   139	143	257	java/lang/Exception
    //   147	157	257	java/lang/Exception
    //   159	163	257	java/lang/Exception
    //   167	183	257	java/lang/Exception
    //   249	254	257	java/lang/Exception
    //   204	232	311	finally
    //   277	286	357	finally
    //   288	304	357	finally
    //   329	344	357	finally
    //   195	202	373	finally
    //   313	324	373	finally
    //   358	368	373	finally
  }
  
  public static int axZ()
  {
    return Math.max(eVB, 0);
  }
  
  public static long aya()
  {
    return Math.max(eVC, 10000L);
  }
  
  public static long ayb()
  {
    return Math.max(eVD, 1000L);
  }
  
  public static long ayc()
  {
    return Math.max(eVE, 500L);
  }
  
  public static long ayd()
  {
    return Math.max(eVF, 10000L);
  }
  
  public static long aye()
  {
    return Math.max(eVG, 1000L);
  }
  
  public static boolean ayf()
  {
    return eVH;
  }
  
  public static long ayg()
  {
    return Math.max(eVI, 2L);
  }
  
  public static int ayh()
  {
    return Math.max(eVL, 5);
  }
  
  public static long ayi()
  {
    return Math.max(eVM, 1048576L);
  }
  
  public static long ayj()
  {
    return Math.max(eVN, 10000L);
  }
  
  public static int ayk()
  {
    return Math.max(eVT, 50);
  }
  
  public static int ayl()
  {
    return Math.max(eVU, 5);
  }
  
  public static boolean aym()
  {
    return false;
  }
  
  public static boolean ayn()
  {
    return axX();
  }
  
  public static boolean ayo()
  {
    return false;
  }
  
  public static boolean ayp()
  {
    return eVO;
  }
  
  public static boolean ayq()
  {
    return eVR;
  }
  
  public static void ayr() {}
  
  static boolean ays()
  {
    return (eWa != null) && (!eWa.get());
  }
  
  static boolean ayt()
  {
    return (eWa != null) && (eWa.get());
  }
  
  public static int ayu()
  {
    int i = 0;
    String str = String.valueOf(DateFormat.format("yyyyMMdd", System.currentTimeMillis()));
    if (!TextUtils.isEmpty(str))
    {
      str = "battery_tkill_count_".concat(String.valueOf(str));
      i = MultiProcessMMKV.getDefault().getInt(str, 0);
    }
    return i;
  }
  
  private static boolean nh(int paramInt)
  {
    double d = Math.random();
    if ((paramInt > 0) && (d < 1.0D / paramInt))
    {
      Log.i("Matrix.battery.BatteryCanaryConfigs", "dice hit, go kv stat!");
      return true;
    }
    return false;
  }
  
  public static boolean ni(int paramInt)
  {
    try
    {
      boolean bool = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_battery_opt_".concat(String.valueOf(paramInt)), "1", false, true).equals("1");
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Matrix.battery.BatteryCanaryConfigs", localException, "tryOptimize expt error, id = ".concat(String.valueOf(paramInt)), new Object[0]);
    }
    return false;
  }
  
  public static void nj(int paramInt)
  {
    String str = String.valueOf(DateFormat.format("yyyyMMdd", System.currentTimeMillis()));
    if (!TextUtils.isEmpty(str))
    {
      str = "battery_tkill_count_".concat(String.valueOf(str));
      MultiProcessMMKV.getDefault().putInt(str, paramInt).commit();
    }
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Long> eWd;
    public m.a.c.b<Integer> eWe;
    
    public static a ayw()
    {
      a locala = new a();
      locala.eWd = m.a.c.b.c(Long.valueOf(a.eVV));
      locala.eWe = m.a.c.b.c(Integer.valueOf(com.tencent.mm.a.a.hbK));
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */