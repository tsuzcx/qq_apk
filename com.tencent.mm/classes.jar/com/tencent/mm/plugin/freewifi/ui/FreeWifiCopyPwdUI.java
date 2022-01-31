package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int mMY = 111;
  private String appId;
  private int bWu;
  private String coX;
  private ak faV;
  private Intent intent;
  private int mLg;
  private int mMZ;
  private int mNa;
  protected TextView mNb;
  protected TextView mNc;
  protected TextView mNd;
  private String ssid;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(20942);
    this.mMZ = 1;
    this.mNa = 2;
    this.faV = new FreeWifiCopyPwdUI.4(this);
    AppMethodBeat.o(20942);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(20946);
    l.C(d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.bAc();
    ((k.a)localObject).coX = this.coX;
    ((k.a)localObject).kMp = m.U(this.intent);
    ((k.a)localObject).mIF = k.b.mJp.mJq;
    ((k.a)localObject).mIG = k.b.mJp.name;
    ((k.a)localObject).cCy = m.X(this.intent);
    ((k.a)localObject).mIE = m.W(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).eev = "";
    ((k.a)localObject).bAe().c(this.intent, true).bAd();
    localObject = new Intent();
    g.gmO.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(20946);
  }
  
  public int getLayoutId()
  {
    return 2130969626;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20944);
    if ((paramInt1 == mMY) && (m.bAi()) && (!bo.isNullOrNil(this.ssid)) && (this.ssid.equals(d.bAC())))
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)) });
      paramIntent = k.bAc();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = m.Ox("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.coY = m.Oy("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.coX = this.coX;
      paramIntent.mIC = this.appId;
      paramIntent.kMp = m.U(this.intent);
      paramIntent.mIE = m.W(this.intent);
      paramIntent.mIF = k.b.mIQ.mJq;
      paramIntent.mIG = k.b.mIQ.name;
      paramIntent.result = 0;
      paramIntent.cCy = m.X(this.intent);
      paramIntent.bAe().bAd();
      m.a(this.intent, this.coX, this.mLg, this.bWu, new FreeWifiCopyPwdUI.3(this), "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
    }
    AppMethodBeat.o(20944);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20943);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(20936);
        FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this);
        AppMethodBeat.o(20936);
        return true;
      }
    });
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.coX = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.bWu = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.mLg = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131824245)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    getContext();
    a.b("wifi password", paramBundle);
    ((Button)findViewById(2131824249)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.mNb = ((TextView)findViewById(2131824246));
    this.mNc = ((TextView)findViewById(2131824247));
    this.mNd = ((TextView)findViewById(2131824248));
    paramBundle = d.bAB();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    h.qsU.e(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
    AppMethodBeat.o(20943);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20945);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(20945);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(20945);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */