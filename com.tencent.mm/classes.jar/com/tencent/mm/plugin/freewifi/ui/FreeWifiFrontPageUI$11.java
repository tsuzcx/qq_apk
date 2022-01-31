package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiFrontPageUI$11
  implements DialogInterface.OnClickListener
{
  FreeWifiFrontPageUI$11(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20969);
    this.mND.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.mND.finish();
    AppMethodBeat.o(20969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.11
 * JD-Core Version:    0.7.0.1
 */