package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static void report()
  {
    AppMethodBeat.i(25065);
    try
    {
      b.cwM().a(new b.a()
      {
        public final void L(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(25064);
          try
          {
            String str1 = String.valueOf(paramAnonymousFloat1);
            String str2 = String.valueOf(paramAnonymousFloat2);
            com.tencent.mm.plugin.freewifi.g.c localc = j.cvY().aaI(com.tencent.mm.plugin.freewifi.model.d.cvQ());
            if (localc != null)
            {
              h.vKh.f(12073, new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str2, str1 });
              ad.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[] { localc.field_ssid, localc.field_mac, localc.field_url, localc.field_url, str1, str2 });
            }
            AppMethodBeat.o(25064);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + localException.getMessage() + m.m(localException));
            AppMethodBeat.o(25064);
          }
        }
      });
      AppMethodBeat.o(25065);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + localException.getMessage());
      AppMethodBeat.o(25065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.c
 * JD-Core Version:    0.7.0.1
 */