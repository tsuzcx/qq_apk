package com.tencent.mm.plugin.fav.ui;

import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;

final class FavSearchUI$6
  implements Runnable
{
  FavSearchUI$6(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74070);
    if (FavSearchUI.c(this.mxx) != null)
    {
      FavSearchUI.c(this.mxx).expandActionView();
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)FavSearchUI.b(this.mxx).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
      }
      FavSearchUI.b(this.mxx).setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(74070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.6
 * JD-Core Version:    0.7.0.1
 */