package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;

final class k$1$1
  extends e.c
{
  k$1$1(k.1 param1, WindowManager.LayoutParams paramLayoutParams, Activity paramActivity) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(126429);
    this.iaY.screenBrightness = this.iaZ.iaX.iaV;
    this.val$activity.getWindow().setAttributes(this.iaY);
    AppMethodBeat.o(126429);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126430);
    this.iaY.screenBrightness = this.iaZ.iaX.iaW;
    this.val$activity.getWindow().setAttributes(this.iaY);
    AppMethodBeat.o(126430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.k.1.1
 * JD-Core Version:    0.7.0.1
 */