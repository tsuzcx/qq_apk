package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
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
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

@Deprecated
public class ProtocolThreeTwoUI
  extends MMActivity
{
  private String bHI;
  private String bIK;
  private int bKp = 1;
  protected String bNZ;
  protected String bOL;
  protected int bvj;
  private final com.tencent.mm.as.a.a.c eqR;
  private Intent intent;
  private int kpF = 0;
  private String kpQ;
  protected String kpt;
  protected String kpv;
  private com.tencent.mm.plugin.freewifi.a kpz;
  protected String kqK;
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
  private p ksE;
  protected int ksJ;
  protected String ksK;
  protected String ksL;
  private am kth = new am(new am.a()
  {
    public final boolean tC()
    {
      if (!bk.bl(ProtocolThreeTwoUI.this.ssid))
      {
        ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.aUO());
        if (ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this) != 2)
        {
          y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.rr(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this)) });
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
          ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
        }
      }
      return false;
    }
  }, false);
  private String openId;
  private String sign;
  protected String signature;
  protected int source;
  protected String ssid;
  
  public ProtocolThreeTwoUI()
  {
    c.a locala = new c.a();
    locala.erd = true;
    locala.ere = true;
    locala.eru = R.g.free_wifi_icon_default;
    locala.erD = true;
    locala.erE = 0.0F;
    this.eqR = locala.OV();
  }
  
  private void an(int paramInt, String paramString)
  {
    k.a locala = k.aTx();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.Protocol32UI");
    locala.bHJ = com.tencent.mm.plugin.freewifi.m.Dq("MicroMsg.FreeWifi.Protocol32UI");
    locala.bHI = this.bHI;
    locala.kmQ = this.bOL;
    locala.iGw = com.tencent.mm.plugin.freewifi.m.B(this.intent);
    locala.kmR = com.tencent.mm.plugin.freewifi.m.D(this.intent);
    locala.kmS = k.b.knu.knD;
    locala.kmT = k.b.knu.name;
    locala.result = paramInt;
    locala.dmU = paramString;
    locala.bUR = com.tencent.mm.plugin.freewifi.m.E(this.intent);
    locala.kmU = this.bNZ;
    locala.aTz().aTy();
  }
  
  private void goBack()
  {
    l.v(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.eUR.i(localIntent, this);
    finish();
  }
  
  protected final int aUO()
  {
    if (bk.bl(this.ssid)) {
      y.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
    }
    com.tencent.mm.plugin.freewifi.g.c localc;
    do
    {
      return 0;
      localc = j.aUi().DC(this.ssid);
    } while ((localc == null) || (!localc.field_ssid.equalsIgnoreCase(this.ssid)));
    return localc.field_connectState;
  }
  
  protected final void connect()
  {
    this.bKp = aUO();
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), com.tencent.mm.plugin.freewifi.model.d.rr(this.bKp) });
    if (this.bKp != 2)
    {
      this.kth.S(45000L, 45000L);
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), Integer.valueOf(60) });
      this.kpz = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
      j.aUl().aTT().post(new Runnable()
      {
        public final void run()
        {
          ProtocolThreeTwoUI.c(ProtocolThreeTwoUI.this);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_front_page;
  }
  
  public final void initView()
  {
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
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.ssid, this.kqK, this.kpt, Integer.valueOf(this.source), Integer.valueOf(this.bvj), this.bOL, this.krI, this.krJ, this.krL });
    setBackBtn(new ProtocolThreeTwoUI.4(this));
    findViewById(R.h.user_protocol_phone_text).setVisibility(0);
    this.krB = ((ImageView)findViewById(R.h.free_wifi_app_logo_iv));
    this.krC = ((TextView)findViewById(R.h.free_wifi_welcomemsg_tv));
    this.krD = ((TextView)findViewById(R.h.free_wifi_ssidname_tv));
    this.kro = ((TextView)findViewById(R.h.free_wifi_connectfail_tv));
    this.krE = ((Button)findViewById(R.h.connect_wifi_btn));
    this.krE.setOnClickListener(new ProtocolThreeTwoUI.5(this));
    this.krF = ((Button)findViewById(R.h.user_protocol_privacy_btn));
    this.krF.setOnClickListener(new ProtocolThreeTwoUI.6(this));
    if (bk.bl(this.ssid))
    {
      this.krD.setText(getString(R.l.free_wifi_ssid_empty_tips));
      this.krE.setVisibility(4);
    }
    setMMTitle(getString(R.l.free_wifi_title));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.bHI = getIntent().getStringExtra("free_wifi_ap_key");
    this.openId = getIntent().getStringExtra("free_wifi_openid");
    this.kpQ = getIntent().getStringExtra("free_wifi_tid");
    this.bIK = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.bHI });
    initView();
    if (bk.bl(this.ssid))
    {
      y.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
      l.t(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      return;
    }
    paramBundle = j.aUi().DC(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = ad.bB(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.kpt;
      paramBundle.field_mid = this.kqK;
      paramBundle.field_wifiType = 32;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.aUi().b(paramBundle);
      }
      for (;;)
      {
        y.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.kqK, Integer.valueOf(this.source) });
        this.kqQ = new ProtocolThreeTwoUI.7(this);
        j.aUi().c(this.kqQ);
        y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.aUi().c(paramBundle, new String[0]);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.kqQ != null) {
      j.aUi().d(this.kqQ);
    }
    this.kth.stopTimer();
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
  
  protected final void rt(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kth.stopTimer();
      this.kro.setVisibility(4);
      this.krE.setText(R.l.connect_state_wating);
      if (this.source == 3) {
        this.krD.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[] { this.ssid }));
      }
      for (;;)
      {
        if (!bk.bl(this.bOL))
        {
          if (!bk.bl(this.kpv)) {
            this.krC.setText(this.kpv);
          }
          if (!bk.bl(this.krI)) {
            o.ON().a(this.krI, this.krB, this.eqR);
          }
        }
        y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
        return;
        if (bk.bl(this.krK)) {
          this.krD.setText(getString(R.l.connect_state_connecting_default_tips));
        } else {
          this.krD.setText(this.krK);
        }
      }
    case 1: 
      this.kro.setVisibility(4);
      this.krE.setText(R.l.connect_state_connecting_ing);
      this.ksE = h.b(this.mController.uMN, getString(R.l.connect_state_connecting_ing), true, new ProtocolThreeTwoUI.3(this));
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
    case 3: 
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kth.stopTimer();
      this.kro.setVisibility(0);
      this.krE.setText(R.l.free_wifi_re_connect);
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
    }
    if (this.ksE != null) {
      this.ksE.dismiss();
    }
    this.kth.stopTimer();
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
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
      localIntent.putExtra("free_wifi_qinghuai_url", this.ksL);
      localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI
 * JD-Core Version:    0.7.0.1
 */