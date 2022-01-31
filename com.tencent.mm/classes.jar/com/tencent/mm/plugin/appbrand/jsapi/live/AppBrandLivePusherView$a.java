package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLivePusherView$a
  implements Runnable
{
  int bGN;
  int number = 0;
  
  AppBrandLivePusherView$a(AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void run()
  {
    AppMethodBeat.i(96057);
    this.number += 1;
    ab.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.bGN);
    int i = AppBrandLivePusherView.c(this.hNB);
    if (i == this.bGN)
    {
      AppBrandLivePusherView.a(this.hNB, i);
      AppMethodBeat.o(96057);
      return;
    }
    if (this.number < 8) {
      AppBrandLivePusherView.b(this.hNB).postDelayed(this, 250L);
    }
    AppMethodBeat.o(96057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.a
 * JD-Core Version:    0.7.0.1
 */