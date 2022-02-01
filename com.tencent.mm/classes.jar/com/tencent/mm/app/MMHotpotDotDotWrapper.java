package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.vfs.y;
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
    AppMethodBeat.i(257904);
    this.mProcessInitTimestamp = System.currentTimeMillis();
    this.profile = null;
    this.mApp = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.mCurrentProcessName = paramString;
    AppMethodBeat.o(257904);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(257905);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.mCurrentProcessName, this.mApp, this.mAppLike);
    this.profile.htp.htq = this.mProcessInitTimestamp;
    y.f(this.profile);
    paramContext.getClassLoader();
    j.Ed("stlport_shared");
    paramContext.getClassLoader();
    j.Ed("c++_shared");
    String str = com.tencent.mm.xlog.app.a.Rza;
    paramContext.getClassLoader();
    j.Ed(str);
    this.profile.gmN = d.cg(this.profile.ca);
    this.profile.gmN.CN("HOTPOT..");
    com.tencent.f.g.a(this.profile.ca, new aa());
    com.tencent.mm.splash.a.n(this.mApp);
    com.tencent.mm.bu.a.a.gtp();
    aj.a(this.profile, null);
    AppMethodBeat.o(257905);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(257907);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(257907);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(257906);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(257906);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(257908);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(257908);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(257910);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(257910);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(257909);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(257909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.MMHotpotDotDotWrapper
 * JD-Core Version:    0.7.0.1
 */