package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HoneyPayCardBackUI$1
  implements MenuItem.OnMenuItemClickListener
{
  HoneyPayCardBackUI$1(HoneyPayCardBackUI paramHoneyPayCardBackUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41771);
    this.nHG.hideVKB();
    this.nHG.hideTenpayKB();
    this.nHG.finish();
    AppMethodBeat.o(41771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI.1
 * JD-Core Version:    0.7.0.1
 */