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
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cGY;
  protected int dbL;
  private int dea = 1;
  protected String nJQ;
  protected String ssid;
  private FreeWifiStateView sso;
  private TextView ssp;
  private TextView ssq;
  private Button ssr;
  protected Button sss;
  protected String sst;
  protected FreeWifiNetworkReceiver ssu;
  protected boolean ssv = false;
  private boolean ssw = false;
  private au ssx = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24969);
      if (!bs.isNullOrNil(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cJM());
        ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this)) });
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        if (FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this) != 2)
        {
          FreeWifiActivateStateUI.this.cJQ();
          FreeWifiActivateStateUI.this.cJO();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(24969);
      return false;
    }
  }, false);
  private au ssy = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24970);
      if (com.tencent.mm.plugin.freewifi.model.d.afs(FreeWifiActivateStateUI.this.ssid))
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
  private k.a ssz = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(24971);
      FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cJM());
      FreeWifiActivateStateUI.this.BY(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this));
      AppMethodBeat.o(24971);
    }
  };
  
  private void cJR()
  {
    this.ssu = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.ssu, localIntentFilter);
  }
  
  private void cJT()
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.ssv) });
    if (this.ssv)
    {
      ac.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.ssx.au(60000L, 60000L);
    this.ssy.au(1000L, 1000L);
    aQH();
    this.ssv = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.iyx.h(localIntent, this);
    }
  }
  
  protected final void BY(int paramInt)
  {
    this.sso.setOnClickListener(null);
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.sso.setImageResource(2131232440);
      this.ssp.setText(2131757569);
      if (this.dbL == 3) {
        this.ssq.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.ssr.setVisibility(8);
      return;
      this.sso.setImageResource(2131232440);
      this.sso.setState(3);
      this.sso.pGo = 2;
      this.ssp.setText(2131757573);
      this.ssr.setVisibility(0);
      this.ssr.setText(2131759649);
      this.ssx.stopTimer();
      this.ssy.stopTimer();
      return;
      this.sso.setImageResource(2131232438);
      this.sso.setState(2);
      this.ssp.setText(2131757568);
      this.ssr.setVisibility(0);
      this.ssr.setText(2131759607);
      this.ssx.stopTimer();
      this.ssy.stopTimer();
      if ((this.dbL == 1) || (this.dbL == 5) || (this.dbL == 4))
      {
        this.ssr.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.cJk().afA(this.ssid);
        if ((localc != null) && (!bs.isNullOrNil(localc.field_showUrl)) && (!this.ssw))
        {
          this.ssw = true;
          ap.n(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      c.report();
      return;
      this.sso.setImageResource(2131232440);
      this.sso.setState(1);
      this.ssp.setText(2131757569);
      continue;
      this.ssx.stopTimer();
      this.ssy.stopTimer();
      this.sso.setImageResource(2131232439);
      this.sso.setState(3);
      this.ssp.setText(2131759635);
      this.ssp.setVisibility(0);
      this.ssq.setText(2131759636);
      this.ssq.setVisibility(0);
      continue;
      this.ssq.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public final void Fu(int paramInt)
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  protected abstract void aQH();
  
  protected abstract void cJL();
  
  protected abstract int cJM();
  
  protected final void cJO()
  {
    if (this.ssu != null)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
      ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.ssu.sqv = null;
    }
  }
  
  protected final void cJS()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.ssx.au(60000L, 60000L);
      this.ssy.au(1000L, 1000L);
      ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.cJn().cIW().post(new Runnable()
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
    this.dea = cJM();
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dea) });
    if (this.dea != 2)
    {
      this.ssx.au(60000L, 60000L);
      this.ssy.au(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.afs(this.ssid))
      {
        cJT();
        return;
      }
      j.cJn().cIW().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24976);
          ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiActivateStateUI.this.ssid });
          FreeWifiActivateStateUI.this.cJL();
          AppMethodBeat.o(24976);
        }
      });
      return;
    }
    BY(this.dea);
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
    this.sso = ((FreeWifiStateView)findViewById(2131300248));
    this.ssp = ((TextView)findViewById(2131300249));
    this.ssq = ((TextView)findViewById(2131300250));
    if (this.dbL == 3) {
      this.ssq.setText(getString(2131761229, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.ssr = ((Button)findViewById(2131303749));
      this.ssr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24973);
          if (FreeWifiActivateStateUI.this.cJM() == 2)
          {
            FreeWifiActivateStateUI.this.finish();
            AppMethodBeat.o(24973);
            return;
          }
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
          FreeWifiActivateStateUI.this.ssv = false;
          FreeWifiActivateStateUI.this.cJS();
          AppMethodBeat.o(24973);
        }
      });
      this.sss = ((Button)findViewById(2131300737));
      this.sss.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.ssq.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.sst = getIntent().getStringExtra("free_wifi_mid");
    this.nJQ = getIntent().getStringExtra("free_wifi_url");
    this.dbL = getIntent().getIntExtra("free_wifi_source", 1);
    this.cGY = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.dbL)
    {
    default: 
      if (bs.isNullOrNil(this.ssid)) {
        ac.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
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
        j.cJk().add(this.ssz);
        return;
        paramBundle = j.cJk().cJK();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.sst = paramBundle.field_mid;
          this.nJQ = paramBundle.field_url;
          ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.sst, this.nJQ });
          break;
        }
        ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bs.isNullOrNil(this.ssid)) {
          break label252;
        }
        ac.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.cJk().afA(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ah.dg(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nJQ;
      paramBundle.field_mid = this.sst;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.cJk().insert(paramBundle);
        break;
      }
      j.cJk().update(paramBundle, new String[0]);
      break;
      ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.sst, Integer.valueOf(this.dbL) });
      break label134;
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
  
  public void onResume()
  {
    super.onResume();
    if (!bs.isNullOrNil(this.ssid)) {
      cJS();
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