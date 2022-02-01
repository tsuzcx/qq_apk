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

public class j
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> rix;
  private int riy;
  public boolean riz;
  
  public j()
  {
    AppMethodBeat.i(137911);
    this.rix = new LinkedList();
    this.riy = 0;
    this.riz = false;
    AppMethodBeat.o(137911);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.riy += 1;
    if (this.riy == 1)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.rix.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).er(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.riy -= 1;
    if (this.riy == 0)
    {
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.rix.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).cmf();
      }
      if ((this.riz) && (this.app != null))
      {
        paramActivity = this.app;
        Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.rix.clear();
        this.app = null;
        this.riz = false;
        this.riz = false;
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
    public abstract void cmf();
    
    public abstract void er(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.j
 * JD-Core Version:    0.7.0.1
 */