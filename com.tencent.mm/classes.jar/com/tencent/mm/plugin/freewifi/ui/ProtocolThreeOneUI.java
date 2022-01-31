package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI
  extends MMActivity
{
  protected int bWu;
  private boolean caV;
  private String coX;
  protected int cpt;
  private int crJ;
  private String crs;
  protected String cvr;
  protected String cwc;
  private final com.tencent.mm.at.a.a.c fHh;
  protected String hAq;
  private Intent intent;
  protected String kdt;
  protected String mLh;
  private String mLq;
  private int mLr;
  private com.tencent.mm.sdk.e.k.a mMC;
  protected String mMw;
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
  private ap mOV;
  private p mOt;
  protected int mOy;
  protected String mOz;
  protected String signature;
  protected String ssid;
  
  public ProtocolThreeOneUI()
  {
    AppMethodBeat.i(21134);
    this.crJ = 1;
    this.mLr = 0;
    this.caV = false;
    this.mOV = new ap(new ProtocolThreeOneUI.1(this), false);
    c.a locala = new c.a();
    locala.eNK = true;
    locala.eNL = true;
    locala.eNY = 2130838889;
    locala.eOk = true;
    locala.eOl = 0.0F;
    this.fHh = locala.ahY();
    AppMethodBeat.o(21134);
  }
  
  private void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(21142);
    com.tencent.mm.plugin.freewifi.k.a locala = k.bAc();
    locala.ssid = this.ssid;
    locala.bssid = m.Ox("MicroMsg.FreeWifi.Protocol31UI");
    locala.coY = m.Oy("MicroMsg.FreeWifi.Protocol31UI");
    locala.coX = this.coX;
    locala.mIC = this.cwc;
    locala.kMp = m.U(this.intent);
    locala.mIE = m.W(this.intent);
    locala.mIF = k.b.mJg.mJq;
    locala.mIG = k.b.mJg.name;
    locala.result = paramInt;
    locala.eev = paramString;
    locala.cCy = m.X(this.intent);
    locala.mIH = this.cvr;
    locala.bAe().bAd();
    AppMethodBeat.o(21142);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(21140);
    l.C(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.gmO.h(localIntent, this);
    finish();
    AppMethodBeat.o(21140);
  }
  
  protected final int bBm()
  {
    AppMethodBeat.i(21141);
    if (bo.isNullOrNil(this.ssid))
    {
      ab.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
      AppMethodBeat.o(21141);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.bAK().OK(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(21141);
      return i;
    }
    AppMethodBeat.o(21141);
    return 0;
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(21137);
    this.crJ = bBm();
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), com.tencent.mm.plugin.freewifi.model.d.wl(this.crJ) });
    if (this.crJ != 2)
    {
      this.mOV.ag(15000L, 15000L);
      ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), Integer.valueOf(60) });
      String str = this.mLq;
      j.bAN().bAw().post(new ProtocolThreeOneUI.6(this, str));
      AppMethodBeat.o(21137);
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(21137);
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
    AppMethodBeat.i(21136);
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
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.ssid, this.mMw, this.kdt, Integer.valueOf(this.cpt), Integer.valueOf(this.bWu), this.cwc, this.hAq, this.mNx, this.mNz });
    setBackBtn(new ProtocolThreeOneUI.2(this));
    findViewById(2131824262).setVisibility(0);
    this.mNq = ((ImageView)findViewById(2131824254));
    this.mNr = ((TextView)findViewById(2131824255));
    this.mNs = ((TextView)findViewById(2131824256));
    this.mNb = ((TextView)findViewById(2131824257));
    this.mNt = ((Button)findViewById(2131824260));
    this.mNt.setOnClickListener(new ProtocolThreeOneUI.3(this));
    this.mNu = ((Button)findViewById(2131824261));
    this.mNu.setOnClickListener(new ProtocolThreeOneUI.4(this));
    if (bo.isNullOrNil(this.ssid))
    {
      this.mNs.setText(getString(2131300179));
      this.mNt.setVisibility(4);
    }
    setMMTitle(getString(2131300181));
    AppMethodBeat.o(21136);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21135);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.coX = getIntent().getStringExtra("free_wifi_ap_key");
    this.crs = getIntent().getStringExtra("free_wifi_schema_ticket");
    this.mLq = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.coX, this.crs });
    initView();
    if (bo.isNullOrNil(this.ssid))
    {
      ab.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
      l.A(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(21135);
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
      paramBundle.field_url = this.kdt;
      paramBundle.field_mid = this.mMw;
      paramBundle.field_wifiType = 3;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.bAK().insert(paramBundle);
      }
      for (;;)
      {
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.mMw, Integer.valueOf(this.cpt) });
        this.mMC = new ProtocolThreeOneUI.5(this);
        j.bAK().add(this.mMC);
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.bAK().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21143);
    super.onDestroy();
    if (this.mMC != null) {
      j.bAK().remove(this.mMC);
    }
    this.mOV.stopTimer();
    j.bAN().release();
    AppMethodBeat.o(21143);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21139);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(21139);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21139);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void wn(int paramInt)
  {
    AppMethodBeat.i(21138);
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(21138);
      return;
    case 4: 
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mOV.stopTimer();
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
        if (!bo.isNullOrNil(this.cwc))
        {
          if (!bo.isNullOrNil(this.mLh)) {
            this.mNr.setText(this.mLh);
          }
          if (!bo.isNullOrNil(this.hAq)) {
            o.ahG().a(this.hAq, this.mNq, this.fHh);
          }
        }
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
        AppMethodBeat.o(21138);
        return;
        if (bo.isNullOrNil(this.mNy)) {
          this.mNs.setText(getString(2131298511));
        } else {
          this.mNs.setText(this.mNy);
        }
      }
    case 1: 
      this.mNb.setVisibility(4);
      this.mNt.setText(2131298512);
      this.mOt = h.b(getContext(), getString(2131298512), true, new ProtocolThreeOneUI.9(this));
      ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      AppMethodBeat.o(21138);
      return;
    case 3: 
      if (this.mOt != null) {
        this.mOt.dismiss();
      }
      this.mOV.stopTimer();
      this.mNb.setVisibility(0);
      this.mNt.setText(2131300177);
      ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      AppMethodBeat.o(21138);
      return;
    }
    if (this.mOt != null) {
      this.mOt.dismiss();
    }
    this.mOV.stopTimer();
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
      ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      break;
      localIntent.putExtra("free_wifi_qinghuai_url", this.mOA);
      localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI
 * JD-Core Version:    0.7.0.1
 */