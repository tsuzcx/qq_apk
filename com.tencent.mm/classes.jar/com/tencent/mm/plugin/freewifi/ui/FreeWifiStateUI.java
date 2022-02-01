package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
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

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected String appUserName;
  protected int channelId;
  protected String dFd;
  private int dHO = 1;
  protected String dNI;
  protected String iAR;
  private final com.tencent.mm.av.a.a.c jaR;
  protected String pFJ;
  protected String signature;
  protected int source;
  protected String ssid;
  protected String wPA;
  protected String wQO;
  protected FreeWifiNetworkReceiver wQP;
  protected boolean wQQ = false;
  private MTimerHandler wQS = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25130);
      if (!Util.isNullOrNil(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.dNP());
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.a(FreeWifiStateUI.this)) });
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        k.a locala = k.dMF();
        locala.ssid = FreeWifiStateUI.this.ssid;
        locala.dFd = FreeWifiStateUI.this.dFd;
        locala.quX = com.tencent.mm.plugin.freewifi.m.aw(FreeWifiStateUI.this.getIntent());
        locala.wNc = com.tencent.mm.plugin.freewifi.m.ay(FreeWifiStateUI.this.getIntent());
        locala.wNd = k.b.wNo.wNO;
        locala.wNe = k.b.wNo.name;
        locala.result = -16;
        locala.channel = com.tencent.mm.plugin.freewifi.m.az(FreeWifiStateUI.this.getIntent());
        locala.wNb = FreeWifiStateUI.this.dNI;
        locala.wNf = FreeWifiStateUI.this.appUserName;
        locala.dMH().dMG();
        if (FreeWifiStateUI.a(FreeWifiStateUI.this) != 2)
        {
          FreeWifiStateUI.this.dNT();
          FreeWifiStateUI.this.dNR();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(25130);
      return false;
    }
  }, false);
  private MTimerHandler wQT = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25131);
      if (com.tencent.mm.plugin.freewifi.model.d.axS(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.this.a(NetworkInfo.State.CONNECTED);
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        AppMethodBeat.o(25131);
        return false;
      }
      AppMethodBeat.o(25131);
      return true;
    }
  }, true);
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
  private com.tencent.mm.ui.base.q wSy = null;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.jbd = true;
    locala.jbe = true;
    locala.jbq = 2131232809;
    locala.iaT = true;
    locala.jbx = 0.0F;
    this.jaR = locala.bdv();
    this.wQU = new MStorage.IOnStorageChange()
    {
      private int wSH = -999999999;
      
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(25132);
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.dNP());
        if (this.wSH != FreeWifiStateUI.a(FreeWifiStateUI.this))
        {
          this.wSH = FreeWifiStateUI.a(FreeWifiStateUI.this);
          FreeWifiStateUI.this.GE(FreeWifiStateUI.a(FreeWifiStateUI.this));
        }
        AppMethodBeat.o(25132);
      }
    };
  }
  
  private void dNU()
  {
    this.wQP = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.wQP, localIntentFilter);
  }
  
  private void goBack()
  {
    l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.jRt.h(localIntent, this);
    finish();
  }
  
  protected final void GE(int paramInt)
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757801);
      if (this.source == 3) {
        this.wRx.setText(getString(2131763044, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.dNI))
      {
        if (!Util.isNullOrNil(this.wRC)) {
          this.wRw.setText(this.wRC);
        }
        if (!Util.isNullOrNil(this.iAR)) {
          com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
        }
      }
      label448:
      for (;;)
      {
        return;
        if (this.wSy != null) {
          this.wSy.dismiss();
        }
        this.wQS.stopTimer();
        this.wQT.stopTimer();
        this.wQQ = false;
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
          if (Util.isNullOrNil(this.dNI)) {
            break label448;
          }
          if (!Util.isNullOrNil(this.wRC)) {
            this.wRw.setText(this.wRC);
          }
          if (Util.isNullOrNil(this.iAR)) {
            break;
          }
          com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
          return;
          if (Util.isNullOrNil(this.wRD)) {
            this.wRx.setText(getString(2131757797));
          } else {
            this.wRx.setText(this.wRD);
          }
        }
      }
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wQS.stopTimer();
      this.wQT.stopTimer();
      this.wRh.setVisibility(0);
      this.wRy.setText(2131760970);
      return;
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wQS.stopTimer();
      this.wQT.stopTimer();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        return;
        ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.wSF);
        ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.wRh.setVisibility(4);
      this.wRy.setText(2131757798);
      this.wSy = h.a(getContext(), getString(2131757798), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25138);
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
          AppMethodBeat.o(25138);
        }
      });
      return;
      if (this.wSy != null) {
        this.wSy.dismiss();
      }
      this.wQS.stopTimer();
      this.wQT.stopTimer();
      this.wRh.setVisibility(0);
      this.wRy.setText(2131760970);
      return;
      if (Util.isNullOrNil(this.wRD)) {
        this.wRx.setText(getString(2131757797));
      } else {
        this.wRx.setText(this.wRD);
      }
    }
  }
  
  public final void Nf(int paramInt)
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    dNR();
    dNV();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void bpf();
  
  protected abstract void dNO();
  
  protected abstract int dNP();
  
  protected final void dNR()
  {
    if (this.wQP != null)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
      this.wQP.wOS = null;
    }
  }
  
  protected final void dNS()
  {
    if (this.wQP == null) {
      dNU();
    }
    this.wQP.wOT = this;
  }
  
  protected final void dNT()
  {
    if (this.wQP != null)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.wQP.wOT = null;
    }
  }
  
  protected final void dNV()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.wQS.startTimer(60000L);
      this.wQT.startTimer(1000L);
      Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.dNq().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25136);
          FreeWifiStateUI.d(FreeWifiStateUI.this);
          AppMethodBeat.o(25136);
        }
      });
      return;
    }
    this.dHO = dNP();
    Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dHO) });
    if (this.dHO != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.ay(getIntent()) == 4) {
        this.wQS.startTimer(30000L);
      }
      for (;;)
      {
        this.wQT.startTimer(1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.axS(this.ssid)) {
          break label213;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.wQQ) });
        if (!this.wQQ) {
          break;
        }
        Log.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.wQS.startTimer(60000L);
      }
      this.wQS.startTimer(60000L);
      this.wQT.startTimer(1000L);
      bpf();
      this.wQQ = true;
      return;
      label213:
      j.dNq().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25137);
          Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiStateUI.this.ssid });
          FreeWifiStateUI.this.dNO();
          AppMethodBeat.o(25137);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.dHO, getIntent());
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
    setBackBtn(new FreeWifiStateUI.4(this));
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(2131309644).setVisibility(0);
    }
    this.wRv = ((ImageView)findViewById(2131301725));
    this.wRw = ((TextView)findViewById(2131301768));
    this.wRx = ((TextView)findViewById(2131301754));
    this.wRh = ((TextView)findViewById(2131301732));
    this.wRy = ((Button)findViewById(2131299013));
    this.wRy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25134);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (FreeWifiStateUI.this.dNP() == 2) {
          FreeWifiStateUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25134);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
          FreeWifiStateUI.this.wQQ = false;
          FreeWifiStateUI.this.dNV();
        }
      }
    });
    this.wRz = ((Button)findViewById(2131309645));
    this.wRz.setOnClickListener(new FreeWifiStateUI.6(this));
    if (Util.isNullOrNil(this.ssid))
    {
      this.wRx.setText(getString(2131760972));
      this.wRy.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
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
    switch (this.source)
    {
    default: 
      if (Util.isNullOrNil(this.ssid)) {
        Log.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      break;
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        label234:
        initView();
        j.dNn().add(this.wQU);
        l.Q(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.dNn().dNN();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.wQO = paramBundle.field_mid;
          this.pFJ = paramBundle.field_url;
          Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.wQO, this.pFJ });
          break;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!Util.isNullOrNil(this.ssid)) {
          break label377;
        }
        Log.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.dNn().aya(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.pFJ;
      paramBundle.field_mid = this.wQO;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.dNn().insert(paramBundle);
        break;
      }
      j.dNn().update(paramBundle, new String[0]);
      break;
      Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.wQO, Integer.valueOf(this.source) });
      break label234;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.dNn().remove(this.wQU);
    dNR();
    dNT();
    if (this.wQP != null) {
      unregisterReceiver(this.wQP);
    }
    this.wQS.stopTimer();
    this.wQT.stopTimer();
    j.dNq().release();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */