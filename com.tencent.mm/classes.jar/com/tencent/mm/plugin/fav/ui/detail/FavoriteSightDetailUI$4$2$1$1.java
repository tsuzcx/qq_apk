package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavoriteSightDetailUI$4$2$1$1
  implements Runnable
{
  FavoriteSightDetailUI$4$2$1$1(FavoriteSightDetailUI.4.2.1 param1, p paramp) {}
  
  public final void run()
  {
    this.kgk.kgj.kgi.kgg.keY.jYQ = true;
    this.kfC.dismiss();
    y.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteSightDetailUI.a(this.kgk.kgj.kgi.kgg).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.kgk.kgj.kgi.kgg).field_id) });
    this.kgk.kgj.kgi.kgg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2.1.1
 * JD-Core Version:    0.7.0.1
 */