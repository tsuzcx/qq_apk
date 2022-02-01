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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class WiFiConnector$2
  extends BroadcastReceiver
{
  public WiFiConnector$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(144703);
    if (paramIntent == null)
    {
      AppMethodBeat.o(144703);
      return;
    }
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext))
    {
      AppMethodBeat.o(144703);
      return;
    }
    ad.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent, action: ".concat(String.valueOf(paramContext)));
    if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) || ("android.net.wifi.STATE_CHANGE".equals(paramContext)))
    {
      paramContext = this.lwG.lwC.getActiveNetworkInfo();
      paramIntent = c.getConnectionInfo();
      if ((paramContext != null) && (paramIntent != null) && (paramContext.getType() == 1) && (paramContext.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) && (paramIntent.getNetworkId() == this.lwG.lwB.networkId))
      {
        this.lwG.q(true, "");
        ad.i("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
      }
      AppMethodBeat.o(144703);
      return;
    }
    if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramContext)) {}
    try
    {
      i = paramIntent.getIntExtra("supplicantError", -1);
      if (i == 1)
      {
        ad.e("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
        ad.i("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
        paramIntent = this.lwG;
        if (this.lwG.lwF)
        {
          paramContext = "wifi config may be expired";
          paramIntent.q(false, paramContext);
        }
      }
      else
      {
        AppMethodBeat.o(144703);
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.e("MicroMsg.WiFiConnector", paramContext.getMessage());
        int i = -1;
        continue;
        paramContext = "password error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2
 * JD-Core Version:    0.7.0.1
 */