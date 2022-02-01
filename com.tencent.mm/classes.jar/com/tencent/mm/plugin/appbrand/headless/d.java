package com.tencent.mm.plugin.appbrand.headless;

import android.content.Context;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.cb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/HeadlessPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "component", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "context", "Landroid/content/Context;", "onLoadURL", "", "url", "", "openType", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.page.a<ah>
{
  public d(ah paramah)
  {
    super((c)paramah);
    AppMethodBeat.i(317548);
    AppMethodBeat.o(317548);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(317556);
    s.u(paramd, "this$0");
    paramd = (ah)paramd.aqX();
    if (paramd != null) {
      paramd.aeN("onLoadURL");
    }
    AppMethodBeat.o(317556);
  }
  
  public final boolean b(String paramString, cb paramcb)
  {
    AppMethodBeat.i(317577);
    paramString = (ah)aqX();
    if (paramString != null) {
      paramString.V(new d..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(317577);
    return true;
  }
  
  public final bd eC(Context paramContext)
  {
    AppMethodBeat.i(317568);
    s.u(paramContext, "context");
    paramContext = (bd)new com.tencent.luggage.game.page.a();
    AppMethodBeat.o(317568);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.d
 * JD-Core Version:    0.7.0.1
 */