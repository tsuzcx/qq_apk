package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;

final class EmailVerifyUI$7
  implements DialogInterface.OnCancelListener
{
  EmailVerifyUI$7(EmailVerifyUI paramEmailVerifyUI, z paramz) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124765);
    g.Rc().a(this.gCS);
    AppMethodBeat.o(124765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.7
 * JD-Core Version:    0.7.0.1
 */