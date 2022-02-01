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
    AppMethodBeat.i(64091);
    this.oAX.setResult(0);
    this.oAX.finish();
    AppMethodBeat.o(64091);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */