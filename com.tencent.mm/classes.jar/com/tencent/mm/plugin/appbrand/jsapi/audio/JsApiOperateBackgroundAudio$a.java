package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;

public final class JsApiOperateBackgroundAudio$a
  extends ac
{
  private static final int CTRL_INDEX = 162;
  private static final String NAME = "onBackgroundAudioNext";
  private static final a giB = new a();
  
  static void f(c paramc)
  {
    try
    {
      y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
      giB.e(paramc).dispatch();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.a
 * JD-Core Version:    0.7.0.1
 */