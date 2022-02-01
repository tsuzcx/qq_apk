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

public class n
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> uqI;
  private int uqJ;
  public boolean uqK;
  
  public n()
  {
    AppMethodBeat.i(137911);
    this.uqI = new LinkedList();
    this.uqJ = 0;
    this.uqK = false;
    AppMethodBeat.o(137911);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.uqJ += 1;
    if (this.uqJ == 1)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.uqI.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).fn(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.uqJ -= 1;
    if (this.uqJ == 0)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.uqI.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).cNz();
      }
      if ((this.uqK) && (this.app != null))
      {
        paramActivity = this.app;
        Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.uqI.clear();
        this.app = null;
        this.uqK = false;
        this.uqK = false;
        this.app = null;
      }
    }
    AppMethodBeat.o(137913);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public static abstract interface a
  {
    public abstract void cNz();
    
    public abstract void fn(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */