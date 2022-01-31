package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector zzem;
  private final AtomicBoolean zzen;
  private final AtomicBoolean zzeo;
  @GuardedBy("sInstance")
  private final ArrayList<BackgroundStateChangeListener> zzep;
  @GuardedBy("sInstance")
  private boolean zzeq;
  
  static
  {
    AppMethodBeat.i(89469);
    zzem = new BackgroundDetector();
    AppMethodBeat.o(89469);
  }
  
  @KeepForSdk
  private BackgroundDetector()
  {
    AppMethodBeat.i(89460);
    this.zzen = new AtomicBoolean();
    this.zzeo = new AtomicBoolean();
    this.zzep = new ArrayList();
    this.zzeq = false;
    AppMethodBeat.o(89460);
  }
  
  @KeepForSdk
  public static BackgroundDetector getInstance()
  {
    return zzem;
  }
  
  @KeepForSdk
  public static void initialize(Application paramApplication)
  {
    AppMethodBeat.i(89461);
    synchronized (zzem)
    {
      if (!zzem.zzeq)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzem);
        paramApplication.registerComponentCallbacks(zzem);
        zzem.zzeq = true;
      }
      AppMethodBeat.o(89461);
      return;
    }
  }
  
  private final void onBackgroundStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(89468);
    synchronized (zzem)
    {
      ArrayList localArrayList = (ArrayList)this.zzep;
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localArrayList.get(i);
        i += 1;
        ((BackgroundStateChangeListener)localObject2).onBackgroundStateChanged(paramBoolean);
      }
    }
    AppMethodBeat.o(89468);
  }
  
  @KeepForSdk
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    AppMethodBeat.i(89464);
    synchronized (zzem)
    {
      this.zzep.add(paramBackgroundStateChangeListener);
      AppMethodBeat.o(89464);
      return;
    }
  }
  
  @KeepForSdk
  public final boolean isInBackground()
  {
    AppMethodBeat.i(89463);
    boolean bool = this.zzen.get();
    AppMethodBeat.o(89463);
    return bool;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(89465);
    boolean bool = this.zzen.compareAndSet(true, false);
    this.zzeo.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
    AppMethodBeat.o(89465);
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(89466);
    boolean bool = this.zzen.compareAndSet(true, false);
    this.zzeo.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
    AppMethodBeat.o(89466);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(89467);
    if ((paramInt == 20) && (this.zzen.compareAndSet(false, true)))
    {
      this.zzeo.set(true);
      onBackgroundStateChanged(true);
    }
    AppMethodBeat.o(89467);
  }
  
  @TargetApi(16)
  @KeepForSdk
  public final boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    AppMethodBeat.i(89462);
    if (!this.zzeo.get())
    {
      if (!PlatformVersion.isAtLeastJellyBean()) {
        break label73;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!this.zzeo.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
        this.zzen.set(true);
      }
    }
    paramBoolean = isInBackground();
    AppMethodBeat.o(89462);
    return paramBoolean;
    label73:
    AppMethodBeat.o(89462);
    return paramBoolean;
  }
  
  @KeepForSdk
  public static abstract interface BackgroundStateChangeListener
  {
    @KeepForSdk
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BackgroundDetector
 * JD-Core Version:    0.7.0.1
 */