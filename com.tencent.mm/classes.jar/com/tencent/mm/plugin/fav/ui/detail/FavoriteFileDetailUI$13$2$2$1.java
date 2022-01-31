package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavoriteFileDetailUI$13$2$2$1
  implements Runnable
{
  FavoriteFileDetailUI$13$2$2$1(FavoriteFileDetailUI.13.2.2 param2, p paramp) {}
  
  public final void run()
  {
    this.kfD.kfB.kfA.kfu.keY.jYQ = true;
    this.kfC.dismiss();
    y.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(this.kfD.kfB.kfA.kfu).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.kfD.kfB.kfA.kfu).field_id) });
    this.kfD.kfB.kfA.kfu.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.2.2.1
 * JD-Core Version:    0.7.0.1
 */