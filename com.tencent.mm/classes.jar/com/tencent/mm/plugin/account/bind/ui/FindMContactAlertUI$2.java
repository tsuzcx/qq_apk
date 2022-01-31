package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMContactAlertUI$2
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$2(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13564);
    paramDialogInterface.dismiss();
    this.guR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(13564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.2
 * JD-Core Version:    0.7.0.1
 */