package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;

final class JsApiStartRecordVoice$1
  implements f.b
{
  JsApiStartRecordVoice$1(JsApiStartRecordVoice paramJsApiStartRecordVoice, r paramr) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(130784);
    JsApiStopRecordVoice.m(this.bAW);
    JsApiStartRecordVoice.a(this.hCO).b(this);
    AppMethodBeat.o(130784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.1
 * JD-Core Version:    0.7.0.1
 */