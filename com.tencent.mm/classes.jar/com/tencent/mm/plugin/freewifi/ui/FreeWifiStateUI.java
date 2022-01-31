package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int bWu;
  protected String coX;
  protected int cpt;
  private int crJ = 1;
  protected String cvr;
  protected String cwc;
  private final com.tencent.mm.at.a.a.c fHh;
  protected String hAq;
  protected String kdt;
  protected String mLh;
  private ap mMA = new ap(new FreeWifiStateUI.1(this), false);
  private ap mMB = new ap(new FreeWifiStateUI.2(this), true);
  private k.a mMC;
  protected String mMw;
  protected FreeWifiNetworkReceiver mMx;
  protected boolean mMy = false;
  private TextView mNb;
  private ImageView mNq;
  private TextView mNr;
  private TextView mNs;
  private Button mNt;
  private Button mNu;
  protected String mNx;
  protected String mNy;
  protected String mNz;
  protected String mOA;
  private p mOt = null;
  protected int mOy;
  protected String mOz;
  protected String signature;
  protected String ssid;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.eNK = true;
    locala.eNL = true;
    locala.eNY = 2130838889;
    locala.eOk = true;
    locala.eOl = 0.0F;
    this.fHh = locala.ahY();
    this.mMC = new FreeWifiStateUI.3(this);
  }
  
  private void bBr()
  {
    this.mMx = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.mMx, localIntentFilter);
  }
  
  private void goBack()
  {
    l.C(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.gmO.h(localIntent, this);
    finish();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void arq();
  
  protected abstract void bBl();
  
  protected abstract int bBm();
  
  protected final void bBo()
  {
    if (this.mMx != null)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
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
      ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.mMx.mKy = null;
    }
  }
  
  protected final void bBs()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.mMA.ag(60000L, 60000L);
      this.mMB.ag(1000L, 1000L);
      ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.bAN().bAw().post(new FreeWifiStateUI.7(this));
      return;
    }
    this.crJ = bBm();
    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.crJ) });
    if (this.crJ != 2)
    {
      if (m.W(getIntent()) == 4) {
        this.mMA.ag(30000L, 30000L);
      }
      for (;;)
      {
        this.mMB.ag(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.OC(this.ssid)) {
          break label233;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.mMy) });
        if (!this.mMy) {
          break;
        }
        ab.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.mMA.ag(60000L, 60000L);
      }
      this.mMA.ag(60000L, 60000L);
      this.mMB.ag(1000L, 1000L);
      arq();
      this.mMy = true;
      return;
      label233:
      j.bAN().bAw().post(new FreeWifiStateUI.8(this));
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.crJ, getIntent());
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969628;
  }
  
  public void initView()
  {
    setBackBtn(new FreeWifiStateUI.4(this));
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(2131824262).setVisibility(0);
    }
    this.mNq = ((ImageView)findViewById(2131824254));
    this.mNr = ((TextView)findViewById(2131824255));
    this.mNs = ((TextView)findViewById(2131824256));
    this.mNb = ((TextView)findViewById(2131824257));
    this.mNt = ((Button)findViewById(2131824260));
    this.mNt.setOnClickListener(new FreeWifiStateUI.5(this));
    this.mNu = ((Button)findViewById(2131824261));
    this.mNu.setOnClickListener(new FreeWifiStateUI.6(this));
    if (bo.isNullOrNil(this.ssid))
    {
      this.mNs.setText(getString(2131300179));
      this.mNt.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.coX = getIntent().getStringExtra("free_wifi_ap_key");
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.mMw = getIntent().getStringExtra("free_wifi_mid");
    this.kdt = getIntent().getStringExtra("free_wifi_url");
    this.cpt = getIntent().getIntExtra("free_wifi_source", 1);
    this.bWu = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.cwc = getIntent().getStringExtra("free_wifi_appid");
    this.hAq = getIntent().getStringExtra("free_wifi_head_img_url");
    this.mNx = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.mNy = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.mNz = getIntent().getStringExtra("free_wifi_privacy_url");
    this.mLh = getIntent().getStringExtra("free_wifi_app_nickname");
    switch (this.cpt)
    {
    default: 
      if (bo.isNullOrNil(this.ssid)) {
        ab.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
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
        j.bAK().add(this.mMC);
        l.A(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.bAK().bBk();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.mMw = paramBundle.field_mid;
          this.kdt = paramBundle.field_url;
          ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.mMw, this.kdt });
          break;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bo.isNullOrNil(this.ssid)) {
          break label377;
        }
        ab.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.bAK().OK(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ag.cE(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.kdt;
      paramBundle.field_mid = this.mMw;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.bAK().insert(paramBundle);
        break;
      }
      j.bAK().update(paramBundle, new String[0]);
      break;
      ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.mMw, Integer.valueOf(this.cpt) });
      break label234;
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void vc(int paramInt)
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mNb.setVisibility(4);
      this.mNt.setText(2131298515);
      if (this.cpt == 3) {
        this.mNs.setText(getString(2131301558, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.cwc))
      {
        if (!bo.isNullOrNil(this.mNx)) {
          this.mNr.setText(this.mNx);
        }
        if (!bo.isNullOrNil(this.hAq)) {
          o.ahG().a(this.hAq, this.mNq, this.fHh);
        }
      }
      label456:
      for (;;)
      {
        return;
        if (this.mOt != null) {
          this.mOt.dismiss();
        }
        this.mMA.stopTimer();
        this.mMB.stopTimer();
        this.mMy = false;
        this.mNb.setVisibility(4);
        this.mNt.setText(2131298515);
        if ((m.X(getIntent()) == 10) && (!m.isEmpty(ac.erz.ere)) && (!m.isEmpty(ac.bH(getContext())))) {
          this.mNt.setText(String.format(getString(2131300138), new Object[] { ac.bH(getContext()) }));
        }
        if (this.cpt == 3) {
          this.mNs.setText(getString(2131301558, new Object[] { this.ssid }));
        }
        for (;;)
        {
          if (bo.isNullOrNil(this.cwc)) {
            break label456;
          }
          if (!bo.isNullOrNil(this.mNx)) {
            this.mNr.setText(this.mNx);
          }
          if (bo.isNullOrNil(this.hAq)) {
            break;
          }
          o.ahG().a(this.hAq, this.mNq, this.fHh);
          return;
          if (bo.isNullOrNil(this.mNy)) {
            this.mNs.setText(getString(2131298511));
          } else {
            this.mNs.setText(this.mNy);
          }
        }
      }
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      this.mNb.setVisibility(0);
      this.mNt.setText(2131300177);
      return;
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      this.mNt.setText(2131298509);
      this.mNt.setClickable(false);
      Intent localIntent = getIntent();
      localIntent.putExtra("free_wifi_appid", this.cwc);
      localIntent.putExtra("free_wifi_app_nickname", this.mLh);
      localIntent.putExtra("free_wifi_app_username", this.cvr);
      localIntent.putExtra("free_wifi_signature", this.signature);
      localIntent.putExtra("free_wifi_finish_actioncode", this.mOy);
      localIntent.putExtra("free_wifi_finish_url", this.mOz);
      if (bo.isNullOrNil(this.mOA)) {
        localIntent.setClass(this, FreeWifiSuccUI.class);
      }
      for (;;)
      {
        finish();
        startActivity(localIntent);
        d.IE();
        return;
        localIntent.putExtra("free_wifi_qinghuai_url", this.mOA);
        localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.mNb.setVisibility(4);
      this.mNt.setText(2131298512);
      this.mOt = h.b(getContext(), getString(2131298512), true, new FreeWifiStateUI.9(this));
      return;
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mMA.stopTimer();
      this.mMB.stopTimer();
      this.mNb.setVisibility(0);
      this.mNt.setText(2131300177);
      return;
      if (bo.isNullOrNil(this.mNy)) {
        this.mNs.setText(getString(2131298511));
      } else {
        this.mNs.setText(this.mNy);
      }
    }
  }
  
  public final void wm(int paramInt)
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */