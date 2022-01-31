package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

final class LoginUI$22
  implements View.OnClickListener
{
  LoginUI$22(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.fnM.getString(q.j.login_forget_password_help) + x.cqJ();
    LoginUI.O(this.fnM, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.22
 * JD-Core Version:    0.7.0.1
 */