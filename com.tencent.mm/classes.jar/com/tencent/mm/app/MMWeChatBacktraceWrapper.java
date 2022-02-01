package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xlog.app.a;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMWeChatBacktraceWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMWeChatBacktraceWrapper";
  private final Application mApp;
  private final ApplicationLike mAppLike;
  private final String mCurrentProcessName;
  private final long mProcessInitTimestamp;
  private h profile;
  
  public MMWeChatBacktraceWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(186135);
    this.mProcessInitTimestamp = System.currentTimeMillis();
    this.profile = null;
    this.mApp = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.mCurrentProcessName = paramString;
    AppMethodBeat.o(186135);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(186141);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.mCurrentProcessName, this.mApp, this.mAppLike);
    this.profile.kfk.kfm = this.mProcessInitTimestamp;
    paramContext.getClassLoader();
    j.KW("stlport_shared");
    paramContext.getClassLoader();
    j.KW("c++_shared");
    String str = a.ZaI;
    paramContext.getClassLoader();
    j.KW(str);
    this.profile.iQW = d.cc(this.profile.Zw);
    this.profile.iQW.JC("BACKTRACE");
    Log.i("MicroMsg.MMWeChatBacktraceWrapper", "Process %s startup", new Object[] { this.profile.mProcessName });
    t.f(true, this.profile.mProcessName);
    AppMethodBeat.o(186141);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186146);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(186146);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(186143);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(186143);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(186150);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(186150);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(186156);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(186156);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(186154);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(186154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMWeChatBacktraceWrapper
 * JD-Core Version:    0.7.0.1
 */