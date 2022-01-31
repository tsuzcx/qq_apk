package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallShareCouponCardUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallShareCouponCardUI$1(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22283);
    this.nVC.finish();
    AppMethodBeat.o(22283);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.1
 * JD-Core Version:    0.7.0.1
 */