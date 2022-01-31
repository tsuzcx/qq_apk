package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class h$1$1
  implements a.a
{
  h$1$1(h.1 param1) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.B(this.kpH.kpG.intent), Integer.valueOf(m.C(this.kpH.kpG.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      h.a(this.kpH.kpG, 0, "");
      m.a(this.kpH.kpG.intent, this.kpH.kpG.bHI, this.kpH.kpG.kpu, this.kpH.kpG.bvj, this.kpH.kpG.kps, "MicroMsg.FreeWifi.ProtocolThreeOne");
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      h.a(this.kpH.kpG, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(this.kpH.kpG.intent), Integer.valueOf(m.C(this.kpH.kpG.intent)) });
    paramHttpURLConnection = this.kpH.kpG.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpH.kpG.kpu, k.b.knt, 32);
    paramHttpURLConnection.a(locald, locala);
    h.a(this.kpH.kpG, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[] { m.B(this.kpH.kpG.intent), Integer.valueOf(m.C(this.kpH.kpG.intent)), paramException.getMessage(), m.g(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.kpH.kpG.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpH.kpG.kpu, k.b.knt, m.h(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    h.a(this.kpH.kpG, m.h(paramException), m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h.1.1
 * JD-Core Version:    0.7.0.1
 */