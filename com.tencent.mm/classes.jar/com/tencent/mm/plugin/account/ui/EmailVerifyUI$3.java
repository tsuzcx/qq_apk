package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class EmailVerifyUI$3
  implements View.OnClickListener
{
  EmailVerifyUI$3(EmailVerifyUI paramEmailVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new StringBuilder();
    g.DN();
    paramView = paramView.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_250,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R500_250") + ",3");
    h.a(this.flz, q.j.regby_email_resend_verify_code, q.j.regby_email_err_tip_title, q.j.app_ok, q.j.app_cancel, new EmailVerifyUI.3.1(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */