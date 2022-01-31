package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class ExdeviceConnectWifiUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceConnectWifiUI$10(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!ExdeviceConnectWifiUI.h(this.jCy))
    {
      paramMenuItem = new Intent();
      if (ExdeviceConnectWifiUI.d(this.jCy) == ExdeviceConnectWifiUI.b.jCJ) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      paramMenuItem.putExtra("is_wifi_connected", bool);
      this.jCy.setResult(0, paramMenuItem);
      this.jCy.finish();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.10
 * JD-Core Version:    0.7.0.1
 */