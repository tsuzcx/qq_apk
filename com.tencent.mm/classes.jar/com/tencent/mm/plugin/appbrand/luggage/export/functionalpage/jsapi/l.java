package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPrivateOpenUrl;", "()V", "startWebViewUI", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends cp
{
  @Deprecated
  public static final int CTRL_INDEX = 406;
  @Deprecated
  public static final String NAME = "private_openUrl";
  private static final l.a tgO;
  
  static
  {
    AppMethodBeat.i(320106);
    tgO = new l.a((byte)0);
    AppMethodBeat.o(320106);
  }
  
  public final void a(Context paramContext, Intent paramIntent, final k paramk, final int paramInt)
  {
    AppMethodBeat.i(320114);
    s.u(paramIntent, "intent");
    s.u(paramk, "component");
    d.b(paramContext, (b)new b(paramIntent, this, paramk, paramInt));
    AppMethodBeat.o(320114);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "activity", "Lcom/tencent/mm/ui/MMActivity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<MMActivity, ah>
  {
    b(Intent paramIntent, l paraml, k paramk, int paramInt)
    {
      super();
    }
    
    private static final void a(k paramk, int paramInt1, l paraml, MMActivity paramMMActivity, int paramInt2, int paramInt3, Intent paramIntent)
    {
      AppMethodBeat.i(320145);
      s.u(paramk, "$component");
      s.u(paraml, "this$0");
      s.u(paramMMActivity, "$activity");
      paramk.callback(paramInt1, paraml.ZP("ok"));
      paramMMActivity.finish();
      AppMethodBeat.o(320145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */