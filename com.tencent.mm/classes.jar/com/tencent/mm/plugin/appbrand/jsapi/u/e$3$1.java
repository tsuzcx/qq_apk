package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$3$1
  implements u.a
{
  e$3$1(e.3 param3) {}
  
  public final void Dc(String paramString)
  {
    AppMethodBeat.i(17029);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(17029);
      return;
    }
    e.c(this.ihn.ihi, paramString);
    AppMethodBeat.o(17029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.3.1
 * JD-Core Version:    0.7.0.1
 */