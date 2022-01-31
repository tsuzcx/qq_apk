package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class JsApiOperateBackgroundAudio$b
  extends ai
{
  private static final int CTRL_INDEX = 162;
  private static final String NAME = "onBackgroundAudioPrev";
  private static final b hBV;
  
  static
  {
    AppMethodBeat.i(137751);
    hBV = new b();
    AppMethodBeat.o(137751);
  }
  
  static void k(c paramc)
  {
    try
    {
      AppMethodBeat.i(137750);
      ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
      hBV.j(paramc).aBz();
      AppMethodBeat.o(137750);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.b
 * JD-Core Version:    0.7.0.1
 */