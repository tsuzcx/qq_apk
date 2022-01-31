package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.platformtools.ab;

final class FavBaseUI$8
  implements f
{
  FavBaseUI$8(FavBaseUI paramFavBaseUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(73933);
    ab.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
    if (((aj)paramm).muq)
    {
      ab.i("MicroMsg.FavoriteBaseUI", "need batch get return");
      AppMethodBeat.o(73933);
      return;
    }
    ab.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
    if (FavBaseUI.c(this.mvK)) {
      FavBaseUI.d(this.mvK);
    }
    this.mvK.hy(false);
    this.mvK.bxq();
    AppMethodBeat.o(73933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.8
 * JD-Core Version:    0.7.0.1
 */