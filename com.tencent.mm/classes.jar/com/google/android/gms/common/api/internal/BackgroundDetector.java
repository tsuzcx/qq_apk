package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector zzem;
  private final AtomicBoolean zzen;
  private final AtomicBoolean zzeo;
  private final ArrayList<BackgroundStateChangeListener> zzep;
  private boolean zzeq;
  
  static
  {
    AppMethodBeat.i(4491);
    zzem = new BackgroundDetector();
    AppMethodBeat.o(4491);
  }
  
  private BackgroundDetector()
  {
    AppMethodBeat.i(4482);
    this.zzen = new AtomicBoolean();
    this.zzeo = new AtomicBoolean();
    this.zzep = new ArrayList();
    this.zzeq = false;
    AppMethodBeat.o(4482);
  }
  
  public static BackgroundDetector getInstance()
  {
    return zzem;
  }
  
  public static void initialize(Application paramApplication)
  {
    AppMethodBeat.i(4483);
    synchronized (zzem)
    {
      if (!zzem.zzeq)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzem);
        paramApplication.registerComponentCallbacks(zzem);
        zzem.zzeq = true;
      }
      AppMethodBeat.o(4483);
      return;
    }
  }
  
  private final void onBackgroundStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(4490);
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
    AppMethodBeat.o(4490);
  }
  
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    AppMethodBeat.i(4486);
    synchronized (zzem)
    {
      this.zzep.add(paramBackgroundStateChangeListener);
      AppMethodBeat.o(4486);
      return;
    }
  }
  
  public final boolean isInBackground()
  {
    AppMethodBeat.i(4485);
    boolean bool = this.zzen.get();
    AppMethodBeat.o(4485);
    return bool;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(4487);
    boolean bool = this.zzen.compareAndSet(true, false);
    this.zzeo.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
    AppMethodBeat.o(4487);
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(4488);
    boolean bool = this.zzen.compareAndSet(true, false);
    this.zzeo.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
    AppMethodBeat.o(4488);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(4489);
    if ((paramInt == 20) && (this.zzen.compareAndSet(false, true)))
    {
      this.zzeo.set(true);
      onBackgroundStateChanged(true);
    }
    AppMethodBeat.o(4489);
  }
  
  public final boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    AppMethodBeat.i(4484);
    if (!this.zzeo.get())
    {
      if (!PlatformVersion.isAtLeastJellyBean()) {
        break label75;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!this.zzeo.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
        this.zzen.set(true);
      }
    }
    paramBoolean = isInBackground();
    AppMethodBeat.o(4484);
    return paramBoolean;
    label75:
    AppMethodBeat.o(4484);
    return paramBoolean;
  }
  
  public static abstract interface BackgroundStateChangeListener
  {
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BackgroundDetector
 * JD-Core Version:    0.7.0.1
 */