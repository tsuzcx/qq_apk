package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteSightDetailUI$4
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteSightDetailUI$4(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74419);
    paramMenuItem = new d(this.mAS.getContext(), 1, false);
    paramMenuItem.sao = new FavoriteSightDetailUI.4.1(this);
    paramMenuItem.sap = new FavoriteSightDetailUI.4.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(74419);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4
 * JD-Core Version:    0.7.0.1
 */