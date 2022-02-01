package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.c;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalPageAuthorizePresenterViewsFactory;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "()V", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "plugin-appbrand-integration_release"})
public final class i
  implements a.c, b.c
{
  public static final i qaM;
  
  static
  {
    AppMethodBeat.i(268862);
    qaM = new i();
    AppMethodBeat.o(268862);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b a(g paramg, b.d paramd)
  {
    AppMethodBeat.i(268857);
    p.k(paramg, "component");
    p.k(paramd, "listener");
    paramg = (com.tencent.mm.plugin.appbrand.permission.a.b)new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b(paramg, paramd);
    AppMethodBeat.o(268857);
    return paramg;
  }
  
  public final a f(g paramg)
  {
    AppMethodBeat.i(268859);
    p.k(paramg, "component");
    paramg = (a)new c(paramg);
    AppMethodBeat.o(268859);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */