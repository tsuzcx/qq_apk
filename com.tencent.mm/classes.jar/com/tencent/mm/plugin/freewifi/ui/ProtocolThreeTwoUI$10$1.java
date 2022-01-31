package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class ProtocolThreeTwoUI$10$1
  implements a.a
{
  ProtocolThreeTwoUI$10$1(ProtocolThreeTwoUI.10 param10) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(21191);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.U(this.mPg.mPc.getIntent()), Integer.valueOf(m.V(this.mPg.mPc.getIntent())), paramException.getMessage() });
    d.a(this.mPg.mPc.ssid, 3, this.mPg.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPg.mPc, 101, m.e(paramException));
    AppMethodBeat.o(21191);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(21190);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(this.mPg.mPc.getIntent()), Integer.valueOf(m.V(this.mPg.mPc.getIntent())), Integer.valueOf(i) });
    if (i == 200)
    {
      ProtocolThreeTwoUI.f(this.mPg.mPc);
      AppMethodBeat.o(21190);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeTwoUI.b(this.mPg.mPc, paramHttpURLConnection);
      AppMethodBeat.o(21190);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[] { m.U(this.mPg.mPc.getIntent()), Integer.valueOf(m.V(this.mPg.mPc.getIntent())) });
    d.a(this.mPg.mPc.ssid, 3, this.mPg.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPg.mPc, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(21190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.10.1
 * JD-Core Version:    0.7.0.1
 */