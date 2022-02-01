package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected int cJR;
  protected String className;
  protected String ddU;
  protected int dep;
  protected String dlB;
  private ap gAC;
  protected String gLg;
  private final com.tencent.mm.aw.a.a.c hjG;
  protected Intent intent;
  protected String nha;
  private boolean pcG;
  protected int rik;
  protected String ril;
  protected TextView rjT;
  protected TextView rjU;
  protected TextView rjV;
  protected ImageView rki;
  protected TextView rkj;
  protected TextView rkk;
  protected Button rkl;
  protected Button rkm;
  protected Dialog rkn;
  protected View rko;
  protected String rkp;
  protected String rkq;
  protected String rkr;
  protected com.tencent.mm.plugin.freewifi.e.a rks;
  private Lock rkt;
  private d rku;
  protected String ssid;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(25033);
    this.pcG = true;
    this.gAC = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25018);
        paramAnonymousMessage = (FreeWifiFrontPageUI.c)paramAnonymousMessage.obj;
        switch (FreeWifiFrontPageUI.3.rkw[paramAnonymousMessage.rku.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cwK();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cwL();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.db(paramAnonymousMessage.data);
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dc(paramAnonymousMessage.data);
        }
      }
    };
    c.a locala = new c.a();
    locala.hjS = true;
    locala.hjT = true;
    locala.hkf = 2131232428;
    locala.gkG = true;
    locala.hkm = 0.0F;
    this.hjG = locala.azc();
    AppMethodBeat.o(25033);
  }
  
  private static Dialog b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(25042);
    View localView = View.inflate(paramContext, 2131494176, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, 2131820944);
    paramContext.setCancelable(true);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    AppMethodBeat.o(25042);
    return paramContext;
  }
  
  private d cwI()
  {
    AppMethodBeat.i(25034);
    try
    {
      this.rkt.lock();
      d locald = this.rku;
      return locald;
    }
    finally
    {
      this.rkt.unlock();
      AppMethodBeat.o(25034);
    }
  }
  
  private void cwJ()
  {
    AppMethodBeat.i(25039);
    com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    d locald = cwI();
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())), this.className, locald.name() });
    if ((cwI() == d.rkz) || (cwI() == d.rkB))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = m.cvv();
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.rik != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131759608, 2131759609, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25025);
            m.eT(FreeWifiFrontPageUI.this);
            AppMethodBeat.o(25025);
          }
        }, null);
        AppMethodBeat.o(25039);
        return;
      }
      this.rku = d.rkA;
      cwL();
      this.rks.connect();
    }
    AppMethodBeat.o(25039);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25047);
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cvq();
    ((k.a)localObject).ddU = this.ddU;
    ((k.a)localObject).nSA = m.ai(this.intent);
    ((k.a)localObject).rfM = k.b.rgk.rgx;
    ((k.a)localObject).rfN = k.b.rgk.name;
    ((k.a)localObject).channel = m.al(this.intent);
    ((k.a)localObject).rfL = m.ak(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).foR = "";
    ((k.a)localObject).cvs().c(this.intent, true).cvr();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.hYt.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25047);
  }
  
  public final void a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(25035);
    try
    {
      this.rkt.lock();
      this.rku = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new c(paramd, paramObject);
      this.gAC.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.rkt.unlock();
      AppMethodBeat.o(25035);
    }
  }
  
  protected final void cwK()
  {
    AppMethodBeat.i(25040);
    this.rjT.setVisibility(4);
    if (this.rik == 31)
    {
      this.rkl.setVisibility(8);
      if ((m.al(getIntent()) == 10) && (!m.dq(ae.fFB.fEN)) && (!m.dq(ae.bW(getContext())))) {
        this.rkl.setText(String.format(getString(2131759610), new Object[] { ae.bW(getContext()) }));
      }
      if (!bt.isNullOrNil(this.rkq)) {
        break label298;
      }
      if (this.rik != 33) {
        break label281;
      }
      this.rkk.setText(getString(2131757570) + ": " + this.ssid);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.dlB))
      {
        if (!bt.isNullOrNil(this.ril)) {
          this.rkj.setText(this.ril);
        }
        if (!bt.isNullOrNil(this.gLg)) {
          o.ayJ().a(this.gLg, this.rki, this.hjG);
        }
      }
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())) });
      AppMethodBeat.o(25040);
      return;
      this.rkl.setVisibility(0);
      this.rkl.setText(2131757574);
      break;
      label281:
      this.rkk.setText(getString(2131757570));
      continue;
      label298:
      this.rkk.setText(this.rkq);
    }
  }
  
  protected final void cwL()
  {
    AppMethodBeat.i(25041);
    this.rjT.setVisibility(4);
    this.rjU.setVisibility(4);
    this.rjV.setVisibility(4);
    this.rkl.setText(2131757571);
    this.rkn = b(getContext(), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25026);
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
        ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.ai(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(m.aj(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4) });
        AppMethodBeat.o(25026);
      }
    });
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())) });
    this.rkn.show();
    AppMethodBeat.o(25041);
  }
  
  protected final void db(Object paramObject)
  {
    AppMethodBeat.i(25043);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(25043);
      return;
    }
    a locala = (a)paramObject;
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), a.a(locala) });
    if (this.rkn != null) {
      this.rkn.dismiss();
    }
    this.rjT.setVisibility(0);
    if (!m.dq(a.b(locala))) {}
    for (paramObject = a.b(locala);; paramObject = getString(a.c(locala)))
    {
      this.rjT.setText(paramObject);
      this.rjT.setVisibility(0);
      this.rjU.setVisibility(0);
      this.rjV.setVisibility(0);
      paramObject = getString(2131759629) + ": " + a.a(locala);
      this.rjV.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.rkl.setVisibility(0);
      this.rkl.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())) });
      AppMethodBeat.o(25043);
      return;
      if (a.c(locala) == 0) {
        a.d(locala);
      }
    }
  }
  
  protected final void dc(Object paramObject)
  {
    AppMethodBeat.i(25044);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(25044);
      return;
    }
    Object localObject = ((b)paramObject).rky;
    if ((this.rik != 31) && (this.rkn != null)) {
      this.rkn.dismiss();
    }
    this.rkl.setText(2131757568);
    this.rkl.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((hj)localObject).Cxj);
    paramObject.putExtra("free_wifi_app_nickname", ((hj)localObject).mBV);
    paramObject.putExtra("free_wifi_app_username", ((hj)localObject).mAQ);
    paramObject.putExtra("free_wifi_signature", ((hj)localObject).ijP);
    paramObject.putExtra("free_wifi_finish_actioncode", ((hj)localObject).CCv);
    paramObject.putExtra("free_wifi_finish_url", ((hj)localObject).CCw);
    paramObject.putExtra(e.f.FHX, ((hj)localObject).rlB);
    if (((hj)localObject).CCv == 2)
    {
      if (!bt.isNullOrNil(((hj)localObject).mAQ))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((hj)localObject).mAQ);
        com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        c.report();
        ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())) });
        localObject = k.cvq();
        ((k.a)localObject).ddU = this.ddU;
        ((k.a)localObject).nSA = m.ai(paramObject);
        ((k.a)localObject).rfM = k.b.rgm.rgx;
        ((k.a)localObject).rfN = k.b.rgm.name;
        ((k.a)localObject).channel = m.al(paramObject);
        ((k.a)localObject).rfL = m.ak(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).foR = "";
        ((k.a)localObject).cvs().c(paramObject, true).cvr();
        AppMethodBeat.o(25044);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.cvq();
      ((k.a)localObject).ddU = this.ddU;
      ((k.a)localObject).nSA = m.ai(paramObject);
      ((k.a)localObject).rfM = k.b.rgl.rgx;
      ((k.a)localObject).rfN = k.b.rgl.name;
      ((k.a)localObject).channel = m.al(paramObject);
      ((k.a)localObject).rfL = m.ak(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).foR = "";
      ((k.a)localObject).cvs().c(paramObject, true).cvr();
      finish();
      paramObject = new com.tencent.mm.hellhoundlib.b.a().bd(paramObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramObject.adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramObject.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())) });
      AppMethodBeat.o(25044);
      return;
      if (m.dq(((hj)localObject).CCx))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((hj)localObject).CCx);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(25045);
    super.finish();
    k.a locala = k.cvq();
    locala.ddU = this.ddU;
    locala.nSA = m.ai(this.intent);
    locala.rfM = k.b.rgj.rgx;
    locala.rfN = k.b.rgj.name;
    locala.channel = m.al(this.intent);
    locala.rfL = m.ak(this.intent);
    locala.result = 0;
    locala.foR = "";
    locala.cvs().c(this.intent, true).cvr();
    AppMethodBeat.o(25045);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494170;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25037);
    setBackBtn(new FreeWifiFrontPageUI.4(this));
    if (this.rkn != null) {
      this.rkn.dismiss();
    }
    this.rkt = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.nha = getIntent().getStringExtra("free_wifi_url");
    this.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    this.cJR = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.rik = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.dlB = getIntent().getStringExtra("free_wifi_appid");
    this.gLg = getIntent().getStringExtra("free_wifi_head_img_url");
    this.rkp = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.rkq = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.rkr = getIntent().getStringExtra("free_wifi_privacy_url");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())), this.className, this.ssid, this.nha, this.ddU, Integer.valueOf(this.dep), Integer.valueOf(this.cJR), Integer.valueOf(this.rik), this.dlB, this.gLg, this.rkp, this.rkr });
    this.rko = findViewById(2131306245);
    this.rki = ((ImageView)findViewById(2131300246));
    this.rkj = ((TextView)findViewById(2131300289));
    this.rkk = ((TextView)findViewById(2131300275));
    this.rjT = ((TextView)findViewById(2131300253));
    this.rjU = ((TextView)findViewById(2131300251));
    this.rjV = ((TextView)findViewById(2131300252));
    this.rkl = ((Button)findViewById(2131298576));
    this.rkl.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.rkm = ((Button)findViewById(2131306246));
    this.rkm.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (bt.isNullOrNil(this.ssid))
    {
      this.rkk.setText(getString(2131759651));
      this.rkl.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    a(d.rkz, null);
    AppMethodBeat.o(25037);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25036);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25036);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25048);
    super.onDestroy();
    com.tencent.mm.plugin.freewifi.model.j.cwb().release();
    AppMethodBeat.o(25048);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25046);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25046);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25046);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25049);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25049);
      return;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25049);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.pcG = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25038);
    super.onResume();
    int i;
    if (this.pcG)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
      AppMethodBeat.o(25038);
      return;
      if (!b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.axU())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiFrontPageUI.7(this), null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.rik)
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { m.ai(getIntent()), Integer.valueOf(m.aj(getIntent())), this.className, this.ddU });
      com.tencent.mm.plugin.freewifi.l.L(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25038);
      return;
      this.rks = new f(this);
      continue;
      this.rks = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.rks = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.rko.setVisibility(0);
      cwJ();
      continue;
      this.rks = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.rko.setVisibility(0);
      continue;
      this.rks = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a rkx;
    public int rjZ;
    public String rka;
    public String text;
    
    static
    {
      AppMethodBeat.i(25029);
      rkx = new a();
      AppMethodBeat.o(25029);
    }
  }
  
  public static final class b
  {
    public hj rky;
  }
  
  public static final class c
  {
    Object data;
    FreeWifiFrontPageUI.d rku;
    
    public c(FreeWifiFrontPageUI.d paramd, Object paramObject)
    {
      this.rku = paramd;
      this.data = paramObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(25032);
      rkz = new d("START", 0);
      rkA = new d("CONNECTING", 1);
      rkB = new d("FAIL", 2);
      rkC = new d("SUCCESS", 3);
      rkD = new d[] { rkz, rkA, rkB, rkC };
      AppMethodBeat.o(25032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */