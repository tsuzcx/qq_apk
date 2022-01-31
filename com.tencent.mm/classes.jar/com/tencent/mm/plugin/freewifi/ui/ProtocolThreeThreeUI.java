package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
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
public class ProtocolThreeThreeUI
  extends MMActivity
{
  protected String appId;
  protected int bWu;
  protected String bssid;
  protected int cpt;
  protected String cqf;
  private int crJ;
  protected String cvr;
  protected String mLh;
  private int mLr;
  protected String mLu;
  protected String mLv;
  protected String mLw;
  private Uri mLx;
  private String mLy;
  private k.a mMC;
  private TextView mNb;
  private ImageView mNq;
  private TextView mNr;
  private TextView mNs;
  private Button mNt;
  private Button mNu;
  protected String mOA;
  private ap mOV;
  private p mOt;
  protected int mOy;
  protected String mOz;
  protected String sign;
  protected String signature;
  protected String ssid;
  
  public ProtocolThreeThreeUI()
  {
    AppMethodBeat.i(21160);
    this.crJ = 1;
    this.mLr = 0;
    this.mOV = new ap(new ProtocolThreeThreeUI.1(this), false);
    AppMethodBeat.o(21160);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(21166);
    l.C(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.gmO.h(localIntent, this);
    finish();
    AppMethodBeat.o(21166);
  }
  
  protected final int bBm()
  {
    AppMethodBeat.i(21167);
    if (bo.isNullOrNil(this.ssid))
    {
      ab.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
      AppMethodBeat.o(21167);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.bAK().OK(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(21167);
      return i;
    }
    AppMethodBeat.o(21167);
    return 0;
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(21163);
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.ssid))
    {
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(21163);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.mLv))
    {
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(21163);
      return;
    }
    this.crJ = bBm();
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())), com.tencent.mm.plugin.freewifi.model.d.wl(this.crJ) });
    if (this.crJ != 2)
    {
      this.mOV.ag(30000L, 30000L);
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())), Integer.valueOf(60) });
      com.tencent.mm.plugin.freewifi.m.isEmpty(this.mLv);
      Object localObject = new StringBuilder(this.mLv);
      if (this.mLv.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?extend=").append(this.mLw);
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        j.bAN().bAw().post(new ProtocolThreeThreeUI.6(this, (String)localObject));
        AppMethodBeat.o(21163);
        return;
        ((StringBuilder)localObject).append("&extend=").append(this.mLw);
      }
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(21163);
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
    AppMethodBeat.i(21162);
    this.ssid = com.tencent.mm.plugin.freewifi.m.Ow("MicroMsg.FreeWifi.Protocol33UI");
    this.bssid = com.tencent.mm.plugin.freewifi.m.Ox("MicroMsg.FreeWifi.Protocol33UI");
    this.cpt = getIntent().getIntExtra("free_wifi_source", 1);
    this.bWu = getIntent().getIntExtra("free_wifi_channel_id", 0);
    setBackBtn(new ProtocolThreeThreeUI.2(this));
    findViewById(2131824262).setVisibility(0);
    this.mNq = ((ImageView)findViewById(2131824254));
    this.mNr = ((TextView)findViewById(2131824255));
    this.mNs = ((TextView)findViewById(2131824256));
    this.mNb = ((TextView)findViewById(2131824257));
    this.mNt = ((Button)findViewById(2131824260));
    this.mNt.setOnClickListener(new ProtocolThreeThreeUI.3(this));
    this.mNu = ((Button)findViewById(2131824261));
    this.mNu.setOnClickListener(new ProtocolThreeThreeUI.4(this));
    if (bo.isNullOrNil(this.ssid))
    {
      this.mNs.setText(getString(2131300179));
      this.mNt.setVisibility(4);
    }
    setMMTitle(getString(2131300181));
    AppMethodBeat.o(21162);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21161);
    super.onCreate(paramBundle);
    this.mLy = getIntent().getStringExtra("free_wifi_schema_uri");
    this.mLx = Uri.parse(this.mLy);
    this.appId = this.mLx.getQueryParameter("appId");
    this.mLu = this.mLx.getQueryParameter("shopId");
    this.mLv = this.mLx.getQueryParameter("authUrl");
    this.mLw = this.mLx.getQueryParameter("extend");
    this.cqf = this.mLx.getQueryParameter("timestamp");
    this.sign = this.mLx.getQueryParameter("sign");
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())), this.mLy });
    initView();
    if (bo.isNullOrNil(this.ssid))
    {
      ab.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
      l.A(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(21161);
      return;
    }
    paramBundle = j.bAK().OK(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = ag.cE(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = "";
      paramBundle.field_mid = "";
      paramBundle.field_wifiType = 33;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.bAK().insert(paramBundle);
      }
      for (;;)
      {
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, "", Integer.valueOf(this.cpt) });
        this.mMC = new k.a()
        {
          private int mOC = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(21151);
            ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.bBm());
            if (this.mOC != ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this))
            {
              this.mOC = ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this);
              ProtocolThreeThreeUI.this.wn(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this));
            }
            AppMethodBeat.o(21151);
          }
        };
        j.bAK().add(this.mMC);
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.bAK().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21168);
    super.onDestroy();
    if (this.mMC != null) {
      j.bAK().remove(this.mMC);
    }
    this.mOV.stopTimer();
    j.bAN().release();
    AppMethodBeat.o(21168);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21165);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(21165);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21165);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void wn(int paramInt)
  {
    AppMethodBeat.i(21164);
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(21164);
      return;
    case 4: 
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mOV.stopTimer();
      this.mNb.setVisibility(4);
      this.mNt.setText(2131298515);
      if (this.cpt == 3) {
        this.mNs.setText(getString(2131301558, new Object[] { this.ssid }));
      }
      for (;;)
      {
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
        AppMethodBeat.o(21164);
        return;
        this.mNs.setText(getString(2131298513, new Object[] { this.ssid }));
      }
    case 1: 
      this.mNb.setVisibility(4);
      this.mNt.setText(2131298512);
      this.mOt = h.b(getContext(), getString(2131298512), true, new ProtocolThreeThreeUI.9(this));
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
      AppMethodBeat.o(21164);
      return;
    case 3: 
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mOV.stopTimer();
      this.mNb.setVisibility(0);
      this.mNt.setText(2131300177);
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
      AppMethodBeat.o(21164);
      return;
    }
    if (this.mOt != null) {
      this.mOt.dismiss();
    }
    this.mOV.stopTimer();
    this.mNt.setText(2131298509);
    this.mNt.setClickable(false);
    Intent localIntent = getIntent();
    localIntent.putExtra("free_wifi_appid", this.appId);
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
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(getIntent())) });
      break;
      localIntent.putExtra("free_wifi_qinghuai_url", this.mOA);
      localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI
 * JD-Core Version:    0.7.0.1
 */