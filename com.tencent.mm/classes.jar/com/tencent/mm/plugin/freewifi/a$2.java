package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class a$2
  extends BroadcastReceiver
{
  a$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(20556);
    if (paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE"))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.mIe.ssid, m.Ow("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1) && (this.mIe.ssid.equals(m.Ou(paramContext.getExtraInfo())))) {
        try
        {
          this.mIe.mHZ.lock();
          this.mIe.mIa = true;
          ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
          this.mIe.bVg.signalAll();
          return;
        }
        finally
        {
          this.mIe.mHZ.unlock();
          AppMethodBeat.o(20556);
        }
      }
      AppMethodBeat.o(20556);
      return;
    }
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.mIe.ssid, m.Ow("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1) && (this.mIe.ssid.equals(m.Ou(paramContext.getExtraInfo())))) {
        try
        {
          this.mIe.mHZ.lock();
          this.mIe.mIb = true;
          ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
          this.mIe.bVg.signalAll();
          return;
        }
        finally
        {
          this.mIe.mHZ.unlock();
          AppMethodBeat.o(20556);
        }
      }
    }
    AppMethodBeat.o(20556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.2
 * JD-Core Version:    0.7.0.1
 */