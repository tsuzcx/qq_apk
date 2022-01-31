package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;

final class EmailVerifyUI$6
  implements MenuItem.OnMenuItemClickListener
{
  EmailVerifyUI$6(EmailVerifyUI paramEmailVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    EmailVerifyUI.b(this.flz, EmailVerifyUI.e(this.flz).getText());
    if ((!bk.bl(EmailVerifyUI.f(this.flz))) && (EmailVerifyUI.f(this.flz).length() == 12)) {
      EmailVerifyUI.a(this.flz, EmailVerifyUI.f(this.flz));
    }
    for (;;)
    {
      return true;
      this.flz.enableOptionMenu(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */