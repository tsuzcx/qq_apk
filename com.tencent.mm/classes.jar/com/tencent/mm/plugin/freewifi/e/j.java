package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j
  extends e
  implements a
{
  String cVJ;
  String openId;
  String sign;
  private com.tencent.mm.plugin.freewifi.a tyB;
  private int tyH;
  String tyS;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24930);
    this.tyH = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.tyS = this.intent.getStringExtra("free_wifi_tid");
    this.cVJ = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ae.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.openId, this.tyS, this.cVJ, this.sign });
    AppMethodBeat.o(24930);
  }
  
  private void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(24932);
    k.a locala = k.cTw();
    locala.ssid = this.ssid;
    locala.bssid = m.akJ("MicroMsg.FreeWifi.Protocol32");
    locala.dnP = m.akK("MicroMsg.FreeWifi.Protocol32");
    locala.dnO = this.dnO;
    locala.tvX = this.appId;
    locala.pfT = m.ap(this.intent);
    locala.tvY = 32;
    locala.tvZ = k.b.twB.twK;
    locala.twa = k.b.twB.name;
    locala.result = paramInt;
    locala.fMT = paramString;
    locala.channel = m.as(this.intent);
    locala.cTy().cTx();
    AppMethodBeat.o(24932);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24931);
    this.tyB = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.tyv);
    com.tencent.mm.plugin.freewifi.model.j.cUh().cTQ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24915);
        j.a(j.this);
        AppMethodBeat.o(24915);
      }
    });
    AppMethodBeat.o(24931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j
 * JD-Core Version:    0.7.0.1
 */