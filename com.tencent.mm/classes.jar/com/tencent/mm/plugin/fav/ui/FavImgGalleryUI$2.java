package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavImgGalleryUI$2
  implements Runnable
{
  FavImgGalleryUI$2(FavImgGalleryUI paramFavImgGalleryUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(151519);
    this.mwd.dismiss();
    b.l(this.mwu, this.mwu.getString(2131299674));
    AppMethodBeat.o(151519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.2
 * JD-Core Version:    0.7.0.1
 */