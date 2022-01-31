package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class IPCallShareCouponCardUI$13
  implements n.d
{
  IPCallShareCouponCardUI$13(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(22295);
    IPCallShareCouponCardUI.a(this.nVC, paramMenuItem.getItemId());
    AppMethodBeat.o(22295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.13
 * JD-Core Version:    0.7.0.1
 */