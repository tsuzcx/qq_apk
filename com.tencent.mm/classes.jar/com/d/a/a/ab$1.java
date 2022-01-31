package com.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import java.util.List;

final class ab$1
  extends BroadcastReceiver
{
  ab$1(ab paramab) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
    {
      paramContext = this.bcg;
      try
      {
        paramIntent = paramContext.aVR.getScanResults();
        if ((paramIntent == null) || (paramIntent.isEmpty())) {
          throw new Exception("WifiScanMsg: null or empty scan result list");
        }
        paramContext.c(new ab.a(paramIntent));
        return;
      }
      catch (Exception paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.ab.1
 * JD-Core Version:    0.7.0.1
 */