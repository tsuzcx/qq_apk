package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class f
{
  NetworkInfo fiM = null;
  String fiN = "";
  String fiO = "";
  int fiP = -1;
  
  final boolean Tv()
  {
    Object localObject1 = null;
    AppMethodBeat.i(131895);
    try
    {
      Object localObject2 = (ConnectivityManager)com.tencent.mm.network.ad.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.fiM = null;
        AppMethodBeat.o(131895);
        return false;
      }
      try
      {
        localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
        }
      }
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
        this.fiM = null;
        AppMethodBeat.o(131895);
        return false;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException1, "", new Object[0]);
      AppMethodBeat.o(131895);
      return true;
    }
    int i;
    if (localException1.getType() == 1) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        WifiInfo localWifiInfo = ay.getWifiInfo(aj.getContext());
        if (localWifiInfo != null)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), ay.iA(aj.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.fiO, this.fiN, Integer.valueOf(this.fiP) });
          if ((this.fiO.equals(localWifiInfo.getBSSID())) && (this.fiN.equals(ay.iA(aj.getContext()))) && (this.fiP == localWifiInfo.getNetworkId()))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(131895);
            return false;
            i = 0;
            continue;
          }
          this.fiO = localWifiInfo.getBSSID();
          this.fiN = ay.iA(aj.getContext());
          this.fiP = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.fiM != null) {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.fiM });
        }
        this.fiO = "";
        this.fiN = "";
        this.fiP = -1;
      }
      this.fiM = localException1;
      break;
      if ((this.fiM != null) && (this.fiM.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.fiM.getExtraInfo().equals(localException1.getExtraInfo())) && (this.fiM.getSubtype() == localException1.getSubtype()) && (this.fiM.getType() == localException1.getType()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.fiM == null) || (this.fiM.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.fiM.getSubtype() != localException1.getSubtype()) || (this.fiM.getType() != localException1.getType()));
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */