package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class FindMContactAlertUI$6
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$6(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13568);
    paramDialogInterface = new Intent(this.guR, FindMContactLearmMoreUI.class);
    paramDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(this.guR));
    paramDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(this.guR));
    paramDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(this.guR));
    MMWizardActivity.J(this.guR, paramDialogInterface);
    AppMethodBeat.o(13568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.6
 * JD-Core Version:    0.7.0.1
 */