package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$3
  implements Runnable
{
  c$3(c paramc, Activity paramActivity, float paramFloat) {}
  
  public final void run()
  {
    float f = 0.01F;
    AppMethodBeat.i(139555);
    WindowManager.LayoutParams localLayoutParams = this.val$activity.getWindow().getAttributes();
    if (this.mLc < 0.01F) {}
    for (;;)
    {
      localLayoutParams.screenBrightness = f;
      this.val$activity.getWindow().setAttributes(localLayoutParams);
      Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", new Object[] { Float.valueOf(localLayoutParams.screenBrightness) });
      AppMethodBeat.o(139555);
      return;
      f = this.mLc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.3
 * JD-Core Version:    0.7.0.1
 */