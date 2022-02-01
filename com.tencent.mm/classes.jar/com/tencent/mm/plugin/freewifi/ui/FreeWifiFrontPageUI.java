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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected int channelId;
  protected String className;
  protected String dFd;
  protected String dNI;
  private MMHandler hAk;
  protected String iAR;
  protected Intent intent;
  private final com.tencent.mm.av.a.a.c jaR;
  protected String pFJ;
  private boolean rHi;
  protected int source;
  protected String ssid;
  protected String wPA;
  protected int wPz;
  protected Dialog wRA;
  protected View wRB;
  protected String wRC;
  protected String wRD;
  protected String wRE;
  protected com.tencent.mm.plugin.freewifi.e.a wRF;
  private Lock wRG;
  private d wRH;
  protected TextView wRh;
  protected TextView wRi;
  protected TextView wRj;
  protected ImageView wRv;
  protected TextView wRw;
  protected TextView wRx;
  protected Button wRy;
  protected Button wRz;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(25033);
    this.rHi = true;
    this.hAk = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25018);
        paramAnonymousMessage = (FreeWifiFrontPageUI.c)paramAnonymousMessage.obj;
        switch (FreeWifiFrontPageUI.3.wRJ[paramAnonymousMessage.wRH.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dNZ();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dOa();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.jdMethod_do(paramAnonymousMessage.data);
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dp(paramAnonymousMessage.data);
        }
      }
    };
    c.a locala = new c.a();
    locala.jbd = true;
    locala.jbe = true;
    locala.jbq = 2131232809;
    locala.iaT = true;
    locala.jbx = 0.0F;
    this.jaR = locala.bdv();
    AppMethodBeat.o(25033);
  }
  
  private static Dialog b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(25042);
    View localView = View.inflate(paramContext, 2131494730, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, 2131820958);
    paramContext.setCancelable(true);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    AppMethodBeat.o(25042);
    return paramContext;
  }
  
  private d dNX()
  {
    AppMethodBeat.i(25034);
    try
    {
      this.wRG.lock();
      d locald = this.wRH;
      return locald;
    }
    finally
    {
      this.wRG.unlock();
      AppMethodBeat.o(25034);
    }
  }
  
  private void dNY()
  {
    AppMethodBeat.i(25039);
    l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    d locald = dNX();
    Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.className, locald.name() });
    if ((dNX() == d.wRM) || (dNX() == d.wRO))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = com.tencent.mm.plugin.freewifi.m.dMK();
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.wPz != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131760929, 2131760930, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25025);
            com.tencent.mm.plugin.freewifi.m.fT(FreeWifiFrontPageUI.this);
            AppMethodBeat.o(25025);
          }
        }, null);
        AppMethodBeat.o(25039);
        return;
      }
      this.wRH = d.wRN;
      dOa();
      this.wRF.connect();
    }
    AppMethodBeat.o(25039);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25047);
    l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.dMF();
    ((k.a)localObject).dFd = this.dFd;
    ((k.a)localObject).quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
    ((k.a)localObject).wNd = k.b.wNB.wNO;
    ((k.a)localObject).wNe = k.b.wNB.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
    ((k.a)localObject).wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).resultMsg = "";
    ((k.a)localObject).dMH().c(this.intent, true).dMG();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.jRt.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25047);
  }
  
  public final void a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(25035);
    try
    {
      this.wRG.lock();
      this.wRH = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new c(paramd, paramObject);
      this.hAk.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.wRG.unlock();
      AppMethodBeat.o(25035);
    }
  }
  
  protected final void dNZ()
  {
    AppMethodBeat.i(25040);
    this.wRh.setVisibility(4);
    if (this.wPz == 31)
    {
      this.wRy.setVisibility(8);
      if ((com.tencent.mm.plugin.freewifi.m.az(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.eP(ae.gKy.gJB)) && (!com.tencent.mm.plugin.freewifi.m.eP(ae.cu(getContext())))) {
        this.wRy.setText(String.format(getString(2131760931), new Object[] { ae.cu(getContext()) }));
      }
      if (!Util.isNullOrNil(this.wRD)) {
        break label298;
      }
      if (this.wPz != 33) {
        break label281;
      }
      this.wRx.setText(getString(2131757797) + ": " + this.ssid);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.dNI))
      {
        if (!Util.isNullOrNil(this.wPA)) {
          this.wRw.setText(this.wPA);
        }
        if (!Util.isNullOrNil(this.iAR)) {
          q.bcV().a(this.iAR, this.wRv, this.jaR);
        }
      }
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25040);
      return;
      this.wRy.setVisibility(0);
      this.wRy.setText(2131757801);
      break;
      label281:
      this.wRx.setText(getString(2131757797));
      continue;
      label298:
      this.wRx.setText(this.wRD);
    }
  }
  
  protected final void dOa()
  {
    AppMethodBeat.i(25041);
    this.wRh.setVisibility(4);
    this.wRi.setVisibility(4);
    this.wRj.setVisibility(4);
    this.wRy.setText(2131757798);
    this.wRA = b(getContext(), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25026);
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4) });
        AppMethodBeat.o(25026);
      }
    });
    Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
    this.wRA.show();
    AppMethodBeat.o(25041);
  }
  
  protected final void jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(25043);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(25043);
      return;
    }
    a locala = (a)paramObject;
    Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(this.intent)), a.a(locala) });
    if (this.wRA != null) {
      this.wRA.dismiss();
    }
    this.wRh.setVisibility(0);
    if (!com.tencent.mm.plugin.freewifi.m.eP(a.b(locala))) {}
    for (paramObject = a.b(locala);; paramObject = getString(a.c(locala)))
    {
      this.wRh.setText(paramObject);
      this.wRh.setVisibility(0);
      this.wRi.setVisibility(0);
      this.wRj.setVisibility(0);
      paramObject = getString(2131760950) + ": " + a.a(locala);
      this.wRj.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.wRy.setVisibility(0);
      this.wRy.setText(2131760970);
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25043);
      return;
      if (a.c(locala) == 0) {
        a.d(locala);
      }
    }
  }
  
  protected final void dp(Object paramObject)
  {
    AppMethodBeat.i(25044);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(25044);
      return;
    }
    Object localObject = ((b)paramObject).wRL;
    if ((this.wPz != 31) && (this.wRA != null)) {
      this.wRA.dismiss();
    }
    this.wRy.setText(2131757795);
    this.wRy.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((ih)localObject).KGX);
    paramObject.putExtra("free_wifi_app_nickname", ((ih)localObject).oUJ);
    paramObject.putExtra("free_wifi_app_username", ((ih)localObject).UserName);
    paramObject.putExtra("free_wifi_signature", ((ih)localObject).keb);
    paramObject.putExtra("free_wifi_finish_actioncode", ((ih)localObject).KMt);
    paramObject.putExtra("free_wifi_finish_url", ((ih)localObject).KMu);
    paramObject.putExtra(e.h.Ozc, ((ih)localObject).wSO);
    if (((ih)localObject).KMt == 2)
    {
      if (!Util.isNullOrNil(((ih)localObject).UserName))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((ih)localObject).UserName);
        com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        c.report();
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        localObject = k.dMF();
        ((k.a)localObject).dFd = this.dFd;
        ((k.a)localObject).quX = com.tencent.mm.plugin.freewifi.m.aw(paramObject);
        ((k.a)localObject).wNd = k.b.wND.wNO;
        ((k.a)localObject).wNe = k.b.wND.name;
        ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.az(paramObject);
        ((k.a)localObject).wNc = com.tencent.mm.plugin.freewifi.m.ay(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).resultMsg = "";
        ((k.a)localObject).dMH().c(paramObject, true).dMG();
        AppMethodBeat.o(25044);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.dMF();
      ((k.a)localObject).dFd = this.dFd;
      ((k.a)localObject).quX = com.tencent.mm.plugin.freewifi.m.aw(paramObject);
      ((k.a)localObject).wNd = k.b.wNC.wNO;
      ((k.a)localObject).wNe = k.b.wNC.name;
      ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.az(paramObject);
      ((k.a)localObject).wNc = com.tencent.mm.plugin.freewifi.m.ay(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).resultMsg = "";
      ((k.a)localObject).dMH().c(paramObject, true).dMG();
      finish();
      paramObject = new com.tencent.mm.hellhoundlib.b.a().bl(paramObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramObject.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramObject.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25044);
      return;
      if (com.tencent.mm.plugin.freewifi.m.eP(((ih)localObject).KMv))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((ih)localObject).KMv);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(25045);
    super.finish();
    k.a locala = k.dMF();
    locala.dFd = this.dFd;
    locala.quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
    locala.wNd = k.b.wNA.wNO;
    locala.wNe = k.b.wNA.name;
    locala.channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
    locala.wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
    locala.result = 0;
    locala.resultMsg = "";
    locala.dMH().c(this.intent, true).dMG();
    AppMethodBeat.o(25045);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25037);
    setBackBtn(new FreeWifiFrontPageUI.4(this));
    if (this.wRA != null) {
      this.wRA.dismiss();
    }
    this.wRG = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.pFJ = getIntent().getStringExtra("free_wifi_url");
    this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.dNI = getIntent().getStringExtra("free_wifi_appid");
    this.iAR = getIntent().getStringExtra("free_wifi_head_img_url");
    this.wRC = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.wRD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
    this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
    Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.className, this.ssid, this.pFJ, this.dFd, Integer.valueOf(this.source), Integer.valueOf(this.channelId), Integer.valueOf(this.wPz), this.dNI, this.iAR, this.wRC, this.wRE });
    this.wRB = findViewById(2131309644);
    this.wRv = ((ImageView)findViewById(2131301725));
    this.wRw = ((TextView)findViewById(2131301768));
    this.wRx = ((TextView)findViewById(2131301754));
    this.wRh = ((TextView)findViewById(2131301732));
    this.wRi = ((TextView)findViewById(2131301730));
    this.wRj = ((TextView)findViewById(2131301731));
    this.wRy = ((Button)findViewById(2131299013));
    this.wRy.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.wRz = ((Button)findViewById(2131309645));
    this.wRz.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (Util.isNullOrNil(this.ssid))
    {
      this.wRx.setText(getString(2131760972));
      this.wRy.setVisibility(4);
    }
    setMMTitle(getString(2131760974));
    a(d.wRM, null);
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
    com.tencent.mm.plugin.freewifi.model.j.dNq().release();
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
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25049);
      return;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25049);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.rHi = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25038);
    super.onResume();
    int i;
    if (this.rHi)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_FINE_LOCATION", 77, null, null);
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
      AppMethodBeat.o(25038);
      return;
      if (!b.n(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.bcc())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131761461), getString(2131755998), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25024);
            com.tencent.mm.modelgeo.d.cZ(FreeWifiFrontPageUI.this);
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
    switch (this.wPz)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.className, this.dFd });
      l.Q(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25038);
      return;
      this.wRF = new f(this);
      continue;
      this.wRF = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.wRF = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.wRB.setVisibility(0);
      dNY();
      continue;
      this.wRF = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.wRB.setVisibility(0);
      continue;
      this.wRF = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a wRK;
    public String text;
    public int wRn;
    public String wRo;
    
    static
    {
      AppMethodBeat.i(25029);
      wRK = new a();
      AppMethodBeat.o(25029);
    }
  }
  
  public static final class b
  {
    public ih wRL;
  }
  
  public static final class c
  {
    Object data;
    FreeWifiFrontPageUI.d wRH;
    
    public c(FreeWifiFrontPageUI.d paramd, Object paramObject)
    {
      this.wRH = paramd;
      this.data = paramObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(25032);
      wRM = new d("START", 0);
      wRN = new d("CONNECTING", 1);
      wRO = new d("FAIL", 2);
      wRP = new d("SUCCESS", 3);
      wRQ = new d[] { wRM, wRN, wRO, wRP };
      AppMethodBeat.o(25032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */