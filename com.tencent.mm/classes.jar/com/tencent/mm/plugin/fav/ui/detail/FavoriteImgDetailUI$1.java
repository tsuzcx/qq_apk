package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteImgDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteImgDetailUI$1(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74374);
    this.mAv.finish();
    AppMethodBeat.o(74374);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.1
 * JD-Core Version:    0.7.0.1
 */