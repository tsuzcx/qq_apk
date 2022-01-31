package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VerifyQQUI$1
  implements MenuItem.OnMenuItemClickListener
{
  VerifyQQUI$1(VerifyQQUI paramVerifyQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13777);
    this.gwA.hideVKB();
    VerifyQQUI.a(this.gwA);
    AppMethodBeat.o(13777);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.1
 * JD-Core Version:    0.7.0.1
 */