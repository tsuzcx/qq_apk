package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;

final class LoginUI$21
  implements DialogInterface.OnCancelListener
{
  LoginUI$21(LoginUI paramLoginUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(169138);
    h.aZW().a(this.pZE);
    h.aZW().b(252, this.qbD);
    h.aZW().b(701, this.qbD);
    AppMethodBeat.o(169138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.21
 * JD-Core Version:    0.7.0.1
 */