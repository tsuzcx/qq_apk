package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o.g;

final class LoginHistoryUI$24
  implements o.g
{
  LoginHistoryUI$24(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(128106);
    LoginHistoryUI.a(this.kmt, paramMenuItem.getItemId());
    AppMethodBeat.o(128106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.24
 * JD-Core Version:    0.7.0.1
 */