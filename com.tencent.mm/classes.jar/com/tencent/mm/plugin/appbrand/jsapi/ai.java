package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class ai
  extends JsApiUploadWeRunData
{
  public static final int CTRL_INDEX = 324;
  public static final String NAME = "addWeRunData";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45450);
    ad.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiAddWeRunData", "data is null");
      AppMethodBeat.o(45450);
      return;
    }
    a(this, paramc, paramInt, paramJSONObject.optInt("step"), true);
    AppMethodBeat.o(45450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */