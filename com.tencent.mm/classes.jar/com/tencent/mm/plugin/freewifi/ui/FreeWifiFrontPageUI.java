package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected int bWu;
  protected String className;
  protected String coX;
  protected int cpt;
  protected String cwc;
  private final com.tencent.mm.at.a.a.c fHh;
  private ak faV;
  protected String hAq;
  protected Intent intent;
  protected String kdt;
  protected int mLg;
  protected String mLh;
  private boolean mMF;
  protected com.tencent.mm.plugin.freewifi.e.a mNA;
  private Lock mNB;
  private FreeWifiFrontPageUI.d mNC;
  protected TextView mNb;
  protected TextView mNc;
  protected TextView mNd;
  protected ImageView mNq;
  protected TextView mNr;
  protected TextView mNs;
  protected Button mNt;
  protected Button mNu;
  protected Dialog mNv;
  protected View mNw;
  protected String mNx;
  protected String mNy;
  protected String mNz;
  protected String ssid;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(20974);
    this.mMF = true;
    this.faV = new FreeWifiFrontPageUI.1(this);
    c.a locala = new c.a();
    locala.eNK = true;
    locala.eNL = true;
    locala.eNY = 2130838889;
    locala.eOk = true;
    locala.eOl = 0.0F;
    this.fHh = locala.ahY();
    AppMethodBeat.o(20974);
  }
  
  private static Dialog b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(20983);
    View localView = View.inflate(paramContext, 2130969634, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, 2131493268);
    paramContext.setCancelable(true);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    AppMethodBeat.o(20983);
    return paramContext;
  }
  
  private FreeWifiFrontPageUI.d bBv()
  {
    AppMethodBeat.i(20975);
    try
    {
      this.mNB.lock();
      FreeWifiFrontPageUI.d locald = this.mNC;
      return locald;
    }
    finally
    {
      this.mNB.unlock();
      AppMethodBeat.o(20975);
    }
  }
  
  private void bBw()
  {
    AppMethodBeat.i(20980);
    l.B(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    FreeWifiFrontPageUI.d locald = bBv();
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.className, locald.name() });
    if ((bBv() == FreeWifiFrontPageUI.d.mNH) || (bBv() == FreeWifiFrontPageUI.d.mNJ))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = m.bAh();
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.mLg != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131300136, 2131300137, new FreeWifiFrontPageUI.8(this), null);
        AppMethodBeat.o(20980);
        return;
      }
      this.mNC = FreeWifiFrontPageUI.d.mNI;
      bBy();
      this.mNA.connect();
    }
    AppMethodBeat.o(20980);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(20988);
    l.C(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.bAc();
    ((k.a)localObject).coX = this.coX;
    ((k.a)localObject).kMp = m.U(this.intent);
    ((k.a)localObject).mIF = k.b.mJd.mJq;
    ((k.a)localObject).mIG = k.b.mJd.name;
    ((k.a)localObject).cCy = m.X(this.intent);
    ((k.a)localObject).mIE = m.W(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).eev = "";
    ((k.a)localObject).bAe().c(this.intent, true).bAd();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.gmO.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(20988);
  }
  
  public final void a(FreeWifiFrontPageUI.d paramd, Object paramObject)
  {
    AppMethodBeat.i(20976);
    try
    {
      this.mNB.lock();
      this.mNC = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new FreeWifiFrontPageUI.c(paramd, paramObject);
      this.faV.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.mNB.unlock();
      AppMethodBeat.o(20976);
    }
  }
  
  protected final void bBx()
  {
    AppMethodBeat.i(20981);
    this.mNb.setVisibility(4);
    if (this.mLg == 31)
    {
      this.mNt.setVisibility(8);
      if ((m.X(getIntent()) == 10) && (!m.isEmpty(ac.erz.ere)) && (!m.isEmpty(ac.bH(getContext())))) {
        this.mNt.setText(String.format(getString(2131300138), new Object[] { ac.bH(getContext()) }));
      }
      if (!bo.isNullOrNil(this.mNy)) {
        break label298;
      }
      if (this.mLg != 33) {
        break label281;
      }
      this.mNs.setText(getString(2131298511) + ": " + this.ssid);
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
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      AppMethodBeat.o(20981);
      return;
      this.mNt.setVisibility(0);
      this.mNt.setText(2131298515);
      break;
      label281:
      this.mNs.setText(getString(2131298511));
      continue;
      label298:
      this.mNs.setText(this.mNy);
    }
  }
  
  protected final void bBy()
  {
    AppMethodBeat.i(20982);
    this.mNb.setVisibility(4);
    this.mNc.setVisibility(4);
    this.mNd.setVisibility(4);
    this.mNt.setText(2131298512);
    this.mNv = b(getContext(), new FreeWifiFrontPageUI.9(this));
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
    this.mNv.show();
    AppMethodBeat.o(20982);
  }
  
  protected final void bL(Object paramObject)
  {
    AppMethodBeat.i(20984);
    if (!(paramObject instanceof FreeWifiFrontPageUI.a))
    {
      AppMethodBeat.o(20984);
      return;
    }
    FreeWifiFrontPageUI.a locala = (FreeWifiFrontPageUI.a)paramObject;
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), FreeWifiFrontPageUI.a.a(locala) });
    if (this.mNv != null) {
      this.mNv.dismiss();
    }
    this.mNb.setVisibility(0);
    if (!m.isEmpty(FreeWifiFrontPageUI.a.b(locala))) {}
    for (paramObject = FreeWifiFrontPageUI.a.b(locala);; paramObject = getString(FreeWifiFrontPageUI.a.c(locala)))
    {
      this.mNb.setText(paramObject);
      this.mNb.setVisibility(0);
      this.mNc.setVisibility(0);
      this.mNd.setVisibility(0);
      paramObject = getString(2131300157) + ": " + FreeWifiFrontPageUI.a.a(locala);
      this.mNd.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.mNt.setVisibility(0);
      this.mNt.setText(2131300177);
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      AppMethodBeat.o(20984);
      return;
      if (FreeWifiFrontPageUI.a.c(locala) == 0) {
        FreeWifiFrontPageUI.a.d(locala);
      }
    }
  }
  
  protected final void bM(Object paramObject)
  {
    AppMethodBeat.i(20985);
    if (!(paramObject instanceof FreeWifiFrontPageUI.b))
    {
      AppMethodBeat.o(20985);
      return;
    }
    Object localObject = ((FreeWifiFrontPageUI.b)paramObject).mNG;
    if ((this.mLg != 31) && (this.mNv != null)) {
      this.mNv.dismiss();
    }
    this.mNt.setText(2131298509);
    this.mNt.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((gm)localObject).woB);
    paramObject.putExtra("free_wifi_app_nickname", ((gm)localObject).jKG);
    paramObject.putExtra("free_wifi_app_username", ((gm)localObject).jJA);
    paramObject.putExtra("free_wifi_signature", ((gm)localObject).gwS);
    paramObject.putExtra("free_wifi_finish_actioncode", ((gm)localObject).wsQ);
    paramObject.putExtra("free_wifi_finish_url", ((gm)localObject).wsR);
    paramObject.putExtra(e.d.yVb, ((gm)localObject).mOJ);
    if (((gm)localObject).wsQ == 2)
    {
      if (!bo.isNullOrNil(((gm)localObject).jJA))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((gm)localObject).jJA);
        com.tencent.mm.bq.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        d.IE();
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
        localObject = k.bAc();
        ((k.a)localObject).coX = this.coX;
        ((k.a)localObject).kMp = m.U(paramObject);
        ((k.a)localObject).mIF = k.b.mJf.mJq;
        ((k.a)localObject).mIG = k.b.mJf.name;
        ((k.a)localObject).cCy = m.X(paramObject);
        ((k.a)localObject).mIE = m.W(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).eev = "";
        ((k.a)localObject).bAe().c(paramObject, true).bAd();
        AppMethodBeat.o(20985);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.bAc();
      ((k.a)localObject).coX = this.coX;
      ((k.a)localObject).kMp = m.U(paramObject);
      ((k.a)localObject).mIF = k.b.mJe.mJq;
      ((k.a)localObject).mIG = k.b.mJe.name;
      ((k.a)localObject).cCy = m.X(paramObject);
      ((k.a)localObject).mIE = m.W(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).eev = "";
      ((k.a)localObject).bAe().c(paramObject, true).bAd();
      finish();
      startActivity(paramObject);
      d.IE();
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())) });
      AppMethodBeat.o(20985);
      return;
      if (m.isEmpty(((gm)localObject).wsS))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((gm)localObject).wsS);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(20986);
    super.finish();
    k.a locala = k.bAc();
    locala.coX = this.coX;
    locala.kMp = m.U(this.intent);
    locala.mIF = k.b.mJc.mJq;
    locala.mIG = k.b.mJc.name;
    locala.cCy = m.X(this.intent);
    locala.mIE = m.W(this.intent);
    locala.result = 0;
    locala.eev = "";
    locala.bAe().c(this.intent, true).bAd();
    AppMethodBeat.o(20986);
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
    AppMethodBeat.i(20978);
    setBackBtn(new FreeWifiFrontPageUI.4(this));
    if (this.mNv != null) {
      this.mNv.dismiss();
    }
    this.mNB = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.kdt = getIntent().getStringExtra("free_wifi_url");
    this.coX = getIntent().getStringExtra("free_wifi_ap_key");
    this.cpt = getIntent().getIntExtra("free_wifi_source", 1);
    this.bWu = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.mLg = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.cwc = getIntent().getStringExtra("free_wifi_appid");
    this.hAq = getIntent().getStringExtra("free_wifi_head_img_url");
    this.mNx = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.mNy = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.mNz = getIntent().getStringExtra("free_wifi_privacy_url");
    this.mLh = getIntent().getStringExtra("free_wifi_app_nickname");
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.className, this.ssid, this.kdt, this.coX, Integer.valueOf(this.cpt), Integer.valueOf(this.bWu), Integer.valueOf(this.mLg), this.cwc, this.hAq, this.mNx, this.mNz });
    this.mNw = findViewById(2131824262);
    this.mNq = ((ImageView)findViewById(2131824254));
    this.mNr = ((TextView)findViewById(2131824255));
    this.mNs = ((TextView)findViewById(2131824256));
    this.mNb = ((TextView)findViewById(2131824257));
    this.mNc = ((TextView)findViewById(2131824258));
    this.mNd = ((TextView)findViewById(2131824259));
    this.mNt = ((Button)findViewById(2131824260));
    this.mNt.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.mNu = ((Button)findViewById(2131824261));
    this.mNu.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (bo.isNullOrNil(this.ssid))
    {
      this.mNs.setText(getString(2131300179));
      this.mNt.setVisibility(4);
    }
    setMMTitle(getString(2131300181));
    a(FreeWifiFrontPageUI.d.mNH, null);
    AppMethodBeat.o(20978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20977);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(20977);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20989);
    super.onDestroy();
    com.tencent.mm.plugin.freewifi.model.j.bAN().release();
    AppMethodBeat.o(20989);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20987);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(20987);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(20987);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(20990);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(20990);
      return;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20990);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.mMF = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20979);
    super.onResume();
    int i;
    if (this.mMF)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
      AppMethodBeat.o(20979);
      return;
      if (!b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.agR())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131300538), getString(2131297087), getString(2131300996), getString(2131296888), false, new FreeWifiFrontPageUI.7(this), null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.mLg)
    {
    }
    for (;;)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), this.className, this.coX });
      l.A(com.tencent.mm.plugin.freewifi.model.d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(20979);
      return;
      this.mNA = new f(this);
      continue;
      this.mNA = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.mNA = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.mNw.setVisibility(0);
      bBw();
      continue;
      this.mNA = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.mNw.setVisibility(0);
      continue;
      this.mNA = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */