package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

final class j$2$1
  implements a.a
{
  int mLE;
  private final int mLF;
  private int mLG;
  private a.a mLH;
  
  j$2$1(j.2 param2, String paramString)
  {
    AppMethodBeat.i(20848);
    this.mLE = 0;
    this.mLF = 3;
    this.mLG = 0;
    this.mLH = new j.2.1.1(this);
    AppMethodBeat.o(20848);
  }
  
  private void OH(String paramString)
  {
    AppMethodBeat.i(20851);
    Object localObject2 = Uri.parse(paramString);
    Object localObject1 = ((Uri)localObject2).getQueryParameter("authUrl");
    localObject2 = m.Ov(((Uri)localObject2).getQueryParameter("extend"));
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)), paramString, localObject1, localObject2 });
    if (m.isEmpty((String)localObject1))
    {
      this.mLG += 1;
      if (this.mLG < 3)
      {
        a.bAk();
        a.a(paramString, this.mLH);
        AppMethodBeat.o(20851);
        return;
      }
      ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)) });
      paramString = this.mLJ.mLD.mLf;
      localObject1 = FreeWifiFrontPageUI.d.mNJ;
      localObject2 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject2).mNi = m.a(this.mLJ.mLD.mLg, k.b.mJi, 36);
      paramString.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
      j.a(this.mLJ.mLD, 36, "BLACK_302_TIMES_EXCESS");
      AppMethodBeat.o(20851);
      return;
    }
    paramString = new StringBuilder((String)localObject1);
    if (((String)localObject1).indexOf("?") != -1) {
      paramString.append("&extend=").append((String)localObject2);
    }
    for (;;)
    {
      paramString.append("&openId=").append(m.Ov(this.mLJ.mLD.openId)).append("&tid=").append(m.Ov(this.mLJ.mLD.mLC)).append("&timestamp=").append(this.mLJ.mLD.cqf).append("&sign=").append(this.mLJ.mLD.sign);
      j.a(this.mLJ.mLD, paramString.toString());
      ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)), paramString.toString() });
      AppMethodBeat.o(20851);
      return;
      paramString.append("?extend=").append((String)localObject2);
    }
  }
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20850);
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)), paramException.getMessage(), m.f(paramException) });
    if ((paramException instanceof UnknownHostException))
    {
      j.b(this.mLJ.mLD, 102, m.e(paramException));
      ab.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.mLE);
      int i = this.mLE + 1;
      this.mLE = i;
      if (i <= 3) {
        try
        {
          Thread.sleep(3000L);
          a.bAk();
          a.a(this.mLI, this);
          AppMethodBeat.o(20850);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[] { m.f(paramException) });
          j.b(this.mLJ.mLD, 103, m.e(paramException));
          paramException = this.mLJ.mLD.mLf;
          localObject1 = FreeWifiFrontPageUI.d.mNJ;
          localObject2 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject2).mNi = m.a(this.mLJ.mLD.mLg, k.b.mJi, 103);
          paramException.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
          AppMethodBeat.o(20850);
          return;
        }
      }
      localObject1 = this.mLJ.mLD.mLf;
      localObject2 = FreeWifiFrontPageUI.d.mNJ;
      locala = new FreeWifiFrontPageUI.a();
      locala.mNi = m.a(this.mLJ.mLD.mLg, k.b.mJi, m.g(paramException));
      ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
      j.b(this.mLJ.mLD, m.g(paramException), m.e(paramException));
      AppMethodBeat.o(20850);
      return;
    }
    Object localObject1 = this.mLJ.mLD.mLf;
    Object localObject2 = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLJ.mLD.mLg, k.b.mJi, m.g(paramException));
    ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
    j.b(this.mLJ.mLD, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20850);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20849);
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)) });
      j.a(this.mLJ.mLD, 0, "");
      m.a(this.mLJ.mLD.intent, this.mLJ.mLD.coX, this.mLJ.mLD.mLg, this.mLJ.mLD.bWu, this.mLJ.mLD.mLf, "MicroMsg.FreeWifi.Protocol32");
      AppMethodBeat.o(20849);
      return;
    }
    if (i == 302)
    {
      OH(paramHttpURLConnection.getHeaderField("Location"));
      AppMethodBeat.o(20849);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mLJ.mLD.intent), Integer.valueOf(m.V(this.mLJ.mLD.intent)) });
    paramHttpURLConnection = this.mLJ.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLJ.mLD.mLg, k.b.mJi, 32);
    paramHttpURLConnection.a(locald, locala);
    j.b(this.mLJ.mLD, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.2.1
 * JD-Core Version:    0.7.0.1
 */