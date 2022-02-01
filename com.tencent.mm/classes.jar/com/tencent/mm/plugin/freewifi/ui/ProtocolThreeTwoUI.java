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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.h.b;
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
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI
  extends MMActivity
{
  protected String appUserName;
  protected int channelId;
  private String dFd;
  private int dHO;
  protected String dNI;
  private String dmc;
  protected String iAR;
  private Intent intent;
  private final com.tencent.mm.av.a.a.c jaR;
  private String openId;
  protected String pFJ;
  private String sign;
  protected String signature;
  protected int source;
  protected String ssid;
  protected String wPA;
  private com.tencent.mm.plugin.freewifi.a wPE;
  private int wPK;
  private String wPU;
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
  
  public ProtocolThreeTwoUI()
  {
    AppMethodBeat.i(25256);
    this.dHO = 1;
    this.wPK = 0;
    this.wTa = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25233);
        if (!Util.isNullOrNil(ProtocolThreeTwoUI.this.ssid))
        {
          ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.dNP());
          if (ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this) != 2)
          {
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this)) });
            com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
          }
        }
        AppMethodBeat.o(25233);
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
    AppMethodBeat.o(25256);
  }
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(25264);
    k.a locala = k.dMF();
    locala.ssid = this.ssid;
    locala.bssid = com.tencent.mm.plugin.freewifi.m.axN("MicroMsg.FreeWifi.Protocol32UI");
    locala.dFe = com.tencent.mm.plugin.freewifi.m.axO("MicroMsg.FreeWifi.Protocol32UI");
    locala.dFd = this.dFd;
    locala.wNb = this.dNI;
    locala.quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
    locala.wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
    locala.wNd = k.b.wNF.wNO;
    locala.wNe = k.b.wNF.name;
    locala.result = paramInt;
    locala.resultMsg = paramString;
    locala.channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
    locala.wNf = this.appUserName;
    locala.dMH().dMG();
    AppMethodBeat.o(25264);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25262);
    l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.jRt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25262);
  }
  
  protected final void Ng(int paramInt)
  {
    AppMethodBeat.i(25260);
    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25260);
      return;
    case 4: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wTa.stopTimer();
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757801);
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
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        AppMethodBeat.o(25260);
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
      this.wSy = com.tencent.mm.ui.base.h.a(getContext(), getString(2131757798), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25236);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
          Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25236);
        }
      });
      Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25260);
      return;
    case 3: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wTa.stopTimer();
      this.wRh.setVisibility(0);
      this.wRy.setText(2131760970);
      Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25260);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.wSF);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25259);
    this.dHO = dNP();
    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(this.dHO) });
    if (this.dHO != 2)
    {
      this.wTa.startTimer(45000L);
      Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(60) });
      this.wPE = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
      j.dNq().dMZ().post(new Runnable()
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
  
  protected final int dNP()
  {
    AppMethodBeat.i(25263);
    if (Util.isNullOrNil(this.ssid))
    {
      Log.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
      AppMethodBeat.o(25263);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.dNn().aya(this.ssid);
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
    return 2131494724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25258);
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
    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.ssid, this.wQO, this.pFJ, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.dNI, this.iAR, this.wRC, this.wRE });
    setBackBtn(new ProtocolThreeTwoUI.4(this));
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
        AppMethodBeat.i(25238);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeTwoUI.this.dNP();
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeTwoUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(i) });
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
    this.wRz = ((Button)findViewById(2131309645));
    this.wRz.setOnClickListener(new ProtocolThreeTwoUI.6(this));
    if (Util.isNullOrNil(this.ssid))
    {
      this.wRx.setText(getString(2131760972));
      this.wRy.setVisibility(4);
    }
    setMMTitle(getString(2131760974));
    AppMethodBeat.o(25258);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25257);
    super.onCreate(paramBundle);
    this.intent = getIntent();
    this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
    this.openId = getIntent().getStringExtra("free_wifi_openid");
    this.wPU = getIntent().getStringExtra("free_wifi_tid");
    this.dmc = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.dFd });
    initView();
    if (Util.isNullOrNil(this.ssid))
    {
      Log.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
      l.Q(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25257);
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
      paramBundle.field_wifiType = 32;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.dNn().insert(paramBundle);
      }
      for (;;)
      {
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.wQO, Integer.valueOf(this.source) });
        this.wQU = new MStorage.IOnStorageChange()
        {
          private int wSH = -999999999;
          
          public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
          {
            AppMethodBeat.i(25240);
            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, ProtocolThreeTwoUI.this.dNP());
            if (this.wSH != ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this))
            {
              this.wSH = ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this);
              ProtocolThreeTwoUI.this.Ng(ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this));
            }
            AppMethodBeat.o(25240);
          }
        };
        j.dNn().add(this.wQU);
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.dNn().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25265);
    super.onDestroy();
    if (this.wQU != null) {
      j.dNn().remove(this.wQU);
    }
    this.wTa.stopTimer();
    j.dNq().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI
 * JD-Core Version:    0.7.0.1
 */