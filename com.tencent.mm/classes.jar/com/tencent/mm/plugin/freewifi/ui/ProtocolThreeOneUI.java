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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI
  extends MMActivity
{
  protected int cGY;
  private boolean cLV;
  protected int dbL;
  private String dbq;
  private String ddJ;
  private int dea;
  protected String dia;
  protected String djj;
  private final com.tencent.mm.av.a.a.c hKj;
  protected String hlG;
  private Intent intent;
  protected String nJQ;
  protected String signature;
  protected String sre;
  private String srn;
  private int sro;
  private TextView ssM;
  protected String ssid;
  protected String sst;
  private com.tencent.mm.sdk.e.k.a ssz;
  private ImageView stb;
  private TextView stc;
  private TextView std;
  private Button ste;
  private Button stf;
  protected String sti;
  protected String stj;
  protected String stk;
  private au suH;
  private p sue;
  protected int suj;
  protected String suk;
  protected String sul;
  
  public ProtocolThreeOneUI()
  {
    AppMethodBeat.i(25194);
    this.dea = 1;
    this.sro = 0;
    this.cLV = false;
    this.suH = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25181);
        if (!bs.isNullOrNil(ProtocolThreeOneUI.this.ssid))
        {
          ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cJM());
          if (ProtocolThreeOneUI.a(ProtocolThreeOneUI.this) != 2)
          {
            ProtocolThreeOneUI.b(ProtocolThreeOneUI.this);
            ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
          }
        }
        AppMethodBeat.o(25181);
        return false;
      }
    }, false);
    c.a locala = new c.a();
    locala.hKv = true;
    locala.hKw = true;
    locala.hKI = 2131232428;
    locala.gLt = true;
    locala.hKP = 0.0F;
    this.hKj = locala.aFT();
    AppMethodBeat.o(25194);
  }
  
  private void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(25202);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cIC();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.afn("MicroMsg.FreeWifi.Protocol31UI");
    locala.dbr = com.tencent.mm.plugin.freewifi.m.afo("MicroMsg.FreeWifi.Protocol31UI");
    locala.dbq = this.dbq;
    locala.soC = this.djj;
    locala.ovU = com.tencent.mm.plugin.freewifi.m.aj(this.intent);
    locala.soD = com.tencent.mm.plugin.freewifi.m.al(this.intent);
    locala.soE = k.b.spf.spp;
    locala.soF = k.b.spf.name;
    locala.result = paramInt;
    locala.fsq = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.am(this.intent);
    locala.soG = this.dia;
    locala.cIE().cID();
    AppMethodBeat.o(25202);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25200);
    com.tencent.mm.plugin.freewifi.l.O(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.iyx.h(localIntent, this);
    finish();
    AppMethodBeat.o(25200);
  }
  
  protected final void Fv(int paramInt)
  {
    AppMethodBeat.i(25198);
    ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25198);
      return;
    case 4: 
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.suH.stopTimer();
      this.ssM.setVisibility(4);
      this.ste.setText(2131757574);
      if ((com.tencent.mm.plugin.freewifi.m.am(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.cX(ae.fJi.fIu)) && (!com.tencent.mm.plugin.freewifi.m.cX(ae.bZ(getContext())))) {
        this.ste.setText(String.format(getString(2131759610), new Object[] { ae.bZ(getContext()) }));
      }
      if (this.dbL == 3) {
        this.std.setText(getString(2131761229, new Object[] { this.ssid }));
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
        ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
        AppMethodBeat.o(25198);
        return;
        if (bs.isNullOrNil(this.stj)) {
          this.std.setText(getString(2131757570));
        } else {
          this.std.setText(this.stj);
        }
      }
    case 1: 
      this.ssM.setVisibility(4);
      this.ste.setText(2131757571);
      this.sue = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25193);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
          ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25193);
        }
      });
      ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    case 3: 
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.suH.stopTimer();
      this.ssM.setVisibility(0);
      this.ste.setText(2131759649);
      ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    }
    if (this.sue != null) {
      this.sue.dismiss();
    }
    this.suH.stopTimer();
    this.ste.setText(2131757568);
    this.ste.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.djj);
    ((Intent)localObject).putExtra("free_wifi_app_nickname", this.sre);
    ((Intent)localObject).putExtra("free_wifi_app_username", this.dia);
    ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
    ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.suj);
    ((Intent)localObject).putExtra("free_wifi_finish_url", this.suk);
    if (bs.isNullOrNil(this.sul)) {
      ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      finish();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.sul);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final int cJM()
  {
    AppMethodBeat.i(25201);
    if (bs.isNullOrNil(this.ssid))
    {
      ac.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
      AppMethodBeat.o(25201);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cJk().afA(this.ssid);
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
    this.dea = cJM();
    ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(this.dea) });
    if (this.dea != 2)
    {
      this.suH.au(15000L, 15000L);
      ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), Integer.valueOf(60) });
      final String str = this.srn;
      j.cJn().cIW().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25188);
          ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), str });
          com.tencent.mm.plugin.freewifi.a.a.cIK();
          com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(25186);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i) });
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
              ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())) });
              com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
              ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
              AppMethodBeat.o(25186);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(25187);
              ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
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
    this.sst = getIntent().getStringExtra("free_wifi_mid");
    this.nJQ = getIntent().getStringExtra("free_wifi_url");
    this.dbL = getIntent().getIntExtra("free_wifi_source", 1);
    this.cGY = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.djj = getIntent().getStringExtra("free_wifi_appid");
    this.hlG = getIntent().getStringExtra("free_wifi_head_img_url");
    this.sti = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.stj = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.stk = getIntent().getStringExtra("free_wifi_privacy_url");
    this.sre = getIntent().getStringExtra("free_wifi_app_nickname");
    ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), this.ssid, this.sst, this.nJQ, Integer.valueOf(this.dbL), Integer.valueOf(this.cGY), this.djj, this.hlG, this.sti, this.stk });
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
    this.stb = ((ImageView)findViewById(2131300246));
    this.stc = ((TextView)findViewById(2131300289));
    this.std = ((TextView)findViewById(2131300275));
    this.ssM = ((TextView)findViewById(2131300253));
    this.ste = ((Button)findViewById(2131298576));
    this.ste.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25183);
        com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cJb(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeOneUI.this.cJM();
        ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(i) });
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
    this.stf = ((Button)findViewById(2131306246));
    this.stf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25184);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", ProtocolThreeOneUI.this.stk);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(ProtocolThreeOneUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25184);
      }
    });
    if (bs.isNullOrNil(this.ssid))
    {
      this.std.setText(getString(2131759651));
      this.ste.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25195);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dbq = getIntent().getStringExtra("free_wifi_ap_key");
    this.ddJ = getIntent().getStringExtra("free_wifi_schema_ticket");
    this.srn = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), this.dbq, this.ddJ });
    initView();
    if (bs.isNullOrNil(this.ssid))
    {
      ac.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25195);
      return;
    }
    paramBundle = j.cJk().afA(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = ah.dg(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nJQ;
      paramBundle.field_mid = this.sst;
      paramBundle.field_wifiType = 3;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cJk().insert(paramBundle);
      }
      for (;;)
      {
        ac.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.sst, Integer.valueOf(this.dbL) });
        this.ssz = new com.tencent.mm.sdk.e.k.a()
        {
          private int suo = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25185);
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.cJM());
            if (this.suo != ProtocolThreeOneUI.a(ProtocolThreeOneUI.this))
            {
              this.suo = ProtocolThreeOneUI.a(ProtocolThreeOneUI.this);
              ProtocolThreeOneUI.this.Fv(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this));
            }
            AppMethodBeat.o(25185);
          }
        };
        j.cJk().add(this.ssz);
        ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ac.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cJk().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25203);
    super.onDestroy();
    if (this.ssz != null) {
      j.cJk().remove(this.ssz);
    }
    this.suH.stopTimer();
    j.cJn().release();
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