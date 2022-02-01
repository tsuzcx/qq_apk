package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;

final class FavoriteFileDetailUI$12
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteFileDetailUI$12(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(107126);
    m.a(m.a.taP, FavoriteFileDetailUI.b(this.tie));
    if ((FavoriteFileDetailUI.c(this.tie) != null) && (FavoriteFileDetailUI.c(this.tie).O(1, false)))
    {
      AppMethodBeat.o(107126);
      return true;
    }
    if ((FavoriteFileDetailUI.d(this.tie) != null) && (FavoriteFileDetailUI.d(this.tie).wu(1)))
    {
      AppMethodBeat.o(107126);
      return true;
    }
    this.tie.finish();
    AppMethodBeat.o(107126);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.12
 * JD-Core Version:    0.7.0.1
 */