package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.a.a.a;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI
  extends MMActivity
{
  protected int cJR;
  private boolean cOA;
  private String ddU;
  protected int dep;
  private int dgF;
  private String dgo;
  protected String dkB;
  protected String dlB;
  protected String gLg;
  private final com.tencent.mm.aw.a.a.c hjG;
  private Intent intent;
  protected String nha;
  protected String ril;
  private String riu;
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
  protected String signature;
  protected String ssid;
  
  public ProtocolThreeOneUI()
  {
    AppMethodBeat.i(25194);
    this.dgF = 1;
    this.riv = 0;
    this.cOA = false;
    this.rlN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25181);
        if (!bt.isNullOrNil(ProtocolThreeOneUI.this.ssid))
        {
          ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cwA());
          if (ProtocolThreeOneUI.a(ProtocolThreeOneUI.this) != 2)
          {
            ProtocolThreeOneUI.b(ProtocolThreeOneUI.this);
            ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
          }
        }
        AppMethodBeat.o(25181);
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
    AppMethodBeat.o(25194);
  }
  
  private void ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(25202);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cvq();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.aav("MicroMsg.FreeWifi.Protocol31UI");
    locala.ddV = com.tencent.mm.plugin.freewifi.m.aaw("MicroMsg.FreeWifi.Protocol31UI");
    locala.ddU = this.ddU;
    locala.rfK = this.dlB;
    locala.nSA = com.tencent.mm.plugin.freewifi.m.ai(this.intent);
    locala.rfL = com.tencent.mm.plugin.freewifi.m.ak(this.intent);
    locala.rfM = k.b.rgn.rgx;
    locala.rfN = k.b.rgn.name;
    locala.result = paramInt;
    locala.foR = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.al(this.intent);
    locala.rfO = this.dkB;
    locala.cvs().cvr();
    AppMethodBeat.o(25202);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25200);
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.hYt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25200);
  }
  
  protected final void Dz(int paramInt)
  {
    AppMethodBeat.i(25198);
    ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25198);
      return;
    case 4: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rlN.stopTimer();
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757574);
      if ((com.tencent.mm.plugin.freewifi.m.al(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.dq(ae.fFB.fEN)) && (!com.tencent.mm.plugin.freewifi.m.dq(ae.bW(getContext())))) {
        this.rkl.setText(String.format(getString(2131759610), new Object[] { ae.bW(getContext()) }));
      }
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
        ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        AppMethodBeat.o(25198);
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
      this.rll = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25193);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
          ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25193);
        }
      });
      ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    case 3: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rlN.stopTimer();
      this.rjT.setVisibility(0);
      this.rkl.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25198);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.rls);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25197);
    this.dgF = cwA();
    ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(this.dgF) });
    if (this.dgF != 2)
    {
      this.rlN.av(15000L, 15000L);
      ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(60) });
      final String str = this.riu;
      j.cwb().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25188);
          ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), str });
          com.tencent.mm.plugin.freewifi.a.a.cvy();
          com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(25186);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i) });
              if (ProtocolThreeOneUI.d(ProtocolThreeOneUI.this))
              {
                AppMethodBeat.o(25186);
                return;
              }
              if (i == 200)
              {
                ProtocolThreeOneUI.e(ProtocolThreeOneUI.this);
                AppMethodBeat.o(25186);
                return;
              }
              if (i == 302)
              {
                paramAnonymous2HttpURLConnection = paramAnonymous2HttpURLConnection.getHeaderField("Location");
                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, paramAnonymous2HttpURLConnection);
                AppMethodBeat.o(25186);
                return;
              }
              ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())) });
              com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
              ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
              AppMethodBeat.o(25186);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(25187);
              ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
              com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
              ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 101, com.tencent.mm.plugin.freewifi.m.l(paramAnonymous2Exception));
              AppMethodBeat.o(25187);
            }
          });
          AppMethodBeat.o(25188);
        }
      });
      AppMethodBeat.o(25197);
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(25197);
  }
  
  protected final int cwA()
  {
    AppMethodBeat.i(25201);
    if (bt.isNullOrNil(this.ssid))
    {
      ad.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
      AppMethodBeat.o(25201);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cvY().aaI(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25201);
      return i;
    }
    AppMethodBeat.o(25201);
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
    AppMethodBeat.i(25196);
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
    ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), this.ssid, this.rjA, this.nha, Integer.valueOf(this.dep), Integer.valueOf(this.cJR), this.dlB, this.gLg, this.rkp, this.rkr });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25182);
        ProtocolThreeOneUI.c(ProtocolThreeOneUI.this);
        AppMethodBeat.o(25182);
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
        AppMethodBeat.i(25183);
        com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cvP(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeOneUI.this.cwA();
        ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(i) });
        if (i == 2)
        {
          ProtocolThreeOneUI.this.finish();
          AppMethodBeat.o(25183);
          return;
        }
        com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
        ProtocolThreeOneUI.this.connect();
        AppMethodBeat.o(25183);
      }
    });
    this.rkm = ((Button)findViewById(2131306246));
    this.rkm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25184);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", ProtocolThreeOneUI.this.rkr);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(ProtocolThreeOneUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25184);
      }
    });
    if (bt.isNullOrNil(this.ssid))
    {
      this.rkk.setText(getString(2131759651));
      this.rkl.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25195);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    this.dgo = getIntent().getStringExtra("free_wifi_schema_ticket");
    this.riu = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), this.ddU, this.dgo });
    initView();
    if (bt.isNullOrNil(this.ssid))
    {
      ad.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.L(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25195);
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
      paramBundle.field_wifiType = 3;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cvY().insert(paramBundle);
      }
      for (;;)
      {
        ad.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.rjA, Integer.valueOf(this.dep) });
        this.rjG = new com.tencent.mm.sdk.e.k.a()
        {
          private int rlu = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25185);
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cwA());
            if (this.rlu != ProtocolThreeOneUI.a(ProtocolThreeOneUI.this))
            {
              this.rlu = ProtocolThreeOneUI.a(ProtocolThreeOneUI.this);
              ProtocolThreeOneUI.this.Dz(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this));
            }
            AppMethodBeat.o(25185);
          }
        };
        j.cvY().add(this.rjG);
        ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ad.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cvY().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25203);
    super.onDestroy();
    if (this.rjG != null) {
      j.cvY().remove(this.rjG);
    }
    this.rlN.stopTimer();
    j.cwb().release();
    AppMethodBeat.o(25203);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25199);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25199);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25199);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI
 * JD-Core Version:    0.7.0.1
 */