package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
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
public class ProtocolThreeThreeUI
  extends MMActivity
{
  protected String appId;
  protected String bssid;
  protected int cSM;
  protected String cVJ;
  protected int doj;
  private int dqB;
  protected String duJ;
  protected String sign;
  protected String signature;
  protected String ssid;
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
  private int tyH;
  protected String tyK;
  protected String tyL;
  protected String tyM;
  private Uri tyN;
  private String tyO;
  protected String tyx;
  private k.a tzS;
  
  public ProtocolThreeThreeUI()
  {
    AppMethodBeat.i(25221);
    this.dqB = 1;
    this.tyH = 0;
    this.tBZ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25208);
        if (!bu.isNullOrNil(ProtocolThreeThreeUI.this.ssid))
        {
          ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.cUG());
          if (ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this) != 2)
          {
            ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this)) });
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
    l.R(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iUz.h(localIntent, this);
    finish();
    AppMethodBeat.o(25227);
  }
  
  protected final void Hh(int paramInt)
  {
    AppMethodBeat.i(25225);
    ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25225);
      return;
    case 4: 
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tBZ.stopTimer();
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757574);
      if (this.doj == 3) {
        this.tAw.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      for (;;)
      {
        ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
        AppMethodBeat.o(25225);
        return;
        this.tAw.setText(getString(2131757572, new Object[] { this.ssid }));
      }
    case 1: 
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757571);
      this.tBx = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25220);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
          ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25220);
        }
      });
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    case 3: 
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tBZ.stopTimer();
      this.tAf.setVisibility(0);
      this.tAx.setText(2131759649);
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    }
    if (this.tBx != null) {
      this.tBx.dismiss();
    }
    this.tBZ.stopTimer();
    this.tAx.setText(2131757568);
    this.tAx.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.appId);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.tBE);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final int cUG()
  {
    AppMethodBeat.i(25228);
    if (bu.isNullOrNil(this.ssid))
    {
      ae.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
      AppMethodBeat.o(25228);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cUe().akW(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25228);
      return i;
    }
    AppMethodBeat.o(25228);
    return 0;
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25224);
    if (com.tencent.mm.plugin.freewifi.m.ef(this.ssid))
    {
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.ef(this.tyL))
    {
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    this.dqB = cUG();
    ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(this.dqB) });
    if (this.dqB != 2)
    {
      this.tBZ.ay(30000L, 30000L);
      ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), Integer.valueOf(60) });
      com.tencent.mm.plugin.freewifi.m.ef(this.tyL);
      Object localObject = new StringBuilder(this.tyL);
      if (this.tyL.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?extend=").append(this.tyM);
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        j.cUh().cTQ().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25215);
            ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), this.val$url });
            com.tencent.mm.plugin.freewifi.a.a.cTE();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
            {
              public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
              {
                AppMethodBeat.i(25213);
                int i = paramAnonymous2HttpURLConnection.getResponseCode();
                ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i) });
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
                ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())) });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25213);
              }
              
              public final void o(Exception paramAnonymous2Exception)
              {
                AppMethodBeat.i(25214);
                ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25214);
              }
            });
            AppMethodBeat.o(25215);
          }
        });
        AppMethodBeat.o(25224);
        return;
        ((StringBuilder)localObject).append("&extend=").append(this.tyM);
      }
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(25224);
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
    this.ssid = com.tencent.mm.plugin.freewifi.m.akI("MicroMsg.FreeWifi.Protocol33UI");
    this.bssid = com.tencent.mm.plugin.freewifi.m.akJ("MicroMsg.FreeWifi.Protocol33UI");
    this.doj = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSM = getIntent().getIntExtra("free_wifi_channel_id", 0);
    setBackBtn(new ProtocolThreeThreeUI.2(this));
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
        AppMethodBeat.i(25210);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        l.Q(com.tencent.mm.plugin.freewifi.model.d.cTV(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeThreeUI.this.cUG();
        ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Hf(i) });
        if (i == 2) {
          ProtocolThreeThreeUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25210);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
          ProtocolThreeThreeUI.this.connect();
        }
      }
    });
    this.tAy = ((Button)findViewById(2131306246));
    this.tAy.setOnClickListener(new ProtocolThreeThreeUI.4(this));
    if (bu.isNullOrNil(this.ssid))
    {
      this.tAw.setText(getString(2131759651));
      this.tAx.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25222);
    super.onCreate(paramBundle);
    this.tyO = getIntent().getStringExtra("free_wifi_schema_uri");
    this.tyN = Uri.parse(this.tyO);
    this.appId = this.tyN.getQueryParameter("appId");
    this.tyK = this.tyN.getQueryParameter("shopId");
    this.tyL = this.tyN.getQueryParameter("authUrl");
    this.tyM = this.tyN.getQueryParameter("extend");
    this.cVJ = this.tyN.getQueryParameter("timestamp");
    this.sign = this.tyN.getQueryParameter("sign");
    ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), this.tyO });
    initView();
    if (bu.isNullOrNil(this.ssid))
    {
      ae.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
      l.P(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25222);
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
      paramBundle.field_url = "";
      paramBundle.field_mid = "";
      paramBundle.field_wifiType = 33;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cUe().insert(paramBundle);
      }
      for (;;)
      {
        ae.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, "", Integer.valueOf(this.doj) });
        this.tzS = new k.a()
        {
          private int tBG = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25212);
            ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.cUG());
            if (this.tBG != ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this))
            {
              this.tBG = ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this);
              ProtocolThreeThreeUI.this.Hh(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this));
            }
            AppMethodBeat.o(25212);
          }
        };
        j.cUe().add(this.tzS);
        ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ae.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cUe().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25229);
    super.onDestroy();
    if (this.tzS != null) {
      j.cUe().remove(this.tzS);
    }
    this.tBZ.stopTimer();
    j.cUh().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI
 * JD-Core Version:    0.7.0.1
 */