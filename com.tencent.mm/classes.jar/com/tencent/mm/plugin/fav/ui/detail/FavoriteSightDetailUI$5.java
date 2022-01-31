package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

final class FavoriteSightDetailUI$5
  implements Runnable
{
  FavoriteSightDetailUI$5(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74420);
    if ((FavoriteSightDetailUI.a(this.mAS).isDone()) && (b.f(FavoriteSightDetailUI.b(this.mAS))) && (FavoriteSightDetailUI.d(this.mAS) != null) && (FavoriteSightDetailUI.d(this.mAS).isPlaying()))
    {
      AppMethodBeat.o(74420);
      return;
    }
    FavoriteSightDetailUI.a(this.mAS, true);
    AppMethodBeat.o(74420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.5
 * JD-Core Version:    0.7.0.1
 */