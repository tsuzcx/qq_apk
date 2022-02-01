package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.c;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.splash.n;
import com.tencent.smtt.sandbox.SandboxListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.xweb.pinus.sdk.process.SandBoxHelper;
import com.tencent.xweb.pinus.sdk.process.SandBoxHelper.SandboxListener;

public class MMIsolatedApplicationWrapper
  implements ApplicationLifeCycle
{
  public Application app;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private h profile;
  private String thisProcess;
  
  public MMIsolatedApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(160050);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    com.tencent.mm.blink.a.O(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160050);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160051);
    com.tencent.mm.kernel.a.a.mDT = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.mDS = System.currentTimeMillis();
    this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.mFH.mFJ = this.processInitTimestamp;
    com.tencent.mm.vfs.k.setContext(this.profile.bGP);
    paramContext.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("stlport_shared");
    paramContext.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("c++_shared");
    QbSdk.setSandboxListener(new SandboxListener()
    {
      public final void setCrashRecordFileDescriptor(ParcelFileDescriptor paramAnonymousParcelFileDescriptor1, ParcelFileDescriptor paramAnonymousParcelFileDescriptor2)
      {
        AppMethodBeat.i(160134);
        x.a(paramAnonymousParcelFileDescriptor1, paramAnonymousParcelFileDescriptor2, MMIsolatedApplicationWrapper.a(MMIsolatedApplicationWrapper.this));
        AppMethodBeat.o(160134);
      }
    });
    SandBoxHelper.setSandboxListener(new SandBoxHelper.SandboxListener()
    {
      public final void setCrashRecordFileDescriptor(ParcelFileDescriptor paramAnonymousParcelFileDescriptor1, ParcelFileDescriptor paramAnonymousParcelFileDescriptor2)
      {
        AppMethodBeat.i(239251);
        x.a(paramAnonymousParcelFileDescriptor1, paramAnonymousParcelFileDescriptor2, MMIsolatedApplicationWrapper.a(MMIsolatedApplicationWrapper.this));
        AppMethodBeat.o(239251);
      }
    });
    com.tencent.mm.splash.a.r(this.app);
    com.tencent.mm.bu.a.a.iPx();
    Log.i("MicroMsg.MMIsolatedApplicationWrapper", "is plain process. load nothing");
    ap.a(this.profile, null);
    af.at(R.raw.class);
    af.setPackageName("com.tencent.mm.boot");
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
    n.iWb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMIsolatedApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */