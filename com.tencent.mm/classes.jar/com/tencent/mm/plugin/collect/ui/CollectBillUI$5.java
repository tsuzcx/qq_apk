package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CollectBillUI$5
  implements MenuItem.OnMenuItemClickListener
{
  CollectBillUI$5(CollectBillUI paramCollectBillUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41215);
    paramMenuItem = new Intent(this.kRi.getContext(), CollectBillListUI.class);
    this.kRi.startActivity(paramMenuItem);
    AppMethodBeat.o(41215);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.5
 * JD-Core Version:    0.7.0.1
 */