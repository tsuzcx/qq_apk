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
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cSM;
  protected String dnO;
  protected int doj;
  private int dqB = 1;
  protected String duJ;
  protected String dwb;
  protected String hGI;
  private final com.tencent.mm.av.a.a.c ifW;
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
  private p tBx = null;
  protected String tyx;
  protected String tzM;
  protected FreeWifiNetworkReceiver tzN;
  protected boolean tzO = false;
  private aw tzQ = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25130);
      if (!bu.isNullOrNil(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cUG());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.a(FreeWifiStateUI.this)) });
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        com.tencent.mm.plugin.freewifi.k.a locala = k.cTw();
        locala.ssid = FreeWifiStateUI.this.ssid;
        locala.dnO = FreeWifiStateUI.this.dnO;
        locala.pfT = com.tencent.mm.plugin.freewifi.m.ap(FreeWifiStateUI.this.getIntent());
        locala.tvY = com.tencent.mm.plugin.freewifi.m.ar(FreeWifiStateUI.this.getIntent());
        locala.tvZ = k.b.twk.twK;
        locala.twa = k.b.twk.name;
        locala.result = -16;
        locala.channel = com.tencent.mm.plugin.freewifi.m.as(FreeWifiStateUI.this.getIntent());
        locala.tvX = FreeWifiStateUI.this.dwb;
        locala.twb = FreeWifiStateUI.this.duJ;
        locala.cTy().cTx();
        if (FreeWifiStateUI.a(FreeWifiStateUI.this) != 2)
        {
          FreeWifiStateUI.this.cUK();
          FreeWifiStateUI.this.cUI();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(25130);
      return false;
    }
  }, false);
  private aw tzR = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25131);
      if (com.tencent.mm.plugin.freewifi.model.d.akO(FreeWifiStateUI.this.ssid))
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
  private com.tencent.mm.sdk.e.k.a tzS;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.igi = true;
    locala.igj = true;
    locala.igv = 2131232428;
    locala.hhW = true;
    locala.igC = 0.0F;
    this.ifW = locala.aJu();
    this.tzS = new com.tencent.mm.sdk.e.k.a()
    {
      private int tBG = -999999999;
      
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(25132);
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cUG());
        if (this.tBG != FreeWifiStateUI.a(FreeWifiStateUI.this))
        {
          this.tBG = FreeWifiStateUI.a(FreeWifiStateUI.this);
          FreeWifiStateUI.this.CT(FreeWifiStateUI.a(FreeWifiStateUI.this));
        }
        AppMethodBeat.o(25132);
      }
    };
  }
  
  private void cUL()
  {
    this.tzN = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.tzN, localIntentFilter);
  }
  
  private void goBack()
  {
    l.R(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iUz.h(localIntent, this);
    finish();
  }
  
  protected final void CT(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757574);
      if (this.doj == 3) {
        this.tAw.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.dwb))
      {
        if (!bu.isNullOrNil(this.tAB)) {
          this.tAv.setText(this.tAB);
        }
        if (!bu.isNullOrNil(this.hGI)) {
          q.aJb().a(this.hGI, this.tAu, this.ifW);
        }
      }
      label448:
      for (;;)
      {
        return;
        if (this.tBx != null) {
          this.tBx.dismiss();
        }
        this.tzQ.stopTimer();
        this.tzR.stopTimer();
        this.tzO = false;
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
          if (bu.isNullOrNil(this.dwb)) {
            break label448;
          }
          if (!bu.isNullOrNil(this.tAB)) {
            this.tAv.setText(this.tAB);
          }
          if (bu.isNullOrNil(this.hGI)) {
            break;
          }
          q.aJb().a(this.hGI, this.tAu, this.ifW);
          return;
          if (bu.isNullOrNil(this.tAC)) {
            this.tAw.setText(getString(2131757570));
          } else {
            this.tAw.setText(this.tAC);
          }
        }
      }
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
      this.tAf.setVisibility(0);
      this.tAx.setText(2131759649);
      return;
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        return;
        ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.tBE);
        ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.tAf.setVisibility(4);
      this.tAx.setText(2131757571);
      this.tBx = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25138);
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
          AppMethodBeat.o(25138);
        }
      });
      return;
      if (this.tBx != null) {
        this.tBx.dismiss();
      }
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
      this.tAf.setVisibility(0);
      this.tAx.setText(2131759649);
      return;
      if (bu.isNullOrNil(this.tAC)) {
        this.tAw.setText(getString(2131757570));
      } else {
        this.tAw.setText(this.tAC);
      }
    }
  }
  
  public final void Hg(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    cUI();
    cUM();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void aUs();
  
  protected abstract void cUF();
  
  protected abstract int cUG();
  
  protected final void cUI()
  {
    if (this.tzN != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
      this.tzN.txO = null;
    }
  }
  
  protected final void cUJ()
  {
    if (this.tzN == null) {
      cUL();
    }
    this.tzN.txP = this;
  }
  
  protected final void cUK()
  {
    if (this.tzN != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.tzN.txP = null;
    }
  }
  
  protected final void cUM()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.tzQ.ay(60000L, 60000L);
      this.tzR.ay(1000L, 1000L);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.cUh().cTQ().post(new Runnable()
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
    this.dqB = cUG();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dqB) });
    if (this.dqB != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.ar(getIntent()) == 4) {
        this.tzQ.ay(30000L, 30000L);
      }
      for (;;)
      {
        this.tzR.ay(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.akO(this.ssid)) {
          break label234;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.tzO) });
        if (!this.tzO) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.tzQ.ay(60000L, 60000L);
      }
      this.tzQ.ay(60000L, 60000L);
      this.tzR.ay(1000L, 1000L);
      aUs();
      this.tzO = true;
      return;
      label234:
      j.cUh().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25137);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiStateUI.this.ssid });
          FreeWifiStateUI.this.cUF();
          AppMethodBeat.o(25137);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.dqB, getIntent());
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
    setBackBtn(new FreeWifiStateUI.4(this));
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(2131306245).setVisibility(0);
    }
    this.tAu = ((ImageView)findViewById(2131300246));
    this.tAv = ((TextView)findViewById(2131300289));
    this.tAw = ((TextView)findViewById(2131300275));
    this.tAf = ((TextView)findViewById(2131300253));
    this.tAx = ((Button)findViewById(2131298576));
    this.tAx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25134);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        l.Q(com.tencent.mm.plugin.freewifi.model.d.cTV(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (FreeWifiStateUI.this.cUG() == 2) {
          FreeWifiStateUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25134);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
          FreeWifiStateUI.this.tzO = false;
          FreeWifiStateUI.this.cUM();
        }
      }
    });
    this.tAy = ((Button)findViewById(2131306246));
    this.tAy.setOnClickListener(new FreeWifiStateUI.6(this));
    if (bu.isNullOrNil(this.ssid))
    {
      this.tAw.setText(getString(2131759651));
      this.tAx.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnO = getIntent().getStringExtra("free_wifi_ap_key");
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
    switch (this.doj)
    {
    default: 
      if (bu.isNullOrNil(this.ssid)) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
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
        j.cUe().add(this.tzS);
        l.P(com.tencent.mm.plugin.freewifi.model.d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.cUe().cUE();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.tzM = paramBundle.field_mid;
          this.osm = paramBundle.field_url;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.tzM, this.osm });
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bu.isNullOrNil(this.ssid)) {
          break label377;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.cUe().akW(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = aj.ej(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.osm;
      paramBundle.field_mid = this.tzM;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.cUe().insert(paramBundle);
        break;
      }
      j.cUe().update(paramBundle, new String[0]);
      break;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.tzM, Integer.valueOf(this.doj) });
      break label234;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.cUe().remove(this.tzS);
    cUI();
    cUK();
    if (this.tzN != null) {
      unregisterReceiver(this.tzN);
    }
    this.tzQ.stopTimer();
    this.tzR.stopTimer();
    j.cUh().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */