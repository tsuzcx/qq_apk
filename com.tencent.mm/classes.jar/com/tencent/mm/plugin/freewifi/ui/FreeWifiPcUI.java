package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class FreeWifiPcUI
  extends MMActivity
{
  private String appId;
  private String crs;
  private Button gtF;
  private String mLh;
  private Button mNu;
  private String mNz;
  private TextView mOr;
  private int mOs;
  private p mOt = null;
  
  private void goBack()
  {
    AppMethodBeat.i(21068);
    Intent localIntent = new Intent();
    g.gmO.h(localIntent, this);
    finish();
    AppMethodBeat.o(21068);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969633;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21066);
    super.onCreate(paramBundle);
    setMMTitle(2131300181);
    setBackBtn(new FreeWifiPcUI.1(this));
    this.appId = getIntent().getStringExtra("free_wifi_appid");
    this.mOs = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
    this.crs = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
    this.mLh = getIntent().getStringExtra("free_wifi_app_nickname");
    this.mNz = getIntent().getStringExtra("free_wifi_privacy_url");
    this.mOr = ((TextView)findViewById(2131824275));
    this.gtF = ((Button)findViewById(2131824276));
    this.mOr.setText("由" + this.mLh + "提供");
    this.gtF.setOnClickListener(new FreeWifiPcUI.2(this));
    this.mNu = ((Button)findViewById(2131824277));
    this.mNu.setOnClickListener(new FreeWifiPcUI.3(this));
    AppMethodBeat.o(21066);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21067);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(21067);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21067);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI
 * JD-Core Version:    0.7.0.1
 */