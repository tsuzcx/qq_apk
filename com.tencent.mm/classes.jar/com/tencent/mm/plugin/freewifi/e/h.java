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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.net.HttpURLConnection;

public final class h
  extends e
  implements a
{
  private String tnO;
  private int tnP;
  
  public h(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24899);
    this.tnP = 0;
    this.tnO = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.tnO });
    AppMethodBeat.o(24899);
  }
  
  private void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(24901);
    Object localObject = k.cQR();
    ((k.a)localObject).ssid = this.ssid;
    ((k.a)localObject).bssid = m.ajL("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dmN = m.ajM("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).dmM = this.dmM;
    ((k.a)localObject).tlf = this.appId;
    ((k.a)localObject).oZp = m.ao(this.intent);
    ((k.a)localObject).tlg = 31;
    ((k.a)localObject).tlh = k.b.tlI.tlS;
    ((k.a)localObject).tli = k.b.tlI.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).fKQ = paramString;
    ((k.a)localObject).channel = m.ar(this.intent);
    paramString = ((k.a)localObject).cQT();
    localObject = this.intent;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.c((Intent)localObject, bool).cQS();
      AppMethodBeat.o(24901);
      return;
    }
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24900);
    ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.tnO });
    final String str = this.tnO;
    j.cRC().cRl().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24896);
        ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.ao(h.this.intent), Integer.valueOf(m.ap(h.this.intent)), str });
        com.tencent.mm.plugin.freewifi.a.a.cQZ();
        com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
        {
          public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
          {
            AppMethodBeat.i(24894);
            int i = paramAnonymous2HttpURLConnection.getResponseCode();
            ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.ao(h.this.intent), Integer.valueOf(m.ap(h.this.intent)), Integer.valueOf(i) });
            if (i == 200)
            {
              h.a(h.this, 0, "");
              m.a(h.this.intent, h.this.dmM, h.this.tnE, h.this.cSc, h.this.tnD, "MicroMsg.FreeWifi.ProtocolThreeOne");
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
            ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.ao(h.this.intent), Integer.valueOf(m.ap(h.this.intent)) });
            paramAnonymous2HttpURLConnection = h.this.tnD;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tpW;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.tpv = m.a(h.this.tnE, k.b.tlI, 32);
            paramAnonymous2HttpURLConnection.a(locald, locala);
            h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
            AppMethodBeat.o(24894);
          }
          
          public final void o(Exception paramAnonymous2Exception)
          {
            AppMethodBeat.i(24895);
            ad.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[] { m.ao(h.this.intent), Integer.valueOf(m.ap(h.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
            FreeWifiFrontPageUI localFreeWifiFrontPageUI = h.this.tnD;
            FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tpW;
            FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
            locala.tpv = m.a(h.this.tnE, k.b.tlI, m.n(paramAnonymous2Exception));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h
 * JD-Core Version:    0.7.0.1
 */