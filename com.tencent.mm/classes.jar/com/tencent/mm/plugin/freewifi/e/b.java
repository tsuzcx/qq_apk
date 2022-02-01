package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";
  
  public static void aB(Intent paramIntent)
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
    if (!m.eP((String)localObject))
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
      m.f(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
      paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.aw(paramIntent) + "_" + m.ay(paramIntent) + "_" + m.az(paramIntent) + "_" + System.currentTimeMillis());
      boolean bool2 = d.a.dNJ().B(paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0), paramIntent.getStringExtra("free_wifi_ap_key"), paramIntent.getStringExtra("free_wifi_schema_ticket"));
      k.a locala = k.dMF();
      locala.ssid = m.axM(TAG);
      locala.bssid = m.axN(TAG);
      locala.dFd = ((String)localObject);
      locala.quX = paramIntent.getStringExtra("free_wifi_schema_ticket");
      locala.wNc = m.ay(paramIntent);
      locala.wNd = k.b.wNw.wNO;
      locala.wNe = k.b.wNw.name;
      locala.channel = m.az(paramIntent);
      if (bool2)
      {
        i = 0;
        label254:
        locala.result = i;
        localObject = locala.dMH();
        if (bool2) {
          break label407;
        }
      }
      for (;;)
      {
        ((k)localObject).c(paramIntent, bool1).dMG();
        Log.i(TAG, "getLock = ".concat(String.valueOf(bool2)));
        m.axP("type=" + paramIntent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + bool2);
        if (bool2)
        {
          m.f(paramIntent, paramIntent.getStringExtra("free_wifi_schema_ticket"));
          paramIntent.setClass(MMApplicationContext.getContext(), FreeWifiNetCheckUI.class);
          paramIntent.addFlags(67108864);
          c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
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
  
  public static b dNH()
  {
    AppMethodBeat.i(24871);
    b localb = a.dNI();
    AppMethodBeat.o(24871);
    return localb;
  }
  
  static final class a
  {
    private static b wPt;
    
    static
    {
      AppMethodBeat.i(24870);
      wPt = new b((byte)0);
      AppMethodBeat.o(24870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.b
 * JD-Core Version:    0.7.0.1
 */