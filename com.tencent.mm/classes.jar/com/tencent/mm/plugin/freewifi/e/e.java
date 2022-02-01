package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.Log;

public class e
{
  protected String appId;
  protected int channelId;
  protected String dFd;
  protected final Intent intent;
  protected String pFJ;
  protected int source;
  protected String ssid;
  protected String wPA;
  protected FreeWifiFrontPageUI wPy;
  protected int wPz;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(24876);
    this.wPy = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.pFJ = this.intent.getStringExtra("free_wifi_url");
    this.dFd = this.intent.getStringExtra("free_wifi_ap_key");
    this.source = this.intent.getIntExtra("free_wifi_source", 1);
    this.channelId = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.wPA = this.intent.getStringExtra("free_wifi_app_nickname");
    this.wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    Log.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.ssid, this.pFJ, this.dFd, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.appId, this.wPA, Integer.valueOf(this.wPz) });
    AppMethodBeat.o(24876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */