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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.xlog.app.a;
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
    AppMethodBeat.i(186136);
    this.mProcessInitTimestamp = System.currentTimeMillis();
    this.profile = null;
    this.mApp = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.mCurrentProcessName = paramString;
    AppMethodBeat.o(186136);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(186138);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.mCurrentProcessName, this.mApp, this.mAppLike);
    this.profile.kfk.kfm = this.mProcessInitTimestamp;
    ab.h(this.profile);
    paramContext.getClassLoader();
    j.KW("stlport_shared");
    paramContext.getClassLoader();
    j.KW("c++_shared");
    String str = a.ZaI;
    paramContext.getClassLoader();
    j.KW(str);
    this.profile.iQW = d.cc(this.profile.Zw);
    this.profile.iQW.JC("HOTPOT..");
    Log.i("MicroMsg.MMHotpotDotDotWrapper", "Process %s startup", new Object[] { this.profile.mProcessName });
    com.tencent.e.g.a(this.profile.Zw, new aa());
    t.f(true, this.profile.mProcessName);
    AppMethodBeat.o(186138);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186159);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(186159);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(186140);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(186140);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(186161);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(186161);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(186165);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(186165);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(186163);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(186163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMHotpotDotDotWrapper
 * JD-Core Version:    0.7.0.1
 */