package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class BindQQUI$7
  implements MenuItem.OnMenuItemClickListener
{
  BindQQUI$7(BindQQUI paramBindQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13551);
    paramMenuItem = new l(this.guz.getContext());
    paramMenuItem.sao = new BindQQUI.7.1(this);
    paramMenuItem.sap = new BindQQUI.7.2(this);
    paramMenuItem.cwt();
    AppMethodBeat.o(13551);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.7
 * JD-Core Version:    0.7.0.1
 */