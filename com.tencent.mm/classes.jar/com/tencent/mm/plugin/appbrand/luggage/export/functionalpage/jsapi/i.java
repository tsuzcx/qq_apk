package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends a<d>
{
  public static final int CTRL_INDEX = 201;
  public static final String NAME = "openUrl";
  @Deprecated
  public static final a lTU;
  
  static
  {
    AppMethodBeat.i(223695);
    lTU = new a((byte)0);
    AppMethodBeat.o(223695);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class b
    extends q
    implements b<MMActivity, z>
  {
    b(i parami, d paramd, int paramInt, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.i
 * JD-Core Version:    0.7.0.1
 */