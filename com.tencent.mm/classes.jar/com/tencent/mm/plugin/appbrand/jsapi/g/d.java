package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  protected r kRV;
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143627);
    ae.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
    this.kRV = ((r)paramCONTEXT.as(r.class));
    if (this.kRV == null)
    {
      ae.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
      paramCONTEXT.h(paramInt, e("fail:location update not enabled", null));
      AppMethodBeat.o(143627);
      return;
    }
    this.kRV.blo();
    paramCONTEXT.h(paramInt, e("ok", null));
    AppMethodBeat.o(143627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */