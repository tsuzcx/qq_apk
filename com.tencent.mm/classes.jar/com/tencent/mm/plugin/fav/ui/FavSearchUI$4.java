package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;

final class FavSearchUI$4
  implements Runnable
{
  FavSearchUI$4(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74068);
    if (FavSearchUI.a(this.mxx) <= 0)
    {
      FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.mxx);
      if (localFavSearchActionView.mya != null) {
        localFavSearchActionView.mya.dEn();
      }
      this.mxx.showVKB();
    }
    AppMethodBeat.o(74068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.4
 * JD-Core Version:    0.7.0.1
 */