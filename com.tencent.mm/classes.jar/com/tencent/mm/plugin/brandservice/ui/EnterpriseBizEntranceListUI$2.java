package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EnterpriseBizEntranceListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseBizEntranceListUI$2(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194880);
    this.ppF.hideVKB();
    this.ppF.finish();
    AppMethodBeat.o(194880);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.2
 * JD-Core Version:    0.7.0.1
 */