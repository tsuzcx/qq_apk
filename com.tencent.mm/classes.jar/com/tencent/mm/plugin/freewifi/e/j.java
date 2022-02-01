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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j
  extends e
  implements a
{
  String cJz;
  String openId;
  String sign;
  private com.tencent.mm.plugin.freewifi.a sri;
  private int sro;
  String srz;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24930);
    this.sro = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.srz = this.intent.getStringExtra("free_wifi_tid");
    this.cJz = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ac.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), this.openId, this.srz, this.cJz, this.sign });
    AppMethodBeat.o(24930);
  }
  
  private void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(24932);
    k.a locala = k.cIC();
    locala.ssid = this.ssid;
    locala.bssid = m.afn("MicroMsg.FreeWifi.Protocol32");
    locala.dbr = m.afo("MicroMsg.FreeWifi.Protocol32");
    locala.dbq = this.dbq;
    locala.soC = this.appId;
    locala.ovU = m.aj(this.intent);
    locala.soD = 32;
    locala.soE = k.b.spg.spp;
    locala.soF = k.b.spg.name;
    locala.result = paramInt;
    locala.fsq = paramString;
    locala.channel = m.am(this.intent);
    locala.cIE().cID();
    AppMethodBeat.o(24932);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24931);
    this.sri = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.srb);
    com.tencent.mm.plugin.freewifi.model.j.cJn().cIW().post(new Runnable()
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