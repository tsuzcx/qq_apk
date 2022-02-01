package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.splash.n;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.ab;
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
  private com.tencent.mm.kernel.b.h profile;
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
  
  private void setupXLogDebugger(com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(160079);
    d locald = paramh.iQW;
    if (paramh.aIE())
    {
      locald.JC("MM");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":push"))
    {
      locald.JC("PUSH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":tools"))
    {
      locald.JC("TOOL");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":toolsmp"))
    {
      locald.JC("TOOLSMP");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":sandbox"))
    {
      locald.JC("SANDBOX");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":exdevice"))
    {
      locald.JC("EXDEVICE");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":patch"))
    {
      locald.JC("PATCH");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":appbrand0"))
    {
      locald.JC("APPBRAND0");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":appbrand1"))
    {
      locald.JC("APPBRAND1");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":appbrand2"))
    {
      locald.JC("APPBRAND2");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":appbrand3"))
    {
      locald.JC("APPBRAND3");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":appbrand4"))
    {
      locald.JC("APPBRAND4");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":TMAssistantDownloadSDKService"))
    {
      locald.JC("TMSDK");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":dexopt"))
    {
      locald.JC("DEXOPT");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":extmig"))
    {
      locald.JC("EXTMIG");
      AppMethodBeat.o(160079);
      return;
    }
    if (paramh.MY(":hld")) {
      locald.JC("HLD");
    }
    AppMethodBeat.o(160079);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.kdJ = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.kdI = System.currentTimeMillis();
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.kfk.kfl = l.aHO();
    this.profile.kfk.kfm = this.processInitTimestamp;
    ak.init(paramContext);
    j.a(new MMApplicationWrapper.1(this, paramContext));
    ab.h(this.profile);
    com.tencent.e.g.a(this.profile.Zw, new com.tencent.mm.booter.aa());
    boolean bool1 = aa.gV(this.thisProcess);
    boolean bool2 = aa.gU(this.thisProcess);
    if (!bool1)
    {
      paramContext.getClassLoader();
      j.KW("stlport_shared");
      paramContext.getClassLoader();
      j.KW("c++_shared");
      String str = com.tencent.mm.xlog.app.a.ZaI;
      paramContext.getClassLoader();
      j.KW(str);
      this.profile.iQW = d.cc(this.profile.Zw);
      setupXLogDebugger(this.profile);
    }
    com.tencent.mm.splash.a.q(this.app);
    com.tencent.matrix.a.b.c(this.app);
    z.c(this.app);
    AppForegroundDelegate.fby.c(this.app);
    DataPackageFrequencyDetect.IyC.c(this.app);
    com.tencent.mm.cb.a.a.hoB();
    if (!bool2)
    {
      al.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
      paramContext = this.app;
      MMApplicationContext.setResources(com.tencent.mm.cj.b.a(paramContext.getResources(), paramContext, bool2));
      com.tencent.mm.cj.a.a(new MMApplicationWrapper.2(this));
      if (!com.tencent.mm.cj.c.hrB()) {
        break label422;
      }
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("special_dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        ar.hIV();
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("special_dark_mode_set_follow_system", true);
      }
    }
    for (;;)
    {
      ac.ab(R.raw.class);
      ac.setPackageName("com.tencent.mm.boot");
      if (this.thisProcess.endsWith(":hld"))
      {
        ac.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw.getResources());
        com.tencent.mm.plugin.hld.model.g.DCm.gN(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(160078);
      return;
      Log.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      al.a(this.profile, null);
      break;
      label422:
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        ar.hIV();
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
    com.tencent.mm.ag.c.i(this.app);
    n.huz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */