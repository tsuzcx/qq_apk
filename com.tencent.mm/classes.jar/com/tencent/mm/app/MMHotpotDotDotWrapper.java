package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.mm.xlog.app.a;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMHotpotDotDotWrapper
  implements ApplicationLifeCycle
{
  private final long hhg;
  private final Application hhh;
  private final String hhi;
  private final ApplicationLike mAppLike;
  private h profile;
  
  public MMHotpotDotDotWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(239099);
    this.hhg = System.currentTimeMillis();
    this.profile = null;
    this.hhh = paramApplicationLike.getApplication();
    this.mAppLike = paramApplicationLike;
    this.hhi = paramString;
    AppMethodBeat.o(239099);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(239105);
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new h(this.hhi, this.hhh, this.mAppLike);
    this.profile.mFH.mFJ = this.hhg;
    af.i(this.profile);
    paramContext.getClassLoader();
    k.DA("stlport_shared");
    paramContext.getClassLoader();
    k.DA("c++_shared");
    String str = a.agYU;
    paramContext.getClassLoader();
    k.DA(str);
    this.profile.lsS = d.cO(this.profile.bGP);
    this.profile.lsS.Ci("HOTPOT..");
    Log.i("MicroMsg.MMHotpotDotDotWrapper", "Process %s startup", new Object[] { this.profile.mProcessName });
    com.tencent.threadpool.g.a(this.profile.bGP, new aa());
    w.f(true, this.profile.mProcessName);
    AppMethodBeat.o(239105);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239116);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(239116);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(239109);
    if (this.profile != null) {
      this.profile.onCreate();
    }
    AppMethodBeat.o(239109);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(239119);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(239119);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(239128);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(239128);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239124);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(239124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMHotpotDotDotWrapper
 * JD-Core Version:    0.7.0.1
 */