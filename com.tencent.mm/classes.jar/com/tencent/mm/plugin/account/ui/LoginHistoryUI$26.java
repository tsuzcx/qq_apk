package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

final class LoginHistoryUI$26
  implements View.OnClickListener
{
  LoginHistoryUI$26(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.fnc.getString(q.j.login_forget_password_help) + x.cqJ();
    LoginHistoryUI.N(this.fnc, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.26
 * JD-Core Version:    0.7.0.1
 */