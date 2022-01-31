package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  private int bKp = 1;
  protected int bvj;
  protected String kpt;
  private FreeWifiStateView kqF;
  private TextView kqG;
  private TextView kqH;
  private Button kqI;
  protected Button kqJ;
  protected String kqK;
  protected FreeWifiNetworkReceiver kqL;
  protected boolean kqM = false;
  private boolean kqN = false;
  private am kqO = new am(new FreeWifiActivateStateUI.1(this), false);
  private am kqP = new am(new FreeWifiActivateStateUI.2(this), true);
  private j.a kqQ = new FreeWifiActivateStateUI.3(this);
  protected int source;
  protected String ssid;
  
  private void aUT()
  {
    this.kqL = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.kqL, localIntentFilter);
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.eUR.i(localIntent, this);
    }
  }
  
  protected abstract void XJ();
  
  protected abstract void aUN();
  
  protected abstract int aUO();
  
  protected final void aUQ()
  {
    if (this.kqL != null)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
      this.kqL.koK = null;
    }
  }
  
  protected final void aUR()
  {
    if (this.kqL == null) {
      aUT();
    }
    this.kqL.koL = this;
  }
  
  protected final void aUS()
  {
    if (this.kqL != null)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.kqL.koL = null;
    }
  }
  
  protected final void aUU()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.kqO.S(60000L, 60000L);
      this.kqP.S(1000L, 1000L);
      y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.aUl().aTT().post(new FreeWifiActivateStateUI.7(this));
      return;
    }
    this.bKp = aUO();
    y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.bKp) });
    if (this.bKp != 2)
    {
      this.kqO.S(60000L, 60000L);
      this.kqP.S(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.Du(this.ssid))
      {
        y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.kqM) });
        if (this.kqM)
        {
          y.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
          return;
        }
        this.kqO.S(60000L, 60000L);
        this.kqP.S(1000L, 1000L);
        XJ();
        this.kqM = true;
        return;
      }
      j.aUl().aTT().post(new FreeWifiActivateStateUI.8(this));
      return;
    }
    qv(this.bKp);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_state;
  }
  
  protected void initView()
  {
    setBackBtn(new FreeWifiActivateStateUI.4(this));
    this.kqF = ((FreeWifiStateView)findViewById(R.h.free_wifi_connect_state_iv));
    this.kqG = ((TextView)findViewById(R.h.free_wifi_connect_state_tv));
    this.kqH = ((TextView)findViewById(R.h.free_wifi_connect_tips));
    if (this.source == 3) {
      this.kqH.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.kqI = ((Button)findViewById(R.h.re_scan_qrcode));
      this.kqI.setOnClickListener(new FreeWifiActivateStateUI.5(this));
      this.kqJ = ((Button)findViewById(R.h.help_btn));
      this.kqJ.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.kqH.setText(getString(R.l.connect_state_connecting_tips, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.kqK = getIntent().getStringExtra("free_wifi_mid");
    this.kpt = getIntent().getStringExtra("free_wifi_url");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.bvj = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.source)
    {
    default: 
      if (bk.bl(this.ssid)) {
        y.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
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
        j.aUi().c(this.kqQ);
        return;
        paramBundle = j.aUi().aUL();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.kqK = paramBundle.field_mid;
          this.kpt = paramBundle.field_url;
          y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.kqK, this.kpt });
          break;
        }
        y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bk.bl(this.ssid)) {
          break label252;
        }
        y.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.aUi().DC(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ad.bB(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.kpt;
      paramBundle.field_mid = this.kqK;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.aUi().b(paramBundle);
        break;
      }
      j.aUi().c(paramBundle, new String[0]);
      break;
      y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.kqK, Integer.valueOf(this.source) });
      break label134;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    j.aUi().d(this.kqQ);
    aUQ();
    aUS();
    if (this.kqL != null) {
      unregisterReceiver(this.kqL);
    }
    this.kqO.stopTimer();
    this.kqP.stopTimer();
    j.aUl().release();
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
  
  protected void onResume()
  {
    super.onResume();
    if (!bk.bl(this.ssid)) {
      aUU();
    }
  }
  
  protected final void qv(int paramInt)
  {
    this.kqF.setOnClickListener(null);
    y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.kqF.setImageResource(R.g.free_wifi_state_normal);
      this.kqG.setText(R.l.connect_state_connecting);
      if (this.source == 3) {
        this.kqH.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.kqI.setVisibility(8);
      return;
      this.kqF.setImageResource(R.g.free_wifi_state_normal);
      this.kqF.setState(3);
      this.kqF.startAngle = 2;
      this.kqG.setText(R.l.connect_state_failed);
      this.kqI.setVisibility(0);
      this.kqI.setText(R.l.free_wifi_re_connect);
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      return;
      this.kqF.setImageResource(R.g.free_wifi_state_connected);
      this.kqF.setState(2);
      this.kqG.setText(R.l.connect_state_connected);
      this.kqI.setVisibility(0);
      this.kqI.setText(R.l.free_wifi_back);
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      if ((this.source == 1) || (this.source == 5) || (this.source == 4))
      {
        this.kqI.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.aUi().DC(this.ssid);
        if ((localc != null) && (!bk.bl(localc.field_showUrl)) && (!this.kqN))
        {
          this.kqN = true;
          ai.l(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      d.wn();
      return;
      this.kqF.setImageResource(R.g.free_wifi_state_normal);
      this.kqF.setState(1);
      this.kqG.setText(R.l.connect_state_connecting);
      continue;
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      this.kqF.setImageResource(R.g.free_wifi_state_illegal_ap);
      this.kqF.setState(3);
      this.kqG.setText(R.l.free_wifi_illegal_ap_tile);
      this.kqG.setVisibility(0);
      this.kqH.setText(R.l.free_wifi_illegal_ap_tips);
      this.kqH.setVisibility(0);
      continue;
      this.kqH.setText(getString(R.l.connect_state_connecting_tips, new Object[] { this.ssid }));
    }
  }
  
  public final void rs(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    aUQ();
    aUU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
 * JD-Core Version:    0.7.0.1
 */