package com.tencent.mm.app;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
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
  
  private void setupXLogDebugger(h paramh)
  {
    AppMethodBeat.i(160079);
    d locald = paramh.fHC;
    if (paramh.akL())
    {
      locald.ux("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":push"))
    {
      locald.ux("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":tools"))
    {
      locald.ux("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":toolsmp"))
    {
      locald.ux("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":sandbox"))
    {
      locald.ux("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":exdevice"))
    {
      locald.ux("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":patch"))
    {
      locald.ux("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":appbrand0"))
    {
      locald.ux("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":appbrand1"))
    {
      locald.ux("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":appbrand2"))
    {
      locald.ux("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":appbrand3"))
    {
      locald.ux("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":appbrand4"))
    {
      locald.ux("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":TMAssistantDownloadSDKService"))
    {
      locald.ux("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":dexopt"))
    {
      locald.ux("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xO(":extmig")) {
      locald.ux("EXTMIG");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(final Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.gFa = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.gEZ = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.b.a(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gGB.gGC = this.processInitTimestamp;
    com.tencent.mm.compatible.util.j.a(new j.b()
    {
      public final boolean Mi()
      {
        AppMethodBeat.i(224045);
        if ((com.tencent.mm.sdk.platformtools.j.hjx) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          Object localObject1 = paramContext;
          Object localObject2 = new Intent(paramContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756079).putExtra("messageRes", 2131756078).putExtra("buttonRes", 2131756077).putExtra("action", PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/m")).addFlags(268435456), 0));
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(224045);
          return true;
        }
        AppMethodBeat.o(224045);
        return false;
      }
    });
    u.g(this.profile);
    com.tencent.e.g.a(this.profile.ca, new aa());
    boolean bool1 = z.fy(this.thisProcess);
    boolean bool2 = z.fx(this.thisProcess);
    if (!bool1)
    {
      paramContext.getClassLoader();
      com.tencent.mm.compatible.util.j.vN("stlport_shared");
      paramContext.getClassLoader();
      com.tencent.mm.compatible.util.j.vN("c++_shared");
      String str = com.tencent.mm.xlog.app.a.LYI;
      paramContext.getClassLoader();
      com.tencent.mm.compatible.util.j.vN(str);
      this.profile.fHC = d.bL(this.profile.ca);
      setupXLogDebugger(this.profile);
    }
    com.tencent.mm.splash.a.p(this.app);
    AppForegroundDelegate.cTA.d(this.app);
    DataPackageFrequencyDetect.ywE.d(this.app);
    com.tencent.mm.bu.a.a.fjN();
    if (!bool2)
    {
      ai.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
      paramContext = this.app;
      ak.h(com.tencent.mm.cc.b.a(paramContext.getResources(), paramContext, bool2));
      com.tencent.mm.cc.a.a(new com.tencent.mm.cc.a.a()
      {
        public final void Mj()
        {
          AppMethodBeat.i(224044);
          com.tencent.mm.bv.a.hN(ak.getContext());
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          System.exit(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          AppMethodBeat.o(224044);
        }
      });
      if (!com.tencent.mm.cc.c.flR()) {
        break label339;
      }
      if (!ay.aRW(ak.fow()).getBoolean("special_dark_mode_set_follow_system", false))
      {
        ay.aRW(ak.fow()).putBoolean("dark_mode_follow_system", true);
        al.fCc();
        ay.aRW(ak.fow()).putBoolean("special_dark_mode_set_follow_system", true);
      }
    }
    for (;;)
    {
      ab.Y(com.tencent.mm.boot.a.a.class);
      ab.fz("com.tencent.mm.boot");
      AppMethodBeat.o(160078);
      return;
      ae.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      ai.a(this.profile, null);
      break;
      label339:
      if (!ay.aRW(ak.fow()).getBoolean("dark_mode_set_follow_system", false))
      {
        ay.aRW(ak.fow()).putBoolean("dark_mode_follow_system", true);
        al.fCc();
        ay.aRW(ak.fow()).putBoolean("dark_mode_set_follow_system", true);
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
    com.tencent.mm.ad.c.h(this.app);
    m.frz();
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