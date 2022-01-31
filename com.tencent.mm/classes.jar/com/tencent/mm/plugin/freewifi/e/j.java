package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class j
  extends e
  implements a
{
  String cqf;
  String mLC;
  private com.tencent.mm.plugin.freewifi.a mLl;
  private int mLr;
  String openId;
  String sign;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(20860);
    this.mLr = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.mLC = this.intent.getStringExtra("free_wifi_tid");
    this.cqf = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.openId, this.mLC, this.cqf, this.sign });
    AppMethodBeat.o(20860);
  }
  
  private void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(20862);
    k.a locala = k.bAc();
    locala.ssid = this.ssid;
    locala.bssid = m.Ox("MicroMsg.FreeWifi.Protocol32");
    locala.coY = m.Oy("MicroMsg.FreeWifi.Protocol32");
    locala.coX = this.coX;
    locala.mIC = this.appId;
    locala.kMp = m.U(this.intent);
    locala.mIE = 32;
    locala.mIF = k.b.mJh.mJq;
    locala.mIG = k.b.mJh.name;
    locala.result = paramInt;
    locala.eev = paramString;
    locala.cCy = m.X(this.intent);
    locala.bAe().bAd();
    AppMethodBeat.o(20862);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(20861);
    this.mLl = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.mLf);
    com.tencent.mm.plugin.freewifi.model.j.bAN().bAw().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20845);
        j.a(j.this);
        AppMethodBeat.o(20845);
      }
    });
    AppMethodBeat.o(20861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j
 * JD-Core Version:    0.7.0.1
 */