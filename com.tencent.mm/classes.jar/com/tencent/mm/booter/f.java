package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public final class f
{
  NetworkInfo fGr = null;
  String fGs = "";
  String fGt = "";
  int fGu = -1;
  
  final boolean WO()
  {
    Object localObject1 = null;
    AppMethodBeat.i(131895);
    try
    {
      Object localObject2 = (ConnectivityManager)ad.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        ae.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.fGr = null;
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
          ae.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
        }
      }
      if (localObject1 == null)
      {
        ae.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
        this.fGr = null;
        AppMethodBeat.o(131895);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ae.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException1, "", new Object[0]);
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
        WifiInfo localWifiInfo = az.getWifiInfo(ak.getContext());
        if (localWifiInfo != null)
        {
          ae.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), az.ja(ak.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          ae.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.fGt, this.fGs, Integer.valueOf(this.fGu) });
          if ((this.fGt.equals(localWifiInfo.getBSSID())) && (this.fGs.equals(az.ja(ak.getContext()))) && (this.fGu == localWifiInfo.getNetworkId()))
          {
            ae.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(131895);
            return false;
            i = 0;
            continue;
          }
          this.fGt = localWifiInfo.getBSSID();
          this.fGs = az.ja(ak.getContext());
          this.fGu = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        ae.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.fGr != null) {
          ae.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.fGr });
        }
        this.fGt = "";
        this.fGs = "";
        this.fGu = -1;
      }
      this.fGr = localException1;
      break;
      if ((this.fGr != null) && (this.fGr.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.fGr.getExtraInfo().equals(localException1.getExtraInfo())) && (this.fGr.getSubtype() == localException1.getSubtype()) && (this.fGr.getType() == localException1.getType()))
      {
        ae.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.fGr == null) || (this.fGr.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.fGr.getSubtype() != localException1.getSubtype()) || (this.fGr.getType() != localException1.getType()));
    ae.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */