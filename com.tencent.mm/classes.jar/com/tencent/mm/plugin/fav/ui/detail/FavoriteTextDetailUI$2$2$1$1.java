package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavoriteTextDetailUI$2$2$1$1
  implements Runnable
{
  FavoriteTextDetailUI$2$2$1$1(FavoriteTextDetailUI.2.2.1 param1, p paramp) {}
  
  public final void run()
  {
    this.kgt.kgs.kgr.kgq.keY.jYQ = true;
    this.kfC.dismiss();
    y.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteTextDetailUI.b(this.kgt.kgs.kgr.kgq)) });
    this.kgt.kgs.kgr.kgq.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */