package com.tencent.mm.plugin.appbrand.jsapi;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.e.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onReady"})
final class bu$d
  implements e.a
{
  bu$d(bu parambu, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  
  public final void onReady()
  {
    AppMethodBeat.i(143743);
    if (e.aLL() != null) {}
    for (boolean bool = true;; bool = false)
    {
      bu.aBG();
      com.tencent.luggage.g.d.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
      if (!bool) {
        break;
      }
      this.hAK.h(this.hAB, this.hAJ.BL("ok"));
      AppMethodBeat.o(143743);
      return;
    }
    this.hAK.h(this.hAB, this.hAJ.BL("fail"));
    AppMethodBeat.o(143743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bu.d
 * JD-Core Version:    0.7.0.1
 */