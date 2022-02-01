package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.a.a.a;
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
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.net.HttpURLConnection;

public final class i
  extends e
  implements a
{
  protected String cVJ;
  protected String sign;
  private int tyH;
  protected String tyK;
  protected String tyL;
  protected String tyM;
  private Uri tyN;
  private String tyO;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24911);
    this.tyH = 0;
    this.tyO = this.intent.getStringExtra("free_wifi_schema_uri");
    this.tyN = Uri.parse(this.tyO);
    this.appId = this.tyN.getQueryParameter("appId");
    this.tyK = this.tyN.getQueryParameter("shopId");
    this.tyL = this.tyN.getQueryParameter("authUrl");
    this.tyM = this.tyN.getQueryParameter("extend");
    this.cVJ = this.tyN.getQueryParameter("timestamp");
    this.sign = this.tyN.getQueryParameter("sign");
    ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.tyN, this.appId, this.tyK, this.tyL, this.tyM, this.cVJ, this.sign });
    AppMethodBeat.o(24911);
  }
  
  protected final void cUC()
  {
    AppMethodBeat.i(24913);
    j.cUh().cTQ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24910);
        Object localObject = k.cTw();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = m.akJ("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dnP = m.akK("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dnO = i.this.dnO;
        ((k.a)localObject).pfT = m.ap(i.this.intent);
        ((k.a)localObject).tvY = i.this.tyw;
        ((k.a)localObject).tvZ = k.b.twn.twK;
        ((k.a)localObject).twa = k.b.twn.name;
        ((k.a)localObject).channel = m.as(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).cTy().cTx();
        localObject = d.cTS();
        String str = d.cTW();
        int i = d.cTT();
        ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new com.tencent.mm.plugin.freewifi.d.f(i.this.ssid, m.akJ("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.tyK, i.this.tyL, i.this.tyM, i.this.cVJ, i.this.sign).c(new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(24909);
            ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.cTw();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = m.akJ("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dnP = m.akK("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dnO = i.this.dnO;
            ((k.a)localObject).pfT = m.ap(i.this.intent);
            ((k.a)localObject).tvY = m.ar(i.this.intent);
            ((k.a)localObject).tvZ = k.b.two.twK;
            ((k.a)localObject).twa = k.b.two.name;
            ((k.a)localObject).channel = m.as(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).fMT = paramAnonymous2String;
            ((k.a)localObject).cTy().cTx();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.f)paramAnonymous2n).cUq();
              if (paramAnonymous2String != null)
              {
                ae.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.FNs, paramAnonymous2String.nJO, paramAnonymous2String.nIJ, Integer.valueOf(paramAnonymous2String.FSK), paramAnonymous2String.FSL, paramAnonymous2String.jfY, paramAnonymous2String.FSM });
                paramAnonymous2n = i.this.tyv;
                localObject = FreeWifiFrontPageUI.d.tAO;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.tAK = paramAnonymous2String;
                paramAnonymous2n.a((FreeWifiFrontPageUI.d)localObject, localb);
                AppMethodBeat.o(24909);
                return;
              }
              paramAnonymous2String = i.this.tyv;
              paramAnonymous2n = FreeWifiFrontPageUI.d.tAN;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).tAm = m.a(i.this.tyw, k.b.two, 20);
              paramAnonymous2String.a(paramAnonymous2n, localObject);
              AppMethodBeat.o(24909);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2n = new Intent();
              paramAnonymous2n.putExtra("free_wifi_error_ui_error_msg", i.this.tyv.getString(2131759618));
              paramAnonymous2n.setClass(i.this.tyv, FreeWifiErrorUI.class);
              i.this.tyv.finish();
              paramAnonymous2String = i.this.tyv;
              paramAnonymous2n = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2n);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, paramAnonymous2n.ahE(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2String.startActivity((Intent)paramAnonymous2n.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24909);
              return;
            }
            paramAnonymous2String = i.this.tyv;
            paramAnonymous2n = FreeWifiFrontPageUI.d.tAN;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).tAl = 2131759613;
            ((FreeWifiFrontPageUI.a)localObject).tAm = m.a(i.this.tyw, k.b.two, paramAnonymous2Int2);
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
    if (m.ef(this.ssid))
    {
      ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)) });
      localObject = this.tyv;
      locald = FreeWifiFrontPageUI.d.tAN;
      locala = new FreeWifiFrontPageUI.a();
      locala.tAm = m.a(this.tyw, k.b.twD, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    if (m.ef(this.tyL))
    {
      ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)) });
      localObject = this.tyv;
      locald = FreeWifiFrontPageUI.d.tAN;
      locala = new FreeWifiFrontPageUI.a();
      locala.tAm = m.a(this.tyw, k.b.twD, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    Object localObject = new StringBuilder(this.tyL);
    if (this.tyL.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.tyM);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.cUh().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24906);
          ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)), this.val$url });
          com.tencent.mm.plugin.freewifi.a.a.cTE();
          com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(24904);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)), Integer.valueOf(i) });
              if (i == 200)
              {
                i.this.cUC();
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
              ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)) });
              paramAnonymous2HttpURLConnection = i.this.tyv;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tAN;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.tAm = m.a(i.this.tyw, k.b.twD, 32);
              paramAnonymous2HttpURLConnection.a(locald, locala);
              AppMethodBeat.o(24904);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(24905);
              ae.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.ap(i.this.intent), Integer.valueOf(m.aq(i.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
              FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.this.tyv;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tAN;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.tAm = m.a(i.this.tyw, k.b.twD, m.n(paramAnonymous2Exception));
              localFreeWifiFrontPageUI.a(locald, locala);
              AppMethodBeat.o(24905);
            }
          });
          AppMethodBeat.o(24906);
        }
      });
      AppMethodBeat.o(24912);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.tyM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */