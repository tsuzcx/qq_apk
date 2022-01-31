package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;

final class JsApiChooseMultiMedia$2
  extends e.c
{
  JsApiChooseMultiMedia$2(JsApiChooseMultiMedia paramJsApiChooseMultiMedia, c paramc) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(131218);
    n.yd(this.hKB.getAppId()).gRd = false;
    e.b(this.hKB.getAppId(), this);
    AppMethodBeat.o(131218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.2
 * JD-Core Version:    0.7.0.1
 */