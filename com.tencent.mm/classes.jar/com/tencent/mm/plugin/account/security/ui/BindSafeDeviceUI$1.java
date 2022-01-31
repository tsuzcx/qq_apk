package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindSafeDeviceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BindSafeDeviceUI$1(BindSafeDeviceUI paramBindSafeDeviceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69858);
    this.gBq.finish();
    AppMethodBeat.o(69858);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */