package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavMediaGalleryUI$5
  implements MenuItem.OnMenuItemClickListener
{
  FavMediaGalleryUI$5(FavMediaGalleryUI paramFavMediaGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74512);
    this.mBV.finish();
    AppMethodBeat.o(74512);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */