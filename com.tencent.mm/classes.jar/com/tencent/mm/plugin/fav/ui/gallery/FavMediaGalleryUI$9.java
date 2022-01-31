package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;

final class FavMediaGalleryUI$9
  implements Runnable
{
  FavMediaGalleryUI$9(FavMediaGalleryUI paramFavMediaGalleryUI, int paramInt) {}
  
  public final void run()
  {
    if (this.kbX != -1)
    {
      y.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(this.kbX) });
      FavMediaGalleryUI.g(this.khg).setSelection(this.kbX);
      FavMediaGalleryUI.a(this.khg, this.kbX);
      return;
    }
    if ((FavMediaGalleryUI.c(this.khg) - 1 >= 0) && (FavMediaGalleryUI.c(this.khg) - 1 < FavMediaGalleryUI.h(this.khg).size()))
    {
      y.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.c(this.khg) - 1), Integer.valueOf(FavMediaGalleryUI.h(this.khg).size()) });
      FavMediaGalleryUI.g(this.khg).setSelection(FavMediaGalleryUI.c(this.khg) - 1);
      FavMediaGalleryUI.a(this.khg, FavMediaGalleryUI.c(this.khg) - 1);
      return;
    }
    if (FavMediaGalleryUI.h(this.khg).size() > 0)
    {
      y.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.h(this.khg).size()) });
      FavMediaGalleryUI.g(this.khg).setSelection(0);
      FavMediaGalleryUI.a(this.khg, 0);
      return;
    }
    y.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.h(this.khg).size()) });
    this.khg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */