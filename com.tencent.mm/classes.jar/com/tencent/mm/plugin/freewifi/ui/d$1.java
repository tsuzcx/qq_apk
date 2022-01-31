package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements c.a
{
  public final void Q(float paramFloat1, float paramFloat2)
  {
    try
    {
      String str1 = String.valueOf(paramFloat1);
      String str2 = String.valueOf(paramFloat2);
      c localc = j.aUi().DC(com.tencent.mm.plugin.freewifi.model.d.aTX());
      if (localc != null)
      {
        h.nFQ.f(12073, new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str2, str1 });
        y.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str1, str2 });
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + localException.getMessage() + m.g(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.d.1
 * JD-Core Version:    0.7.0.1
 */