package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.sdk.platformtools.y;

final class FavoriteIndexUI$12
  implements f
{
  FavoriteIndexUI$12(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
    this.kee.kbe.post(new FavoriteIndexUI.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.12
 * JD-Core Version:    0.7.0.1
 */