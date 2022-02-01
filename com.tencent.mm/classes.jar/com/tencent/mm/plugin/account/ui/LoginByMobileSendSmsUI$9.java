package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class LoginByMobileSendSmsUI$9
  implements DialogInterface.OnCancelListener
{
  LoginByMobileSendSmsUI$9(LoginByMobileSendSmsUI paramLoginByMobileSendSmsUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128065);
    g.ajj().a(this.jnz);
    AppMethodBeat.o(128065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.9
 * JD-Core Version:    0.7.0.1
 */