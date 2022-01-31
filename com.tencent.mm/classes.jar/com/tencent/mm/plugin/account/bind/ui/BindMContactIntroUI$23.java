package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class BindMContactIntroUI$23
  implements MenuItem.OnMenuItemClickListener
{
  BindMContactIntroUI$23(BindMContactIntroUI paramBindMContactIntroUI, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13433);
    paramMenuItem = new l(this.gtw.getContext());
    paramMenuItem.sao = new BindMContactIntroUI.23.1(this);
    paramMenuItem.sap = new BindMContactIntroUI.23.2(this);
    paramMenuItem.cwt();
    AppMethodBeat.o(13433);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23
 * JD-Core Version:    0.7.0.1
 */