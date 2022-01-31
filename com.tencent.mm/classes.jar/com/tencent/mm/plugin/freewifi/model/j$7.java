package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class j$7
  extends n.a
{
  private byte[] dZg;
  
  j$7(j paramj)
  {
    AppMethodBeat.i(20743);
    this.dZg = new byte[0];
    AppMethodBeat.o(20743);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(20744);
    for (;;)
    {
      synchronized (this.dZg)
      {
        if (!aw.RG())
        {
          ab.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
          AppMethodBeat.o(20744);
          return;
        }
        ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
        Object localObject2 = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
        if (localObject2 == null)
        {
          AppMethodBeat.o(20744);
          return;
        }
        NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
        if (localNetworkInfo != null)
        {
          ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(localNetworkInfo)));
          ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
        }
        localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
        if (localObject2 != null)
        {
          ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
          ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
          break label331;
          if (!localNetworkInfo.isConnected())
          {
            f.a.bAG().bAD();
            AppMethodBeat.o(20744);
            return;
          }
          boolean bool = f.a.bAG().T(m.Ow("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.Ox("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.Oy("MicroMsg.FreeWifi.SubCoreFreeWifi"));
          ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            j.bAP().bAt();
          }
          AppMethodBeat.o(20744);
          return;
        }
      }
      label331:
      if ((6 != paramInt) && (4 != paramInt) && (paramInt != 0) && (-1 != paramInt)) {
        if (-9 != paramInt) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.7
 * JD-Core Version:    0.7.0.1
 */