package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceBindDeviceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceBindDeviceUI$1(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(23892);
    this.pbF.finish();
    AppMethodBeat.o(23892);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */