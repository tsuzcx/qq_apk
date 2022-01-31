package com.tencent.mm.plugin.freewifi.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ae;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", this.knT);
    localIntent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", this.knU);
    localIntent.setClass(ae.getContext(), FreeWifiManufacturerLoadingUI.class);
    localIntent.addFlags(268435456);
    ae.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b.2
 * JD-Core Version:    0.7.0.1
 */