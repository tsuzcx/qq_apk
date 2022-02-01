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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI
  extends MMActivity
{
  protected String appUserName;
  protected int channelId;
  private String dFd;
  private int dHO;
  private String dHx;
  protected String dNI;
  protected String iAR;
  private Intent intent;
  private boolean isTimeout;
  private final com.tencent.mm.av.a.a.c jaR;
  protected String pFJ;
  protected String signature;
  protected int source;
  protected String ssid;
  protected String wPA;
  private String wPJ;
  private int wPK;
  protected String wQO;
  private MStorage.IOnStorageChange wQU;
  protected String wRC;
  protected String wRD;
  protected String wRE;
  private TextView wRh;
  private ImageView wRv;
  private TextView wRw;
  private TextView wRx;
  private Button wRy;
  private Button wRz;
  protected int wSD;
  protected String wSE;
  protected String wSF;
  private com.tencent.mm.ui.base.q wSy;
  private MTimerHandler wTa;
  
  public ProtocolThreeOneUI()
  {
    AppMethodBeat.i(25194);
    this.dHO = 1;
    this.wPK = 0;
    this.isTimeout = false;
    this.wTa = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25181);
        if (!Util.isNullOrNil(ProtocolThreeOneUI.this.ssid))
        {
          ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.dNP());
          if (ProtocolThreeOneUI.a(ProtocolThreeOneUI.this) != 2)
          {
            ProtocolThreeOneUI.b(ProtocolThreeOneUI.this);
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
          }
        }
        AppMethodBeat.o(25181);
        return false;
      }
    }, false);
    c.a locala = new c.a();
    locala.jbd = true;
    locala.jbe = true;
    locala.jbq = 2131232809;
    locala.iaT = true;
    locala.jbx = 0.0F;
    this.jaR = locala.bdv();
    AppMethodBeat.o(25194);
  }
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(25202);
    k.a locala = k.dMF();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.axN("MicroMsg.FreeWifi.Protocol31UI");
    locala.dFe = com.tencent.mm.plugin.freewifi.m.axO("MicroMsg.FreeWifi.Protocol31UI");
    locala.dFd = this.dFd;
    locala.wNb = this.dNI;
    locala.quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
    locala.wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
    locala.wNd = k.b.wNE.wNO;
    locala.wNe = k.b.wNE.name;
    locala.result = paramInt;
    locala.resultMsg = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
    locala.wNf = this.appUserName;
    locala.dMH().dMG();
    AppMethodBeat.o(25202);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25200);
    l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.jRt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25200);
  }
  
  protected final void Ng(int paramInt)
  {
    AppMethodBeat.i(25198);
    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25198);
      return;
    case 4: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wTa.stopTimer();
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757801);
      if ((com.tencent.mm.plugin.freewifi.m.az(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.eP(ae.gKy.gJB)) && (!com.tencent.mm.plugin.freewifi.m.eP(ae.cu(getContext())))) {
        this.wRy.setText(String.format(getString(2131760931), new Object[] { ae.cu(getContext()) }));
      }
      if (this.source == 3) {
        this.wRx.setText(getString(2131763044, new Object[] { this.ssid }));
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.dNI))
        {
          if (!Util.isNullOrNil(this.wPA)) {
            this.wRw.setText(this.wPA);
          }
          if (!Util.isNullOrNil(this.iAR)) {
            com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
          }
        }
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        AppMethodBeat.o(25198);
        return;
        if (Util.isNullOrNil(this.wRD)) {
          this.wRx.setText(getString(2131757797));
        } else {
          this.wRx.setText(this.wRD);
        }
      }
    case 1: 
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757798);
      this.wSy = h.a(getContext(), getString(2131757798), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25193);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
          Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25193);
        }
      });
      Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    case 3: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wTa.stopTimer();
      this.wRh.setVisibility(0);
      this.wRy.setText(2131760970);
      Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25198);
      return;
    }
    if (this.wSy != null) {
      this.wSy.dismiss();
    }
    this.wTa.stopTimer();
    this.wRy.setText(2131757795);
    this.wRy.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.dNI);
    ((Intent)localObject).putExtra("free_wifi_app_nickname", this.wPA);
    ((Intent)localObject).putExtra("free_wifi_app_username", this.appUserName);
    ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
    ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.wSD);
    ((Intent)localObject).putExtra("free_wifi_finish_url", this.wSE);
    if (Util.isNullOrNil(this.wSF)) {
      ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
    }
    for (;;)
    {
      finish();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.wSF);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25197);
    this.dHO = dNP();
    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(this.dHO) });
    if (this.dHO != 2)
    {
      this.wTa.startTimer(15000L);
      Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(60) });
      final String str = this.wPJ;
      j.dNq().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25188);
          Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), str });
          com.tencent.mm.plugin.freewifi.a.a.dMN();
          com.tencent.mm.plugin.freewifi.a.a.a(str, new a.a()
          {
            public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
            {
              AppMethodBeat.i(25186);
              int i = paramAnonymous2HttpURLConnection.getResponseCode();
              Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i) });
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
              Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())) });
              com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
              ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
              AppMethodBeat.o(25186);
            }
            
            public final void o(Exception paramAnonymous2Exception)
            {
              AppMethodBeat.i(25187);
              Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
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
  
  protected final int dNP()
  {
    AppMethodBeat.i(25201);
    if (Util.isNullOrNil(this.ssid))
    {
      Log.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
      AppMethodBeat.o(25201);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.dNn().aya(this.ssid);
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
    return 2131494724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25196);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.wQO = getIntent().getStringExtra("free_wifi_mid");
    this.pFJ = getIntent().getStringExtra("free_wifi_url");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.dNI = getIntent().getStringExtra("free_wifi_appid");
    this.iAR = getIntent().getStringExtra("free_wifi_head_img_url");
    this.wRC = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.wRD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
    this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.ssid, this.wQO, this.pFJ, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.dNI, this.iAR, this.wRC, this.wRE });
    setBackBtn(new ProtocolThreeOneUI.2(this));
    findViewById(2131309644).setVisibility(0);
    this.wRv = ((ImageView)findViewById(2131301725));
    this.wRw = ((TextView)findViewById(2131301768));
    this.wRx = ((TextView)findViewById(2131301754));
    this.wRh = ((TextView)findViewById(2131301732));
    this.wRy = ((Button)findViewById(2131299013));
    this.wRy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25183);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeOneUI.this.dNP();
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeOneUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(i) });
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
    this.wRz = ((Button)findViewById(2131309645));
    this.wRz.setOnClickListener(new ProtocolThreeOneUI.4(this));
    if (Util.isNullOrNil(this.ssid))
    {
      this.wRx.setText(getString(2131760972));
      this.wRy.setVisibility(4);
    }
    setMMTitle(getString(2131760974));
    AppMethodBeat.o(25196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25195);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
    this.dHx = getIntent().getStringExtra("free_wifi_schema_ticket");
    this.wPJ = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.dFd, this.dHx });
    initView();
    if (Util.isNullOrNil(this.ssid))
    {
      Log.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
      l.Q(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25195);
      return;
    }
    paramBundle = j.dNn().aya(this.ssid);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
      paramBundle.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
      paramBundle.field_ssid = this.ssid;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.pFJ;
      paramBundle.field_mid = this.wQO;
      paramBundle.field_wifiType = 3;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.dNn().insert(paramBundle);
      }
      for (;;)
      {
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.wQO, Integer.valueOf(this.source) });
        this.wQU = new MStorage.IOnStorageChange()
        {
          private int wSH = -999999999;
          
          public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
          {
            AppMethodBeat.i(25185);
            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, ProtocolThreeOneUI.this.dNP());
            if (this.wSH != ProtocolThreeOneUI.a(ProtocolThreeOneUI.this))
            {
              this.wSH = ProtocolThreeOneUI.a(ProtocolThreeOneUI.this);
              ProtocolThreeOneUI.this.Ng(ProtocolThreeOneUI.a(ProtocolThreeOneUI.this));
            }
            AppMethodBeat.o(25185);
          }
        };
        j.dNn().add(this.wQU);
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.dNn().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25203);
    super.onDestroy();
    if (this.wQU != null) {
      j.dNn().remove(this.wQU);
    }
    this.wTa.stopTimer();
    j.dNq().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI
 * JD-Core Version:    0.7.0.1
 */