package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

final class FavoriteIndexUI$7
  implements Runnable
{
  FavoriteIndexUI$7(FavoriteIndexUI paramFavoriteIndexUI, List paramList, String[] paramArrayOfString, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(74233);
    FavoriteIndexUI.a(this.mwc, this.myS);
    al.d(new FavoriteIndexUI.7.1(this));
    AppMethodBeat.o(74233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.7
 * JD-Core Version:    0.7.0.1
 */