package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class JsApiChooseVideo$a$2
  implements Runnable
{
  JsApiChooseVideo$a$2(JsApiChooseVideo.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131283);
    if (new File(JsApiChooseVideo.a.b(this.hRK)).exists())
    {
      JsApiChooseVideo.a.a(this.hRK).bpE = -1;
      JsApiChooseVideo.a.a(this.hRK).hRH = JsApiChooseVideo.a.a(this.hRK, JsApiChooseVideo.a.b(this.hRK), JsApiChooseVideo.a.c(this.hRK).hRG);
      JsApiChooseVideo.a.b(this.hRK, JsApiChooseVideo.a.a(this.hRK));
      AppMethodBeat.o(131283);
      return;
    }
    JsApiChooseVideo.a.a(this.hRK).bpE = -2;
    JsApiChooseVideo.a.c(this.hRK, JsApiChooseVideo.a.a(this.hRK));
    AppMethodBeat.o(131283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a.2
 * JD-Core Version:    0.7.0.1
 */