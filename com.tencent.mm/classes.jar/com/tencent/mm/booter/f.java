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
  NetworkInfo fEn = null;
  String fEo = "";
  String fEp = "";
  int fEq = -1;
  
  final boolean WG()
  {
    Object localObject1 = null;
    AppMethodBeat.i(131895);
    try
    {
      Object localObject2 = (ConnectivityManager)com.tencent.mm.network.ad.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.fEn = null;
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
        this.fEn = null;
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
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), ay.iV(aj.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.fEp, this.fEo, Integer.valueOf(this.fEq) });
          if ((this.fEp.equals(localWifiInfo.getBSSID())) && (this.fEo.equals(ay.iV(aj.getContext()))) && (this.fEq == localWifiInfo.getNetworkId()))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(131895);
            return false;
            i = 0;
            continue;
          }
          this.fEp = localWifiInfo.getBSSID();
          this.fEo = ay.iV(aj.getContext());
          this.fEq = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.fEn != null) {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.fEn });
        }
        this.fEp = "";
        this.fEo = "";
        this.fEq = -1;
      }
      this.fEn = localException1;
      break;
      if ((this.fEn != null) && (this.fEn.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.fEn.getExtraInfo().equals(localException1.getExtraInfo())) && (this.fEn.getSubtype() == localException1.getSubtype()) && (this.fEn.getType() == localException1.getType()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.fEn == null) || (this.fEn.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.fEn.getSubtype() != localException1.getSubtype()) || (this.fEn.getType() != localException1.getType()));
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */