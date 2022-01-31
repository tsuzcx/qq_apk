package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class SecurityAccountVerifyUI$6$1
  implements DialogInterface.OnCancelListener
{
  SecurityAccountVerifyUI$6$1(SecurityAccountVerifyUI.6 param6, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(69921);
    g.Rc().a(this.gCd);
    AppMethodBeat.o(69921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.6.1
 * JD-Core Version:    0.7.0.1
 */