package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.sdk.platformtools.ab;

final class b$5
  extends e.c
{
  b$5(b paramb, AppBrandLivePusherView paramAppBrandLivePusherView, com.tencent.mm.plugin.appbrand.jsapi.e parame) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(96091);
    AppBrandLivePusherView localAppBrandLivePusherView = this.hNI;
    ab.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramd });
    if ((paramd == e.d.gPf) || (paramd == e.d.gPe) || (paramd == e.d.gPl)) {
      localAppBrandLivePusherView.hNx.eh(true);
    }
    AppMethodBeat.o(96091);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(96093);
    com.tencent.mm.plugin.appbrand.e.b(this.hEL.getAppId(), this);
    AppMethodBeat.o(96093);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(96092);
    this.hNI.hNx.aDl();
    AppMethodBeat.o(96092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.5
 * JD-Core Version:    0.7.0.1
 */