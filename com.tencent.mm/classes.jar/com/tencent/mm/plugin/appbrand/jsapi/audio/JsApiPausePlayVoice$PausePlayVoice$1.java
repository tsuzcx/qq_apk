package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;

final class JsApiPausePlayVoice$PausePlayVoice$1
  implements Runnable
{
  JsApiPausePlayVoice$PausePlayVoice$1(JsApiPausePlayVoice.PausePlayVoice paramPausePlayVoice) {}
  
  public final void run()
  {
    AppMethodBeat.i(130756);
    ((b)g.E(b.class)).pause();
    AppMethodBeat.o(130756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice.1
 * JD-Core Version:    0.7.0.1
 */