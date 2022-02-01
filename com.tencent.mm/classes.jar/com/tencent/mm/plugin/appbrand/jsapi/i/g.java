package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class g
  extends e<s>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public void a(s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138192);
    super.a(params, paramJSONObject, paramInt);
    if (!(this.lXb instanceof t))
    {
      Log.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      params.i(paramInt, h("fail:system error", null));
      AppMethodBeat.o(138192);
      return;
    }
    ((t)this.lXb).X(params.getRuntime());
    AppMethodBeat.o(138192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.g
 * JD-Core Version:    0.7.0.1
 */