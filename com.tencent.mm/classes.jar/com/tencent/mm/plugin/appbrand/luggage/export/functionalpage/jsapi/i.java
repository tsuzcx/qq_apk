package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m.q;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenLocation;", "()V", "invoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends q
{
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(320098);
    if (paramf == null) {}
    for (Context localContext = null;; localContext = paramf.getContext())
    {
      d.b(localContext, (b)new a(this, paramJSONObject, paramf, paramInt));
      AppMethodBeat.o(320098);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<MMActivity, ah>
  {
    a(i parami, JSONObject paramJSONObject, f paramf, int paramInt)
    {
      super();
    }
    
    private static final void a(f paramf, int paramInt1, i parami, MMActivity paramMMActivity, int paramInt2, int paramInt3, Intent paramIntent)
    {
      AppMethodBeat.i(320080);
      s.u(parami, "this$0");
      s.u(paramMMActivity, "$activity");
      if (paramf != null) {
        paramf.callback(paramInt1, parami.ZP("ok"));
      }
      paramMMActivity.finish();
      AppMethodBeat.o(320080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.i
 * JD-Core Version:    0.7.0.1
 */