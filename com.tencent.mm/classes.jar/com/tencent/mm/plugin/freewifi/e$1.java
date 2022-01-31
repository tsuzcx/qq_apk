package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e$1
  extends BroadcastReceiver
{
  e$1(e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(20571);
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("wifi_state", 0);
      ab.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(i)));
      if (i == 3) {
        try
        {
          this.mIm.mHZ.lock();
          this.mIm.bVg.signalAll();
          return;
        }
        finally
        {
          this.mIm.bzQ();
          this.mIm.mHZ.unlock();
          AppMethodBeat.o(20571);
        }
      }
    }
    AppMethodBeat.o(20571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.1
 * JD-Core Version:    0.7.0.1
 */