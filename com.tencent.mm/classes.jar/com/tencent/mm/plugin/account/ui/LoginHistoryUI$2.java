package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

final class LoginHistoryUI$2
  implements n.d
{
  LoginHistoryUI$2(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 7005: 
    case 7006: 
    case 7007: 
    case 7008: 
    default: 
      return;
    case 7002: 
      LoginHistoryUI.d(this.fnc);
      return;
    case 7003: 
      LoginHistoryUI.e(this.fnc);
      return;
    case 7004: 
      LoginHistoryUI.f(this.fnc);
      return;
    }
    LoginHistoryUI.N(this.fnc, this.fnc.getString(q.j.wechat_help_center_url) + x.cqJ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */