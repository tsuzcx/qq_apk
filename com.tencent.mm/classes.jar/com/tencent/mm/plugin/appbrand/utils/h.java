package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class h
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<a> mTI;
  private int mTJ;
  public boolean mTK;
  
  public h()
  {
    AppMethodBeat.i(137911);
    this.mTI = new LinkedList();
    this.mTJ = 0;
    this.mTK = false;
    AppMethodBeat.o(137911);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(137912);
    this.mTJ += 1;
    if (this.mTJ == 1)
    {
      ae.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.mTI.iterator();
      while (paramBundle.hasNext()) {
        ((a)paramBundle.next()).dU(paramActivity);
      }
    }
    AppMethodBeat.o(137912);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(137913);
    this.mTJ -= 1;
    if (this.mTJ == 0)
    {
      ae.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.mTI.iterator();
      while (paramActivity.hasNext()) {
        ((a)paramActivity.next()).bCm();
      }
      if ((this.mTK) && (this.app != null))
      {
        paramActivity = this.app;
        ae.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.mTI.clear();
        this.app = null;
        this.mTK = false;
        this.mTK = false;
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
    public abstract void bCm();
    
    public abstract void dU(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.h
 * JD-Core Version:    0.7.0.1
 */