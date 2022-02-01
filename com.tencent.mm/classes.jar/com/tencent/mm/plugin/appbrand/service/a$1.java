package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$1
  implements q.a
{
  a$1(a parama, d.a parama1, long paramLong, String paramString) {}
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(48239);
    this.mwi.a(this.lYs, false, this.cko, System.currentTimeMillis(), null);
    ad.e("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile inject name(%s) onFailure ret:%s", new Object[] { this.val$name, paramString });
    AppMethodBeat.o(48239);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(48238);
    this.mwi.a(this.lYs, true, this.cko, System.currentTimeMillis(), null);
    ad.i("MicroMsg.AppBrandJSContextInterfaceWC", "beforeEvaluateScriptFile inject name(%s) onSuccess ret:%s", new Object[] { this.val$name, paramString });
    AppMethodBeat.o(48238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a.1
 * JD-Core Version:    0.7.0.1
 */