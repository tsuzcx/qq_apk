package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class ar$1
  extends e.c
{
  ar$1(ar paramar, r paramr) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140829);
    ab.i("MicroMsg.JsApiGetSystemInfo", "onDestroy, reset font scale");
    e.b(this.bAW.getAppId(), this);
    this.hxZ.hxY = -1.0F;
    AppMethodBeat.o(140829);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140830);
    super.onResume();
    ab.i("MicroMsg.JsApiGetSystemInfo", "onResume, update font scale from sp");
    this.hxZ.j(this.bAW);
    AppMethodBeat.o(140830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar.1
 * JD-Core Version:    0.7.0.1
 */