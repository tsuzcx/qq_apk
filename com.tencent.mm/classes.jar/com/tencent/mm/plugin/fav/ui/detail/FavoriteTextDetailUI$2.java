package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class FavoriteTextDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteTextDetailUI$2(FavoriteTextDetailUI paramFavoriteTextDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.kgq.mController.uMN, 1, false);
    paramMenuItem.phH = new FavoriteTextDetailUI.2.1(this);
    paramMenuItem.phI = new FavoriteTextDetailUI.2.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2
 * JD-Core Version:    0.7.0.1
 */