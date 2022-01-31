package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";
  
  public static void Z(Intent paramIntent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20802);
    if (paramIntent == null)
    {
      AppMethodBeat.o(20802);
      return;
    }
    Object localObject = paramIntent.getStringExtra("free_wifi_ap_key");
    int i;
    if (!m.isEmpty((String)localObject))
    {
      i = paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0);
      if (2 != i) {
        break label380;
      }
      i = 11;
    }
    for (;;)
    {
      paramIntent.putExtra("free_wifi_channel_id", i);
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
      m.d(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.U(paramIntent) + "_" + m.W(paramIntent) + "_" + m.X(paramIntent) + "_" + System.currentTimeMillis());
      boolean bool2 = d.a.bBg().v(paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0), paramIntent.getStringExtra("free_wifi_ap_key"), paramIntent.getStringExtra("free_wifi_schema_ticket"));
      k.a locala = k.bAc();
      locala.ssid = m.Ow(TAG);
      locala.bssid = m.Ox(TAG);
      locala.coX = ((String)localObject);
      locala.kMp = paramIntent.getStringExtra("free_wifi_schema_ticket");
      locala.mIE = m.W(paramIntent);
      locala.mIF = k.b.mIY.mJq;
      locala.mIG = k.b.mIY.name;
      locala.cCy = m.X(paramIntent);
      if (bool2)
      {
        i = 0;
        label254:
        locala.result = i;
        localObject = locala.bAe();
        if (bool2) {
          break label407;
        }
      }
      for (;;)
      {
        ((k)localObject).c(paramIntent, bool1).bAd();
        ab.i(TAG, "getLock = ".concat(String.valueOf(bool2)));
        m.Oz("type=" + paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + bool2);
        if (bool2)
        {
          m.d(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
          paramIntent.setClass(ah.getContext(), FreeWifiNetCheckUI.class);
          paramIntent.addFlags(67108864);
          com.tencent.mm.bq.d.b(ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
        }
        AppMethodBeat.o(20802);
        return;
        label380:
        if (3 == i)
        {
          i = 12;
          break;
        }
        if (4 != i) {
          break label412;
        }
        i = 13;
        break;
        i = -1;
        break label254;
        label407:
        bool1 = false;
      }
      label412:
      i = 1;
    }
  }
  
  public static b bBe()
  {
    AppMethodBeat.i(20801);
    b localb = b.a.bBf();
    AppMethodBeat.o(20801);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.b
 * JD-Core Version:    0.7.0.1
 */