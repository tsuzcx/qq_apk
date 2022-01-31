package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CleanChattingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CleanChattingUI$1(CleanChattingUI paramCleanChattingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(18874);
    this.kJl.finish();
    AppMethodBeat.o(18874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.1
 * JD-Core Version:    0.7.0.1
 */