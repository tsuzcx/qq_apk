package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.o;
import d.g.a.b;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenLocation;", "()V", "invoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "plugin-appbrand-integration_release"})
public final class h
  extends o
{
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(189431);
    if (paramc != null) {}
    for (Context localContext = paramc.getContext();; localContext = null)
    {
      d.b(localContext, (b)new h.a(this, paramc, paramInt, paramJSONObject));
      AppMethodBeat.o(189431);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */