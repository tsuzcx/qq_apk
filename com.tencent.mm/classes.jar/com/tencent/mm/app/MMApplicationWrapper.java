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
import com.tencent.mm.cd.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.compatible.util.j.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.o;
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
    d locald = paramh.fFy;
    if (paramh.akw())
    {
      locald.uc("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":push"))
    {
      locald.uc("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":tools"))
    {
      locald.uc("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":toolsmp"))
    {
      locald.uc("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":sandbox"))
    {
      locald.uc("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":exdevice"))
    {
      locald.uc("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":patch"))
    {
      locald.uc("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":appbrand0"))
    {
      locald.uc("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":appbrand1"))
    {
      locald.uc("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":appbrand2"))
    {
      locald.uc("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":appbrand3"))
    {
      locald.uc("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":appbrand4"))
    {
      locald.uc("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":TMAssistantDownloadSDKService"))
    {
      locald.uc("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":dexopt"))
    {
      locald.uc("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.xf(":extmig")) {
      locald.uc("EXTMIG");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(final Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.gCt = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.gCs = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.a.a(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gDU.gDV = this.processInitTimestamp;
    j.a(new j.b()
    {
      public final boolean Ma()
      {
        AppMethodBeat.i(221135);
        if ((i.hgJ) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          Object localObject1 = paramContext;
          Object localObject2 = new Intent(paramContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756079).putExtra("messageRes", 2131756078).putExtra("buttonRes", 2131756077).putExtra("action", PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/m")).addFlags(268435456), 0));
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(221135);
          return true;
        }
        AppMethodBeat.o(221135);
        return false;
      }
    });
    o.f(this.profile);
    com.tencent.e.g.a(this.profile.ca, new aa());
    boolean bool1 = z.fs(this.thisProcess);
    boolean bool2 = z.fr(this.thisProcess);
    if (!bool1)
    {
      paramContext.getClassLoader();
      j.vr("stlport_shared");
      paramContext.getClassLoader();
      j.vr("c++_shared");
      String str = com.tencent.mm.xlog.app.a.LBF;
      paramContext.getClassLoader();
      j.vr(str);
      this.profile.fFy = d.bJ(this.profile.ca);
      setupXLogDebugger(this.profile);
    }
    com.tencent.mm.splash.a.n(this.app);
    AppForegroundDelegate.cSQ.d(this.app);
    DataPackageFrequencyDetect.ygN.d(this.app);
    com.tencent.mm.bv.a.a.ffX();
    if (!bool2)
    {
      ai.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
      paramContext = this.app;
      aj.h(b.a(paramContext.getResources(), paramContext, bool2));
      com.tencent.mm.cd.a.a(new com.tencent.mm.cd.a.a()
      {
        public final void Mb()
        {
          AppMethodBeat.i(221134);
          com.tencent.mm.bw.a.hH(aj.getContext());
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          System.exit(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          AppMethodBeat.o(221134);
        }
      });
      if (!com.tencent.mm.cd.c.fhZ()) {
        break label339;
      }
      if (!ax.aQz(aj.fkC()).getBoolean("special_dark_mode_set_follow_system", false))
      {
        ax.aQz(aj.fkC()).putBoolean("dark_mode_follow_system", true);
        al.fya();
        ax.aQz(aj.fkC()).putBoolean("special_dark_mode_set_follow_system", true);
      }
    }
    for (;;)
    {
      ab.Y(com.tencent.mm.boot.a.a.class);
      ab.ft("com.tencent.mm.boot");
      AppMethodBeat.o(160078);
      return;
      ad.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      ai.a(this.profile, null);
      break;
      label339:
      if (!ax.aQz(aj.fkC()).getBoolean("dark_mode_set_follow_system", false))
      {
        ax.aQz(aj.fkC()).putBoolean("dark_mode_follow_system", true);
        al.fya();
        ax.aQz(aj.fkC()).putBoolean("dark_mode_set_follow_system", true);
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
    com.tencent.mm.ae.c.g(this.app);
    m.fnG();
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