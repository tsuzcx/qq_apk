package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int bWu;
  protected int cpt;
  private int crJ = 1;
  protected String kdt;
  private ap mMA = new ap(new FreeWifiActivateStateUI.1(this), false);
  private ap mMB = new ap(new FreeWifiActivateStateUI.2(this), true);
  private k.a mMC = new FreeWifiActivateStateUI.3(this);
  private FreeWifiStateView mMr;
  private TextView mMs;
  private TextView mMt;
  private Button mMu;
  protected Button mMv;
  protected String mMw;
  protected FreeWifiNetworkReceiver mMx;
  protected boolean mMy = false;
  private boolean mMz = false;
  protected String ssid;
  
  private void bBr()
  {
    this.mMx = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.mMx, localIntentFilter);
  }
  
  private void bBt()
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.mMy) });
    if (this.mMy)
    {
      ab.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.mMA.ag(60000L, 60000L);
    this.mMB.ag(1000L, 1000L);
    arq();
    this.mMy = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.gmO.h(localIntent, this);
    }
  }
  
  protected abstract void arq();
  
  protected abstract void bBl();
  
  protected abstract int bBm();
  
  protected final void bBo()
  {
    if (this.mMx != null)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
      this.mMx.mKx = null;
    }
  }
  
  protected final void bBp()
  {
    if (this.mMx == null) {
      bBr();
    }
    this.mMx.mKy = this;
  }
  
  protected final void bBq()
  {
    if (this.mMx != null)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.mMx.mKy = null;
    }
  }
  
  protected final void bBs()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.mMA.ag(60000L, 60000L);
      this.mMB.ag(1000L, 1000L);
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.bAN().bAw().post(new FreeWifiActivateStateUI.7(this));
      return;
    }
    this.crJ = bBm();
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.crJ) });
    if (this.crJ != 2)
    {
      this.mMA.ag(60000L, 60000L);
      this.mMB.ag(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.OC(this.ssid))
      {
        bBt();
        return;
      }
      j.bAN().bAw().post(new FreeWifiActivateStateUI.8(this));
      return;
    }
    vc(this.crJ);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969635;
  }
  
  public void initView()
  {
    setBackBtn(new FreeWifiActivateStateUI.4(this));
    this.mMr = ((FreeWifiStateView)findViewById(2131824278));
    this.mMs = ((TextView)findViewById(2131824279));
    this.mMt = ((TextView)findViewById(2131824280));
    if (this.cpt == 3) {
      this.mMt.setText(getString(2131301558, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.mMu = ((Button)findViewById(2131824281));
      this.mMu.setOnClickListener(new FreeWifiActivateStateUI.5(this));
      this.mMv = ((Button)findViewById(2131824268));
      this.mMv.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.mMt.setText(getString(2131298513, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.mMw = getIntent().getStringExtra("free_wifi_mid");
    this.kdt = getIntent().getStringExtra("free_wifi_url");
    this.cpt = getIntent().getIntExtra("free_wifi_source", 1);
    this.bWu = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.cpt)
    {
    default: 
      if (bo.isNullOrNil(this.ssid)) {
        ab.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      break;
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        label134:
        initView();
        j.bAK().add(this.mMC);
        return;
        paramBundle = j.bAK().bBk();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.mMw = paramBundle.field_mid;
          this.kdt = paramBundle.field_url;
          ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.mMw, this.kdt });
          break;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bo.isNullOrNil(this.ssid)) {
          break label252;
        }
        ab.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.bAK().OK(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ag.cE(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.kdt;
      paramBundle.field_mid = this.mMw;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.bAK().insert(paramBundle);
        break;
      }
      j.bAK().update(paramBundle, new String[0]);
      break;
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.mMw, Integer.valueOf(this.cpt) });
      break label134;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.bAK().remove(this.mMC);
    bBo();
    bBq();
    if (this.mMx != null) {
      unregisterReceiver(this.mMx);
    }
    this.mMA.stopTimer();
    this.mMB.stopTimer();
    j.bAN().release();
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
  
  public void onResume()
  {
    super.onResume();
    if (!bo.isNullOrNil(this.ssid)) {
      bBs();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void vc(int paramInt)
  {
    this.mMr.setOnClickListener(null);
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.mMr.setImageResource(2130838901);
      this.mMs.setText(2131298510);
      if (this.cpt == 3) {
        this.mMt.setText(getString(2131301558, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.mMu.setVisibility(8);
      return;
      this.mMr.setImageResource(2130838901);
      this.mMr.setState(3);
      this.mMr.lMs = 2;
      this.mMs.setText(2131298514);
      this.mMu.setVisibility(0);
      this.mMu.setText(2131300177);
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      return;
      this.mMr.setImageResource(2130838899);
      this.mMr.setState(2);
      this.mMs.setText(2131298509);
      this.mMu.setVisibility(0);
      this.mMu.setText(2131300135);
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      if ((this.cpt == 1) || (this.cpt == 5) || (this.cpt == 4))
      {
        this.mMu.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.bAK().OK(this.ssid);
        if ((localc != null) && (!bo.isNullOrNil(localc.field_showUrl)) && (!this.mMz))
        {
          this.mMz = true;
          al.p(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      d.IE();
      return;
      this.mMr.setImageResource(2130838901);
      this.mMr.setState(1);
      this.mMs.setText(2131298510);
      continue;
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      this.mMr.setImageResource(2130838900);
      this.mMr.setState(3);
      this.mMs.setText(2131300163);
      this.mMs.setVisibility(0);
      this.mMt.setText(2131300164);
      this.mMt.setVisibility(0);
      continue;
      this.mMt.setText(getString(2131298513, new Object[] { this.ssid }));
    }
  }
  
  public final void wm(int paramInt)
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    bBo();
    bBs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
 * JD-Core Version:    0.7.0.1
 */