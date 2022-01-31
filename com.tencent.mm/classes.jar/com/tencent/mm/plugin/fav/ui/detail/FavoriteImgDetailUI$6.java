package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteImgDetailUI$6
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteImgDetailUI$6(FavoriteImgDetailUI paramFavoriteImgDetailUI, long paramLong) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74381);
    paramMenuItem = new d(this.mAv.getContext(), 1, false);
    paramMenuItem.sao = new FavoriteImgDetailUI.6.1(this);
    paramMenuItem.sap = new FavoriteImgDetailUI.6.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(74381);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.6
 * JD-Core Version:    0.7.0.1
 */