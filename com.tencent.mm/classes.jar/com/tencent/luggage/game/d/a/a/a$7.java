package com.tencent.luggage.game.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.sdk.platformtools.Log;

final class a$7
  implements u.a
{
  a$7(a parama) {}
  
  public final void dL(String paramString)
  {
    AppMethodBeat.i(247427);
    Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramString });
    AppMethodBeat.o(247427);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(247425);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramString });
    AppMethodBeat.o(247425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.7
 * JD-Core Version:    0.7.0.1
 */