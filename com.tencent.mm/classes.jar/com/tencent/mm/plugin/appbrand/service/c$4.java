package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$4
  implements n.a
{
  c$4(c paramc) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(143551);
    ab.e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
    AppMethodBeat.o(143551);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(143550);
    ab.i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
    AppMethodBeat.o(143550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c.4
 * JD-Core Version:    0.7.0.1
 */