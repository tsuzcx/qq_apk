package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;

final class FavoriteFileDetailUI$8
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteFileDetailUI$8(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    m.a(m.a.jZk, FavoriteFileDetailUI.b(this.kfu));
    this.kfu.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.8
 * JD-Core Version:    0.7.0.1
 */