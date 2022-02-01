package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ae;

public class e
{
  protected String appId;
  protected int cSM;
  protected String dnO;
  protected int doj;
  protected final Intent intent;
  protected String osm;
  protected String ssid;
  protected FreeWifiFrontPageUI tyv;
  protected int tyw;
  protected String tyx;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(24876);
    this.tyv = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.osm = this.intent.getStringExtra("free_wifi_url");
    this.dnO = this.intent.getStringExtra("free_wifi_ap_key");
    this.doj = this.intent.getIntExtra("free_wifi_source", 1);
    this.cSM = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.tyx = this.intent.getStringExtra("free_wifi_app_nickname");
    this.tyw = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ae.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.ssid, this.osm, this.dnO, Integer.valueOf(this.doj), Integer.valueOf(this.cSM), this.appId, this.tyx, Integer.valueOf(this.tyw) });
    AppMethodBeat.o(24876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */