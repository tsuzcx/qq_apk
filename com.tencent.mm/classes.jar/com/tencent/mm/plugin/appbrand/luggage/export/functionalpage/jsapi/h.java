package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenLocation;", "()V", "invoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "plugin-appbrand-integration_release"})
public final class h
  extends o
{
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(223691);
    if (paramc != null) {}
    for (Context localContext = paramc.getContext();; localContext = null)
    {
      d.b(localContext, (b)new a(this, paramc, paramInt, paramJSONObject));
      AppMethodBeat.o(223691);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements b<MMActivity, z>
  {
    a(h paramh, c paramc, int paramInt, JSONObject paramJSONObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */