package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;

public final class WiFiConnector$2
  extends BroadcastReceiver
{
  public WiFiConnector$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if (TextUtils.isEmpty(paramContext)) {
        continue;
      }
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
      {
        paramContext = this.gHn.gHk.getActiveNetworkInfo();
        paramIntent = c.getConnectionInfo();
        if ((paramContext == null) || (paramIntent == null) || (paramContext.getType() != 1) || (paramContext.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) || (paramIntent.getNetworkId() != this.gHn.gHj.networkId)) {
          continue;
        }
        this.gHn.g(true, "");
        y.i("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
        return;
      }
      if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(paramContext)) {
        continue;
      }
      try
      {
        i = paramIntent.getIntExtra("supplicantError", -1);
        if (i != 1) {
          continue;
        }
        y.e("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
        y.i("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
        this.gHn.g(false, "password error");
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.e("MicroMsg.WiFiConnector", paramContext.getMessage());
          int i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2
 * JD-Core Version:    0.7.0.1
 */