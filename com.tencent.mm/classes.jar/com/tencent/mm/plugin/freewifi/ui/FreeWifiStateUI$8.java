package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiStateUI$8
  implements Runnable
{
  FreeWifiStateUI$8(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { this.ksM.ssid });
    this.ksM.aUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.8
 * JD-Core Version:    0.7.0.1
 */