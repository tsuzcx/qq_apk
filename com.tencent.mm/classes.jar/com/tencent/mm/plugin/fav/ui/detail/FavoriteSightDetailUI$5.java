package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

final class FavoriteSightDetailUI$5
  implements Runnable
{
  FavoriteSightDetailUI$5(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final void run()
  {
    if ((FavoriteSightDetailUI.a(this.kgg).isDone()) && (b.f(FavoriteSightDetailUI.b(this.kgg))) && (FavoriteSightDetailUI.d(this.kgg) != null) && (FavoriteSightDetailUI.d(this.kgg).isPlaying())) {
      return;
    }
    FavoriteSightDetailUI.a(this.kgg, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.5
 * JD-Core Version:    0.7.0.1
 */