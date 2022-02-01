package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalPageAuthorizePresenterViewsFactory;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "()V", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "plugin-appbrand-integration_release"})
public final class i
  implements a.b, b.b
{
  public static final i nax;
  
  static
  {
    AppMethodBeat.i(228837);
    nax = new i();
    AppMethodBeat.o(228837);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b a(d paramd, b.c paramc)
  {
    AppMethodBeat.i(228835);
    p.h(paramd, "component");
    p.h(paramc, "listener");
    paramd = (com.tencent.mm.plugin.appbrand.permission.a.b)new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b(paramd, paramc);
    AppMethodBeat.o(228835);
    return paramd;
  }
  
  public final a e(d paramd)
  {
    AppMethodBeat.i(228836);
    p.h(paramd, "component");
    paramd = (a)new c(paramd);
    AppMethodBeat.o(228836);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */