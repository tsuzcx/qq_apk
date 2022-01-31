package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class JsApiChooseMedia$a$5$1
  implements Runnable
{
  JsApiChooseMedia$a$5$1(JsApiChooseMedia.a.5 param5, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
    JsApiChooseMedia.a.e(this.gvQ.gvN).aYY = -1;
    JsApiChooseMedia.a.e(this.gvQ.gvN).type = "image";
    JsApiChooseMedia.a.e(this.gvQ.gvN).gvI = JsApiChooseMedia.a.h(this.gvO, this.gvP);
    JsApiChooseMedia.a.f(this.gvQ.gvN, JsApiChooseMedia.a.e(this.gvQ.gvN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.5.1
 * JD-Core Version:    0.7.0.1
 */