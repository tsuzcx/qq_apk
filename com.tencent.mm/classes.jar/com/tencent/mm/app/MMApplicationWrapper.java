package com.tencent.mm.app;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.z;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.ai;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  private byte _hellAccFlag_;
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  public MMApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(160077);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    com.tencent.mm.blink.a.u(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160077);
  }
  
  private void setupXLogDebugger(com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(160079);
    d locald = paramh.fjW;
    if (paramh.agu())
    {
      locald.ok("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":push"))
    {
      locald.ok("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":tools"))
    {
      locald.ok("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":toolsmp"))
    {
      locald.ok("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":sandbox"))
    {
      locald.ok("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":exdevice"))
    {
      locald.ok("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":patch"))
    {
      locald.ok("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":appbrand0"))
    {
      locald.ok("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":appbrand1"))
    {
      locald.ok("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":appbrand2"))
    {
      locald.ok("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":appbrand3"))
    {
      locald.ok("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":appbrand4"))
    {
      locald.ok("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":TMAssistantDownloadSDKService"))
    {
      locald.ok("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":dexopt"))
    {
      locald.ok("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.ra(":extmig")) {
      locald.ok("EXTMIG");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.ged = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.gec = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.a.a(paramContext.getApplicationInfo());
    this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gfE.gfF = this.processInitTimestamp;
    o.f(this.profile);
    com.tencent.e.g.a(this.profile.ca, new z());
    boolean bool1 = y.eH(this.thisProcess);
    boolean bool2 = y.eG(this.thisProcess);
    if (!bool1) {}
    try
    {
      paramContext.getClassLoader();
      j.pq("stlport_shared");
      paramContext.getClassLoader();
      j.pq("c++_shared");
      String str = com.tencent.mm.xlog.app.a.Igx;
      paramContext.getClassLoader();
      j.pq(str);
      this.profile.fjW = d.bH(this.profile.ca);
      setupXLogDebugger(this.profile);
      com.tencent.mm.splash.a.l(this.app);
      localAppForegroundDelegate = AppForegroundDelegate.cKE;
      localApplication = this.app;
      if (localAppForegroundDelegate.csX)
      {
        ad.e("MicroMsg.AppForegroundDelegate", "has init!");
        com.tencent.mm.bv.a.a.eBz();
        if (aj.cbe()) {
          com.tencent.mm.sdcard_migrate.b.ia(this.app);
        }
        if (bool2) {
          break label928;
        }
        ah.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        paramContext = this.app;
        aj.h(com.tencent.mm.ce.b.a(paramContext.getResources(), paramContext, bool2));
        com.tencent.mm.ce.a.a(new com.tencent.mm.ce.a.a()
        {
          public final void KM()
          {
            AppMethodBeat.i(160047);
            com.tencent.mm.bw.a.hr(aj.getContext());
            System.exit(0);
            AppMethodBeat.o(160047);
          }
        });
        if (!ax.aFC(aj.eFD()).getBoolean("dark_mode_set_follow_system", false))
        {
          ax.aFC(aj.eFD()).putBoolean("dark_mode_follow_system", true);
          ai.eSa();
          ax.aFC(aj.eFD()).putBoolean("dark_mode_set_follow_system", true);
        }
        aa.Y(com.tencent.mm.boot.a.a.class);
        aa.eI("com.tencent.mm.boot");
        AppMethodBeat.o(160078);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        AppForegroundDelegate localAppForegroundDelegate;
        Application localApplication;
        if ((com.tencent.mm.sdk.platformtools.h.glZ) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          Object localObject = new Intent(paramContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756079).putExtra("messageRes", 2131756078).putExtra("buttonRes", 2131756077).putExtra("action", PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/m")).addFlags(268435456), 0));
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/app/MMApplicationWrapper", "onBaseContextAttached", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/MMApplicationWrapper", "onBaseContextAttached", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Process.killProcess(Process.myPid());
          continue;
          localAppForegroundDelegate.csX = true;
          paramContext = new HandlerThread("AppForegroundDelegate");
          paramContext.start();
          localAppForegroundDelegate.cKF = new Handler(paramContext.getLooper());
          if (aj.cbe())
          {
            paramContext = new IntentFilter();
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cKN));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cKO));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cKP));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cKQ));
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.SCREEN_ON");
            localApplication.registerReceiver(localAppForegroundDelegate.cKI.cKT, paramContext, "com.tencent.mm.permission.MM_MESSAGE", null);
          }
          for (;;)
          {
            localApplication.registerActivityLifecycleCallbacks(localAppForegroundDelegate.cKI.cKT);
            localApplication.registerComponentCallbacks(localAppForegroundDelegate.cKI.cKT);
            paramContext = new IntentFilter();
            paramContext.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            paramContext.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
            localApplication.registerReceiver(localAppForegroundDelegate.cKI.cKU, paramContext, "com.tencent.mm.permission.MM_MESSAGE", null);
            break;
            if (aj.getProcessName().endsWith(":dexopt")) {
              break;
            }
            Uri localUri = Uri.parse("content://com.tencent.mm.AppForegroundDelegate.Provider/");
            Bundle localBundle = new Bundle();
            localObject = localBundle;
            paramContext = localBundle;
            try
            {
              if (aj.eFN())
              {
                paramContext = localBundle;
                localObject = localApplication.getContentResolver().call(localUri, "isAppForeground", null, null);
                paramContext = (Context)localObject;
                localAppForegroundDelegate.csU = ((Bundle)localObject).getBoolean("isAppForeground");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.AppForegroundDelegate", localException, "isMMProcessExist:%s", new Object[] { Boolean.valueOf(aj.eFN()) });
                Context localContext;
                if (aj.eFH())
                {
                  e.vIY.idkeyStat(1118L, 0L, 1L, true);
                  localContext = paramContext;
                }
                else
                {
                  e.vIY.idkeyStat(1118L, 1L, 1L, true);
                  localContext = paramContext;
                  continue;
                  paramContext = localContext.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
                }
              }
            }
            if (localObject != null) {
              break label916;
            }
            paramContext = "";
            ad.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { aj.getProcessName(), Boolean.valueOf(localAppForegroundDelegate.csU) });
            if (localAppForegroundDelegate.csU) {
              localAppForegroundDelegate.azU.post(new AppForegroundDelegate.1(localAppForegroundDelegate, paramContext));
            }
          }
          label916:
          label928:
          ad.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
          ah.a(this.profile, null);
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(160082);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(160082);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(160080);
    c.e(this.app);
    m.eIA();
    AppMethodBeat.o(160080);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(160083);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(160083);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(160081);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(160081);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(160084);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(160084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */