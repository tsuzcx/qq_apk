package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzaac
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final zzaac zzazV = new zzaac();
  private final ArrayList<zzaac.zza> mListeners = new ArrayList();
  private boolean zzadP = false;
  private final AtomicBoolean zzazW = new AtomicBoolean();
  private final AtomicBoolean zzazX = new AtomicBoolean();
  
  public static void zza(Application paramApplication)
  {
    synchronized (zzazV)
    {
      if (!zzazV.zzadP)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzazV);
        paramApplication.registerComponentCallbacks(zzazV);
        zzazV.zzadP = true;
      }
      return;
    }
  }
  
  private void zzat(boolean paramBoolean)
  {
    synchronized (zzazV)
    {
      Iterator localIterator = this.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((zzaac.zza)localIterator.next()).zzat(paramBoolean);
      }
    }
  }
  
  public static zzaac zzvB()
  {
    return zzazV;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.zzazW.compareAndSet(true, false);
    this.zzazX.set(true);
    if (bool) {
      zzat(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.zzazW.compareAndSet(true, false);
    this.zzazX.set(true);
    if (bool) {
      zzat(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.zzazW.compareAndSet(false, true)))
    {
      this.zzazX.set(true);
      zzat(true);
    }
  }
  
  public final void zza(zzaac.zza paramzza)
  {
    synchronized (zzazV)
    {
      this.mListeners.add(paramzza);
      return;
    }
  }
  
  @TargetApi(16)
  public final boolean zzas(boolean paramBoolean)
  {
    if (!this.zzazX.get())
    {
      if (!zzt.zzzi()) {
        return paramBoolean;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!this.zzazX.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
        this.zzazW.set(true);
      }
    }
    paramBoolean = zzvC();
    return paramBoolean;
  }
  
  public final boolean zzvC()
  {
    return this.zzazW.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaac
 * JD-Core Version:    0.7.0.1
 */