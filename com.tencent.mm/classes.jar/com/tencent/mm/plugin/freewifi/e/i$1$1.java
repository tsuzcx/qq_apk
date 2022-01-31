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

final class i$1$1
  implements a.a
{
  i$1$1(i.1 param1) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20835);
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLA.mLz.intent), Integer.valueOf(m.V(this.mLA.mLz.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLA.mLz.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLA.mLz.mLg, k.b.mJj, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    AppMethodBeat.o(20835);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20834);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(this.mLA.mLz.intent), Integer.valueOf(m.V(this.mLA.mLz.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      this.mLA.mLz.bBi();
      AppMethodBeat.o(20834);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      i.a(this.mLA.mLz, paramHttpURLConnection);
      AppMethodBeat.o(20834);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mLA.mLz.intent), Integer.valueOf(m.V(this.mLA.mLz.intent)) });
    paramHttpURLConnection = this.mLA.mLz.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLA.mLz.mLg, k.b.mJj, 32);
    paramHttpURLConnection.a(locald, locala);
    AppMethodBeat.o(20834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.1.1
 * JD-Core Version:    0.7.0.1
 */