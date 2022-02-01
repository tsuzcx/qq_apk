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
import com.tencent.f.i;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h.a;
import com.tencent.matrix.report.h.b;
import com.tencent.matrix.report.h.d;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.e.b.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.aa;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import java.io.File;
import java.io.IOException;
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
  public com.tencent.matrix.report.h cPJ = null;
  private volatile boolean cPK = false;
  private final MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");
  public com.tencent.matrix.strategy.a cPM;
  private final int cPN = 9;
  private boolean cPO = false;
  private volatile boolean cPP = false;
  public volatile boolean isInitialized = false;
  
  private d() {}
  
  private static com.tencent.matrix.resource.analyzer.model.a a(com.tencent.mm.vfs.o paramo, String paramString)
  {
    com.tencent.matrix.resource.analyzer.model.d locald = com.tencent.matrix.resource.analyzer.model.c.m(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
    try
    {
      paramo = new com.tencent.matrix.resource.analyzer.model.g(paramo);
      paramo = new com.tencent.matrix.resource.analyzer.a(paramString, locald).a(paramo);
      return paramo;
    }
    catch (IOException paramo) {}
    return com.tencent.matrix.resource.analyzer.model.a.a(paramo, 0L);
  }
  
  private void cy(boolean paramBoolean)
  {
    if (!this.isInitialized)
    {
      Log.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
      this.cPK = true;
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      MrsLogic.onForeground(paramBoolean);
      if (!paramBoolean) {
        com.tencent.f.h.RTc.b(new Runnable()
        {
          public final void run()
          {
            d.a(d.this);
          }
        }, "MatrixDelegate");
      }
    }
    Iterator localIterator = b.RG().cqP.iterator();
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
      this.cPP = paramBoolean;
      return;
    }
  }
  
  public final com.tencent.matrix.g.c.a RH()
  {
    new com.tencent.matrix.g.c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
    };
  }
  
  public final com.tencent.matrix.report.h RI()
  {
    long l2 = 5L;
    h.a locala = new h.a(MMApplicationContext.getContext());
    locala.cWo = Long.valueOf(com.tencent.mm.protocal.d.KyO);
    locala.cWx = Boolean.valueOf(WeChatEnvironment.isMonkeyEnv());
    locala.cWp = BuildInfo.REV;
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
      locala.cWr = Long.valueOf(l1);
      Objects.requireNonNull(locala.context, "matrix report init, context is null");
      Objects.requireNonNull(locala.cWo, "matrix report init, clientVersion is null");
      Objects.requireNonNull(locala.cWp, "matrix report init, revision is null");
      Objects.requireNonNull(locala.cWr, "matrix report init, publishType is null");
      this.cPJ = new com.tencent.matrix.report.h(locala.context, locala.cWo, locala.cWp, locala.cWx, locala.cWr);
      Log.i("MatrixDelegate", "init matrix reporter. %s", new Object[] { this.cPJ });
      return this.cPJ;
      label188:
      l1 = l2;
      if (!com.tencent.mm.protocal.d.KyR) {
        if (com.tencent.mm.protocal.d.KyP) {
          l1 = 3L;
        } else if (com.tencent.mm.protocal.d.KyQ) {
          l1 = 4L;
        } else {
          l1 = -1L;
        }
      }
    }
  }
  
  public final f RJ()
  {
    return new f();
  }
  
  public final h.b RK()
  {
    return new com.tencent.matrix.report.g();
  }
  
  public final com.tencent.mm.app.o RL()
  {
    new com.tencent.mm.app.o()
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
    this.cPM = new com.tencent.matrix.strategy.d();
  }
  
  public final void a(Application paramApplication, b.a parama, f paramf)
  {
    boolean bool;
    Object localObject2;
    int i;
    label96:
    Object localObject1;
    if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()))
    {
      bool = true;
      Log.i("MatrixDelegate", "[isEnableTracePlugin] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.matrix.trace.a.a.Tu().daJ = true;
        localObject2 = new com.tencent.matrix.trace.a.b.a();
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.cVx = paramf;
        i = this.cPL.getInt(com.tencent.c.a.a.a.RzK.name(), 0);
        if (i != 1) {
          break label966;
        }
        bool = true;
        Log.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daK = bool;
        i = this.cPL.getInt(com.tencent.c.a.a.a.RzS.name(), 0);
        if (i != 1) {
          break label1002;
        }
        bool = true;
        label159:
        Log.i("MatrixDelegate", "[isEnableEvilMethod] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daL = bool;
        i = this.cPL.getInt(com.tencent.c.a.a.a.RzU.name(), 0);
        if (i != 1) {
          break label1038;
        }
        bool = true;
        label222:
        Log.i("MatrixDelegate", "[isEnableStartUp] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daM = bool;
        i = this.cPL.getInt(com.tencent.c.a.a.a.RzT.name(), 0);
        if (i != 1) {
          break label1080;
        }
        bool = true;
        label285:
        Log.i("MatrixDelegate", "[isEnableAnr] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daN = bool;
        if (!MMApplicationContext.isMainProcess()) {
          break label1122;
        }
        localObject1 = "com.tencent.mm.app.WeChatSplashActivity;com.tencent.mm.plugin.account.ui.WelcomeActivity;";
        label334:
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daP = ((String)localObject1);
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.cWq = true;
        ((com.tencent.matrix.trace.a.b.a)localObject2).daS.daO = false;
        parama.a(new com.tencent.matrix.trace.a(((com.tencent.matrix.trace.a.b.a)localObject2).daS));
        EventCenter.instance.add(new IListener()
        {
          private static boolean RM()
          {
            try
            {
              boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.smc, true);
              MultiProcessMMKV.getDefault().encode("clicfg_anr_report_all", bool);
              bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.smd, false);
              MultiProcessMMKV.getDefault().encode("clicfg_normal_report", bool);
              bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.smA, true);
              MultiProcessMMKV.getDefault().encode("clicfg_detect_dropframe", bool);
              bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.snd, false);
              MultiProcessMMKV.getDefault().encode("clicfg_detect_syncbarrier_leak", bool);
              return true;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
            }
            return true;
          }
        });
        this.cPJ.a(new com.tencent.matrix.b.a());
      }
      i = this.cPL.getInt("ENABLE_BATTERY", 0);
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] value=%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label1130;
      }
      bool = true;
      label449:
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if (!bool) {
        break label1408;
      }
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
      if (localObject1 == null) {
        break label1401;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(com.tencent.mm.plugin.expt.b.b.a.siY, 127);
      label512:
      if (!MMApplicationContext.isMainProcess()) {
        break label1184;
      }
      if ((i & 0x1) != 1) {
        break label1178;
      }
      bool = true;
      label529:
      Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s cliCfg=%s", new Object[] { Boolean.valueOf(bool), Integer.toBinaryString(i) });
    }
    label1408:
    for (;;)
    {
      for (;;)
      {
        if (bool) {
          parama.a(com.tencent.matrix.c.a.Sz());
        }
        if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()))
        {
          bool = true;
          label591:
          Log.i("MatrixDelegate", "[isEnableActivityLeak] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new Intent();
            if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_matrix_activity_leak_silence_dump", "0", false, true), 0) == 0) {
              break label1300;
            }
            i = 1;
            label649:
            if (i == 0) {
              break label1306;
            }
            Log.i("MatrixDelegate", "enable silence dump cause expt: clicfg_matrix_activity_leak_silence_dump");
            localObject1 = a.b.cYK;
            label667:
            Log.i("MatrixDelegate", "Dump Activity Leak Mode=%s", new Object[] { localObject1 });
            ((Intent)localObject2).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.matrix.ManualDumpActivity");
            com.tencent.matrix.resource.b.a.a locala = new com.tencent.matrix.resource.b.a.a();
            locala.cVx = paramf;
            locala.cYG = ((a.b)localObject1);
            locala.cYF = ((Intent)localObject2);
            parama.a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(locala.cVx, locala.cYG, locala.cYE, locala.cYF, (byte)0)));
            com.tencent.matrix.resource.b.b(paramApplication);
          }
          Log.i("MatrixDelegate", "[isEnableIOCanary] isEnable=%s", new Object[] { Boolean.TRUE });
          paramApplication = new com.tencent.matrix.iocanary.a.a.a();
          paramApplication.cQF = paramf;
          parama.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(paramApplication.cQF, (byte)0)));
          bool = WeChatEnvironment.isMonkeyEnv();
          Log.i("MatrixDelegate", "[isEnableSQLiteLint] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        try
        {
          paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
          parama.a(new SQLiteLintPlugin(paramApplication));
          if (MMApplicationContext.isMainProcess())
          {
            paramApplication = new com.tencent.matrix.d.a.a.a();
            paramApplication.cVx = paramf;
            parama.a(new com.tencent.matrix.d.a(new com.tencent.matrix.d.a.a(paramApplication.cVx, (byte)0)));
          }
          this.cPJ.a(new com.tencent.matrix.b.d());
          if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_syncbarrier_leak", false))
          {
            Log.i("MatrixDelegate", "SyncBarrierWatchDogPlus start");
            com.tencent.matrix.h.a.TR();
          }
          return;
          bool = false;
          break;
          label966:
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess())))
          {
            bool = true;
            break label96;
          }
          bool = false;
          break label96;
          label1002:
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess())))
          {
            bool = true;
            break label159;
          }
          bool = false;
          break label159;
          label1038:
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess())))
          {
            bool = true;
            break label222;
          }
          bool = false;
          break label222;
          label1080:
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isAppBrandProcess())))
          {
            bool = true;
            break label285;
          }
          bool = false;
          break label285;
          label1122:
          localObject1 = "";
          break label334;
          label1130:
          if ((i != -1) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isPushProcess())))
          {
            bool = true;
            break label449;
          }
          bool = false;
          break label449;
          label1178:
          bool = false;
          break label529;
          label1184:
          if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
          {
            if ((i & 0x2) == 2)
            {
              bool = true;
              break label529;
            }
            bool = false;
            break label529;
          }
          if (MMApplicationContext.isAppBrandProcess())
          {
            if ((i & 0x4) == 4)
            {
              bool = true;
              break label529;
            }
            bool = false;
            break label529;
          }
          if (MMApplicationContext.isPushProcess())
          {
            if ((i & 0x8) == 8)
            {
              bool = true;
              break label529;
            }
            bool = false;
            break label529;
          }
          if ((i & 0x80) == 128)
          {
            bool = true;
            break label529;
          }
          bool = false;
          break label529;
          bool = false;
          break label591;
          label1300:
          i = 0;
          break label649;
          label1306:
          if (WeChatEnvironment.isMonkeyEnv())
          {
            Log.i("MatrixDelegate", "enable silence dump cause monkey");
            localObject1 = a.b.cYK;
            break label667;
          }
          if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
          {
            Log.i("MatrixDelegate", "enable silence dump cause purple/red");
            localObject1 = a.b.cYK;
            break label667;
          }
          if (com.tencent.mm.protocal.d.KyR)
          {
            Log.i("MatrixDelegate", "enable silence dump cause alpha");
            localObject1 = a.b.cYK;
            break label667;
          }
          localObject1 = a.b.cYH;
        }
        catch (Throwable paramApplication)
        {
          for (;;)
          {
            paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
          }
        }
      }
      label1401:
      i = 127;
      break label512;
    }
  }
  
  public final void b(b paramb)
  {
    int i = 0;
    Log.i("MatrixDelegate", "onFinalJob");
    int j = this.cPL.getInt("ENABLE_FPS_FLOAT", 0);
    boolean bool;
    if (j == 1) {
      bool = true;
    }
    for (;;)
    {
      Log.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (j == 1) {
        i = 1;
      }
      if ((i != 0) && (e.RN())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            d.eh("ENABLE_FPS");
            d.eh("ENABLE_FPS_FLOAT");
          }
        });
      }
      Application localApplication = this.application;
      paramb = (com.tencent.matrix.resource.b)paramb.Y(com.tencent.matrix.resource.b.class);
      BroadcastReceiver local7;
      if (paramb != null)
      {
        paramb.cWQ.cZM = new b.b()
        {
          final HashSet<String> cPW = new HashSet();
          private final Set<String> cPX = new HashSet();
          private final double cPY = Math.random();
          
          public final boolean G(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            final long l1 = SystemClock.uptimeMillis();
            Log.i("MatrixDelegate", "[onLeak] activity=%s isEnableDump=%s isSilence=%s", new Object[] { paramAnonymousString1, Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) });
            Log.i("MatrixDelegate", "[onLeak] Activity dump [%s]", new Object[] { com.tencent.mm.ad.a.aBz() });
            if (!this.cPX.contains(paramAnonymousString2))
            {
              Log.i("MatrixDelegate", "[onLeak] Activity report: %s", new Object[] { paramAnonymousString2 });
              com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { paramAnonymousString1, String.format("isEnableDump=%s isSilence=%s", new Object[] { Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) }), Integer.valueOf(0), Integer.valueOf(5), Long.valueOf(l1), BuildInfo.BUILD_TAG });
              this.cPX.add(paramAnonymousString2);
            }
            long l2;
            if ((d.b(d.this)) && (d.c(d.this)))
            {
              d.b(d.this, false);
              synchronized (this.cPW)
              {
                if (this.cPW.contains(paramAnonymousString1))
                {
                  Log.i("MatrixDelegate", "this activity has dumped! %s", new Object[] { paramAnonymousString1 });
                  return true;
                }
                ??? = (com.tencent.matrix.resource.b)b.RG().Y(com.tencent.matrix.resource.b.class);
                if (??? == null)
                {
                  Log.e("MatrixDelegate", "ResourcePlugin not found!");
                  return false;
                }
              }
              if (((com.tencent.matrix.resource.b)???).cWQ == null)
              {
                Log.e("MatrixDelegate", "ActivityRefWatcher not found!");
                return false;
              }
              l2 = System.currentTimeMillis();
              ??? = com.tencent.mm.vfs.o.X(new com.tencent.matrix.resource.e.d(MMApplicationContext.getContext()).Tj());
              if (??? == null) {
                return true;
              }
              try
              {
                long l3 = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
                Log.i("MatrixDelegate", "freeSpace = %s GB", new Object[] { Long.valueOf(l3) });
                if (l3 > 1L) {
                  Debug.dumpHprofData(aa.z(((com.tencent.mm.vfs.o)???).her()));
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { paramAnonymousString1, "dump file error!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1), BuildInfo.BUILD_TAG });
                  Log.printErrStackTrace("MatrixDelegate", localException, "dump file error!", new Object[0]);
                }
                Log.i("MatrixDelegate", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), paramAnonymousString2, aa.z(((com.tencent.mm.vfs.o)???).her()) }));
                com.tencent.f.h.RTc.aX(new Runnable()
                {
                  /* Error */
                  public final void run()
                  {
                    // Byte code:
                    //   0: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   3: lstore_1
                    //   4: aload_0
                    //   5: getfield 26	com/tencent/matrix/d$6$1:cPZ	Lcom/tencent/mm/vfs/o;
                    //   8: aload_0
                    //   9: getfield 28	com/tencent/matrix/d$6$1:cQa	Ljava/lang/String;
                    //   12: invokestatic 51	com/tencent/matrix/d:b	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)Lcom/tencent/matrix/resource/analyzer/model/a;
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
                    //   38: getfield 28	com/tencent/matrix/d$6$1:cQa	Ljava/lang/String;
                    //   41: aastore
                    //   42: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                    //   45: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   48: aload_3
                    //   49: invokevirtual 79	com/tencent/matrix/resource/analyzer/model/a:toString	()Ljava/lang/String;
                    //   52: astore 4
                    //   54: aload_3
                    //   55: getfield 83	com/tencent/matrix/resource/analyzer/model/a:cWT	Z
                    //   58: ifeq +71 -> 129
                    //   61: getstatic 89	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
                    //   64: sipush 18573
                    //   67: bipush 7
                    //   69: anewarray 4	java/lang/Object
                    //   72: dup
                    //   73: iconst_0
                    //   74: aload_0
                    //   75: getfield 30	com/tencent/matrix/d$6$1:cQb	Ljava/lang/String;
                    //   78: aastore
                    //   79: dup
                    //   80: iconst_1
                    //   81: aload 4
                    //   83: aastore
                    //   84: dup
                    //   85: iconst_2
                    //   86: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   89: lload_1
                    //   90: lsub
                    //   91: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   94: aastore
                    //   95: dup
                    //   96: iconst_3
                    //   97: bipush 7
                    //   99: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   102: aastore
                    //   103: dup
                    //   104: iconst_4
                    //   105: aload_0
                    //   106: getfield 32	com/tencent/matrix/d$6$1:cQc	J
                    //   109: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   112: aastore
                    //   113: dup
                    //   114: iconst_5
                    //   115: getstatic 99	com/tencent/mm/sdk/platformtools/BuildInfo:BUILD_TAG	Ljava/lang/String;
                    //   118: aastore
                    //   119: dup
                    //   120: bipush 6
                    //   122: getstatic 102	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
                    //   125: aastore
                    //   126: invokevirtual 106	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
                    //   129: ldc 53
                    //   131: aload 4
                    //   133: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   136: aload_0
                    //   137: getfield 24	com/tencent/matrix/d$6$1:cQd	Lcom/tencent/matrix/d$6;
                    //   140: getfield 110	com/tencent/matrix/d$6:cPW	Ljava/util/HashSet;
                    //   143: astore_3
                    //   144: aload_3
                    //   145: monitorenter
                    //   146: aload_0
                    //   147: getfield 24	com/tencent/matrix/d$6$1:cQd	Lcom/tencent/matrix/d$6;
                    //   150: getfield 110	com/tencent/matrix/d$6:cPW	Ljava/util/HashSet;
                    //   153: aload_0
                    //   154: getfield 30	com/tencent/matrix/d$6$1:cQb	Ljava/lang/String;
                    //   157: invokevirtual 116	java/util/HashSet:add	(Ljava/lang/Object;)Z
                    //   160: pop
                    //   161: aload_3
                    //   162: monitorexit
                    //   163: aload_0
                    //   164: getfield 26	com/tencent/matrix/d$6$1:cPZ	Lcom/tencent/mm/vfs/o;
                    //   167: invokevirtual 122	com/tencent/mm/vfs/o:delete	()Z
                    //   170: pop
                    //   171: return
                    //   172: astore 4
                    //   174: aload_3
                    //   175: monitorexit
                    //   176: aload 4
                    //   178: athrow
                    //   179: astore_3
                    //   180: getstatic 89	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
                    //   183: sipush 18573
                    //   186: bipush 6
                    //   188: anewarray 4	java/lang/Object
                    //   191: dup
                    //   192: iconst_0
                    //   193: aload_0
                    //   194: getfield 30	com/tencent/matrix/d$6$1:cQb	Ljava/lang/String;
                    //   197: aastore
                    //   198: dup
                    //   199: iconst_1
                    //   200: ldc 124
                    //   202: aastore
                    //   203: dup
                    //   204: iconst_2
                    //   205: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   208: lload_1
                    //   209: lsub
                    //   210: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   213: aastore
                    //   214: dup
                    //   215: iconst_3
                    //   216: iconst_3
                    //   217: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   220: aastore
                    //   221: dup
                    //   222: iconst_4
                    //   223: aload_0
                    //   224: getfield 32	com/tencent/matrix/d$6$1:cQc	J
                    //   227: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   230: aastore
                    //   231: dup
                    //   232: iconst_5
                    //   233: getstatic 99	com/tencent/mm/sdk/platformtools/BuildInfo:BUILD_TAG	Ljava/lang/String;
                    //   236: aastore
                    //   237: invokevirtual 106	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
                    //   240: ldc 53
                    //   242: aload_3
                    //   243: invokevirtual 128	java/lang/OutOfMemoryError:getCause	()Ljava/lang/Throwable;
                    //   246: ldc 130
                    //   248: iconst_0
                    //   249: anewarray 4	java/lang/Object
                    //   252: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
                    //   255: aload_0
                    //   256: getfield 26	com/tencent/matrix/d$6$1:cPZ	Lcom/tencent/mm/vfs/o;
                    //   259: invokevirtual 122	com/tencent/mm/vfs/o:delete	()Z
                    //   262: pop
                    //   263: return
                    //   264: astore_3
                    //   265: aload_0
                    //   266: getfield 26	com/tencent/matrix/d$6$1:cPZ	Lcom/tencent/mm/vfs/o;
                    //   269: invokevirtual 122	com/tencent/mm/vfs/o:delete	()Z
                    //   272: pop
                    //   273: aload_3
                    //   274: athrow
                    // Local variable table:
                    //   start	length	slot	name	signature
                    //   0	275	0	this	1
                    //   3	206	1	l	long
                    //   179	64	3	localOutOfMemoryError	java.lang.OutOfMemoryError
                    //   264	10	3	localObject2	Object
                    //   52	80	4	str	String
                    //   172	5	4	localObject3	Object
                    // Exception table:
                    //   from	to	target	type
                    //   146	163	172	finally
                    //   174	176	172	finally
                    //   4	129	179	java/lang/OutOfMemoryError
                    //   129	146	179	java/lang/OutOfMemoryError
                    //   176	179	179	java/lang/OutOfMemoryError
                    //   4	129	264	finally
                    //   129	146	264	finally
                    //   176	179	264	finally
                    //   180	255	264	finally
                  }
                });
                return true;
              }
              if (((com.tencent.mm.vfs.o)???).length() <= 0L)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { paramAnonymousString1, "file is null!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1), BuildInfo.BUILD_TAG });
                Log.e("MatrixDelegate", "file is null!");
                return true;
              }
            }
            return false;
          }
          
          public final boolean H(String paramAnonymousString1, String paramAnonymousString2)
          {
            if (((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rQY, true)) && (this.cPY < 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rQZ, 100000))) || (WeChatEnvironment.hasDebugger())) {}
            for (int i = 1; i == 0; i = 0)
            {
              Log.i("MatrixDelegate", "not report");
              return false;
            }
            Log.i("MatrixDelegate", "[onLeakLite] activity=%s isEnableDump=%s isSilence=%s", new Object[] { paramAnonymousString1, Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) });
            Log.i("MatrixDelegate", "[onLeakLite] Activity dump [%s]", new Object[] { com.tencent.mm.ad.a.aBz() });
            if (!this.cPX.contains(paramAnonymousString2))
            {
              Log.i("MatrixDelegate", "[onLeakLite] Activity report: %s", new Object[] { paramAnonymousString2 });
              com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { paramAnonymousString1, "release report", Integer.valueOf(0), Integer.valueOf(8) });
              this.cPX.add(paramAnonymousString2);
            }
            return true;
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
              if ((!BuildInfo.DEBUG) && (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rRC, false))) {
                break label85;
              }
            }
            label85:
            for (boolean bool = true;; bool = false)
            {
              d.c(paramAnonymousContext, bool);
              Log.i("MatrixDelegate", "[ACTION_SCREEN_OFF] isEnableDump=%s", new Object[] { Boolean.valueOf(d.b(d.this)) });
              return;
            }
          }
        };
      }
      try
      {
        localApplication.getApplicationContext().registerReceiver(local7, paramb);
        this.isInitialized = true;
        if (this.cPK) {
          cy(AppForegroundDelegate.djR.cPB);
        }
        if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_dropframe", true))
        {
          Log.i("MatrixDelegate", "start detecting dropFrame");
          paramb = (com.tencent.matrix.trace.a)b.RG().Y(com.tencent.matrix.trace.a.class);
          if (paramb == null) {
            Log.i("MatrixDelegate", "tracePlugin is null");
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
        paramb = paramb.daF;
        if (paramb == null)
        {
          Log.i("MatrixDelegate", "frameTracer is null");
          return;
        }
        paramb.dco = new com.tencent.matrix.trace.f.c.a()
        {
          public final void a(int paramAnonymousInt, final String paramAnonymousString, final long paramAnonymousLong)
          {
            com.tencent.f.h.RTc.aX(new Runnable()
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
                    Log.i("MatrixDelegate", "happens dropFrames : dropFrame = %d, scene = %s, lastResumeTime = %d, timeAfterResume = %d", new Object[] { Integer.valueOf(paramAnonymousString), this.cPU, Long.valueOf(paramAnonymousLong), Long.valueOf(l1) });
                    if ((l1 <= 2000L) || (!this.cPU.contains("Finder"))) {
                      break;
                    }
                    if (paramAnonymousString < 15)
                    {
                      i = 1;
                      int k = com.tencent.matrix.g.a.bj(MMApplicationContext.getContext()).value;
                      long l2 = Math.min(paramAnonymousString * 16, 2000);
                      Thread.sleep(l2);
                      if ((d.cPI.cPJ == null) || (d.cPI.cPJ.cWw == null)) {
                        break label370;
                      }
                      h.d locald = (h.d)d.cPI.cPJ.cWw.getFirst();
                      if (locald != null)
                      {
                        long l3 = locald.cWe.getLong("time");
                        if (System.currentTimeMillis() - l3 < l2 * 2L)
                        {
                          String str = "";
                          if (j != 0) {
                            str = locald.cWe.toString();
                          }
                          com.tencent.mm.plugin.report.e.Cxv.a(20502, new Object[] { Integer.valueOf(paramAnonymousString), this.cPU, Integer.valueOf(i), Integer.valueOf(k), Long.valueOf(l1), str });
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
                    Log.i("MatrixDelegate", "report dropFrame error = " + localThrowable.getMessage());
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
        paramb.dcp = 9;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d
 * JD-Core Version:    0.7.0.1
 */