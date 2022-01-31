package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiActivateStateUI$8
  implements Runnable
{
  FreeWifiActivateStateUI$8(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20906);
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { this.mMD.ssid });
    this.mMD.bBl();
    AppMethodBeat.o(20906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.8
 * JD-Core Version:    0.7.0.1
 */