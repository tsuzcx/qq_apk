package com.tencent.mm.plugin.fav.ui;

import android.support.v4.view.f;
import android.support.v7.widget.Toolbar.LayoutParams;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;

final class FavSearchUI$6
  implements Runnable
{
  FavSearchUI$6(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    if (FavSearchUI.c(this.kcM) != null)
    {
      f.b(FavSearchUI.c(this.kcM));
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)FavSearchUI.b(this.kcM).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
      }
      FavSearchUI.b(this.kcM).setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.6
 * JD-Core Version:    0.7.0.1
 */