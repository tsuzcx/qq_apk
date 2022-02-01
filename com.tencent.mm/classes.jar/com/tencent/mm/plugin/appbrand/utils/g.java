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

public final class g
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> mOD;
  private int mOE;
  public boolean mOF;
  
  public g()
  {
    AppMethodBeat.i(137911);
    this.mOD = new LinkedList();
    this.mOE = 0;
    this.mOF = false;
    AppMethodBeat.o(137911);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.mOE += 1;
    if (this.mOE == 1)
    {
      ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.mOD.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).dQ(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.mOE -= 1;
    if (this.mOE == 0)
    {
      ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.mOD.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).bBs();
      }
      if ((this.mOF) && (this.app != null))
      {
        paramActivity = this.app;
        ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.mOD.clear();
        this.app = null;
        this.mOF = false;
        this.mOF = false;
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
    public abstract void bBs();
    
    public abstract void dQ(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.g
 * JD-Core Version:    0.7.0.1
 */