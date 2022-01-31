package com.tencent.mm.plugin.appbrand.v;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<d.a> hlh = new LinkedList();
  private int hli = 0;
  public boolean hlj = false;
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.hli += 1;
    if (this.hli == 1)
    {
      y.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.hlh.iterator();
      while (paramBundle.hasNext()) {
        ((d.a)paramBundle.next()).cA(paramActivity);
      }
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.hli -= 1;
    if (this.hli == 0)
    {
      y.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.hlh.iterator();
      while (paramActivity.hasNext()) {
        ((d.a)paramActivity.next()).aqw();
      }
      if ((this.hlj) && (this.app != null))
      {
        paramActivity = this.app;
        y.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.hlh.clear();
        this.app = null;
        this.hlj = false;
        this.hlj = false;
        this.app = null;
      }
    }
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.d
 * JD-Core Version:    0.7.0.1
 */