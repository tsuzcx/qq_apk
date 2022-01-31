package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class FavoriteVoiceDetailUI$2$2$1$1
  implements Runnable
{
  FavoriteVoiceDetailUI$2$2$1$1(FavoriteVoiceDetailUI.2.2.1 param1, p paramp, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    this.kgN.kgK.kgJ.kgI.keY.jYQ = true;
    this.kfC.dismiss();
    y.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(this.kgL), Long.valueOf(this.kgM) });
    this.kgN.kgK.kgJ.kgI.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */