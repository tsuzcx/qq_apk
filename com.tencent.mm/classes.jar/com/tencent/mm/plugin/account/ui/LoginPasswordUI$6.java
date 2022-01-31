package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginPasswordUI$6
  implements DialogInterface.OnCancelListener
{
  LoginPasswordUI$6(LoginPasswordUI paramLoginPasswordUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125003);
    g.Rc().a(this.gDI);
    this.gEJ.ars();
    AppMethodBeat.o(125003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.6
 * JD-Core Version:    0.7.0.1
 */