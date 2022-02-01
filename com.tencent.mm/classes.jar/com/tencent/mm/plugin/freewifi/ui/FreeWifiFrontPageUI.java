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
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI
  extends MMActivity
{
  protected int cGY;
  protected String className;
  protected int dbL;
  protected String dbq;
  protected String djj;
  private ao gox;
  private final com.tencent.mm.av.a.a.c hKj;
  protected String hlG;
  protected Intent intent;
  protected String nJQ;
  private boolean pFR;
  protected int srd;
  protected String sre;
  protected TextView ssM;
  protected TextView ssN;
  protected TextView ssO;
  protected String ssid;
  protected ImageView stb;
  protected TextView stc;
  protected TextView std;
  protected Button ste;
  protected Button stf;
  protected Dialog stg;
  protected View sth;
  protected String sti;
  protected String stj;
  protected String stk;
  protected com.tencent.mm.plugin.freewifi.e.a stl;
  private Lock stm;
  private d stn;
  
  public FreeWifiFrontPageUI()
  {
    AppMethodBeat.i(25033);
    this.pFR = true;
    this.gox = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25018);
        paramAnonymousMessage = (FreeWifiFrontPageUI.c)paramAnonymousMessage.obj;
        switch (FreeWifiFrontPageUI.3.stp[paramAnonymousMessage.stn.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cJW();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.cJX();
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.dd(paramAnonymousMessage.data);
          AppMethodBeat.o(25018);
          return;
          FreeWifiFrontPageUI.this.de(paramAnonymousMessage.data);
        }
      }
    };
    c.a locala = new c.a();
    locala.hKv = true;
    locala.hKw = true;
    locala.hKI = 2131232428;
    locala.gLt = true;
    locala.hKP = 0.0F;
    this.hKj = locala.aFT();
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
  
  private d cJU()
  {
    AppMethodBeat.i(25034);
    try
    {
      this.stm.lock();
      d locald = this.stn;
      return locald;
    }
    finally
    {
      this.stm.unlock();
      AppMethodBeat.o(25034);
    }
  }
  
  private void cJV()
  {
    AppMethodBeat.i(25039);
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    d locald = cJU();
    ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())), this.className, locald.name() });
    if ((cJU() == d.sts) || (cJU() == d.stu))
    {
      boolean bool = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
      int i = m.cIH();
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())), this.className, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i == 1) && (this.srd != 33))
      {
        com.tencent.mm.ui.base.h.a(this, 2131759608, 2131759609, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25025);
            m.fg(FreeWifiFrontPageUI.this);
            AppMethodBeat.o(25025);
          }
        }, null);
        AppMethodBeat.o(25039);
        return;
      }
      this.stn = d.stt;
      cJX();
      this.stl.connect();
    }
    AppMethodBeat.o(25039);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25047);
    com.tencent.mm.plugin.freewifi.l.O(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cIC();
    ((k.a)localObject).dbq = this.dbq;
    ((k.a)localObject).ovU = m.aj(this.intent);
    ((k.a)localObject).soE = k.b.spc.spp;
    ((k.a)localObject).soF = k.b.spc.name;
    ((k.a)localObject).channel = m.am(this.intent);
    ((k.a)localObject).soD = m.al(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fsq = "";
    ((k.a)localObject).cIE().c(this.intent, true).cID();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.iyx.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25047);
  }
  
  public final void a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(25035);
    try
    {
      this.stm.lock();
      this.stn = paramd;
      Message localMessage = Message.obtain();
      localMessage.obj = new c(paramd, paramObject);
      this.gox.sendMessage(localMessage);
      return;
    }
    finally
    {
      this.stm.unlock();
      AppMethodBeat.o(25035);
    }
  }
  
  protected final void cJW()
  {
    AppMethodBeat.i(25040);
    this.ssM.setVisibility(4);
    if (this.srd == 31)
    {
      this.ste.setVisibility(8);
      if ((m.am(getIntent()) == 10) && (!m.cX(ae.fJi.fIu)) && (!m.cX(ae.bZ(getContext())))) {
        this.ste.setText(String.format(getString(2131759610), new Object[] { ae.bZ(getContext()) }));
      }
      if (!bs.isNullOrNil(this.stj)) {
        break label298;
      }
      if (this.srd != 33) {
        break label281;
      }
      this.std.setText(getString(2131757570) + ": " + this.ssid);
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.djj))
      {
        if (!bs.isNullOrNil(this.sre)) {
          this.stc.setText(this.sre);
        }
        if (!bs.isNullOrNil(this.hlG)) {
          o.aFB().a(this.hlG, this.stb, this.hKj);
        }
      }
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())) });
      AppMethodBeat.o(25040);
      return;
      this.ste.setVisibility(0);
      this.ste.setText(2131757574);
      break;
      label281:
      this.std.setText(getString(2131757570));
      continue;
      label298:
      this.std.setText(this.stj);
    }
  }
  
  protected final void cJX()
  {
    AppMethodBeat.i(25041);
    this.ssM.setVisibility(4);
    this.ssN.setVisibility(4);
    this.ssO.setVisibility(4);
    this.ste.setText(2131757571);
    this.stg = b(getContext(), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25026);
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
        ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.aj(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(m.ak(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4) });
        AppMethodBeat.o(25026);
      }
    });
    ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())) });
    this.stg.show();
    AppMethodBeat.o(25041);
  }
  
  protected final void dd(Object paramObject)
  {
    AppMethodBeat.i(25043);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(25043);
      return;
    }
    a locala = (a)paramObject;
    ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), a.a(locala) });
    if (this.stg != null) {
      this.stg.dismiss();
    }
    this.ssM.setVisibility(0);
    if (!m.cX(a.b(locala))) {}
    for (paramObject = a.b(locala);; paramObject = getString(a.c(locala)))
    {
      this.ssM.setText(paramObject);
      this.ssM.setVisibility(0);
      this.ssN.setVisibility(0);
      this.ssO.setVisibility(0);
      paramObject = getString(2131759629) + ": " + a.a(locala);
      this.ssO.setOnClickListener(new FreeWifiFrontPageUI.10(this, paramObject));
      this.ste.setVisibility(0);
      this.ste.setText(2131759649);
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())) });
      AppMethodBeat.o(25043);
      return;
      if (a.c(locala) == 0) {
        a.d(locala);
      }
    }
  }
  
  protected final void de(Object paramObject)
  {
    AppMethodBeat.i(25044);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(25044);
      return;
    }
    Object localObject = ((b)paramObject).str;
    if ((this.srd != 31) && (this.stg != null)) {
      this.stg.dismiss();
    }
    this.ste.setText(2131757568);
    this.ste.setClickable(false);
    paramObject = getIntent();
    paramObject.putExtra("free_wifi_appid", ((hn)localObject).DPF);
    paramObject.putExtra("free_wifi_app_nickname", ((hn)localObject).ndW);
    paramObject.putExtra("free_wifi_app_username", ((hn)localObject).ncR);
    paramObject.putExtra("free_wifi_signature", ((hn)localObject).iJW);
    paramObject.putExtra("free_wifi_finish_actioncode", ((hn)localObject).DUS);
    paramObject.putExtra("free_wifi_finish_url", ((hn)localObject).DUT);
    paramObject.putExtra(e.f.Hhf, ((hn)localObject).suv);
    if (((hn)localObject).DUS == 2)
    {
      if (!bs.isNullOrNil(((hn)localObject).ncR))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", ((hn)localObject).ncR);
        com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
        c.report();
        ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())) });
        localObject = k.cIC();
        ((k.a)localObject).dbq = this.dbq;
        ((k.a)localObject).ovU = m.aj(paramObject);
        ((k.a)localObject).soE = k.b.spe.spp;
        ((k.a)localObject).soF = k.b.spe.name;
        ((k.a)localObject).channel = m.am(paramObject);
        ((k.a)localObject).soD = m.al(paramObject);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).fsq = "";
        ((k.a)localObject).cIE().c(paramObject, true).cID();
        AppMethodBeat.o(25044);
        return;
      }
      paramObject.setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      localObject = k.cIC();
      ((k.a)localObject).dbq = this.dbq;
      ((k.a)localObject).ovU = m.aj(paramObject);
      ((k.a)localObject).soE = k.b.spd.spp;
      ((k.a)localObject).soF = k.b.spd.name;
      ((k.a)localObject).channel = m.am(paramObject);
      ((k.a)localObject).soD = m.al(paramObject);
      ((k.a)localObject).result = 0;
      ((k.a)localObject).fsq = "";
      ((k.a)localObject).cIE().c(paramObject, true).cID();
      finish();
      paramObject = new com.tencent.mm.hellhoundlib.b.a().ba(paramObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramObject.aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramObject.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())) });
      AppMethodBeat.o(25044);
      return;
      if (m.cX(((hn)localObject).DUU))
      {
        paramObject.setClass(this, FreeWifiSuccUI.class);
      }
      else
      {
        paramObject.putExtra("free_wifi_qinghuai_url", ((hn)localObject).DUU);
        paramObject.setClass(this, FreeWifiSuccWebViewUI.class);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(25045);
    super.finish();
    k.a locala = k.cIC();
    locala.dbq = this.dbq;
    locala.ovU = m.aj(this.intent);
    locala.soE = k.b.spb.spp;
    locala.soF = k.b.spb.name;
    locala.channel = m.am(this.intent);
    locala.soD = m.al(this.intent);
    locala.result = 0;
    locala.fsq = "";
    locala.cIE().c(this.intent, true).cID();
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
    if (this.stg != null) {
      this.stg.dismiss();
    }
    this.stm = new ReentrantLock();
    this.className = getClass().getSimpleName();
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.nJQ = getIntent().getStringExtra("free_wifi_url");
    this.dbq = getIntent().getStringExtra("free_wifi_ap_key");
    this.dbL = getIntent().getIntExtra("free_wifi_source", 1);
    this.cGY = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.srd = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    this.djj = getIntent().getStringExtra("free_wifi_appid");
    this.hlG = getIntent().getStringExtra("free_wifi_head_img_url");
    this.sti = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.stj = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.stk = getIntent().getStringExtra("free_wifi_privacy_url");
    this.sre = getIntent().getStringExtra("free_wifi_app_nickname");
    ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())), this.className, this.ssid, this.nJQ, this.dbq, Integer.valueOf(this.dbL), Integer.valueOf(this.cGY), Integer.valueOf(this.srd), this.djj, this.hlG, this.sti, this.stk });
    this.sth = findViewById(2131306245);
    this.stb = ((ImageView)findViewById(2131300246));
    this.stc = ((TextView)findViewById(2131300289));
    this.std = ((TextView)findViewById(2131300275));
    this.ssM = ((TextView)findViewById(2131300253));
    this.ssN = ((TextView)findViewById(2131300251));
    this.ssO = ((TextView)findViewById(2131300252));
    this.ste = ((Button)findViewById(2131298576));
    this.ste.setOnClickListener(new FreeWifiFrontPageUI.5(this));
    this.stf = ((Button)findViewById(2131306246));
    this.stf.setOnClickListener(new FreeWifiFrontPageUI.6(this));
    if (bs.isNullOrNil(this.ssid))
    {
      this.std.setText(getString(2131759651));
      this.ste.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    a(d.sts, null);
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
    com.tencent.mm.plugin.freewifi.model.j.cJn().release();
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
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25049);
      return;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25049);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.pFR = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiFrontPageUI.11(this), new FreeWifiFrontPageUI.2(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25038);
    super.onResume();
    int i;
    if (this.pFR)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
      AppMethodBeat.o(25038);
      return;
      if (!b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.aEM())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiFrontPageUI.7(this), null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.srd)
    {
    }
    for (;;)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[] { m.aj(getIntent()), Integer.valueOf(m.ak(getIntent())), this.className, this.dbq });
      com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25038);
      return;
      this.stl = new f(this);
      continue;
      this.stl = new com.tencent.mm.plugin.freewifi.e.g(this);
      continue;
      this.stl = new com.tencent.mm.plugin.freewifi.e.h(this);
      this.sth.setVisibility(0);
      cJV();
      continue;
      this.stl = new com.tencent.mm.plugin.freewifi.e.j(this);
      this.sth.setVisibility(0);
      continue;
      this.stl = new com.tencent.mm.plugin.freewifi.e.i(this);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a stq;
    public int ssS;
    public String ssT;
    public String text;
    
    static
    {
      AppMethodBeat.i(25029);
      stq = new a();
      AppMethodBeat.o(25029);
    }
  }
  
  public static final class b
  {
    public hn str;
  }
  
  public static final class c
  {
    Object data;
    FreeWifiFrontPageUI.d stn;
    
    public c(FreeWifiFrontPageUI.d paramd, Object paramObject)
    {
      this.stn = paramd;
      this.data = paramObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(25032);
      sts = new d("START", 0);
      stt = new d("CONNECTING", 1);
      stu = new d("FAIL", 2);
      stv = new d("SUCCESS", 3);
      stw = new d[] { sts, stt, stu, stv };
      AppMethodBeat.o(25032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI
 * JD-Core Version:    0.7.0.1
 */