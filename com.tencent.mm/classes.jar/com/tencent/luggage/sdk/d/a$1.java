package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends com.tencent.mm.plugin.appbrand.s.a
{
  a$1(a parama) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(140794);
    if (this.bFc.gQx == paramActivity) {
      this.bFc.gQx.getApplication().unregisterActivityLifecycleCallbacks(this);
    }
    AppMethodBeat.o(140794);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    if (this.bFc.gQx == paramActivity)
    {
      this.bFc.bFa = false;
      this.bFc.bFb = true;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (this.bFc.gQx == paramActivity)
    {
      this.bFc.bFa = true;
      this.bFc.bFb = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a.1
 * JD-Core Version:    0.7.0.1
 */