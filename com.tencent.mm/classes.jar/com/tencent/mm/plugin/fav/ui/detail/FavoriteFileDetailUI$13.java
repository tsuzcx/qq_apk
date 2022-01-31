package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class FavoriteFileDetailUI$13
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteFileDetailUI$13(FavoriteFileDetailUI paramFavoriteFileDetailUI, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (this.kfy)
    {
      FavoriteFileDetailUI.j(this.kfu);
      if ((!k.h(FavoriteFileDetailUI.a(this.kfu))) && (FavoriteFileDetailUI.a(this.kfu).sVO == 0)) {}
    }
    else if (!this.kfz)
    {
      return false;
    }
    paramMenuItem = new d(this.kfu.mController.uMN, 1, false);
    paramMenuItem.phH = new FavoriteFileDetailUI.13.1(this);
    paramMenuItem.phI = new FavoriteFileDetailUI.13.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13
 * JD-Core Version:    0.7.0.1
 */