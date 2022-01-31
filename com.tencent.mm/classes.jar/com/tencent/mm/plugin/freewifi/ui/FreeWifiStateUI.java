package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected String bHI;
  private int bKp = 1;
  protected String bNZ;
  protected String bOL;
  protected int bvj;
  private final com.tencent.mm.as.a.a.c eqR;
  protected String kpt;
  protected String kpv;
  protected String kqK;
  protected FreeWifiNetworkReceiver kqL;
  protected boolean kqM = false;
  private am kqO = new am(new FreeWifiStateUI.1(this), false);
  private am kqP = new am(new FreeWifiStateUI.2(this), true);
  private j.a kqQ;
  private ImageView krB;
  private TextView krC;
  private TextView krD;
  private Button krE;
  private Button krF;
  protected String krI;
  protected String krJ;
  protected String krK;
  protected String krL;
  private TextView kro;
  private p ksE = null;
  protected int ksJ;
  protected String ksK;
  protected String ksL;
  protected String signature;
  protected int source;
  protected String ssid;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.erd = true;
    locala.ere = true;
    locala.eru = R.g.free_wifi_icon_default;
    locala.erD = true;
    locala.erE = 0.0F;
    this.eqR = locala.OV();
    this.kqQ = new FreeWifiStateUI.3(this);
  }
  
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
    l.v(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.eUR.i(localIntent, this);
    finish();
  }
  
  protected abstract void XJ();
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void aUN();
  
  protected abstract int aUO();
  
  protected final void aUQ()
  {
    if (this.kqL != null)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
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
      y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.kqL.koL = null;
    }
  }
  
  protected final void aUU()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.kqO.S(60000L, 60000L);
      this.kqP.S(1000L, 1000L);
      y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.aUl().aTT().post(new FreeWifiStateUI.7(this));
      return;
    }
    this.bKp = aUO();
    y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.bKp) });
    if (this.bKp != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.D(getIntent()) == 4) {
        this.kqO.S(30000L, 30000L);
      }
      for (;;)
      {
        this.kqP.S(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.Du(this.ssid)) {
          break label233;
        }
        y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.kqM) });
        if (!this.kqM) {
          break;
        }
        y.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.kqO.S(60000L, 60000L);
      }
      this.kqO.S(60000L, 60000L);
      this.kqP.S(1000L, 1000L);
      XJ();
      this.kqM = true;
      return;
      label233:
      j.aUl().aTT().post(new FreeWifiStateUI.8(this));
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.bKp, getIntent());
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_front_page;
  }
  
  protected void initView()
  {
    setBackBtn(new FreeWifiStateUI.4(this));
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(R.h.user_protocol_phone_text).setVisibility(0);
    }
    this.krB = ((ImageView)findViewById(R.h.free_wifi_app_logo_iv));
    this.krC = ((TextView)findViewById(R.h.free_wifi_welcomemsg_tv));
    this.krD = ((TextView)findViewById(R.h.free_wifi_ssidname_tv));
    this.kro = ((TextView)findViewById(R.h.free_wifi_connectfail_tv));
    this.krE = ((Button)findViewById(R.h.connect_wifi_btn));
    this.krE.setOnClickListener(new FreeWifiStateUI.5(this));
    this.krF = ((Button)findViewById(R.h.user_protocol_privacy_btn));
    this.krF.setOnClickListener(new FreeWifiStateUI.6(this));
    if (bk.bl(this.ssid))
    {
      this.krD.setText(getString(R.l.free_wifi_ssid_empty_tips));
      this.krE.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bHI = getIntent().getStringExtra("free_wifi_ap_key");
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.kqK = getIntent().getStringExtra("free_wifi_mid");
    this.kpt = getIntent().getStringExtra("free_wifi_url");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.bvj = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.bOL = getIntent().getStringExtra("free_wifi_appid");
    this.krI = getIntent().getStringExtra("free_wifi_head_img_url");
    this.krJ = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.krK = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.krL = getIntent().getStringExtra("free_wifi_privacy_url");
    this.kpv = getIntent().getStringExtra("free_wifi_app_nickname");
    switch (this.source)
    {
    default: 
      if (bk.bl(this.ssid)) {
        y.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      break;
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        label234:
        initView();
        j.aUi().c(this.kqQ);
        l.t(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.aUi().aUL();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.kqK = paramBundle.field_mid;
          this.kpt = paramBundle.field_url;
          y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.kqK, this.kpt });
          break;
        }
        y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bk.bl(this.ssid)) {
          break label377;
        }
        y.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.aUi().DC(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ad.bB(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.kpt;
      paramBundle.field_mid = this.kqK;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.aUi().b(paramBundle);
        break;
      }
      j.aUi().c(paramBundle, new String[0]);
      break;
      y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.kqK, Integer.valueOf(this.source) });
      break label234;
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
  
  protected final void qv(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kro.setVisibility(4);
      this.krE.setText(R.l.connect_state_wating);
      if (this.source == 3) {
        this.krD.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bk.bl(this.bOL))
      {
        if (!bk.bl(this.krJ)) {
          this.krC.setText(this.krJ);
        }
        if (!bk.bl(this.krI)) {
          o.ON().a(this.krI, this.krB, this.eqR);
        }
      }
      label462:
      for (;;)
      {
        return;
        if (this.ksE != null) {
          this.ksE.dismiss();
        }
        this.kqO.stopTimer();
        this.kqP.stopTimer();
        this.kqM = false;
        this.kro.setVisibility(4);
        this.krE.setText(R.l.connect_state_wating);
        if ((com.tencent.mm.plugin.freewifi.m.E(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(q.dyi.dyE)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(q.bc(this.mController.uMN)))) {
          this.krE.setText(String.format(getString(R.l.free_wifi_connect_btn_manu_wording), new Object[] { q.bc(this.mController.uMN) }));
        }
        if (this.source == 3) {
          this.krD.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[] { this.ssid }));
        }
        for (;;)
        {
          if (bk.bl(this.bOL)) {
            break label462;
          }
          if (!bk.bl(this.krJ)) {
            this.krC.setText(this.krJ);
          }
          if (bk.bl(this.krI)) {
            break;
          }
          o.ON().a(this.krI, this.krB, this.eqR);
          return;
          if (bk.bl(this.krK)) {
            this.krD.setText(getString(R.l.connect_state_connecting_default_tips));
          } else {
            this.krD.setText(this.krK);
          }
        }
      }
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      this.kro.setVisibility(0);
      this.krE.setText(R.l.free_wifi_re_connect);
      return;
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      this.krE.setText(R.l.connect_state_connected);
      this.krE.setClickable(false);
      Intent localIntent = getIntent();
      localIntent.putExtra("free_wifi_appid", this.bOL);
      localIntent.putExtra("free_wifi_app_nickname", this.kpv);
      localIntent.putExtra("free_wifi_app_username", this.bNZ);
      localIntent.putExtra("free_wifi_signature", this.signature);
      localIntent.putExtra("free_wifi_finish_actioncode", this.ksJ);
      localIntent.putExtra("free_wifi_finish_url", this.ksK);
      if (bk.bl(this.ksL)) {
        localIntent.setClass(this, FreeWifiSuccUI.class);
      }
      for (;;)
      {
        finish();
        startActivity(localIntent);
        d.wn();
        return;
        localIntent.putExtra("free_wifi_qinghuai_url", this.ksL);
        localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.kro.setVisibility(4);
      this.krE.setText(R.l.connect_state_connecting_ing);
      this.ksE = h.b(this.mController.uMN, getString(R.l.connect_state_connecting_ing), true, new FreeWifiStateUI.9(this));
      return;
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kqO.stopTimer();
      this.kqP.stopTimer();
      this.kro.setVisibility(0);
      this.krE.setText(R.l.free_wifi_re_connect);
      return;
      if (bk.bl(this.krK)) {
        this.krD.setText(getString(R.l.connect_state_connecting_default_tips));
      } else {
        this.krD.setText(this.krK);
      }
    }
  }
  
  public final void rs(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */