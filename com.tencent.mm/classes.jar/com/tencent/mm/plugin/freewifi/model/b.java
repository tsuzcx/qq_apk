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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
{
  a txu;
  BroadcastReceiver txv;
  
  private b()
  {
    AppMethodBeat.i(24769);
    this.txu = new a((byte)0);
    this.txv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(24765);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          try
          {
            ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
            paramAnonymousIntent = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
            if (paramAnonymousIntent == null)
            {
              ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
              AppMethodBeat.o(24765);
              return;
            }
            ae.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + paramAnonymousIntent.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[] { Boolean.valueOf(paramAnonymousIntent.isConnected()), paramAnonymousIntent.getState(), paramAnonymousIntent.getDetailedState(), paramAnonymousIntent.getExtraInfo(), Boolean.valueOf(paramAnonymousIntent.isConnectedOrConnecting()), Boolean.valueOf(paramAnonymousIntent.isAvailable()) });
            if (!paramAnonymousIntent.isConnected())
            {
              ae.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
              AppMethodBeat.o(24765);
              return;
            }
            if ((paramAnonymousIntent.getType() != 0) && (paramAnonymousIntent.getType() != 1))
            {
              ae.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousContext == null)
            {
              ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 1)
            {
              paramAnonymousContext = m.akG(m.akI("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
              String str = m.akJ("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
              paramAnonymousIntent = m.akG(m.akH(paramAnonymousIntent.getExtraInfo()));
              ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramAnonymousIntent, paramAnonymousContext, str });
              if (!m.akH(paramAnonymousIntent).equals(paramAnonymousContext))
              {
                ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                AppMethodBeat.o(24765);
                return;
              }
              if ((b.this.txu.type == 1) && (m.akH(b.this.txu.ssid).equals(paramAnonymousContext)) && (m.akH(b.this.txu.bssid).equals(str)))
              {
                ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousIntent = new b.a((byte)0);
              paramAnonymousIntent.txx = System.currentTimeMillis();
              paramAnonymousIntent.type = 1;
              paramAnonymousIntent.ssid = paramAnonymousContext;
              paramAnonymousIntent.bssid = str;
              paramAnonymousIntent.txy = "";
              b.b(b.this.txu.cTO(), paramAnonymousIntent);
              b.this.txu = paramAnonymousIntent;
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 0)
            {
              if ((b.this.txu.type == 0) && (m.akH(b.this.txu.txy).equals(m.akH(paramAnonymousIntent.getExtraInfo()))))
              {
                ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
              if (paramAnonymousContext == null)
              {
                ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = paramAnonymousContext.getNetworkInfo(1);
              if (paramAnonymousContext == null)
              {
                ae.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                AppMethodBeat.o(24765);
                return;
              }
              ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[] { paramAnonymousContext.getState(), paramAnonymousContext.getDetailedState() });
              if (paramAnonymousContext.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED)
              {
                ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = new b.a((byte)0);
              paramAnonymousContext.txx = System.currentTimeMillis();
              paramAnonymousContext.type = 0;
              paramAnonymousContext.ssid = "";
              paramAnonymousContext.bssid = "";
              paramAnonymousContext.txy = m.akH(paramAnonymousIntent.getExtraInfo());
              b.a(b.this.txu.cTO(), paramAnonymousContext);
              b.this.txu = paramAnonymousContext;
              AppMethodBeat.o(24765);
              return;
            }
            AppMethodBeat.o(24765);
            return;
          }
          catch (Exception paramAnonymousContext)
          {
            paramAnonymousIntent = k.cTw();
            paramAnonymousIntent.dnO = "UnExpectedException";
            paramAnonymousIntent.result = -1;
            paramAnonymousIntent.fMT = m.l(paramAnonymousContext);
            paramAnonymousIntent.cTy().cTx();
            ae.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(paramAnonymousContext));
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
    m.akL("on mobile connected.");
    ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.md(0);
    AppMethodBeat.o(24771);
  }
  
  static void b(a parama1, a parama2)
  {
    AppMethodBeat.i(24772);
    m.akL("on wifi connected.");
    ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.akL("on wifi roaming.");
      ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.md(1);
    AppMethodBeat.o(24772);
  }
  
  public final void cTl()
  {
    AppMethodBeat.i(24770);
    try
    {
      ak.getContext().unregisterReceiver(this.txv);
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
    long txx;
    String txy = "";
    int type;
    
    public final a cTO()
    {
      AppMethodBeat.i(24766);
      a locala = new a();
      locala.txx = this.txx;
      locala.type = this.type;
      locala.ssid = this.ssid;
      locala.bssid = this.bssid;
      locala.txy = this.txy;
      AppMethodBeat.o(24766);
      return locala;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24767);
      String str = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.txx), Integer.valueOf(this.type), this.ssid, this.bssid, this.txy });
      AppMethodBeat.o(24767);
      return str;
    }
  }
  
  static final class b
  {
    private static b txz;
    
    static
    {
      AppMethodBeat.i(24768);
      txz = new b((byte)0);
      AppMethodBeat.o(24768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */