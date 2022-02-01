package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
{
  private static void a(fp paramfp, int paramInt, String paramString)
  {
    AppMethodBeat.i(24749);
    paramfp.dqF.dqI = paramInt;
    paramfp.dqF.dqJ = paramString;
    paramfp.dqF.dqH = 1;
    ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramfp.callback != null) {
      paramfp.callback.run();
    }
    AppMethodBeat.o(24749);
  }
  
  public final void a(fp paramfp)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(24748);
        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.ajI(paramfp.dqE.ssid);
        str2 = paramfp.dqE.bssid;
        if (m.ea(str1))
        {
          a(paramfp, 1141, "Ssid is empty.");
          AppMethodBeat.o(24748);
          return;
        }
        if (m.ea(str2))
        {
          a(paramfp, 1142, "Bssid is empty.");
          AppMethodBeat.o(24748);
          continue;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramfp.dqE.ssid + "; bssid=" + paramfp.dqE.bssid + "; version=" + paramfp.dqE.version);
      }
      finally {}
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.cRb().gH(str1, str2);
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.cRb().size() == 0)
        {
          a(paramfp, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfp, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
          AppMethodBeat.o(24748);
        }
      }
      else
      {
        String str3 = localb.dmM;
        int i = localb.tlg;
        if (i == 4)
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          aq.f(new b.1(this, str3));
          a(paramfp, 1, null);
          AppMethodBeat.o(24748);
        }
        else if (i == 31)
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          aq.f(new b.2(this, str1, str2));
          a(paramfp, 1, null);
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfp, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
          AppMethodBeat.o(24748);
        }
      }
    }
  }
  
  public static final class a
  {
    private static b tmj;
    
    static
    {
      AppMethodBeat.i(24747);
      tmj = new b((byte)0);
      AppMethodBeat.o(24747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */