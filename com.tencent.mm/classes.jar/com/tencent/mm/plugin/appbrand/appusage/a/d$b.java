package com.tencent.mm.plugin.appbrand.appusage.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apc;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
public final class d$b
  implements h.a
{
  public final void a(apc paramapc)
  {
    AppMethodBeat.i(134569);
    j.q(paramapc, "response");
    d.a(this.hds, paramapc);
    AppMethodBeat.o(134569);
  }
  
  public final void axS()
  {
    AppMethodBeat.i(134570);
    d.a(this.hds, 1, null, 6);
    AppMethodBeat.o(134570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d.b
 * JD-Core Version:    0.7.0.1
 */