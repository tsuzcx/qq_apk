package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ad;

public class e
{
  protected String appId;
  protected int cSc;
  protected String dmM;
  protected int dnh;
  protected final Intent intent;
  protected String omw;
  protected String ssid;
  protected FreeWifiFrontPageUI tnD;
  protected int tnE;
  protected String tnF;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(24876);
    this.tnD = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.omw = this.intent.getStringExtra("free_wifi_url");
    this.dmM = this.intent.getStringExtra("free_wifi_ap_key");
    this.dnh = this.intent.getIntExtra("free_wifi_source", 1);
    this.cSc = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.tnF = this.intent.getStringExtra("free_wifi_app_nickname");
    this.tnE = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ad.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.ssid, this.omw, this.dmM, Integer.valueOf(this.dnh), Integer.valueOf(this.cSc), this.appId, this.tnF, Integer.valueOf(this.tnE) });
    AppMethodBeat.o(24876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */