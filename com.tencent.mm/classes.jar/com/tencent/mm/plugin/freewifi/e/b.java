package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";
  
  public static void G(Intent paramIntent)
  {
    boolean bool1 = true;
    if (paramIntent == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramIntent.getStringExtra("free_wifi_ap_key");
    } while (m.isEmpty((String)localObject));
    int i = paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0);
    if (2 == i) {
      i = 11;
    }
    for (;;)
    {
      label39:
      paramIntent.putExtra("free_wifi_channel_id", i);
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
      m.d(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.B(paramIntent) + "_" + m.D(paramIntent) + "_" + m.E(paramIntent) + "_" + System.currentTimeMillis());
      boolean bool2 = d.a.aUG().l(paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0), paramIntent.getStringExtra("free_wifi_ap_key"), paramIntent.getStringExtra("free_wifi_schema_ticket"));
      k.a locala = k.aTx();
      locala.ssid = m.Do(TAG);
      locala.bssid = m.Dp(TAG);
      locala.bHI = ((String)localObject);
      locala.iGw = paramIntent.getStringExtra("free_wifi_schema_ticket");
      locala.kmR = m.D(paramIntent);
      locala.kmS = k.b.knl.knD;
      locala.kmT = k.b.knl.name;
      locala.bUR = m.E(paramIntent);
      if (bool2)
      {
        i = 0;
        label242:
        locala.result = i;
        localObject = locala.aTz();
        if (bool2) {
          break label396;
        }
      }
      for (;;)
      {
        ((k)localObject).b(paramIntent, bool1).aTy();
        y.i(TAG, "getLock = " + bool2);
        m.Dr("type=" + paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + bool2);
        if (!bool2) {
          break;
        }
        m.d(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
        paramIntent.setClass(ae.getContext(), FreeWifiNetCheckUI.class);
        paramIntent.addFlags(67108864);
        com.tencent.mm.br.d.b(ae.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
        return;
        if (3 == i)
        {
          i = 12;
          break label39;
        }
        if (4 != i) {
          break label401;
        }
        i = 13;
        break label39;
        i = -1;
        break label242;
        label396:
        bool1 = false;
      }
      label401:
      i = 1;
    }
  }
  
  public static b aUE()
  {
    return b.a.aUF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.b
 * JD-Core Version:    0.7.0.1
 */