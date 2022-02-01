package com.tencent.luggage.game.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.Log;

final class a$7
  implements z.a
{
  a$7(a parama) {}
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(220173);
    Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramString });
    AppMethodBeat.o(220173);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(220169);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramString });
    AppMethodBeat.o(220169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.7
 * JD-Core Version:    0.7.0.1
 */