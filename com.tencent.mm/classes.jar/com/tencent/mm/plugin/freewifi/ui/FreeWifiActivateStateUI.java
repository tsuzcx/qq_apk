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
  protected int cSc;
  protected int dnh;
  private int dpw = 1;
  protected String omw;
  protected String ssid;
  private FreeWifiStateView toQ;
  private TextView toR;
  private TextView toS;
  private Button toT;
  protected Button toU;
  protected String toV;
  protected FreeWifiNetworkReceiver toW;
  protected boolean toX = false;
  private boolean toY = false;
  private av toZ = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24969);
      if (!bt.isNullOrNil(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cSb());
        ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this)) });
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        if (FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this) != 2)
        {
          FreeWifiActivateStateUI.this.cSf();
          FreeWifiActivateStateUI.this.cSd();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(24969);
      return false;
    }
  }, false);
  private av tpa = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24970);
      if (com.tencent.mm.plugin.freewifi.model.d.ajQ(FreeWifiActivateStateUI.this.ssid))
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
  private k.a tpb = new k.a()
  {
    public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
    {
      AppMethodBeat.i(24971);
      FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.cSb());
      FreeWifiActivateStateUI.this.CH(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this));
      AppMethodBeat.o(24971);
    }
  };
  
  private void cSg()
  {
    this.toW = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.toW, localIntentFilter);
  }
  
  private void cSi()
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.toX) });
    if (this.toX)
    {
      ad.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.toZ.az(60000L, 60000L);
    this.tpa.az(1000L, 1000L);
    aTT();
    this.toX = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.iRG.h(localIntent, this);
    }
  }
  
  protected final void CH(int paramInt)
  {
    this.toQ.setOnClickListener(null);
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.toQ.setImageResource(2131232440);
      this.toR.setText(2131757569);
      if (this.dnh == 3) {
        this.toS.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.toT.setVisibility(8);
      return;
      this.toQ.setImageResource(2131232440);
      this.toQ.setState(3);
      this.toQ.qjT = 2;
      this.toR.setText(2131757573);
      this.toT.setVisibility(0);
      this.toT.setText(2131759649);
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      return;
      this.toQ.setImageResource(2131232438);
      this.toQ.setState(2);
      this.toR.setText(2131757568);
      this.toT.setVisibility(0);
      this.toT.setText(2131759607);
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      if ((this.dnh == 1) || (this.dnh == 5) || (this.dnh == 4))
      {
        this.toT.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.cRz().ajY(this.ssid);
        if ((localc != null) && (!bt.isNullOrNil(localc.field_showUrl)) && (!this.toY))
        {
          this.toY = true;
          aq.o(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      c.report();
      return;
      this.toQ.setImageResource(2131232440);
      this.toQ.setState(1);
      this.toR.setText(2131757569);
      continue;
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      this.toQ.setImageResource(2131232439);
      this.toQ.setState(3);
      this.toR.setText(2131759635);
      this.toR.setVisibility(0);
      this.toS.setText(2131759636);
      this.toS.setVisibility(0);
      continue;
      this.toS.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public final void GJ(int paramInt)
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
    cSd();
    cSh();
  }
  
  protected abstract void aTT();
  
  protected abstract void cSa();
  
  protected abstract int cSb();
  
  protected final void cSd()
  {
    if (this.toW != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
      this.toW.tmW = null;
    }
  }
  
  protected final void cSe()
  {
    if (this.toW == null) {
      cSg();
    }
    this.toW.tmX = this;
  }
  
  protected final void cSf()
  {
    if (this.toW != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.toW.tmX = null;
    }
  }
  
  protected final void cSh()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.toZ.az(60000L, 60000L);
      this.tpa.az(1000L, 1000L);
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.cRC().cRl().post(new Runnable()
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
    this.dpw = cSb();
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dpw) });
    if (this.dpw != 2)
    {
      this.toZ.az(60000L, 60000L);
      this.tpa.az(1000L, 1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.ajQ(this.ssid))
      {
        cSi();
        return;
      }
      j.cRC().cRl().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24976);
          ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiActivateStateUI.this.ssid });
          FreeWifiActivateStateUI.this.cSa();
          AppMethodBeat.o(24976);
        }
      });
      return;
    }
    CH(this.dpw);
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
    this.toQ = ((FreeWifiStateView)findViewById(2131300248));
    this.toR = ((TextView)findViewById(2131300249));
    this.toS = ((TextView)findViewById(2131300250));
    if (this.dnh == 3) {
      this.toS.setText(getString(2131761229, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.toT = ((Button)findViewById(2131303749));
      this.toT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24973);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (FreeWifiActivateStateUI.this.cSb() == 2) {
            FreeWifiActivateStateUI.this.finish();
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24973);
            return;
            com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
            FreeWifiActivateStateUI.this.toX = false;
            FreeWifiActivateStateUI.this.cSh();
          }
        }
      });
      this.toU = ((Button)findViewById(2131300737));
      this.toU.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.toS.setText(getString(2131757572, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.toV = getIntent().getStringExtra("free_wifi_mid");
    this.omw = getIntent().getStringExtra("free_wifi_url");
    this.dnh = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSc = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.dnh)
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
        j.cRz().add(this.tpb);
        return;
        paramBundle = j.cRz().cRZ();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.toV = paramBundle.field_mid;
          this.omw = paramBundle.field_url;
          ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.toV, this.omw });
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
      paramBundle = j.cRz().ajY(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ai.ee(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.omw;
      paramBundle.field_mid = this.toV;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.cRz().insert(paramBundle);
        break;
      }
      j.cRz().update(paramBundle, new String[0]);
      break;
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.toV, Integer.valueOf(this.dnh) });
      break label134;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.cRz().remove(this.tpb);
    cSd();
    cSf();
    if (this.toW != null) {
      unregisterReceiver(this.toW);
    }
    this.toZ.stopTimer();
    this.tpa.stopTimer();
    j.cRC().release();
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
      cSh();
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