package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginFaceUI$2
  implements DialogInterface.OnCancelListener
{
  LoginFaceUI$2(LoginFaceUI paramLoginFaceUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124910);
    g.Rc().a(this.gDI);
    this.gDH.ars();
    AppMethodBeat.o(124910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI.2
 * JD-Core Version:    0.7.0.1
 */