package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByQQAuthUI$2
  implements MenuItem.OnMenuItemClickListener
{
  RegByQQAuthUI$2(RegByQQAuthUI paramRegByQQAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125500);
    this.gJn.hideVKB();
    this.gJn.finish();
    AppMethodBeat.o(125500);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI.2
 * JD-Core Version:    0.7.0.1
 */