package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class RegByMobileSetPwdUI$1$1
  implements DialogInterface.OnClickListener
{
  RegByMobileSetPwdUI$1$1(RegByMobileSetPwdUI.1 param1, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125436);
    MMWizardActivity.J(this.gIP.gIO, this.val$intent);
    AppMethodBeat.o(125436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1.1
 * JD-Core Version:    0.7.0.1
 */