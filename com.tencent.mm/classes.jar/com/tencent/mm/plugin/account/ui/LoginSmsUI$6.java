package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class LoginSmsUI$6
  implements DialogInterface.OnCancelListener
{
  LoginSmsUI$6(LoginSmsUI paramLoginSmsUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(169134);
    g.agi().a(this.iRx);
    AppMethodBeat.o(169134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.6
 * JD-Core Version:    0.7.0.1
 */