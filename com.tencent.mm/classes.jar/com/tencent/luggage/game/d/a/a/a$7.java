package com.tencent.luggage.game.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$7
  implements q.a
{
  a$7(a parama) {}
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(190408);
    ad.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramString });
    AppMethodBeat.o(190408);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(190407);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramString });
    AppMethodBeat.o(190407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.7
 * JD-Core Version:    0.7.0.1
 */