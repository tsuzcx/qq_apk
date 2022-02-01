package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginPasswordUI$7
  implements DialogInterface.OnCancelListener
{
  LoginPasswordUI$7(LoginPasswordUI paramLoginPasswordUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(169129);
    g.agi().a(this.iRy);
    this.iSv.aQJ();
    AppMethodBeat.o(169129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.7
 * JD-Core Version:    0.7.0.1
 */