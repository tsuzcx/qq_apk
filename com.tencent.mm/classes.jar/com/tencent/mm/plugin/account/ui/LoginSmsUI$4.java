package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class LoginSmsUI$4
  implements DialogInterface.OnCancelListener
{
  LoginSmsUI$4(LoginSmsUI paramLoginSmsUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125018);
    g.Rc().a(this.gEH);
    AppMethodBeat.o(125018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.4
 * JD-Core Version:    0.7.0.1
 */