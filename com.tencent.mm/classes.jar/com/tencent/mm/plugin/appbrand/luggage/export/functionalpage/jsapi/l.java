package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cl;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPrivateOpenUrl;", "()V", "startWebViewUI", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class l
  extends cl
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  @Deprecated
  public static final a nbG;
  
  static
  {
    AppMethodBeat.i(228925);
    nbG = new a((byte)0);
    AppMethodBeat.o(228925);
  }
  
  public final void a(Context paramContext, final Intent paramIntent, final k paramk, final int paramInt)
  {
    AppMethodBeat.i(228924);
    p.h(paramIntent, "intent");
    p.h(paramk, "component");
    d.b(paramContext, (b)new b(this, paramk, paramInt, paramIntent));
    AppMethodBeat.o(228924);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class b
    extends q
    implements b<MMActivity, x>
  {
    b(l paraml, k paramk, int paramInt, Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */