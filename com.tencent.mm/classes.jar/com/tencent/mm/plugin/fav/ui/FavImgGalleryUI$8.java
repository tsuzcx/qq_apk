package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;

final class FavImgGalleryUI$8
  implements Runnable
{
  FavImgGalleryUI$8(FavImgGalleryUI paramFavImgGalleryUI, int paramInt) {}
  
  public final void run()
  {
    if (this.kbX != -1)
    {
      y.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[] { Integer.valueOf(this.kbX) });
      FavImgGalleryUI.a(this.kbW).setSelection(this.kbX);
      FavImgGalleryUI.a(this.kbW, this.kbX);
      return;
    }
    if ((FavImgGalleryUI.d(this.kbW) - 1 >= 0) && (FavImgGalleryUI.d(this.kbW) - 1 < FavImgGalleryUI.h(this.kbW).size()))
    {
      y.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.d(this.kbW) - 1), Integer.valueOf(FavImgGalleryUI.h(this.kbW).size()) });
      FavImgGalleryUI.a(this.kbW).setSelection(FavImgGalleryUI.d(this.kbW) - 1);
      FavImgGalleryUI.a(this.kbW, FavImgGalleryUI.d(this.kbW) - 1);
      return;
    }
    if (FavImgGalleryUI.h(this.kbW).size() > 0)
    {
      y.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.h(this.kbW).size()) });
      FavImgGalleryUI.a(this.kbW).setSelection(0);
      FavImgGalleryUI.a(this.kbW, 0);
      return;
    }
    y.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavImgGalleryUI.h(this.kbW).size()) });
    this.kbW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */