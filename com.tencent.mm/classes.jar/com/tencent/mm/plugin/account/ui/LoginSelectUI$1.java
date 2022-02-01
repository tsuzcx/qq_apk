package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginSelectUI$1
  implements MenuItem.OnMenuItemClickListener
{
  LoginSelectUI$1(LoginSelectUI paramLoginSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(305027);
    this.qbq.finish();
    AppMethodBeat.o(305027);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectUI.1
 * JD-Core Version:    0.7.0.1
 */