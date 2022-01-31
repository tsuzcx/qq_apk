package com.tencent.mm.cm;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.lang.reflect.Field;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private Application application;
  
  private b(Application paramApplication)
  {
    this.application = paramApplication;
  }
  
  public static void g(Application paramApplication)
  {
    if ((Build.MANUFACTURER.equals("samsung")) && (Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT <= 24)) {
      paramApplication.registerActivityLifecycleCallbacks(new b(paramApplication));
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    try
    {
      paramActivity = Class.forName("com.samsung.android.emergencymode.SemEmergencyManager");
      Object localObject = paramActivity.getDeclaredField("sInstance");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      paramActivity = paramActivity.getDeclaredField("mContext");
      paramActivity.setAccessible(true);
      paramActivity.set(localObject, this.application);
      label45:
      this.application.unregisterActivityLifecycleCallbacks(this);
      return;
    }
    catch (Exception paramActivity)
    {
      break label45;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.b
 * JD-Core Version:    0.7.0.1
 */