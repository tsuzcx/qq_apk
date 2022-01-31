package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavoriteIndexUI$6
  implements Runnable
{
  FavoriteIndexUI$6(FavoriteIndexUI paramFavoriteIndexUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.kee, this.kee.getString(n.i.fav_finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.6
 * JD-Core Version:    0.7.0.1
 */