package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ac;

public class e
{
  protected String appId;
  protected int cGY;
  protected int dbL;
  protected String dbq;
  protected final Intent intent;
  protected String nJQ;
  protected FreeWifiFrontPageUI srb;
  protected int srd;
  protected String sre;
  protected String ssid;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(24876);
    this.srb = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.nJQ = this.intent.getStringExtra("free_wifi_url");
    this.dbq = this.intent.getStringExtra("free_wifi_ap_key");
    this.dbL = this.intent.getIntExtra("free_wifi_source", 1);
    this.cGY = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.sre = this.intent.getStringExtra("free_wifi_app_nickname");
    this.srd = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ac.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), this.ssid, this.nJQ, this.dbq, Integer.valueOf(this.dbL), Integer.valueOf(this.cGY), this.appId, this.sre, Integer.valueOf(this.srd) });
    AppMethodBeat.o(24876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */