package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceBindDeviceGuideUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceBindDeviceGuideUI$1(ExdeviceBindDeviceGuideUI paramExdeviceBindDeviceGuideUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(19811);
    this.lKD.finish();
    AppMethodBeat.o(19811);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.1
 * JD-Core Version:    0.7.0.1
 */