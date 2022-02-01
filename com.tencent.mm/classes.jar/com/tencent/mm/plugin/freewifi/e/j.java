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
  String cUM;
  String openId;
  String sign;
  private com.tencent.mm.plugin.freewifi.a tnJ;
  private int tnP;
  String toa;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24930);
    this.tnP = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.toa = this.intent.getStringExtra("free_wifi_tid");
    this.cUM = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ad.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.openId, this.toa, this.cUM, this.sign });
    AppMethodBeat.o(24930);
  }
  
  private void bj(int paramInt, String paramString)
  {
    AppMethodBeat.i(24932);
    k.a locala = k.cQR();
    locala.ssid = this.ssid;
    locala.bssid = m.ajL("MicroMsg.FreeWifi.Protocol32");
    locala.dmN = m.ajM("MicroMsg.FreeWifi.Protocol32");
    locala.dmM = this.dmM;
    locala.tlf = this.appId;
    locala.oZp = m.ao(this.intent);
    locala.tlg = 32;
    locala.tlh = k.b.tlJ.tlS;
    locala.tli = k.b.tlJ.name;
    locala.result = paramInt;
    locala.fKQ = paramString;
    locala.channel = m.ar(this.intent);
    locala.cQT().cQS();
    AppMethodBeat.o(24932);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24931);
    this.tnJ = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.tnD);
    com.tencent.mm.plugin.freewifi.model.j.cRC().cRl().post(new Runnable()
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