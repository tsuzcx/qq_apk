package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.fm.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  private static void a(fm paramfm, int paramInt, String paramString)
  {
    AppMethodBeat.i(24749);
    paramfm.dfj.dfm = paramInt;
    paramfm.dfj.dfn = paramString;
    paramfm.dfj.dfl = 1;
    ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramfm.callback != null) {
      paramfm.callback.run();
    }
    AppMethodBeat.o(24749);
  }
  
  public final void a(fm paramfm)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(24748);
        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.afk(paramfm.dfi.ssid);
        str2 = paramfm.dfi.bssid;
        if (m.cX(str1))
        {
          a(paramfm, 1141, "Ssid is empty.");
          AppMethodBeat.o(24748);
          return;
        }
        if (m.cX(str2))
        {
          a(paramfm, 1142, "Bssid is empty.");
          AppMethodBeat.o(24748);
          continue;
        }
        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramfm.dfi.ssid + "; bssid=" + paramfm.dfi.bssid + "; version=" + paramfm.dfi.version);
      }
      finally {}
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.cIM().gw(str1, str2);
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.cIM().size() == 0)
        {
          a(paramfm, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfm, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
          AppMethodBeat.o(24748);
        }
      }
      else
      {
        String str3 = localb.dbq;
        int i = localb.soD;
        if (i == 4)
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          ap.f(new b.1(this, str3));
          a(paramfm, 1, null);
          AppMethodBeat.o(24748);
        }
        else if (i == 31)
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          ap.f(new b.2(this, str1, str2));
          a(paramfm, 1, null);
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfm, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
          AppMethodBeat.o(24748);
        }
      }
    }
  }
  
  public static final class a
  {
    private static b spG;
    
    static
    {
      AppMethodBeat.i(24747);
      spG = new b((byte)0);
      AppMethodBeat.o(24747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */