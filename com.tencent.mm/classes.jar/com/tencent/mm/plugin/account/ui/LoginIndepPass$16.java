package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class LoginIndepPass$16
  implements DialogInterface.OnCancelListener
{
  LoginIndepPass$16(LoginIndepPass paramLoginIndepPass, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128162);
    h.aGY().a(this.ndz);
    AppMethodBeat.o(128162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.16
 * JD-Core Version:    0.7.0.1
 */