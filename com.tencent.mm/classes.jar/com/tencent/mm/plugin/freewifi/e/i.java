package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.net.HttpURLConnection;

public final class i
  extends e
  implements a
{
  protected String cJz;
  protected String sign;
  private int sro;
  protected String srr;
  protected String srs;
  protected String srt;
  private Uri sru;
  private String srv;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24911);
    this.sro = 0;
    this.srv = this.intent.getStringExtra("free_wifi_schema_uri");
    this.sru = Uri.parse(this.srv);
    this.appId = this.sru.getQueryParameter("appId");
    this.srr = this.sru.getQueryParameter("shopId");
    this.srs = this.sru.getQueryParameter("authUrl");
    this.srt = this.sru.getQueryParameter("extend");
    this.cJz = this.sru.getQueryParameter("timestamp");
    this.sign = this.sru.getQueryParameter("sign");
    ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), this.sru, this.appId, this.srr, this.srs, this.srt, this.cJz, this.sign });
    AppMethodBeat.o(24911);
  }
  
  protected final void cJI()
  {
    AppMethodBeat.i(24913);
    j.cJn().cIW().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24910);
        Object localObject = k.cIC();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = m.afn("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dbr = m.afo("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dbq = i.this.dbq;
        ((k.a)localObject).ovU = m.aj(i.this.intent);
        ((k.a)localObject).soD = i.this.srd;
        ((k.a)localObject).soE = k.b.soS.spp;
        ((k.a)localObject).soF = k.b.soS.name;
        ((k.a)localObject).channel = m.am(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).cIE().cID();
        localObject = d.cIY();
        String str = d.cJc();
        int i = d.cIZ();
        ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new f(i.this.ssid, m.afn("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.srr, i.this.srs, i.this.srt, i.this.cJz, i.this.sign).c(new g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(24909);
            ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.cIC();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = m.afn("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dbr = m.afo("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dbq = i.this.dbq;
            ((k.a)localObject).ovU = m.aj(i.this.intent);
            ((k.a)localObject).soD = m.al(i.this.intent);
            ((k.a)localObject).soE = k.b.soT.spp;
            ((k.a)localObject).soF = k.b.soT.name;
            ((k.a)localObject).channel = m.am(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).fsq = paramAnonymous2String;
            ((k.a)localObject).cIE().cID();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((f)paramAnonymous2n).cJw();
              if (paramAnonymous2String != null)
              {
                ac.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.DPF, paramAnonymous2String.ndW, paramAnonymous2String.ncR, Integer.valueOf(paramAnonymous2String.DUS), paramAnonymous2String.DUT, paramAnonymous2String.iJW, paramAnonymous2String.DUU });
                paramAnonymous2n = i.this.srb;
                localObject = FreeWifiFrontPageUI.d.stv;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.str = paramAnonymous2String;
                paramAnonymous2n.a((FreeWifiFrontPageUI.d)localObject, localb);
                AppMethodBeat.o(24909);
                return;
              }
              paramAnonymous2String = i.this.srb;
              paramAnonymous2n = FreeWifiFrontPageUI.d.stu;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).ssT = m.a(i.this.srd, k.b.soT, 20);
              paramAnonymous2String.a(paramAnonymous2n, localObject);
              AppMethodBeat.o(24909);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2n = new Intent();
              paramAnonymous2n.putExtra("free_wifi_error_ui_error_msg", i.this.srb.getString(2131759618));
              paramAnonymous2n.setClass(i.this.srb, FreeWifiErrorUI.class);
              i.this.srb.finish();
              paramAnonymous2String = i.this.srb;
              paramAnonymous2n = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymous2n);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, paramAnonymous2n.aeD(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2String.startActivity((Intent)paramAnonymous2n.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24909);
              return;
            }
            paramAnonymous2String = i.this.srb;
            paramAnonymous2n = FreeWifiFrontPageUI.d.stu;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).ssS = 2131759613;
            ((FreeWifiFrontPageUI.a)localObject).ssT = m.a(i.this.srd, k.b.soT, paramAnonymous2Int2);
            paramAnonymous2String.a(paramAnonymous2n, localObject);
            AppMethodBeat.o(24909);
          }
        });
        AppMethodBeat.o(24910);
      }
    });
    AppMethodBeat.o(24913);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24912);
    FreeWifiFrontPageUI.d locald;
    FreeWifiFrontPageUI.a locala;
    if (m.cX(this.ssid))
    {
      ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)) });
      localObject = this.srb;
      locald = FreeWifiFrontPageUI.d.stu;
      locala = new FreeWifiFrontPageUI.a();
      locala.ssT = m.a(this.srd, k.b.spi, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    if (m.cX(this.srs))
    {
      ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)) });
      localObject = this.srb;
      locald = FreeWifiFrontPageUI.d.stu;
      locala = new FreeWifiFrontPageUI.a();
      locala.ssT = m.a(this.srd, k.b.spi, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    Object localObject = new StringBuilder(this.srs);
    if (this.srs.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.srt);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.cJn().cIW().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24906);
          ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)), this.val$url });
          com.tencent.mm.plugin.freewifi.a.a.cIK();
          com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(24904);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)), Integer.valueOf(i) });
              if (i == 200)
              {
                i.this.cJI();
                AppMethodBeat.o(24904);
                return;
              }
              if (i == 302)
              {
                paramAnonymous2HttpURLConnection = paramAnonymous2HttpURLConnection.getHeaderField("Location");
                i.a(i.this, paramAnonymous2HttpURLConnection);
                AppMethodBeat.o(24904);
                return;
              }
              ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)) });
              paramAnonymous2HttpURLConnection = i.this.srb;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.stu;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.ssT = m.a(i.this.srd, k.b.spi, 32);
              paramAnonymous2HttpURLConnection.a(locald, locala);
              AppMethodBeat.o(24904);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(24905);
              ac.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.aj(i.this.intent), Integer.valueOf(m.ak(i.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
              FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.this.srb;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.stu;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.ssT = m.a(i.this.srd, k.b.spi, m.n(paramAnonymous2Exception));
              localFreeWifiFrontPageUI.a(locald, locala);
              AppMethodBeat.o(24905);
            }
          });
          AppMethodBeat.o(24906);
        }
      });
      AppMethodBeat.o(24912);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.srt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */