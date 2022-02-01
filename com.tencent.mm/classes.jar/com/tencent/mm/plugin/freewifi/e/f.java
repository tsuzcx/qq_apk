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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class f
  extends e
  implements a
{
  private String dom;
  
  public f(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24880);
    this.dom = this.intent.getStringExtra("free_wifi_passowrd");
    ad.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), this.dom });
    AppMethodBeat.o(24880);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24881);
    final com.tencent.mm.plugin.freewifi.c localc = new com.tencent.mm.plugin.freewifi.c(this.ssid, this.rij, this.dom);
    j.cvW();
    j.cwb().cvK().post(new Runnable()
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
            ad.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.ai(f.this.intent), Integer.valueOf(m.aj(f.this.intent)), f.this.ssid, Integer.valueOf(paramAnonymous2Int) });
            Object localObject1 = k.cvq();
            ((k.a)localObject1).ssid = f.this.ssid;
            ((k.a)localObject1).bssid = m.aav("MicroMsg.FreeWifi.ProtocolFour");
            ((k.a)localObject1).ddV = m.aaw("MicroMsg.FreeWifi.ProtocolFour");
            ((k.a)localObject1).ddU = f.this.ddU;
            ((k.a)localObject1).rfK = f.this.appId;
            ((k.a)localObject1).nSA = m.ai(f.this.intent);
            ((k.a)localObject1).rfL = m.ak(f.this.intent);
            ((k.a)localObject1).rfM = k.b.rfX.rgx;
            ((k.a)localObject1).rfN = k.b.rfX.name;
            ((k.a)localObject1).result = paramAnonymous2Int;
            ((k.a)localObject1).channel = m.al(f.this.intent);
            ((k.a)localObject1).cvs().cvr();
            if (paramAnonymous2Int == -16)
            {
              f.this.intent.setClass(f.this.rij.getContext(), FreeWifiCopyPwdUI.class);
              f.this.rij.finish();
              localObject1 = f.this.rij;
              localObject2 = f.this.intent;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((FreeWifiFrontPageUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24878);
              return;
            }
            if ((paramAnonymous2Int == -14) || (paramAnonymous2Int == -18))
            {
              localObject1 = f.this.rij;
              localObject2 = FreeWifiFrontPageUI.d.rkB;
              locala = new FreeWifiFrontPageUI.a();
              locala.rjZ = 2131759614;
              locala.rka = m.a(f.this.rik, k.b.rfX, paramAnonymous2Int);
              ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
              AppMethodBeat.o(24878);
              return;
            }
            localObject1 = f.this.rij;
            Object localObject2 = FreeWifiFrontPageUI.d.rkB;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.rjZ = 2131759613;
            locala.rka = m.a(f.this.rik, k.b.rfX, paramAnonymous2Int);
            ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
            AppMethodBeat.o(24878);
          }
          
          public final void onSuccess()
          {
            AppMethodBeat.i(24877);
            ad.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.ai(f.this.intent), Integer.valueOf(m.aj(f.this.intent)) });
            k.a locala = k.cvq();
            locala.ssid = f.this.ssid;
            locala.bssid = m.aav("MicroMsg.FreeWifi.ProtocolFour");
            locala.ddV = m.aaw("MicroMsg.FreeWifi.ProtocolFour");
            locala.ddU = f.this.ddU;
            locala.rfK = f.this.appId;
            locala.nSA = m.ai(f.this.intent);
            locala.rfL = m.ak(f.this.intent);
            locala.rfM = k.b.rfX.rgx;
            locala.rfN = k.b.rfX.name;
            locala.result = 0;
            locala.channel = m.al(f.this.intent);
            locala.cvs().cvr();
            m.a(f.this.intent, f.this.ddU, f.this.rik, f.this.cJR, f.this.rij, "MicroMsg.FreeWifi.ProtocolFour");
            AppMethodBeat.o(24877);
          }
        });
        if ((((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (((com.tencent.mm.plugin.freewifi.c)localObject1).ssid.equals(d.cvQ())))
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
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aGr.lock();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).activity.registerReceiver(((com.tencent.mm.plugin.freewifi.c)localObject1).broadcastReceiver, localIntentFilter);
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).bVj.isWifiEnabled())
            {
              i = new com.tencent.mm.plugin.freewifi.e(((com.tencent.mm.plugin.freewifi.c)localObject1).activity).cvh();
              ad.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(i)));
              if (i != 0)
              {
                local1.onFail(i);
                return;
              }
            }
            int i = d.e(((com.tencent.mm.plugin.freewifi.c)localObject1).ssid, ((com.tencent.mm.plugin.freewifi.c)localObject1).dom, 3, false);
            if (i != 0)
            {
              ((com.tencent.mm.plugin.freewifi.c)localObject1).cvf();
              local1.onFail(i);
              return;
            }
            try
            {
              if ((((com.tencent.mm.plugin.freewifi.c)localObject1).connected) || (((com.tencent.mm.plugin.freewifi.c)localObject1).rfo)) {
                break label489;
              }
              bool = ((com.tencent.mm.plugin.freewifi.c)localObject1).cHn.await(((com.tencent.mm.plugin.freewifi.c)localObject1).csI, TimeUnit.MILLISECONDS);
              if (!bool)
              {
                local1.onFail(-16);
                return;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              ad.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { m.ai(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent()), Integer.valueOf(m.aj(((com.tencent.mm.plugin.freewifi.c)localObject1).activity.getIntent())), localInterruptedException.getMessage() });
              local1.onFail(-17);
              return;
            }
            if (((com.tencent.mm.plugin.freewifi.c)localObject1).connected)
            {
              local1.onSuccess();
              continue;
            }
            if (!((com.tencent.mm.plugin.freewifi.c)localObject1).rfo) {
              continue;
            }
          }
          finally
          {
            ((com.tencent.mm.plugin.freewifi.c)localObject1).cvf();
            ((com.tencent.mm.plugin.freewifi.c)localObject1).aGr.unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f
 * JD-Core Version:    0.7.0.1
 */