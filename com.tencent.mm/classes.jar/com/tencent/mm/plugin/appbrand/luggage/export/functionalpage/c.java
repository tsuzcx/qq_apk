package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "invokeProcess", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "onCallback", "", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "", "data", "", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "isFromNewSdk", "", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  public static final a lOr;
  public o lOp;
  final l lOq;
  
  static
  {
    AppMethodBeat.i(189353);
    lOr = new a((byte)0);
    AppMethodBeat.o(189353);
  }
  
  public c(l paraml)
  {
    AppMethodBeat.i(50863);
    this.lOq = paraml;
    AppMethodBeat.o(50863);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(50861);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    o localo = this.lOp;
    if (localo == null) {
      d.g.b.p.bcb("invokeProcess");
    }
    localo.a(paramp, paramInt, paramString);
    AppMethodBeat.o(50861);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c
 * JD-Core Version:    0.7.0.1
 */