package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
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
  private final long hhg;
  private final Application hhh;
  private final String hhi;
  private final ApplicationLike mAppLike;
  private h profile;
  
  public MMWeChatBacktraceWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(239032);
    this.hhg = System.currentTimeMillis();
    this.profile = null;
    this.hhh = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.hhi = paramString;
    AppMethodBeat.o(239032);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(239036);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.hhi, this.hhh, this.mAppLike);
    this.profile.mFH.mFJ = this.hhg;
    paramContext.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("stlport_shared");
    paramContext.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("c++_shared");
    String str = a.agYU;
    paramContext.getClassLoader();
    com.tencent.mm.compatible.util.k.DA(str);
    this.profile.lsS = d.cO(this.profile.bGP);
    this.profile.lsS.Ci("BACKTRACE");
    Log.i("MicroMsg.MMWeChatBacktraceWrapper", "Process %s startup", new Object[] { this.profile.mProcessName });
    com.tencent.mm.vfs.k.setContext(paramContext);
    w.f(true, this.profile.mProcessName);
    AppMethodBeat.o(239036);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239043);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(239043);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(239037);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(239037);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(239045);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(239045);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(239054);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(239054);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239049);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(239049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMWeChatBacktraceWrapper
 * JD-Core Version:    0.7.0.1
 */