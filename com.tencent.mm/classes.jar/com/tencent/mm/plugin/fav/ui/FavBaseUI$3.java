package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

final class FavBaseUI$3
  implements k.a
{
  long rvy = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(106613);
    ad.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramString });
    this.rvx.rpF.removeCallbacks(FavBaseUI.h(this.rvx));
    if (bt.aO(this.rvy) > 200L)
    {
      this.rvy = bt.HI();
      this.rvx.rpF.post(FavBaseUI.h(this.rvx));
      AppMethodBeat.o(106613);
      return;
    }
    this.rvx.rpF.postDelayed(FavBaseUI.h(this.rvx), 200L);
    AppMethodBeat.o(106613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */