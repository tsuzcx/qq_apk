package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavoriteImgDetailUI$10
  implements Runnable
{
  FavoriteImgDetailUI$10(FavoriteImgDetailUI paramFavoriteImgDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.kfM, this.kfM.getString(n.i.fav_finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.10
 * JD-Core Version:    0.7.0.1
 */