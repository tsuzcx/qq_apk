package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;

final class LoginIndepPass$2
  implements DialogInterface.OnCancelListener
{
  LoginIndepPass$2(LoginIndepPass paramLoginIndepPass, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128147);
    h.aZW().a(this.pZE);
    AppMethodBeat.o(128147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.2
 * JD-Core Version:    0.7.0.1
 */