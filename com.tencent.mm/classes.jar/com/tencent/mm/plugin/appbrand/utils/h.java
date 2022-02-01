package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class h
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> ogJ;
  private int ogK;
  public boolean ogL;
  
  public h()
  {
    AppMethodBeat.i(137911);
    this.ogJ = new LinkedList();
    this.ogK = 0;
    this.ogL = false;
    AppMethodBeat.o(137911);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.ogK += 1;
    if (this.ogK == 1)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.ogJ.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).er(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.ogK -= 1;
    if (this.ogK == 0)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.ogJ.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).bZq();
      }
      if ((this.ogL) && (this.app != null))
      {
        paramActivity = this.app;
        Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.ogJ.clear();
        this.app = null;
        this.ogL = false;
        this.ogL = false;
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
    public abstract void bZq();
    
    public abstract void er(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.h
 * JD-Core Version:    0.7.0.1
 */