package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class FavBaseUI$9
  implements f
{
  FavBaseUI$9(FavBaseUI paramFavBaseUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(73934);
    ab.i("MicroMsg.FavoriteBaseUI", "on batch get end");
    if (FavBaseUI.c(this.mvK))
    {
      ab.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
      FavBaseUI.d(this.mvK);
      this.mvK.hy(false);
    }
    AppMethodBeat.o(73934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.9
 * JD-Core Version:    0.7.0.1
 */