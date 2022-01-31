package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  Activity activity;
  int cCy;
  String coX;
  Intent intent;
  
  public b(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(20933);
    if (bo.isNullOrNil(paramString))
    {
      paramActivity = new IllegalArgumentException("acitvity or apKey cannot be null.");
      AppMethodBeat.o(20933);
      throw paramActivity;
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.coX = paramString;
    this.cCy = paramInt;
    AppMethodBeat.o(20933);
  }
  
  final void OM(String paramString)
  {
    AppMethodBeat.i(20935);
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_error_ui_error_msg", paramString);
    localIntent.setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    this.activity.startActivity(localIntent);
    AppMethodBeat.o(20935);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(20934);
    if (bo.isNullOrNil(this.coX))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.coX);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.coX);
    if (bo.isNullOrNil(this.coX))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(20934);
      return;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.coX, Integer.valueOf(this.cCy) });
    k.a locala = k.bAc();
    locala.coX = this.coX;
    locala.kMp = m.U(this.intent);
    locala.mIF = k.b.mIN.mJq;
    locala.mIG = k.b.mIN.name;
    locala.cCy = this.cCy;
    locala.mIE = m.W(this.intent);
    locala.bAe().c(this.intent, false).bAd();
    new a(this.coX, this.cCy, m.U(this.intent)).U(this.activity).c(new b.1(this));
    AppMethodBeat.o(20934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b
 * JD-Core Version:    0.7.0.1
 */