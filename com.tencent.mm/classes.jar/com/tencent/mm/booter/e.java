package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  NetworkInfo dhI = null;
  WifiInfo dhJ = null;
  
  final boolean vW()
  {
    try
    {
      Object localObject1 = (ConnectivityManager)aa.getContext().getSystemService("connectivity");
      if (localObject1 == null)
      {
        y.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.dhI = null;
        this.dhJ = null;
        return false;
      }
      try
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject1 == null)
        {
          y.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
          this.dhI = null;
          this.dhJ = null;
          return false;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
          localObject2 = null;
        }
      }
      if (localObject2.getType() != 1) {
        break label423;
      }
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        y.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException2, "", new Object[0]);
        break;
        WifiInfo localWifiInfo = null;
        continue;
        label423:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localWifiInfo = ((WifiManager)aa.getContext().getSystemService("wifi")).getConnectionInfo();
      if ((localWifiInfo != null) && (this.dhJ != null) && (this.dhJ.getBSSID().equals(localWifiInfo.getBSSID())) && (this.dhJ.getSSID().equals(localWifiInfo.getSSID())) && (this.dhJ.getNetworkId() == localWifiInfo.getNetworkId()))
      {
        y.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
        return false;
      }
      y.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", new Object[] { localWifiInfo });
      y.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", new Object[] { this.dhJ });
      if (i == 0)
      {
        y.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localObject2 });
        if (this.dhI != null) {
          y.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.dhI });
        }
      }
      this.dhI = localObject2;
      this.dhJ = localWifiInfo;
    }
    else
    {
      if ((this.dhI != null) && (this.dhI.getExtraInfo() != null) && (localObject2.getExtraInfo() != null) && (this.dhI.getExtraInfo().equals(localObject2.getExtraInfo())) && (this.dhI.getSubtype() == localObject2.getSubtype()) && (this.dhI.getType() == localObject2.getType()))
      {
        y.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        return false;
      }
      if ((this.dhI != null) && (this.dhI.getExtraInfo() == null) && (localObject2.getExtraInfo() == null) && (this.dhI.getSubtype() == localObject2.getSubtype()) && (this.dhI.getType() == localObject2.getType()))
      {
        y.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.e
 * JD-Core Version:    0.7.0.1
 */