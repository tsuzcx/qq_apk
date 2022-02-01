package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.net.HttpURLConnection;

public final class h
  extends e
  implements a
{
  private String wPJ;
  private int wPK;
  
  public h(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24899);
    this.wPK = 0;
    this.wPJ = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPJ });
    AppMethodBeat.o(24899);
  }
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(24901);
    Object localObject = k.dMF();
    ((k.a)localObject).ssid = this.ssid;
    ((k.a)localObject).bssid = m.axN("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dFe = m.axO("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dFd = this.dFd;
    ((k.a)localObject).wNb = this.appId;
    ((k.a)localObject).quX = m.aw(this.intent);
    ((k.a)localObject).wNc = 31;
    ((k.a)localObject).wNd = k.b.wNE.wNO;
    ((k.a)localObject).wNe = k.b.wNE.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).resultMsg = paramString;
    ((k.a)localObject).channel = m.az(this.intent);
    paramString = ((k.a)localObject).dMH();
    localObject = this.intent;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.c((Intent)localObject, bool).dMG();
      AppMethodBeat.o(24901);
      return;
    }
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24900);
    Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPJ });
    final String str = this.wPJ;
    j.dNq().dMZ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24896);
        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), str });
        com.tencent.mm.plugin.freewifi.a.a.dMN();
        com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
        {
          public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
          {
            AppMethodBeat.i(24894);
            int i = paramAnonymous2HttpURLConnection.getResponseCode();
            Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), Integer.valueOf(i) });
            if (i == 200)
            {
              h.a(h.this, 0, "");
              m.a(h.this.intent, h.this.dFd, h.this.wPz, h.this.channelId, h.this.wPy, "MicroMsg.FreeWifi.ProtocolThreeOne");
              AppMethodBeat.o(24894);
              return;
            }
            if (i == 302)
            {
              paramAnonymous2HttpURLConnection = paramAnonymous2HttpURLConnection.getHeaderField("Location");
              h.a(h.this, paramAnonymous2HttpURLConnection);
              AppMethodBeat.o(24894);
              return;
            }
            Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)) });
            paramAnonymous2HttpURLConnection = h.this.wPy;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.wRO;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.wRo = m.a(h.this.wPz, k.b.wNE, 32);
            paramAnonymous2HttpURLConnection.a(locald, locala);
            h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
            AppMethodBeat.o(24894);
          }
          
          public final void o(Exception paramAnonymous2Exception)
          {
            AppMethodBeat.i(24895);
            Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[] { m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
            FreeWifiFrontPageUI localFreeWifiFrontPageUI = h.this.wPy;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.wRO;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.wRo = m.a(h.this.wPz, k.b.wNE, m.n(paramAnonymous2Exception));
            localFreeWifiFrontPageUI.a(locald, locala);
            h.a(h.this, m.n(paramAnonymous2Exception), m.l(paramAnonymous2Exception));
            AppMethodBeat.o(24895);
          }
        });
        AppMethodBeat.o(24896);
      }
    });
    AppMethodBeat.o(24900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h
 * JD-Core Version:    0.7.0.1
 */