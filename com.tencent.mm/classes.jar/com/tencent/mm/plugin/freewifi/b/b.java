package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.h.a.fc;
import com.tencent.mm.h.a.fc.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static void a(fc paramfc, int paramInt, String paramString)
  {
    paramfc.bLy.bLB = paramInt;
    paramfc.bLy.bLC = paramString;
    paramfc.bLy.bLA = 1;
    y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramfc.bFJ != null) {
      paramfc.bFJ.run();
    }
  }
  
  public final void a(fc paramfc)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.Dm(paramfc.bLx.ssid);
        str2 = paramfc.bLx.bssid;
        if (m.isEmpty(str1))
        {
          a(paramfc, 1141, "Ssid is empty.");
          return;
        }
        if (m.isEmpty(str2))
        {
          a(paramfc, 1142, "Bssid is empty.");
          continue;
        }
        y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramfc.bLx.ssid + "; bssid=" + paramfc.bLx.bssid + "; version=" + paramfc.bLx.version);
      }
      finally {}
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.aTI().dg(str1, str2);
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.aTI().size() == 0) {
          a(paramfc, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
        } else {
          a(paramfc, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
        }
      }
      else
      {
        String str3 = localb.bHI;
        int i = localb.kmR;
        if (i == 4)
        {
          y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          ai.d(new b.1(this, str3));
          a(paramfc, 1, null);
        }
        else if (i == 31)
        {
          y.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          ai.d(new b.2(this, str1, str2));
          a(paramfc, 1, null);
        }
        else
        {
          a(paramfc, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */