package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavSearchUI$11$1$1
  implements Runnable
{
  FavSearchUI$11$1$1(FavSearchUI.11.1 param1, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(74080);
    if (this.mwd != null) {
      this.mwd.dismiss();
    }
    b.l(this.mxE.mxD.mxx, this.mxE.mxD.mxx.getString(2131299674));
    al.p(new FavSearchUI.11.1.1.1(this), 1800L);
    AppMethodBeat.o(74080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11.1.1
 * JD-Core Version:    0.7.0.1
 */