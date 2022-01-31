package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiActivateStateUI$8
  implements Runnable
{
  FreeWifiActivateStateUI$8(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { this.kqR.ssid });
    this.kqR.aUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.8
 * JD-Core Version:    0.7.0.1
 */