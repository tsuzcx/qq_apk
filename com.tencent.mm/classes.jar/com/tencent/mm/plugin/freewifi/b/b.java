package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fq.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
{
  private static void a(fq paramfq, int paramInt, String paramString)
  {
    AppMethodBeat.i(24749);
    paramfq.drK.drN = paramInt;
    paramfq.drK.drO = paramString;
    paramfq.drK.drM = 1;
    ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramfq.callback != null) {
      paramfq.callback.run();
    }
    AppMethodBeat.o(24749);
  }
  
  public final void a(fq paramfq)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(24748);
        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.akG(paramfq.drJ.ssid);
        str2 = paramfq.drJ.bssid;
        if (m.ef(str1))
        {
          a(paramfq, 1141, "Ssid is empty.");
          AppMethodBeat.o(24748);
          return;
        }
        if (m.ef(str2))
        {
          a(paramfq, 1142, "Bssid is empty.");
          AppMethodBeat.o(24748);
          continue;
        }
        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramfq.drJ.ssid + "; bssid=" + paramfq.drJ.bssid + "; version=" + paramfq.drJ.version);
      }
      finally {}
      ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.cTG().gM(str1, str2);
      ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.cTG().size() == 0)
        {
          a(paramfq, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfq, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
          AppMethodBeat.o(24748);
        }
      }
      else
      {
        String str3 = localb.dnO;
        int i = localb.tvY;
        if (i == 4)
        {
          ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          ar.f(new b.1(this, str3));
          a(paramfq, 1, null);
          AppMethodBeat.o(24748);
        }
        else if (i == 31)
        {
          ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          ar.f(new b.2(this, str1, str2));
          a(paramfq, 1, null);
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramfq, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
          AppMethodBeat.o(24748);
        }
      }
    }
  }
  
  public static final class a
  {
    private static b txb;
    
    static
    {
      AppMethodBeat.i(24747);
      txb = new b((byte)0);
      AppMethodBeat.o(24747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */