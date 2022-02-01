package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.i;

final class LoginHistoryUI$21
  implements u.i
{
  LoginHistoryUI$21(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(305172);
    LoginHistoryUI.a(this.qbb, paramMenuItem.getItemId());
    AppMethodBeat.o(305172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.21
 * JD-Core Version:    0.7.0.1
 */