package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class LoginHistoryUI$19
  implements n.d
{
  LoginHistoryUI$19(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(152548);
    LoginHistoryUI.a(this.gEw, paramMenuItem.getItemId());
    AppMethodBeat.o(152548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.19
 * JD-Core Version:    0.7.0.1
 */