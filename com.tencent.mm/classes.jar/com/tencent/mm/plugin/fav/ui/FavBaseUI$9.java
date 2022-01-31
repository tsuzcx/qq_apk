package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class FavBaseUI$9
  implements f
{
  FavBaseUI$9(FavBaseUI paramFavBaseUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FavoriteBaseUI", "on batch get end");
    if (FavBaseUI.c(this.kbo))
    {
      y.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
      FavBaseUI.d(this.kbo);
      this.kbo.fU(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.9
 * JD-Core Version:    0.7.0.1
 */