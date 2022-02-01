package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginUI$21
  implements DialogInterface.OnCancelListener
{
  LoginUI$21(LoginUI paramLoginUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(169138);
    g.agi().a(this.iRy);
    g.agi().b(252, this.iSO);
    g.agi().b(701, this.iSO);
    AppMethodBeat.o(169138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.21
 * JD-Core Version:    0.7.0.1
 */