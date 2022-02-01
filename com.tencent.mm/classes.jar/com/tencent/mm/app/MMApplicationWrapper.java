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
import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.cc.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.compatible.util.j.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  public Application app;
  private EasyGo easyGoManager;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
  private String thisProcess;
  
  public MMApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(160077);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.easyGoManager = null;
    com.tencent.mm.blink.a.r(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160077);
  }
  
  private void setupXLogDebugger(h paramh)
  {
    AppMethodBeat.i(160079);
    d locald = paramh.gmN;
    if (paramh.aBb())
    {
      locald.CN("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":push"))
    {
      locald.CN("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":tools"))
    {
      locald.CN("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":toolsmp"))
    {
      locald.CN("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":sandbox"))
    {
      locald.CN("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":exdevice"))
    {
      locald.CN("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":patch"))
    {
      locald.CN("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":appbrand0"))
    {
      locald.CN("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":appbrand1"))
    {
      locald.CN("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":appbrand2"))
    {
      locald.CN("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":appbrand3"))
    {
      locald.CN("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":appbrand4"))
    {
      locald.CN("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":TMAssistantDownloadSDKService"))
    {
      locald.CN("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":dexopt"))
    {
      locald.CN("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.FY(":extmig")) {
      locald.CN("EXTMIG");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(final Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.hrO = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.hrN = System.currentTimeMillis();
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.htp.htq = this.processInitTimestamp;
    ai.init(paramContext);
    j.a(new j.b()
    {
      public final boolean Wt()
      {
        AppMethodBeat.i(257897);
        if ((BuildInfo.IS_ARM64) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          Object localObject1 = paramContext;
          Object localObject2 = new Intent(paramContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756209).putExtra("messageRes", 2131756208).putExtra("buttonRes", 2131756207).putExtra("action", PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://" + WeChatHosts.domainString(2131761749) + "/")).addFlags(268435456), 0));
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(257897);
          return true;
        }
        AppMethodBeat.o(257897);
        return false;
      }
    });
    y.f(this.profile);
    com.tencent.f.g.a(this.profile.ca, new aa());
    boolean bool1 = z.gl(this.thisProcess);
    boolean bool2 = z.gk(this.thisProcess);
    if (!bool1)
    {
      paramContext.getClassLoader();
      j.Ed("stlport_shared");
      paramContext.getClassLoader();
      j.Ed("c++_shared");
      String str = com.tencent.mm.xlog.app.a.Rza;
      paramContext.getClassLoader();
      j.Ed(str);
      this.profile.gmN = d.cg(this.profile.ca);
      setupXLogDebugger(this.profile);
    }
    com.tencent.mm.splash.a.n(this.app);
    AppForegroundDelegate.djR.d(this.app);
    DataPackageFrequencyDetect.CxA.d(this.app);
    com.tencent.mm.bu.a.a.gtp();
    if (!bool2)
    {
      aj.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
      paramContext = this.app;
      MMApplicationContext.setResources(b.a(paramContext.getResources(), paramContext, bool2));
      com.tencent.mm.cc.a.a(new com.tencent.mm.cc.a.a()
      {
        public final void Wu()
        {
          AppMethodBeat.i(257896);
          com.tencent.mm.bv.a.iH(MMApplicationContext.getContext());
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          System.exit(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
          AppMethodBeat.o(257896);
        }
      });
      if (!com.tencent.mm.cc.c.gvD()) {
        break label343;
      }
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("special_dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        ao.gJU();
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("special_dark_mode_set_follow_system", true);
      }
    }
    for (;;)
    {
      ab.ab(com.tencent.mm.boot.a.a.class);
      ab.gm("com.tencent.mm.boot");
      AppMethodBeat.o(160078);
      return;
      Log.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      aj.a(this.profile, null);
      break;
      label343:
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        ao.gJU();
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_set_follow_system", true);
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
    com.tencent.mm.ad.c.g(this.app);
    m.gyz();
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