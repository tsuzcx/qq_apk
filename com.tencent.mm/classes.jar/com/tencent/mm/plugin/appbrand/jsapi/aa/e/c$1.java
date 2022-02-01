package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.s.a.d;
import com.tencent.mm.sdk.platformtools.ad;

final class c$1
  implements Runnable
{
  c$1(c paramc, aa paramaa, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(139553);
    if ((!this.kzG.isRunning()) || (this.kzG.kWU == null))
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
      AppMethodBeat.o(139553);
      return;
    }
    d locald = this.kzG.kWU.getFullscreenImpl();
    View localView = this.kzG.kWU.getWrapperView();
    if ((locald != null) && (localView != null))
    {
      locald.O(localView, this.kzH);
      if (this.kAD.kAA != null) {
        locald.a(this.kAD.kAA);
      }
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(this.kzH) });
      AppMethodBeat.o(139553);
      return;
    }
    ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
    AppMethodBeat.o(139553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.1
 * JD-Core Version:    0.7.0.1
 */