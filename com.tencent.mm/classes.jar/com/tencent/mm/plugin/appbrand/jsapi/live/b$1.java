package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.t.t;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements f.d
{
  b$1(b paramb, AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(96085);
    AppBrandLivePusherView localAppBrandLivePusherView = this.hNI;
    i locali = localAppBrandLivePusherView.hNx.aDl();
    ab.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.bFT });
    localAppBrandLivePusherView.hNv.enable();
    AppMethodBeat.o(96085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.1
 * JD-Core Version:    0.7.0.1
 */