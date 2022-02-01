package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI
  extends MMActivity
{
  protected int cJR;
  private String cMo;
  private String ddU;
  protected int dep;
  private int dgF;
  protected String dkB;
  protected String dlB;
  protected String gLg;
  private final com.tencent.mm.aw.a.a.c hjG;
  private Intent intent;
  protected String nha;
  private String openId;
  private String riG;
  protected String ril;
  private com.tencent.mm.plugin.freewifi.a rip;
  private int riv;
  protected String rjA;
  private com.tencent.mm.sdk.e.k.a rjG;
  private TextView rjT;
  private ImageView rki;
  private TextView rkj;
  private TextView rkk;
  private Button rkl;
  private Button rkm;
  protected String rkp;
  protected String rkq;
  protected String rkr;
  private av rlN;
  private p rll;
  protected int rlq;
  protected String rlr;
  protected String rls;
  private String sign;
  protected String signature;
  protected String ssid;
  
  public ProtocolThreeTwoUI()
  {
    AppMethodBeat.i(25256);
    this.dgF = 1;
    this.riv = 0;
    this.rlN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25233);
        if (!bt.isNullOrNil(ProtocolThreeTwoUI.this.ssid))
        {
          ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cwA());
          if (ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this) != 2)
          {
            ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
          }
        }
        AppMethodBeat.o(25233);
        return false;
      }
    }, false);
    c.a locala = new c.a();
    locala.hjS = true;
    locala.hjT = true;
    locala.hkf = 2131232428;
    locala.gkG = true;
    locala.hkm = 0.0F;
    this.hjG = locala.azc();
    AppMethodBeat.o(25256);
  }
  
  private void ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(25264);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cvq();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.aav("MicroMsg.FreeWifi.Protocol32UI");
    locala.ddV = com.tencent.mm.plugin.freewifi.m.aaw("MicroMsg.FreeWifi.Protocol32UI");
    locala.ddU = this.ddU;
    locala.rfK = this.dlB;
    locala.nSA = com.tencent.mm.plugin.freewifi.m.ai(this.intent);
    locala.rfL = com.tencent.mm.plugin.freewifi.m.ak(this.intent);
    locala.rfM = k.b.rgo.rgx;
    locala.rfN = k.b.rgo.name;
    locala.result = paramInt;
    locala.foR = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.al(this.intent);
    locala.rfO = this.dkB;
    locala.cvs().cvr();
    AppMethodBeat.o(25264);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25262);
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.hYt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25262);
  }
  
  protected final void Dz(int paramInt)
  {
    AppMethodBeat.i(25260);
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25260);
      return;
    case 4: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rlN.stopTimer();
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757574);
      if (this.dep == 3) {
        this.rkk.setText(getString(2131761229, new Object[] { this.ssid }));
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
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        AppMethodBeat.o(25260);
        return;
        if (bt.isNullOrNil(this.rkq)) {
          this.rkk.setText(getString(2131757570));
        } else {
          this.rkk.setText(this.rkq);
        }
      }
    case 1: 
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757571);
      this.rll = com.tencent.mm.ui.base.h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25236);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
          ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25236);
        }
      });
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    case 3: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rlN.stopTimer();
      this.rjT.setVisibility(0);
      this.rkl.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    }
    if (this.rll != null) {
      this.rll.dismiss();
    }
    this.rlN.stopTimer();
    this.rkl.setText(2131757568);
    this.rkl.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.dlB);
    ((Intent)localObject).putExtra("free_wifi_app_nickname", this.ril);
    ((Intent)localObject).putExtra("free_wifi_app_username", this.dkB);
    ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
    ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.rlq);
    ((Intent)localObject).putExtra("free_wifi_finish_url", this.rlr);
    if (bt.isNullOrNil(this.rls)) {
      ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      finish();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.rls);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25259);
    this.dgF = cwA();
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(this.dgF) });
    if (this.dgF != 2)
    {
      this.rlN.av(45000L, 45000L);
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(60) });
      this.rip = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
      j.cwb().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25241);
          ProtocolThreeTwoUI.c(ProtocolThreeTwoUI.this);
          AppMethodBeat.o(25241);
        }
      });
      AppMethodBeat.o(25259);
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(25259);
  }
  
  protected final int cwA()
  {
    AppMethodBeat.i(25263);
    if (bt.isNullOrNil(this.ssid))
    {
      ad.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
      AppMethodBeat.o(25263);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cvY().aaI(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25263);
      return i;
    }
    AppMethodBeat.o(25263);
    return 0;
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
    AppMethodBeat.i(25258);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.rjA = getIntent().getStringExtra("free_wifi_mid");
    this.nha = getIntent().getStringExtra("free_wifi_url");
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    this.cJR = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.dlB = getIntent().getStringExtra("free_wifi_appid");
    this.gLg = getIntent().getStringExtra("free_wifi_head_img_url");
    this.rkp = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.rkq = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.rkr = getIntent().getStringExtra("free_wifi_privacy_url");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), this.ssid, this.rjA, this.nha, Integer.valueOf(this.dep), Integer.valueOf(this.cJR), this.dlB, this.gLg, this.rkp, this.rkr });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25237);
        ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this);
        AppMethodBeat.o(25237);
        return true;
      }
    });
    findViewById(2131306245).setVisibility(0);
    this.rki = ((ImageView)findViewById(2131300246));
    this.rkj = ((TextView)findViewById(2131300289));
    this.rkk = ((TextView)findViewById(2131300275));
    this.rjT = ((TextView)findViewById(2131300253));
    this.rkl = ((Button)findViewById(2131298576));
    this.rkl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25238);
        com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cvP(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeTwoUI.this.cwA();
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(i) });
        if (i == 2)
        {
          ProtocolThreeTwoUI.this.finish();
          AppMethodBeat.o(25238);
          return;
        }
        com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
        ProtocolThreeTwoUI.this.connect();
        AppMethodBeat.o(25238);
      }
    });
    this.rkm = ((Button)findViewById(2131306246));
    this.rkm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25239);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", ProtocolThreeTwoUI.this.rkr);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(ProtocolThreeTwoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25239);
      }
    });
    if (bt.isNullOrNil(this.ssid))
    {
      this.rkk.setText(getString(2131759651));
      this.rkl.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25258);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25257);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    this.openId = getIntent().getStringExtra("free_wifi_openid");
    this.riG = getIntent().getStringExtra("free_wifi_tid");
    this.cMo = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), this.ddU });
    initView();
    if (bt.isNullOrNil(this.ssid))
    {
      ad.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.L(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25257);
      return;
    }
    paramBundle = j.cvY().aaI(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = ai.du(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nha;
      paramBundle.field_mid = this.rjA;
      paramBundle.field_wifiType = 32;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cvY().insert(paramBundle);
      }
      for (;;)
      {
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.rjA, Integer.valueOf(this.dep) });
        this.rjG = new com.tencent.mm.sdk.e.k.a()
        {
          private int rlu = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25240);
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cwA());
            if (this.rlu != ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this))
            {
              this.rlu = ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this);
              ProtocolThreeTwoUI.this.Dz(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this));
            }
            AppMethodBeat.o(25240);
          }
        };
        j.cvY().add(this.rjG);
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cvY().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25265);
    super.onDestroy();
    if (this.rjG != null) {
      j.cvY().remove(this.rjG);
    }
    this.rlN.stopTimer();
    j.cwb().release();
    AppMethodBeat.o(25265);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25261);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25261);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25261);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI
 * JD-Core Version:    0.7.0.1
 */