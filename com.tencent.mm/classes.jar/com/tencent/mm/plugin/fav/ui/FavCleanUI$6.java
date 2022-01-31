package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class FavCleanUI$6
  implements f
{
  FavCleanUI$6(FavCleanUI paramFavCleanUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
    if (FavCleanUI.f(this.kbE) != null) {
      FavCleanUI.f(this.kbE).kjh = b.aPL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.6
 * JD-Core Version:    0.7.0.1
 */