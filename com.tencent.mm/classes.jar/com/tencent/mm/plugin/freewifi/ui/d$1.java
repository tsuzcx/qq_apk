package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements c.a
{
  public final void U(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(21005);
    try
    {
      String str1 = String.valueOf(paramFloat1);
      String str2 = String.valueOf(paramFloat2);
      c localc = j.bAK().OK(com.tencent.mm.plugin.freewifi.model.d.bAC());
      if (localc != null)
      {
        h.qsU.e(12073, new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str2, str1 });
        ab.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str1, str2 });
      }
      AppMethodBeat.o(21005);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + localException.getMessage() + m.f(localException));
      AppMethodBeat.o(21005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.d.1
 * JD-Core Version:    0.7.0.1
 */