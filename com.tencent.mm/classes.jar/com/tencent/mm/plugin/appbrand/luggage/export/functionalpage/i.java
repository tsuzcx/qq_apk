package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalPageAuthorizePresenterViewsFactory;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "()V", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "plugin-appbrand-integration_release"})
public final class i
  implements a.b, b.b
{
  public static final i lSW;
  
  static
  {
    AppMethodBeat.i(223618);
    lSW = new i();
    AppMethodBeat.o(223618);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b a(d paramd, b.c paramc)
  {
    AppMethodBeat.i(223616);
    p.h(paramd, "component");
    p.h(paramc, "listener");
    paramd = (com.tencent.mm.plugin.appbrand.permission.a.b)new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b(paramd, paramc);
    AppMethodBeat.o(223616);
    return paramd;
  }
  
  public final a e(d paramd)
  {
    AppMethodBeat.i(223617);
    p.h(paramd, "component");
    paramd = (a)new c(paramd);
    AppMethodBeat.o(223617);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */