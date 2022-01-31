package com.tencent.mm.plugin.freewifi.e;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.c.1;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.e;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class f$1
  implements Runnable
{
  f$1(f paramf, c paramc) {}
  
  public final void run()
  {
    c localc = this.kpw;
    c.1 local1 = new c.1(localc, new f.1.1(this));
    if ((((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (localc.ssid.equals(d.aUa())))
    {
      local1.onSuccess();
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
    }
    localc.kmq = new ConnectSsidPasswordHelper.2(localc);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    for (;;)
    {
      try
      {
        localc.kmn.lock();
        localc.activity.registerReceiver(localc.kmq, localIntentFilter);
        if (!localc.bci.isWifiEnabled())
        {
          i = new e(localc.activity).aTn();
          y.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = " + i);
          if (i != 0)
          {
            local1.onFail(i);
            return;
          }
        }
        int i = d.c(localc.ssid, localc.foj, 3, false);
        if (i != 0)
        {
          localc.aTl();
          local1.onFail(i);
          return;
        }
        try
        {
          if ((localc.connected) || (localc.kmu)) {
            break label446;
          }
          bool = localc.btV.await(localc.edM, TimeUnit.MILLISECONDS);
          if (!bool)
          {
            local1.onFail(-16);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          y.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { m.B(localc.activity.getIntent()), Integer.valueOf(m.C(localc.activity.getIntent())), localInterruptedException.getMessage() });
          local1.onFail(-17);
          return;
        }
        if (localc.connected)
        {
          local1.onSuccess();
          continue;
        }
        if (!localc.kmu) {
          continue;
        }
      }
      finally
      {
        localc.aTl();
        localc.kmn.unlock();
      }
      localObject.onFail(-18);
      continue;
      label446:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f.1
 * JD-Core Version:    0.7.0.1
 */