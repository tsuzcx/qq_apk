package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class j$3$1
  implements a.a
{
  j$3$1(j.3 param3) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.B(this.kpZ.kpR.intent), Integer.valueOf(m.C(this.kpZ.kpR.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      j.a(this.kpZ.kpR, 0, "");
      m.a(this.kpZ.kpR.intent, this.kpZ.kpR.bHI, this.kpZ.kpR.kpu, this.kpZ.kpR.bvj, this.kpZ.kpR.kps, "MicroMsg.FreeWifi.Protocol32");
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      j.a(this.kpZ.kpR, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[] { m.B(this.kpZ.kpR.intent), Integer.valueOf(m.C(this.kpZ.kpR.intent)) });
    paramHttpURLConnection = this.kpZ.kpR.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpZ.kpR.kpu, k.b.knu, 32);
    paramHttpURLConnection.a(locald, locala);
    j.a(this.kpZ.kpR, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(this.kpZ.kpR.intent), Integer.valueOf(m.C(this.kpZ.kpR.intent)), paramException.getMessage(), m.g(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.kpZ.kpR.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpZ.kpR.kpu, k.b.knu, m.h(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    j.a(this.kpZ.kpR, m.h(paramException), m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.3.1
 * JD-Core Version:    0.7.0.1
 */