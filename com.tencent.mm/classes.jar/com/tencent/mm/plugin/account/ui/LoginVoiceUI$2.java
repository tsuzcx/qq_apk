package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;

final class LoginVoiceUI$2
  implements DialogInterface.OnCancelListener
{
  LoginVoiceUI$2(LoginVoiceUI paramLoginVoiceUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128251);
    h.aZW().a(this.pZE);
    paramDialogInterface = this.qbF;
    h.aZW().b(701, paramDialogInterface);
    h.aZW().b(252, paramDialogInterface);
    AppMethodBeat.o(128251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI.2
 * JD-Core Version:    0.7.0.1
 */