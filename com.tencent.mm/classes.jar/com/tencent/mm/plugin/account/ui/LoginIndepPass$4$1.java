package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginIndepPass$4$1
  implements DialogInterface.OnCancelListener
{
  LoginIndepPass$4$1(LoginIndepPass.4 param4, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124971);
    g.Rc().a(this.gDI);
    g.Rc().b(701, this.gEF.gEE);
    g.Rc().b(252, this.gEF.gEE);
    AppMethodBeat.o(124971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.4.1
 * JD-Core Version:    0.7.0.1
 */