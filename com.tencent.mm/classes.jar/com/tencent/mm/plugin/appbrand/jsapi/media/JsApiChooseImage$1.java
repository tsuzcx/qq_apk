package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m;

final class JsApiChooseImage$1
  extends g.b
{
  JsApiChooseImage$1(JsApiChooseImage paramJsApiChooseImage, c paramc) {}
  
  public final void onResume()
  {
    m.qI(this.ggH.getAppId()).fzz = false;
    g.b(this.ggH.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.1
 * JD-Core Version:    0.7.0.1
 */