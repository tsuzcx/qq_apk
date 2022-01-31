package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;

final class JsApiChooseImage$1
  extends e.c
{
  JsApiChooseImage$1(JsApiChooseImage paramJsApiChooseImage, c paramc) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(131123);
    n.yd(this.hxW.getAppId()).gRb = false;
    e.b(this.hxW.getAppId(), this);
    AppMethodBeat.o(131123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.1
 * JD-Core Version:    0.7.0.1
 */