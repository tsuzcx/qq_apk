package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.sdk.platformtools.ab;

final class d$3
  extends e.c
{
  d$3(d paramd) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(141907);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
    HCEEventLogic.ev(true);
    AppMethodBeat.o(141907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.3
 * JD-Core Version:    0.7.0.1
 */