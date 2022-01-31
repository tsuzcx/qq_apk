package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class ConnectSsidPasswordHelper$2
  extends BroadcastReceiver
{
  public ConnectSsidPasswordHelper$2(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(20566);
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.mIi.ssid, m.Ow("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1) && (this.mIi.ssid.equals(m.Ou(paramContext.getExtraInfo())))) {
        try
        {
          this.mIi.mHZ.lock();
          this.mIi.connected = true;
          this.mIi.mIg = false;
          this.mIi.bVg.signalAll();
          ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
          return;
        }
        finally
        {
          this.mIi.bzQ();
          this.mIi.mHZ.unlock();
          AppMethodBeat.o(20566);
        }
      }
      AppMethodBeat.o(20566);
      return;
    }
    if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (SupplicantState)paramIntent.getParcelableExtra("newState");
      switch (c.2.mIj[paramContext.ordinal()])
      {
      default: 
        ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
      }
    }
    for (;;)
    {
      if (paramIntent.getIntExtra("supplicantError", -1) == 1) {}
      try
      {
        this.mIi.mHZ.lock();
        this.mIi.connected = false;
        this.mIi.mIg = true;
        this.mIi.bVg.signalAll();
        ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
        this.mIi.bzQ();
        return;
      }
      finally
      {
        this.mIi.bzQ();
        this.mIi.mHZ.unlock();
        AppMethodBeat.o(20566);
      }
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
      continue;
      ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2
 * JD-Core Version:    0.7.0.1
 */