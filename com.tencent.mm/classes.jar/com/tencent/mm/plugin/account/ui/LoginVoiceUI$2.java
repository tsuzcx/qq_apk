package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginVoiceUI$2
  implements DialogInterface.OnCancelListener
{
  LoginVoiceUI$2(LoginVoiceUI paramLoginVoiceUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128251);
    g.agi().a(this.iRy);
    this.iSR.aQJ();
    AppMethodBeat.o(128251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI.2
 * JD-Core Version:    0.7.0.1
 */