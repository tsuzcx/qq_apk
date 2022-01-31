package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class JsApiOperateBackgroundAudio$a
  extends ai
{
  private static final int CTRL_INDEX = 162;
  private static final String NAME = "onBackgroundAudioNext";
  private static final a hBU;
  
  static
  {
    AppMethodBeat.i(137749);
    hBU = new a();
    AppMethodBeat.o(137749);
  }
  
  static void k(c paramc)
  {
    try
    {
      AppMethodBeat.i(137748);
      ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
      hBU.j(paramc).aBz();
      AppMethodBeat.o(137748);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.a
 * JD-Core Version:    0.7.0.1
 */