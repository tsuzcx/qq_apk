package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginUI$20
  implements DialogInterface.OnCancelListener
{
  LoginUI$20(LoginUI paramLoginUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(152566);
    g.Rc().a(this.gDI);
    g.Rc().b(252, this.gFf);
    g.Rc().b(701, this.gFf);
    AppMethodBeat.o(152566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.20
 * JD-Core Version:    0.7.0.1
 */