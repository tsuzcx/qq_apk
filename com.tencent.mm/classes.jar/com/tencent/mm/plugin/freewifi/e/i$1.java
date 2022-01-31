package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class i$1
  implements Runnable
{
  i$1(i parami, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.B(this.kpN.intent), Integer.valueOf(m.C(this.kpN.intent)), this.val$url });
    a.aTG();
    a.a(this.val$url, new a.a()
    {
      public final void f(HttpURLConnection paramAnonymousHttpURLConnection)
      {
        int i = paramAnonymousHttpURLConnection.getResponseCode();
        y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.B(i.1.this.kpN.intent), Integer.valueOf(m.C(i.1.this.kpN.intent)), Integer.valueOf(i) });
        if (i == 200)
        {
          i.1.this.kpN.aUI();
          return;
        }
        if (i == 302)
        {
          paramAnonymousHttpURLConnection = paramAnonymousHttpURLConnection.getHeaderField("Location");
          i.a(i.1.this.kpN, paramAnonymousHttpURLConnection);
          return;
        }
        y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(i.1.this.kpN.intent), Integer.valueOf(m.C(i.1.this.kpN.intent)) });
        paramAnonymousHttpURLConnection = i.1.this.kpN.kps;
        FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
        FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
        locala.kru = m.a(i.1.this.kpN.kpu, k.b.knw, 32);
        paramAnonymousHttpURLConnection.a(locald, locala);
      }
      
      public final void i(Exception paramAnonymousException)
      {
        y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(i.1.this.kpN.intent), Integer.valueOf(m.C(i.1.this.kpN.intent)), paramAnonymousException.getMessage(), m.g(paramAnonymousException) });
        FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.1.this.kpN.kps;
        FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
        FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
        locala.kru = m.a(i.1.this.kpN.kpu, k.b.knw, m.h(paramAnonymousException));
        localFreeWifiFrontPageUI.a(locald, locala);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.1
 * JD-Core Version:    0.7.0.1
 */