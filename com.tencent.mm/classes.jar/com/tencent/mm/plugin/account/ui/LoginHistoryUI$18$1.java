package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class LoginHistoryUI$18$1
  implements DialogInterface.OnCancelListener
{
  LoginHistoryUI$18$1(LoginHistoryUI.18 param18, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128101);
    g.agi().a(this.iRy);
    g.agi().b(701, this.iSk.iSi);
    g.agi().b(252, this.iSk.iSi);
    AppMethodBeat.o(128101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.18.1
 * JD-Core Version:    0.7.0.1
 */