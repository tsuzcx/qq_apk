package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g;
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
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeThreeUI
  extends MMActivity
{
  protected String appId;
  protected String bIK;
  private int bKp = 1;
  protected String bNZ;
  protected String bssid;
  protected int bvj;
  private int kpF = 0;
  protected String kpI;
  protected String kpJ;
  protected String kpK;
  private Uri kpL;
  private String kpM;
  protected String kpv;
  private j.a kqQ;
  private ImageView krB;
  private TextView krC;
  private TextView krD;
  private Button krE;
  private Button krF;
  private TextView kro;
  private p ksE;
  protected int ksJ;
  protected String ksK;
  protected String ksL;
  private am kth = new am(new ProtocolThreeThreeUI.1(this), false);
  protected String sign;
  protected String signature;
  protected int source;
  protected String ssid;
  
  private void goBack()
  {
    com.tencent.mm.plugin.freewifi.l.v(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.eUR.i(localIntent, this);
    finish();
  }
  
  protected final int aUO()
  {
    if (bk.bl(this.ssid)) {
      y.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
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
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.ssid))
    {
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(this.kpJ))
    {
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      return;
    }
    this.bKp = aUO();
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), com.tencent.mm.plugin.freewifi.model.d.rr(this.bKp) });
    if (this.bKp != 2)
    {
      this.kth.S(30000L, 30000L);
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), Integer.valueOf(60) });
      com.tencent.mm.plugin.freewifi.m.isEmpty(this.kpJ);
      Object localObject = new StringBuilder(this.kpJ);
      if (this.kpJ.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?extend=").append(this.kpK);
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        j.aUl().aTT().post(new Runnable()
        {
          public final void run()
          {
            y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(ProtocolThreeThreeUI.this.getIntent())), this.val$url });
            a.aTG();
            a.a(this.val$url, new a.a()
            {
              public final void f(HttpURLConnection paramAnonymous2HttpURLConnection)
              {
                int i = paramAnonymous2HttpURLConnection.getResponseCode();
                y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i) });
                if (i == 200)
                {
                  ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.this);
                  return;
                }
                if (i == 302)
                {
                  paramAnonymous2HttpURLConnection = paramAnonymous2HttpURLConnection.getHeaderField("Location");
                  ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, paramAnonymous2HttpURLConnection);
                  return;
                }
                y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(ProtocolThreeThreeUI.this.getIntent())) });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
              }
              
              public final void i(Exception paramAnonymous2Exception)
              {
                y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(ProtocolThreeThreeUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
              }
            });
          }
        });
        return;
        ((StringBuilder)localObject).append("&extend=").append(this.kpK);
      }
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
    this.ssid = com.tencent.mm.plugin.freewifi.m.Do("MicroMsg.FreeWifi.Protocol33UI");
    this.bssid = com.tencent.mm.plugin.freewifi.m.Dp("MicroMsg.FreeWifi.Protocol33UI");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.bvj = getIntent().getIntExtra("free_wifi_channel_id", 0);
    setBackBtn(new ProtocolThreeThreeUI.2(this));
    findViewById(R.h.user_protocol_phone_text).setVisibility(0);
    this.krB = ((ImageView)findViewById(R.h.free_wifi_app_logo_iv));
    this.krC = ((TextView)findViewById(R.h.free_wifi_welcomemsg_tv));
    this.krD = ((TextView)findViewById(R.h.free_wifi_ssidname_tv));
    this.kro = ((TextView)findViewById(R.h.free_wifi_connectfail_tv));
    this.krE = ((Button)findViewById(R.h.connect_wifi_btn));
    this.krE.setOnClickListener(new ProtocolThreeThreeUI.3(this));
    this.krF = ((Button)findViewById(R.h.user_protocol_privacy_btn));
    this.krF.setOnClickListener(new ProtocolThreeThreeUI.4(this));
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
    this.kpM = getIntent().getStringExtra("free_wifi_schema_uri");
    this.kpL = Uri.parse(this.kpM);
    this.appId = this.kpL.getQueryParameter("appId");
    this.kpI = this.kpL.getQueryParameter("shopId");
    this.kpJ = this.kpL.getQueryParameter("authUrl");
    this.kpK = this.kpL.getQueryParameter("extend");
    this.bIK = this.kpL.getQueryParameter("timestamp");
    this.sign = this.kpL.getQueryParameter("sign");
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.kpM });
    initView();
    if (bk.bl(this.ssid))
    {
      y.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.t(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
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
      paramBundle.field_url = "";
      paramBundle.field_mid = "";
      paramBundle.field_wifiType = 33;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.aUi().b(paramBundle);
      }
      for (;;)
      {
        y.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, "", Integer.valueOf(this.source) });
        this.kqQ = new j.a()
        {
          private int ksN = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.l paramAnonymousl)
          {
            ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.aUO());
            if (this.ksN != ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this))
            {
              this.ksN = ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this);
              ProtocolThreeThreeUI.this.rt(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this));
            }
          }
        };
        j.aUi().c(this.kqQ);
        y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
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
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), Integer.valueOf(paramInt) });
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
        y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
        return;
        this.krD.setText(getString(R.l.connect_state_connecting_tips, new Object[] { this.ssid }));
      }
    case 1: 
      this.kro.setVisibility(4);
      this.krE.setText(R.l.connect_state_connecting_ing);
      this.ksE = h.b(this.mController.uMN, getString(R.l.connect_state_connecting_ing), true, new ProtocolThreeThreeUI.9(this));
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
    case 3: 
      if (this.ksE != null) {
        this.ksE.dismiss();
      }
      this.kth.stopTimer();
      this.kro.setVisibility(0);
      this.krE.setText(R.l.free_wifi_re_connect);
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
    }
    if (this.ksE != null) {
      this.ksE.dismiss();
    }
    this.kth.stopTimer();
    this.krE.setText(R.l.connect_state_connected);
    this.krE.setClickable(false);
    Intent localIntent = getIntent();
    localIntent.putExtra("free_wifi_appid", this.appId);
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
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
      localIntent.putExtra("free_wifi_qinghuai_url", this.ksL);
      localIntent.setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI
 * JD-Core Version:    0.7.0.1
 */