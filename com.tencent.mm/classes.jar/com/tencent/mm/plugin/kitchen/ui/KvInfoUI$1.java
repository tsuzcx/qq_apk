package com.tencent.mm.plugin.kitchen.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class KvInfoUI$1
  implements MenuItem.OnMenuItemClickListener
{
  KvInfoUI$1(KvInfoUI paramKvInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(114440);
    this.nXL.finish();
    AppMethodBeat.o(114440);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.1
 * JD-Core Version:    0.7.0.1
 */