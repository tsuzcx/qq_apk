package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class ProtocolThreeTwoUI$10$1
  implements a.a
{
  ProtocolThreeTwoUI$10$1(ProtocolThreeTwoUI.10 param10) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.B(this.kts.kto.getIntent()), Integer.valueOf(m.C(this.kts.kto.getIntent())), Integer.valueOf(i) });
    if (i == 200)
    {
      ProtocolThreeTwoUI.f(this.kts.kto);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeTwoUI.b(this.kts.kto, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[] { m.B(this.kts.kto.getIntent()), Integer.valueOf(m.C(this.kts.kto.getIntent())) });
    d.a(this.kts.kto.ssid, 3, this.kts.kto.getIntent());
    ProtocolThreeTwoUI.a(this.kts.kto, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.B(this.kts.kto.getIntent()), Integer.valueOf(m.C(this.kts.kto.getIntent())), paramException.getMessage() });
    d.a(this.kts.kto.ssid, 3, this.kts.kto.getIntent());
    ProtocolThreeTwoUI.a(this.kts.kto, 101, m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.10.1
 * JD-Core Version:    0.7.0.1
 */