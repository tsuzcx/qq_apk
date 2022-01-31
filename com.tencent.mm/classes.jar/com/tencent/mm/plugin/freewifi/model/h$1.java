package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class h$1
  extends BroadcastReceiver
{
  h$1(h paramh) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if ((paramContext == null) || (paramIntent == null)) {
      y.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
    }
    for (;;)
    {
      return;
      this.koO.hTl = false;
      paramContext.unregisterReceiver(this.koO.koN);
      if (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())) {
        continue;
      }
      paramContext = (WifiManager)ae.getContext().getSystemService("wifi");
      if (paramContext == null)
      {
        y.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
        return;
      }
      try
      {
        paramContext = paramContext.getScanResults();
        localh = this.koO;
        paramIntent = paramContext;
        if (paramContext != null)
        {
          if (paramContext.size() <= 20) {
            paramIntent = paramContext;
          }
        }
        else
        {
          paramContext = new StringBuilder("wifiManager scanResults size = ");
          if (paramIntent != null) {
            break label217;
          }
          y.i("MicroMsg.FreeWifi.WifiScanReceiver", i);
          if (this.koO.koM == null) {
            continue;
          }
          this.koO.koM.bx(paramIntent);
          return;
        }
      }
      catch (SecurityException paramIntent)
      {
        for (;;)
        {
          h localh;
          paramContext = new ArrayList(0);
          y.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + paramIntent.getMessage());
          continue;
          Collections.sort(paramContext, new h.2(localh));
          paramIntent = paramContext.subList(0, 20);
          continue;
          label217:
          i = paramIntent.size();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h.1
 * JD-Core Version:    0.7.0.1
 */