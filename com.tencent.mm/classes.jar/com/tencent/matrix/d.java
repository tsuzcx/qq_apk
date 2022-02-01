package com.tencent.matrix;

import android.app.Application;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.j;
import com.tencent.matrix.report.k;
import com.tencent.matrix.report.k.a;
import com.tencent.matrix.report.k.c;
import com.tencent.matrix.report.m;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public enum d
  implements c.a
{
  private static boolean cQH = false;
  private Application application;
  public k cQB = null;
  private volatile boolean cQC = false;
  private final MultiProcessMMKV cQD = MultiProcessMMKV.getMMKV("MatrixDelegate");
  public com.tencent.matrix.strategy.a cQE;
  private final int cQF = 9;
  private final int cQG = 1699;
  private boolean dqj = false;
  public volatile boolean isInitialized = false;
  
  private d() {}
  
  private void cN(boolean paramBoolean)
  {
    if (!this.isInitialized)
    {
      Log.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
      this.cQC = true;
    }
    for (;;)
    {
      return;
      if (MMApplicationContext.isMainProcess())
      {
        MrsLogic.onForeground(paramBoolean);
        if (!paramBoolean) {
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              d.a(d.this);
            }
          }, "MatrixDelegate");
        }
      }
      Iterator localIterator = b.Vu().coE.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.matrix.d.b localb = (com.tencent.matrix.d.b)localIterator.next();
        if ((!(localb instanceof com.tencent.matrix.trace.b)) && (!(localb instanceof com.tencent.matrix.a.c))) {
          localb.onForeground(paramBoolean);
        }
      }
    }
  }
  
  public final void VA()
  {
    int i = 0;
    Log.i("MatrixDelegate", "onFinalJob");
    int j = this.cQD.getInt("ENABLE_FPS_FLOAT", 0);
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (j == 1) {
        i = 1;
      }
      if ((i != 0) && (e.VC())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            d.eI("ENABLE_FPS");
            d.eI("ENABLE_FPS_FLOAT");
          }
        });
      }
      this.isInitialized = true;
      if (this.cQC) {
        cN(AppForegroundDelegate.fby.cQt);
      }
      if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_dropframe", true))
      {
        Log.i("MatrixDelegate", "start detecting dropFrame");
        localObject = (com.tencent.matrix.trace.b)b.Vu().Y(com.tencent.matrix.trace.b.class);
        if (localObject != null) {
          break;
        }
        Log.i("MatrixDelegate", "tracePlugin is null");
      }
      return;
    }
    Object localObject = ((com.tencent.matrix.trace.b)localObject).deH;
    if (localObject == null)
    {
      Log.i("MatrixDelegate", "frameTracer is null");
      return;
    }
    ((com.tencent.matrix.trace.f.c)localObject).dgr = new d.4(this);
    ((com.tencent.matrix.trace.f.c)localObject).dgs = 9;
  }
  
  public final com.tencent.matrix.e.c.a Vv()
  {
    return new d.1(this);
  }
  
  public final k Vw()
  {
    long l2 = 5L;
    k.a locala = new k.a(MMApplicationContext.getContext());
    locala.daj = Long.valueOf(com.tencent.mm.protocal.d.RAD);
    locala.das = Boolean.valueOf(WeChatEnvironment.isMonkeyEnv());
    locala.dak = BuildInfo.REV;
    long l1 = l2;
    if (!BuildInfo.IS_FLAVOR_PURPLE)
    {
      l1 = l2;
      if (!BuildInfo.IS_FLAVOR_RED)
      {
        if (!BuildInfo.DEBUG) {
          break label188;
        }
        l1 = l2;
      }
    }
    for (;;)
    {
      locala.dam = Long.valueOf(l1);
      Objects.requireNonNull(locala.context, "matrix report init, context is null");
      Objects.requireNonNull(locala.daj, "matrix report init, clientVersion is null");
      Objects.requireNonNull(locala.dak, "matrix report init, revision is null");
      Objects.requireNonNull(locala.dam, "matrix report init, publishType is null");
      this.cQB = new k(locala.context, locala.daj, locala.dak, locala.das, locala.dam);
      Log.i("MatrixDelegate", "init matrix reporter. %s", new Object[] { this.cQB });
      return this.cQB;
      label188:
      l1 = l2;
      if (!com.tencent.mm.protocal.d.RAG) {
        if (com.tencent.mm.protocal.d.RAE) {
          l1 = 3L;
        } else if (com.tencent.mm.protocal.d.RAF) {
          l1 = 4L;
        } else {
          l1 = -1L;
        }
      }
    }
  }
  
  public final f Vx()
  {
    return new f();
  }
  
  public final k.c Vy()
  {
    return new j();
  }
  
  public final o Vz()
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
  
  public final void a(Application paramApplication, b.a parama, f paramf)
  {
    cQH = MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_base_swtich", false);
    EventCenter.instance.add(new IListener()
    {
      private static boolean VB()
      {
        try
        {
          boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWR, true);
          MultiProcessMMKV.getDefault().encode("clicfg_anr_report_all", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWS, false);
          MultiProcessMMKV.getDefault().encode("clicfg_normal_report", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vXx, true);
          MultiProcessMMKV.getDefault().encode("clicfg_detect_dropframe", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYf, false);
          MultiProcessMMKV.getDefault().encode("clicfg_detect_syncbarrier_leak", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vwk, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_base_swtich", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vwj, true);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_traceplugin_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vwq, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_trace_evil_method_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vxb, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_io_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vwr, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_frame_tracer_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vws, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_startup_tracer_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vwt, false);
          MultiProcessMMKV.getDefault().encode("clicfg_matrix_trace_anr_switch", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wcl, false);
          MultiProcessMMKV.getDefault().encode("clicfg_camera_util_use_cache", bool);
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wck, false);
          MultiProcessMMKV.getDefault().encode("clicfg_voip_camera_info_use_cache", bool);
          return true;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
        }
        return true;
      }
    });
    boolean bool1;
    int j;
    label130:
    Object localObject2;
    int i;
    boolean bool2;
    label201:
    label347:
    Object localObject1;
    if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_traceplugin_switch", true)) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isImeProcess())))
    {
      bool1 = true;
      Log.i("MatrixDelegate", "[isEnableTracePlugin] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.matrix.trace.a.a.XY().deL = true;
        j = this.cQD.getInt(com.tencent.b.a.a.a.Zby.name(), 0);
        if (j != 1) {
          break label1017;
        }
        bool1 = true;
        Log.i("MatrixDelegate", "[isEnableEvilMethod] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
        localObject2 = new com.tencent.matrix.trace.a.b.a();
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.dcH = paramf;
        i = this.cQD.getInt(com.tencent.b.a.a.a.Zbq.name(), 0);
        if (i != 1) {
          break label1092;
        }
        bool2 = true;
        Log.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deM = bool2;
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deP = bool1;
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deN = bool1;
        i = this.cQD.getInt(com.tencent.b.a.a.a.ZbA.name(), 0);
        if (i != 1) {
          break label1147;
        }
        bool1 = true;
        label284:
        Log.i("MatrixDelegate", "[isEnableStartUp] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deO = bool1;
        j = this.cQD.getInt(com.tencent.b.a.a.a.Zbz.name(), 0);
        if (j != 1) {
          break label1202;
        }
        bool1 = true;
        Log.i("MatrixDelegate", "[isEnableAnr] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deQ = bool1;
        if (!MMApplicationContext.isMainProcess()) {
          break label1295;
        }
        localObject1 = "com.tencent.mm.app.WeChatSplashActivity;com.tencent.mm.plugin.account.ui.WelcomeActivity;";
        label396:
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deS = ((String)localObject1);
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.dal = true;
        ((com.tencent.matrix.trace.a.b.a)localObject2).deV.deR = false;
        localObject1 = new com.tencent.matrix.trace.b(((com.tencent.matrix.trace.a.b.a)localObject2).deV);
        parama.a((com.tencent.matrix.d.b)localObject1);
        this.cQB.a((com.tencent.matrix.d.b)localObject1, new com.tencent.matrix.report.b());
      }
      i = this.cQD.getInt("ENABLE_BATTERY", 0);
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] value=%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label1303;
      }
      bool1 = true;
      label503:
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
      if (!bool1) {
        break label1642;
      }
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
      if (localObject1 == null) {
        break label1635;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.vTf, 127);
      label566:
      if (!MMApplicationContext.isMainProcess()) {
        break label1357;
      }
      if ((i & 0x1) != 1) {
        break label1351;
      }
      bool1 = true;
      label583:
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s cliCfg=%s", new Object[] { Boolean.valueOf(bool1), Integer.toBinaryString(i) });
    }
    label658:
    label709:
    label1351:
    label1357:
    label1614:
    label1635:
    label1642:
    for (;;)
    {
      for (;;)
      {
        if (bool1)
        {
          localObject1 = com.tencent.matrix.c.a.WT();
          com.tencent.matrix.c.b.Xn();
          parama.a((com.tencent.matrix.d.b)localObject1);
        }
        if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()))
        {
          bool1 = true;
          Log.i("MatrixDelegate", "[isEnableActivityLeak] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
          if (bool1)
          {
            localObject2 = new Intent();
            if ((!BuildInfo.DEBUG) && (!WeChatEnvironment.hasDebugger())) {
              break label1473;
            }
            localObject1 = a.b.dcK;
            if (a.b.dcL == localObject1) {
              this.dqj = true;
            }
            Log.i("MatrixDelegate", "Dump Activity Leak Mode=%s", new Object[] { localObject1 });
            ((Intent)localObject2).setClassName(WeChatBrands.AppInfo.current().getPackageName(), "com.tencent.mm.ui.matrix.ManualDumpActivity");
            localObject2 = new com.tencent.matrix.resource.b.a.a();
            ((com.tencent.matrix.resource.b.a.a)localObject2).dcH = paramf;
            ((com.tencent.matrix.resource.b.a.a)localObject2).dcG = ((a.b)localObject1);
            ((com.tencent.matrix.resource.b.a.a)localObject2).dcF = "com.tencent.mm.ui.matrix.ManualDumpActivity";
            localObject1 = new com.tencent.matrix.resource.c(new com.tencent.matrix.resource.b.a(((com.tencent.matrix.resource.b.a.a)localObject2).dcH, ((com.tencent.matrix.resource.b.a.a)localObject2).dcG, ((com.tencent.matrix.resource.b.a.a)localObject2).dcE, ((com.tencent.matrix.resource.b.a.a)localObject2).dcF, (byte)0));
            parama.a((com.tencent.matrix.d.b)localObject1);
            com.tencent.matrix.resource.c.d(paramApplication);
            this.cQB.a((com.tencent.matrix.d.b)localObject1, new m());
          }
          if ((!cQH) || (!MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_io_switch", false))) {
            break label1614;
          }
          bool1 = true;
          Log.i("MatrixDelegate", "[isEnableIOCanary] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
          if (bool1)
          {
            paramApplication = new com.tencent.matrix.iocanary.a.a.a();
            paramApplication.cYC = paramf;
            parama.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(paramApplication.cYC, (byte)0)));
          }
          bool1 = WeChatEnvironment.isMonkeyEnv();
          Log.i("MatrixDelegate", "[isEnableSQLiteLint] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {}
        }
        try
        {
          paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
          parama.a(new SQLiteLintPlugin(paramApplication));
          if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_syncbarrier_leak", false))
          {
            Log.i("MatrixDelegate", "SyncBarrierWatchDogPlus start");
            com.tencent.matrix.f.a.Yv();
          }
          return;
          bool1 = false;
          break;
          label1017:
          if (j != -1)
          {
            if ((cQH) && (MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_trace_evil_method_switch", false))) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || ((!MMApplicationContext.isMainProcess()) && (!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isAppBrandProcess()) && (!MMApplicationContext.isToolsMpProcess()))) {
                break label1086;
              }
              bool1 = true;
              break;
            }
          }
          bool1 = false;
          break label130;
          if ((i != -1) && (MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_frame_tracer_switch", false)) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess())))
          {
            bool2 = true;
            break label201;
          }
          bool2 = false;
          break label201;
          label1147:
          if ((i != -1) && (MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_startup_tracer_switch", false)) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess())))
          {
            bool1 = true;
            break label284;
          }
          bool1 = false;
          break label284;
          if (j != -1)
          {
            if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_matrix_trace_anr_switch", false)) || (com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || ((!MMApplicationContext.isMainProcess()) && (!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isToolsMpProcess()) && (!MMApplicationContext.isAppBrandProcess()))) {
                break label1289;
              }
              bool1 = true;
              break;
            }
          }
          bool1 = false;
          break label347;
          localObject1 = "";
          break label396;
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isPushProcess())))
          {
            bool1 = true;
            break label503;
          }
          bool1 = false;
          break label503;
          bool1 = false;
          break label583;
          if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
          {
            if ((i & 0x2) == 2)
            {
              bool1 = true;
              break label583;
            }
            bool1 = false;
            break label583;
          }
          if (MMApplicationContext.isAppBrandProcess())
          {
            if ((i & 0x4) == 4)
            {
              bool1 = true;
              break label583;
            }
            bool1 = false;
            break label583;
          }
          if (MMApplicationContext.isPushProcess())
          {
            if ((i & 0x8) == 8)
            {
              bool1 = true;
              break label583;
            }
            bool1 = false;
            break label583;
          }
          if ((i & 0x80) == 128)
          {
            bool1 = true;
            break label583;
          }
          bool1 = false;
          break label583;
          bool1 = false;
          break label658;
          long l = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_matrix_activity_leak_silence_analyse_rate", "-1", false, true), -1L);
          if (Math.random() < 1.0D / l)
          {
            Log.i("MatrixDelegate", "enable silence dump cause expt: clicfg_matrix_activity_leak_silence_analyse_rate");
            com.tencent.mm.plugin.report.service.h.IzE.p(1699L, 0L, 1L);
            localObject1 = a.b.dcL;
            break label709;
          }
          if (WeChatEnvironment.isMonkeyEnv())
          {
            Log.i("MatrixDelegate", "enable silence dump cause monkey");
            localObject1 = a.b.dcL;
            break label709;
          }
          if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
          {
            Log.i("MatrixDelegate", "enable silence dump cause purple/red");
            localObject1 = a.b.dcL;
            break label709;
          }
          if (com.tencent.mm.protocal.d.RAG)
          {
            Log.i("MatrixDelegate", "enable silence dump cause alpha");
            localObject1 = a.b.dcL;
            break label709;
          }
          localObject1 = a.b.dcI;
          break label709;
          bool1 = false;
        }
        catch (Throwable paramApplication)
        {
          for (;;)
          {
            paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
          }
        }
      }
      i = 127;
      break label566;
    }
  }
  
  public final void b(Application paramApplication)
  {
    this.application = paramApplication;
    this.cQE = new com.tencent.matrix.strategy.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d
 * JD-Core Version:    0.7.0.1
 */