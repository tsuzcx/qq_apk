package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class a$2
  extends BroadcastReceiver
{
  a$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE"))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.kms.ssid, m.Do("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
      if ((paramContext == null) || (!paramContext.isConnected()) || (paramContext.getType() != 1) || (!this.kms.ssid.equals(m.Dm(paramContext.getExtraInfo())))) {}
    }
    do
    {
      do
      {
        try
        {
          this.kms.kmn.lock();
          this.kms.kmo = true;
          y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
          this.kms.btV.signalAll();
          return;
        }
        finally
        {
          this.kms.kmn.unlock();
        }
      } while (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"));
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { this.kms.ssid, m.Do("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramContext.isConnected()), Boolean.valueOf(paramContext.isConnectedOrConnecting()), paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()), paramContext.toString() });
      }
    } while ((paramContext == null) || (!paramContext.isConnected()) || (paramContext.getType() != 1) || (!this.kms.ssid.equals(m.Dm(paramContext.getExtraInfo()))));
    try
    {
      this.kms.kmn.lock();
      this.kms.kmp = true;
      y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
      this.kms.btV.signalAll();
      return;
    }
    finally
    {
      this.kms.kmn.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.2
 * JD-Core Version:    0.7.0.1
 */