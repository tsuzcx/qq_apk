package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginFaceUI$2
  implements DialogInterface.OnCancelListener
{
  LoginFaceUI$2(LoginFaceUI paramLoginFaceUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128085);
    g.agi().a(this.iRy);
    this.iRA.aQJ();
    AppMethodBeat.o(128085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI.2
 * JD-Core Version:    0.7.0.1
 */