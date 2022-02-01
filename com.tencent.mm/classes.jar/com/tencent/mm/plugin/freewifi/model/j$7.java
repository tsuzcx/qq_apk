package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class j$7
  extends n.a
{
  private byte[] fmn;
  
  j$7(j paramj)
  {
    AppMethodBeat.i(24817);
    this.fmn = new byte[0];
    AppMethodBeat.o(24817);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(24818);
    for (;;)
    {
      synchronized (this.fmn)
      {
        if (!az.agM())
        {
          ac.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
          AppMethodBeat.o(24818);
          return;
        }
        ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
        Object localObject2 = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
        if (localObject2 == null)
        {
          AppMethodBeat.o(24818);
          return;
        }
        NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
        if (localNetworkInfo != null)
        {
          ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(localNetworkInfo)));
          ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
        }
        localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
        if (localObject2 != null)
        {
          ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
          ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
          break label331;
          if (!localNetworkInfo.isConnected())
          {
            f.a.cJg().cJd();
            AppMethodBeat.o(24818);
            return;
          }
          boolean bool = f.a.cJg().ac(m.afm("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.afn("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.afo("MicroMsg.FreeWifi.SubCoreFreeWifi"));
          ac.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            j.cJp().cIT();
          }
          AppMethodBeat.o(24818);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.7
 * JD-Core Version:    0.7.0.1
 */