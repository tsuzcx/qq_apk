package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class f
{
  NetworkInfo glA = null;
  String glB = "";
  String glC = "";
  int glD = -1;
  
  final boolean akC()
  {
    Object localObject1 = null;
    AppMethodBeat.i(131895);
    try
    {
      Object localObject2 = (ConnectivityManager)af.getContext().getSystemService("connectivity");
      if (localObject2 == null)
      {
        Log.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.glA = null;
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
          Log.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
        }
      }
      if (localObject1 == null)
      {
        Log.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
        this.glA = null;
        AppMethodBeat.o(131895);
        return false;
      }
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException1, "", new Object[0]);
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
        WifiInfo localWifiInfo = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
        if (localWifiInfo != null)
        {
          Log.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { localWifiInfo.getBSSID(), NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext()), Integer.valueOf(localWifiInfo.getNetworkId()) });
          Log.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.glC, this.glB, Integer.valueOf(this.glD) });
          if ((this.glC.equals(localWifiInfo.getBSSID())) && (this.glB.equals(NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext()))) && (this.glD == localWifiInfo.getNetworkId()))
          {
            Log.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
            AppMethodBeat.o(131895);
            return false;
            i = 0;
            continue;
          }
          this.glC = localWifiInfo.getBSSID();
          this.glB = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
          this.glD = localWifiInfo.getNetworkId();
        }
      }
    }
    do
    {
      if (i == 0)
      {
        Log.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localException1 });
        if (this.glA != null) {
          Log.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.glA });
        }
        this.glC = "";
        this.glB = "";
        this.glD = -1;
      }
      this.glA = localException1;
      break;
      if ((this.glA != null) && (this.glA.getExtraInfo() != null) && (localException1.getExtraInfo() != null) && (this.glA.getExtraInfo().equals(localException1.getExtraInfo())) && (this.glA.getSubtype() == localException1.getSubtype()) && (this.glA.getType() == localException1.getType()))
      {
        Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.glA == null) || (this.glA.getExtraInfo() != null) || (localException1.getExtraInfo() != null) || (this.glA.getSubtype() != localException1.getSubtype()) || (this.glA.getType() != localException1.getType()));
    Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */