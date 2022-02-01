package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bt;

public final class JsApiStopPlayVoice
  extends a<q>
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  public static void biG()
  {
    AppMethodBeat.i(45997);
    if (bt.isNullOrNil(JsApiStartPlayVoice.kxh))
    {
      AppMethodBeat.o(45997);
      return;
    }
    AppBrandMainProcessService.a(new JsApiStopPlayVoice.StopPlayVoice((byte)0));
    JsApiStartPlayVoice.kxh = null;
    AppMethodBeat.o(45997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice
 * JD-Core Version:    0.7.0.1
 */