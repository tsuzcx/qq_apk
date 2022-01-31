package com.tencent.mm.plugin.freewifi.e;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.c.1;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.e;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class f$1
  implements Runnable
{
  f$1(f paramf, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(20809);
    Object localObject1 = this.mLi;
    c.1 local1 = new c.1((c)localObject1, new f.1.1(this));
    if ((((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (((c)localObject1).ssid.equals(d.bAC())))
    {
      local1.onSuccess();
      AppMethodBeat.o(20809);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      localObject1 = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
      AppMethodBeat.o(20809);
      throw ((Throwable)localObject1);
    }
    ((c)localObject1).broadcastReceiver = new ConnectSsidPasswordHelper.2((c)localObject1);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    for (;;)
    {
      try
      {
        ((c)localObject1).mHZ.lock();
        ((c)localObject1).activity.registerReceiver(((c)localObject1).broadcastReceiver, localIntentFilter);
        if (!((c)localObject1).bsO.isWifiEnabled())
        {
          i = new e(((c)localObject1).activity).bzS();
          ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(i)));
          if (i != 0)
          {
            local1.onFail(i);
            return;
          }
        }
        int i = d.c(((c)localObject1).ssid, ((c)localObject1).gFE, 3, false);
        if (i != 0)
        {
          ((c)localObject1).bzQ();
          local1.onFail(i);
          return;
        }
        try
        {
          if ((((c)localObject1).connected) || (((c)localObject1).mIg)) {
            break label489;
          }
          bool = ((c)localObject1).bVg.await(((c)localObject1).ftP, TimeUnit.MILLISECONDS);
          if (!bool)
          {
            local1.onFail(-16);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { m.U(((c)localObject1).activity.getIntent()), Integer.valueOf(m.V(((c)localObject1).activity.getIntent())), localInterruptedException.getMessage() });
          local1.onFail(-17);
          return;
        }
        if (((c)localObject1).connected)
        {
          local1.onSuccess();
          continue;
        }
        if (!((c)localObject1).mIg) {
          continue;
        }
      }
      finally
      {
        ((c)localObject1).bzQ();
        ((c)localObject1).mHZ.unlock();
        AppMethodBeat.o(20809);
      }
      localObject2.onFail(-18);
      continue;
      label489:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f.1
 * JD-Core Version:    0.7.0.1
 */