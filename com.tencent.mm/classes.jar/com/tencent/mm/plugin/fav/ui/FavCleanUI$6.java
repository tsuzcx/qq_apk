package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class FavCleanUI$6
  implements f
{
  FavCleanUI$6(FavCleanUI paramFavCleanUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(73958);
    ab.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
    if (FavCleanUI.f(this.mwa) != null) {
      FavCleanUI.f(this.mwa).mDN = b.bvZ();
    }
    AppMethodBeat.o(73958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.6
 * JD-Core Version:    0.7.0.1
 */