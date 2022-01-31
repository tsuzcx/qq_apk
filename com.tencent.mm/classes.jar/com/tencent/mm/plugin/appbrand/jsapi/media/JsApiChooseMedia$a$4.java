package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class JsApiChooseMedia$a$4
  implements Runnable
{
  JsApiChooseMedia$a$4(JsApiChooseMedia.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131171);
    if (new File(JsApiChooseMedia.a.f(this.hRe)).exists())
    {
      ab.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
      JsApiChooseMedia.a.e(this.hRe).bpE = -1;
      JsApiChooseMedia.a.e(this.hRe).type = "video";
      AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(this.hRe, JsApiChooseMedia.a.f(this.hRe));
      if (localAppBrandLocalVideoObject == null)
      {
        ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(this.hRe) });
        JsApiChooseMedia.a.e(this.hRe).bpE = -2;
        JsApiChooseMedia.a.b(this.hRe, JsApiChooseMedia.a.e(this.hRe));
        AppMethodBeat.o(131171);
        return;
      }
      JsApiChooseMedia.a.b(this.hRe, JsApiChooseMedia.a.f(this.hRe));
      String str = JsApiChooseMedia.a.g(this.hRe);
      JsApiChooseMedia.a.e(this.hRe).hQZ = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.ctV, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
      JsApiChooseMedia.a.c(this.hRe, JsApiChooseMedia.a.e(this.hRe));
      AppMethodBeat.o(131171);
      return;
    }
    ab.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(this.hRe) });
    JsApiChooseMedia.a.e(this.hRe).bpE = -2;
    JsApiChooseMedia.a.d(this.hRe, JsApiChooseMedia.a.e(this.hRe));
    AppMethodBeat.o(131171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.4
 * JD-Core Version:    0.7.0.1
 */