package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h
  extends f<v>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138192);
    super.a(paramv, paramJSONObject, paramInt);
    if (!(this.oUM instanceof u))
    {
      Log.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramv.j(paramInt, h("fail:system error", null));
      AppMethodBeat.o(138192);
      return;
    }
    ((u)this.oUM).Y(paramv.getRuntime());
    AppMethodBeat.o(138192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.h
 * JD-Core Version:    0.7.0.1
 */