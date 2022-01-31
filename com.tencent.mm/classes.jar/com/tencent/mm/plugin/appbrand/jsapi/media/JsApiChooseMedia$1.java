package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiChooseMedia$1
  extends e.c
{
  JsApiChooseMedia$1(JsApiChooseMedia paramJsApiChooseMedia, c paramc) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(131154);
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
    JsApiChooseMedia.Pt();
    e.b(this.hxW.getAppId(), this);
    AppMethodBeat.o(131154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.1
 * JD-Core Version:    0.7.0.1
 */