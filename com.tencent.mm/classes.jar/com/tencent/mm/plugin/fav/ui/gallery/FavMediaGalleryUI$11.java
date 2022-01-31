package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavMediaGalleryUI$11
  implements Runnable
{
  FavMediaGalleryUI$11(FavMediaGalleryUI paramFavMediaGalleryUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.khg, this.khg.getString(n.i.fav_finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.11
 * JD-Core Version:    0.7.0.1
 */