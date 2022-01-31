package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.booter.c;
import com.tencent.mm.cm.b;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.2;
import com.tencent.mm.kernel.b.h.3;
import com.tencent.mm.kernel.b.h.4;
import com.tencent.mm.kernel.b.h.5;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.splash.n;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  public Application app;
  private final ApplicationLike lifeCycle;
  private h profile = null;
  private String thisProcess = "";
  
  public MMApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    com.tencent.mm.blink.a.l(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
  }
  
  private void setupXLogDebugger(h paramh)
  {
    c localc = paramh.diu;
    if (paramh.Ex()) {
      localc.em("MM");
    }
    do
    {
      return;
      if (paramh.gn(":push"))
      {
        localc.em("PUSH");
        return;
      }
      if (paramh.gn(":tools"))
      {
        localc.em("TOOL");
        return;
      }
      if (paramh.gn(":toolsmp"))
      {
        localc.em("TOOLSMP");
        return;
      }
      if (paramh.gn(":sandbox"))
      {
        localc.em("SANDBOX");
        return;
      }
      if (paramh.gn(":exdevice"))
      {
        localc.em("EXDEVICE");
        return;
      }
      if (paramh.gn(":patch"))
      {
        localc.em("PATCH");
        return;
      }
      if (paramh.gn(":appbrand0"))
      {
        localc.em("APPBRAND0");
        return;
      }
      if (paramh.gn(":appbrand1"))
      {
        localc.em("APPBRAND1");
        return;
      }
      if (paramh.gn(":appbrand2"))
      {
        localc.em("APPBRAND2");
        return;
      }
      if (paramh.gn(":appbrand3"))
      {
        localc.em("APPBRAND3");
        return;
      }
      if (paramh.gn(":appbrand4"))
      {
        localc.em("APPBRAND4");
        return;
      }
      if (paramh.gn(":TMAssistantDownloadSDKService"))
      {
        localc.em("TMSDK");
        return;
      }
    } while (!paramh.gn(":dexopt"));
    localc.em("DEXOPT");
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    com.tencent.mm.kernel.a.a.dLv = SystemClock.elapsedRealtime();
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    o.ta();
    k.b("stlport_shared", paramContext.getClassLoader());
    k.b("c++_shared", paramContext.getClassLoader());
    k.b(com.tencent.mm.xlog.app.a.wDj, paramContext.getClassLoader());
    this.profile.diu = c.aS(this.profile.bT);
    setupXLogDebugger(this.profile);
    com.tencent.mm.splash.a.e(this.app);
    y.v("PreventAccessModification", "profile %s", new Object[] { t.bxn });
    if (!o.cp(this.thisProcess)) {
      t.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
    }
    for (;;)
    {
      p.n(a.a.class);
      p.cq("com.tencent.mm.boot");
      return;
      y.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      t.a(this.profile, null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.profile != null)
    {
      h localh = this.profile;
      localh.dMV.a(new h.5(localh, paramConfiguration));
    }
  }
  
  public void onCreate()
  {
    b.g(this.app);
    n.cto();
  }
  
  public void onLowMemory()
  {
    if (this.profile != null)
    {
      h localh = this.profile;
      localh.dMV.a(new h.2(localh));
    }
  }
  
  public void onTerminate()
  {
    if (this.profile != null)
    {
      h localh = this.profile;
      localh.dMV.a(new h.4(localh));
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.profile != null)
    {
      h localh = this.profile;
      localh.dMV.a(new h.3(localh, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */