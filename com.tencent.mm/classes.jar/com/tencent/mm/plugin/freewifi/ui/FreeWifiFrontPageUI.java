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
import com.tencent.mm.aw.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hu;
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
  protected int cSc;
  protected String className;
  protected String dmM;
  protected int dnh;
  protected String duW;
  private ap gIf;
  protected String hDQ;
  private final com.tencent.mm.aw.a.a.c idd;
  protected Intent intent;
  protected String omw;
  private boolean qjw;
  protected String ssid;
  protected int tnE;
  protected String tnF;
  protected ImageView tpD;
  protected TextView tpE;
  protected TextView tpF;
  protected Button tpG;
  protected Button tpH;
  protected Dialog tpI;
  protected View tpJ;
  protected String tpK;
  protected String tpL;
  protected String tpM;
  protected com.tencent.mm.plugin.freewifi.e.a tpN;
  private Lock tpO;
  private d tpP;
  protected TextView tpo;
  protected TextView tpp;
  protected TextView tpq;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(25033);
    this.qjw = true;
    this.gIf = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25018);
        paramAnonymousMessage = (FreeWifiFrontPageUI.c)paramAnonymousMessage.obj;
        switch (FreeWifiFrontPageUI.3.tpR[paramAnonymousMessage.tpP.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cSl();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cSm();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dg(paramAnonymousMessage.data);
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dh(paramAnonymousMessage.data);
        }
      }
    };
    c.a locala = new c.a();
    locala.idp = true;
    locala.idq = true;
    locala.idD = 2131232428;
    locala.hfi = true;
    locala.idK = 0.0F;
    this.idd = locala.aJc();
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
  
  private d cSj()
  {
    AppMethodBeat.i(25034);
    try
    {
      this.tpO.lock();
      d locald = this.tpP;
      return locald;
    }
    finally
    {
      this.tpO.unlock();
      AppMethodBeat.o(25034);
    }
  }
  
  private void cSk()
  {
    AppMethodBeat.i(25039);
    l.Q(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    d locald = cSj();
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.className, locald.name() });
    if ((cSj() == d.tpU) || (cSj() == d.tpW))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = com.tencent.mm.plugin.freewifi.m.cQW();
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.tnE != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131759608, 2131759609, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25025);
            com.tencent.mm.plugin.freewifi.m.fj(FreeWifiFrontPageUI.this);
            AppMethodBeat.o(25025);
          }
        }, null);
        AppMethodBeat.o(25039);
        return;
      }
      this.tpP = d.tpV;
      cSm();
      this.tpN.connect();
    }
    AppMethodBeat.o(25039);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25047);
    l.R(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cQR();
    ((k.a)localObject).dmM = this.dmM;
    ((k.a)localObject).oZp = com.tencent.mm.plugin.freewifi.m.ao(this.intent);
    ((k.a)localObject).tlh = k.b.tlF.tlS;
    ((k.a)localObject).tli = k.b.tlF.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    ((k.a)localObject).tlg = com.tencent.mm.plugin.freewifi.m.aq(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fKQ = "";
    ((k.a)localObject).cQT().c(this.intent, true).cQS();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.iRG.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25047);
  }
  
  public final void a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(25035);
    try
    {
      this.tpO.lock();
      this.tpP = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new c(paramd, paramObject);
      this.gIf.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.tpO.unlock();
      AppMethodBeat.o(25035);
    }
  }
  
  protected final void cSl()
  {
    AppMethodBeat.i(25040);
    this.tpo.setVisibility(4);
    if (this.tnE == 31)
    {
      this.tpG.setVisibility(8);
      if ((com.tencent.mm.plugin.freewifi.m.ar(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.ea(ae.gcJ.gbU)) && (!com.tencent.mm.plugin.freewifi.m.ea(ae.bX(getContext())))) {
        this.tpG.setText(String.format(getString(2131759610), new Object[] { ae.bX(getContext()) }));
      }
      if (!bt.isNullOrNil(this.tpL)) {
        break label298;
      }
      if (this.tnE != 33) {
        break label281;
      }
      this.tpF.setText(getString(2131757570) + ": " + this.ssid);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.duW))
      {
        if (!bt.isNullOrNil(this.tnF)) {
          this.tpE.setText(this.tnF);
        }
        if (!bt.isNullOrNil(this.hDQ)) {
          q.aIJ().a(this.hDQ, this.tpD, this.idd);
        }
      }
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      AppMethodBeat.o(25040);
      return;
      this.tpG.setVisibility(0);
      this.tpG.setText(2131757574);
      break;
      label281:
      this.tpF.setText(getString(2131757570));
      continue;
      label298:
      this.tpF.setText(this.tpL);
    }
  }
  
  protected final void cSm()
  {
    AppMethodBeat.i(25041);
    this.tpo.setVisibility(4);
    this.tpp.setVisibility(4);
    this.tpq.setVisibility(4);
    this.tpG.setText(2131757571);
    this.tpI = b(getContext(), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25026);
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
        ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4) });
        AppMethodBeat.o(25026);
      }
    });
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
    this.tpI.show();
    AppMethodBeat.o(25041);
  }
  
  protected final void dg(Object paramObject)
  {
    AppMethodBeat.i(25043);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(25043);
      return;
    }
    a locala = (a)paramObject;
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(this.intent)), a.a(locala) });
    if (this.tpI != null) {
      this.tpI.dismiss();
    }
    this.tpo.setVisibility(0);
    if (!com.tencent.mm.plugin.freewifi.m.ea(a.b(locala))) {}
    for (paramObject = a.b(locala);; paramObject = getString(a.c(locala)))
    {
      this.tpo.setText(paramObject);
      this.tpo.setVisibility(0);
      this.tpp.setVisibility(0);
      this.tpq.setVisibility(0);
      paramObject = getString(2131759629) + ": " + a.a(locala);
      this.tpq.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.tpG.setVisibility(0);
      this.tpG.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      AppMethodBeat.o(25043);
      return;
      if (a.c(locala) == 0) {
        a.d(locala);
      }
    }
  }
  
  protected final void dh(Object paramObject)
  {
    AppMethodBeat.i(25044);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(25044);
      return;
    }
    Object localObject = ((b)paramObject).tpT;
    if ((this.tnE != 31) && (this.tpI != null)) {
      this.tpI.dismiss();
    }
    this.tpG.setText(2131757568);
    this.tpG.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((hu)localObject).FuU);
    paramObject.putExtra("free_wifi_app_nickname", ((hu)localObject).nEt);
    paramObject.putExtra("free_wifi_app_username", ((hu)localObject).nDo);
    paramObject.putExtra("free_wifi_signature", ((hu)localObject).jdf);
    paramObject.putExtra("free_wifi_finish_actioncode", ((hu)localObject).FAn);
    paramObject.putExtra("free_wifi_finish_url", ((hu)localObject).FAo);
    paramObject.putExtra(e.f.IUv, ((hu)localObject).tqW);
    if (((hu)localObject).FAn == 2)
    {
      if (!bt.isNullOrNil(((hu)localObject).nDo))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((hu)localObject).nDo);
        com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        c.report();
        ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
        localObject = k.cQR();
        ((k.a)localObject).dmM = this.dmM;
        ((k.a)localObject).oZp = com.tencent.mm.plugin.freewifi.m.ao(paramObject);
        ((k.a)localObject).tlh = k.b.tlH.tlS;
        ((k.a)localObject).tli = k.b.tlH.name;
        ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.ar(paramObject);
        ((k.a)localObject).tlg = com.tencent.mm.plugin.freewifi.m.aq(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).fKQ = "";
        ((k.a)localObject).cQT().c(paramObject, true).cQS();
        AppMethodBeat.o(25044);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.cQR();
      ((k.a)localObject).dmM = this.dmM;
      ((k.a)localObject).oZp = com.tencent.mm.plugin.freewifi.m.ao(paramObject);
      ((k.a)localObject).tlh = k.b.tlG.tlS;
      ((k.a)localObject).tli = k.b.tlG.name;
      ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.ar(paramObject);
      ((k.a)localObject).tlg = com.tencent.mm.plugin.freewifi.m.aq(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).fKQ = "";
      ((k.a)localObject).cQT().c(paramObject, true).cQS();
      finish();
      paramObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramObject.ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramObject.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      AppMethodBeat.o(25044);
      return;
      if (com.tencent.mm.plugin.freewifi.m.ea(((hu)localObject).FAp))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((hu)localObject).FAp);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(25045);
    super.finish();
    k.a locala = k.cQR();
    locala.dmM = this.dmM;
    locala.oZp = com.tencent.mm.plugin.freewifi.m.ao(this.intent);
    locala.tlh = k.b.tlE.tlS;
    locala.tli = k.b.tlE.name;
    locala.channel = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    locala.tlg = com.tencent.mm.plugin.freewifi.m.aq(this.intent);
    locala.result = 0;
    locala.fKQ = "";
    locala.cQT().c(this.intent, true).cQS();
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
    if (this.tpI != null) {
      this.tpI.dismiss();
    }
    this.tpO = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.omw = getIntent().getStringExtra("free_wifi_url");
    this.dmM = getIntent().getStringExtra("free_wifi_ap_key");
    this.dnh = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSc = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.tnE = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.duW = getIntent().getStringExtra("free_wifi_appid");
    this.hDQ = getIntent().getStringExtra("free_wifi_head_img_url");
    this.tpK = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.tpL = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.tpM = getIntent().getStringExtra("free_wifi_privacy_url");
    this.tnF = getIntent().getStringExtra("free_wifi_app_nickname");
    ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.className, this.ssid, this.omw, this.dmM, Integer.valueOf(this.dnh), Integer.valueOf(this.cSc), Integer.valueOf(this.tnE), this.duW, this.hDQ, this.tpK, this.tpM });
    this.tpJ = findViewById(2131306245);
    this.tpD = ((ImageView)findViewById(2131300246));
    this.tpE = ((TextView)findViewById(2131300289));
    this.tpF = ((TextView)findViewById(2131300275));
    this.tpo = ((TextView)findViewById(2131300253));
    this.tpp = ((TextView)findViewById(2131300251));
    this.tpq = ((TextView)findViewById(2131300252));
    this.tpG = ((Button)findViewById(2131298576));
    this.tpG.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.tpH = ((Button)findViewById(2131306246));
    this.tpH.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (bt.isNullOrNil(this.ssid))
    {
      this.tpF.setText(getString(2131759651));
      this.tpG.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    a(d.tpU, null);
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
    com.tencent.mm.plugin.freewifi.model.j.cRC().release();
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
        this.qjw = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25038);
    super.onResume();
    int i;
    if (this.qjw)
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
      if (!b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.aHR())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25024);
            com.tencent.mm.modelgeo.d.cB(FreeWifiFrontPageUI.this);
            AppMethodBeat.o(25024);
          }
        }, null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.tnE)
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.className, this.dmM });
      l.P(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25038);
      return;
      this.tpN = new f(this);
      continue;
      this.tpN = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.tpN = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.tpJ.setVisibility(0);
      cSk();
      continue;
      this.tpN = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.tpJ.setVisibility(0);
      continue;
      this.tpN = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a tpS;
    public String text;
    public int tpu;
    public String tpv;
    
    static
    {
      AppMethodBeat.i(25029);
      tpS = new a();
      AppMethodBeat.o(25029);
    }
  }
  
  public static final class b
  {
    public hu tpT;
  }
  
  public static final class c
  {
    Object data;
    FreeWifiFrontPageUI.d tpP;
    
    public c(FreeWifiFrontPageUI.d paramd, Object paramObject)
    {
      this.tpP = paramd;
      this.data = paramObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(25032);
      tpU = new d("START", 0);
      tpV = new d("CONNECTING", 1);
      tpW = new d("FAIL", 2);
      tpX = new d("SUCCESS", 3);
      tpY = new d[] { tpU, tpV, tpW, tpX };
      AppMethodBeat.o(25032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */