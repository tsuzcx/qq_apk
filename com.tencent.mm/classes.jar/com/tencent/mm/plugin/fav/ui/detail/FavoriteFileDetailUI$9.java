package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;

final class FavoriteFileDetailUI$9
  implements View.OnClickListener
{
  FavoriteFileDetailUI$9(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = b.b(FavoriteFileDetailUI.a(this.kfu));
    if (4 == FavoriteFileDetailUI.c(this.kfu))
    {
      FavoriteFileDetailUI.d(this.kfu);
      FavoriteFileDetailUI.e(this.kfu);
      return;
    }
    FavoriteFileDetailUI.a(this.kfu, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.9
 * JD-Core Version:    0.7.0.1
 */