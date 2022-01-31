package com.tencent.mm.plugin.fav.ui.detail;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.ui.tools.e;

final class FavoriteVideoPlayUI$4
  implements ViewTreeObserver.OnPreDrawListener
{
  FavoriteVideoPlayUI$4(FavoriteVideoPlayUI paramFavoriteVideoPlayUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(74463);
    FavoriteVideoPlayUI.e(this.mBr).getViewTreeObserver().removeOnPreDrawListener(this);
    FavoriteVideoPlayUI.g(this.mBr).a(FavoriteVideoPlayUI.e(this.mBr), FavoriteVideoPlayUI.f(this.mBr), new FavoriteVideoPlayUI.4.1(this));
    AppMethodBeat.o(74463);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.4
 * JD-Core Version:    0.7.0.1
 */