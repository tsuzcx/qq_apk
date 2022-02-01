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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.net.HttpURLConnection;

public final class h
  extends e
  implements a
{
  private String tyG;
  private int tyH;
  
  public h(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24899);
    this.tyH = 0;
    this.tyG = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.tyG });
    AppMethodBeat.o(24899);
  }
  
  private void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(24901);
    Object localObject = k.cTw();
    ((k.a)localObject).ssid = this.ssid;
    ((k.a)localObject).bssid = m.akJ("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dnP = m.akK("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dnO = this.dnO;
    ((k.a)localObject).tvX = this.appId;
    ((k.a)localObject).pfT = m.ap(this.intent);
    ((k.a)localObject).tvY = 31;
    ((k.a)localObject).tvZ = k.b.twA.twK;
    ((k.a)localObject).twa = k.b.twA.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).fMT = paramString;
    ((k.a)localObject).channel = m.as(this.intent);
    paramString = ((k.a)localObject).cTy();
    localObject = this.intent;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.c((Intent)localObject, bool).cTx();
      AppMethodBeat.o(24901);
      return;
    }
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24900);
    ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.tyG });
    final String str = this.tyG;
    j.cUh().cTQ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24896);
        ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.ap(h.this.intent), Integer.valueOf(m.aq(h.this.intent)), str });
        com.tencent.mm.plugin.freewifi.a.a.cTE();
        com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
        {
          public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
          {
            AppMethodBeat.i(24894);
            int i = paramAnonymous2HttpURLConnection.getResponseCode();
            ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.ap(h.this.intent), Integer.valueOf(m.aq(h.this.intent)), Integer.valueOf(i) });
            if (i == 200)
            {
              h.a(h.this, 0, "");
              m.a(h.this.intent, h.this.dnO, h.this.tyw, h.this.cSM, h.this.tyv, "MicroMsg.FreeWifi.ProtocolThreeOne");
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
            ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.ap(h.this.intent), Integer.valueOf(m.aq(h.this.intent)) });
            paramAnonymous2HttpURLConnection = h.this.tyv;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tAN;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.tAm = m.a(h.this.tyw, k.b.twA, 32);
            paramAnonymous2HttpURLConnection.a(locald, locala);
            h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
            AppMethodBeat.o(24894);
          }
          
          public final void o(Exception paramAnonymous2Exception)
          {
            AppMethodBeat.i(24895);
            ae.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[] { m.ap(h.this.intent), Integer.valueOf(m.aq(h.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
            FreeWifiFrontPageUI localFreeWifiFrontPageUI = h.this.tyv;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tAN;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.tAm = m.a(h.this.tyw, k.b.twA, m.n(paramAnonymous2Exception));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h
 * JD-Core Version:    0.7.0.1
 */