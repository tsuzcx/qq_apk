package com.tencent.mm.plugin.fav.ui.detail;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.ui.tools.e;

final class FavoriteVideoPlayUI$4
  implements ViewTreeObserver.OnPreDrawListener
{
  FavoriteVideoPlayUI$4(FavoriteVideoPlayUI paramFavoriteVideoPlayUI) {}
  
  public final boolean onPreDraw()
  {
    FavoriteVideoPlayUI.e(this.kgD).getViewTreeObserver().removeOnPreDrawListener(this);
    FavoriteVideoPlayUI.g(this.kgD).a(FavoriteVideoPlayUI.e(this.kgD), FavoriteVideoPlayUI.f(this.kgD), new FavoriteVideoPlayUI.4.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.4
 * JD-Core Version:    0.7.0.1
 */