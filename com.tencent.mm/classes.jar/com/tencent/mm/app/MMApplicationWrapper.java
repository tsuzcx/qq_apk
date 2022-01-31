package com.tencent.mm.app;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.booter.d;
import com.tencent.mm.cc.b;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.m;
import com.tencent.mm.vfs.FileSystemManager;
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
    AppMethodBeat.i(137959);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    com.tencent.mm.blink.a.s(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(137959);
  }
  
  private void setupXLogDebugger(h paramh)
  {
    AppMethodBeat.i(137961);
    d locald = paramh.dZN;
    if (paramh.SD())
    {
      locald.kt("MM");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":push"))
    {
      locald.kt("PUSH");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":tools"))
    {
      locald.kt("TOOL");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":toolsmp"))
    {
      locald.kt("TOOLSMP");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":sandbox"))
    {
      locald.kt("SANDBOX");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":exdevice"))
    {
      locald.kt("EXDEVICE");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":patch"))
    {
      locald.kt("PATCH");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":appbrand0"))
    {
      locald.kt("APPBRAND0");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":appbrand1"))
    {
      locald.kt("APPBRAND1");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":appbrand2"))
    {
      locald.kt("APPBRAND2");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":appbrand3"))
    {
      locald.kt("APPBRAND3");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":appbrand4"))
    {
      locald.kt("APPBRAND4");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":TMAssistantDownloadSDKService"))
    {
      locald.kt("TMSDK");
      AppMethodBeat.o(137961);
      return;
    }
    if (paramh.mI(":dexopt")) {
      locald.kt("DEXOPT");
    }
    AppMethodBeat.o(137961);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(137960);
    com.tencent.mm.kernel.a.a.eIU = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.eIT = System.currentTimeMillis();
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.eKw.eKx = this.processInitTimestamp;
    FileSystemManager.setContext(this.profile.bX);
    r.Bx();
    k.a("stlport_shared", paramContext.getClassLoader());
    k.a("c++_shared", paramContext.getClassLoader());
    k.a(com.tencent.mm.xlog.app.a.AZA, paramContext.getClassLoader());
    this.profile.dZN = d.bt(this.profile.bX);
    setupXLogDebugger(this.profile);
    com.tencent.mm.splash.a.i(this.app);
    paramContext = AppForegroundDelegate.bXk;
    Application localApplication = this.app;
    if (paramContext.bRB)
    {
      ab.e("MicroMsg.AppForegroundDelegate", "has init!");
      com.tencent.mm.bt.a.a.dqi();
      if (r.dB(this.thisProcess)) {
        break label478;
      }
      z.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
    }
    for (;;)
    {
      paramContext = this.app;
      ah.h(b.a(paramContext.getResources(), paramContext));
      com.tencent.mm.cc.a.a(new com.tencent.mm.cc.a.a()
      {
        public final void Bl()
        {
          AppMethodBeat.i(154190);
          com.tencent.mm.bu.a.ge(ah.getContext());
          System.exit(0);
          AppMethodBeat.o(154190);
        }
      });
      s.A(com.tencent.mm.boot.a.a.class);
      s.dC("com.tencent.mm.boot");
      AppMethodBeat.o(137960);
      return;
      paramContext.bRB = true;
      Object localObject;
      if (ah.dsT())
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.bXs));
        ((IntentFilter)localObject).addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.bXt));
        ((IntentFilter)localObject).addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.bXu));
        ((IntentFilter)localObject).addAction(AppForegroundDelegate.a.a(AppForegroundDelegate.a.bXv));
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
        localApplication.registerReceiver(paramContext.bXm.bXy, (IntentFilter)localObject, "com.tencent.mm.permission.MM_MESSAGE", null);
      }
      for (;;)
      {
        localApplication.registerActivityLifecycleCallbacks(paramContext.bXm.bXy);
        localApplication.registerComponentCallbacks(paramContext.bXm.bXy);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
        ((IntentFilter)localObject).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
        localApplication.registerReceiver(paramContext.bXm.bXz, (IntentFilter)localObject, "com.tencent.mm.permission.MM_MESSAGE", null);
        break;
        if (ah.getProcessName().endsWith(":dexopt")) {
          break;
        }
        localObject = Uri.parse("content://com.tencent.mm.AppForegroundDelegate.Provider/");
        localObject = localApplication.getContentResolver().call((Uri)localObject, "isAppForeground", null, null);
        paramContext.bLR = ((Bundle)localObject).getBoolean("isAppForeground");
        localObject = ((Bundle)localObject).getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
        ab.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { ah.getProcessName(), Boolean.valueOf(paramContext.bLR) });
        if (paramContext.bLR) {
          paramContext.bTu.post(new AppForegroundDelegate.1(paramContext, (String)localObject));
        }
      }
      label478:
      ab.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      z.a(this.profile, null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(137964);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(137964);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(137962);
    c.c(this.app);
    m.dvK();
    AppMethodBeat.o(137962);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(137965);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(137965);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(137963);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(137963);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(137966);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(137966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */