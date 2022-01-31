package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FreeWifiNetworkReceiver
  extends BroadcastReceiver
{
  public FreeWifiNetworkReceiver.b koK;
  public FreeWifiNetworkReceiver.a koL;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            paramContext = paramIntent.getAction();
            y.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", new Object[] { paramContext });
            if (bk.bl(paramContext))
            {
              y.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
              return;
            }
            if (!paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
              break;
            }
            i = paramIntent.getIntExtra("wifi_state", 0);
            y.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", new Object[] { Integer.valueOf(i) });
          } while (this.koK == null);
          this.koK.rs(i);
          return;
        } while (!paramContext.equals("android.net.wifi.STATE_CHANGE"));
        paramContext = paramIntent.getParcelableExtra("networkInfo");
      } while (paramContext == null);
      paramContext = (NetworkInfo)paramContext;
    } while ((paramContext == null) || (this.koL == null));
    this.koL.a(paramContext.getState());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */