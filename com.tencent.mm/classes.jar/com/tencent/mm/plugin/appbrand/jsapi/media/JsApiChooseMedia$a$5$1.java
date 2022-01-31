package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class JsApiChooseMedia$a$5$1
  implements Runnable
{
  JsApiChooseMedia$a$5$1(JsApiChooseMedia.a.5 param5, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void run()
  {
    AppMethodBeat.i(131172);
    ab.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
    JsApiChooseMedia.a.e(this.hRh.hRe).bpE = -1;
    JsApiChooseMedia.a.e(this.hRh.hRe).type = "image";
    JsApiChooseMedia.a.e(this.hRh.hRe).hQZ = JsApiChooseMedia.a.c(this.hRf, this.hRg);
    JsApiChooseMedia.a.f(this.hRh.hRe, JsApiChooseMedia.a.e(this.hRh.hRe));
    AppMethodBeat.o(131172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.5.1
 * JD-Core Version:    0.7.0.1
 */