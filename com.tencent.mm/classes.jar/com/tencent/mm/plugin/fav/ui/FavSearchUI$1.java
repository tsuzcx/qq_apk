package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;

final class FavSearchUI$1
  implements Runnable
{
  FavSearchUI$1(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    FavSearchUI.a(this.kcM, ((ae)g.t(ae.class)).getFavItemInfoStorage().aQD());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.1
 * JD-Core Version:    0.7.0.1
 */