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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cJR;
  protected int dep;
  private int dgF = 1;
  protected String nha;
  protected String rjA;
  protected FreeWifiNetworkReceiver rjB;
  protected boolean rjC = false;
  private boolean rjD = false;
  private av rjE = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24969);
      if (!bt.isNullOrNil(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cwA());
        ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this)) });
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        if (FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this) != 2)
        {
          FreeWifiActivateStateUI.this.cwE();
          FreeWifiActivateStateUI.this.cwC();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(24969);
      return false;
    }
  }, false);
  private av rjF = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24970);
      if (com.tencent.mm.plugin.freewifi.model.d.aaA(FreeWifiActivateStateUI.this.ssid))
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
  private k.a rjG = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(24971);
      FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cwA());
      FreeWifiActivateStateUI.this.Bg(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this));
      AppMethodBeat.o(24971);
    }
  };
  private FreeWifiStateView rjv;
  private TextView rjw;
  private TextView rjx;
  private Button rjy;
  protected Button rjz;
  protected String ssid;
  
  private void cwF()
  {
    this.rjB = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.rjB, localIntentFilter);
  }
  
  private void cwH()
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.rjC) });
    if (this.rjC)
    {
      ad.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.rjE.av(60000L, 60000L);
    this.rjF.av(1000L, 1000L);
    aJQ();
    this.rjC = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.hYt.h(localIntent, this);
    }
  }
  
  protected final void Bg(int paramInt)
  {
    this.rjv.setOnClickListener(null);
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.rjv.setImageResource(2131232440);
      this.rjw.setText(2131757569);
      if (this.dep == 3) {
        this.rjx.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.rjy.setVisibility(8);
      return;
      this.rjv.setImageResource(2131232440);
      this.rjv.setState(3);
      this.rjv.pdd = 2;
      this.rjw.setText(2131757573);
      this.rjy.setVisibility(0);
      this.rjy.setText(2131759649);
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      return;
      this.rjv.setImageResource(2131232438);
      this.rjv.setState(2);
      this.rjw.setText(2131757568);
      this.rjy.setVisibility(0);
      this.rjy.setText(2131759607);
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      if ((this.dep == 1) || (this.dep == 5) || (this.dep == 4))
      {
        this.rjy.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.cvY().aaI(this.ssid);
        if ((localc != null) && (!bt.isNullOrNil(localc.field_showUrl)) && (!this.rjD))
        {
          this.rjD = true;
          aq.n(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      c.report();
      return;
      this.rjv.setImageResource(2131232440);
      this.rjv.setState(1);
      this.rjw.setText(2131757569);
      continue;
      this.rjE.stopTimer();
      this.rjF.stopTimer();
      this.rjv.setImageResource(2131232439);
      this.rjv.setState(3);
      this.rjw.setText(2131759635);
      this.rjw.setVisibility(0);
      this.rjx.setText(2131759636);
      this.rjx.setVisibility(0);
      continue;
      this.rjx.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public final void Dy(int paramInt)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  protected abstract void aJQ();
  
  protected abstract int cwA();
  
  protected final void cwC()
  {
    if (this.rjB != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.rjB.rhC = null;
    }
  }
  
  protected final void cwG()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.rjE.av(60000L, 60000L);
      this.rjF.av(1000L, 1000L);
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.cwb().cvK().post(new Runnable()
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
    this.dgF = cwA();
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dgF) });
    if (this.dgF != 2)
    {
      this.rjE.av(60000L, 60000L);
      this.rjF.av(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.aaA(this.ssid))
      {
        cwH();
        return;
      }
      j.cwb().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24976);
          ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiActivateStateUI.this.ssid });
          FreeWifiActivateStateUI.this.cwz();
          AppMethodBeat.o(24976);
        }
      });
      return;
    }
    Bg(this.dgF);
  }
  
  protected abstract void cwz();
  
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
    this.rjv = ((FreeWifiStateView)findViewById(2131300248));
    this.rjw = ((TextView)findViewById(2131300249));
    this.rjx = ((TextView)findViewById(2131300250));
    if (this.dep == 3) {
      this.rjx.setText(getString(2131761229, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.rjy = ((Button)findViewById(2131303749));
      this.rjy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24973);
          if (FreeWifiActivateStateUI.this.cwA() == 2)
          {
            FreeWifiActivateStateUI.this.finish();
            AppMethodBeat.o(24973);
            return;
          }
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
          FreeWifiActivateStateUI.this.rjC = false;
          FreeWifiActivateStateUI.this.cwG();
          AppMethodBeat.o(24973);
        }
      });
      this.rjz = ((Button)findViewById(2131300737));
      this.rjz.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.rjx.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.rjA = getIntent().getStringExtra("free_wifi_mid");
    this.nha = getIntent().getStringExtra("free_wifi_url");
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    this.cJR = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.dep)
    {
    default: 
      if (bt.isNullOrNil(this.ssid)) {
        ad.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
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
        j.cvY().add(this.rjG);
        return;
        paramBundle = j.cvY().cwy();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.rjA = paramBundle.field_mid;
          this.nha = paramBundle.field_url;
          ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.rjA, this.nha });
          break;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bt.isNullOrNil(this.ssid)) {
          break label252;
        }
        ad.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.cvY().aaI(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ai.du(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.nha;
      paramBundle.field_mid = this.rjA;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.cvY().insert(paramBundle);
        break;
      }
      j.cvY().update(paramBundle, new String[0]);
      break;
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.rjA, Integer.valueOf(this.dep) });
      break label134;
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
  
  public void onResume()
  {
    super.onResume();
    if (!bt.isNullOrNil(this.ssid)) {
      cwG();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
 * JD-Core Version:    0.7.0.1
 */