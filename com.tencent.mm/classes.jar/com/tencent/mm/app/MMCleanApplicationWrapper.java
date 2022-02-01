package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cj.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ab;
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
    AppMethodBeat.i(186133);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(186133);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(186134);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.kfk.kfm = this.processInitTimestamp;
    ab.h(this.profile);
    com.tencent.e.g.a(this.profile.Zw, new aa());
    com.tencent.mm.splash.a.q(this.app);
    AppForegroundDelegate.fby.c(this.app);
    DataPackageFrequencyDetect.IyC.c(this.app);
    com.tencent.mm.cb.a.a.hoB();
    al.a(this.profile, null);
    paramContext = this.app;
    MMApplicationContext.setResources(b.a(paramContext.getResources(), paramContext, true));
    ac.ab(R.raw.class);
    ac.setPackageName("com.tencent.mm.boot");
    ak.init(this.app);
    AppMethodBeat.o(186134);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186149);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(186149);
  }
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(186153);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(186153);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(186142);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(186142);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(186155);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(186155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMCleanApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */