package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;

final class EmailVerifyUI$3$1$1
  implements DialogInterface.OnCancelListener
{
  EmailVerifyUI$3$1$1(EmailVerifyUI.3.1 param1, z paramz) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124759);
    g.Rc().a(this.gCS);
    AppMethodBeat.o(124759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.3.1.1
 * JD-Core Version:    0.7.0.1
 */