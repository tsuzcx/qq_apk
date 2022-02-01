package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginByMobileSendSmsUI$13$1
  implements DialogInterface.OnCancelListener
{
  LoginByMobileSendSmsUI$13$1(LoginByMobileSendSmsUI.13 param13, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128067);
    g.agi().a(this.iRy);
    g.agi().b(701, this.iRz.iRw);
    g.agi().b(252, this.iRz.iRw);
    AppMethodBeat.o(128067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.13.1
 * JD-Core Version:    0.7.0.1
 */