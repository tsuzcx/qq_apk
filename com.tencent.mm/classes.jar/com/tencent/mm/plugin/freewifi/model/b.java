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
  a tmC;
  BroadcastReceiver tmD;
  
  private b()
  {
    AppMethodBeat.i(24769);
    this.tmC = new a((byte)0);
    this.tmD = new BroadcastReceiver()
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
              paramAnonymousContext = m.ajI(m.ajK("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
              String str = m.ajL("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
              paramAnonymousIntent = m.ajI(m.ajJ(paramAnonymousIntent.getExtraInfo()));
              ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramAnonymousIntent, paramAnonymousContext, str });
              if (!m.ajJ(paramAnonymousIntent).equals(paramAnonymousContext))
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                AppMethodBeat.o(24765);
                return;
              }
              if ((b.this.tmC.type == 1) && (m.ajJ(b.this.tmC.ssid).equals(paramAnonymousContext)) && (m.ajJ(b.this.tmC.bssid).equals(str)))
              {
                ad.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousIntent = new b.a((byte)0);
              paramAnonymousIntent.tmF = System.currentTimeMillis();
              paramAnonymousIntent.type = 1;
              paramAnonymousIntent.ssid = paramAnonymousContext;
              paramAnonymousIntent.bssid = str;
              paramAnonymousIntent.tmG = "";
              b.b(b.this.tmC.cRj(), paramAnonymousIntent);
              b.this.tmC = paramAnonymousIntent;
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 0)
            {
              if ((b.this.tmC.type == 0) && (m.ajJ(b.this.tmC.tmG).equals(m.ajJ(paramAnonymousIntent.getExtraInfo()))))
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
              paramAnonymousContext.tmF = System.currentTimeMillis();
              paramAnonymousContext.type = 0;
              paramAnonymousContext.ssid = "";
              paramAnonymousContext.bssid = "";
              paramAnonymousContext.tmG = m.ajJ(paramAnonymousIntent.getExtraInfo());
              b.a(b.this.tmC.cRj(), paramAnonymousContext);
              b.this.tmC = paramAnonymousContext;
              AppMethodBeat.o(24765);
              return;
            }
            AppMethodBeat.o(24765);
            return;
          }
          catch (Exception paramAnonymousContext)
          {
            paramAnonymousIntent = k.cQR();
            paramAnonymousIntent.dmM = "UnExpectedException";
            paramAnonymousIntent.result = -1;
            paramAnonymousIntent.fKQ = m.l(paramAnonymousContext);
            paramAnonymousIntent.cQT().cQS();
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
    m.ajN("on mobile connected.");
    ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.ma(0);
    AppMethodBeat.o(24771);
  }
  
  static void b(a parama1, a parama2)
  {
    AppMethodBeat.i(24772);
    m.ajN("on wifi connected.");
    ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.ajN("on wifi roaming.");
      ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.ma(1);
    AppMethodBeat.o(24772);
  }
  
  public final void cQG()
  {
    AppMethodBeat.i(24770);
    try
    {
      aj.getContext().unregisterReceiver(this.tmD);
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
    String ssid = "";
    long tmF;
    String tmG = "";
    int type;
    
    public final a cRj()
    {
      AppMethodBeat.i(24766);
      a locala = new a();
      locala.tmF = this.tmF;
      locala.type = this.type;
      locala.ssid = this.ssid;
      locala.bssid = this.bssid;
      locala.tmG = this.tmG;
      AppMethodBeat.o(24766);
      return locala;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24767);
      String str = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.tmF), Integer.valueOf(this.type), this.ssid, this.bssid, this.tmG });
      AppMethodBeat.o(24767);
      return str;
    }
  }
  
  static final class b
  {
    private static b tmH;
    
    static
    {
      AppMethodBeat.i(24768);
      tmH = new b((byte)0);
      AppMethodBeat.o(24768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */