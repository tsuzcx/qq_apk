package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CollectCreateQRCodeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CollectCreateQRCodeUI$1(CollectCreateQRCodeUI paramCollectCreateQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41230);
    this.kRn.setResult(0);
    this.kRn.finish();
    AppMethodBeat.o(41230);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */