package com.tencent.mm.plugin.freewifi.ui;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

final class ProtocolThreeTwoUI$9$1
  implements a.a
{
  int mLE;
  private final int mLF;
  private int mLG;
  private a.a mLH;
  
  ProtocolThreeTwoUI$9$1(ProtocolThreeTwoUI.9 param9, String paramString)
  {
    AppMethodBeat.i(21183);
    this.mLE = 0;
    this.mLF = 3;
    this.mLG = 0;
    this.mLH = new ProtocolThreeTwoUI.9.1.1(this);
    AppMethodBeat.o(21183);
  }
  
  private void OH(String paramString)
  {
    AppMethodBeat.i(21186);
    Object localObject = Uri.parse(paramString);
    String str = ((Uri)localObject).getQueryParameter("authUrl");
    localObject = m.Ov(((Uri)localObject).getQueryParameter("extend"));
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[] { m.U(this.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPe.mPc.getIntent())), paramString, str, localObject });
    if (m.isEmpty(str))
    {
      this.mLG += 1;
      if (this.mLG < 3)
      {
        a.bAk();
        a.a(paramString, this.mLH);
        AppMethodBeat.o(21186);
        return;
      }
      ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[] { m.U(this.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPe.mPc.getIntent())) });
      d.a(this.mPe.mPc.ssid, 3, this.mPe.mPc.getIntent());
      ProtocolThreeTwoUI.a(this.mPe.mPc, 36, "BLACK_302_TIMES_EXCESS");
      AppMethodBeat.o(21186);
      return;
    }
    paramString = new StringBuilder(str);
    if (str.indexOf("?") != -1) {
      paramString.append("&extend=").append((String)localObject);
    }
    for (;;)
    {
      paramString.append("&openId=").append(m.Ov(ProtocolThreeTwoUI.j(this.mPe.mPc))).append("&tid=").append(m.Ov(ProtocolThreeTwoUI.i(this.mPe.mPc))).append("&timestamp=").append(ProtocolThreeTwoUI.h(this.mPe.mPc)).append("&sign=").append(ProtocolThreeTwoUI.g(this.mPe.mPc));
      ProtocolThreeTwoUI.a(this.mPe.mPc, paramString.toString());
      AppMethodBeat.o(21186);
      return;
      paramString.append("?extend=").append((String)localObject);
    }
  }
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(21185);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.U(this.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPe.mPc.getIntent())), paramException.getMessage() });
    if ((paramException instanceof UnknownHostException))
    {
      ProtocolThreeTwoUI.a(this.mPe.mPc, 102, m.e(paramException));
      int i = this.mLE + 1;
      this.mLE = i;
      if (i <= 3) {
        try
        {
          Thread.sleep(3000L);
          a.bAk();
          a.a(this.mLI, this);
          AppMethodBeat.o(21185);
          return;
        }
        catch (InterruptedException paramException)
        {
          AppMethodBeat.o(21185);
          return;
        }
      }
      d.a(this.mPe.mPc.ssid, 3, this.mPe.mPc.getIntent());
      ProtocolThreeTwoUI.a(this.mPe.mPc, 101, m.e(paramException));
      AppMethodBeat.o(21185);
      return;
    }
    d.a(this.mPe.mPc.ssid, 3, this.mPe.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPe.mPc, 101, m.e(paramException));
    AppMethodBeat.o(21185);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(21184);
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[] { m.U(this.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPe.mPc.getIntent())) });
      ProtocolThreeTwoUI.f(this.mPe.mPc);
      AppMethodBeat.o(21184);
      return;
    }
    if (i == 302)
    {
      OH(paramHttpURLConnection.getHeaderField("Location"));
      AppMethodBeat.o(21184);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPe.mPc.getIntent())) });
    d.a(this.mPe.mPc.ssid, 3, this.mPe.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPe.mPc, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(21184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1
 * JD-Core Version:    0.7.0.1
 */