package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class h$1$1
  implements a.a
{
  h$1$1(h.1 param1) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20825);
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[] { m.U(this.mLt.mLs.intent), Integer.valueOf(m.V(this.mLt.mLs.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLt.mLs.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLt.mLs.mLg, k.b.mJg, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    h.a(this.mLt.mLs, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20825);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20824);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(this.mLt.mLs.intent), Integer.valueOf(m.V(this.mLt.mLs.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      h.a(this.mLt.mLs, 0, "");
      m.a(this.mLt.mLs.intent, this.mLt.mLs.coX, this.mLt.mLs.mLg, this.mLt.mLs.bWu, this.mLt.mLs.mLf, "MicroMsg.FreeWifi.ProtocolThreeOne");
      AppMethodBeat.o(20824);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      h.a(this.mLt.mLs, paramHttpURLConnection);
      AppMethodBeat.o(20824);
      return;
    }
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mLt.mLs.intent), Integer.valueOf(m.V(this.mLt.mLs.intent)) });
    paramHttpURLConnection = this.mLt.mLs.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLt.mLs.mLg, k.b.mJg, 32);
    paramHttpURLConnection.a(locald, locala);
    h.a(this.mLt.mLs, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h.1.1
 * JD-Core Version:    0.7.0.1
 */