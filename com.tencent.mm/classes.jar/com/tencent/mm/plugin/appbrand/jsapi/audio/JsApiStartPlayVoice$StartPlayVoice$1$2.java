package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.b;

final class JsApiStartPlayVoice$StartPlayVoice$1$2
  implements h.b
{
  JsApiStartPlayVoice$StartPlayVoice$1$2(JsApiStartPlayVoice.StartPlayVoice.1 param1) {}
  
  public final void onError()
  {
    AppMethodBeat.i(130772);
    this.hCL.hCK.error = true;
    JsApiStartPlayVoice.StartPlayVoice.c(this.hCL.hCK);
    AppMethodBeat.o(130772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.1.2
 * JD-Core Version:    0.7.0.1
 */