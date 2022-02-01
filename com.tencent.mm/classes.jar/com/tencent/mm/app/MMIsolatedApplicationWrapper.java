package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.c;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.splash.n;
import com.tencent.smtt.sandbox.SandboxListener;
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
  private com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  public MMIsolatedApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(160050);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    com.tencent.mm.blink.a.r(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160050);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160051);
    com.tencent.mm.kernel.a.a.kdJ = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.kdI = System.currentTimeMillis();
    this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.kfk.kfm = this.processInitTimestamp;
    com.tencent.mm.vfs.h.setContext(this.profile.Zw);
    paramContext.getClassLoader();
    j.KW("stlport_shared");
    paramContext.getClassLoader();
    j.KW("c++_shared");
    QbSdk.setSandboxListener(new SandboxListener()
    {
      public final void setCrashRecordFileDescriptor(ParcelFileDescriptor paramAnonymousParcelFileDescriptor1, ParcelFileDescriptor paramAnonymousParcelFileDescriptor2)
      {
        AppMethodBeat.i(160134);
        u.a(paramAnonymousParcelFileDescriptor1, paramAnonymousParcelFileDescriptor2, MMIsolatedApplicationWrapper.this.thisProcess);
        AppMethodBeat.o(160134);
      }
    });
    com.tencent.mm.splash.a.q(this.app);
    com.tencent.mm.cb.a.a.hoB();
    Log.i("MicroMsg.MMIsolatedApplicationWrapper", "is plain process. load nothing");
    al.a(this.profile, null);
    ac.ab(R.raw.class);
    ac.setPackageName("com.tencent.mm.boot");
    AppMethodBeat.o(160051);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(160054);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(160054);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(160052);
    c.i(this.app);
    n.huz();
    AppMethodBeat.o(160052);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(160055);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(160055);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(160053);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(160053);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(160056);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(160056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMIsolatedApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */