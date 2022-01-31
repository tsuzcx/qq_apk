package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

final class LoginHistoryUI$27
  implements View.OnClickListener
{
  LoginHistoryUI$27(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.fnc.getString(q.j.freeze_account_url, new Object[] { x.cqJ() });
    LoginHistoryUI.N(this.fnc, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.27
 * JD-Core Version:    0.7.0.1
 */