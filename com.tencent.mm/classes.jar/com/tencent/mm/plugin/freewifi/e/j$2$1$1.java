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

final class j$2$1$1
  implements a.a
{
  j$2$1$1(j.2.1 param1) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20847);
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[] { m.U(this.mLK.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLK.mLJ.mLD.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLK.mLJ.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLK.mLJ.mLD.mLg, k.b.mJi, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    j.a(this.mLK.mLJ.mLD, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20847);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20846);
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[] { m.U(this.mLK.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLK.mLJ.mLD.intent)) });
      paramHttpURLConnection = this.mLK.mLJ.mLD.mLf;
      locald = FreeWifiFrontPageUI.d.mNJ;
      locala = new FreeWifiFrontPageUI.a();
      locala.mNi = m.a(this.mLK.mLJ.mLD.mLg, k.b.mJi, 35);
      paramHttpURLConnection.a(locald, locala);
      j.a(this.mLK.mLJ.mLD, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
      AppMethodBeat.o(20846);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      j.2.1.a(this.mLK, paramHttpURLConnection);
      AppMethodBeat.o(20846);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mLK.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLK.mLJ.mLD.intent)) });
    paramHttpURLConnection = this.mLK.mLJ.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLK.mLJ.mLD.mLg, k.b.mJi, 32);
    paramHttpURLConnection.a(locald, locala);
    j.a(this.mLK.mLJ.mLD, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.2.1.1
 * JD-Core Version:    0.7.0.1
 */