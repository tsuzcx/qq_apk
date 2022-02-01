package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cJR;
  protected String ddU;
  protected int dep;
  private int dgF = 1;
  protected String dkB;
  protected String dlB;
  protected String gLg;
  private final com.tencent.mm.aw.a.a.c hjG;
  protected String nha;
  protected String ril;
  protected String rjA;
  protected FreeWifiNetworkReceiver rjB;
  protected boolean rjC = false;
  private av rjE = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25130);
      if (!bt.isNullOrNil(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cwA());
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.a(FreeWifiStateUI.this)) });
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        com.tencent.mm.plugin.freewifi.k.a locala = k.cvq();
        locala.ssid = FreeWifiStateUI.this.ssid;
        locala.ddU = FreeWifiStateUI.this.ddU;
        locala.nSA = com.tencent.mm.plugin.freewifi.m.ai(FreeWifiStateUI.this.getIntent());
        locala.rfL = com.tencent.mm.plugin.freewifi.m.ak(FreeWifiStateUI.this.getIntent());
        locala.rfM = k.b.rfX.rgx;
        locala.rfN = k.b.rfX.name;
        locala.result = -16;
        locala.channel = com.tencent.mm.plugin.freewifi.m.al(FreeWifiStateUI.this.getIntent());
        locala.rfK = FreeWifiStateUI.this.dlB;
        locala.rfO = FreeWifiStateUI.this.dkB;
        locala.cvs().cvr();
        if (FreeWifiStateUI.a(FreeWifiStateUI.this) != 2)
        {
          FreeWifiStateUI.this.cwE();
          FreeWifiStateUI.this.cwC();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(25130);
      return false;
    }
  }, false);
  private av rjF = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25131);
      if (com.tencent.mm.plugin.freewifi.model.d.aaA(FreeWifiStateUI.this.ssid))
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
  private com.tencent.mm.sdk.e.k.a rjG;
  private TextView rjT;
  private ImageView rki;
  private TextView rkj;
  private TextView rkk;
  private Button rkl;
  private Button rkm;
  protected String rkp;
  protected String rkq;
  protected String rkr;
  private p rll = null;
  protected int rlq;
  protected String rlr;
  protected String rls;
  protected String signature;
  protected String ssid;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.hjS = true;
    locala.hjT = true;
    locala.hkf = 2131232428;
    locala.gkG = true;
    locala.hkm = 0.0F;
    this.hjG = locala.azc();
    this.rjG = new com.tencent.mm.sdk.e.k.a()
    {
      private int rlu = -999999999;
      
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(25132);
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cwA());
        if (this.rlu != FreeWifiStateUI.a(FreeWifiStateUI.this))
        {
          this.rlu = FreeWifiStateUI.a(FreeWifiStateUI.this);
          FreeWifiStateUI.this.Bg(FreeWifiStateUI.a(FreeWifiStateUI.this));
        }
        AppMethodBeat.o(25132);
      }
    };
  }
  
  private void cwF()
  {
    this.rjB = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.rjB, localIntentFilter);
  }
  
  private void goBack()
  {
    com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.hYt.h(localIntent, this);
    finish();
  }
  
  protected final void Bg(int paramInt)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757574);
      if (this.dep == 3) {
        this.rkk.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.dlB))
      {
        if (!bt.isNullOrNil(this.rkp)) {
          this.rkj.setText(this.rkp);
        }
        if (!bt.isNullOrNil(this.gLg)) {
          o.ayJ().a(this.gLg, this.rki, this.hjG);
        }
      }
      label448:
      for (;;)
      {
        return;
        if (this.rll != null) {
          this.rll.dismiss();
        }
        this.rjE.stopTimer();
        this.rjF.stopTimer();
        this.rjC = false;
        this.rjT.setVisibility(4);
        this.rkl.setText(2131757574);
        if ((com.tencent.mm.plugin.freewifi.m.al(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.dq(ae.fFB.fEN)) && (!com.tencent.mm.plugin.freewifi.m.dq(ae.bW(getContext())))) {
          this.rkl.setText(String.format(getString(2131759610), new Object[] { ae.bW(getContext()) }));
        }
        if (this.dep == 3) {
          this.rkk.setText(getString(2131761229, new Object[] { this.ssid }));
        }
        for (;;)
        {
          if (bt.isNullOrNil(this.dlB)) {
            break label448;
          }
          if (!bt.isNullOrNil(this.rkp)) {
            this.rkj.setText(this.rkp);
          }
          if (bt.isNullOrNil(this.gLg)) {
            break;
          }
          o.ayJ().a(this.gLg, this.rki, this.hjG);
          return;
          if (bt.isNullOrNil(this.rkq)) {
            this.rkk.setText(getString(2131757570));
          } else {
            this.rkk.setText(this.rkq);
          }
        }
      }
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      this.rjT.setVisibility(0);
      this.rkl.setText(2131759649);
      return;
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      this.rkl.setText(2131757568);
      this.rkl.setClickable(false);
      Object localObject = getIntent();
      ((Intent)localObject).putExtra("free_wifi_appid", this.dlB);
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
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        return;
        ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.rls);
        ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.rjT.setVisibility(4);
      this.rkl.setText(2131757571);
      this.rll = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25138);
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
          AppMethodBeat.o(25138);
        }
      });
      return;
      if (this.rll != null) {
        this.rll.dismiss();
      }
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      this.rjT.setVisibility(0);
      this.rkl.setText(2131759649);
      return;
      if (bt.isNullOrNil(this.rkq)) {
        this.rkk.setText(getString(2131757570));
      } else {
        this.rkk.setText(this.rkq);
      }
    }
  }
  
  public final void Dy(int paramInt)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    cwC();
    cwG();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void aJQ();
  
  protected abstract int cwA();
  
  protected final void cwC()
  {
    if (this.rjB != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
      this.rjB.rhB = null;
    }
  }
  
  protected final void cwD()
  {
    if (this.rjB == null) {
      cwF();
    }
    this.rjB.rhC = this;
  }
  
  protected final void cwE()
  {
    if (this.rjB != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.rjB.rhC = null;
    }
  }
  
  protected final void cwG()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.rjE.av(60000L, 60000L);
      this.rjF.av(1000L, 1000L);
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.cwb().cvK().post(new Runnable()
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
    this.dgF = cwA();
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dgF) });
    if (this.dgF != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.ak(getIntent()) == 4) {
        this.rjE.av(30000L, 30000L);
      }
      for (;;)
      {
        this.rjF.av(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.aaA(this.ssid)) {
          break label234;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.rjC) });
        if (!this.rjC) {
          break;
        }
        ad.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.rjE.av(60000L, 60000L);
      }
      this.rjE.av(60000L, 60000L);
      this.rjF.av(1000L, 1000L);
      aJQ();
      this.rjC = true;
      return;
      label234:
      j.cwb().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25137);
          ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiStateUI.this.ssid });
          FreeWifiStateUI.this.cwz();
          AppMethodBeat.o(25137);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.dgF, getIntent());
  }
  
  protected abstract void cwz();
  
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25133);
        FreeWifiStateUI.c(FreeWifiStateUI.this);
        AppMethodBeat.o(25133);
        return true;
      }
    });
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(2131306245).setVisibility(0);
    }
    this.rki = ((ImageView)findViewById(2131300246));
    this.rkj = ((TextView)findViewById(2131300289));
    this.rkk = ((TextView)findViewById(2131300275));
    this.rjT = ((TextView)findViewById(2131300253));
    this.rkl = ((Button)findViewById(2131298576));
    this.rkl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25134);
        com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cvP(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (FreeWifiStateUI.this.cwA() == 2)
        {
          FreeWifiStateUI.this.finish();
          AppMethodBeat.o(25134);
          return;
        }
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
        FreeWifiStateUI.this.rjC = false;
        FreeWifiStateUI.this.cwG();
        AppMethodBeat.o(25134);
      }
    });
    this.rkm = ((Button)findViewById(2131306246));
    this.rkm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25135);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", FreeWifiStateUI.this.rkr);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(FreeWifiStateUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25135);
      }
    });
    if (bt.isNullOrNil(this.ssid))
    {
      this.rkk.setText(getString(2131759651));
      this.rkl.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.rjA = getIntent().getStringExtra("free_wifi_mid");
    this.nha = getIntent().getStringExtra("free_wifi_url");
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    this.cJR = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.dlB = getIntent().getStringExtra("free_wifi_appid");
    this.gLg = getIntent().getStringExtra("free_wifi_head_img_url");
    this.rkp = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.rkq = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.rkr = getIntent().getStringExtra("free_wifi_privacy_url");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    switch (this.dep)
    {
    default: 
      if (bt.isNullOrNil(this.ssid)) {
        ad.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
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
        j.cvY().add(this.rjG);
        com.tencent.mm.plugin.freewifi.l.L(com.tencent.mm.plugin.freewifi.model.d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.cvY().cwy();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.rjA = paramBundle.field_mid;
          this.nha = paramBundle.field_url;
          ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.rjA, this.nha });
          break;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bt.isNullOrNil(this.ssid)) {
          break label377;
        }
        ad.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.cvY().aaI(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ai.du(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nha;
      paramBundle.field_mid = this.rjA;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.cvY().insert(paramBundle);
        break;
      }
      j.cvY().update(paramBundle, new String[0]);
      break;
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.rjA, Integer.valueOf(this.dep) });
      break label234;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.cvY().remove(this.rjG);
    cwC();
    cwE();
    if (this.rjB != null) {
      unregisterReceiver(this.rjB);
    }
    this.rjE.stopTimer();
    this.rjF.stopTimer();
    j.cwb().release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */