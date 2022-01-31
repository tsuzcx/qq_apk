package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.splash.m;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMIsolatedApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMIsolatedApplicationWrapper";
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
  private String thisProcess;
  
  public MMIsolatedApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(154191);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    com.tencent.mm.blink.a.s(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(154191);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(154192);
    com.tencent.mm.kernel.a.a.eIU = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.eIT = System.currentTimeMillis();
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.eKw.eKx = this.processInitTimestamp;
    FileSystemManager.setContext(this.profile.bX);
    k.a("stlport_shared", paramContext.getClassLoader());
    k.a("c++_shared", paramContext.getClassLoader());
    QbSdk.setSandboxListener(new MMIsolatedApplicationWrapper.1(this));
    com.tencent.mm.splash.a.i(this.app);
    com.tencent.mm.bt.a.a.dqi();
    ab.i("MicroMsg.MMIsolatedApplicationWrapper", "is plain process. load nothing");
    z.a(this.profile, null);
    s.A(a.a.class);
    s.dC("com.tencent.mm.boot");
    AppMethodBeat.o(154192);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(154195);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(154195);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(154193);
    c.c(this.app);
    m.dvK();
    AppMethodBeat.o(154193);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(154196);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(154196);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(154194);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(154194);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(154197);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(154197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMIsolatedApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */