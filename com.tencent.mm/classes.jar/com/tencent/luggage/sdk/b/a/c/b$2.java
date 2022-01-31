package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;

final class b$2
  implements n.a
{
  b$2(b paramb, String paramString, long paramLong) {}
  
  private void bd(boolean paramBoolean)
  {
    AppMethodBeat.i(140726);
    ((c)b.a(this.bEH)).a("app-service.js", this.bEI, paramBoolean, this.bBo, System.currentTimeMillis());
    AppMethodBeat.o(140726);
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140725);
    bd(false);
    AppMethodBeat.o(140725);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140724);
    bd(true);
    AppMethodBeat.o(140724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.2
 * JD-Core Version:    0.7.0.1
 */