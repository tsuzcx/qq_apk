package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiNetCheckUI$7
  implements DialogInterface.OnClickListener
{
  FreeWifiNetCheckUI$7(FreeWifiNetCheckUI paramFreeWifiNetCheckUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21041);
    this.mOl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.mOl.finish();
    AppMethodBeat.o(21041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.7
 * JD-Core Version:    0.7.0.1
 */