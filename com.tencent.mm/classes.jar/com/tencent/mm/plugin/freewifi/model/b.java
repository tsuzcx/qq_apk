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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  a spZ;
  BroadcastReceiver sqa;
  
  private b()
  {
    AppMethodBeat.i(24769);
    this.spZ = new a((byte)0);
    this.sqa = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(24765);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          try
          {
            ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
            paramAnonymousIntent = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
            if (paramAnonymousIntent == null)
            {
              ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
              AppMethodBeat.o(24765);
              return;
            }
            ac.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + paramAnonymousIntent.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[] { Boolean.valueOf(paramAnonymousIntent.isConnected()), paramAnonymousIntent.getState(), paramAnonymousIntent.getDetailedState(), paramAnonymousIntent.getExtraInfo(), Boolean.valueOf(paramAnonymousIntent.isConnectedOrConnecting()), Boolean.valueOf(paramAnonymousIntent.isAvailable()) });
            if (!paramAnonymousIntent.isConnected())
            {
              ac.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
              AppMethodBeat.o(24765);
              return;
            }
            if ((paramAnonymousIntent.getType() != 0) && (paramAnonymousIntent.getType() != 1))
            {
              ac.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousContext == null)
            {
              ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 1)
            {
              paramAnonymousContext = m.afk(m.afm("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
              String str = m.afn("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
              paramAnonymousIntent = m.afk(m.afl(paramAnonymousIntent.getExtraInfo()));
              ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramAnonymousIntent, paramAnonymousContext, str });
              if (!m.afl(paramAnonymousIntent).equals(paramAnonymousContext))
              {
                ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                AppMethodBeat.o(24765);
                return;
              }
              if ((b.this.spZ.type == 1) && (m.afl(b.this.spZ.ssid).equals(paramAnonymousContext)) && (m.afl(b.this.spZ.bssid).equals(str)))
              {
                ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousIntent = new b.a((byte)0);
              paramAnonymousIntent.sqc = System.currentTimeMillis();
              paramAnonymousIntent.type = 1;
              paramAnonymousIntent.ssid = paramAnonymousContext;
              paramAnonymousIntent.bssid = str;
              paramAnonymousIntent.sqd = "";
              b.b(b.this.spZ.cIU(), paramAnonymousIntent);
              b.this.spZ = paramAnonymousIntent;
              AppMethodBeat.o(24765);
              return;
            }
            if (paramAnonymousIntent.getType() == 0)
            {
              if ((b.this.spZ.type == 0) && (m.afl(b.this.spZ.sqd).equals(m.afl(paramAnonymousIntent.getExtraInfo()))))
              {
                ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
              if (paramAnonymousContext == null)
              {
                ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = paramAnonymousContext.getNetworkInfo(1);
              if (paramAnonymousContext == null)
              {
                ac.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                AppMethodBeat.o(24765);
                return;
              }
              ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[] { paramAnonymousContext.getState(), paramAnonymousContext.getDetailedState() });
              if (paramAnonymousContext.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED)
              {
                ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                AppMethodBeat.o(24765);
                return;
              }
              paramAnonymousContext = new b.a((byte)0);
              paramAnonymousContext.sqc = System.currentTimeMillis();
              paramAnonymousContext.type = 0;
              paramAnonymousContext.ssid = "";
              paramAnonymousContext.bssid = "";
              paramAnonymousContext.sqd = m.afl(paramAnonymousIntent.getExtraInfo());
              b.a(b.this.spZ.cIU(), paramAnonymousContext);
              b.this.spZ = paramAnonymousContext;
              AppMethodBeat.o(24765);
              return;
            }
            AppMethodBeat.o(24765);
            return;
          }
          catch (Exception paramAnonymousContext)
          {
            paramAnonymousIntent = k.cIC();
            paramAnonymousIntent.dbq = "UnExpectedException";
            paramAnonymousIntent.result = -1;
            paramAnonymousIntent.fsq = m.l(paramAnonymousContext);
            paramAnonymousIntent.cIE().cID();
            ac.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(paramAnonymousContext));
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
    m.afp("on mobile connected.");
    ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.lA(0);
    AppMethodBeat.o(24771);
  }
  
  static void b(a parama1, a parama2)
  {
    AppMethodBeat.i(24772);
    m.afp("on wifi connected.");
    ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.afp("on wifi roaming.");
      ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.lA(1);
    AppMethodBeat.o(24772);
  }
  
  public final void cIr()
  {
    AppMethodBeat.i(24770);
    try
    {
      ai.getContext().unregisterReceiver(this.sqa);
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
    long sqc;
    String sqd = "";
    String ssid = "";
    int type;
    
    public final a cIU()
    {
      AppMethodBeat.i(24766);
      a locala = new a();
      locala.sqc = this.sqc;
      locala.type = this.type;
      locala.ssid = this.ssid;
      locala.bssid = this.bssid;
      locala.sqd = this.sqd;
      AppMethodBeat.o(24766);
      return locala;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24767);
      String str = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.sqc), Integer.valueOf(this.type), this.ssid, this.bssid, this.sqd });
      AppMethodBeat.o(24767);
      return str;
    }
  }
  
  static final class b
  {
    private static b sqe;
    
    static
    {
      AppMethodBeat.i(24768);
      sqe = new b((byte)0);
      AppMethodBeat.o(24768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */