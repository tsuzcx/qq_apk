package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI
  extends MMActivity
{
  protected int cSM;
  private boolean cYg;
  private String dnO;
  protected int doj;
  private int dqB;
  private String dqk;
  protected String duJ;
  protected String dwb;
  protected String hGI;
  private final com.tencent.mm.av.a.a.c ifW;
  private Intent intent;
  protected String osm;
  protected String signature;
  protected String ssid;
  protected String tAB;
  protected String tAC;
  protected String tAD;
  private TextView tAf;
  private ImageView tAu;
  private TextView tAv;
  private TextView tAw;
  private Button tAx;
  private Button tAy;
  protected int tBC;
  protected String tBD;
  protected String tBE;
  private aw tBZ;
  private p tBx;
  private String tyG;
  private int tyH;
  protected String tyx;
  protected String tzM;
  private com.tencent.mm.sdk.e.k.a tzS;
  
  public ProtocolThreeOneUI()
  {
    AppMethodBeat.i(25194);
    this.dqB = 1;
    this.tyH = 0;
    this.cYg = false;
    this.tBZ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25181);
        if (!bu.isNullOrNil(ProtocolThreeOneUI.this.ssid))
        {
          ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cUG());
          if (ProtocolThreeOneUI.a(ProtocolThreeOneUI.this) != 2)
          {
            ProtocolThreeOneUI.b(ProtocolThreeOneUI.this);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
          }
        }
        AppMethodBeat.o(25181);
        return false;
      }
    }, false);
    c.a locala = new c.a();
    locala.igi = true;
    locala.igj = true;
    locala.igv = 2131232428;
    locala.hhW = true;
    locala.igC = 0.0F;
    this.ifW = locala.aJu();
    AppMethodBeat.o(25194);
  }
  
  private void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(25202);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cTw();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.akJ("MicroMsg.FreeWifi.Protocol31UI");
    locala.dnP = com.tencent.mm.plugin.freewifi.m.akK("MicroMsg.FreeWifi.Protocol31UI");
    locala.dnO = this.dnO;
    locala.tvX = this.dwb;
    locala.pfT = com.tencent.mm.plugin.freewifi.m.ap(this.intent);
    locala.tvY = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    locala.tvZ = k.b.twA.twK;
    locala.twa = k.b.twA.name;
    locala.result = paramInt;
    locala.fMT = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.as(this.intent);
    locala.twb = this.duJ;
    locala.cTy().cTx();
    AppMethodBeat.o(25202);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25200);
    l.R(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iUz.h(localIntent, this);
    finish();
    AppMethodBeat.o(25200);
  }
  
  protected final void Hh(int paramInt)
  {
    AppMethodBeat.i(25198);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25198);
      return;
    case 4: 
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tBZ.stopTimer();
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757574);
      if ((com.tencent.mm.plugin.freewifi.m.as(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.ef(com.tencent.mm.compatible.deviceinfo.ae.geR.gec)) && (!com.tencent.mm.plugin.freewifi.m.ef(com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext())))) {
        this.tAx.setText(String.format(getString(2131759610), new Object[] { com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext()) }));
      }
      if (this.doj == 3) {
        this.tAw.setText(getString(2131761229, new Object[] { this.ssid }));
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
        AppMethodBeat.o(25198);
        return;
        if (bu.isNullOrNil(this.tAC)) {
          this.tAw.setText(getString(2131757570));
        } else {
          this.tAw.setText(this.tAC);
        }
      }
    case 1: 
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757571);
      this.tBx = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25193);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25193);
        }
      });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    case 3: 
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tBZ.stopTimer();
      this.tAf.setVisibility(0);
      this.tAx.setText(2131759649);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    }
    if (this.tBx != null) {
      this.tBx.dismiss();
    }
    this.tBZ.stopTimer();
    this.tAx.setText(2131757568);
    this.tAx.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.dwb);
    ((Intent)localObject).putExtra("free_wifi_app_nickname", this.tyx);
    ((Intent)localObject).putExtra("free_wifi_app_username", this.duJ);
    ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
    ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.tBC);
    ((Intent)localObject).putExtra("free_wifi_finish_url", this.tBD);
    if (bu.isNullOrNil(this.tBE)) {
      ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      finish();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.tBE);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final int cUG()
  {
    AppMethodBeat.i(25201);
    if (bu.isNullOrNil(this.ssid))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
      AppMethodBeat.o(25201);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cUe().akW(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25201);
      return i;
    }
    AppMethodBeat.o(25201);
    return 0;
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25197);
    this.dqB = cUG();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(this.dqB) });
    if (this.dqB != 2)
    {
      this.tBZ.ay(15000L, 15000L);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), Integer.valueOf(60) });
      final String str = this.tyG;
      j.cUh().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25188);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), str });
          com.tencent.mm.plugin.freewifi.a.a.cTE();
          com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(25186);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i) });
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
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())) });
              com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
              ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
              AppMethodBeat.o(25186);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(25187);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
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
    this.tzM = getIntent().getStringExtra("free_wifi_mid");
    this.osm = getIntent().getStringExtra("free_wifi_url");
    this.doj = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSM = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.dwb = getIntent().getStringExtra("free_wifi_appid");
    this.hGI = getIntent().getStringExtra("free_wifi_head_img_url");
    this.tAB = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.tAC = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.tAD = getIntent().getStringExtra("free_wifi_privacy_url");
    this.tyx = getIntent().getStringExtra("free_wifi_app_nickname");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.ssid, this.tzM, this.osm, Integer.valueOf(this.doj), Integer.valueOf(this.cSM), this.dwb, this.hGI, this.tAB, this.tAD });
    setBackBtn(new ProtocolThreeOneUI.2(this));
    findViewById(2131306245).setVisibility(0);
    this.tAu = ((ImageView)findViewById(2131300246));
    this.tAv = ((TextView)findViewById(2131300289));
    this.tAw = ((TextView)findViewById(2131300275));
    this.tAf = ((TextView)findViewById(2131300253));
    this.tAx = ((Button)findViewById(2131298576));
    this.tAx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25183);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        l.Q(com.tencent.mm.plugin.freewifi.model.d.cTV(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeOneUI.this.cUG();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(i) });
        if (i == 2) {
          ProtocolThreeOneUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25183);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
          ProtocolThreeOneUI.this.connect();
        }
      }
    });
    this.tAy = ((Button)findViewById(2131306246));
    this.tAy.setOnClickListener(new ProtocolThreeOneUI.4(this));
    if (bu.isNullOrNil(this.ssid))
    {
      this.tAw.setText(getString(2131759651));
      this.tAx.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25195);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dnO = getIntent().getStringExtra("free_wifi_ap_key");
    this.dqk = getIntent().getStringExtra("free_wifi_schema_ticket");
    this.tyG = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.dnO, this.dqk });
    initView();
    if (bu.isNullOrNil(this.ssid))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
      l.P(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25195);
      return;
    }
    paramBundle = j.cUe().akW(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = aj.ej(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.osm;
      paramBundle.field_mid = this.tzM;
      paramBundle.field_wifiType = 3;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cUe().insert(paramBundle);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.tzM, Integer.valueOf(this.doj) });
        this.tzS = new com.tencent.mm.sdk.e.k.a()
        {
          private int tBG = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25185);
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cUG());
            if (this.tBG != ProtocolThreeOneUI.a(ProtocolThreeOneUI.this))
            {
              this.tBG = ProtocolThreeOneUI.a(ProtocolThreeOneUI.this);
              ProtocolThreeOneUI.this.Hh(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this));
            }
            AppMethodBeat.o(25185);
          }
        };
        j.cUe().add(this.tzS);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cUe().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25203);
    super.onDestroy();
    if (this.tzS != null) {
      j.cUe().remove(this.tzS);
    }
    this.tBZ.stopTimer();
    j.cUh().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI
 * JD-Core Version:    0.7.0.1
 */