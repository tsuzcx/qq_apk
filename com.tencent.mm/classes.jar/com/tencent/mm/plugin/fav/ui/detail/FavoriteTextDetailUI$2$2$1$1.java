package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class FavoriteTextDetailUI$2$2$1$1
  implements Runnable
{
  FavoriteTextDetailUI$2$2$1$1(FavoriteTextDetailUI.2.2.1 param1, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(74439);
    this.mBf.mBe.mBd.mBc.mzH.mtj = true;
    this.mAo.dismiss();
    ab.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteTextDetailUI.b(this.mBf.mBe.mBd.mBc)) });
    this.mBf.mBe.mBd.mBc.finish();
    AppMethodBeat.o(74439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.2.1.1
 * JD-Core Version:    0.7.0.1
 */