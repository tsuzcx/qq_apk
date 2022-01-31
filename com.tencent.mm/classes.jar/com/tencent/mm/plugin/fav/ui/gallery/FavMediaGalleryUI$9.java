package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;

final class FavMediaGalleryUI$9
  implements Runnable
{
  FavMediaGalleryUI$9(FavMediaGalleryUI paramFavMediaGalleryUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(74516);
    if (this.mwx != -1)
    {
      ab.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(this.mwx) });
      FavMediaGalleryUI.g(this.mBV).setSelection(this.mwx);
      FavMediaGalleryUI.a(this.mBV, this.mwx);
      AppMethodBeat.o(74516);
      return;
    }
    if ((FavMediaGalleryUI.c(this.mBV) - 1 >= 0) && (FavMediaGalleryUI.c(this.mBV) - 1 < FavMediaGalleryUI.h(this.mBV).size()))
    {
      ab.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.c(this.mBV) - 1), Integer.valueOf(FavMediaGalleryUI.h(this.mBV).size()) });
      FavMediaGalleryUI.g(this.mBV).setSelection(FavMediaGalleryUI.c(this.mBV) - 1);
      FavMediaGalleryUI.a(this.mBV, FavMediaGalleryUI.c(this.mBV) - 1);
      AppMethodBeat.o(74516);
      return;
    }
    if (FavMediaGalleryUI.h(this.mBV).size() > 0)
    {
      ab.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.h(this.mBV).size()) });
      FavMediaGalleryUI.g(this.mBV).setSelection(0);
      FavMediaGalleryUI.a(this.mBV, 0);
      AppMethodBeat.o(74516);
      return;
    }
    ab.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.h(this.mBV).size()) });
    this.mBV.finish();
    AppMethodBeat.o(74516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */