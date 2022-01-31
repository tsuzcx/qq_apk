package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class f
{
  NetworkInfo dYZ = null;
  String dZa = "";
  String dZb = "";
  int dZc = -1;
  
  final boolean Ik()
  {
    Object localObject1 = null;
    AppMethodBeat.i(57779);
    try
    {
      Object localObject2 = (ConnectivityManager)com.tencent.mm.network.ab.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.dYZ = null;
        AppMethodBeat.o(57779);
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
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
        }
      }
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
        this.dYZ = null;
        AppMethodBeat.o(57779);
        return false;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException1, "", new Object[0]);
      AppMethodBeat.o(57779);
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
        WifiInfo localWifiInfo = at.getWifiInfo(ah.getContext());
        if (localWifiInfo != null)
        {
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), at.gX(ah.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.dZb, this.dZa, Integer.valueOf(this.dZc) });
          if ((this.dZb.equals(localWifiInfo.getBSSID())) && (this.dZa.equals(at.gX(ah.getContext()))) && (this.dZc == localWifiInfo.getNetworkId()))
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(57779);
            return false;
            i = 0;
            continue;
          }
          this.dZb = localWifiInfo.getBSSID();
          this.dZa = at.gX(ah.getContext());
          this.dZc = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.dYZ != null) {
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.dYZ });
        }
        this.dZb = "";
        this.dZa = "";
        this.dZc = -1;
      }
      this.dYZ = localException1;
      break;
      if ((this.dYZ != null) && (this.dYZ.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.dYZ.getExtraInfo().equals(localException1.getExtraInfo())) && (this.dYZ.getSubtype() == localException1.getSubtype()) && (this.dYZ.getType() == localException1.getType()))
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(57779);
        return false;
      }
    } while ((this.dYZ == null) || (this.dYZ.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.dYZ.getSubtype() != localException1.getSubtype()) || (this.dYZ.getType() != localException1.getType()));
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(57779);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */