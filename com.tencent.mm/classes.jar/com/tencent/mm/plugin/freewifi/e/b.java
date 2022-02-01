package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";
  
  public static void at(Intent paramIntent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(24872);
    if (paramIntent == null)
    {
      AppMethodBeat.o(24872);
      return;
    }
    Object localObject = paramIntent.getStringExtra("free_wifi_ap_key");
    int i;
    if (!m.ea((String)localObject))
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
      m.e(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.ao(paramIntent) + "_" + m.aq(paramIntent) + "_" + m.ar(paramIntent) + "_" + System.currentTimeMillis());
      boolean bool2 = d.a.cRV().y(paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0), paramIntent.getStringExtra("free_wifi_ap_key"), paramIntent.getStringExtra("free_wifi_schema_ticket"));
      k.a locala = k.cQR();
      locala.ssid = m.ajK(TAG);
      locala.bssid = m.ajL(TAG);
      locala.dmM = ((String)localObject);
      locala.oZp = paramIntent.getStringExtra("free_wifi_schema_ticket");
      locala.tlg = m.aq(paramIntent);
      locala.tlh = k.b.tlA.tlS;
      locala.tli = k.b.tlA.name;
      locala.channel = m.ar(paramIntent);
      if (bool2)
      {
        i = 0;
        label254:
        locala.result = i;
        localObject = locala.cQT();
        if (bool2) {
          break label407;
        }
      }
      for (;;)
      {
        ((k)localObject).c(paramIntent, bool1).cQS();
        ad.i(TAG, "getLock = ".concat(String.valueOf(bool2)));
        m.ajN("type=" + paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + bool2);
        if (bool2)
        {
          m.e(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
          paramIntent.setClass(aj.getContext(), FreeWifiNetCheckUI.class);
          paramIntent.addFlags(67108864);
          com.tencent.mm.bs.d.b(aj.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
        }
        AppMethodBeat.o(24872);
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
  
  public static b cRT()
  {
    AppMethodBeat.i(24871);
    b localb = a.cRU();
    AppMethodBeat.o(24871);
    return localb;
  }
  
  static final class a
  {
    private static b tny;
    
    static
    {
      AppMethodBeat.i(24870);
      tny = new b((byte)0);
      AppMethodBeat.o(24870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.b
 * JD-Core Version:    0.7.0.1
 */