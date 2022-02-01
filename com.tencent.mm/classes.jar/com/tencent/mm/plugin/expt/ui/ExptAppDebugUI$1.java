package com.tencent.mm.plugin.expt.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExptAppDebugUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExptAppDebugUI$1(ExptAppDebugUI paramExptAppDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(299568);
    this.zNK.finish();
    AppMethodBeat.o(299568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.1
 * JD-Core Version:    0.7.0.1
 */