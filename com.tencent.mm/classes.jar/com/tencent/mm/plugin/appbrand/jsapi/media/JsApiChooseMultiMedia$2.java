package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;

final class JsApiChooseMultiMedia$2
  extends g.c
{
  JsApiChooseMultiMedia$2(JsApiChooseMultiMedia paramJsApiChooseMultiMedia, c paramc) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(46494);
    n.Dp(this.jBi.getAppId()).iFT = false;
    g.b(this.jBi.getAppId(), this);
    AppMethodBeat.o(46494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.2
 * JD-Core Version:    0.7.0.1
 */