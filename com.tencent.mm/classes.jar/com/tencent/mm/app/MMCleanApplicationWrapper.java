package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.booter.aa;
import com.tencent.mm.ce.d;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMCleanApplicationWrapper
  implements ApplicationLifeCycle
{
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
  private String thisProcess;
  
  public MMCleanApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(239303);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(239303);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(239311);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.mFH.mFJ = this.processInitTimestamp;
    com.tencent.mm.vfs.af.i(this.profile);
    com.tencent.threadpool.g.a(this.profile.bGP, new aa());
    com.tencent.mm.splash.a.r(this.app);
    AppForegroundDelegate.heY.c(this.app);
    DataPackageFrequencyDetect.Ozf.c(this.app);
    com.tencent.mm.bu.a.a.iPx();
    ap.a(this.profile, null);
    paramContext = this.app;
    MMApplicationContext.setResources(d.a(paramContext.getResources(), paramContext, true));
    af.at(R.raw.class);
    af.setPackageName("com.tencent.mm.boot");
    ao.init(this.app);
    AppMethodBeat.o(239311);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239318);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(239318);
  }
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(239320);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(239320);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(239315);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(239315);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239323);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(239323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMCleanApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */