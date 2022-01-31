package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavoriteImgDetailUI$3$2$1$1
  implements Runnable
{
  FavoriteImgDetailUI$3$2$1$1(FavoriteImgDetailUI.3.2.1 param1, p paramp) {}
  
  public final void run()
  {
    this.kfQ.kfP.kfO.kfM.keY.jYQ = true;
    this.kfC.dismiss();
    y.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(this.kfQ.kfP.kfO.kfM).field_localId) });
    this.kfQ.kfP.kfO.kfM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3.2.1.1
 * JD-Core Version:    0.7.0.1
 */