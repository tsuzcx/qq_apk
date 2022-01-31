package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
class GoogleAnalytics$zzb
  implements Application.ActivityLifecycleCallbacks
{
  GoogleAnalytics$zzb(GoogleAnalytics paramGoogleAnalytics) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.zzabM.zzm(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.zzabM.zzn(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.analytics.GoogleAnalytics.zzb
 * JD-Core Version:    0.7.0.1
 */