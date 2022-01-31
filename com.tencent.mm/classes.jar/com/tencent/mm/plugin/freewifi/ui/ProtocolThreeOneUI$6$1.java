package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class ProtocolThreeOneUI$6$1
  implements a.a
{
  ProtocolThreeOneUI$6$1(ProtocolThreeOneUI.6 param6) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(21127);
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.U(this.mOX.mOW.getIntent()), Integer.valueOf(m.V(this.mOX.mOW.getIntent())), paramException.getMessage() });
    d.a(this.mOX.mOW.ssid, 3, this.mOX.mOW.getIntent());
    ProtocolThreeOneUI.a(this.mOX.mOW, 101, m.e(paramException));
    AppMethodBeat.o(21127);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(21126);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(this.mOX.mOW.getIntent()), Integer.valueOf(m.V(this.mOX.mOW.getIntent())), Integer.valueOf(i) });
    if (ProtocolThreeOneUI.d(this.mOX.mOW))
    {
      AppMethodBeat.o(21126);
      return;
    }
    if (i == 200)
    {
      ProtocolThreeOneUI.e(this.mOX.mOW);
      AppMethodBeat.o(21126);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeOneUI.a(this.mOX.mOW, paramHttpURLConnection);
      AppMethodBeat.o(21126);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mOX.mOW.getIntent()), Integer.valueOf(m.V(this.mOX.mOW.getIntent())) });
    d.a(this.mOX.mOW.ssid, 3, this.mOX.mOW.getIntent());
    ProtocolThreeOneUI.a(this.mOX.mOW, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(21126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6.1
 * JD-Core Version:    0.7.0.1
 */