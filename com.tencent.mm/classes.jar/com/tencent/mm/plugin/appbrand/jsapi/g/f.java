package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class f
  extends d<r>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public void a(r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138192);
    super.a(paramr, paramJSONObject, paramInt);
    if (!(this.kRV instanceof s))
    {
      ae.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramr.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138192);
      return;
    }
    ((s)this.kRV).W(paramr.getRuntime());
    AppMethodBeat.o(138192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.f
 * JD-Core Version:    0.7.0.1
 */