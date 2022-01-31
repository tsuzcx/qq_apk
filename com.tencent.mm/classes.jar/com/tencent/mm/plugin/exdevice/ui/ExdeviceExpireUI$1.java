package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceExpireUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceExpireUI$1(ExdeviceExpireUI paramExdeviceExpireUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(19966);
    this.lMJ.finish();
    AppMethodBeat.o(19966);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI.1
 * JD-Core Version:    0.7.0.1
 */