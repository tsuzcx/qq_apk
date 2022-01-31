package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ab;

public class e
{
  protected String appId;
  protected int bWu;
  protected String coX;
  protected int cpt;
  protected final Intent intent;
  protected String kdt;
  protected FreeWifiFrontPageUI mLf;
  protected int mLg;
  protected String mLh;
  protected String ssid;
  
  public e(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    AppMethodBeat.i(20806);
    this.mLf = paramFreeWifiFrontPageUI;
    this.intent = paramFreeWifiFrontPageUI.getIntent();
    this.ssid = this.intent.getStringExtra("free_wifi_ssid");
    this.kdt = this.intent.getStringExtra("free_wifi_url");
    this.coX = this.intent.getStringExtra("free_wifi_ap_key");
    this.cpt = this.intent.getIntExtra("free_wifi_source", 1);
    this.bWu = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.mLh = this.intent.getStringExtra("free_wifi_app_nickname");
    this.mLg = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ab.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.ssid, this.kdt, this.coX, Integer.valueOf(this.cpt), Integer.valueOf(this.bWu), this.appId, this.mLh, Integer.valueOf(this.mLg) });
    AppMethodBeat.o(20806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.e
 * JD-Core Version:    0.7.0.1
 */