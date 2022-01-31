package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteSightDetailUI$3
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteSightDetailUI$3(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74414);
    this.mAS.finish();
    AppMethodBeat.o(74414);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.3
 * JD-Core Version:    0.7.0.1
 */