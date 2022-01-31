package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class f
  implements Application.ActivityLifecycleCallbacks
{
  public Application app;
  public final Queue<f.a> iXC;
  private int iXD;
  public boolean iXE;
  
  public f()
  {
    AppMethodBeat.i(126633);
    this.iXC = new LinkedList();
    this.iXD = 0;
    this.iXE = false;
    AppMethodBeat.o(126633);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(126634);
    this.iXD += 1;
    if (this.iXD == 1)
    {
      ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
      paramBundle = this.iXC.iterator();
      while (paramBundle.hasNext()) {
        ((f.a)paramBundle.next()).dg(paramActivity);
      }
    }
    AppMethodBeat.o(126634);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(126635);
    this.iXD -= 1;
    if (this.iXD == 0)
    {
      ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
      paramActivity = this.iXC.iterator();
      while (paramActivity.hasNext()) {
        ((f.a)paramActivity.next()).aNZ();
      }
      if ((this.iXE) && (this.app != null))
      {
        paramActivity = this.app;
        ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
        paramActivity.unregisterActivityLifecycleCallbacks(this);
        this.iXC.clear();
        this.app = null;
        this.iXE = false;
        this.iXE = false;
        this.app = null;
      }
    }
    AppMethodBeat.o(126635);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.f
 * JD-Core Version:    0.7.0.1
 */