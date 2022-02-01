package com.tencent.matrix;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.a.c.a.a.1;
import com.tencent.matrix.a.c.a.c;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h.a;
import com.tencent.matrix.report.h.b;
import com.tencent.matrix.report.h.d;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.e.b.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

public enum d
  implements c.a
{
  private Application application;
  public com.tencent.matrix.report.h cBL = null;
  private volatile boolean cBM = false;
  private final ay cBN = ay.aRW("MatrixDelegate");
  public com.tencent.matrix.strategy.a cBO;
  private final int cBP = 9;
  private boolean cBQ = false;
  private volatile boolean cBR = false;
  public volatile boolean isInitialized = false;
  
  private d() {}
  
  private static com.tencent.matrix.resource.analyzer.model.a a(k paramk, String paramString)
  {
    com.tencent.matrix.resource.analyzer.model.d locald = com.tencent.matrix.resource.analyzer.model.c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).IK();
    try
    {
      paramk = new com.tencent.matrix.resource.analyzer.model.g(paramk);
      paramk = new com.tencent.matrix.resource.analyzer.a(paramString, locald).a(paramk);
      return paramk;
    }
    catch (IOException paramk) {}
    return com.tencent.matrix.resource.analyzer.model.a.a(paramk, 0L);
  }
  
  private void bV(boolean paramBoolean)
  {
    if (!this.isInitialized)
    {
      ae.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
      this.cBM = true;
      return;
    }
    if (ak.coh())
    {
      MrsLogic.onForeground(paramBoolean);
      if (!paramBoolean) {
        com.tencent.e.h.MqF.f(new Runnable()
        {
          public final void run()
          {
            d.a(d.this);
          }
        }, "MatrixDelegate");
      }
    }
    Iterator localIterator = b.HT().cBJ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.e.b localb = (com.tencent.matrix.e.b)localIterator.next();
      if (!(localb instanceof com.tencent.matrix.trace.a)) {
        localb.onForeground(paramBoolean);
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.cBR = paramBoolean;
      return;
    }
  }
  
  public final com.tencent.matrix.g.c.a HU()
  {
    new com.tencent.matrix.g.c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ae.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
    };
  }
  
  public final com.tencent.matrix.report.h HV()
  {
    long l2 = 5L;
    h.a locala = new h.a(ak.getContext());
    locala.cFQ = Long.valueOf(com.tencent.mm.protocal.d.FFH);
    locala.cFZ = Boolean.valueOf(bv.fnD());
    locala.cFR = j.REV;
    long l1 = l2;
    if (!j.IS_FLAVOR_PURPLE)
    {
      l1 = l2;
      if (!j.IS_FLAVOR_RED)
      {
        if (!j.DEBUG) {
          break label188;
        }
        l1 = l2;
      }
    }
    for (;;)
    {
      locala.cFT = Long.valueOf(l1);
      Objects.requireNonNull(locala.context, "matrix report init, context is null");
      Objects.requireNonNull(locala.cFQ, "matrix report init, clientVersion is null");
      Objects.requireNonNull(locala.cFR, "matrix report init, revision is null");
      Objects.requireNonNull(locala.cFT, "matrix report init, publishType is null");
      this.cBL = new com.tencent.matrix.report.h(locala.context, locala.cFQ, locala.cFR, locala.cFZ, locala.cFT);
      ae.i("MatrixDelegate", "init matrix reporter. %s", new Object[] { this.cBL });
      return this.cBL;
      label188:
      l1 = l2;
      if (!com.tencent.mm.protocal.d.FFK) {
        if (com.tencent.mm.protocal.d.FFI) {
          l1 = 3L;
        } else if (com.tencent.mm.protocal.d.FFJ) {
          l1 = 4L;
        } else {
          l1 = -1L;
        }
      }
    }
  }
  
  public final f HW()
  {
    return new f();
  }
  
  public final h.b HX()
  {
    return new com.tencent.matrix.report.g();
  }
  
  public final o HY()
  {
    new o()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        d.a(d.this, false);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        d.a(d.this, true);
      }
    };
  }
  
  public final void a(Application paramApplication)
  {
    this.application = paramApplication;
    this.cBO = new com.tencent.matrix.strategy.d();
  }
  
  public final void a(Application paramApplication, b.a parama, f paramf)
  {
    boolean bool;
    if ((ak.coh()) || (ak.foC()) || (ak.isAppBrandProcess())) {
      bool = true;
    }
    for (;;)
    {
      ae.i("MatrixDelegate", "[isEnableTracePlugin] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
      Object localObject2;
      int i;
      label96:
      Object localObject1;
      if (bool)
      {
        com.tencent.matrix.trace.a.a.Jg().cKl = true;
        localObject2 = new com.tencent.matrix.trace.a.b.a();
        ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cET = paramf;
        i = this.cBN.getInt(com.tencent.c.a.a.a.LZs.name(), 0);
        if (i == 1)
        {
          bool = true;
          ae.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKm = bool;
          i = this.cBN.getInt(com.tencent.c.a.a.a.LZA.name(), 0);
          if (i != 1) {
            break label1005;
          }
          bool = true;
          label159:
          ae.i("MatrixDelegate", "[isEnableEvilMethod] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKn = bool;
          i = this.cBN.getInt(com.tencent.c.a.a.a.LZC.name(), 0);
          if (i != 1) {
            break label1041;
          }
          bool = true;
          label222:
          ae.i("MatrixDelegate", "[isEnableStartUp] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKo = bool;
          i = this.cBN.getInt(com.tencent.c.a.a.a.LZB.name(), 0);
          if (i != 1) {
            break label1083;
          }
          bool = true;
          label285:
          ae.i("MatrixDelegate", "[isEnableAnr] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKp = bool;
          if (!ak.coh()) {
            break label1125;
          }
          localObject1 = "com.tencent.mm.app.WeChatSplashActivity;com.tencent.mm.plugin.account.ui.WelcomeActivity;";
          label334:
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKr = ((String)localObject1);
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cFS = true;
          ((com.tencent.matrix.trace.a.b.a)localObject2).cKu.cKq = false;
          parama.a(new com.tencent.matrix.trace.a(((com.tencent.matrix.trace.a.b.a)localObject2).cKu));
          com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c()
          {
            private static boolean HZ()
            {
              try
              {
                boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOV, true);
                ay.fpa().encode("clicfg_anr_report_all", bool);
                bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOW, false);
                ay.fpa().encode("clicfg_normal_report", bool);
                bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPr, true);
                ay.fpa().encode("clicfg_detect_dropframe", bool);
                bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPS, false);
                ay.fpa().encode("clicfg_detect_syncbarrier_leak", bool);
                return true;
              }
              catch (Exception localException)
              {
                ae.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
              }
              return true;
            }
          });
          this.cBL.a(new com.tencent.matrix.b.a());
        }
      }
      else
      {
        i = this.cBN.getInt("ENABLE_BATTERY", 0);
        ae.i("MatrixDelegate", "[isEnableBatteryMonitor] value=%s", new Object[] { Integer.valueOf(i) });
        if (i != 1) {
          break label1133;
        }
        bool = true;
        label449:
        ae.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool)
        {
          localObject1 = new com.tencent.matrix.a.c.a.a().X(com.tencent.matrix.a.c.a.b.class);
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDM = true;
          localObject2 = new com.tencent.matrix.report.a();
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDH = ((a.c)localObject2);
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDI = 120000L;
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDJ = 30000L;
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDL = true;
          ((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDK = 1200000L;
          Collections.sort(((com.tencent.matrix.a.c.a.a)localObject1).cDF.cDN, new a.a.1((com.tencent.matrix.a.c.a.a)localObject1));
          parama.a(new com.tencent.matrix.a.c.a(((com.tencent.matrix.a.c.a.a)localObject1).cDF));
        }
        if ((!ak.coh()) && (!ak.foC()) && (!ak.isAppBrandProcess())) {
          break label1181;
        }
        bool = true;
        label625:
        ae.i("MatrixDelegate", "[isEnableActivityLeak] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject2 = new Intent();
          if (!bv.fnD()) {
            break label1187;
          }
          localObject1 = com.tencent.matrix.resource.b.a.b.cIl;
          label670:
          ae.i("MatrixDelegate", "Dump Activity Leak Mode=%s", new Object[] { localObject1 });
          ((Intent)localObject2).setClassName(ak.getPackageName(), "com.tencent.mm.ui.matrix.ManualDumpActivity");
          com.tencent.matrix.resource.b.a.a locala = new com.tencent.matrix.resource.b.a.a();
          locala.cET = paramf;
          locala.cIj = ((com.tencent.matrix.resource.b.a.b)localObject1);
          locala.cIi = ((Intent)localObject2);
          parama.a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(locala.cET, locala.cIj, locala.cIh, locala.cIi, (byte)0)));
          com.tencent.matrix.resource.b.b(paramApplication);
        }
        ae.i("MatrixDelegate", "[isEnableIOCanary] isEnable=%s", new Object[] { Boolean.TRUE });
        paramApplication = new com.tencent.matrix.iocanary.a.a.a();
        paramApplication.cCj = paramf;
        parama.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(paramApplication.cCj, (byte)0)));
        bool = bv.fnD();
        ae.i("MatrixDelegate", "[isEnableSQLiteLint] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        parama.a(new SQLiteLintPlugin(paramApplication));
        if (ak.coh())
        {
          paramApplication = new com.tencent.matrix.d.a.a.a();
          paramApplication.cET = paramf;
          parama.a(new com.tencent.matrix.d.a(new com.tencent.matrix.d.a.a(paramApplication.cET, (byte)0)));
        }
        this.cBL.a(new com.tencent.matrix.b.c());
        if (ay.fpa().decodeBool("clicfg_detect_syncbarrier_leak", false))
        {
          ae.i("MatrixDelegate", "SyncBarrierWatchDogPlus start");
          com.tencent.matrix.h.a.JE();
        }
        return;
        bool = false;
        continue;
        if ((i != -1) && ((ak.coh()) || (ak.foC()) || (ak.isAppBrandProcess())))
        {
          bool = true;
          break label96;
        }
        bool = false;
        break label96;
        label1005:
        if ((i != -1) && ((ak.coh()) || (ak.foC()) || (ak.isAppBrandProcess())))
        {
          bool = true;
          break label159;
        }
        bool = false;
        break label159;
        label1041:
        if ((i != -1) && ((ak.coh()) || (ak.foC()) || (ak.isAppBrandProcess()) || (ak.foD())))
        {
          bool = true;
          break label222;
        }
        bool = false;
        break label222;
        label1083:
        if ((i != -1) && ((ak.coh()) || (ak.foC()) || (ak.foD()) || (ak.isAppBrandProcess())))
        {
          bool = true;
          break label285;
        }
        bool = false;
        break label285;
        label1125:
        localObject1 = "";
        break label334;
        label1133:
        if ((i != -1) && ((ak.coh()) || (ak.foC()) || (ak.foD()) || (ak.isAppBrandProcess()) || (ak.foA())))
        {
          bool = true;
          break label449;
        }
        bool = false;
        break label449;
        label1181:
        bool = false;
        break label625;
        label1187:
        if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED))
        {
          localObject1 = com.tencent.matrix.resource.b.a.b.cIn;
          break label670;
        }
        if (com.tencent.mm.protocal.d.FFK)
        {
          localObject1 = com.tencent.matrix.resource.b.a.b.cIn;
          break label670;
        }
        localObject1 = com.tencent.matrix.resource.b.a.b.cIk;
      }
      catch (Throwable paramApplication)
      {
        for (;;)
        {
          paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        }
      }
    }
  }
  
  public final void b(b paramb)
  {
    int i = 0;
    ae.i("MatrixDelegate", "onFinalJob");
    int j = this.cBN.getInt("ENABLE_FPS_FLOAT", 0);
    boolean bool;
    if (j == 1) {
      bool = true;
    }
    for (;;)
    {
      ae.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (j == 1) {
        i = 1;
      }
      if ((i != 0) && (e.Ia())) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            d.dM("ENABLE_FPS");
            d.dM("ENABLE_FPS_FLOAT");
          }
        });
      }
      Application localApplication = this.application;
      paramb = (com.tencent.matrix.resource.b)paramb.V(com.tencent.matrix.resource.b.class);
      BroadcastReceiver local7;
      if (paramb != null)
      {
        paramb.cGs.cJp = new b.b()
        {
          final HashSet<String> cBY = new HashSet();
          private final Set<String> cBZ = new HashSet();
          
          public final boolean G(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            final long l1 = SystemClock.uptimeMillis();
            ae.i("MatrixDelegate", "[onLeak] activity=%s isEnableDump=%s isSilence=%s", new Object[] { paramAnonymousString1, Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) });
            ae.i("MatrixDelegate", "[onLeak] Activity dump [%s]", new Object[] { com.tencent.mm.ad.a.alg() });
            if (!this.cBZ.contains(paramAnonymousString2))
            {
              ae.i("MatrixDelegate", "[onLeak] Activity report: %s", new Object[] { paramAnonymousString2 });
              com.tencent.mm.plugin.report.service.g.yxI.f(18573, new Object[] { paramAnonymousString1, String.format("isEnableDump=%s isSilence=%s", new Object[] { Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) }), Integer.valueOf(0), Integer.valueOf(5), Long.valueOf(l1) });
              this.cBZ.add(paramAnonymousString2);
            }
            long l2;
            if ((d.b(d.this)) && (d.c(d.this)))
            {
              d.b(d.this, false);
              synchronized (this.cBY)
              {
                if (this.cBY.contains(paramAnonymousString1))
                {
                  ae.i("MatrixDelegate", "this activity has dumped! %s", new Object[] { paramAnonymousString1 });
                  return true;
                }
                ??? = (com.tencent.matrix.resource.b)b.HT().V(com.tencent.matrix.resource.b.class);
                if (??? == null)
                {
                  ae.e("MatrixDelegate", "ResourcePlugin not found!");
                  return false;
                }
              }
              if (((com.tencent.matrix.resource.b)???).cGs == null)
              {
                ae.e("MatrixDelegate", "ActivityRefWatcher not found!");
                return false;
              }
              l2 = System.currentTimeMillis();
              ??? = k.W(new com.tencent.matrix.resource.e.d(ak.getContext()).IV());
              if (??? == null) {
                return true;
              }
              try
              {
                long l3 = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
                ae.i("MatrixDelegate", "freeSpace = %s GB", new Object[] { Long.valueOf(l3) });
                if (l3 > 1L) {
                  Debug.dumpHprofData(w.B(((k)???).fTh()));
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.f(18573, new Object[] { paramAnonymousString1, "dump file error!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1) });
                  ae.printErrStackTrace("MatrixDelegate", localException, "dump file error!", new Object[0]);
                }
                ae.i("MatrixDelegate", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), paramAnonymousString2, w.B(((k)???).fTh()) }));
                com.tencent.e.h.MqF.aO(new Runnable()
                {
                  /* Error */
                  public final void run()
                  {
                    // Byte code:
                    //   0: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   3: lstore_1
                    //   4: aload_0
                    //   5: getfield 26	com/tencent/matrix/d$6$1:cCa	Lcom/tencent/mm/vfs/k;
                    //   8: aload_0
                    //   9: getfield 28	com/tencent/matrix/d$6$1:cCb	Ljava/lang/String;
                    //   12: invokestatic 51	com/tencent/matrix/d:b	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)Lcom/tencent/matrix/resource/analyzer/model/a;
                    //   15: astore_3
                    //   16: ldc 53
                    //   18: ldc 55
                    //   20: iconst_2
                    //   21: anewarray 4	java/lang/Object
                    //   24: dup
                    //   25: iconst_0
                    //   26: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   29: lload_1
                    //   30: lsub
                    //   31: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   34: aastore
                    //   35: dup
                    //   36: iconst_1
                    //   37: aload_0
                    //   38: getfield 28	com/tencent/matrix/d$6$1:cCb	Ljava/lang/String;
                    //   41: aastore
                    //   42: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                    //   45: invokestatic 73	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   48: aload_3
                    //   49: invokevirtual 79	com/tencent/matrix/resource/analyzer/model/a:toString	()Ljava/lang/String;
                    //   52: astore 4
                    //   54: aload_3
                    //   55: getfield 83	com/tencent/matrix/resource/analyzer/model/a:cGv	Z
                    //   58: ifeq +57 -> 115
                    //   61: getstatic 89	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
                    //   64: sipush 18573
                    //   67: iconst_5
                    //   68: anewarray 4	java/lang/Object
                    //   71: dup
                    //   72: iconst_0
                    //   73: aload_0
                    //   74: getfield 30	com/tencent/matrix/d$6$1:cCc	Ljava/lang/String;
                    //   77: aastore
                    //   78: dup
                    //   79: iconst_1
                    //   80: aload 4
                    //   82: aastore
                    //   83: dup
                    //   84: iconst_2
                    //   85: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   88: lload_1
                    //   89: lsub
                    //   90: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   93: aastore
                    //   94: dup
                    //   95: iconst_3
                    //   96: bipush 7
                    //   98: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   101: aastore
                    //   102: dup
                    //   103: iconst_4
                    //   104: aload_0
                    //   105: getfield 32	com/tencent/matrix/d$6$1:cCd	J
                    //   108: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   111: aastore
                    //   112: invokevirtual 98	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
                    //   115: ldc 53
                    //   117: aload 4
                    //   119: invokestatic 73	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   122: aload_0
                    //   123: getfield 24	com/tencent/matrix/d$6$1:cCe	Lcom/tencent/matrix/d$6;
                    //   126: getfield 102	com/tencent/matrix/d$6:cBY	Ljava/util/HashSet;
                    //   129: astore_3
                    //   130: aload_3
                    //   131: monitorenter
                    //   132: aload_0
                    //   133: getfield 24	com/tencent/matrix/d$6$1:cCe	Lcom/tencent/matrix/d$6;
                    //   136: getfield 102	com/tencent/matrix/d$6:cBY	Ljava/util/HashSet;
                    //   139: aload_0
                    //   140: getfield 30	com/tencent/matrix/d$6$1:cCc	Ljava/lang/String;
                    //   143: invokevirtual 108	java/util/HashSet:add	(Ljava/lang/Object;)Z
                    //   146: pop
                    //   147: aload_3
                    //   148: monitorexit
                    //   149: aload_0
                    //   150: getfield 26	com/tencent/matrix/d$6$1:cCa	Lcom/tencent/mm/vfs/k;
                    //   153: invokevirtual 114	com/tencent/mm/vfs/k:delete	()Z
                    //   156: pop
                    //   157: return
                    //   158: astore 4
                    //   160: aload_3
                    //   161: monitorexit
                    //   162: aload 4
                    //   164: athrow
                    //   165: astore_3
                    //   166: getstatic 89	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
                    //   169: sipush 18573
                    //   172: iconst_5
                    //   173: anewarray 4	java/lang/Object
                    //   176: dup
                    //   177: iconst_0
                    //   178: aload_0
                    //   179: getfield 30	com/tencent/matrix/d$6$1:cCc	Ljava/lang/String;
                    //   182: aastore
                    //   183: dup
                    //   184: iconst_1
                    //   185: ldc 116
                    //   187: aastore
                    //   188: dup
                    //   189: iconst_2
                    //   190: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   193: lload_1
                    //   194: lsub
                    //   195: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   198: aastore
                    //   199: dup
                    //   200: iconst_3
                    //   201: iconst_3
                    //   202: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   205: aastore
                    //   206: dup
                    //   207: iconst_4
                    //   208: aload_0
                    //   209: getfield 32	com/tencent/matrix/d$6$1:cCd	J
                    //   212: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   215: aastore
                    //   216: invokevirtual 98	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
                    //   219: ldc 53
                    //   221: aload_3
                    //   222: invokevirtual 120	java/lang/OutOfMemoryError:getCause	()Ljava/lang/Throwable;
                    //   225: ldc 122
                    //   227: iconst_0
                    //   228: anewarray 4	java/lang/Object
                    //   231: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
                    //   234: aload_0
                    //   235: getfield 26	com/tencent/matrix/d$6$1:cCa	Lcom/tencent/mm/vfs/k;
                    //   238: invokevirtual 114	com/tencent/mm/vfs/k:delete	()Z
                    //   241: pop
                    //   242: return
                    //   243: astore_3
                    //   244: aload_0
                    //   245: getfield 26	com/tencent/matrix/d$6$1:cCa	Lcom/tencent/mm/vfs/k;
                    //   248: invokevirtual 114	com/tencent/mm/vfs/k:delete	()Z
                    //   251: pop
                    //   252: aload_3
                    //   253: athrow
                    // Local variable table:
                    //   start	length	slot	name	signature
                    //   0	254	0	this	1
                    //   3	191	1	l	long
                    //   165	57	3	localOutOfMemoryError	java.lang.OutOfMemoryError
                    //   243	10	3	localObject2	Object
                    //   52	66	4	str	String
                    //   158	5	4	localObject3	Object
                    // Exception table:
                    //   from	to	target	type
                    //   132	149	158	finally
                    //   160	162	158	finally
                    //   4	115	165	java/lang/OutOfMemoryError
                    //   115	132	165	java/lang/OutOfMemoryError
                    //   162	165	165	java/lang/OutOfMemoryError
                    //   4	115	243	finally
                    //   115	132	243	finally
                    //   162	165	243	finally
                    //   166	234	243	finally
                  }
                });
                return true;
              }
              if (((k)???).length() <= 0L)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(18573, new Object[] { paramAnonymousString1, "file is null!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1) });
                ae.e("MatrixDelegate", "file is null!");
                return true;
              }
            }
            return false;
          }
        };
        paramb = new IntentFilter();
        paramb.addAction("android.intent.action.SCREEN_OFF");
        local7 = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            if (Objects.equals(paramAnonymousIntent.getAction(), "android.intent.action.SCREEN_OFF"))
            {
              d.b(d.this, true);
              paramAnonymousContext = d.this;
              if ((!j.DEBUG) && (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzu, false))) {
                break label85;
              }
            }
            label85:
            for (boolean bool = true;; bool = false)
            {
              d.c(paramAnonymousContext, bool);
              ae.i("MatrixDelegate", "[ACTION_SCREEN_OFF] isEnableDump=%s", new Object[] { Boolean.valueOf(d.b(d.this)) });
              return;
            }
          }
        };
      }
      try
      {
        localApplication.getApplicationContext().registerReceiver(local7, paramb);
        this.isInitialized = true;
        if (this.cBM) {
          bV(AppForegroundDelegate.cTA.cBB);
        }
        if (ay.fpa().decodeBool("clicfg_detect_dropframe", true))
        {
          ae.i("MatrixDelegate", "start detecting dropFrame");
          paramb = (com.tencent.matrix.trace.a)b.HT().V(com.tencent.matrix.trace.a.class);
          if (paramb == null) {
            ae.i("MatrixDelegate", "tracePlugin is null");
          }
        }
        else
        {
          return;
          bool = false;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localApplication.getApplicationContext().unregisterReceiver(local7);
          localApplication.getApplicationContext().registerReceiver(local7, paramb);
        }
        paramb = paramb.cKh;
        if (paramb == null)
        {
          ae.i("MatrixDelegate", "frameTracer is null");
          return;
        }
        paramb.cLQ = new com.tencent.matrix.trace.f.c.a()
        {
          public final void a(int paramAnonymousInt, final String paramAnonymousString, final long paramAnonymousLong)
          {
            com.tencent.e.h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                int i = 4;
                int j = 1;
                for (;;)
                {
                  try
                  {
                    long l1 = System.currentTimeMillis() - paramAnonymousLong;
                    if (l1 <= 0L) {
                      break;
                    }
                    ae.i("MatrixDelegate", "happens dropFrames : dropFrame = %d, scene = %s, lastResumeTime = %d, timeAfterResume = %d", new Object[] { Integer.valueOf(paramAnonymousString), this.cBW, Long.valueOf(paramAnonymousLong), Long.valueOf(l1) });
                    if ((l1 <= 2000L) || (!this.cBW.contains("Finder"))) {
                      break;
                    }
                    if (paramAnonymousString < 15)
                    {
                      i = 1;
                      int k = com.tencent.matrix.g.a.aP(ak.getContext()).value;
                      long l2 = Math.min(paramAnonymousString * 16, 2000);
                      Thread.sleep(l2);
                      if ((d.cBK.cBL == null) || (d.cBK.cBL.cFY == null)) {
                        break label370;
                      }
                      h.d locald = (h.d)d.cBK.cBL.cFY.getFirst();
                      if (locald != null)
                      {
                        long l3 = locald.cFG.getLong("time");
                        if (System.currentTimeMillis() - l3 < l2 * 2L)
                        {
                          String str = "";
                          if (j != 0) {
                            str = locald.cFG.toString();
                          }
                          com.tencent.mm.plugin.report.e.ywz.f(20502, new Object[] { Integer.valueOf(paramAnonymousString), this.cBW, Integer.valueOf(i), Integer.valueOf(k), Long.valueOf(l1), str });
                        }
                      }
                    }
                    else
                    {
                      if (paramAnonymousString < 30)
                      {
                        i = 2;
                        continue;
                      }
                      if (paramAnonymousString < 60)
                      {
                        i = 3;
                        continue;
                      }
                      if (paramAnonymousString < 90) {
                        continue;
                      }
                      i = paramAnonymousString;
                      if (i < 120)
                      {
                        i = 5;
                        continue;
                      }
                      i = 6;
                      continue;
                    }
                    j = 0;
                  }
                  catch (Throwable localThrowable)
                  {
                    ae.i("MatrixDelegate", "report dropFrame error = " + localThrowable.getMessage());
                    return;
                  }
                  continue;
                  label370:
                  Object localObject = null;
                }
              }
            });
          }
        };
        paramb.cLR = 9;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d
 * JD-Core Version:    0.7.0.1
 */