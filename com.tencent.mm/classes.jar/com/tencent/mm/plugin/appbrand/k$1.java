package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;

final class k$1
  extends a
{
  k$1(k paramk) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(86710);
    if (this.gQD.gQx == paramActivity) {
      this.gQD.gQx.getApplication().unregisterActivityLifecycleCallbacks(this);
    }
    AppMethodBeat.o(86710);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    if (this.gQD.gQx == paramActivity)
    {
      this.gQD.bFa = false;
      this.gQD.bFb = true;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (this.gQD.gQx == paramActivity)
    {
      this.gQD.bFa = true;
      this.gQD.bFb = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.1
 * JD-Core Version:    0.7.0.1
 */