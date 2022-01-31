package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class FavoriteSightDetailUI$4
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteSightDetailUI$4(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.kgg.mController.uMN, 1, false);
    paramMenuItem.phH = new FavoriteSightDetailUI.4.1(this);
    paramMenuItem.phI = new FavoriteSightDetailUI.4.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4
 * JD-Core Version:    0.7.0.1
 */