package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class j$7
  extends n.a
{
  private byte[] dhN = new byte[0];
  
  j$7(j paramj) {}
  
  public final void et(int paramInt)
  {
    for (;;)
    {
      synchronized (this.dhN)
      {
        if (!au.DK())
        {
          y.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
          return;
        }
        y.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
        Object localObject2 = (ConnectivityManager)ae.getContext().getSystemService("connectivity");
        NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
        if (localNetworkInfo != null)
        {
          y.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:" + localNetworkInfo);
          y.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
        }
        localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
        if (localObject2 == null) {
          break label282;
        }
        y.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
        y.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
        break label282;
        if (!localNetworkInfo.isConnected())
        {
          f.a.aUe().aUb();
          return;
        }
      }
      boolean bool = f.a.aUe().a(d.aTY());
      y.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        j.aUn().aTQ();
      }
      label282:
      do
      {
        return;
        if ((6 == paramInt) || (4 == paramInt) || (paramInt == 0) || (-1 == paramInt)) {
          break;
        }
      } while (-9 != paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.7
 * JD-Core Version:    0.7.0.1
 */