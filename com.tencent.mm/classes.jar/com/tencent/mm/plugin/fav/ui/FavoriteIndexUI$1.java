package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.b;

final class FavoriteIndexUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteIndexUI$1(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74219);
    if (FavoriteIndexUI.a(this.myP).mzp)
    {
      FavoriteIndexUI.b(this.myP);
      AppMethodBeat.o(74219);
      return true;
    }
    this.myP.finish();
    AppMethodBeat.o(74219);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.1
 * JD-Core Version:    0.7.0.1
 */