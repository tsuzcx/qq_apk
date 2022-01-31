package com.tencent.luggage.game.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements n.a
{
  a$3(a parama, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140425);
    ab.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
    this.bBl.vf();
    AppMethodBeat.o(140425);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140424);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(this.bBm) });
    this.bBl.a(this.bBn, this.bBo, this.bBm);
    AppMethodBeat.o(140424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.a.3
 * JD-Core Version:    0.7.0.1
 */