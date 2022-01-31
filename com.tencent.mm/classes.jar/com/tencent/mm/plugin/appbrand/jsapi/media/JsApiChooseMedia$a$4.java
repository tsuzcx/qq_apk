package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class JsApiChooseMedia$a$4
  implements Runnable
{
  JsApiChooseMedia$a$4(JsApiChooseMedia.a parama) {}
  
  public final void run()
  {
    if (new File(JsApiChooseMedia.a.f(this.gvN)).exists())
    {
      y.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
      JsApiChooseMedia.a.e(this.gvN).aYY = -1;
      JsApiChooseMedia.a.e(this.gvN).type = "video";
      AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(this.gvN, JsApiChooseMedia.a.f(this.gvN));
      if (localAppBrandLocalVideoObject == null)
      {
        y.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(this.gvN) });
        JsApiChooseMedia.a.e(this.gvN).aYY = -2;
        JsApiChooseMedia.a.b(this.gvN, JsApiChooseMedia.a.e(this.gvN));
        return;
      }
      JsApiChooseMedia.a.b(this.gvN, JsApiChooseMedia.a.f(this.gvN));
      String str = JsApiChooseMedia.a.g(this.gvN);
      JsApiChooseMedia.a.e(this.gvN).gvI = JsApiChooseMedia.a.d(localAppBrandLocalVideoObject.bMB, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
      JsApiChooseMedia.a.c(this.gvN, JsApiChooseMedia.a.e(this.gvN));
      return;
    }
    y.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(this.gvN) });
    JsApiChooseMedia.a.e(this.gvN).aYY = -2;
    JsApiChooseMedia.a.d(this.gvN, JsApiChooseMedia.a.e(this.gvN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.4
 * JD-Core Version:    0.7.0.1
 */