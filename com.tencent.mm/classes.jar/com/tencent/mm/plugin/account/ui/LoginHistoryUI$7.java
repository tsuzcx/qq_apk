package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class LoginHistoryUI$7
  implements View.OnClickListener
{
  LoginHistoryUI$7(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    d.x(this.fnc, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.fnc.overridePendingTransition(q.a.push_down_in, q.a.anim_not_change);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */