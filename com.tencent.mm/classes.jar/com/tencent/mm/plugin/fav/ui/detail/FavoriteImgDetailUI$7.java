package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class FavoriteImgDetailUI$7
  implements Runnable
{
  FavoriteImgDetailUI$7(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(74384);
    Bitmap localBitmap2 = l.a(this.mAB.cuL, FavoriteImgDetailUI.b(this.mAv), false);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      ab.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
      localBitmap1 = FavoriteImgDetailUI.a(this.mAv, this.mAB.cuL);
    }
    al.d(new FavoriteImgDetailUI.7.1(this, localBitmap1));
    AppMethodBeat.o(74384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.7
 * JD-Core Version:    0.7.0.1
 */