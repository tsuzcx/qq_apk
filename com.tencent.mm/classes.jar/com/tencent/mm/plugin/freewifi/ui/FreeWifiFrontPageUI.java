package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.s;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected String bHI;
  protected String bOL;
  protected int bvj;
  protected String className;
  private ah dPi = new FreeWifiFrontPageUI.1(this);
  private final com.tencent.mm.as.a.a.c eqR;
  protected Intent intent;
  protected String kpt;
  protected int kpu;
  protected String kpv;
  protected ImageView krB;
  protected TextView krC;
  protected TextView krD;
  protected Button krE;
  protected Button krF;
  protected Dialog krG;
  protected View krH;
  protected String krI;
  protected String krJ;
  protected String krK;
  protected String krL;
  protected com.tencent.mm.plugin.freewifi.e.a krM;
  private Lock krN;
  private FreeWifiFrontPageUI.d krO;
  protected TextView kro;
  protected TextView krp;
  protected TextView krq;
  protected int source;
  protected String ssid;
  
  public FreeWifiFrontPageUI()
  {
    c.a locala = new c.a();
    locala.erd = true;
    locala.ere = true;
    locala.eru = R.g.free_wifi_icon_default;
    locala.erD = true;
    locala.erE = 0.0F;
    this.eqR = locala.OV();
  }
  
  private FreeWifiFrontPageUI.d aUW()
  {
    try
    {
      this.krN.lock();
      FreeWifiFrontPageUI.d locald = this.krO;
      return locald;
    }
    finally
    {
      this.krN.unlock();
    }
  }
  
  private void aUX()
  {
    l.u(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    FreeWifiFrontPageUI.d locald = aUW();
    y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.className, locald.name() });
    if ((aUW() == FreeWifiFrontPageUI.d.krT) || (aUW() == FreeWifiFrontPageUI.d.krV))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = com.tencent.mm.plugin.freewifi.m.aTD();
      y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.kpu != 33)) {
        com.tencent.mm.ui.base.h.a(this, R.l.free_wifi_bind_phone_msg, R.l.free_wifi_bind_phone_title, new FreeWifiFrontPageUI.5(this), null);
      }
    }
    else
    {
      return;
    }
    this.krO = FreeWifiFrontPageUI.d.krU;
    aUZ();
    this.krM.connect();
  }
  
  private void goBack()
  {
    l.v(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.aTx();
    ((k.a)localObject).bHI = this.bHI;
    ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(this.intent);
    ((k.a)localObject).kmS = k.b.knq.knD;
    ((k.a)localObject).kmT = k.b.knq.name;
    ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(this.intent);
    ((k.a)localObject).kmR = com.tencent.mm.plugin.freewifi.m.D(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).dmU = "";
    ((k.a)localObject).aTz().b(this.intent, true).aTy();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.eUR.i((Intent)localObject, this);
    finish();
  }
  
  public final void a(FreeWifiFrontPageUI.d paramd, Object paramObject)
  {
    try
    {
      this.krN.lock();
      this.krO = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new FreeWifiFrontPageUI.c(paramd, paramObject);
      this.dPi.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.krN.unlock();
    }
  }
  
  protected final void aUY()
  {
    this.kro.setVisibility(4);
    if (this.kpu == 31)
    {
      this.krE.setVisibility(8);
      if ((com.tencent.mm.plugin.freewifi.m.E(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(q.dyi.dyE)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(q.bc(this.mController.uMN)))) {
        this.krE.setText(String.format(getString(R.l.free_wifi_connect_btn_manu_wording), new Object[] { q.bc(this.mController.uMN) }));
      }
      if (!bk.bl(this.krK)) {
        break label292;
      }
      if (this.kpu != 33) {
        break label275;
      }
      this.krD.setText(getString(R.l.connect_state_connecting_default_tips) + ": " + this.ssid);
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
      y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
      this.krE.setVisibility(0);
      this.krE.setText(R.l.connect_state_wating);
      break;
      label275:
      this.krD.setText(getString(R.l.connect_state_connecting_default_tips));
      continue;
      label292:
      this.krD.setText(this.krK);
    }
  }
  
  protected final void aUZ()
  {
    this.kro.setVisibility(4);
    this.krp.setVisibility(4);
    this.krq.setVisibility(4);
    this.krE.setText(R.l.connect_state_connecting_ing);
    Object localObject = this.mController.uMN;
    FreeWifiFrontPageUI.6 local6 = new FreeWifiFrontPageUI.6(this);
    View localView = View.inflate((Context)localObject, R.i.free_wifi_progress_dialog, null);
    localObject = new com.tencent.mm.ui.base.i((Context)localObject, R.m.FreeWifiProgressDialogStyle);
    ((Dialog)localObject).setCancelable(true);
    ((Dialog)localObject).setContentView(localView);
    ((Dialog)localObject).setOnCancelListener(local6);
    this.krG = ((Dialog)localObject);
    y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
    this.krG.show();
  }
  
  protected final void bk(Object paramObject)
  {
    if (!(paramObject instanceof FreeWifiFrontPageUI.a)) {
      return;
    }
    FreeWifiFrontPageUI.a locala = (FreeWifiFrontPageUI.a)paramObject;
    y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.intent)), FreeWifiFrontPageUI.a.a(locala) });
    if (this.krG != null) {
      this.krG.dismiss();
    }
    this.kro.setVisibility(0);
    if (!com.tencent.mm.plugin.freewifi.m.isEmpty(FreeWifiFrontPageUI.a.b(locala))) {}
    for (paramObject = FreeWifiFrontPageUI.a.b(locala);; paramObject = getString(FreeWifiFrontPageUI.a.c(locala)))
    {
      this.kro.setText(paramObject);
      this.kro.setVisibility(0);
      this.krp.setVisibility(0);
      this.krq.setVisibility(0);
      paramObject = getString(R.l.free_wifi_errorcode_type) + ": " + FreeWifiFrontPageUI.a.a(locala);
      this.krq.setOnClickListener(new FreeWifiFrontPageUI.7(this, paramObject));
      this.krE.setVisibility(0);
      this.krE.setText(R.l.free_wifi_re_connect);
      y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
      if (FreeWifiFrontPageUI.a.c(locala) == 0) {
        FreeWifiFrontPageUI.a.a(locala, R.l.free_wifi_connect_fail_tips);
      }
    }
  }
  
  protected final void bl(Object paramObject)
  {
    if (!(paramObject instanceof FreeWifiFrontPageUI.b)) {
      return;
    }
    Object localObject = ((FreeWifiFrontPageUI.b)paramObject).krS;
    if ((this.kpu != 31) && (this.krG != null)) {
      this.krG.dismiss();
    }
    this.krE.setText(R.l.connect_state_connected);
    this.krE.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((fd)localObject).svu);
    paramObject.putExtra("free_wifi_app_nickname", ((fd)localObject).hRf);
    paramObject.putExtra("free_wifi_app_username", ((fd)localObject).hPY);
    paramObject.putExtra("free_wifi_signature", ((fd)localObject).ffk);
    paramObject.putExtra("free_wifi_finish_actioncode", ((fd)localObject).syP);
    paramObject.putExtra("free_wifi_finish_url", ((fd)localObject).syQ);
    paramObject.putExtra(e.c.uHQ, ((fd)localObject).ksV);
    if (((fd)localObject).syP == 2)
    {
      if (!bk.bl(((fd)localObject).hPY))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((fd)localObject).hPY);
        com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        d.wn();
        y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
        localObject = k.aTx();
        ((k.a)localObject).bHI = this.bHI;
        ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(paramObject);
        ((k.a)localObject).kmS = k.b.kns.knD;
        ((k.a)localObject).kmT = k.b.kns.name;
        ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(paramObject);
        ((k.a)localObject).kmR = com.tencent.mm.plugin.freewifi.m.D(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).dmU = "";
        ((k.a)localObject).aTz().b(paramObject, true).aTy();
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.aTx();
      ((k.a)localObject).bHI = this.bHI;
      ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(paramObject);
      ((k.a)localObject).kmS = k.b.knr.knD;
      ((k.a)localObject).kmT = k.b.knr.name;
      ((k.a)localObject).bUR = com.tencent.mm.plugin.freewifi.m.E(paramObject);
      ((k.a)localObject).kmR = com.tencent.mm.plugin.freewifi.m.D(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).dmU = "";
      ((k.a)localObject).aTz().b(paramObject, true).aTy();
      finish();
      startActivity(paramObject);
      d.wn();
      y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())) });
      return;
      if (com.tencent.mm.plugin.freewifi.m.isEmpty(((fd)localObject).syR))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((fd)localObject).syR);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    k.a locala = k.aTx();
    locala.bHI = this.bHI;
    locala.iGw = com.tencent.mm.plugin.freewifi.m.B(this.intent);
    locala.kmS = k.b.knp.knD;
    locala.kmT = k.b.knp.name;
    locala.bUR = com.tencent.mm.plugin.freewifi.m.E(this.intent);
    locala.kmR = com.tencent.mm.plugin.freewifi.m.D(this.intent);
    locala.result = 0;
    locala.dmU = "";
    locala.aTz().b(this.intent, true).aTy();
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
    setBackBtn(new FreeWifiFrontPageUI.2(this));
    if (this.krG != null) {
      this.krG.dismiss();
    }
    this.krN = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.kpt = getIntent().getStringExtra("free_wifi_url");
    this.bHI = getIntent().getStringExtra("free_wifi_ap_key");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.bvj = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.kpu = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.bOL = getIntent().getStringExtra("free_wifi_appid");
    this.krI = getIntent().getStringExtra("free_wifi_head_img_url");
    this.krJ = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.krK = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.krL = getIntent().getStringExtra("free_wifi_privacy_url");
    this.kpv = getIntent().getStringExtra("free_wifi_app_nickname");
    y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.className, this.ssid, this.kpt, this.bHI, Integer.valueOf(this.source), Integer.valueOf(this.bvj), Integer.valueOf(this.kpu), this.bOL, this.krI, this.krJ, this.krL });
    this.krH = findViewById(R.h.user_protocol_phone_text);
    this.krB = ((ImageView)findViewById(R.h.free_wifi_app_logo_iv));
    this.krC = ((TextView)findViewById(R.h.free_wifi_welcomemsg_tv));
    this.krD = ((TextView)findViewById(R.h.free_wifi_ssidname_tv));
    this.kro = ((TextView)findViewById(R.h.free_wifi_connectfail_tv));
    this.krp = ((TextView)findViewById(R.h.free_wifi_connectfail_mark_tv));
    this.krq = ((TextView)findViewById(R.h.free_wifi_connectfail_open_detail_tv));
    this.krE = ((Button)findViewById(R.h.connect_wifi_btn));
    this.krE.setOnClickListener(new FreeWifiFrontPageUI.3(this));
    this.krF = ((Button)findViewById(R.h.user_protocol_privacy_btn));
    this.krF.setOnClickListener(new FreeWifiFrontPageUI.4(this));
    if (bk.bl(this.ssid))
    {
      this.krD.setText(getString(R.l.free_wifi_ssid_empty_tips));
      this.krE.setVisibility(4);
    }
    setMMTitle(getString(R.l.free_wifi_title));
    a(FreeWifiFrontPageUI.d.krT, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    switch (this.kpu)
    {
    }
    for (;;)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(getIntent())), this.className, this.bHI });
      l.t(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      return;
      this.krM = new f(this);
      continue;
      this.krM = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.krM = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.krH.setVisibility(0);
      aUX();
      continue;
      this.krM = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.krH.setVisibility(0);
      continue;
      this.krM = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.freewifi.model.j.aUl().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */