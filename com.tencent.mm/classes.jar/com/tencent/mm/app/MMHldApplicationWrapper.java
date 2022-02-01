package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.booter.aa;
import com.tencent.mm.crash.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ah;
import kotlin.g.b.s;

public class MMHldApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMHldApplicationWrapper";
  private String PROCESS_NAME;
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  public MMHldApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(239085);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.PROCESS_NAME = MMApplicationContext.getProcessName();
    com.tencent.mm.blink.a.O(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(239085);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(239097);
    Log.i("MicroMsg.MMHldApplicationWrapper", "onBaseContextAttached processInitTimestamp:%s", new Object[] { Long.valueOf(this.processInitTimestamp) });
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.hld.model.a.b localb = com.tencent.mm.plugin.hld.model.a.b.JwG;
    com.tencent.mm.plugin.hld.model.a.b.JwH = System.currentTimeMillis();
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null) {}
    for (localObject = null;; localObject = null)
    {
      if (localObject == null) {
        Log.e("WxIme.ImeRecovery", "get last crash info is null");
      }
      Log.i("WxIme.ImeRecovery", s.X("startMonitor ", Long.valueOf(com.tencent.mm.plugin.hld.model.a.b.JwH)));
      if (MMApplicationContext.isImeProcess())
      {
        com.tencent.mm.crash.b.a((b.b)localb);
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)localb);
      }
      com.tencent.mm.kernel.a.a.mDT = SystemClock.elapsedRealtime();
      com.tencent.mm.kernel.a.a.mDS = System.currentTimeMillis();
      this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
      this.profile.mFH.mFJ = this.processInitTimestamp;
      Log.d("MicroMsg.MMHldApplicationWrapper", "profile:%s %s %s", new Object[] { this.profile, this.profile.mFH, Long.valueOf(this.processInitTimestamp) });
      com.tencent.mm.vfs.k.setContext(this.profile.bGP);
      com.tencent.mm.vfs.af.i(this.profile);
      com.tencent.mm.vfs.af.j(this.profile);
      com.tencent.threadpool.g.a(this.profile.bGP, new aa());
      localObject = com.tencent.mm.xlog.app.a.agYU;
      paramContext.getClassLoader();
      com.tencent.mm.compatible.util.k.DA((String)localObject);
      this.profile.lsS = com.tencent.mm.booter.d.cO(this.profile.bGP);
      this.profile.lsS.Ci("HLD");
      com.tencent.mm.splash.a.r(this.app);
      AppForegroundDelegate.heY.c(this.app);
      com.tencent.mm.bu.a.a.iPx();
      ap.a(this.profile, null);
      com.tencent.mm.kernel.h.a(this.profile);
      com.tencent.mm.kernel.a.c.baR().baS();
      MMApplicationContext.setResources(com.tencent.mm.ce.d.a(this.app.getResources(), this.app, false));
      af.at(R.raw.class);
      af.setPackageName("com.tencent.mm.boot");
      af.a(this.app, this.app.getResources());
      af.aCS();
      com.tencent.mm.plugin.hld.model.g.JuL.ih(MMApplicationContext.getContext());
      paramContext = new ArrayList();
      paramContext.add("com.tencent.mm.plugin.hook.PluginHook");
      paramContext.add("com.tencent.mm.plugin.expt.PluginExpt");
      paramContext.add("com.tencent.mm.sensitive.PluginSensitive");
      paramContext.add("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
      paramContext.add("com.tencent.mm.plugin.hld.PluginHld");
      paramContext.add("com.tencent.mm.plugin.secdata.PluginSecData");
      paramContext.add("com.tencent.mm.plugin.report.PluginReport");
      paramContext.add("com.tencent.mm.plugin.sensitive_api_check.Plugin");
      paramContext.add("com.tencent.mm.plugin.zero.PluginZero");
      paramContext.add("com.tencent.mm.plugin.performance.PluginPerformance");
      paramContext.add("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        localObject = com.tencent.mm.kernel.h.baA().Fx((String)localObject);
        if (localObject != null)
        {
          ((f)localObject).configure(com.tencent.mm.kernel.h.baB().bad());
          ((f)localObject).execute(com.tencent.mm.kernel.h.baB().bad());
        }
      }
      localObject = ((MultiProcessMMKV)localObject).getString("ime_recovery_last_crash_info", "");
      if (localObject != null) {
        break;
      }
    }
    List localList;
    int i;
    if (!Util.isNullOrNil((String)localObject))
    {
      localList = kotlin.n.n.a((CharSequence)localObject, new String[] { "_" });
      if (localList.size() != 2) {
        break label695;
      }
      i = 1;
      label604:
      if (i == 0) {
        break label700;
      }
    }
    label695:
    label700:
    for (localObject = localList;; localObject = null)
    {
      if (localObject != null)
      {
        com.tencent.mm.plugin.hld.model.a.b.JwK = Util.safeParseLong((String)localList.get(0));
        com.tencent.mm.plugin.hld.model.a.b.JwL = Util.safeParseLong((String)localList.get(1));
        Log.i("WxIme.ImeRecovery", "initRecovery lastCrashTime:" + com.tencent.mm.plugin.hld.model.a.b.JwK + " lastCrashNum:" + com.tencent.mm.plugin.hld.model.a.b.JwL);
      }
      localObject = ah.aiuX;
      break;
      i = 0;
      break label604;
    }
    paramContext = o.Jwm;
    o.aIs(MMApplicationContext.getContext().getPackageName());
    paramContext = o.Jwm;
    o.init();
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    w.f(false, this.PROCESS_NAME);
    Log.setConsoleLogOpen(true);
    e.eMg = Util.getProcessNameByPid(this.app, Process.myPid());
    NativeCrash.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("wechatcrash");
    com.tencent.mm.crash.b.aTa();
    MMHldApplicationWrapper.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("wechatcommon");
    com.tencent.mm.compatible.util.k.DA("wechatbase");
    com.tencent.mm.compatible.util.k.DA("wechatmm");
    Log.i("MicroMsg.MMHldApplicationWrapper", "onBaseContextAttached end %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(239097);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239108);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    Resources localResources = MMApplicationContext.getResources();
    if ((localResources instanceof com.tencent.mm.ce.d)) {
      ((com.tencent.mm.ce.d)localResources).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(239108);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(239100);
    Log.i("MicroMsg.MMHldApplicationWrapper", "onCreate");
    com.tencent.mm.ag.c.i(this.app);
    com.tencent.mm.splash.n.iWb();
    AppMethodBeat.o(239100);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(239115);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(239115);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(239104);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(239104);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239118);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(239118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMHldApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */