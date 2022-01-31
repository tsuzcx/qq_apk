package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class j$4
  implements a.a
{
  j$4(j paramj) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.B(this.kpR.intent), Integer.valueOf(m.C(this.kpR.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      j.a(this.kpR, 0, "");
      m.a(this.kpR.intent, this.kpR.bHI, this.kpR.kpu, this.kpR.bvj, this.kpR.kps, "MicroMsg.FreeWifi.Protocol32");
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      j.a(this.kpR, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.B(this.kpR.intent), Integer.valueOf(m.C(this.kpR.intent)) });
    paramHttpURLConnection = this.kpR.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpR.kpu, k.b.knu, 32);
    paramHttpURLConnection.a(locald, locala);
    j.a(this.kpR, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(this.kpR.intent), Integer.valueOf(m.C(this.kpR.intent)), paramException.getMessage(), m.g(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.kpR.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpR.kpu, k.b.knu, m.h(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    j.a(this.kpR, m.h(paramException), m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.4
 * JD-Core Version:    0.7.0.1
 */