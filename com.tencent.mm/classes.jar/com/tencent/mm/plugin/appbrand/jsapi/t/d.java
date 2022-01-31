package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 34;
  public static final String NAME = "pauseVoice";
  
  protected final void a(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145916);
    paramc = paramc.aFY();
    ab.i("MicroMsg.JsApiPausePlayVoice", "pause:%s", new Object[] { paramc });
    if (paramc.isSuccess())
    {
      paramc1.h(paramInt, "ok");
      AppMethodBeat.o(145916);
      return;
    }
    ab.e("MicroMsg.JsApiPausePlayVoice", "pause fail %s", new Object[] { paramc });
    paramc1.h(paramInt, "fail:" + paramc.errMsg);
    AppMethodBeat.o(145916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.d
 * JD-Core Version:    0.7.0.1
 */