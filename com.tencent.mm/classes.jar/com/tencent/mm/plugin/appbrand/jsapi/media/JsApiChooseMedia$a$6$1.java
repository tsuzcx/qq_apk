package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class JsApiChooseMedia$a$6$1
  implements Runnable
{
  JsApiChooseMedia$a$6$1(JsApiChooseMedia.a.6 param6, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void run()
  {
    AppMethodBeat.i(131174);
    ab.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
    JsApiChooseMedia.a.e(this.hRj.hRe).bpE = -1;
    JsApiChooseMedia.a.e(this.hRj.hRe).type = "image";
    JsApiChooseMedia.a.e(this.hRj.hRe).hQZ = JsApiChooseMedia.a.c(this.hRf, this.hRi);
    JsApiChooseMedia.a.g(this.hRj.hRe, JsApiChooseMedia.a.e(this.hRj.hRe));
    AppMethodBeat.o(131174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.6.1
 * JD-Core Version:    0.7.0.1
 */