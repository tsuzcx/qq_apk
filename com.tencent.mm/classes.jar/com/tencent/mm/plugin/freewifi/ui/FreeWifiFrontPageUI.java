package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected int cSM;
  protected String className;
  protected String dnO;
  protected int doj;
  protected String dwb;
  private aq gKO;
  protected String hGI;
  private final com.tencent.mm.av.a.a.c ifW;
  protected Intent intent;
  protected String osm;
  private boolean qqb;
  protected String ssid;
  protected View tAA;
  protected String tAB;
  protected String tAC;
  protected String tAD;
  protected com.tencent.mm.plugin.freewifi.e.a tAE;
  private Lock tAF;
  private d tAG;
  protected TextView tAf;
  protected TextView tAg;
  protected TextView tAh;
  protected ImageView tAu;
  protected TextView tAv;
  protected TextView tAw;
  protected Button tAx;
  protected Button tAy;
  protected Dialog tAz;
  protected int tyw;
  protected String tyx;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(25033);
    this.qqb = true;
    this.gKO = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25018);
        paramAnonymousMessage = (FreeWifiFrontPageUI.c)paramAnonymousMessage.obj;
        switch (FreeWifiFrontPageUI.3.tAI[paramAnonymousMessage.tAG.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cUQ();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cUR();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dh(paramAnonymousMessage.data);
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.di(paramAnonymousMessage.data);
        }
      }
    };
    c.a locala = new c.a();
    locala.igi = true;
    locala.igj = true;
    locala.igv = 2131232428;
    locala.hhW = true;
    locala.igC = 0.0F;
    this.ifW = locala.aJu();
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
  
  private d cUO()
  {
    AppMethodBeat.i(25034);
    try
    {
      this.tAF.lock();
      d locald = this.tAG;
      return locald;
    }
    finally
    {
      this.tAF.unlock();
      AppMethodBeat.o(25034);
    }
  }
  
  private void cUP()
  {
    AppMethodBeat.i(25039);
    l.Q(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    d locald = cUO();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.className, locald.name() });
    if ((cUO() == d.tAL) || (cUO() == d.tAN))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = com.tencent.mm.plugin.freewifi.m.cTB();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.tyw != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131759608, 2131759609, new FreeWifiFrontPageUI.8(this), null);
        AppMethodBeat.o(25039);
        return;
      }
      this.tAG = d.tAM;
      cUR();
      this.tAE.connect();
    }
    AppMethodBeat.o(25039);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25047);
    l.R(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cTw();
    ((k.a)localObject).dnO = this.dnO;
    ((k.a)localObject).pfT = com.tencent.mm.plugin.freewifi.m.ap(this.intent);
    ((k.a)localObject).tvZ = k.b.twx.twK;
    ((k.a)localObject).twa = k.b.twx.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.as(this.intent);
    ((k.a)localObject).tvY = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fMT = "";
    ((k.a)localObject).cTy().c(this.intent, true).cTx();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.iUz.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25047);
  }
  
  public final void a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(25035);
    try
    {
      this.tAF.lock();
      this.tAG = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new c(paramd, paramObject);
      this.gKO.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.tAF.unlock();
      AppMethodBeat.o(25035);
    }
  }
  
  protected final void cUQ()
  {
    AppMethodBeat.i(25040);
    this.tAf.setVisibility(4);
    if (this.tyw == 31)
    {
      this.tAx.setVisibility(8);
      if ((com.tencent.mm.plugin.freewifi.m.as(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.ef(com.tencent.mm.compatible.deviceinfo.ae.geR.gec)) && (!com.tencent.mm.plugin.freewifi.m.ef(com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext())))) {
        this.tAx.setText(String.format(getString(2131759610), new Object[] { com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext()) }));
      }
      if (!bu.isNullOrNil(this.tAC)) {
        break label298;
      }
      if (this.tyw != 33) {
        break label281;
      }
      this.tAw.setText(getString(2131757570) + ": " + this.ssid);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.dwb))
      {
        if (!bu.isNullOrNil(this.tyx)) {
          this.tAv.setText(this.tyx);
        }
        if (!bu.isNullOrNil(this.hGI)) {
          q.aJb().a(this.hGI, this.tAu, this.ifW);
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25040);
      return;
      this.tAx.setVisibility(0);
      this.tAx.setText(2131757574);
      break;
      label281:
      this.tAw.setText(getString(2131757570));
      continue;
      label298:
      this.tAw.setText(this.tAC);
    }
  }
  
  protected final void cUR()
  {
    AppMethodBeat.i(25041);
    this.tAf.setVisibility(4);
    this.tAg.setVisibility(4);
    this.tAh.setVisibility(4);
    this.tAx.setText(2131757571);
    this.tAz = b(getContext(), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25026);
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4) });
        AppMethodBeat.o(25026);
      }
    });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
    this.tAz.show();
    AppMethodBeat.o(25041);
  }
  
  protected final void dh(Object paramObject)
  {
    AppMethodBeat.i(25043);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(25043);
      return;
    }
    a locala = (a)paramObject;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(this.intent)), a.a(locala) });
    if (this.tAz != null) {
      this.tAz.dismiss();
    }
    this.tAf.setVisibility(0);
    if (!com.tencent.mm.plugin.freewifi.m.ef(a.b(locala))) {}
    for (paramObject = a.b(locala);; paramObject = getString(a.c(locala)))
    {
      this.tAf.setText(paramObject);
      this.tAf.setVisibility(0);
      this.tAg.setVisibility(0);
      this.tAh.setVisibility(0);
      paramObject = getString(2131759629) + ": " + a.a(locala);
      this.tAh.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.tAx.setVisibility(0);
      this.tAx.setText(2131759649);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25043);
      return;
      if (a.c(locala) == 0) {
        a.d(locala);
      }
    }
  }
  
  protected final void di(Object paramObject)
  {
    AppMethodBeat.i(25044);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(25044);
      return;
    }
    Object localObject = ((b)paramObject).tAK;
    if ((this.tyw != 31) && (this.tAz != null)) {
      this.tAz.dismiss();
    }
    this.tAx.setText(2131757568);
    this.tAx.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((hu)localObject).FNs);
    paramObject.putExtra("free_wifi_app_nickname", ((hu)localObject).nJO);
    paramObject.putExtra("free_wifi_app_username", ((hu)localObject).nIJ);
    paramObject.putExtra("free_wifi_signature", ((hu)localObject).jfY);
    paramObject.putExtra("free_wifi_finish_actioncode", ((hu)localObject).FSK);
    paramObject.putExtra("free_wifi_finish_url", ((hu)localObject).FSL);
    paramObject.putExtra(e.f.Jpd, ((hu)localObject).tBN);
    if (((hu)localObject).FSK == 2)
    {
      if (!bu.isNullOrNil(((hu)localObject).nIJ))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((hu)localObject).nIJ);
        com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        c.report();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
        localObject = k.cTw();
        ((k.a)localObject).dnO = this.dnO;
        ((k.a)localObject).pfT = com.tencent.mm.plugin.freewifi.m.ap(paramObject);
        ((k.a)localObject).tvZ = k.b.twz.twK;
        ((k.a)localObject).twa = k.b.twz.name;
        ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.as(paramObject);
        ((k.a)localObject).tvY = com.tencent.mm.plugin.freewifi.m.ar(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).fMT = "";
        ((k.a)localObject).cTy().c(paramObject, true).cTx();
        AppMethodBeat.o(25044);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.cTw();
      ((k.a)localObject).dnO = this.dnO;
      ((k.a)localObject).pfT = com.tencent.mm.plugin.freewifi.m.ap(paramObject);
      ((k.a)localObject).tvZ = k.b.twy.twK;
      ((k.a)localObject).twa = k.b.twy.name;
      ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.as(paramObject);
      ((k.a)localObject).tvY = com.tencent.mm.plugin.freewifi.m.ar(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).fMT = "";
      ((k.a)localObject).cTy().c(paramObject, true).cTx();
      finish();
      paramObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramObject.ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramObject.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25044);
      return;
      if (com.tencent.mm.plugin.freewifi.m.ef(((hu)localObject).FSM))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((hu)localObject).FSM);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(25045);
    super.finish();
    k.a locala = k.cTw();
    locala.dnO = this.dnO;
    locala.pfT = com.tencent.mm.plugin.freewifi.m.ap(this.intent);
    locala.tvZ = k.b.tww.twK;
    locala.twa = k.b.tww.name;
    locala.channel = com.tencent.mm.plugin.freewifi.m.as(this.intent);
    locala.tvY = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    locala.result = 0;
    locala.fMT = "";
    locala.cTy().c(this.intent, true).cTx();
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
    if (this.tAz != null) {
      this.tAz.dismiss();
    }
    this.tAF = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.osm = getIntent().getStringExtra("free_wifi_url");
    this.dnO = getIntent().getStringExtra("free_wifi_ap_key");
    this.doj = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSM = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.tyw = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.dwb = getIntent().getStringExtra("free_wifi_appid");
    this.hGI = getIntent().getStringExtra("free_wifi_head_img_url");
    this.tAB = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.tAC = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.tAD = getIntent().getStringExtra("free_wifi_privacy_url");
    this.tyx = getIntent().getStringExtra("free_wifi_app_nickname");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.className, this.ssid, this.osm, this.dnO, Integer.valueOf(this.doj), Integer.valueOf(this.cSM), Integer.valueOf(this.tyw), this.dwb, this.hGI, this.tAB, this.tAD });
    this.tAA = findViewById(2131306245);
    this.tAu = ((ImageView)findViewById(2131300246));
    this.tAv = ((TextView)findViewById(2131300289));
    this.tAw = ((TextView)findViewById(2131300275));
    this.tAf = ((TextView)findViewById(2131300253));
    this.tAg = ((TextView)findViewById(2131300251));
    this.tAh = ((TextView)findViewById(2131300252));
    this.tAx = ((Button)findViewById(2131298576));
    this.tAx.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.tAy = ((Button)findViewById(2131306246));
    this.tAy.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (bu.isNullOrNil(this.ssid))
    {
      this.tAw.setText(getString(2131759651));
      this.tAx.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    a(d.tAL, null);
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
    com.tencent.mm.plugin.freewifi.model.j.cUh().release();
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25049);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25049);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.qqb = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25038);
    super.onResume();
    int i;
    if (this.qqb)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
      AppMethodBeat.o(25038);
      return;
      if (!b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.aIi())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiFrontPageUI.7(this), null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.tyw)
    {
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.className, this.dnO });
      l.P(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25038);
      return;
      this.tAE = new f(this);
      continue;
      this.tAE = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.tAE = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.tAA.setVisibility(0);
      cUP();
      continue;
      this.tAE = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.tAA.setVisibility(0);
      continue;
      this.tAE = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a tAJ;
    public int tAl;
    public String tAm;
    public String text;
    
    static
    {
      AppMethodBeat.i(25029);
      tAJ = new a();
      AppMethodBeat.o(25029);
    }
  }
  
  public static final class b
  {
    public hu tAK;
  }
  
  public static final class c
  {
    Object data;
    FreeWifiFrontPageUI.d tAG;
    
    public c(FreeWifiFrontPageUI.d paramd, Object paramObject)
    {
      this.tAG = paramd;
      this.data = paramObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(25032);
      tAL = new d("START", 0);
      tAM = new d("CONNECTING", 1);
      tAN = new d("FAIL", 2);
      tAO = new d("SUCCESS", 3);
      tAP = new d[] { tAL, tAM, tAN, tAO };
      AppMethodBeat.o(25032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */