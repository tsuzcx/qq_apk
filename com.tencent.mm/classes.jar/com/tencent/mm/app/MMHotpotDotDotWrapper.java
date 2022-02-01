package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.b;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMHotpotDotDotWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMHotpotDotDotWrapper";
  private final Application mApp;
  private final ApplicationLike mAppLike;
  private final String mCurrentProcessName;
  private final long mProcessInitTimestamp;
  private h profile;
  
  public MMHotpotDotDotWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(224059);
    this.mProcessInitTimestamp = System.currentTimeMillis();
    this.profile = null;
    this.mApp = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.mCurrentProcessName = paramString;
    AppMethodBeat.o(224059);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(224060);
    b.a(paramContext.getApplicationInfo());
    this.profile = new h(this.mCurrentProcessName, this.mApp, this.mAppLike);
    this.profile.gGB.gGC = this.mProcessInitTimestamp;
    u.g(this.profile);
    paramContext.getClassLoader();
    j.vN("stlport_shared");
    paramContext.getClassLoader();
    j.vN("c++_shared");
    String str = com.tencent.mm.xlog.app.a.LYI;
    paramContext.getClassLoader();
    j.vN(str);
    this.profile.fHC = d.bL(this.profile.ca);
    this.profile.fHC.ux("HOTPOT..");
    com.tencent.e.g.a(this.profile.ca, new aa());
    com.tencent.mm.splash.a.p(this.mApp);
    com.tencent.mm.bu.a.a.fjN();
    ai.a(this.profile, null);
    AppMethodBeat.o(224060);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(224062);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(224062);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(224061);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(224061);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(224063);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(224063);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(224065);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(224065);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(224064);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(224064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMHotpotDotDotWrapper
 * JD-Core Version:    0.7.0.1
 */