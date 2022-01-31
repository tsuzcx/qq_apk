package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class FavBaseUI$3
  implements k.a
{
  long mvL = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(73928);
    this.mvK.mqF.removeCallbacks(FavBaseUI.h(this.mvK));
    if (bo.av(this.mvL) > 200L)
    {
      this.mvL = bo.yB();
      this.mvK.mqF.post(FavBaseUI.h(this.mvK));
      AppMethodBeat.o(73928);
      return;
    }
    this.mvK.mqF.postDelayed(FavBaseUI.h(this.mvK), 200L);
    AppMethodBeat.o(73928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */