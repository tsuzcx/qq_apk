package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.ui.tools.e.b;

final class FavoriteVideoPlayUI$4$1
  implements e.b
{
  FavoriteVideoPlayUI$4$1(FavoriteVideoPlayUI.4 param4) {}
  
  public final void onAnimationEnd() {}
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(74462);
    if (FavoriteVideoPlayUI.e(this.mBt.mBr) != null) {
      FavoriteVideoPlayUI.e(this.mBt.mBr).onResume();
    }
    AppMethodBeat.o(74462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.4.1
 * JD-Core Version:    0.7.0.1
 */