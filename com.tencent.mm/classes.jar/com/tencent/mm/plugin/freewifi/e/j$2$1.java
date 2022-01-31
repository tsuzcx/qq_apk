package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

final class j$2$1
  implements a.a
{
  int kpS = 0;
  private final int kpT = 3;
  private int kpU = 0;
  private a.a kpV = new a.a()
  {
    public final void f(HttpURLConnection paramAnonymousHttpURLConnection)
    {
      int i = paramAnonymousHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[] { m.B(j.2.1.this.kpX.kpR.intent), Integer.valueOf(m.C(j.2.1.this.kpX.kpR.intent)) });
        paramAnonymousHttpURLConnection = j.2.1.this.kpX.kpR.kps;
        locald = FreeWifiFrontPageUI.d.krV;
        locala = new FreeWifiFrontPageUI.a();
        locala.kru = m.a(j.2.1.this.kpX.kpR.kpu, k.b.knv, 35);
        paramAnonymousHttpURLConnection.a(locald, locala);
        j.a(j.2.1.this.kpX.kpR, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
        return;
      }
      if (i == 302)
      {
        paramAnonymousHttpURLConnection = paramAnonymousHttpURLConnection.getHeaderField("Location");
        j.2.1.a(j.2.1.this, paramAnonymousHttpURLConnection);
        return;
      }
      y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(j.2.1.this.kpX.kpR.intent), Integer.valueOf(m.C(j.2.1.this.kpX.kpR.intent)) });
      paramAnonymousHttpURLConnection = j.2.1.this.kpX.kpR.kps;
      FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
      FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
      locala.kru = m.a(j.2.1.this.kpX.kpR.kpu, k.b.knv, 32);
      paramAnonymousHttpURLConnection.a(locald, locala);
      j.a(j.2.1.this.kpX.kpR, 32, "INVALID_HTTP_RESP_CODE");
    }
    
    public final void i(Exception paramAnonymousException)
    {
      y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[] { m.B(j.2.1.this.kpX.kpR.intent), Integer.valueOf(m.C(j.2.1.this.kpX.kpR.intent)), paramAnonymousException.getMessage(), m.g(paramAnonymousException) });
      FreeWifiFrontPageUI localFreeWifiFrontPageUI = j.2.1.this.kpX.kpR.kps;
      FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
      FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
      locala.kru = m.a(j.2.1.this.kpX.kpR.kpu, k.b.knv, m.h(paramAnonymousException));
      localFreeWifiFrontPageUI.a(locald, locala);
      j.a(j.2.1.this.kpX.kpR, m.h(paramAnonymousException), m.f(paramAnonymousException));
    }
  };
  
  j$2$1(j.2 param2, String paramString) {}
  
  private void Dz(String paramString)
  {
    Object localObject2 = Uri.parse(paramString);
    Object localObject1 = ((Uri)localObject2).getQueryParameter("authUrl");
    localObject2 = m.Dn(((Uri)localObject2).getQueryParameter("extend"));
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)), paramString, localObject1, localObject2 });
    if (m.isEmpty((String)localObject1))
    {
      this.kpU += 1;
      if (this.kpU < 3)
      {
        a.aTG();
        a.a(paramString, this.kpV);
        return;
      }
      y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)) });
      paramString = this.kpX.kpR.kps;
      localObject1 = FreeWifiFrontPageUI.d.krV;
      localObject2 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject2).kru = m.a(this.kpX.kpR.kpu, k.b.knv, 36);
      paramString.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
      j.a(this.kpX.kpR, 36, "BLACK_302_TIMES_EXCESS");
      return;
    }
    paramString = new StringBuilder((String)localObject1);
    if (((String)localObject1).indexOf("?") != -1) {
      paramString.append("&extend=").append((String)localObject2);
    }
    for (;;)
    {
      paramString.append("&openId=").append(m.Dn(this.kpX.kpR.openId)).append("&tid=").append(m.Dn(this.kpX.kpR.kpQ)).append("&timestamp=").append(this.kpX.kpR.bIK).append("&sign=").append(this.kpX.kpR.sign);
      localObject1 = this.kpX.kpR;
      localObject2 = paramString.toString();
      com.tencent.mm.plugin.freewifi.model.j.aUl().aTT().post(new j.3((j)localObject1, (String)localObject2));
      y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)), paramString.toString() });
      return;
      paramString.append("?extend=").append((String)localObject2);
    }
  }
  
  public final void f(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)) });
      j.a(this.kpX.kpR, 0, "");
      m.a(this.kpX.kpR.intent, this.kpX.kpR.bHI, this.kpX.kpR.kpu, this.kpX.kpR.bvj, this.kpX.kpR.kps, "MicroMsg.FreeWifi.Protocol32");
      return;
    }
    if (i == 302)
    {
      Dz(paramHttpURLConnection.getHeaderField("Location"));
      return;
    }
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)) });
    paramHttpURLConnection = this.kpX.kpR.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpX.kpR.kpu, k.b.knv, 32);
    paramHttpURLConnection.a(locald, locala);
    j.b(this.kpX.kpR, 32, "INVALID_HTTP_RESP_CODE");
  }
  
  public final void i(Exception paramException)
  {
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.B(this.kpX.kpR.intent), Integer.valueOf(m.C(this.kpX.kpR.intent)), paramException.getMessage(), m.g(paramException) });
    if ((paramException instanceof UnknownHostException))
    {
      j.b(this.kpX.kpR, 102, m.f(paramException));
      y.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.kpS);
      int i = this.kpS + 1;
      this.kpS = i;
      if (i <= 3) {
        try
        {
          Thread.sleep(3000L);
          a.aTG();
          a.a(this.kpW, this);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          y.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[] { m.g(paramException) });
          j.b(this.kpX.kpR, 103, m.f(paramException));
          paramException = this.kpX.kpR.kps;
          localObject1 = FreeWifiFrontPageUI.d.krV;
          localObject2 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject2).kru = m.a(this.kpX.kpR.kpu, k.b.knv, 103);
          paramException.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
          return;
        }
      }
      localObject1 = this.kpX.kpR.kps;
      localObject2 = FreeWifiFrontPageUI.d.krV;
      locala = new FreeWifiFrontPageUI.a();
      locala.kru = m.a(this.kpX.kpR.kpu, k.b.knv, m.h(paramException));
      ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
      j.b(this.kpX.kpR, m.h(paramException), m.f(paramException));
      return;
    }
    Object localObject1 = this.kpX.kpR.kps;
    Object localObject2 = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.kru = m.a(this.kpX.kpR.kpu, k.b.knv, m.h(paramException));
    ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
    j.b(this.kpX.kpR, m.h(paramException), m.f(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.2.1
 * JD-Core Version:    0.7.0.1
 */