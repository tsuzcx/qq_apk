package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class FreeWifiPcUI
  extends MMActivity
{
  private String appId;
  private String bJY;
  private Button fbO;
  private String kpv;
  private Button krF;
  private String krL;
  private TextView ksC;
  private int ksD;
  private p ksE = null;
  
  private void goBack()
  {
    Intent localIntent = new Intent();
    g.eUR.i(localIntent, this);
    finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_pc_front_page;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.free_wifi_title);
    setBackBtn(new FreeWifiPcUI.1(this));
    this.appId = getIntent().getStringExtra("free_wifi_appid");
    this.ksD = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
    this.bJY = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
    this.kpv = getIntent().getStringExtra("free_wifi_app_nickname");
    this.krL = getIntent().getStringExtra("free_wifi_privacy_url");
    this.ksC = ((TextView)findViewById(R.h.free_wifi_pc_app_name_tv));
    this.fbO = ((Button)findViewById(R.h.free_wifi_pc_ok_btn));
    this.ksC.setText("由" + this.kpv + "提供");
    this.fbO.setOnClickListener(new FreeWifiPcUI.2(this));
    this.krF = ((Button)findViewById(R.h.free_wifi_pc_user_protocol_privacy_btn));
    this.krF.setOnClickListener(new FreeWifiPcUI.3(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI
 * JD-Core Version:    0.7.0.1
 */