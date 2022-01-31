package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int krl = 111;
  private String appId;
  private String bHI;
  private int bvj;
  private ah dPi = new FreeWifiCopyPwdUI.4(this);
  private Intent intent;
  private int kpu;
  private int krm = 1;
  private int krn = 2;
  protected TextView kro;
  protected TextView krp;
  protected TextView krq;
  private String ssid;
  
  private void goBack()
  {
    l.v(d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.aTx();
    ((k.a)localObject).bHI = this.bHI;
    ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(this.intent);
    ((k.a)localObject).kmS = k.b.knC.knD;
    ((k.a)localObject).kmT = k.b.knC.name;
    ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(this.intent);
    ((k.a)localObject).kmR = com.tencent.mm.plugin.freewifi.m.D(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).dmU = "";
    ((k.a)localObject).aTz().b(this.intent, true).aTy();
    localObject = new Intent();
    g.eUR.i((Intent)localObject, this);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_copy_pwd;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == krl) && (com.tencent.mm.plugin.freewifi.m.aTE()) && (!bk.bl(this.ssid)) && (this.ssid.equals(d.aUa())))
    {
      y.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.intent)) });
      paramIntent = k.aTx();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.bHJ = com.tencent.mm.plugin.freewifi.m.Dq("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.bHI = this.bHI;
      paramIntent.kmQ = this.appId;
      paramIntent.iGw = com.tencent.mm.plugin.freewifi.m.B(this.intent);
      paramIntent.kmR = com.tencent.mm.plugin.freewifi.m.D(this.intent);
      paramIntent.kmS = k.b.knd.knD;
      paramIntent.kmT = k.b.knd.name;
      paramIntent.result = 0;
      paramIntent.bUR = com.tencent.mm.plugin.freewifi.m.E(this.intent);
      paramIntent.aTz().aTy();
      com.tencent.mm.plugin.freewifi.m.a(this.intent, this.bHI, this.kpu, this.bvj, new FreeWifiCopyPwdUI.3(this), "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new FreeWifiCopyPwdUI.1(this));
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.bHI = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.bvj = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.kpu = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(R.h.free_wifi_ssidname)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    a.a(this.mController.uMN, "wifi password", paramBundle);
    ((Button)findViewById(R.h.free_wifi_copy_btn)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.kro = ((TextView)findViewById(R.h.free_wifi_copypwd_connectfail_tv));
    this.krp = ((TextView)findViewById(R.h.free_wifi_copypwd_connectfail_mark_tv));
    this.krq = ((TextView)findViewById(R.h.free_wifi_copypwd_open_detail_tv));
    paramBundle = d.aTZ();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    h.nFQ.f(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */