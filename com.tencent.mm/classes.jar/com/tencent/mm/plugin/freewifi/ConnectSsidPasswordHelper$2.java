package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.wMH.ssid, m.axM("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1) && (this.wMH.ssid.equals(m.removeSsidQuote(paramContext.getExtraInfo())))) {
        try
        {
          this.wMH.aIR.lock();
          this.wMH.connected = true;
          this.wMH.wMF = false;
          this.wMH.dgF.signalAll();
          Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
          return;
        }
        finally
        {
          this.wMH.dMu();
          this.wMH.aIR.unlock();
          AppMethodBeat.o(24643);
        }
      }
      AppMethodBeat.o(24643);
      return;
    }
    if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (SupplicantState)paramIntent.getParcelableExtra("newState");
      switch (c.2.wMI[paramContext.ordinal()])
      {
      default: 
        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
      }
    }
    for (;;)
    {
      if (paramIntent.getIntExtra("supplicantError", -1) == 1) {}
      try
      {
        this.wMH.aIR.lock();
        this.wMH.connected = false;
        this.wMH.wMF = true;
        this.wMH.dgF.signalAll();
        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
        this.wMH.dMu();
        return;
      }
      finally
      {
        this.wMH.dMu();
        this.wMH.aIR.unlock();
        AppMethodBeat.o(24643);
      }
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
      continue;
      Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2
 * JD-Core Version:    0.7.0.1
 */