package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.booter.aa;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMCleanApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
  private String thisProcess;
  
  public MMCleanApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(224046);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(224046);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(224047);
    com.tencent.mm.sdk.platformtools.b.a(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gGB.gGC = this.processInitTimestamp;
    u.g(this.profile);
    com.tencent.e.g.a(this.profile.ca, new aa());
    com.tencent.mm.splash.a.p(this.app);
    AppForegroundDelegate.cTA.d(this.app);
    DataPackageFrequencyDetect.ywE.d(this.app);
    com.tencent.mm.bu.a.a.fjN();
    ai.a(this.profile, null);
    paramContext = this.app;
    ak.h(com.tencent.mm.cc.b.a(paramContext.getResources(), paramContext, true));
    ab.Y(a.a.class);
    ab.fz("com.tencent.mm.boot");
    AppMethodBeat.o(224047);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(224049);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(224049);
  }
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(224050);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(224050);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(224048);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(224048);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(224051);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(224051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMCleanApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */