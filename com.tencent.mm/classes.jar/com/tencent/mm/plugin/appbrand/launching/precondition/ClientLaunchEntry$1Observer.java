package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;

class ClientLaunchEntry$1Observer
  extends IListener<d>
  implements Application.ActivityLifecycleCallbacks
{
  private final Application app;
  private final WeakReference<Activity> tey;
  
  public ClientLaunchEntry$1Observer()
  {
    super(f.hfK);
    AppMethodBeat.i(47431);
    this.app = ((Application)this.val$context.getApplicationContext());
    this.tey = new WeakReference((Activity)this.val$context);
    alive();
    this.app.registerActivityLifecycleCallbacks(this);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(47431);
  }
  
  private void unregisterAll()
  {
    AppMethodBeat.i(47435);
    dead();
    this.app.unregisterActivityLifecycleCallbacks(this);
    AppMethodBeat.o(47435);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(47434);
    if (paramActivity == this.tey.get()) {
      unregisterAll();
    }
    AppMethodBeat.o(47434);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(47433);
    if (paramActivity == this.tey.get()) {
      unregisterAll();
    }
    AppMethodBeat.o(47433);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(47432);
    if (paramActivity == this.tey.get()) {
      unregisterAll();
    }
    AppMethodBeat.o(47432);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.ClientLaunchEntry.1Observer
 * JD-Core Version:    0.7.0.1
 */