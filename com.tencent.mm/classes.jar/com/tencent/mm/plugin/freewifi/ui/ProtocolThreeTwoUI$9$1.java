package com.tencent.mm.plugin.freewifi.ui;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

final class ProtocolThreeTwoUI$9$1
  implements a.a
{
  int kpS = 0;
  private final int kpT = 3;
  private int kpU = 0;
  private a.a kpV = new ProtocolThreeTwoUI.9.1.1(this);
  
  ProtocolThreeTwoUI$9$1(ProtocolThreeTwoUI.9 param9, String paramString) {}
  
  private void Dz(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str = ((Uri)localObject).getQueryParameter("authUrl");
    localObject = m.Dn(((Uri)localObject).getQueryParameter("extend"));
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[] { m.B(this.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktq.kto.getIntent())), paramString, str, localObject });
    if (m.isEmpty(str))
    {
      this.kpU += 1;
      if (this.kpU < 3)
      {
        a.aTG();
        a.a(paramString, this.kpV);
        return;
      }
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[] { m.B(this.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktq.kto.getIntent())) });
      d.a(this.ktq.kto.ssid, 3, this.ktq.kto.getIntent());
      ProtocolThreeTwoUI.a(this.ktq.kto, 36, "BLACK_302_TIMES_EXCESS");
      return;
    }
    paramString = new StringBuilder(str);
    if (str.indexOf("?") != -1) {
      paramString.append("&extend=").append((String)localObject);
    }
    for (;;)
    {
      paramString.append("&openId=").append(m.Dn(ProtocolThreeTwoUI.j(this.ktq.kto))).append("&tid=").append(m.Dn(ProtocolThreeTwoUI.i(this.ktq.kto))).append("&timestamp=").append(ProtocolThreeTwoUI.h(this.ktq.kto)).append("&sign=").append(ProtocolThreeTwoUI.g(this.ktq.kto));
      ProtocolThreeTwoUI.a(this.ktq.kto, paramString.toString());
      return;
      paramString.append("?extend=").append((String)localObject);
    }
  }
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[] { m.B(this.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktq.kto.getIntent())) });
      ProtocolThreeTwoUI.f(this.ktq.kto);
      return;
    }
    if (i == 302)
    {
      Dz(paramHttpURLConnection.getHeaderField("Location"));
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(this.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktq.kto.getIntent())) });
    d.a(this.ktq.kto.ssid, 3, this.ktq.kto.getIntent());
    ProtocolThreeTwoUI.a(this.ktq.kto, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.B(this.ktq.kto.getIntent()), Integer.valueOf(m.C(this.ktq.kto.getIntent())), paramException.getMessage() });
    if ((paramException instanceof UnknownHostException))
    {
      ProtocolThreeTwoUI.a(this.ktq.kto, 102, m.f(paramException));
      int i = this.kpS + 1;
      this.kpS = i;
      if (i > 3) {}
    }
    try
    {
      Thread.sleep(3000L);
      a.aTG();
      a.a(this.kpW, this);
      return;
    }
    catch (InterruptedException paramException) {}
    d.a(this.ktq.kto.ssid, 3, this.ktq.kto.getIntent());
    ProtocolThreeTwoUI.a(this.ktq.kto, 101, m.f(paramException));
    return;
    d.a(this.ktq.kto.ssid, 3, this.ktq.kto.getIntent());
    ProtocolThreeTwoUI.a(this.ktq.kto, 101, m.f(paramException));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1
 * JD-Core Version:    0.7.0.1
 */