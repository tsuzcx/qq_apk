package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceManageDeviceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceManageDeviceUI$1(ExdeviceManageDeviceUI paramExdeviceManageDeviceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24052);
    this.yAF.finish();
    AppMethodBeat.o(24052);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */