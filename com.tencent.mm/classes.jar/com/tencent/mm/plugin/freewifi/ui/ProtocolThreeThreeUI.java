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
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.e.k.a;
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
public class ProtocolThreeThreeUI
  extends MMActivity
{
  protected String appId;
  protected String bssid;
  protected int cJR;
  protected String cMo;
  protected int dep;
  private int dgF;
  protected String dkB;
  protected String riA;
  private Uri riB;
  private String riC;
  protected String ril;
  private int riv;
  protected String riy;
  protected String riz;
  private k.a rjG;
  private TextView rjT;
  private ImageView rki;
  private TextView rkj;
  private TextView rkk;
  private Button rkl;
  private Button rkm;
  private av rlN;
  private p rll;
  protected int rlq;
  protected String rlr;
  protected String rls;
  protected String sign;
  protected String signature;
  protected String ssid;
  
  public ProtocolThreeThreeUI()
  {
    AppMethodBeat.i(25221);
    this.dgF = 1;
    this.riv = 0;
    this.rlN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25208);
        if (!bt.isNullOrNil(ProtocolThreeThreeUI.this.ssid))
        {
          ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.cwA());
          if (ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this) != 2)
          {
            ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
          }
        }
        AppMethodBeat.o(25208);
        return false;
      }
    }, false);
    AppMethodBeat.o(25221);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25227);
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.hYt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25227);
  }
  
  protected final void Dz(int paramInt)
  {
    AppMethodBeat.i(25225);
    ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25225);
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
        ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        AppMethodBeat.o(25225);
        return;
        this.rkk.setText(getString(2131757572, new Object[] { this.ssid }));
      }
    case 1: 
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757571);
      this.rll = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25220);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
          ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25220);
        }
      });
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    case 3: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rlN.stopTimer();
      this.rjT.setVisibility(0);
      this.rkl.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    }
    if (this.rll != null) {
      this.rll.dismiss();
    }
    this.rlN.stopTimer();
    this.rkl.setText(2131757568);
    this.rkl.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.appId);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.rls);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25224);
    if (com.tencent.mm.plugin.freewifi.m.dq(this.ssid))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.dq(this.riz))
    {
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    this.dgF = cwA();
    ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(this.dgF) });
    if (this.dgF != 2)
    {
      this.rlN.av(30000L, 30000L);
      ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), Integer.valueOf(60) });
      com.tencent.mm.plugin.freewifi.m.dq(this.riz);
      Object localObject = new StringBuilder(this.riz);
      if (this.riz.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?extend=").append(this.riA);
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        j.cwb().cvK().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25215);
            ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), this.val$url });
            com.tencent.mm.plugin.freewifi.a.a.cvy();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
            {
              public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
              {
                AppMethodBeat.i(25213);
                int i = paramAnonymous2HttpURLConnection.getResponseCode();
                ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i) });
                if (i == 200)
                {
                  ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.this);
                  AppMethodBeat.o(25213);
                  return;
                }
                if (i == 302)
                {
                  paramAnonymous2HttpURLConnection = paramAnonymous2HttpURLConnection.getHeaderField("Location");
                  ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, paramAnonymous2HttpURLConnection);
                  AppMethodBeat.o(25213);
                  return;
                }
                ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())) });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25213);
              }
              
              public final void o(Exception paramAnonymous2Exception)
              {
                AppMethodBeat.i(25214);
                ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25214);
              }
            });
            AppMethodBeat.o(25215);
          }
        });
        AppMethodBeat.o(25224);
        return;
        ((StringBuilder)localObject).append("&extend=").append(this.riA);
      }
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(25224);
  }
  
  protected final int cwA()
  {
    AppMethodBeat.i(25228);
    if (bt.isNullOrNil(this.ssid))
    {
      ad.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
      AppMethodBeat.o(25228);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cvY().aaI(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25228);
      return i;
    }
    AppMethodBeat.o(25228);
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
    AppMethodBeat.i(25223);
    this.ssid = com.tencent.mm.plugin.freewifi.m.aau("MicroMsg.FreeWifi.Protocol33UI");
    this.bssid = com.tencent.mm.plugin.freewifi.m.aav("MicroMsg.FreeWifi.Protocol33UI");
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    this.cJR = getIntent().getIntExtra("free_wifi_channel_id", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25209);
        ProtocolThreeThreeUI.b(ProtocolThreeThreeUI.this);
        AppMethodBeat.o(25209);
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
        AppMethodBeat.i(25210);
        com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cvP(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeThreeUI.this.cwA();
        ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Dx(i) });
        if (i == 2)
        {
          ProtocolThreeThreeUI.this.finish();
          AppMethodBeat.o(25210);
          return;
        }
        com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
        ProtocolThreeThreeUI.this.connect();
        AppMethodBeat.o(25210);
      }
    });
    this.rkm = ((Button)findViewById(2131306246));
    this.rkm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25211);
        AppMethodBeat.o(25211);
      }
    });
    if (bt.isNullOrNil(this.ssid))
    {
      this.rkk.setText(getString(2131759651));
      this.rkl.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25222);
    super.onCreate(paramBundle);
    this.riC = getIntent().getStringExtra("free_wifi_schema_uri");
    this.riB = Uri.parse(this.riC);
    this.appId = this.riB.getQueryParameter("appId");
    this.riy = this.riB.getQueryParameter("shopId");
    this.riz = this.riB.getQueryParameter("authUrl");
    this.riA = this.riB.getQueryParameter("extend");
    this.cMo = this.riB.getQueryParameter("timestamp");
    this.sign = this.riB.getQueryParameter("sign");
    ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), this.riC });
    initView();
    if (bt.isNullOrNil(this.ssid))
    {
      ad.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.L(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25222);
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
      paramBundle.field_url = "";
      paramBundle.field_mid = "";
      paramBundle.field_wifiType = 33;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cvY().insert(paramBundle);
      }
      for (;;)
      {
        ad.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, "", Integer.valueOf(this.dep) });
        this.rjG = new k.a()
        {
          private int rlu = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25212);
            ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.cwA());
            if (this.rlu != ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this))
            {
              this.rlu = ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this);
              ProtocolThreeThreeUI.this.Dz(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this));
            }
            AppMethodBeat.o(25212);
          }
        };
        j.cvY().add(this.rjG);
        ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ad.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ai(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aj(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cvY().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25229);
    super.onDestroy();
    if (this.rjG != null) {
      j.cvY().remove(this.rjG);
    }
    this.rlN.stopTimer();
    j.cwb().release();
    AppMethodBeat.o(25229);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25226);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25226);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25226);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI
 * JD-Core Version:    0.7.0.1
 */