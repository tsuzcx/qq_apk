package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
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
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.net.HttpURLConnection;

public final class i
  extends e
  implements a
{
  protected String cMo;
  protected String riA;
  private Uri riB;
  private String riC;
  private int riv;
  protected String riy;
  protected String riz;
  protected String sign;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24911);
    this.riv = 0;
    this.riC = this.intent.getStringExtra("free_wifi_schema_uri");
    this.riB = Uri.parse(this.riC);
    this.appId = this.riB.getQueryParameter("appId");
    this.riy = this.riB.getQueryParameter("shopId");
    this.riz = this.riB.getQueryParameter("authUrl");
    this.riA = this.riB.getQueryParameter("extend");
    this.cMo = this.riB.getQueryParameter("timestamp");
    this.sign = this.riB.getQueryParameter("sign");
    ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), this.riB, this.appId, this.riy, this.riz, this.riA, this.cMo, this.sign });
    AppMethodBeat.o(24911);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24912);
    FreeWifiFrontPageUI.d locald;
    FreeWifiFrontPageUI.a locala;
    if (m.dq(this.ssid))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)) });
      localObject = this.rij;
      locald = FreeWifiFrontPageUI.d.rkB;
      locala = new FreeWifiFrontPageUI.a();
      locala.rka = m.a(this.rik, k.b.rgq, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    if (m.dq(this.riz))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)) });
      localObject = this.rij;
      locald = FreeWifiFrontPageUI.d.rkB;
      locala = new FreeWifiFrontPageUI.a();
      locala.rka = m.a(this.rik, k.b.rgq, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    Object localObject = new StringBuilder(this.riz);
    if (this.riz.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.riA);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.cwb().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24906);
          ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)), this.val$url });
          com.tencent.mm.plugin.freewifi.a.a.cvy();
          com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(24904);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)), Integer.valueOf(i) });
              if (i == 200)
              {
                i.this.cww();
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
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)) });
              paramAnonymous2HttpURLConnection = i.this.rij;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.rkB;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.rka = m.a(i.this.rik, k.b.rgq, 32);
              paramAnonymous2HttpURLConnection.a(locald, locala);
              AppMethodBeat.o(24904);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(24905);
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
              FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.this.rij;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.rkB;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.rka = m.a(i.this.rik, k.b.rgq, m.n(paramAnonymous2Exception));
              localFreeWifiFrontPageUI.a(locald, locala);
              AppMethodBeat.o(24905);
            }
          });
          AppMethodBeat.o(24906);
        }
      });
      AppMethodBeat.o(24912);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.riA);
    }
  }
  
  protected final void cww()
  {
    AppMethodBeat.i(24913);
    j.cwb().cvK().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24910);
        Object localObject = k.cvq();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = m.aav("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).ddV = m.aaw("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).ddU = i.this.ddU;
        ((k.a)localObject).nSA = m.ai(i.this.intent);
        ((k.a)localObject).rfL = i.this.rik;
        ((k.a)localObject).rfM = k.b.rga.rgx;
        ((k.a)localObject).rfN = k.b.rga.name;
        ((k.a)localObject).channel = m.al(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).cvs().cvr();
        localObject = d.cvM();
        String str = d.cvQ();
        int i = d.cvN();
        ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new f(i.this.ssid, m.aav("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.riy, i.this.riz, i.this.riA, i.this.cMo, i.this.sign).c(new g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(24909);
            ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ai(i.this.intent), Integer.valueOf(m.aj(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.cvq();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = m.aav("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).ddV = m.aaw("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).ddU = i.this.ddU;
            ((k.a)localObject).nSA = m.ai(i.this.intent);
            ((k.a)localObject).rfL = m.ak(i.this.intent);
            ((k.a)localObject).rfM = k.b.rgb.rgx;
            ((k.a)localObject).rfN = k.b.rgb.name;
            ((k.a)localObject).channel = m.al(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).foR = paramAnonymous2String;
            ((k.a)localObject).cvs().cvr();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((f)paramAnonymous2n).cwk();
              if (paramAnonymous2String != null)
              {
                ad.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.Cxj, paramAnonymous2String.mBV, paramAnonymous2String.mAQ, Integer.valueOf(paramAnonymous2String.CCv), paramAnonymous2String.CCw, paramAnonymous2String.ijP, paramAnonymous2String.CCx });
                paramAnonymous2n = i.this.rij;
                localObject = FreeWifiFrontPageUI.d.rkC;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.rky = paramAnonymous2String;
                paramAnonymous2n.a((FreeWifiFrontPageUI.d)localObject, localb);
                AppMethodBeat.o(24909);
                return;
              }
              paramAnonymous2String = i.this.rij;
              paramAnonymous2n = FreeWifiFrontPageUI.d.rkB;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).rka = m.a(i.this.rik, k.b.rgb, 20);
              paramAnonymous2String.a(paramAnonymous2n, localObject);
              AppMethodBeat.o(24909);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2n = new Intent();
              paramAnonymous2n.putExtra("free_wifi_error_ui_error_msg", i.this.rij.getString(2131759618));
              paramAnonymous2n.setClass(i.this.rij, FreeWifiErrorUI.class);
              i.this.rij.finish();
              paramAnonymous2String = i.this.rij;
              paramAnonymous2n = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymous2n);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, paramAnonymous2n.adn(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2String.startActivity((Intent)paramAnonymous2n.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24909);
              return;
            }
            paramAnonymous2String = i.this.rij;
            paramAnonymous2n = FreeWifiFrontPageUI.d.rkB;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).rjZ = 2131759613;
            ((FreeWifiFrontPageUI.a)localObject).rka = m.a(i.this.rik, k.b.rgb, paramAnonymous2Int2);
            paramAnonymous2String.a(paramAnonymous2n, localObject);
            AppMethodBeat.o(24909);
          }
        });
        AppMethodBeat.o(24910);
      }
    });
    AppMethodBeat.o(24913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */