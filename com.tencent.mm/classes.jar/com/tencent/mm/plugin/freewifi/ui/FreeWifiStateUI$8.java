package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiStateUI$8
  implements Runnable
{
  FreeWifiStateUI$8(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(21078);
    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { this.mOB.ssid });
    this.mOB.bBl();
    AppMethodBeat.o(21078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.8
 * JD-Core Version:    0.7.0.1
 */