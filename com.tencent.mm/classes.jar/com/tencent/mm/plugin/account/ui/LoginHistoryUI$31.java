package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u.i;

final class LoginHistoryUI$31
  implements u.i
{
  LoginHistoryUI$31(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(305133);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(305133);
      return;
      LoginHistoryUI.c(this.qbb);
      AppMethodBeat.o(305133);
      return;
      LoginHistoryUI.d(this.qbb);
      AppMethodBeat.o(305133);
      return;
      LoginHistoryUI.e(this.qbb);
      AppMethodBeat.o(305133);
      return;
      LoginHistoryUI.U(this.qbb, this.qbb.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.31
 * JD-Core Version:    0.7.0.1
 */