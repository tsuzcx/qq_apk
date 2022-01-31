package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.a;

public class JsApiSetBackgroundAudioStateWC$SetBackgroundAudioStateTaskWC
  extends JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
{
  public JsApiSetBackgroundAudioStateWC$SetBackgroundAudioStateTaskWC(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    super(parama, paramc, paramInt);
  }
  
  public final String tQ(String paramString)
  {
    return com.tencent.mm.plugin.n.c.FG() + paramString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioStateTaskWC
 * JD-Core Version:    0.7.0.1
 */