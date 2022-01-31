package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ui.base.p;

final class ExdeviceConnectWifiUI$6
  implements Runnable
{
  ExdeviceConnectWifiUI$6(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    if ((ExdeviceConnectWifiUI.g(this.jCy) != null) && (ExdeviceConnectWifiUI.g(this.jCy).isShowing())) {
      ExdeviceConnectWifiUI.g(this.jCy).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.6
 * JD-Core Version:    0.7.0.1
 */