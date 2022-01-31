package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavSelectUI$2(FavSelectUI paramFavSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74102);
    paramMenuItem = new Intent();
    FavSelectUI.a(this.mxN, paramMenuItem);
    AppMethodBeat.o(74102);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI.2
 * JD-Core Version:    0.7.0.1
 */