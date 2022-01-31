package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class ProtocolThreeTwoUI$9$1$1
  implements a.a
{
  ProtocolThreeTwoUI$9$1$1(ProtocolThreeTwoUI.9.1 param1) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[] { m.B(this.ktr.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktr.ktq.kto.getIntent())) });
      d.a(this.ktr.ktq.kto.ssid, 3, this.ktr.ktq.kto.getIntent());
      ProtocolThreeTwoUI.a(this.ktr.ktq.kto, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeTwoUI.9.1.a(this.ktr, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(this.ktr.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktr.ktq.kto.getIntent())) });
    d.a(this.ktr.ktq.kto.ssid, 3, this.ktr.ktq.kto.getIntent());
    ProtocolThreeTwoUI.a(this.ktr.ktq.kto, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.B(this.ktr.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktr.ktq.kto.getIntent())), paramException.getMessage() });
    d.a(this.ktr.ktq.kto.ssid, 3, this.ktr.ktq.kto.getIntent());
    ProtocolThreeTwoUI.a(this.ktr.ktq.kto, 101, m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1.1
 * JD-Core Version:    0.7.0.1
 */