package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class f
{
  NetworkInfo iPI = null;
  String iPJ = "";
  String iPK = "";
  int iPL = -1;
  
  final boolean aqy()
  {
    AppMethodBeat.i(131895);
    label312:
    do
    {
      try
      {
        Object localObject = (ConnectivityManager)af.getContext().getSystemService("connectivity");
        if (localObject == null)
        {
          Log.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
          this.iPI = null;
          AppMethodBeat.o(131895);
          return false;
        }
        boolean bool;
        try
        {
          localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
          if (localObject == null)
          {
            Log.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
            this.iPI = null;
            AppMethodBeat.o(131895);
            return false;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
            localNetworkInfo = null;
          }
          bool = NetStatusUtil.isWifi(localNetworkInfo);
          if (!bool) {
            break label312;
          }
        }
        String str1 = ConnectivityCompat.Companion.getWiFiBssid();
        String str2 = ConnectivityCompat.Companion.getWiFiSsid();
        int i = ConnectivityCompat.Companion.getNetworkId();
        Log.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", new Object[] { str1, str2, Integer.valueOf(i) });
        Log.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.iPK, this.iPJ, Integer.valueOf(this.iPL) });
        if ((this.iPK.equals(str1)) && (this.iPJ.equals(str2)) && (this.iPL == i))
        {
          Log.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
          AppMethodBeat.o(131895);
          return false;
        }
        this.iPK = str1;
        this.iPJ = str2;
        this.iPL = i;
        if (!bool)
        {
          Log.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localNetworkInfo });
          if (this.iPI != null) {
            Log.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.iPI });
          }
          this.iPK = "";
          this.iPJ = "";
          this.iPL = -1;
        }
        this.iPI = localNetworkInfo;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          NetworkInfo localNetworkInfo;
          Log.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException2, "", new Object[0]);
        }
      }
      AppMethodBeat.o(131895);
      return true;
      if ((this.iPI != null) && (this.iPI.getExtraInfo() != null) && (localNetworkInfo.getExtraInfo() != null) && (this.iPI.getExtraInfo().equals(localNetworkInfo.getExtraInfo())) && (this.iPI.getSubtype() == localNetworkInfo.getSubtype()) && (this.iPI.getType() == localNetworkInfo.getType()))
      {
        Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.iPI == null) || (this.iPI.getExtraInfo() != null) || (localNetworkInfo.getExtraInfo() != null) || (this.iPI.getSubtype() != localNetworkInfo.getSubtype()) || (this.iPI.getType() != localNetworkInfo.getType()));
    Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */