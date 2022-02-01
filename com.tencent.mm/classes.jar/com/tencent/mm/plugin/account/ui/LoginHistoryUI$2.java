package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.q.g;

final class LoginHistoryUI$2
  implements q.g
{
  LoginHistoryUI$2(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(128089);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128089);
      return;
      LoginHistoryUI.d(this.nek);
      AppMethodBeat.o(128089);
      return;
      LoginHistoryUI.e(this.nek);
      AppMethodBeat.o(128089);
      return;
      LoginHistoryUI.f(this.nek);
      AppMethodBeat.o(128089);
      return;
      LoginHistoryUI.W(this.nek, this.nek.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */