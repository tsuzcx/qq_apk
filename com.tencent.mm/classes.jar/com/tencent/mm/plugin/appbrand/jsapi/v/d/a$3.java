package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements Runnable
{
  a$3(a parama, Activity paramActivity, float paramFloat) {}
  
  public final void run()
  {
    float f = 0.01F;
    AppMethodBeat.i(140066);
    WindowManager.LayoutParams localLayoutParams = this.val$activity.getWindow().getAttributes();
    if (this.iiK < 0.01F) {}
    for (;;)
    {
      localLayoutParams.screenBrightness = f;
      this.val$activity.getWindow().setAttributes(localLayoutParams);
      ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", new Object[] { Float.valueOf(localLayoutParams.screenBrightness) });
      AppMethodBeat.o(140066);
      return;
      f = this.iiK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.a.3
 * JD-Core Version:    0.7.0.1
 */