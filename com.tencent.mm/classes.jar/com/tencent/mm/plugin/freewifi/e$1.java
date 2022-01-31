package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e$1
  extends BroadcastReceiver
{
  e$1(e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("wifi_state", 0);
      y.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + i);
      if (i != 3) {}
    }
    try
    {
      this.kmA.kmn.lock();
      this.kmA.btV.signalAll();
      return;
    }
    finally
    {
      this.kmA.aTl();
      this.kmA.kmn.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.1
 * JD-Core Version:    0.7.0.1
 */