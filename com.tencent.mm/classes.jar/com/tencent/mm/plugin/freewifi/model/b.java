package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  a rhh;
  BroadcastReceiver rhi;
  
  private b()
  {
    AppMethodBeat.i(24769);
    this.rhh = new a((byte)0);
    this.rhi = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(24765);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          try
          {
            ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
            paramAnonymousIntent = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
            if (paramAnonymousIntent == null)
            {
              ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
              AppMethodBeat.o(24765);
              return;
            }
            ad.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + paramAnonymousIntent.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[] { Boolean.valueOf(paramAnonymousIntent.isConnected()), paramAnonymousIntent.getState(), paramAnonymousIntent.getDetailedState(), paramAnonymousIntent.getExtraInfo(), Boolean.valueOf(paramAnonymousIntent.isConnectedOrConnecting()), Boolean.valueOf(paramAnonymousIntent.isAvailable()) });
            if (!paramAnonymousIntent.isConnected())
            {
              ad.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
              AppMethodBeat.o(24765);
              return;
            }
            if ((paramAnonymousIntent.getType() != 0) && (paramAnonymousIntent.getType() != 1))
            {
              ad.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousContext == null)
            {
              ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 1)
            {
              paramAnonymousContext = m.aas(m.aau("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
              String str = m.aav("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
              paramAnonymousIntent = m.aas(m.aat(paramAnonymousIntent.getExtraInfo()));
              ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramAnonymousIntent, paramAnonymousContext, str });
              if (!m.aat(paramAnonymousIntent).equals(paramAnonymousContext))
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                AppMethodBeat.o(24765);
                return;
              }
              if ((b.this.rhh.type == 1) && (m.aat(b.this.rhh.ssid).equals(paramAnonymousContext)) && (m.aat(b.this.rhh.bssid).equals(str)))
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousIntent = new b.a((byte)0);
              paramAnonymousIntent.rhk = System.currentTimeMillis();
              paramAnonymousIntent.type = 1;
              paramAnonymousIntent.ssid = paramAnonymousContext;
              paramAnonymousIntent.bssid = str;
              paramAnonymousIntent.rhl = "";
              b.b(b.this.rhh.cvI(), paramAnonymousIntent);
              b.this.rhh = paramAnonymousIntent;
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 0)
            {
              if ((b.this.rhh.type == 0) && (m.aat(b.this.rhh.rhl).equals(m.aat(paramAnonymousIntent.getExtraInfo()))))
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
              if (paramAnonymousContext == null)
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = paramAnonymousContext.getNetworkInfo(1);
              if (paramAnonymousContext == null)
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                AppMethodBeat.o(24765);
                return;
              }
              ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[] { paramAnonymousContext.getState(), paramAnonymousContext.getDetailedState() });
              if (paramAnonymousContext.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED)
              {
                ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = new b.a((byte)0);
              paramAnonymousContext.rhk = System.currentTimeMillis();
              paramAnonymousContext.type = 0;
              paramAnonymousContext.ssid = "";
              paramAnonymousContext.bssid = "";
              paramAnonymousContext.rhl = m.aat(paramAnonymousIntent.getExtraInfo());
              b.a(b.this.rhh.cvI(), paramAnonymousContext);
              b.this.rhh = paramAnonymousContext;
              AppMethodBeat.o(24765);
              return;
            }
            AppMethodBeat.o(24765);
            return;
          }
          catch (Exception paramAnonymousContext)
          {
            paramAnonymousIntent = k.cvq();
            paramAnonymousIntent.ddU = "UnExpectedException";
            paramAnonymousIntent.result = -1;
            paramAnonymousIntent.foR = m.l(paramAnonymousContext);
            paramAnonymousIntent.cvs().cvr();
            ad.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(paramAnonymousContext));
          }
        }
        AppMethodBeat.o(24765);
      }
    };
    AppMethodBeat.o(24769);
  }
  
  static void a(a parama1, a parama2)
  {
    AppMethodBeat.i(24771);
    m.aax("on mobile connected.");
    ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.lI(0);
    AppMethodBeat.o(24771);
  }
  
  static void b(a parama1, a parama2)
  {
    AppMethodBeat.i(24772);
    m.aax("on wifi connected.");
    ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.aax("on wifi roaming.");
      ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.lI(1);
    AppMethodBeat.o(24772);
  }
  
  public final void cvf()
  {
    AppMethodBeat.i(24770);
    try
    {
      aj.getContext().unregisterReceiver(this.rhi);
      AppMethodBeat.o(24770);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(24770);
    }
  }
  
  static final class a
  {
    String bssid = "";
    long rhk;
    String rhl = "";
    String ssid = "";
    int type;
    
    public final a cvI()
    {
      AppMethodBeat.i(24766);
      a locala = new a();
      locala.rhk = this.rhk;
      locala.type = this.type;
      locala.ssid = this.ssid;
      locala.bssid = this.bssid;
      locala.rhl = this.rhl;
      AppMethodBeat.o(24766);
      return locala;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24767);
      String str = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.rhk), Integer.valueOf(this.type), this.ssid, this.bssid, this.rhl });
      AppMethodBeat.o(24767);
      return str;
    }
  }
  
  static final class b
  {
    private static b rhm;
    
    static
    {
      AppMethodBeat.i(24768);
      rhm = new b((byte)0);
      AppMethodBeat.o(24768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */