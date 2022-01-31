package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.ui.base.h;

final class EmailVerifyUI$3$1
  implements DialogInterface.OnClickListener
{
  EmailVerifyUI$3$1(EmailVerifyUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new z(EmailVerifyUI.a(this.flA.flz), EmailVerifyUI.b(this.flA.flz));
    g.Dk().a(paramDialogInterface, 0);
    EmailVerifyUI localEmailVerifyUI1 = this.flA.flz;
    EmailVerifyUI localEmailVerifyUI2 = this.flA.flz;
    this.flA.flz.getString(q.j.app_tip);
    EmailVerifyUI.a(localEmailVerifyUI1, h.b(localEmailVerifyUI2, this.flA.flz.getString(q.j.regby_email_verify_code_sending), true, new EmailVerifyUI.3.1.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.3.1
 * JD-Core Version:    0.7.0.1
 */