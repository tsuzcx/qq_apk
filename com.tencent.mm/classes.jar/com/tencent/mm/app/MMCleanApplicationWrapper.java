package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.o;
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
    AppMethodBeat.i(221136);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(221136);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(221137);
    com.tencent.mm.sdk.platformtools.a.a(paramContext.getApplicationInfo());
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.gDU.gDV = this.processInitTimestamp;
    o.f(this.profile);
    com.tencent.e.g.a(this.profile.ca, new aa());
    com.tencent.mm.splash.a.n(this.app);
    AppForegroundDelegate.cSQ.d(this.app);
    DataPackageFrequencyDetect.ygN.d(this.app);
    com.tencent.mm.bv.a.a.ffX();
    ai.a(this.profile, null);
    paramContext = this.app;
    aj.h(b.a(paramContext.getResources(), paramContext, true));
    ab.Y(a.a.class);
    ab.ft("com.tencent.mm.boot");
    AppMethodBeat.o(221137);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(221139);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(221139);
  }
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(221140);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(221140);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(221138);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(221138);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(221141);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(221141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMCleanApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */