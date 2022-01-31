package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends e
  implements a
{
  protected String bIK = this.kpL.getQueryParameter("timestamp");
  private int kpF = 0;
  protected String kpI = this.kpL.getQueryParameter("shopId");
  protected String kpJ = this.kpL.getQueryParameter("authUrl");
  protected String kpK = this.kpL.getQueryParameter("extend");
  private Uri kpL = Uri.parse(this.kpM);
  private String kpM = this.intent.getStringExtra("free_wifi_schema_uri");
  protected String sign = this.kpL.getQueryParameter("sign");
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    this.appId = this.kpL.getQueryParameter("appId");
    y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.intent)), this.kpL, this.appId, this.kpI, this.kpJ, this.kpK, this.bIK, this.sign });
  }
  
  protected final void aUI()
  {
    j.aUl().aTT().post(new Runnable()
    {
      public final void run()
      {
        Object localObject = k.aTx();
        ((k.a)localObject).ssid = i.this.ssid;
        ((k.a)localObject).bssid = com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).bHJ = com.tencent.mm.plugin.freewifi.m.Dq("MicroMsg.FreeWifi.Protocol33");
        ((k.a)localObject).bHI = i.this.bHI;
        ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(i.this.intent);
        ((k.a)localObject).kmR = i.this.kpu;
        ((k.a)localObject).kmS = k.b.kng.knD;
        ((k.a)localObject).kmT = k.b.kng.name;
        ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(i.this.intent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).aTz().aTy();
        localObject = d.aTV();
        String str = d.aTX();
        int i = d.aTW();
        y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(i.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(i.this.intent)), "", localObject, str, Integer.valueOf(i) });
        new com.tencent.mm.plugin.freewifi.d.f(i.this.ssid, com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.kpI, i.this.kpJ, i.this.kpK, i.this.bIK, i.this.sign).b(new com.tencent.mm.ah.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ah.m paramAnonymous2m)
          {
            y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(i.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(i.this.intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            Object localObject = k.aTx();
            ((k.a)localObject).ssid = i.this.ssid;
            ((k.a)localObject).bssid = com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).bHJ = com.tencent.mm.plugin.freewifi.m.Dq("MicroMsg.FreeWifi.Protocol33");
            ((k.a)localObject).bHI = i.this.bHI;
            ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(i.this.intent);
            ((k.a)localObject).kmR = com.tencent.mm.plugin.freewifi.m.D(i.this.intent);
            ((k.a)localObject).kmS = k.b.knh.knD;
            ((k.a)localObject).kmT = k.b.knh.name;
            ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(i.this.intent);
            ((k.a)localObject).result = paramAnonymous2Int2;
            ((k.a)localObject).dmU = paramAnonymous2String;
            ((k.a)localObject).aTz().aTy();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
            {
              paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.f)paramAnonymous2m).aUw();
              if (paramAnonymous2String != null)
              {
                y.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymous2String.svu, paramAnonymous2String.hRf, paramAnonymous2String.hPY, Integer.valueOf(paramAnonymous2String.syP), paramAnonymous2String.syQ, paramAnonymous2String.ffk, paramAnonymous2String.syR });
                paramAnonymous2m = i.this.kps;
                localObject = FreeWifiFrontPageUI.d.krW;
                FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
                localb.krS = paramAnonymous2String;
                paramAnonymous2m.a((FreeWifiFrontPageUI.d)localObject, localb);
                return;
              }
              paramAnonymous2String = i.this.kps;
              paramAnonymous2m = FreeWifiFrontPageUI.d.krV;
              localObject = new FreeWifiFrontPageUI.a();
              ((FreeWifiFrontPageUI.a)localObject).kru = com.tencent.mm.plugin.freewifi.m.a(i.this.kpu, k.b.knh, 20);
              paramAnonymous2String.a(paramAnonymous2m, localObject);
              return;
            }
            if (paramAnonymous2Int2 == -30032)
            {
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("free_wifi_error_ui_error_msg", i.this.kps.getString(R.l.free_wifi_errmsg_33_invalid_sign_warnning));
              paramAnonymous2String.setClass(i.this.kps, FreeWifiErrorUI.class);
              i.this.kps.finish();
              i.this.kps.startActivity(paramAnonymous2String);
              return;
            }
            paramAnonymous2String = i.this.kps;
            paramAnonymous2m = FreeWifiFrontPageUI.d.krV;
            localObject = new FreeWifiFrontPageUI.a();
            ((FreeWifiFrontPageUI.a)localObject).gRY = R.l.free_wifi_connect_fail_tips;
            ((FreeWifiFrontPageUI.a)localObject).kru = com.tencent.mm.plugin.freewifi.m.a(i.this.kpu, k.b.knh, paramAnonymous2Int2);
            paramAnonymous2String.a(paramAnonymous2m, localObject);
          }
        });
      }
    });
  }
  
  public final void connect()
  {
    FreeWifiFrontPageUI.d locald;
    FreeWifiFrontPageUI.a locala;
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.ssid))
    {
      y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.intent)) });
      localObject = this.kps;
      locald = FreeWifiFrontPageUI.d.krV;
      locala = new FreeWifiFrontPageUI.a();
      locala.kru = com.tencent.mm.plugin.freewifi.m.a(this.kpu, k.b.knw, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.kpJ))
    {
      y.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.intent)) });
      localObject = this.kps;
      locald = FreeWifiFrontPageUI.d.krV;
      locala = new FreeWifiFrontPageUI.a();
      locala.kru = com.tencent.mm.plugin.freewifi.m.a(this.kpu, k.b.knw, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      return;
    }
    Object localObject = new StringBuilder(this.kpJ);
    if (this.kpJ.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.kpK);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.aUl().aTT().post(new i.1(this, (String)localObject));
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.kpK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */