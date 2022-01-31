package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

final class LoginUI$26
  implements n.d
{
  LoginUI$26(LoginUI paramLoginUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 5001: 
      LoginUI.d(this.fnM);
      return;
    }
    LoginUI.O(this.fnM, this.fnM.getString(q.j.wechat_help_center_url) + x.cqJ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.26
 * JD-Core Version:    0.7.0.1
 */