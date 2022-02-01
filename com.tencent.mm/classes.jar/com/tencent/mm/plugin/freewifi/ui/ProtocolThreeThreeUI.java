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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g;
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
public class ProtocolThreeThreeUI
  extends MMActivity
{
  protected String appId;
  protected String appUserName;
  protected String bssid;
  protected int channelId;
  private int dHO;
  protected String dmc;
  protected String extend;
  protected String sign;
  protected String signature;
  protected int source;
  protected String ssid;
  protected String wPA;
  private int wPK;
  protected String wPN;
  protected String wPO;
  private Uri wPP;
  private String wPQ;
  private MStorage.IOnStorageChange wQU;
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
  
  public ProtocolThreeThreeUI()
  {
    AppMethodBeat.i(25221);
    this.dHO = 1;
    this.wPK = 0;
    this.wTa = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25208);
        if (!Util.isNullOrNil(ProtocolThreeThreeUI.this.ssid))
        {
          ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.dNP());
          if (ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this) != 2)
          {
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this)) });
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
    l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.jRt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25227);
  }
  
  protected final void Ng(int paramInt)
  {
    AppMethodBeat.i(25225);
    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(25225);
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
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        AppMethodBeat.o(25225);
        return;
        this.wRx.setText(getString(2131757799, new Object[] { this.ssid }));
      }
    case 1: 
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757798);
      this.wSy = h.a(getContext(), getString(2131757798), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25220);
          com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
          Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4) });
          AppMethodBeat.o(25220);
        }
      });
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    case 3: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wTa.stopTimer();
      this.wRh.setVisibility(0);
      this.wRy.setText(2131760970);
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      AppMethodBeat.o(25225);
      return;
    }
    if (this.wSy != null) {
      this.wSy.dismiss();
    }
    this.wTa.stopTimer();
    this.wRy.setText(2131757795);
    this.wRy.setClickable(false);
    Object localObject = getIntent();
    ((Intent)localObject).putExtra("free_wifi_appid", this.appId);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      c.report();
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      break;
      ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.wSF);
      ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
    }
  }
  
  protected final void connect()
  {
    AppMethodBeat.i(25224);
    if (com.tencent.mm.plugin.freewifi.m.eP(this.ssid))
    {
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.eP(this.wPO))
    {
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 3, getIntent());
      AppMethodBeat.o(25224);
      return;
    }
    this.dHO = dNP();
    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(this.dHO) });
    if (this.dHO != 2)
    {
      this.wTa.startTimer(30000L);
      Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), Integer.valueOf(60) });
      com.tencent.mm.plugin.freewifi.m.eP(this.wPO);
      Object localObject = new StringBuilder(this.wPO);
      if (this.wPO.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?extend=").append(this.extend);
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        j.dNq().dMZ().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25215);
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), this.val$url });
            com.tencent.mm.plugin.freewifi.a.a.dMN();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new a.a()
            {
              public final void d(HttpURLConnection paramAnonymous2HttpURLConnection)
              {
                AppMethodBeat.i(25213);
                int i = paramAnonymous2HttpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i) });
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
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())) });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25213);
              }
              
              public final void o(Exception paramAnonymous2Exception)
              {
                AppMethodBeat.i(25214);
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), paramAnonymous2Exception.getMessage() });
                com.tencent.mm.plugin.freewifi.model.d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.o(25214);
              }
            });
            AppMethodBeat.o(25215);
          }
        });
        AppMethodBeat.o(25224);
        return;
        ((StringBuilder)localObject).append("&extend=").append(this.extend);
      }
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    AppMethodBeat.o(25224);
  }
  
  protected final int dNP()
  {
    AppMethodBeat.i(25228);
    if (Util.isNullOrNil(this.ssid))
    {
      Log.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
      AppMethodBeat.o(25228);
      return 0;
    }
    com.tencent.mm.plugin.freewifi.g.c localc = j.dNn().aya(this.ssid);
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
    return 2131494724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25223);
    this.ssid = com.tencent.mm.plugin.freewifi.m.axM("MicroMsg.FreeWifi.Protocol33UI");
    this.bssid = com.tencent.mm.plugin.freewifi.m.axN("MicroMsg.FreeWifi.Protocol33UI");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
    setBackBtn(new ProtocolThreeThreeUI.2(this));
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
        AppMethodBeat.i(25210);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        int i = ProtocolThreeThreeUI.this.dNP();
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(ProtocolThreeThreeUI.this.getIntent())), com.tencent.mm.plugin.freewifi.model.d.Ne(i) });
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
    this.wRz = ((Button)findViewById(2131309645));
    this.wRz.setOnClickListener(new ProtocolThreeThreeUI.4(this));
    if (Util.isNullOrNil(this.ssid))
    {
      this.wRx.setText(getString(2131760972));
      this.wRy.setVisibility(4);
    }
    setMMTitle(getString(2131760974));
    AppMethodBeat.o(25223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25222);
    super.onCreate(paramBundle);
    this.wPQ = getIntent().getStringExtra("free_wifi_schema_uri");
    this.wPP = Uri.parse(this.wPQ);
    this.appId = this.wPP.getQueryParameter("appId");
    this.wPN = this.wPP.getQueryParameter("shopId");
    this.wPO = this.wPP.getQueryParameter("authUrl");
    this.extend = this.wPP.getQueryParameter("extend");
    this.dmc = this.wPP.getQueryParameter("timestamp");
    this.sign = this.wPP.getQueryParameter("sign");
    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), this.wPQ });
    initView();
    if (Util.isNullOrNil(this.ssid))
    {
      Log.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
      l.Q(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
      AppMethodBeat.o(25222);
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
      paramBundle.field_url = "";
      paramBundle.field_mid = "";
      paramBundle.field_wifiType = 33;
      paramBundle.field_connectState = 1;
      if (i != 0) {
        j.dNn().insert(paramBundle);
      }
      for (;;)
      {
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, "", Integer.valueOf(this.source) });
        this.wQU = new MStorage.IOnStorageChange()
        {
          private int wSH = -999999999;
          
          public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
          {
            AppMethodBeat.i(25212);
            ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, ProtocolThreeThreeUI.this.dNP());
            if (this.wSH != ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this))
            {
              this.wSH = ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this);
              ProtocolThreeThreeUI.this.Ng(ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this));
            }
            AppMethodBeat.o(25212);
          }
        };
        j.dNn().add(this.wQU);
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())), paramBundle.field_ssidmd5, paramBundle.field_ssid, paramBundle.field_url, paramBundle.field_mid, Integer.valueOf(paramBundle.field_wifiType), Integer.valueOf(paramBundle.field_connectState) });
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(getIntent())) });
        com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
        break;
        j.dNn().update(paramBundle, new String[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25229);
    super.onDestroy();
    if (this.wQU != null) {
      j.dNn().remove(this.wQU);
    }
    this.wTa.stopTimer();
    j.dNq().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI
 * JD-Core Version:    0.7.0.1
 */