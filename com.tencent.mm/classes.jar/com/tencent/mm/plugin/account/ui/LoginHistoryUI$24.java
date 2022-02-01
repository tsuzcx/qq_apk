package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class LoginHistoryUI$24
  implements n.d
{
  LoginHistoryUI$24(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(128106);
    LoginHistoryUI.a(this.isd, paramMenuItem.getItemId());
    AppMethodBeat.o(128106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.24
 * JD-Core Version:    0.7.0.1
 */