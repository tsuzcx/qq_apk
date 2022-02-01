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
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class f
  extends e
  implements a
{
  private String dQC;
  
  public f(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24880);
    this.dQC = this.intent.getStringExtra("free_wifi_passowrd");
    Log.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.dQC });
    AppMethodBeat.o(24880);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24881);
    final com.tencent.mm.plugin.freewifi.c localc = new com.tencent.mm.plugin.freewifi.c(this.ssid, this.wPy, this.dQC);
    j.dNl();
    j.dNq().dMZ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24879);
        Object localObject1 = localc;
        c.1 local1 = new c.1((com.tencent.mm.plugin.freewifi.c)localObject1, new c.a()
        {
          public final void onFail(int paramAnonymous2Int)
          {
            AppMethodBeat.i(24878);
            Log.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.aw(f.this.intent), Integer.valueOf(m.ax(f.this.intent)), f.this.ssid, Integer.valueOf(paramAnonymous2Int) });
            Object localObject1 = k.dMF();
            ((k.a)localObject1).ssid = f.this.ssid;
            ((k.a)localObject1).bssid = m.axN("MicroMsg.FreeWifi.ProtocolFour");
            ((k.a)localObject1).dFe = m.axO("MicroMsg.FreeWifi.ProtocolFour");
            ((k.a)localObject1).dFd = f.this.dFd;
            ((k.a)localObject1).wNb = f.this.appId;
            ((k.a)localObject1).quX = m.aw(f.this.intent);
            ((k.a)localObject1).wNc = m.ay(f.this.intent);
            ((k.a)localObject1).wNd = k.b.wNo.wNO;
            ((k.a)localObject1).wNe = k.b.wNo.name;
            ((k.a)localObject1).result = paramAnonymous2Int;
            ((k.a)localObject1).channel = m.az(f.this.intent);
            ((k.a)localObject1).dMH().dMG();
            if (paramAnonymous2Int == -16)
            {
              f.this.intent.setClass(f.this.wPy.getContext(), FreeWifiCopyPwdUI.class);
              f.this.wPy.finish();
              localObject1 = f.this.wPy;
              localObject2 = f.this.intent;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((FreeWifiFrontPageUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24878);
              return;
            }
            if ((paramAnonymous2Int == -14) || (paramAnonymous2Int == -18))
            {
              localObject1 = f.this.wPy;
              localObject2 = FreeWifiFrontPageUI.d.wRO;
              locala = new FreeWifiFrontPageUI.a();
              locala.wRn = 2131760935;
              locala.wRo = m.a(f.this.wPz, k.b.wNo, paramAnonymous2Int);
              ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
              AppMethodBeat.o(24878);
              return;
            }
            localObject1 = f.this.wPy;
            Object localObject2 = FreeWifiFrontPageUI.d.wRO;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.wRn = 2131760934;
            locala.wRo = m.a(f.this.wPz, k.b.wNo, paramAnonymous2Int);
            ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
            AppMethodBeat.o(24878);
          }
          
          public final void onSuccess()
          {
            AppMethodBeat.i(24877);
            Log.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.aw(f.this.intent), Integer.valueOf(m.ax(f.this.intent)) });
            k.a locala = k.dMF();
            locala.ssid = f.this.ssid;
            locala.bssid = m.axN("MicroMsg.FreeWifi.ProtocolFour");
            locala.dFe = m.axO("MicroMsg.FreeWifi.ProtocolFour");
            locala.dFd = f.this.dFd;
            locala.wNb = f.this.appId;
            locala.quX = m.aw(f.this.intent);
            locala.wNc = m.ay(f.this.intent);
            locala.wNd = k.b.wNo.wNO;
            locala.wNe = k.b.wNo.name;
            locala.result = 0;
            locala.channel = m.az(f.this.intent);
            locala.dMH().dMG();
            m.a(f.this.intent, f.this.dFd, f.this.wPz, f.this.channelId, f.this.wPy, "MicroMsg.FreeWifi.ProtocolFour");
            AppMethodBeat.o(24877);
          }
        });
        if ((((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (((com.tencent.mm.plugin.freewifi.c)localObject1).ssid.equals(d.dNf())))
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
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aIR.lock();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).activity.registerReceiver(((com.tencent.mm.plugin.freewifi.c)localObject1).broadcastReceiver, localIntentFilter);
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).cnK.isWifiEnabled())
            {
              i = new com.tencent.mm.plugin.freewifi.e(((com.tencent.mm.plugin.freewifi.c)localObject1).activity).dMw();
              Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(i)));
              if (i != 0)
              {
                local1.onFail(i);
                return;
              }
            }
            int i = d.d(((com.tencent.mm.plugin.freewifi.c)localObject1).ssid, ((com.tencent.mm.plugin.freewifi.c)localObject1).dQC, 3, false);
            if (i != 0)
            {
              ((com.tencent.mm.plugin.freewifi.c)localObject1).dMu();
              local1.onFail(i);
              return;
            }
            try
            {
              if ((((com.tencent.mm.plugin.freewifi.c)localObject1).connected) || (((com.tencent.mm.plugin.freewifi.c)localObject1).wMF)) {
                break label489;
              }
              bool = ((com.tencent.mm.plugin.freewifi.c)localObject1).dgF.await(((com.tencent.mm.plugin.freewifi.c)localObject1).timeout, TimeUnit.MILLISECONDS);
              if (!bool)
              {
                local1.onFail(-16);
                return;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { m.aw(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent()), Integer.valueOf(m.ax(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent())), localInterruptedException.getMessage() });
              local1.onFail(-17);
              return;
            }
            if (((com.tencent.mm.plugin.freewifi.c)localObject1).connected)
            {
              local1.onSuccess();
              continue;
            }
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).wMF) {
              continue;
            }
          }
          finally
          {
            ((com.tencent.mm.plugin.freewifi.c)localObject1).dMu();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aIR.unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f
 * JD-Core Version:    0.7.0.1
 */