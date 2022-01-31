package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;

final class b$4
  implements n.a
{
  b$4(b paramb, String paramString, long paramLong) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140730);
    ((c)b.c(this.bEH)).a("WAService.js", this.bEJ, false, this.bBo, System.currentTimeMillis());
    AppMethodBeat.o(140730);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140729);
    ((c)b.b(this.bEH)).a("WAService.js", this.bEJ, true, this.bBo, System.currentTimeMillis());
    AppMethodBeat.o(140729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.4
 * JD-Core Version:    0.7.0.1
 */