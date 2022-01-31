package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiChooseMedia$1
  extends g.b
{
  JsApiChooseMedia$1(JsApiChooseMedia paramJsApiChooseMedia, c paramc) {}
  
  public final void onResume()
  {
    y.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
    JsApiChooseMedia.BF();
    g.b(this.ggH.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.1
 * JD-Core Version:    0.7.0.1
 */