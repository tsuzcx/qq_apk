package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class h$2
  implements a.a
{
  h$2(h paramh) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.B(this.kpG.intent), Integer.valueOf(m.C(this.kpG.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      h.a(this.kpG, 0, "");
      m.a(this.kpG.intent, this.kpG.bHI, this.kpG.kpu, this.kpG.bvj, this.kpG.kps, "MicroMsg.FreeWifi.ProtocolThreeOne");
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      h.a(this.kpG, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.B(this.kpG.intent), Integer.valueOf(m.C(this.kpG.intent)) });
    paramHttpURLConnection = this.kpG.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpG.kpu, k.b.knt, 32);
    paramHttpURLConnection.a(locald, locala);
    h.a(this.kpG, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(this.kpG.intent), Integer.valueOf(m.C(this.kpG.intent)), paramException.getMessage(), m.g(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.kpG.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpG.kpu, k.b.knt, m.h(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    h.a(this.kpG, m.h(paramException), m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h.2
 * JD-Core Version:    0.7.0.1
 */