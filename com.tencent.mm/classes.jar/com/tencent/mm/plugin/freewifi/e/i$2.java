package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class i$2
  implements a.a
{
  i$2(i parami) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.B(this.kpN.intent), Integer.valueOf(m.C(this.kpN.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      this.kpN.aUI();
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      i.a(this.kpN, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.B(this.kpN.intent), Integer.valueOf(m.C(this.kpN.intent)) });
    paramHttpURLConnection = this.kpN.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpN.kpu, k.b.knw, 32);
    paramHttpURLConnection.a(locald, locala);
  }
  
  public final void i(Exception paramException)
  {
    y.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(this.kpN.intent), Integer.valueOf(m.C(this.kpN.intent)), paramException.getMessage(), m.g(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.kpN.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpN.kpu, k.b.knw, m.h(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.2
 * JD-Core Version:    0.7.0.1
 */