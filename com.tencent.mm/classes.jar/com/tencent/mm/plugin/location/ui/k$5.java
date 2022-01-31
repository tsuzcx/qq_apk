package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.c;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class k$5
  implements ap.a
{
  k$5(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(113534);
    if (this.oeg.odW == 3) {}
    for (int i = this.oeg.oec.akQ();; i = this.oeg.oec.akR())
    {
      k localk = this.oeg;
      float f2 = i;
      float f1 = f2;
      if (f2 < 10.0F) {
        f1 = 10.0F;
      }
      f2 = f1;
      if (f1 > 100.0F) {
        f2 = 100.0F;
      }
      localk.odP.setVolume(f2 / 100.0F);
      localk.odP.invalidate();
      AppMethodBeat.o(113534);
      return true;
      if (bo.isNullOrNil(this.oeg.odT))
      {
        AppMethodBeat.o(113534);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.5
 * JD-Core Version:    0.7.0.1
 */