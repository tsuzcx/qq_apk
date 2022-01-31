package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class i
  extends b
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  public final void c(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145964);
    paramJSONObject = (e)paramc.q(e.class);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiStopRecord", "luggageRecorder is null, return");
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(145964);
      return;
    }
    paramJSONObject = paramJSONObject.aGg();
    ab.i("MicroMsg.JsApiStopRecord", "startRecord result:%s", new Object[] { paramJSONObject });
    if ((paramJSONObject != null) && (paramJSONObject.isSuccess()))
    {
      paramc.h(paramInt, j("ok", null));
      AppMethodBeat.o(145964);
      return;
    }
    paramc.h(paramInt, j("fail:" + paramJSONObject.errMsg, null));
    ab.e("MicroMsg.JsApiStopRecord", "startRecord fail");
    AppMethodBeat.o(145964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.i
 * JD-Core Version:    0.7.0.1
 */