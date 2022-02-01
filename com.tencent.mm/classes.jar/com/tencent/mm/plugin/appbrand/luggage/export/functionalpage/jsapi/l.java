package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPrivateOpenUrl;", "()V", "startWebViewUI", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class l
  extends ck
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  @Deprecated
  public static final l.a qbU;
  
  static
  {
    AppMethodBeat.i(274788);
    qbU = new l.a((byte)0);
    AppMethodBeat.o(274788);
  }
  
  public final void a(Context paramContext, final Intent paramIntent, final j paramj, final int paramInt)
  {
    AppMethodBeat.i(274785);
    p.k(paramIntent, "intent");
    p.k(paramj, "component");
    d.b(paramContext, (b)new b(this, paramj, paramInt, paramIntent));
    AppMethodBeat.o(274785);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class b
    extends q
    implements b<MMActivity, x>
  {
    b(l paraml, j paramj, int paramInt, Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */