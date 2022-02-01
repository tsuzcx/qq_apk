package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
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
    AppMethodBeat.i(257898);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(257898);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(257899);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.htp.htq = this.processInitTimestamp;
    y.f(this.profile);
    com.tencent.f.g.a(this.profile.ca, new aa());
    com.tencent.mm.splash.a.n(this.app);
    AppForegroundDelegate.djR.d(this.app);
    DataPackageFrequencyDetect.CxA.d(this.app);
    com.tencent.mm.bu.a.a.gtp();
    aj.a(this.profile, null);
    paramContext = this.app;
    MMApplicationContext.setResources(b.a(paramContext.getResources(), paramContext, true));
    ab.ab(a.a.class);
    ab.gm("com.tencent.mm.boot");
    ai.init(this.app);
    AppMethodBeat.o(257899);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(257901);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(257901);
  }
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(257902);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(257902);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(257900);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(257900);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(257903);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(257903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.MMCleanApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */