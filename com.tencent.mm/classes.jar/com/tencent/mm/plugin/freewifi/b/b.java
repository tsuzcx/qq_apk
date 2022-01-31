package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.ff.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class b
{
  private static void a(ff paramff, int paramInt, String paramString)
  {
    AppMethodBeat.i(20672);
    paramff.csS.csV = paramInt;
    paramff.csS.csW = paramString;
    paramff.csS.csU = 1;
    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramff.callback != null) {
      paramff.callback.run();
    }
    AppMethodBeat.o(20672);
  }
  
  public final void a(ff paramff)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(20671);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.Ou(paramff.csR.ssid);
        str2 = paramff.csR.bssid;
        if (m.isEmpty(str1))
        {
          a(paramff, 1141, "Ssid is empty.");
          AppMethodBeat.o(20671);
          return;
        }
        if (m.isEmpty(str2))
        {
          a(paramff, 1142, "Bssid is empty.");
          AppMethodBeat.o(20671);
          continue;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramff.csR.ssid + "; bssid=" + paramff.csR.bssid + "; version=" + paramff.csR.version);
      }
      finally {}
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.bAm().eu(str1, str2);
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.bAm().size() == 0)
        {
          a(paramff, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
          AppMethodBeat.o(20671);
        }
        else
        {
          a(paramff, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
          AppMethodBeat.o(20671);
        }
      }
      else
      {
        String str3 = localb.coX;
        int i = localb.mIE;
        if (i == 4)
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          al.d(new b.1(this, str3));
          a(paramff, 1, null);
          AppMethodBeat.o(20671);
        }
        else if (i == 31)
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          al.d(new b.2(this, str1, str2));
          a(paramff, 1, null);
          AppMethodBeat.o(20671);
        }
        else
        {
          a(paramff, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
          AppMethodBeat.o(20671);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */