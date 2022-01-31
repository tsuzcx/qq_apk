package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;

public class JsApiSetBackgroundAudioStateWC$SetBackgroundAudioStateTaskWC
  extends JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
{
  public JsApiSetBackgroundAudioStateWC$SetBackgroundAudioStateTaskWC(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    super(parama, paramc, paramInt);
  }
  
  public final String BQ(String paramString)
  {
    AppMethodBeat.i(130764);
    paramString = com.tencent.mm.plugin.i.c.YK() + paramString.hashCode();
    AppMethodBeat.o(130764);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioStateTaskWC
 * JD-Core Version:    0.7.0.1
 */