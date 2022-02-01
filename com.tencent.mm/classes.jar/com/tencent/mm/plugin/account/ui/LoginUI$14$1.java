package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginUI$14$1
  implements DialogInterface.OnCancelListener
{
  LoginUI$14$1(LoginUI.14 param14, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128215);
    g.agi().a(this.iRy);
    g.agi().b(701, this.iSQ.iSO);
    g.agi().b(252, this.iSQ.iSO);
    AppMethodBeat.o(128215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.14.1
 * JD-Core Version:    0.7.0.1
 */