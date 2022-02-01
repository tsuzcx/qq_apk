package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "invokeProcess", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "onCallback", "", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "", "data", "", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "isFromNewSdk", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a tfM;
  final l tfN;
  public o tfO;
  
  static
  {
    AppMethodBeat.i(320011);
    tfM = new a((byte)0);
    AppMethodBeat.o(320011);
  }
  
  public c(l paraml)
  {
    AppMethodBeat.i(50863);
    this.tfN = paraml;
    AppMethodBeat.o(50863);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(50861);
    s.u(paramp, "component");
    s.u(paramString, "data");
    o localo2 = this.tfO;
    o localo1 = localo2;
    if (localo2 == null)
    {
      s.bIx("invokeProcess");
      localo1 = null;
    }
    localo1.a(paramp, paramInt, paramString);
    AppMethodBeat.o(50861);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c
 * JD-Core Version:    0.7.0.1
 */