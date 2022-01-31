package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class SecurityAccountVerifyUI$3$1
  implements DialogInterface.OnCancelListener
{
  SecurityAccountVerifyUI$3$1(SecurityAccountVerifyUI.3 param3, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(69917);
    g.Rc().a(this.gBU);
    AppMethodBeat.o(69917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.3.1
 * JD-Core Version:    0.7.0.1
 */