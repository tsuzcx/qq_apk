package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ad;

public class e
{
  protected String appId;
  protected int cJR;
  protected String ddU;
  protected int dep;
  protected final Intent intent;
  protected String nha;
  protected FreeWifiFrontPageUI rij;
  protected int rik;
  protected String ril;
  protected String ssid;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(24876);
    this.rij = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.nha = this.intent.getStringExtra("free_wifi_url");
    this.ddU = this.intent.getStringExtra("free_wifi_ap_key");
    this.dep = this.intent.getIntExtra("free_wifi_source", 1);
    this.cJR = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.ril = this.intent.getStringExtra("free_wifi_app_nickname");
    this.rik = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ad.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), this.ssid, this.nha, this.ddU, Integer.valueOf(this.dep), Integer.valueOf(this.cJR), this.appId, this.ril, Integer.valueOf(this.rik) });
    AppMethodBeat.o(24876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */