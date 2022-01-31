package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.u.a;
import com.tencent.mm.sdk.f.e;
import java.util.concurrent.atomic.AtomicInteger;

final class AppBrandProcessSuicideLogic
  extends a
{
  private static final AppBrandProcessSuicideLogic fAN = new AppBrandProcessSuicideLogic();
  private final AtomicInteger fAO = new AtomicInteger(0);
  
  public static void d(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(fAN);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.fAO.incrementAndGet();
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    if (this.fAO.decrementAndGet() == 0) {
      e.post(new AppBrandProcessSuicideLogic.1(this, paramActivity.getClass()), "CleanupWhenNoActivitiesAliveInAppBrandProcess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */