package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavoriteImgDetailUI$3
  implements Runnable
{
  FavoriteImgDetailUI$3(FavoriteImgDetailUI paramFavoriteImgDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(151528);
    this.mwd.dismiss();
    b.l(this.mAv, this.mAv.getString(2131299674));
    AppMethodBeat.o(151528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3
 * JD-Core Version:    0.7.0.1
 */