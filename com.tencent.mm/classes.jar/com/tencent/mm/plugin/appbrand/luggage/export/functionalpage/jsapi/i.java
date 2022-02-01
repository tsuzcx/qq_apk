package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenLocation;", "()V", "invoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "plugin-appbrand-integration_release"})
public final class i
  extends p
{
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(228914);
    if (paramf != null) {}
    for (Context localContext = paramf.getContext();; localContext = null)
    {
      d.b(localContext, (b)new a(this, paramf, paramInt, paramJSONObject));
      AppMethodBeat.o(228914);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements b<MMActivity, x>
  {
    a(i parami, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.i
 * JD-Core Version:    0.7.0.1
 */