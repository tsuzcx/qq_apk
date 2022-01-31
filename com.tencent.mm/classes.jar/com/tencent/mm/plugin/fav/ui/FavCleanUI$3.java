package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FavCleanUI$3
  implements d.a
{
  FavCleanUI$3(FavCleanUI paramFavCleanUI) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(73951);
    ab.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
    FavCleanUI.c(this.mwa);
    FavCleanUI.d(this.mwa);
    AppMethodBeat.o(73951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.3
 * JD-Core Version:    0.7.0.1
 */