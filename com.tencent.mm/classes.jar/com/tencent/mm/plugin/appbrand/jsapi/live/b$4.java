package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.t.t;
import com.tencent.mm.sdk.platformtools.ab;

final class b$4
  implements f.b
{
  b$4(b paramb, AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(96090);
    AppBrandLivePusherView localAppBrandLivePusherView = this.hNI;
    i locali = localAppBrandLivePusherView.hNx.eh(false);
    ab.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.bFT });
    localAppBrandLivePusherView.hNv.disable();
    AppMethodBeat.o(96090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.4
 * JD-Core Version:    0.7.0.1
 */