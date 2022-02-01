package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

final class FavBaseUI$3
  implements k.a
{
  long rDK = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(106613);
    ae.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramString });
    this.rDJ.rxJ.removeCallbacks(FavBaseUI.h(this.rDJ));
    if (bu.aO(this.rDK) > 200L)
    {
      this.rDK = bu.HQ();
      this.rDJ.rxJ.post(FavBaseUI.h(this.rDJ));
      AppMethodBeat.o(106613);
      return;
    }
    this.rDJ.rxJ.postDelayed(FavBaseUI.h(this.rDJ), 200L);
    AppMethodBeat.o(106613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */