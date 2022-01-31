package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAEntranceUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AAEntranceUI$3(AAEntranceUI paramAAEntranceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40710);
    this.gpn.finish();
    AppMethodBeat.o(40710);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI.3
 * JD-Core Version:    0.7.0.1
 */