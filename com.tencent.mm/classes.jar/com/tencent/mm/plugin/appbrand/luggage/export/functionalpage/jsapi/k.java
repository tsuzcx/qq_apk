package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPrivateOpenUrl;", "()V", "startWebViewUI", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class k
  extends bx
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  @Deprecated
  public static final a lTY;
  
  static
  {
    AppMethodBeat.i(223702);
    lTY = new a((byte)0);
    AppMethodBeat.o(223702);
  }
  
  public final void a(Context paramContext, final Intent paramIntent, final h paramh, final int paramInt)
  {
    AppMethodBeat.i(223701);
    p.h(paramIntent, "intent");
    p.h(paramh, "component");
    d.b(paramContext, (b)new b(this, paramh, paramInt, paramIntent));
    AppMethodBeat.o(223701);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class b
    extends q
    implements b<MMActivity, z>
  {
    b(k paramk, h paramh, int paramInt, Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */