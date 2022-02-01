package com.google.android.gms.common.api.internal;

import android.app.Activity;

public abstract class ActivityLifecycleObserver
{
  public static final ActivityLifecycleObserver of(Activity paramActivity)
  {
    return new zza(paramActivity);
  }
  
  public abstract ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ActivityLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */