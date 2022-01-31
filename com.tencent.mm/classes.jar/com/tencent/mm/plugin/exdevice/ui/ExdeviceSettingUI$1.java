package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceSettingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceSettingUI$1(ExdeviceSettingUI paramExdeviceSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20215);
    this.lPL.finish();
    AppMethodBeat.o(20215);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI.1
 * JD-Core Version:    0.7.0.1
 */