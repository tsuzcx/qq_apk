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
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.aj;
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
    com.tencent.mm.blink.a.q(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160077);
  }
  
  private void setupXLogDebugger(com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(160079);
    d locald = paramh.fnq;
    if (paramh.ahL())
    {
      locald.rq("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":push"))
    {
      locald.rq("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":tools"))
    {
      locald.rq("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":toolsmp"))
    {
      locald.rq("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":sandbox"))
    {
      locald.rq("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":exdevice"))
    {
      locald.rq("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":patch"))
    {
      locald.rq("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":appbrand0"))
    {
      locald.rq("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":appbrand1"))
    {
      locald.rq("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":appbrand2"))
    {
      locald.rq("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":appbrand3"))
    {
      locald.rq("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":appbrand4"))
    {
      locald.rq("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":TMAssistantDownloadSDKService"))
    {
      locald.rq("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":dexopt"))
    {
      locald.rq("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.up(":extmig")) {
      locald.rq("EXTMIG");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.giJ = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.giI = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.a.a(paramContext.getApplicationInfo());
    this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gkk.gkl = this.processInitTimestamp;
    o.f(this.profile);
    com.tencent.e.g.a(this.profile.ca, new aa());
    boolean bool1 = z.ex(this.thisProcess);
    boolean bool2 = z.ew(this.thisProcess);
    if (!bool1) {}
    try
    {
      paramContext.getClassLoader();
      j.sC("stlport_shared");
      paramContext.getClassLoader();
      j.sC("c++_shared");
      String str = com.tencent.mm.xlog.app.a.JIc;
      paramContext.getClassLoader();
      j.sC(str);
      this.profile.fnq = d.bK(this.profile.ca);
      setupXLogDebugger(this.profile);
      com.tencent.mm.splash.a.l(this.app);
      localAppForegroundDelegate = AppForegroundDelegate.cHM;
      localApplication = this.app;
      if (localAppForegroundDelegate.cqf)
      {
        ac.e("MicroMsg.AppForegroundDelegate", "has init!");
        com.tencent.mm.bu.a.a.eQT();
        if (com.tencent.mm.sdk.platformtools.ai.cin()) {
          com.tencent.mm.sdcard_migrate.b.il(this.app);
        }
        if (bool2) {
          break label934;
        }
        ai.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        paramContext = this.app;
        com.tencent.mm.sdk.platformtools.ai.h(com.tencent.mm.cd.b.a(paramContext.getResources(), paramContext, bool2));
        com.tencent.mm.cd.a.a(new com.tencent.mm.cd.a.a()
        {
          public final void Kx()
          {
            AppMethodBeat.i(160047);
            com.tencent.mm.bv.a.hC(com.tencent.mm.sdk.platformtools.ai.getContext());
            System.exit(0);
            AppMethodBeat.o(160047);
          }
        });
        if (!com.tencent.mm.cd.c.eSG()) {
          break label953;
        }
        if (!aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).getBoolean("special_dark_mode_set_follow_system", false))
        {
          aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).putBoolean("dark_mode_follow_system", true);
          aj.fhK();
          aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).putBoolean("special_dark_mode_set_follow_system", true);
        }
        ab.Y(com.tencent.mm.boot.a.a.class);
        ab.ey("com.tencent.mm.boot");
        AppMethodBeat.o(160078);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        AppForegroundDelegate localAppForegroundDelegate;
        Application localApplication;
        if ((com.tencent.mm.sdk.platformtools.h.gMM) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          Object localObject = new Intent(paramContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756079).putExtra("messageRes", 2131756078).putExtra("buttonRes", 2131756077).putExtra("action", PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/m")).addFlags(268435456), 0));
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/app/MMApplicationWrapper", "onBaseContextAttached", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/MMApplicationWrapper", "onBaseContextAttached", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Process.killProcess(Process.myPid());
          continue;
          localAppForegroundDelegate.cqf = true;
          paramContext = new HandlerThread("AppForegroundDelegate");
          paramContext.start();
          localAppForegroundDelegate.cHN = new Handler(paramContext.getLooper());
          if (com.tencent.mm.sdk.platformtools.ai.cin())
          {
            paramContext = new IntentFilter();
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cHV));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cHW));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cHX));
            paramContext.addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.cHY));
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.SCREEN_ON");
            localApplication.registerReceiver(localAppForegroundDelegate.cHQ.cIb, paramContext, "com.tencent.mm.permission.MM_MESSAGE", null);
          }
          for (;;)
          {
            localApplication.registerActivityLifecycleCallbacks(localAppForegroundDelegate.cHQ.cIb);
            localApplication.registerComponentCallbacks(localAppForegroundDelegate.cHQ.cIb);
            paramContext = new IntentFilter();
            paramContext.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            paramContext.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
            localApplication.registerReceiver(localAppForegroundDelegate.cHQ.cIc, paramContext, "com.tencent.mm.permission.MM_MESSAGE", null);
            break;
            if (com.tencent.mm.sdk.platformtools.ai.getProcessName().endsWith(":dexopt")) {
              break;
            }
            Uri localUri = Uri.parse("content://com.tencent.mm.AppForegroundDelegate.Provider/");
            Bundle localBundle = new Bundle();
            localObject = localBundle;
            paramContext = localBundle;
            try
            {
              if (com.tencent.mm.sdk.platformtools.ai.eVi())
              {
                paramContext = localBundle;
                localObject = localApplication.getContentResolver().call(localUri, "isAppForeground", null, null);
                paramContext = (Context)localObject;
                localAppForegroundDelegate.cqc = ((Bundle)localObject).getBoolean("isAppForeground");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.AppForegroundDelegate", localException, "isMMProcessExist:%s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.ai.eVi()) });
                Context localContext;
                if (com.tencent.mm.sdk.platformtools.ai.eVb())
                {
                  e.wTc.idkeyStat(1118L, 0L, 1L, true);
                  localContext = paramContext;
                }
                else
                {
                  e.wTc.idkeyStat(1118L, 1L, 1L, true);
                  localContext = paramContext;
                  continue;
                  paramContext = localContext.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
                }
              }
            }
            if (localObject != null) {
              break label922;
            }
            paramContext = "";
            ac.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { com.tencent.mm.sdk.platformtools.ai.getProcessName(), Boolean.valueOf(localAppForegroundDelegate.cqc) });
            if (localAppForegroundDelegate.cqc) {
              localAppForegroundDelegate.aAO.post(new AppForegroundDelegate.1(localAppForegroundDelegate, paramContext));
            }
          }
          label922:
          label934:
          ac.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
          ai.a(this.profile, null);
          continue;
          label953:
          if (!aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).getBoolean("dark_mode_set_follow_system", false))
          {
            aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).putBoolean("dark_mode_follow_system", true);
            aj.fhK();
            aw.aKT(com.tencent.mm.sdk.platformtools.ai.eUX()).putBoolean("dark_mode_set_follow_system", true);
          }
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
    com.tencent.mm.ad.c.e(this.app);
    m.eXW();
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