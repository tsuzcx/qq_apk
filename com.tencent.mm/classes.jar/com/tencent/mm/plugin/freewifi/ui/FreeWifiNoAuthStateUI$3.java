package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiNoAuthStateUI$3
  implements DialogInterface.OnClickListener
{
  FreeWifiNoAuthStateUI$3(FreeWifiNoAuthStateUI paramFreeWifiNoAuthStateUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21056);
    this.mOp.finish();
    AppMethodBeat.o(21056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI.3
 * JD-Core Version:    0.7.0.1
 */