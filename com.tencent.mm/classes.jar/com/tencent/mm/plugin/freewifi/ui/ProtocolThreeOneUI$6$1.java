package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class ProtocolThreeOneUI$6$1
  implements a.a
{
  ProtocolThreeOneUI$6$1(ProtocolThreeOneUI.6 param6) {}
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.B(this.ktj.kti.getIntent()), Integer.valueOf(m.C(this.ktj.kti.getIntent())), Integer.valueOf(i) });
    if (ProtocolThreeOneUI.d(this.ktj.kti)) {
      return;
    }
    if (i == 200)
    {
      ProtocolThreeOneUI.e(this.ktj.kti);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeOneUI.a(this.ktj.kti, paramHttpURLConnection);
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(this.ktj.kti.getIntent()), Integer.valueOf(m.C(this.ktj.kti.getIntent())) });
    d.a(this.ktj.kti.ssid, 3, this.ktj.kti.getIntent());
    ProtocolThreeOneUI.a(this.ktj.kti, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.B(this.ktj.kti.getIntent()), Integer.valueOf(m.C(this.ktj.kti.getIntent())), paramException.getMessage() });
    d.a(this.ktj.kti.ssid, 3, this.ktj.kti.getIntent());
    ProtocolThreeOneUI.a(this.ktj.kti, 101, m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6.1
 * JD-Core Version:    0.7.0.1
 */