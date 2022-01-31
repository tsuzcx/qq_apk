package com.tencent.luggage.game.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements n.a
{
  a$2(a parama) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140423);
    ab.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramString });
    AppMethodBeat.o(140423);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140422);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramString });
    AppMethodBeat.o(140422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.a.2
 * JD-Core Version:    0.7.0.1
 */