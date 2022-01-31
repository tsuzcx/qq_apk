package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  protected final void a(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145922);
    paramc = paramc.aFZ();
    ab.i("MicroMsg.JsApiStopPlayVoice", "stop:%s", new Object[] { paramc });
    if (paramc.isSuccess())
    {
      paramc1.h(paramInt, "ok");
      AppMethodBeat.o(145922);
      return;
    }
    ab.e("MicroMsg.JsApiStopPlayVoice", "stop fail %s", new Object[] { paramc });
    paramc1.h(paramInt, "fail:" + paramc.errMsg);
    AppMethodBeat.o(145922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.f
 * JD-Core Version:    0.7.0.1
 */