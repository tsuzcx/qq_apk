package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
{
  private static void a(ft paramft, int paramInt, String paramString)
  {
    AppMethodBeat.i(24749);
    paramft.dIW.dIZ = paramInt;
    paramft.dIW.dJa = paramString;
    paramft.dIW.dIY = 1;
    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramft.callback != null) {
      paramft.callback.run();
    }
    AppMethodBeat.o(24749);
  }
  
  public final void a(ft paramft)
  {
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(24748);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        str1 = m.removeSsidQuote(paramft.dIV.ssid);
        str2 = paramft.dIV.bssid;
        if (m.eP(str1))
        {
          a(paramft, 1141, "Ssid is empty.");
          AppMethodBeat.o(24748);
          return;
        }
        if (m.eP(str2))
        {
          a(paramft, 1142, "Bssid is empty.");
          AppMethodBeat.o(24748);
          continue;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + paramft.dIV.ssid + "; bssid=" + paramft.dIV.bssid + "; version=" + paramft.dIV.version);
      }
      finally {}
      Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
      a.b localb = a.a.dMP().hs(str1, str2);
      Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
      if (localb == null)
      {
        if (a.a.dMP().size() == 0)
        {
          a(paramft, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramft, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
          AppMethodBeat.o(24748);
        }
      }
      else
      {
        final String str3 = localb.dFd;
        int i = localb.wNc;
        if (i == 4)
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24745);
              Intent localIntent = new Intent();
              localIntent.putExtra("free_wifi_ap_key", str3);
              localIntent.putExtra("free_wifi_sessionkey", m.dMJ());
              localIntent.putExtra("free_wifi_source", 6);
              localIntent.addFlags(67108864);
              c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
              AppMethodBeat.o(24745);
            }
          });
          a(paramft, 1, null);
          AppMethodBeat.o(24748);
        }
        else if (i == 31)
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
          MMHandlerThread.postToMainThread(new b.2(this, str1, str2));
          a(paramft, 1, null);
          AppMethodBeat.o(24748);
        }
        else
        {
          a(paramft, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
          AppMethodBeat.o(24748);
        }
      }
    }
  }
  
  public static final class a
  {
    private static b wOf;
    
    static
    {
      AppMethodBeat.i(24747);
      wOf = new b((byte)0);
      AppMethodBeat.o(24747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b
 * JD-Core Version:    0.7.0.1
 */