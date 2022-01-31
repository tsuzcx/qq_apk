package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.sdk.platformtools.ab;

final class FavoriteIndexUI$18
  implements f
{
  FavoriteIndexUI$18(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(74245);
    ab.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
    this.myP.mvA.post(new FavoriteIndexUI.18.1(this));
    AppMethodBeat.o(74245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.18
 * JD-Core Version:    0.7.0.1
 */