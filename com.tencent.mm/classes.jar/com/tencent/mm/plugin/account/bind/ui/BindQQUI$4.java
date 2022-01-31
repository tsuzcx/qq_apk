package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindQQUI$4
  implements MenuItem.OnMenuItemClickListener
{
  BindQQUI$4(BindQQUI paramBindQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13547);
    this.guz.hideVKB();
    this.guz.finish();
    AppMethodBeat.o(13547);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.4
 * JD-Core Version:    0.7.0.1
 */