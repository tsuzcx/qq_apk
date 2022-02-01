package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$5
  implements z.a
{
  c$5(c paramc) {}
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(321540);
    Log.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
    AppMethodBeat.o(321540);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(321537);
    Log.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
    AppMethodBeat.o(321537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c.5
 * JD-Core Version:    0.7.0.1
 */