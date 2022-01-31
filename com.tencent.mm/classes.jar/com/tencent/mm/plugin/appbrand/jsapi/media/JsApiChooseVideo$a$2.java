package com.tencent.mm.plugin.appbrand.jsapi.media;

import java.io.File;

final class JsApiChooseVideo$a$2
  implements Runnable
{
  JsApiChooseVideo$a$2(JsApiChooseVideo.a parama) {}
  
  public final void run()
  {
    if (new File(JsApiChooseVideo.a.b(this.gvZ)).exists())
    {
      JsApiChooseVideo.a.a(this.gvZ).aYY = -1;
      JsApiChooseVideo.a.a(this.gvZ).gvW = JsApiChooseVideo.a.a(this.gvZ, JsApiChooseVideo.a.b(this.gvZ), JsApiChooseVideo.a.c(this.gvZ).gvV);
      JsApiChooseVideo.a.b(this.gvZ, JsApiChooseVideo.a.a(this.gvZ));
      return;
    }
    JsApiChooseVideo.a.a(this.gvZ).aYY = -2;
    JsApiChooseVideo.a.c(this.gvZ, JsApiChooseVideo.a.a(this.gvZ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a.2
 * JD-Core Version:    0.7.0.1
 */