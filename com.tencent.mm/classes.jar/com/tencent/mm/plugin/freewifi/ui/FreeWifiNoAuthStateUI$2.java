package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiNoAuthStateUI$2
  implements DialogInterface.OnClickListener
{
  FreeWifiNoAuthStateUI$2(FreeWifiNoAuthStateUI paramFreeWifiNoAuthStateUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21055);
    this.mOp.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.mOp.finish();
    AppMethodBeat.o(21055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI.2
 * JD-Core Version:    0.7.0.1
 */