package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.l;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class API_openWeAppSearch$b$b
  implements Runnable
{
  API_openWeAppSearch$b$b(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143892);
    if (this.ibn.value)
    {
      AppMethodBeat.o(143892);
      return;
    }
    Intent localIntent = ((a)g.E(a.class)).E(ah.getContext(), this.ibp.ibk);
    API_openWeAppSearch.b.a locala = this.ibq;
    API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult localIPC_AppBrandSearchUIParamsPrepareResult = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
    localIPC_AppBrandSearchUIParamsPrepareResult.bpE = -1;
    localIPC_AppBrandSearchUIParamsPrepareResult.intent = localIntent;
    locala.a(localIPC_AppBrandSearchUIParamsPrepareResult);
    AppMethodBeat.o(143892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.b.b
 * JD-Core Version:    0.7.0.1
 */