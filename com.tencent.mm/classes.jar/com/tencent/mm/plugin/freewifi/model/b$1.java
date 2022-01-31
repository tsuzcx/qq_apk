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
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  extends BroadcastReceiver
{
  b$1(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(20688);
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      try
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
        paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        if (paramIntent == null)
        {
          ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
          AppMethodBeat.o(20688);
          return;
        }
        ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + paramIntent.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[] { Boolean.valueOf(paramIntent.isConnected()), paramIntent.getState(), paramIntent.getDetailedState(), paramIntent.getExtraInfo(), Boolean.valueOf(paramIntent.isConnectedOrConnecting()), Boolean.valueOf(paramIntent.isAvailable()) });
        if (!paramIntent.isConnected())
        {
          ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
          AppMethodBeat.o(20688);
          return;
        }
        if ((paramIntent.getType() != 0) && (paramIntent.getType() != 1))
        {
          ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
          AppMethodBeat.o(20688);
          return;
        }
        if (paramContext == null)
        {
          ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
          AppMethodBeat.o(20688);
          return;
        }
        if (paramIntent.getType() == 1)
        {
          paramContext = m.Ou(m.Ow("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
          String str = m.Ox("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
          paramIntent = m.Ou(m.Ov(paramIntent.getExtraInfo()));
          ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[] { paramIntent, paramContext, str });
          if (!m.Ov(paramIntent).equals(paramContext))
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
            AppMethodBeat.o(20688);
            return;
          }
          if ((this.mKd.mKb.type == 1) && (m.Ov(this.mKd.mKb.ssid).equals(paramContext)) && (m.Ov(this.mKd.mKb.bssid).equals(str)))
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
            AppMethodBeat.o(20688);
            return;
          }
          paramIntent = new b.a((byte)0);
          paramIntent.mKe = System.currentTimeMillis();
          paramIntent.type = 1;
          paramIntent.ssid = paramContext;
          paramIntent.bssid = str;
          paramIntent.mKf = "";
          b.b(this.mKd.mKb.bAu(), paramIntent);
          this.mKd.mKb = paramIntent;
          AppMethodBeat.o(20688);
          return;
        }
        if (paramIntent.getType() == 0)
        {
          if ((this.mKd.mKb.type == 0) && (m.Ov(this.mKd.mKb.mKf).equals(m.Ov(paramIntent.getExtraInfo()))))
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
            AppMethodBeat.o(20688);
            return;
          }
          paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
          if (paramContext == null)
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
            AppMethodBeat.o(20688);
            return;
          }
          paramContext = paramContext.getNetworkInfo(1);
          if (paramContext == null)
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
            AppMethodBeat.o(20688);
            return;
          }
          ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[] { paramContext.getState(), paramContext.getDetailedState() });
          if (paramContext.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED)
          {
            ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
            AppMethodBeat.o(20688);
            return;
          }
          paramContext = new b.a((byte)0);
          paramContext.mKe = System.currentTimeMillis();
          paramContext.type = 0;
          paramContext.ssid = "";
          paramContext.bssid = "";
          paramContext.mKf = m.Ov(paramIntent.getExtraInfo());
          b.a(this.mKd.mKb.bAu(), paramContext);
          this.mKd.mKb = paramContext;
          AppMethodBeat.o(20688);
          return;
        }
        AppMethodBeat.o(20688);
        return;
      }
      catch (Exception paramContext)
      {
        paramIntent = k.bAc();
        paramIntent.coX = "UnExpectedException";
        paramIntent.result = -1;
        paramIntent.eev = m.e(paramContext);
        paramIntent.bAe().bAd();
        ab.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(paramContext));
      }
    }
    AppMethodBeat.o(20688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b.1
 * JD-Core Version:    0.7.0.1
 */