package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

final class LoginSmsUI$1
  implements View.OnClickListener
{
  LoginSmsUI$1(LoginSmsUI paramLoginSmsUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fnx, this.fnx.getString(q.j.regbymobile_reg_verify_mobile_msg) + this.fnx.fmC, this.fnx.getString(q.j.regbymobile_reg_verify_mobile_title), this.fnx.getString(q.j.app_ok), this.fnx.getString(q.j.app_cancel), false, new LoginSmsUI.1.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        LoginSmsUI.1.this.fnx.fmP.reset();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.1
 * JD-Core Version:    0.7.0.1
 */