package com.tencent.mm.plugin.expt.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExptDebugUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExptDebugUI$1(ExptDebugUI paramExptDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(122470);
    this.sLM.finish();
    AppMethodBeat.o(122470);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.1
 * JD-Core Version:    0.7.0.1
 */