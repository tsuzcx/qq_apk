package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  b.a koo = new b.a((byte)0);
  BroadcastReceiver kop = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        try
        {
          y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
          paramAnonymousIntent = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
          if (paramAnonymousIntent == null)
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
            return;
          }
          y.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + paramAnonymousIntent.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[] { Boolean.valueOf(paramAnonymousIntent.isConnected()), paramAnonymousIntent.getState(), paramAnonymousIntent.getDetailedState(), paramAnonymousIntent.getExtraInfo(), Boolean.valueOf(paramAnonymousIntent.isConnectedOrConnecting()), Boolean.valueOf(paramAnonymousIntent.isAvailable()) });
          if (!paramAnonymousIntent.isConnected())
          {
            y.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
            return;
          }
        }
        catch (Exception paramAnonymousContext)
        {
          paramAnonymousIntent = k.aTx();
          paramAnonymousIntent.bHI = "UnExpectedException";
          paramAnonymousIntent.result = -1;
          paramAnonymousIntent.dmU = m.f(paramAnonymousContext);
          paramAnonymousIntent.aTz().aTy();
          y.e("MicroMsg.FreeWifi.UnExcepctedException", m.g(paramAnonymousContext));
          return;
        }
        if ((paramAnonymousIntent.getType() != 0) && (paramAnonymousIntent.getType() != 1))
        {
          y.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
          return;
        }
        if (paramAnonymousContext == null)
        {
          y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
          return;
        }
        if (paramAnonymousIntent.getType() == 1)
        {
          paramAnonymousContext = (WifiManager)paramAnonymousContext.getSystemService("wifi");
          if (paramAnonymousContext == null)
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
            return;
          }
          Object localObject = paramAnonymousContext.getConnectionInfo();
          if (localObject == null)
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
            return;
          }
          paramAnonymousContext = m.Dm(((WifiInfo)localObject).getSSID());
          localObject = m.Dn(((WifiInfo)localObject).getBSSID()).toLowerCase();
          paramAnonymousIntent = m.Dm(m.Dn(paramAnonymousIntent.getExtraInfo()));
          y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramAnonymousIntent, paramAnonymousContext, localObject });
          if (!m.Dn(paramAnonymousIntent).equals(paramAnonymousContext))
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
            return;
          }
          if ((b.this.koo.type == 1) && (m.Dn(b.this.koo.ssid).equals(paramAnonymousContext)) && (m.Dn(b.this.koo.bssid).equals(localObject)))
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
            return;
          }
          paramAnonymousIntent = new b.a((byte)0);
          paramAnonymousIntent.kor = System.currentTimeMillis();
          paramAnonymousIntent.type = 1;
          paramAnonymousIntent.ssid = paramAnonymousContext;
          paramAnonymousIntent.bssid = ((String)localObject);
          paramAnonymousIntent.kos = "";
          b.b(b.this.koo.aTR(), paramAnonymousIntent);
          b.this.koo = paramAnonymousIntent;
          return;
        }
        if (paramAnonymousIntent.getType() == 0)
        {
          if ((b.this.koo.type == 0) && (m.Dn(b.this.koo.kos).equals(m.Dn(paramAnonymousIntent.getExtraInfo()))))
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
            return;
          }
          paramAnonymousContext = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
          if (paramAnonymousContext == null)
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
            return;
          }
          paramAnonymousContext = paramAnonymousContext.getNetworkInfo(1);
          if (paramAnonymousContext == null)
          {
            y.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
            return;
          }
          y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[] { paramAnonymousContext.getState(), paramAnonymousContext.getDetailedState() });
          if (paramAnonymousContext.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED)
          {
            y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
            return;
          }
          paramAnonymousContext = new b.a((byte)0);
          paramAnonymousContext.kor = System.currentTimeMillis();
          paramAnonymousContext.type = 0;
          paramAnonymousContext.ssid = "";
          paramAnonymousContext.bssid = "";
          paramAnonymousContext.kos = m.Dn(paramAnonymousIntent.getExtraInfo());
          b.a(b.this.koo.aTR(), paramAnonymousContext);
          b.this.koo = paramAnonymousContext;
        }
      }
    }
  };
  
  static void a(b.a parama1, b.a parama2)
  {
    m.Dr("on mobile connected.");
    y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.jdMethod_if(0);
  }
  
  static void b(b.a parama1, b.a parama2)
  {
    m.Dr("on wifi connected.");
    y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.Dr("on wifi roaming.");
      y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.jdMethod_if(1);
  }
  
  public final void aTl()
  {
    try
    {
      ae.getContext().unregisterReceiver(this.kop);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */