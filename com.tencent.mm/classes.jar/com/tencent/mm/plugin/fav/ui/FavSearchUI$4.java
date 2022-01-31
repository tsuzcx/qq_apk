package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;

final class FavSearchUI$4
  implements Runnable
{
  FavSearchUI$4(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    if (FavSearchUI.a(this.kcM) <= 0)
    {
      FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.kcM);
      if (localFavSearchActionView.kdq != null) {
        localFavSearchActionView.kdq.cBa();
      }
      this.kcM.showVKB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.4
 * JD-Core Version:    0.7.0.1
 */