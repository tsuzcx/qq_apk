package com.tencent.mm.plugin.downloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static BroadcastReceiver iPV = null;
  private static int iPW = -1;
  
  public static void aFI()
  {
    if (iPV == null) {
      iPV = new a.a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ae.getContext().registerReceiver(iPV, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
    }
  }
  
  public static void aFJ()
  {
    if (iPV != null) {}
    try
    {
      ae.getContext().unregisterReceiver(iPV);
      iPV = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.a
 * JD-Core Version:    0.7.0.1
 */