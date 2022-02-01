package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class f
{
  NetworkInfo lrD = null;
  String lrE = "";
  String lrF = "";
  int lrG = -1;
  
  final boolean aKw()
  {
    AppMethodBeat.i(131895);
    label312:
    do
    {
      try
      {
        Object localObject = (ConnectivityManager)ag.getContext().getSystemService("connectivity");
        if (localObject == null)
        {
          Log.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
          this.lrD = null;
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
            this.lrD = null;
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
        Log.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", new Object[] { this.lrF, this.lrE, Integer.valueOf(this.lrG) });
        if ((this.lrF.equals(str1)) && (this.lrE.equals(str2)) && (this.lrG == i))
        {
          Log.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
          AppMethodBeat.o(131895);
          return false;
        }
        this.lrF = str1;
        this.lrE = str2;
        this.lrG = i;
        if (!bool)
        {
          Log.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localNetworkInfo });
          if (this.lrD != null) {
            Log.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.lrD });
          }
          this.lrF = "";
          this.lrE = "";
          this.lrG = -1;
        }
        this.lrD = localNetworkInfo;
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
      if ((this.lrD != null) && (this.lrD.getExtraInfo() != null) && (localNetworkInfo.getExtraInfo() != null) && (this.lrD.getExtraInfo().equals(localNetworkInfo.getExtraInfo())) && (this.lrD.getSubtype() == localNetworkInfo.getSubtype()) && (this.lrD.getType() == localNetworkInfo.getType()))
      {
        Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
        AppMethodBeat.o(131895);
        return false;
      }
    } while ((this.lrD == null) || (this.lrD.getExtraInfo() != null) || (localNetworkInfo.getExtraInfo() != null) || (this.lrD.getSubtype() != localNetworkInfo.getSubtype()) || (this.lrD.getType() != localNetworkInfo.getType()));
    Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
    AppMethodBeat.o(131895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */