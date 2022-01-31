package com.tencent.mm.plugin.exdevice.ui;

import android.net.wifi.WifiManager.MulticastLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceConnectWifiUI$2
  implements Runnable
{
  ExdeviceConnectWifiUI$2(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(19872);
    ExdeviceConnectWifiUI.f(this.lLW).acquire();
    ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s", new Object[] { Integer.valueOf(Java2CExDevice.startAirKissWithInter(this.lLX, this.lLY, ExdeviceConnectWifiUI.l(this.lLW), 60000L, ExdeviceConnectWifiUI.m(this.lLW), ExdeviceConnectWifiUI.n(this.lLW))), this.lLY });
    AppMethodBeat.o(19872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.2
 * JD-Core Version:    0.7.0.1
 */