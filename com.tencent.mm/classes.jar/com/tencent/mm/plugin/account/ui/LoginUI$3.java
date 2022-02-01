package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u.i;

final class LoginUI$3
  implements u.i
{
  LoginUI$3(LoginUI paramLoginUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(304903);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304903);
      return;
      LoginUI.b(this.qbD);
      AppMethodBeat.o(304903);
      return;
      LoginUI.X(this.qbD, this.qbD.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.3
 * JD-Core Version:    0.7.0.1
 */