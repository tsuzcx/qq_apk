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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.freewifi.h.b;
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
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI
  extends MMActivity
{
  protected int cGY;
  private String cJz;
  protected int dbL;
  private String dbq;
  private int dea;
  protected String dia;
  protected String djj;
  private final com.tencent.mm.av.a.a.c hKj;
  protected String hlG;
  private Intent intent;
  protected String nJQ;
  private String openId;
  private String sign;
  protected String signature;
  protected String sre;
  private com.tencent.mm.plugin.freewifi.a sri;
  private int sro;
  private String srz;
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
  
  public ProtocolThreeTwoUI()
  {
    AppMethodBeat.i(25256);
    this.dea = 1;
    this.sro = 0;
    this.suH = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25233);
        if (!bs.isNullOrNil(ProtocolThreeTwoUI.this.ssid))
        {
          ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cJM());
          if (ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this) != 2)
          {
            ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
          }
        }
        AppMethodBeat.o(25233);
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
    AppMethodBeat.o(25256);
  }
  
  private void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(25264);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cIC();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.afn("MicroMsg.FreeWifi.Protocol32UI");
    locala.dbr = com.tencent.mm.plugin.freewifi.m.afo("MicroMsg.FreeWifi.Protocol32UI");
    locala.dbq = this.dbq;
    locala.soC = this.djj;
    locala.ovU = com.tencent.mm.plugin.freewifi.m.aj(this.intent);
    locala.soD = com.tencent.mm.plugin.freewifi.m.al(this.intent);
    locala.soE = k.b.spg.spp;
    locala.soF = k.b.spg.name;
    locala.result = paramInt;
    locala.fsq = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.am(this.intent);
    locala.soG = this.dia;
    locala.cIE().cID();
    AppMethodBeat.o(25264);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25262);
    com.tencent.mm.plugin.freewifi.l.O(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.iyx.h(localIntent, this);
    finish();
    AppMethodBeat.o(25262);
  }
  
  protected final void Fv(int paramInt)
  {
    AppMethodBeat.i(25260);
    ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25260);
      return;
    case 4: 
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.suH.stopTimer();
      this.ssM.setVisibility(4);
      this.ste.setText(2131757574);
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
        ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
        AppMethodBeat.o(25260);
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
      this.sue = com.tencent.mm.ui.base.h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25236);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
          ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25236);
        }
      });
      ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    case 3: 
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.suH.stopTimer();
      this.ssM.setVisibility(0);
      this.ste.setText(2131759649);
      ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      AppMethodBeat.o(25260);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.sul);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final int cJM()
  {
    AppMethodBeat.i(25263);
    if (bs.isNullOrNil(this.ssid))
    {
      ac.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
      AppMethodBeat.o(25263);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cJk().afA(this.ssid);
    if ((localc != null) && (localc.field_ssid.equalsIgnoreCase(this.ssid)))
    {
      int i = localc.field_connectState;
      AppMethodBeat.o(25263);
      return i;
    }
    AppMethodBeat.o(25263);
    return 0;
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25259);
    this.dea = cJM();
    ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(this.dea) });
    if (this.dea != 2)
    {
      this.suH.au(45000L, 45000L);
      ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), Integer.valueOf(60) });
      this.sri = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
      j.cJn().cIW().post(new Runnable()
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
    ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), this.ssid, this.sst, this.nJQ, Integer.valueOf(this.dbL), Integer.valueOf(this.cGY), this.djj, this.hlG, this.sti, this.stk });
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
    this.stb = ((ImageView)findViewById(2131300246));
    this.stc = ((TextView)findViewById(2131300289));
    this.std = ((TextView)findViewById(2131300275));
    this.ssM = ((TextView)findViewById(2131300253));
    this.ste = ((Button)findViewById(2131298576));
    this.ste.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25238);
        com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cJb(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeTwoUI.this.cJM();
        ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ft(i) });
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
    this.stf = ((Button)findViewById(2131306246));
    this.stf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25239);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", ProtocolThreeTwoUI.this.stk);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(ProtocolThreeTwoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25239);
      }
    });
    if (bs.isNullOrNil(this.ssid))
    {
      this.std.setText(getString(2131759651));
      this.ste.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25258);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25257);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dbq = getIntent().getStringExtra("free_wifi_ap_key");
    this.openId = getIntent().getStringExtra("free_wifi_openid");
    this.srz = getIntent().getStringExtra("free_wifi_tid");
    this.cJz = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), this.dbq });
    initView();
    if (bs.isNullOrNil(this.ssid))
    {
      ac.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
      com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25257);
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
      paramBundle.field_wifiType = 32;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cJk().insert(paramBundle);
      }
      for (;;)
      {
        ac.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.sst, Integer.valueOf(this.dbL) });
        this.ssz = new com.tencent.mm.sdk.e.k.a()
        {
          private int suo = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25240);
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cJM());
            if (this.suo != ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this))
            {
              this.suo = ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this);
              ProtocolThreeTwoUI.this.Fv(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this));
            }
            AppMethodBeat.o(25240);
          }
        };
        j.cJk().add(this.ssz);
        ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ac.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aj(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ak(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cJk().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25265);
    super.onDestroy();
    if (this.ssz != null) {
      j.cJk().remove(this.ssz);
    }
    this.suH.stopTimer();
    j.cJn().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI
 * JD-Core Version:    0.7.0.1
 */