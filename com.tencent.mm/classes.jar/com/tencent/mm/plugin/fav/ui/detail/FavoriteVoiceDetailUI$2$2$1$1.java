package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class FavoriteVoiceDetailUI$2$2$1$1
  implements Runnable
{
  FavoriteVoiceDetailUI$2$2$1$1(FavoriteVoiceDetailUI.2.2.1 param1, p paramp, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(74480);
    this.mBB.mBy.mBx.mBw.mzH.mtj = true;
    this.mAo.dismiss();
    ab.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(this.mBz), Long.valueOf(this.mBA) });
    this.mBB.mBy.mBx.mBw.finish();
    AppMethodBeat.o(74480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */