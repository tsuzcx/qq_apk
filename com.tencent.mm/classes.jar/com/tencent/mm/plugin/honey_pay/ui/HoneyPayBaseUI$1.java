package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HoneyPayBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  HoneyPayBaseUI$1(HoneyPayBaseUI paramHoneyPayBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41770);
    this.nHy.hideVKB();
    this.nHy.hideTenpayKB();
    this.nHy.finish();
    AppMethodBeat.o(41770);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI.1
 * JD-Core Version:    0.7.0.1
 */