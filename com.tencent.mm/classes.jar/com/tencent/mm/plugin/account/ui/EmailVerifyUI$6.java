package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;

final class EmailVerifyUI$6
  implements MenuItem.OnMenuItemClickListener
{
  EmailVerifyUI$6(EmailVerifyUI paramEmailVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124764);
    EmailVerifyUI.b(this.gCQ, EmailVerifyUI.e(this.gCQ).getText());
    if ((!bo.isNullOrNil(EmailVerifyUI.f(this.gCQ))) && (EmailVerifyUI.f(this.gCQ).length() == 12)) {
      EmailVerifyUI.a(this.gCQ, EmailVerifyUI.f(this.gCQ));
    }
    for (;;)
    {
      AppMethodBeat.o(124764);
      return true;
      this.gCQ.enableOptionMenu(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */