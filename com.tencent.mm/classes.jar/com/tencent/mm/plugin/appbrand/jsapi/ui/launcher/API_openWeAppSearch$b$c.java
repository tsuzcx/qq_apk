package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PBool;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
final class API_openWeAppSearch$b$c
  implements f
{
  API_openWeAppSearch$b$c(PBool paramPBool, API_openWeAppSearch.b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(143893);
    if (this.ibn.value)
    {
      AppMethodBeat.o(143893);
      return;
    }
    paramString = g.E(com.tencent.mm.plugin.websearch.api.m.class);
    j.p(paramString, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
    if (!((com.tencent.mm.plugin.websearch.api.m)paramString).cYX())
    {
      paramString = this.ibq;
      paramm = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
      paramm.bpE = 1;
      paramString.a(paramm);
    }
    AppMethodBeat.o(143893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.b.c
 * JD-Core Version:    0.7.0.1
 */