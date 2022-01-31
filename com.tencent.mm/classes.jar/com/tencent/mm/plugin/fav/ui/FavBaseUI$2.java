package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.a;

final class FavBaseUI$2
  implements Runnable
{
  FavBaseUI$2(FavBaseUI paramFavBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(73927);
    synchronized (FavBaseUI.g(this.mvK))
    {
      this.mvK.bxm();
      this.mvK.bxl().bxP();
      this.mvK.bxq();
      AppMethodBeat.o(73927);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.2
 * JD-Core Version:    0.7.0.1
 */