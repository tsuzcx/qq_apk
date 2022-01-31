package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.platformtools.y;

final class FavBaseUI$8
  implements f
{
  FavBaseUI$8(FavBaseUI paramFavBaseUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
    if (((aj)paramm).jZT)
    {
      y.i("MicroMsg.FavoriteBaseUI", "need batch get return");
      return;
    }
    y.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
    if (FavBaseUI.c(this.kbo)) {
      FavBaseUI.d(this.kbo);
    }
    this.kbo.fU(false);
    this.kbo.aRc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.8
 * JD-Core Version:    0.7.0.1
 */