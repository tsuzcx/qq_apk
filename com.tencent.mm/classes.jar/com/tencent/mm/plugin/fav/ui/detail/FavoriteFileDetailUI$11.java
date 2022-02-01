package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.ui.b.a;

final class FavoriteFileDetailUI$11
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteFileDetailUI$11(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(107126);
    m.a(m.a.qIW, FavoriteFileDetailUI.b(this.qQl));
    if ((FavoriteFileDetailUI.c(this.qQl) != null) && (FavoriteFileDetailUI.c(this.qQl).rT(1)))
    {
      AppMethodBeat.o(107126);
      return true;
    }
    this.qQl.finish();
    AppMethodBeat.o(107126);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.11
 * JD-Core Version:    0.7.0.1
 */