package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.d;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements Runnable
{
  a$2(a parama, v paramv) {}
  
  public final void run()
  {
    AppMethodBeat.i(140065);
    d locald = this.iiz.iuy.getFullscreenImpl();
    if (locald != null)
    {
      locald.aIJ();
      ab.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
      AppMethodBeat.o(140065);
      return;
    }
    ab.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
    AppMethodBeat.o(140065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.a.2
 * JD-Core Version:    0.7.0.1
 */