package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavTipsUI$2
  implements DialogInterface.OnCancelListener
{
  FavTipsUI$2(FavTipsUI paramFavTipsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(74166);
    this.myj.finish();
    AppMethodBeat.o(74166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTipsUI.2
 * JD-Core Version:    0.7.0.1
 */