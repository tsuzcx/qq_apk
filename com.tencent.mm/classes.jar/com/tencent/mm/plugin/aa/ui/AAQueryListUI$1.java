package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAQueryListUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AAQueryListUI$1(AAQueryListUI paramAAQueryListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40728);
    this.gpD.finish();
    AppMethodBeat.o(40728);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.1
 * JD-Core Version:    0.7.0.1
 */