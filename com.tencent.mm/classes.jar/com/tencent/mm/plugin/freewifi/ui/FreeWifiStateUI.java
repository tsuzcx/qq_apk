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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cGY;
  protected int dbL;
  protected String dbq;
  private int dea = 1;
  protected String dia;
  protected String djj;
  private final com.tencent.mm.av.a.a.c hKj;
  protected String hlG;
  protected String nJQ;
  protected String signature;
  protected String sre;
  private TextView ssM;
  protected String ssid;
  protected String sst;
  protected FreeWifiNetworkReceiver ssu;
  protected boolean ssv = false;
  private au ssx = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25130);
      if (!bs.isNullOrNil(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cJM());
        ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.a(FreeWifiStateUI.this)) });
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        com.tencent.mm.plugin.freewifi.k.a locala = k.cIC();
        locala.ssid = FreeWifiStateUI.this.ssid;
        locala.dbq = FreeWifiStateUI.this.dbq;
        locala.ovU = com.tencent.mm.plugin.freewifi.m.aj(FreeWifiStateUI.this.getIntent());
        locala.soD = com.tencent.mm.plugin.freewifi.m.al(FreeWifiStateUI.this.getIntent());
        locala.soE = k.b.soP.spp;
        locala.soF = k.b.soP.name;
        locala.result = -16;
        locala.channel = com.tencent.mm.plugin.freewifi.m.am(FreeWifiStateUI.this.getIntent());
        locala.soC = FreeWifiStateUI.this.djj;
        locala.soG = FreeWifiStateUI.this.dia;
        locala.cIE().cID();
        if (FreeWifiStateUI.a(FreeWifiStateUI.this) != 2)
        {
          FreeWifiStateUI.this.cJQ();
          FreeWifiStateUI.this.cJO();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(25130);
      return false;
    }
  }, false);
  private au ssy = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25131);
      if (com.tencent.mm.plugin.freewifi.model.d.afs(FreeWifiStateUI.this.ssid))
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
  private com.tencent.mm.sdk.e.k.a ssz;
  private ImageView stb;
  private TextView stc;
  private TextView std;
  private Button ste;
  private Button stf;
  protected String sti;
  protected String stj;
  protected String stk;
  private p sue = null;
  protected int suj;
  protected String suk;
  protected String sul;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.hKv = true;
    locala.hKw = true;
    locala.hKI = 2131232428;
    locala.gLt = true;
    locala.hKP = 0.0F;
    this.hKj = locala.aFT();
    this.ssz = new com.tencent.mm.sdk.e.k.a()
    {
      private int suo = -999999999;
      
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(25132);
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cJM());
        if (this.suo != FreeWifiStateUI.a(FreeWifiStateUI.this))
        {
          this.suo = FreeWifiStateUI.a(FreeWifiStateUI.this);
          FreeWifiStateUI.this.BY(FreeWifiStateUI.a(FreeWifiStateUI.this));
        }
        AppMethodBeat.o(25132);
      }
    };
  }
  
  private void cJR()
  {
    this.ssu = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.ssu, localIntentFilter);
  }
  
  private void goBack()
  {
    com.tencent.mm.plugin.freewifi.l.O(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iyx.h(localIntent, this);
    finish();
  }
  
  protected final void BY(int paramInt)
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.ssM.setVisibility(4);
      this.ste.setText(2131757574);
      if (this.dbL == 3) {
        this.std.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.djj))
      {
        if (!bs.isNullOrNil(this.sti)) {
          this.stc.setText(this.sti);
        }
        if (!bs.isNullOrNil(this.hlG)) {
          o.aFB().a(this.hlG, this.stb, this.hKj);
        }
      }
      label448:
      for (;;)
      {
        return;
        if (this.sue != null) {
          this.sue.dismiss();
        }
        this.ssx.stopTimer();
        this.ssy.stopTimer();
        this.ssv = false;
        this.ssM.setVisibility(4);
        this.ste.setText(2131757574);
        if ((com.tencent.mm.plugin.freewifi.m.am(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.cX(ae.fJi.fIu)) && (!com.tencent.mm.plugin.freewifi.m.cX(ae.bZ(getContext())))) {
          this.ste.setText(String.format(getString(2131759610), new Object[] { ae.bZ(getContext()) }));
        }
        if (this.dbL == 3) {
          this.std.setText(getString(2131761229, new Object[] { this.ssid }));
        }
        for (;;)
        {
          if (bs.isNullOrNil(this.djj)) {
            break label448;
          }
          if (!bs.isNullOrNil(this.sti)) {
            this.stc.setText(this.sti);
          }
          if (bs.isNullOrNil(this.hlG)) {
            break;
          }
          o.aFB().a(this.hlG, this.stb, this.hKj);
          return;
          if (bs.isNullOrNil(this.stj)) {
            this.std.setText(getString(2131757570));
          } else {
            this.std.setText(this.stj);
          }
        }
      }
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.ssx.stopTimer();
      this.ssy.stopTimer();
      this.ssM.setVisibility(0);
      this.ste.setText(2131759649);
      return;
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.ssx.stopTimer();
      this.ssy.stopTimer();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        return;
        ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.sul);
        ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.ssM.setVisibility(4);
      this.ste.setText(2131757571);
      this.sue = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25138);
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
          AppMethodBeat.o(25138);
        }
      });
      return;
      if (this.sue != null) {
        this.sue.dismiss();
      }
      this.ssx.stopTimer();
      this.ssy.stopTimer();
      this.ssM.setVisibility(0);
      this.ste.setText(2131759649);
      return;
      if (bs.isNullOrNil(this.stj)) {
        this.std.setText(getString(2131757570));
      } else {
        this.std.setText(this.stj);
      }
    }
  }
  
  public final void Fu(int paramInt)
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    cJO();
    cJS();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void aQH();
  
  protected abstract void cJL();
  
  protected abstract int cJM();
  
  protected final void cJO()
  {
    if (this.ssu != null)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
      this.ssu.squ = null;
    }
  }
  
  protected final void cJP()
  {
    if (this.ssu == null) {
      cJR();
    }
    this.ssu.sqv = this;
  }
  
  protected final void cJQ()
  {
    if (this.ssu != null)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.ssu.sqv = null;
    }
  }
  
  protected final void cJS()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.ssx.au(60000L, 60000L);
      this.ssy.au(1000L, 1000L);
      ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.cJn().cIW().post(new Runnable()
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
    this.dea = cJM();
    ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dea) });
    if (this.dea != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.al(getIntent()) == 4) {
        this.ssx.au(30000L, 30000L);
      }
      for (;;)
      {
        this.ssy.au(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.afs(this.ssid)) {
          break label234;
        }
        ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.ssv) });
        if (!this.ssv) {
          break;
        }
        ac.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.ssx.au(60000L, 60000L);
      }
      this.ssx.au(60000L, 60000L);
      this.ssy.au(1000L, 1000L);
      aQH();
      this.ssv = true;
      return;
      label234:
      j.cJn().cIW().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25137);
          ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiStateUI.this.ssid });
          FreeWifiStateUI.this.cJL();
          AppMethodBeat.o(25137);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.dea, getIntent());
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
    this.stb = ((ImageView)findViewById(2131300246));
    this.stc = ((TextView)findViewById(2131300289));
    this.std = ((TextView)findViewById(2131300275));
    this.ssM = ((TextView)findViewById(2131300253));
    this.ste = ((Button)findViewById(2131298576));
    this.ste.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25134);
        com.tencent.mm.plugin.freewifi.l.N(com.tencent.mm.plugin.freewifi.model.d.cJb(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (FreeWifiStateUI.this.cJM() == 2)
        {
          FreeWifiStateUI.this.finish();
          AppMethodBeat.o(25134);
          return;
        }
        com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
        FreeWifiStateUI.this.ssv = false;
        FreeWifiStateUI.this.cJS();
        AppMethodBeat.o(25134);
      }
    });
    this.stf = ((Button)findViewById(2131306246));
    this.stf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25135);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", FreeWifiStateUI.this.stk);
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(FreeWifiStateUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25135);
      }
    });
    if (bs.isNullOrNil(this.ssid))
    {
      this.std.setText(getString(2131759651));
      this.ste.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dbq = getIntent().getStringExtra("free_wifi_ap_key");
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
    switch (this.dbL)
    {
    default: 
      if (bs.isNullOrNil(this.ssid)) {
        ac.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
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
        j.cJk().add(this.ssz);
        com.tencent.mm.plugin.freewifi.l.M(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.cJk().cJK();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.sst = paramBundle.field_mid;
          this.nJQ = paramBundle.field_url;
          ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.sst, this.nJQ });
          break;
        }
        ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bs.isNullOrNil(this.ssid)) {
          break label377;
        }
        ac.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.cJk().afA(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ah.dg(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nJQ;
      paramBundle.field_mid = this.sst;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.cJk().insert(paramBundle);
        break;
      }
      j.cJk().update(paramBundle, new String[0]);
      break;
      ac.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.sst, Integer.valueOf(this.dbL) });
      break label234;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.cJk().remove(this.ssz);
    cJO();
    cJQ();
    if (this.ssu != null) {
      unregisterReceiver(this.ssu);
    }
    this.ssx.stopTimer();
    this.ssy.stopTimer();
    j.cJn().release();
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