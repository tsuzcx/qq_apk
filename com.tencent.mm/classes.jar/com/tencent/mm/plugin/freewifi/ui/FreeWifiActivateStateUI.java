package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cSM;
  protected int doj;
  private int dqB = 1;
  protected String osm;
  protected String ssid;
  private FreeWifiStateView tzH;
  private TextView tzI;
  private TextView tzJ;
  private Button tzK;
  protected Button tzL;
  protected String tzM;
  protected FreeWifiNetworkReceiver tzN;
  protected boolean tzO = false;
  private boolean tzP = false;
  private aw tzQ = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24969);
      if (!bu.isNullOrNil(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cUG());
        ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this)) });
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        if (FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this) != 2)
        {
          FreeWifiActivateStateUI.this.cUK();
          FreeWifiActivateStateUI.this.cUI();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(24969);
      return false;
    }
  }, false);
  private aw tzR = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24970);
      if (com.tencent.mm.plugin.freewifi.model.d.akO(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.this.a(NetworkInfo.State.CONNECTED);
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        AppMethodBeat.o(24970);
        return false;
      }
      AppMethodBeat.o(24970);
      return true;
    }
  }, true);
  private k.a tzS = new k.a()
  {
    public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
    {
      AppMethodBeat.i(24971);
      FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cUG());
      FreeWifiActivateStateUI.this.CT(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this));
      AppMethodBeat.o(24971);
    }
  };
  
  private void cUL()
  {
    this.tzN = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.tzN, localIntentFilter);
  }
  
  private void cUN()
  {
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.tzO) });
    if (this.tzO)
    {
      ae.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.tzQ.ay(60000L, 60000L);
    this.tzR.ay(1000L, 1000L);
    aUs();
    this.tzO = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.iUz.h(localIntent, this);
    }
  }
  
  protected final void CT(int paramInt)
  {
    this.tzH.setOnClickListener(null);
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.tzH.setImageResource(2131232440);
      this.tzI.setText(2131757569);
      if (this.doj == 3) {
        this.tzJ.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.tzK.setVisibility(8);
      return;
      this.tzH.setImageResource(2131232440);
      this.tzH.setState(3);
      this.tzH.qqy = 2;
      this.tzI.setText(2131757573);
      this.tzK.setVisibility(0);
      this.tzK.setText(2131759649);
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
      return;
      this.tzH.setImageResource(2131232438);
      this.tzH.setState(2);
      this.tzI.setText(2131757568);
      this.tzK.setVisibility(0);
      this.tzK.setText(2131759607);
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
      if ((this.doj == 1) || (this.doj == 5) || (this.doj == 4))
      {
        this.tzK.setVisibility(4);
        final com.tencent.mm.plugin.freewifi.g.c localc = j.cUe().akW(this.ssid);
        if ((localc != null) && (!bu.isNullOrNil(localc.field_showUrl)) && (!this.tzP))
        {
          this.tzP = true;
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24977);
              Intent localIntent = new Intent();
              String str = ad.f(FreeWifiActivateStateUI.this.getSharedPreferences(ak.fow(), 0));
              localIntent.putExtra("rawUrl", localc.field_showUrl + "&lang=" + str);
              localIntent.putExtra("show_bottom", false);
              localIntent.putExtra("stastic_scene", 7);
              com.tencent.mm.br.d.b(FreeWifiActivateStateUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
              ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
              FreeWifiActivateStateUI.this.finish();
              AppMethodBeat.o(24977);
            }
          }, 1000L);
        }
      }
      c.report();
      return;
      this.tzH.setImageResource(2131232440);
      this.tzH.setState(1);
      this.tzI.setText(2131757569);
      continue;
      this.tzQ.stopTimer();
      this.tzR.stopTimer();
      this.tzH.setImageResource(2131232439);
      this.tzH.setState(3);
      this.tzI.setText(2131759635);
      this.tzI.setVisibility(0);
      this.tzJ.setText(2131759636);
      this.tzJ.setVisibility(0);
      continue;
      this.tzJ.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public final void Hg(int paramInt)
  {
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  protected abstract void aUs();
  
  protected abstract void cUF();
  
  protected abstract int cUG();
  
  protected final void cUI()
  {
    if (this.tzN != null)
    {
      ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
      ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.tzN.txP = null;
    }
  }
  
  protected final void cUM()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.tzQ.ay(60000L, 60000L);
      this.tzR.ay(1000L, 1000L);
      ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.cUh().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24975);
          FreeWifiActivateStateUI.d(FreeWifiActivateStateUI.this);
          AppMethodBeat.o(24975);
        }
      });
      return;
    }
    this.dqB = cUG();
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dqB) });
    if (this.dqB != 2)
    {
      this.tzQ.ay(60000L, 60000L);
      this.tzR.ay(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.akO(this.ssid))
      {
        cUN();
        return;
      }
      j.cUh().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24976);
          ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiActivateStateUI.this.ssid });
          FreeWifiActivateStateUI.this.cUF();
          AppMethodBeat.o(24976);
        }
      });
      return;
    }
    CT(this.dqB);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494177;
  }
  
  public void initView()
  {
    setBackBtn(new FreeWifiActivateStateUI.4(this));
    this.tzH = ((FreeWifiStateView)findViewById(2131300248));
    this.tzI = ((TextView)findViewById(2131300249));
    this.tzJ = ((TextView)findViewById(2131300250));
    if (this.doj == 3) {
      this.tzJ.setText(getString(2131761229, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.tzK = ((Button)findViewById(2131303749));
      this.tzK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24973);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (FreeWifiActivateStateUI.this.cUG() == 2) {
            FreeWifiActivateStateUI.this.finish();
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24973);
            return;
            com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
            FreeWifiActivateStateUI.this.tzO = false;
            FreeWifiActivateStateUI.this.cUM();
          }
        }
      });
      this.tzL = ((Button)findViewById(2131300737));
      this.tzL.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.tzJ.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.tzM = getIntent().getStringExtra("free_wifi_mid");
    this.osm = getIntent().getStringExtra("free_wifi_url");
    this.doj = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSM = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.doj)
    {
    default: 
      if (bu.isNullOrNil(this.ssid)) {
        ae.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      break;
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        label134:
        initView();
        j.cUe().add(this.tzS);
        return;
        paramBundle = j.cUe().cUE();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.tzM = paramBundle.field_mid;
          this.osm = paramBundle.field_url;
          ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.tzM, this.osm });
          break;
        }
        ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bu.isNullOrNil(this.ssid)) {
          break label252;
        }
        ae.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.cUe().akW(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = aj.ej(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.osm;
      paramBundle.field_mid = this.tzM;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.cUe().insert(paramBundle);
        break;
      }
      j.cUe().update(paramBundle, new String[0]);
      break;
      ae.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.tzM, Integer.valueOf(this.doj) });
      break label134;
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
  
  public void onResume()
  {
    super.onResume();
    if (!bu.isNullOrNil(this.ssid)) {
      cUM();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
 * JD-Core Version:    0.7.0.1
 */