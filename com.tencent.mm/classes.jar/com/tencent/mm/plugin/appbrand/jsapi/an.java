package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class an
  extends JsApiUploadWeRunData
{
  public static final int CTRL_INDEX = 324;
  public static final String NAME = "addWeRunData";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45450);
    Log.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiAddWeRunData", "data is null");
      AppMethodBeat.o(45450);
      return;
    }
    a(this, parame, paramInt, paramJSONObject.optInt("step"), true);
    AppMethodBeat.o(45450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.an
 * JD-Core Version:    0.7.0.1
 */