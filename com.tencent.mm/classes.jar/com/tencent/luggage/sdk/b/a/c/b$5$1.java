package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;

final class b$5$1
  implements n.a
{
  b$5$1(b.5 param5, String paramString1, String paramString2, long paramLong) {}
  
  private void bd(boolean paramBoolean)
  {
    AppMethodBeat.i(140733);
    ((c)b.i(this.bEN.bEH)).a(this.bEL, this.byz, paramBoolean, this.bEM, System.currentTimeMillis());
    AppMethodBeat.o(140733);
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140732);
    bd(false);
    AppMethodBeat.o(140732);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140731);
    bd(true);
    AppMethodBeat.o(140731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.5.1
 * JD-Core Version:    0.7.0.1
 */