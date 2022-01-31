package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.ui.base.h;

final class EmailVerifyUI$3$1
  implements DialogInterface.OnClickListener
{
  EmailVerifyUI$3$1(EmailVerifyUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124760);
    paramDialogInterface = new z(EmailVerifyUI.a(this.gCR.gCQ), EmailVerifyUI.b(this.gCR.gCQ));
    g.Rc().a(paramDialogInterface, 0);
    EmailVerifyUI localEmailVerifyUI1 = this.gCR.gCQ;
    EmailVerifyUI localEmailVerifyUI2 = this.gCR.gCQ;
    this.gCR.gCQ.getString(2131297087);
    EmailVerifyUI.a(localEmailVerifyUI1, h.b(localEmailVerifyUI2, this.gCR.gCQ.getString(2131302403), true, new EmailVerifyUI.3.1.1(this, paramDialogInterface)));
    AppMethodBeat.o(124760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.3.1
 * JD-Core Version:    0.7.0.1
 */