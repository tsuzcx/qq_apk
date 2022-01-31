package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.protocal.c.xv;
import java.util.HashMap;

final class FavoriteImgDetailUI$6
  implements View.OnLongClickListener
{
  FavoriteImgDetailUI$6(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = (xv)paramView.getTag();
    paramView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(this.kfM).get(paramView.kgC);
    FavoriteImgDetailUI.a(this.kfM, paramView);
    if (!paramView.kfU) {
      FavoriteImgDetailUI.b(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.6
 * JD-Core Version:    0.7.0.1
 */