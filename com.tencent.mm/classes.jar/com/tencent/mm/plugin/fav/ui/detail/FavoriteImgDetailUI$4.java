package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class FavoriteImgDetailUI$4
  implements Runnable
{
  FavoriteImgDetailUI$4(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void run()
  {
    Bitmap localBitmap2 = l.a(this.kfR.bNt, FavoriteImgDetailUI.b(this.kfM), false);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      y.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
      localBitmap1 = FavoriteImgDetailUI.a(this.kfM, this.kfR.bNt);
    }
    ai.d(new FavoriteImgDetailUI.4.1(this, localBitmap1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.4
 * JD-Core Version:    0.7.0.1
 */