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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hu;
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
  protected int cSc;
  private String cUM;
  private String dmM;
  protected int dnh;
  private int dpw;
  protected String dtE;
  protected String duW;
  protected String hDQ;
  private final com.tencent.mm.aw.a.a.c idd;
  private Intent intent;
  protected String omw;
  private String openId;
  private String sign;
  protected String signature;
  protected String ssid;
  protected String tnF;
  private com.tencent.mm.plugin.freewifi.a tnJ;
  private int tnP;
  protected String toV;
  private String toa;
  private ImageView tpD;
  private TextView tpE;
  private TextView tpF;
  private Button tpG;
  private Button tpH;
  protected String tpK;
  protected String tpL;
  protected String tpM;
  private com.tencent.mm.sdk.e.k.a tpb;
  private TextView tpo;
  private p tqG;
  protected int tqL;
  protected String tqM;
  protected String tqN;
  private av tri;
  
  public ProtocolThreeTwoUI()
  {
    AppMethodBeat.i(25256);
    this.dpw = 1;
    this.tnP = 0;
    this.tri = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25233);
        if (!bt.isNullOrNil(ProtocolThreeTwoUI.this.ssid))
        {
          ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cSb());
          if (ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this) != 2)
          {
            ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.GI(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
          }
        }
        AppMethodBeat.o(25233);
        return false;
      }
    }, false);
    c.a locala = new c.a();
    locala.idp = true;
    locala.idq = true;
    locala.idD = 2131232428;
    locala.hfi = true;
    locala.idK = 0.0F;
    this.idd = locala.aJc();
    AppMethodBeat.o(25256);
  }
  
  private void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(25264);
    com.tencent.mm.plugin.freewifi.k.a locala = k.cQR();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.ajL("MicroMsg.FreeWifi.Protocol32UI");
    locala.dmN = com.tencent.mm.plugin.freewifi.m.ajM("MicroMsg.FreeWifi.Protocol32UI");
    locala.dmM = this.dmM;
    locala.tlf = this.duW;
    locala.oZp = com.tencent.mm.plugin.freewifi.m.ao(this.intent);
    locala.tlg = com.tencent.mm.plugin.freewifi.m.aq(this.intent);
    locala.tlh = k.b.tlJ.tlS;
    locala.tli = k.b.tlJ.name;
    locala.result = paramInt;
    locala.fKQ = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    locala.tlj = this.dtE;
    locala.cQT().cQS();
    AppMethodBeat.o(25264);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25262);
    l.R(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iRG.h(localIntent, this);
    finish();
    AppMethodBeat.o(25262);
  }
  
  protected final void GK(int paramInt)
  {
    AppMethodBeat.i(25260);
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25260);
      return;
    case 4: 
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.tri.stopTimer();
      this.tpo.setVisibility(4);
      this.tpG.setText(2131757574);
      if (this.dnh == 3) {
        this.tpF.setText(getString(2131761229, new Object[] { this.ssid }));
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
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
        AppMethodBeat.o(25260);
        return;
        if (bt.isNullOrNil(this.tpL)) {
          this.tpF.setText(getString(2131757570));
        } else {
          this.tpF.setText(this.tpL);
        }
      }
    case 1: 
      this.tpo.setVisibility(4);
      this.tpG.setText(2131757571);
      this.tqG = com.tencent.mm.ui.base.h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25236);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
          ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25236);
        }
      });
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    case 3: 
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.tri.stopTimer();
      this.tpo.setVisibility(0);
      this.tpG.setText(2131759649);
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    }
    if (this.tqG != null) {
      this.tqG.dismiss();
    }
    this.tri.stopTimer();
    this.tpG.setText(2131757568);
    this.tpG.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.duW);
    ((Intent)localObject).putExtra("free_wifi_app_nickname", this.tnF);
    ((Intent)localObject).putExtra("free_wifi_app_username", this.dtE);
    ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
    ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.tqL);
    ((Intent)localObject).putExtra("free_wifi_finish_url", this.tqM);
    if (bt.isNullOrNil(this.tqN)) {
      ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      finish();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.tqN);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final int cSb()
  {
    AppMethodBeat.i(25263);
    if (bt.isNullOrNil(this.ssid))
    {
      ad.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
      AppMethodBeat.o(25263);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.cRz().ajY(this.ssid);
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
    this.dpw = cSb();
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), com.tencent.mm.plugin.freewifi.model.d.GI(this.dpw) });
    if (this.dpw != 2)
    {
      this.tri.az(45000L, 45000L);
      ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), Integer.valueOf(60) });
      this.tnJ = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
      j.cRC().cRl().post(new Runnable()
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
    this.toV = getIntent().getStringExtra("free_wifi_mid");
    this.omw = getIntent().getStringExtra("free_wifi_url");
    this.dnh = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSc = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.duW = getIntent().getStringExtra("free_wifi_appid");
    this.hDQ = getIntent().getStringExtra("free_wifi_head_img_url");
    this.tpK = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.tpL = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.tpM = getIntent().getStringExtra("free_wifi_privacy_url");
    this.tnF = getIntent().getStringExtra("free_wifi_app_nickname");
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.ssid, this.toV, this.omw, Integer.valueOf(this.dnh), Integer.valueOf(this.cSc), this.duW, this.hDQ, this.tpK, this.tpM });
    setBackBtn(new ProtocolThreeTwoUI.4(this));
    findViewById(2131306245).setVisibility(0);
    this.tpD = ((ImageView)findViewById(2131300246));
    this.tpE = ((TextView)findViewById(2131300289));
    this.tpF = ((TextView)findViewById(2131300275));
    this.tpo = ((TextView)findViewById(2131300253));
    this.tpG = ((Button)findViewById(2131298576));
    this.tpG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25238);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        l.Q(com.tencent.mm.plugin.freewifi.model.d.cRq(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeTwoUI.this.cSb();
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.GI(i) });
        if (i == 2) {
          ProtocolThreeTwoUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25238);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
          ProtocolThreeTwoUI.this.connect();
        }
      }
    });
    this.tpH = ((Button)findViewById(2131306246));
    this.tpH.setOnClickListener(new ProtocolThreeTwoUI.6(this));
    if (bt.isNullOrNil(this.ssid))
    {
      this.tpF.setText(getString(2131759651));
      this.tpG.setVisibility(4);
    }
    setMMTitle(getString(2131759653));
    AppMethodBeat.o(25258);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25257);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dmM = getIntent().getStringExtra("free_wifi_ap_key");
    this.openId = getIntent().getStringExtra("free_wifi_openid");
    this.toa = getIntent().getStringExtra("free_wifi_tid");
    this.cUM = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), this.dmM });
    initView();
    if (bt.isNullOrNil(this.ssid))
    {
      ad.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
      l.P(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25257);
      return;
    }
    paramBundle = j.cRz().ajY(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = ai.ee(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.omw;
      paramBundle.field_mid = this.toV;
      paramBundle.field_wifiType = 32;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.cRz().insert(paramBundle);
      }
      for (;;)
      {
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.toV, Integer.valueOf(this.dnh) });
        this.tpb = new com.tencent.mm.sdk.e.k.a()
        {
          private int tqP = -999999999;
          
          public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
          {
            AppMethodBeat.i(25240);
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.cSb());
            if (this.tqP != ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this))
            {
              this.tqP = ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this);
              ProtocolThreeTwoUI.this.GK(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this));
            }
            AppMethodBeat.o(25240);
          }
        };
        j.cRz().add(this.tpb);
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        ad.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.cRz().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25265);
    super.onDestroy();
    if (this.tpb != null) {
      j.cRz().remove(this.tpb);
    }
    this.tri.stopTimer();
    j.cRC().release();
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