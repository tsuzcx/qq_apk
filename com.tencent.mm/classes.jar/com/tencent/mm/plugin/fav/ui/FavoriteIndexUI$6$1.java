package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteIndexUI$6$1
  implements Runnable
{
  FavoriteIndexUI$6$1(FavoriteIndexUI.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(74228);
    this.myR.mwd.dismiss();
    AppMethodBeat.o(74228);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74229);
    String str = super.toString() + "|batchDelFavItems";
    AppMethodBeat.o(74229);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.6.1
 * JD-Core Version:    0.7.0.1
 */