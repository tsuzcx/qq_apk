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

final class j$3$1
  implements a.a
{
  j$3$1(j.3 param3) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20856);
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLL.mLD.intent), Integer.valueOf(m.V(this.mLL.mLD.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLL.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLL.mLD.mLg, k.b.mJh, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    j.a(this.mLL.mLD, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20856);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20855);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(this.mLL.mLD.intent), Integer.valueOf(m.V(this.mLL.mLD.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      j.a(this.mLL.mLD, 0, "");
      m.a(this.mLL.mLD.intent, this.mLL.mLD.coX, this.mLL.mLD.mLg, this.mLL.mLD.bWu, this.mLL.mLD.mLf, "MicroMsg.FreeWifi.Protocol32");
      AppMethodBeat.o(20855);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      j.b(this.mLL.mLD, paramHttpURLConnection);
      AppMethodBeat.o(20855);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[] { m.U(this.mLL.mLD.intent), Integer.valueOf(m.V(this.mLL.mLD.intent)) });
    paramHttpURLConnection = this.mLL.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLL.mLD.mLg, k.b.mJh, 32);
    paramHttpURLConnection.a(locald, locala);
    j.a(this.mLL.mLD, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.3.1
 * JD-Core Version:    0.7.0.1
 */