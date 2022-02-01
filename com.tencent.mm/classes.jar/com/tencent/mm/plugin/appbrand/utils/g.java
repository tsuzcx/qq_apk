package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class g
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> mob;
  private int moc;
  public boolean mod;
  
  public g()
  {
    AppMethodBeat.i(137911);
    this.mob = new LinkedList();
    this.moc = 0;
    this.mod = false;
    AppMethodBeat.o(137911);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.moc += 1;
    if (this.moc == 1)
    {
      ac.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.mob.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).dR(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.moc -= 1;
    if (this.moc == 0)
    {
      ac.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.mob.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).bxo();
      }
      if ((this.mod) && (this.app != null))
      {
        paramActivity = this.app;
        ac.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.mob.clear();
        this.app = null;
        this.mod = false;
        this.mod = false;
        this.app = null;
      }
    }
    AppMethodBeat.o(137913);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public static abstract interface a
  {
    public abstract void bxo();
    
    public abstract void dR(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.g
 * JD-Core Version:    0.7.0.1
 */