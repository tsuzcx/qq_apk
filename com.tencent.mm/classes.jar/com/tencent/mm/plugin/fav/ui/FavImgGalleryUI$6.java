package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavImgGalleryUI$6
  implements MenuItem.OnMenuItemClickListener
{
  FavImgGalleryUI$6(FavImgGalleryUI paramFavImgGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74005);
    this.mwu.finish();
    AppMethodBeat.o(74005);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */