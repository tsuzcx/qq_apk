package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavSearchUI$11$1$1
  implements Runnable
{
  FavSearchUI$11$1$1(FavSearchUI.11.1 param1, Dialog paramDialog) {}
  
  public final void run()
  {
    if (this.kbH != null) {
      this.kbH.dismiss();
    }
    b.h(this.kcT.kcS.kcM, this.kcT.kcS.kcM.getString(n.i.fav_finish_sent));
    ai.l(new FavSearchUI.11.1.1.1(this), 1800L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11.1.1
 * JD-Core Version:    0.7.0.1
 */