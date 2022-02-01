package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.net.HttpURLConnection;

public final class i
  extends e
  implements a
{
  protected String dmc;
  protected String extend;
  protected String sign;
  private int wPK;
  protected String wPN;
  protected String wPO;
  private Uri wPP;
  private String wPQ;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24911);
    this.wPK = 0;
    this.wPQ = this.intent.getStringExtra("free_wifi_schema_uri");
    this.wPP = Uri.parse(this.wPQ);
    this.appId = this.wPP.getQueryParameter("appId");
    this.wPN = this.wPP.getQueryParameter("shopId");
    this.wPO = this.wPP.getQueryParameter("authUrl");
    this.extend = this.wPP.getQueryParameter("extend");
    this.dmc = this.wPP.getQueryParameter("timestamp");
    this.sign = this.wPP.getQueryParameter("sign");
    Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPP, this.appId, this.wPN, this.wPO, this.extend, this.dmc, this.sign });
    AppMethodBeat.o(24911);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24912);
    FreeWifiFrontPageUI.d locald;
    FreeWifiFrontPageUI.a locala;
    if (m.eP(this.ssid))
    {
      Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)) });
      localObject = this.wPy;
      locald = FreeWifiFrontPageUI.d.wRO;
      locala = new FreeWifiFrontPageUI.a();
      locala.wRo = m.a(this.wPz, k.b.wNH, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    if (m.eP(this.wPO))
    {
      Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)) });
      localObject = this.wPy;
      locald = FreeWifiFrontPageUI.d.wRO;
      locala = new FreeWifiFrontPageUI.a();
      locala.wRo = m.a(this.wPz, k.b.wNH, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    Object localObject = new StringBuilder(this.wPO);
    if (this.wPO.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.extend);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.dNq().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24906);
          Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), this.val$url });
          com.tencent.mm.plugin.freewifi.a.a.dMN();
          com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(24904);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), Integer.valueOf(i) });
              if (i == 200)
              {
                i.this.dNL();
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
              Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)) });
              paramAnonymous2HttpURLConnection = i.this.wPy;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.wRO;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.wRo = m.a(i.this.wPz, k.b.wNH, 32);
              paramAnonymous2HttpURLConnection.a(locald, locala);
              AppMethodBeat.o(24904);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(24905);
              Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
              FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.this.wPy;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.wRO;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.wRo = m.a(i.this.wPz, k.b.wNH, m.n(paramAnonymous2Exception));
              localFreeWifiFrontPageUI.a(locald, locala);
              AppMethodBeat.o(24905);
            }
          });
          AppMethodBeat.o(24906);
        }
      });
      AppMethodBeat.o(24912);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.extend);
    }
  }
  
  protected final void dNL()
  {
    AppMethodBeat.i(24913);
    j.dNq().dMZ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24910);
        Object localObject = k.dMF();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = m.axN("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dFe = m.axO("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dFd = i.this.dFd;
        ((k.a)localObject).quX = m.aw(i.this.intent);
        ((k.a)localObject).wNc = i.this.wPz;
        ((k.a)localObject).wNd = k.b.wNr.wNO;
        ((k.a)localObject).wNe = k.b.wNr.name;
        ((k.a)localObject).channel = m.az(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).dMH().dMG();
        localObject = d.dNb();
        String str = d.dNf();
        int i = d.dNc();
        Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new f(i.this.ssid, m.axN("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.wPN, i.this.wPO, i.this.extend, i.this.dmc, i.this.sign).c(new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(24909);
            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.dMF();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = m.axN("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dFe = m.axO("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dFd = i.this.dFd;
            ((k.a)localObject).quX = m.aw(i.this.intent);
            ((k.a)localObject).wNc = m.ay(i.this.intent);
            ((k.a)localObject).wNd = k.b.wNs.wNO;
            ((k.a)localObject).wNe = k.b.wNs.name;
            ((k.a)localObject).channel = m.az(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).resultMsg = paramAnonymous2String;
            ((k.a)localObject).dMH().dMG();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((f)paramAnonymous2q).dNz();
              if (paramAnonymous2String != null)
              {
                Log.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.KGX, paramAnonymous2String.oUJ, paramAnonymous2String.UserName, Integer.valueOf(paramAnonymous2String.KMt), paramAnonymous2String.KMu, paramAnonymous2String.keb, paramAnonymous2String.KMv });
                paramAnonymous2q = i.this.wPy;
                localObject = FreeWifiFrontPageUI.d.wRP;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.wRL = paramAnonymous2String;
                paramAnonymous2q.a((FreeWifiFrontPageUI.d)localObject, localb);
                AppMethodBeat.o(24909);
                return;
              }
              paramAnonymous2String = i.this.wPy;
              paramAnonymous2q = FreeWifiFrontPageUI.d.wRO;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).wRo = m.a(i.this.wPz, k.b.wNs, 20);
              paramAnonymous2String.a(paramAnonymous2q, localObject);
              AppMethodBeat.o(24909);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2q = new Intent();
              paramAnonymous2q.putExtra("free_wifi_error_ui_error_msg", i.this.wPy.getString(2131760939));
              paramAnonymous2q.setClass(i.this.wPy, FreeWifiErrorUI.class);
              i.this.wPy.finish();
              paramAnonymous2String = i.this.wPy;
              paramAnonymous2q = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2q);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, paramAnonymous2q.axQ(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2String.startActivity((Intent)paramAnonymous2q.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24909);
              return;
            }
            paramAnonymous2String = i.this.wPy;
            paramAnonymous2q = FreeWifiFrontPageUI.d.wRO;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).wRn = 2131760934;
            ((FreeWifiFrontPageUI.a)localObject).wRo = m.a(i.this.wPz, k.b.wNs, paramAnonymous2Int2);
            paramAnonymous2String.a(paramAnonymous2q, localObject);
            AppMethodBeat.o(24909);
          }
        });
        AppMethodBeat.o(24910);
      }
    });
    AppMethodBeat.o(24913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */