package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class LoginHistoryUI$8
  implements DialogInterface.OnCancelListener
{
  LoginHistoryUI$8(LoginHistoryUI paramLoginHistoryUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128094);
    g.aiU().a(this.jkF);
    AppMethodBeat.o(128094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.8
 * JD-Core Version:    0.7.0.1
 */