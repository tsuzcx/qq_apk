package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;

final class JsApiChooseVideo$1
  extends e.c
{
  JsApiChooseVideo$1(JsApiChooseVideo paramJsApiChooseVideo, c paramc) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(131269);
    JsApiChooseVideo.Pt();
    e.b(this.hxW.getAppId(), this);
    AppMethodBeat.o(131269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.1
 * JD-Core Version:    0.7.0.1
 */