package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class JsApiChooseMedia$a$6$1
  implements Runnable
{
  JsApiChooseMedia$a$6$1(JsApiChooseMedia.a.6 param6, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
    JsApiChooseMedia.a.e(this.gvS.gvN).aYY = -1;
    JsApiChooseMedia.a.e(this.gvS.gvN).type = "image";
    JsApiChooseMedia.a.e(this.gvS.gvN).gvI = JsApiChooseMedia.a.h(this.gvO, this.gvR);
    JsApiChooseMedia.a.g(this.gvS.gvN, JsApiChooseMedia.a.e(this.gvS.gvN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.6.1
 * JD-Core Version:    0.7.0.1
 */