package com.tencent.mm.plugin.exdevice.ui;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager.MulticastLock;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceConnectWifiUI$2
  implements Runnable
{
  ExdeviceConnectWifiUI$2(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI, String paramString1, String paramString2, WifiInfo paramWifiInfo) {}
  
  public final void run()
  {
    ExdeviceConnectWifiUI.f(this.jCy).acquire();
    y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", new Object[] { Integer.valueOf(Java2CExDevice.startAirKissWithInter(this.jCz, this.jCA, ExdeviceConnectWifiUI.l(this.jCy), 60000L, ExdeviceConnectWifiUI.m(this.jCy), ExdeviceConnectWifiUI.n(this.jCy))), this.jCA, this.jCB.getSSID(), this.jCB.getBSSID() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.2
 * JD-Core Version:    0.7.0.1
 */