package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

final class FavBaseUI$3
  implements k.a
{
  long qLw = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(106613);
    ac.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramString });
    this.qLv.qFN.removeCallbacks(FavBaseUI.h(this.qLv));
    if (bs.aO(this.qLw) > 200L)
    {
      this.qLw = bs.Gn();
      this.qLv.qFN.post(FavBaseUI.h(this.qLv));
      AppMethodBeat.o(106613);
      return;
    }
    this.qLv.qFN.postDelayed(FavBaseUI.h(this.qLv), 200L);
    AppMethodBeat.o(106613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */