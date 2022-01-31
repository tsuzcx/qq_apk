package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends e
  implements a
{
  String bIK = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
  private int kpF = 0;
  String kpQ = this.intent.getStringExtra("free_wifi_tid");
  private com.tencent.mm.plugin.freewifi.a kpz;
  String openId = this.intent.getStringExtra("free_wifi_openid");
  String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.openId, this.kpQ, this.bIK, this.sign });
  }
  
  private void ao(int paramInt, String paramString)
  {
    k.a locala = k.aTx();
    locala.ssid = this.ssid;
    locala.bssid = m.Dp("MicroMsg.FreeWifi.Protocol32");
    locala.bHJ = m.Dq("MicroMsg.FreeWifi.Protocol32");
    locala.bHI = this.bHI;
    locala.kmQ = this.appId;
    locala.iGw = m.B(this.intent);
    locala.kmR = 32;
    locala.kmS = k.b.knu.knD;
    locala.kmT = k.b.knu.name;
    locala.result = paramInt;
    locala.dmU = paramString;
    locala.bUR = m.E(this.intent);
    locala.aTz().aTy();
  }
  
  public final void connect()
  {
    this.kpz = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.kps);
    com.tencent.mm.plugin.freewifi.model.j.aUl().aTT().post(new Runnable()
    {
      public final void run()
      {
        j.a(j.this);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j
 * JD-Core Version:    0.7.0.1
 */