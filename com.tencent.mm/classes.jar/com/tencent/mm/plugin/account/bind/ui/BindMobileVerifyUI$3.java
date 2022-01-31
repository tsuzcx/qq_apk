package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindMobileVerifyUI$3
  implements MenuItem.OnMenuItemClickListener
{
  BindMobileVerifyUI$3(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13531);
    this.guw.finish();
    AppMethodBeat.o(13531);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */