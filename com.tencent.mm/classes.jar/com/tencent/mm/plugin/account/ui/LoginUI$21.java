package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class LoginUI$21
  implements DialogInterface.OnCancelListener
{
  LoginUI$21(LoginUI paramLoginUI, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(169138);
    h.aGY().a(this.ndz);
    h.aGY().b(252, this.neS);
    h.aGY().b(701, this.neS);
    AppMethodBeat.o(169138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.21
 * JD-Core Version:    0.7.0.1
 */