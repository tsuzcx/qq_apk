package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class ConnectSsidPasswordHelper$2
  extends BroadcastReceiver
{
  public ConnectSsidPasswordHelper$2(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(24643);
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.soi.ssid, m.afm("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1) && (this.soi.ssid.equals(m.afk(paramContext.getExtraInfo())))) {
        try
        {
          this.soi.aHh.lock();
          this.soi.connected = true;
          this.soi.sog = false;
          this.soi.cEv.signalAll();
          ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
          return;
        }
        finally
        {
          this.soi.cIr();
          this.soi.aHh.unlock();
          AppMethodBeat.o(24643);
        }
      }
      AppMethodBeat.o(24643);
      return;
    }
    if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (SupplicantState)paramIntent.getParcelableExtra("newState");
      switch (c.2.soj[paramContext.ordinal()])
      {
      default: 
        ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
      }
    }
    for (;;)
    {
      if (paramIntent.getIntExtra("supplicantError", -1) == 1) {}
      try
      {
        this.soi.aHh.lock();
        this.soi.connected = false;
        this.soi.sog = true;
        this.soi.cEv.signalAll();
        ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
        this.soi.cIr();
        return;
      }
      finally
      {
        this.soi.cIr();
        this.soi.aHh.unlock();
        AppMethodBeat.o(24643);
      }
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
      continue;
      ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2
 * JD-Core Version:    0.7.0.1
 */