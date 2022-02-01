package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 201;
  @Deprecated
  public static final String NAME = "openUrl";
  private static final j.a tgL;
  
  static
  {
    AppMethodBeat.i(320091);
    tgL = new j.a((byte)0);
    AppMethodBeat.o(320091);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<MMActivity, ah>
  {
    b(j paramj, g paramg, int paramInt, String paramString)
    {
      super();
    }
    
    private static final void a(g paramg, int paramInt1, j paramj, MMActivity paramMMActivity, int paramInt2, int paramInt3, Intent paramIntent)
    {
      AppMethodBeat.i(320141);
      s.u(paramj, "this$0");
      s.u(paramMMActivity, "$activity");
      if (paramg != null) {
        paramg.callback(paramInt1, paramj.ZP("ok"));
      }
      paramMMActivity.finish();
      AppMethodBeat.o(320141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */