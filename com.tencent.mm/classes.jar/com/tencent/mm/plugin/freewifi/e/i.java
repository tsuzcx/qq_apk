package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.net.HttpURLConnection;

public final class i
  extends e
  implements a
{
  protected String cUM;
  protected String sign;
  private int tnP;
  protected String tnS;
  protected String tnT;
  protected String tnU;
  private Uri tnV;
  private String tnW;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24911);
    this.tnP = 0;
    this.tnW = this.intent.getStringExtra("free_wifi_schema_uri");
    this.tnV = Uri.parse(this.tnW);
    this.appId = this.tnV.getQueryParameter("appId");
    this.tnS = this.tnV.getQueryParameter("shopId");
    this.tnT = this.tnV.getQueryParameter("authUrl");
    this.tnU = this.tnV.getQueryParameter("extend");
    this.cUM = this.tnV.getQueryParameter("timestamp");
    this.sign = this.tnV.getQueryParameter("sign");
    ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.tnV, this.appId, this.tnS, this.tnT, this.tnU, this.cUM, this.sign });
    AppMethodBeat.o(24911);
  }
  
  protected final void cRX()
  {
    AppMethodBeat.i(24913);
    j.cRC().cRl().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24910);
        Object localObject = k.cQR();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = m.ajL("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dmN = m.ajM("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).dmM = i.this.dmM;
        ((k.a)localObject).oZp = m.ao(i.this.intent);
        ((k.a)localObject).tlg = i.this.tnE;
        ((k.a)localObject).tlh = k.b.tlv.tlS;
        ((k.a)localObject).tli = k.b.tlv.name;
        ((k.a)localObject).channel = m.ar(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).cQT().cQS();
        localObject = d.cRn();
        String str = d.cRr();
        int i = d.cRo();
        ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new com.tencent.mm.plugin.freewifi.d.f(i.this.ssid, m.ajL("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.tnS, i.this.tnT, i.this.tnU, i.this.cUM, i.this.sign).c(new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(24909);
            ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.cQR();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = m.ajL("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dmN = m.ajM("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).dmM = i.this.dmM;
            ((k.a)localObject).oZp = m.ao(i.this.intent);
            ((k.a)localObject).tlg = m.aq(i.this.intent);
            ((k.a)localObject).tlh = k.b.tlw.tlS;
            ((k.a)localObject).tli = k.b.tlw.name;
            ((k.a)localObject).channel = m.ar(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).fKQ = paramAnonymous2String;
            ((k.a)localObject).cQT().cQS();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.f)paramAnonymous2n).cRL();
              if (paramAnonymous2String != null)
              {
                ad.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.FuU, paramAnonymous2String.nEt, paramAnonymous2String.nDo, Integer.valueOf(paramAnonymous2String.FAn), paramAnonymous2String.FAo, paramAnonymous2String.jdf, paramAnonymous2String.FAp });
                paramAnonymous2n = i.this.tnD;
                localObject = FreeWifiFrontPageUI.d.tpX;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.tpT = paramAnonymous2String;
                paramAnonymous2n.a((FreeWifiFrontPageUI.d)localObject, localb);
                AppMethodBeat.o(24909);
                return;
              }
              paramAnonymous2String = i.this.tnD;
              paramAnonymous2n = FreeWifiFrontPageUI.d.tpW;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).tpv = m.a(i.this.tnE, k.b.tlw, 20);
              paramAnonymous2String.a(paramAnonymous2n, localObject);
              AppMethodBeat.o(24909);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2n = new Intent();
              paramAnonymous2n.putExtra("free_wifi_error_ui_error_msg", i.this.tnD.getString(2131759618));
              paramAnonymous2n.setClass(i.this.tnD, FreeWifiErrorUI.class);
              i.this.tnD.finish();
              paramAnonymous2String = i.this.tnD;
              paramAnonymous2n = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2n);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, paramAnonymous2n.ahp(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2String.startActivity((Intent)paramAnonymous2n.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(24909);
              return;
            }
            paramAnonymous2String = i.this.tnD;
            paramAnonymous2n = FreeWifiFrontPageUI.d.tpW;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).tpu = 2131759613;
            ((FreeWifiFrontPageUI.a)localObject).tpv = m.a(i.this.tnE, k.b.tlw, paramAnonymous2Int2);
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
    if (m.ea(this.ssid))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)) });
      localObject = this.tnD;
      locald = FreeWifiFrontPageUI.d.tpW;
      locala = new FreeWifiFrontPageUI.a();
      locala.tpv = m.a(this.tnE, k.b.tlL, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    if (m.ea(this.tnT))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)) });
      localObject = this.tnD;
      locald = FreeWifiFrontPageUI.d.tpW;
      locala = new FreeWifiFrontPageUI.a();
      locala.tpv = m.a(this.tnE, k.b.tlL, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(24912);
      return;
    }
    Object localObject = new StringBuilder(this.tnT);
    if (this.tnT.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.tnU);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.cRC().cRl().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24906);
          ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)), this.val$url });
          com.tencent.mm.plugin.freewifi.a.a.cQZ();
          com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(24904);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)), Integer.valueOf(i) });
              if (i == 200)
              {
                i.this.cRX();
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
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)) });
              paramAnonymous2HttpURLConnection = i.this.tnD;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tpW;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.tpv = m.a(i.this.tnE, k.b.tlL, 32);
              paramAnonymous2HttpURLConnection.a(locald, locala);
              AppMethodBeat.o(24904);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(24905);
              ad.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[] { m.ao(i.this.intent), Integer.valueOf(m.ap(i.this.intent)), paramAnonymous2Exception.getMessage(), m.m(paramAnonymous2Exception) });
              FreeWifiFrontPageUI localFreeWifiFrontPageUI = i.this.tnD;
              FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.tpW;
              FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
              locala.tpv = m.a(i.this.tnE, k.b.tlL, m.n(paramAnonymous2Exception));
              localFreeWifiFrontPageUI.a(locald, locala);
              AppMethodBeat.o(24905);
            }
          });
          AppMethodBeat.o(24906);
        }
      });
      AppMethodBeat.o(24912);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.tnU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */