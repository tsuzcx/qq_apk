package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.y;

public class e
{
  protected String appId;
  protected String bHI;
  protected int bvj;
  protected final Intent intent;
  protected FreeWifiFrontPageUI kps;
  protected String kpt;
  protected int kpu;
  protected String kpv;
  protected int source;
  protected String ssid;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    this.kps = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.kpt = this.intent.getStringExtra("free_wifi_url");
    this.bHI = this.intent.getStringExtra("free_wifi_ap_key");
    this.source = this.intent.getIntExtra("free_wifi_source", 1);
    this.bvj = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.kpv = this.intent.getStringExtra("free_wifi_app_nickname");
    this.kpu = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    y.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.ssid, this.kpt, this.bHI, Integer.valueOf(this.source), Integer.valueOf(this.bvj), this.appId, this.kpv, Integer.valueOf(this.kpu) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */