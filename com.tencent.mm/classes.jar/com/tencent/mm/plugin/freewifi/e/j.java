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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j
  extends e
  implements a
{
  String dmc;
  String openId;
  String sign;
  private com.tencent.mm.plugin.freewifi.a wPE;
  private int wPK;
  String wPU;
  
  public j(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(24930);
    this.wPK = 0;
    this.openId = this.intent.getStringExtra("free_wifi_openid");
    this.wPU = this.intent.getStringExtra("free_wifi_tid");
    this.dmc = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.openId, this.wPU, this.dmc, this.sign });
    AppMethodBeat.o(24930);
  }
  
  private void bu(int paramInt, String paramString)
  {
    AppMethodBeat.i(24932);
    k.a locala = k.dMF();
    locala.ssid = this.ssid;
    locala.bssid = m.axN("MicroMsg.FreeWifi.Protocol32");
    locala.dFe = m.axO("MicroMsg.FreeWifi.Protocol32");
    locala.dFd = this.dFd;
    locala.wNb = this.appId;
    locala.quX = m.aw(this.intent);
    locala.wNc = 32;
    locala.wNd = k.b.wNF.wNO;
    locala.wNe = k.b.wNF.name;
    locala.result = paramInt;
    locala.resultMsg = paramString;
    locala.channel = m.az(this.intent);
    locala.dMH().dMG();
    AppMethodBeat.o(24932);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24931);
    this.wPE = new com.tencent.mm.plugin.freewifi.a(this.ssid, this.wPy);
    com.tencent.mm.plugin.freewifi.model.j.dNq().dMZ().post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j
 * JD-Core Version:    0.7.0.1
 */