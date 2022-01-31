package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class AAQueryListUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AAQueryListUI$4(AAQueryListUI paramAAQueryListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40733);
    paramMenuItem = new d(this.gpD, 1, false);
    paramMenuItem.sao = new AAQueryListUI.4.1(this);
    paramMenuItem.sap = new AAQueryListUI.4.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(40733);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.4
 * JD-Core Version:    0.7.0.1
 */