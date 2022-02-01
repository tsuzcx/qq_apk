package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class f
{
  NetworkInfo fmg = null;
  String fmh = "";
  String fmi = "";
  int fmj = -1;
  
  final boolean Up()
  {
    Object localObject1 = null;
    AppMethodBeat.i(131895);
    try
    {
      Object localObject2 = (ConnectivityManager)ad.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        ac.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.fmg = null;
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
          ac.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
        }
      }
      if (localObject1 == null)
      {
        ac.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
        this.fmg = null;
        AppMethodBeat.o(131895);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ac.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException1, "", new Object[0]);
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
        WifiInfo localWifiInfo = ax.getWifiInfo(ai.getContext());
        if (localWifiInfo != null)
        {
          ac.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), ax.iL(ai.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          ac.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.fmi, this.fmh, Integer.valueOf(this.fmj) });
          if ((this.fmi.equals(localWifiInfo.getBSSID())) && (this.fmh.equals(ax.iL(ai.getContext()))) && (this.fmj == localWifiInfo.getNetworkId()))
          {
            ac.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(131895);
            return false;
            i = 0;
            continue;
          }
          this.fmi = localWifiInfo.getBSSID();
          this.fmh = ax.iL(ai.getContext());
          this.fmj = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        ac.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.fmg != null) {
          ac.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.fmg });
        }
        this.fmi = "";
        this.fmh = "";
        this.fmj = -1;
      }
      this.fmg = localException1;
      break;
      if ((this.fmg != null) && (this.fmg.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.fmg.getExtraInfo().equals(localException1.getExtraInfo())) && (this.fmg.getSubtype() == localException1.getSubtype()) && (this.fmg.getType() == localException1.getType()))
      {
        ac.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.fmg == null) || (this.fmg.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.fmg.getSubtype() != localException1.getSubtype()) || (this.fmg.getType() != localException1.getType()));
    ac.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */