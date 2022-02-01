package com.tencent.mm.plugin.freewifi.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2;
import com.tencent.mm.plugin.freewifi.c.1;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class f
  extends e
  implements a
{
  private String dlV;
  
  public f(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24880);
    this.dlV = this.intent.getStringExtra("free_wifi_passowrd");
    ac.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), this.dlV });
    AppMethodBeat.o(24880);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24881);
    final com.tencent.mm.plugin.freewifi.c localc = new com.tencent.mm.plugin.freewifi.c(this.ssid, this.srb, this.dlV);
    j.cJi();
    j.cJn().cIW().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24879);
        Object localObject1 = localc;
        c.1 local1 = new c.1((com.tencent.mm.plugin.freewifi.c)localObject1, new f.1.1(this));
        if ((((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (((com.tencent.mm.plugin.freewifi.c)localObject1).ssid.equals(d.cJc())))
        {
          local1.onSuccess();
          AppMethodBeat.o(24879);
          return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          localObject1 = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
          AppMethodBeat.o(24879);
          throw ((Throwable)localObject1);
        }
        ((com.tencent.mm.plugin.freewifi.c)localObject1).broadcastReceiver = new ConnectSsidPasswordHelper.2((com.tencent.mm.plugin.freewifi.c)localObject1);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
        localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aHh.lock();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).activity.registerReceiver(((com.tencent.mm.plugin.freewifi.c)localObject1).broadcastReceiver, localIntentFilter);
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).bSR.isWifiEnabled())
            {
              i = new com.tencent.mm.plugin.freewifi.e(((com.tencent.mm.plugin.freewifi.c)localObject1).activity).cIt();
              ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(i)));
              if (i != 0)
              {
                local1.onFail(i);
                return;
              }
            }
            int i = d.e(((com.tencent.mm.plugin.freewifi.c)localObject1).ssid, ((com.tencent.mm.plugin.freewifi.c)localObject1).dlV, 3, false);
            if (i != 0)
            {
              ((com.tencent.mm.plugin.freewifi.c)localObject1).cIr();
              local1.onFail(i);
              return;
            }
            try
            {
              if ((((com.tencent.mm.plugin.freewifi.c)localObject1).connected) || (((com.tencent.mm.plugin.freewifi.c)localObject1).sog)) {
                break label489;
              }
              bool = ((com.tencent.mm.plugin.freewifi.c)localObject1).cEv.await(((com.tencent.mm.plugin.freewifi.c)localObject1).cpQ, TimeUnit.MILLISECONDS);
              if (!bool)
              {
                local1.onFail(-16);
                return;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              ac.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { m.aj(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent()), Integer.valueOf(m.ak(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent())), localInterruptedException.getMessage() });
              local1.onFail(-17);
              return;
            }
            if (((com.tencent.mm.plugin.freewifi.c)localObject1).connected)
            {
              local1.onSuccess();
              continue;
            }
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).sog) {
              continue;
            }
          }
          finally
          {
            ((com.tencent.mm.plugin.freewifi.c)localObject1).cIr();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aHh.unlock();
            AppMethodBeat.o(24879);
          }
          localObject2.onFail(-18);
          continue;
          label489:
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(24881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f
 * JD-Core Version:    0.7.0.1
 */