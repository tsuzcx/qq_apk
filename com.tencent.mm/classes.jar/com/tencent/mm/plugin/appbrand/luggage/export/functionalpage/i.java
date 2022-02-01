package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.c;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.protocal.protobuf.eul;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalPageAuthorizePresenterViewsFactory;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "()V", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "scopeList", "", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements a.c, b.c
{
  public static final i tfS;
  
  static
  {
    AppMethodBeat.i(320036);
    tfS = new i();
    AppMethodBeat.o(320036);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b a(g paramg, b.d paramd, List<? extends eul> paramList)
  {
    AppMethodBeat.i(320041);
    s.u(paramg, "component");
    s.u(paramd, "listener");
    paramg = (com.tencent.mm.plugin.appbrand.permission.a.b)new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b(paramg, paramd);
    AppMethodBeat.o(320041);
    return paramg;
  }
  
  public final a e(g paramg)
  {
    AppMethodBeat.i(320048);
    s.u(paramg, "component");
    paramg = (a)new c(paramg);
    AppMethodBeat.o(320048);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */