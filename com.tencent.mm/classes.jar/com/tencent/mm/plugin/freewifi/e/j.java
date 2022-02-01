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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j
  extends e
  implements a
{
  String cMo;
  String openId;
  String riG;
  private com.tencent.mm.plugin.freewifi.a rip;
  private int riv;
  String sign;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24930);
    this.riv = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.riG = this.intent.getStringExtra("free_wifi_tid");
    this.cMo = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ad.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), this.openId, this.riG, this.cMo, this.sign });
    AppMethodBeat.o(24930);
  }
  
  private void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(24932);
    k.a locala = k.cvq();
    locala.ssid = this.ssid;
    locala.bssid = m.aav("MicroMsg.FreeWifi.Protocol32");
    locala.ddV = m.aaw("MicroMsg.FreeWifi.Protocol32");
    locala.ddU = this.ddU;
    locala.rfK = this.appId;
    locala.nSA = m.ai(this.intent);
    locala.rfL = 32;
    locala.rfM = k.b.rgo.rgx;
    locala.rfN = k.b.rgo.name;
    locala.result = paramInt;
    locala.foR = paramString;
    locala.channel = m.al(this.intent);
    locala.cvs().cvr();
    AppMethodBeat.o(24932);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24931);
    this.rip = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.rij);
    com.tencent.mm.plugin.freewifi.model.j.cwb().cvK().post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j
 * JD-Core Version:    0.7.0.1
 */