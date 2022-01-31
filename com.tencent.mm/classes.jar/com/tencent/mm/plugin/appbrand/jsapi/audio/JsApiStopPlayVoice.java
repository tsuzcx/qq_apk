package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bo;

public final class JsApiStopPlayVoice
  extends a<r>
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  public static void aBR()
  {
    AppMethodBeat.i(130808);
    if (bo.isNullOrNil(JsApiStartPlayVoice.hCH))
    {
      AppMethodBeat.o(130808);
      return;
    }
    AppBrandMainProcessService.a(new JsApiStopPlayVoice.StopPlayVoice((byte)0));
    JsApiStartPlayVoice.hCH = null;
    AppMethodBeat.o(130808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice
 * JD-Core Version:    0.7.0.1
 */