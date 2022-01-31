package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EnterpriseBizContactPlainListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseBizContactPlainListUI$2(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13981);
    this.jUA.hideVKB();
    this.jUA.finish();
    AppMethodBeat.o(13981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.2
 * JD-Core Version:    0.7.0.1
 */