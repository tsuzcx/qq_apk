package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
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
    AppMethodBeat.i(20730);
    if ((paramContext == null) || (paramIntent == null))
    {
      ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
      AppMethodBeat.o(20730);
      return;
    }
    this.mKB.jNf = false;
    paramContext.unregisterReceiver(this.mKB.mKA);
    if ("android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction()))
    {
      paramContext = (WifiManager)ah.getContext().getSystemService("wifi");
      if (paramContext == null)
      {
        ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
        AppMethodBeat.o(20730);
        return;
      }
    }
    try
    {
      paramContext = paramContext.getScanResults();
      localh = this.mKB;
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
          break label241;
        }
        ab.i("MicroMsg.FreeWifi.WifiScanReceiver", i);
        if (this.mKB.mKz != null) {
          this.mKB.mKz.bR(paramIntent);
        }
        AppMethodBeat.o(20730);
        return;
      }
    }
    catch (SecurityException paramIntent)
    {
      for (;;)
      {
        h localh;
        paramContext = new ArrayList(0);
        ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + paramIntent.getMessage());
        continue;
        Collections.sort(paramContext, new h.2(localh));
        paramIntent = paramContext.subList(0, 20);
        continue;
        label241:
        i = paramIntent.size();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h.1
 * JD-Core Version:    0.7.0.1
 */