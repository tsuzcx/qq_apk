package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class f
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> lMd;
  private int lMe;
  public boolean lMf;
  
  public f()
  {
    AppMethodBeat.i(137911);
    this.lMd = new LinkedList();
    this.lMe = 0;
    this.lMf = false;
    AppMethodBeat.o(137911);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.lMe += 1;
    if (this.lMe == 1)
    {
      ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.lMd.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).dJ(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.lMe -= 1;
    if (this.lMe == 0)
    {
      ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.lMd.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).bqq();
      }
      if ((this.lMf) && (this.app != null))
      {
        paramActivity = this.app;
        ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.lMd.clear();
        this.app = null;
        this.lMf = false;
        this.lMf = false;
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
    public abstract void bqq();
    
    public abstract void dJ(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.f
 * JD-Core Version:    0.7.0.1
 */