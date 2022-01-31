package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class FavoriteFileDetailUI$16$2$2$1
  implements Runnable
{
  FavoriteFileDetailUI$16$2$2$1(FavoriteFileDetailUI.16.2.2 param2, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(74340);
    this.mAp.mAn.mAm.mAf.mzH.mtj = true;
    this.mAo.dismiss();
    ab.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(this.mAp.mAn.mAm.mAf).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.mAp.mAn.mAm.mAf).field_id) });
    this.mAp.mAn.mAm.mAf.finish();
    AppMethodBeat.o(74340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.16.2.2.1
 * JD-Core Version:    0.7.0.1
 */