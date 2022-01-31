package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectWifiUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceConnectWifiUI$10(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(19886);
    if (!ExdeviceConnectWifiUI.h(this.lLW))
    {
      paramMenuItem = new Intent();
      if (ExdeviceConnectWifiUI.d(this.lLW) == ExdeviceConnectWifiUI.b.lMg) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      paramMenuItem.putExtra("is_wifi_connected", bool);
      this.lLW.setResult(0, paramMenuItem);
      this.lLW.finish();
      AppMethodBeat.o(19886);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.10
 * JD-Core Version:    0.7.0.1
 */