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
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.crash.a.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ab;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    AppMethodBeat.i(186139);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.PROCESS_NAME = MMApplicationContext.getProcessName();
    com.tencent.mm.blink.a.r(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(186139);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(186145);
    Log.i("MicroMsg.MMHldApplicationWrapper", "onBaseContextAttached processInitTimestamp:%s", new Object[] { Long.valueOf(this.processInitTimestamp) });
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.hld.model.a.b localb = com.tencent.mm.plugin.hld.model.a.b.DFe;
    com.tencent.mm.plugin.hld.model.a.b.DEZ = System.currentTimeMillis();
    Object localObject = l.DHK;
    localObject = l.getKV();
    int i;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).getString("ime_recovery_last_crash_info", "");
      if (localObject != null) {
        if (!Util.isNullOrNil((String)localObject))
        {
          kotlin.g.b.p.j(localObject, "it");
          List localList = kotlin.n.n.a((CharSequence)localObject, new String[] { "_" });
          if (localList.size() != 2) {
            break label668;
          }
          i = 1;
          if (i == 0) {
            break label673;
          }
          localObject = localList;
          label127:
          if (localObject != null)
          {
            com.tencent.mm.plugin.hld.model.a.b.DFc = Util.safeParseLong((String)localList.get(0));
            com.tencent.mm.plugin.hld.model.a.b.DFd = Util.safeParseLong((String)localList.get(1));
            Log.i("WxIme.ImeRecovery", "initRecovery lastCrashTime:" + com.tencent.mm.plugin.hld.model.a.b.DFc + " lastCrashNum:" + com.tencent.mm.plugin.hld.model.a.b.DFd);
          }
        }
      }
    }
    for (;;)
    {
      Log.i("WxIme.ImeRecovery", "startMonitor " + com.tencent.mm.plugin.hld.model.a.b.DEZ);
      if (MMApplicationContext.isImeProcess())
      {
        com.tencent.mm.crash.a.a((a.b)localb);
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)localb);
      }
      com.tencent.mm.kernel.a.a.kdJ = SystemClock.elapsedRealtime();
      com.tencent.mm.kernel.a.a.kdI = System.currentTimeMillis();
      this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
      this.profile.kfk.kfm = this.processInitTimestamp;
      Log.d("MicroMsg.MMHldApplicationWrapper", "profile:%s %s %s", new Object[] { this.profile, this.profile.kfk, Long.valueOf(this.processInitTimestamp) });
      com.tencent.mm.vfs.h.setContext(this.profile.Zw);
      ab.h(this.profile);
      ab.i(this.profile);
      com.tencent.e.g.a(this.profile.Zw, new aa());
      localObject = com.tencent.mm.xlog.app.a.ZaI;
      paramContext.getClassLoader();
      j.KW((String)localObject);
      this.profile.iQW = com.tencent.mm.booter.d.cc(this.profile.Zw);
      this.profile.iQW.JC("HLD");
      com.tencent.mm.splash.a.q(this.app);
      AppForegroundDelegate.fby.c(this.app);
      com.tencent.mm.cb.a.a.hoB();
      al.a(this.profile, null);
      com.tencent.mm.kernel.h.a(this.profile);
      com.tencent.mm.kernel.a.c.aHV().aHW();
      MMApplicationContext.setResources(com.tencent.mm.cj.b.a(this.app.getResources(), this.app, false));
      ac.ab(R.raw.class);
      ac.setPackageName("com.tencent.mm.boot");
      ac.a(this.app, this.app.getResources());
      ac.abg();
      com.tencent.mm.plugin.hld.model.g.DCm.gN(MMApplicationContext.getContext());
      paramContext = new ArrayList();
      paramContext.add("com.tencent.mm.plugin.hook.PluginHook");
      paramContext.add("com.tencent.mm.plugin.expt.PluginExpt");
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
        localObject = com.tencent.mm.kernel.h.aHC().MO((String)localObject);
        if (localObject != null)
        {
          ((f)localObject).configure(com.tencent.mm.kernel.h.aHD().aHf());
          ((f)localObject).execute(com.tencent.mm.kernel.h.aHD().aHf());
        }
      }
      label668:
      i = 0;
      break;
      label673:
      localObject = null;
      break label127;
      Log.e("WxIme.ImeRecovery", "get last crash info is null");
    }
    paramContext = com.tencent.mm.plugin.hld.model.p.DEH;
    com.tencent.mm.plugin.hld.model.p.aLA(MMApplicationContext.getContext().getPackageName());
    paramContext = com.tencent.mm.plugin.hld.model.p.DEH;
    com.tencent.mm.plugin.hld.model.p.init();
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    t.f(false, this.PROCESS_NAME);
    Log.setConsoleLogOpen(true);
    d.cQP = Util.getProcessNameByPid(this.app, Process.myPid());
    NativeCrash.class.getClassLoader();
    j.KW("wechatcrash");
    com.tencent.mm.crash.a.ayx();
    MMHldApplicationWrapper.class.getClassLoader();
    j.KW("wechatcommon");
    j.KW("wechatbase");
    j.KW("wechatmm");
    Log.i("MicroMsg.MMHldApplicationWrapper", "onBaseContextAttached end %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(186145);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186157);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    Resources localResources = MMApplicationContext.getResources();
    if ((localResources instanceof com.tencent.mm.cj.b)) {
      ((com.tencent.mm.cj.b)localResources).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(186157);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(186148);
    Log.i("MicroMsg.MMHldApplicationWrapper", "onCreate");
    com.tencent.mm.ag.c.i(this.app);
    com.tencent.mm.splash.n.huz();
    AppMethodBeat.o(186148);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(186164);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(186164);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(186152);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(186152);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(186167);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(186167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMHldApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */