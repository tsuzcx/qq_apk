package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavImgGalleryUI$10
  implements Runnable
{
  FavImgGalleryUI$10(FavImgGalleryUI paramFavImgGalleryUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.kbW, this.kbW.getString(n.i.fav_finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */