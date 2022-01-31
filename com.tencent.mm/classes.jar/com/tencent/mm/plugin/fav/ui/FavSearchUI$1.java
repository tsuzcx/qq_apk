package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;

final class FavSearchUI$1
  implements Runnable
{
  FavSearchUI$1(FavSearchUI paramFavSearchUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74065);
    FavSearchUI.a(this.mxx, ((ae)g.G(ae.class)).getFavItemInfoStorage().bwS());
    AppMethodBeat.o(74065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.1
 * JD-Core Version:    0.7.0.1
 */