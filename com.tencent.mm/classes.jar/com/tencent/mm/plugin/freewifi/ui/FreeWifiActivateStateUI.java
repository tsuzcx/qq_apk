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
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int channelId;
  private int dHO = 1;
  protected String pFJ;
  protected int source;
  protected String ssid;
  private FreeWifiStateView wQJ;
  private TextView wQK;
  private TextView wQL;
  private Button wQM;
  protected Button wQN;
  protected String wQO;
  protected FreeWifiNetworkReceiver wQP;
  protected boolean wQQ = false;
  private boolean wQR = false;
  private MTimerHandler wQS = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24969);
      if (!Util.isNullOrNil(FreeWifiActivateStateUI.this.ssid))
      {
        FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.dNP());
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this)) });
        FreeWifiActivateStateUI.b(FreeWifiActivateStateUI.this).stopTimer();
        if (FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this) != 2)
        {
          FreeWifiActivateStateUI.this.dNT();
          FreeWifiActivateStateUI.this.dNR();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(24969);
      return false;
    }
  }, false);
  private MTimerHandler wQT = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(24970);
      if (com.tencent.mm.plugin.freewifi.model.d.axS(FreeWifiActivateStateUI.this.ssid))
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
  private MStorage.IOnStorageChange wQU = new MStorage.IOnStorageChange()
  {
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(24971);
      FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this, FreeWifiActivateStateUI.this.dNP());
      FreeWifiActivateStateUI.this.GE(FreeWifiActivateStateUI.a(FreeWifiActivateStateUI.this));
      AppMethodBeat.o(24971);
    }
  };
  
  private void dNU()
  {
    this.wQP = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.wQP, localIntentFilter);
  }
  
  private void dNW()
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.wQQ) });
    if (this.wQQ)
    {
      Log.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
      return;
    }
    this.wQS.startTimer(60000L);
    this.wQT.startTimer(1000L);
    bpf();
    this.wQQ = true;
  }
  
  private void goBack()
  {
    finish();
    if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false))
    {
      Intent localIntent = new Intent();
      g.jRt.h(localIntent, this);
    }
  }
  
  protected final void GE(int paramInt)
  {
    this.wQJ.setOnClickListener(null);
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.wQJ.setImageResource(2131232821);
      this.wQK.setText(2131757796);
      if (this.source == 3) {
        this.wQL.setText(getString(2131763044, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      this.wQM.setVisibility(8);
      return;
      this.wQJ.setImageResource(2131232821);
      this.wQJ.setState(3);
      this.wQJ.rHF = 2;
      this.wQK.setText(2131757800);
      this.wQM.setVisibility(0);
      this.wQM.setText(2131760970);
      this.wQS.stopTimer();
      this.wQT.stopTimer();
      return;
      this.wQJ.setImageResource(2131232819);
      this.wQJ.setState(2);
      this.wQK.setText(2131757795);
      this.wQM.setVisibility(0);
      this.wQM.setText(2131760928);
      this.wQS.stopTimer();
      this.wQT.stopTimer();
      if ((this.source == 1) || (this.source == 5) || (this.source == 4))
      {
        this.wQM.setVisibility(4);
        com.tencent.mm.plugin.freewifi.g.c localc = j.dNn().aya(this.ssid);
        if ((localc != null) && (!Util.isNullOrNil(localc.field_showUrl)) && (!this.wQR))
        {
          this.wQR = true;
          MMHandlerThread.postToMainThreadDelayed(new FreeWifiActivateStateUI.9(this, localc), 1000L);
        }
      }
      c.report();
      return;
      this.wQJ.setImageResource(2131232821);
      this.wQJ.setState(1);
      this.wQK.setText(2131757796);
      continue;
      this.wQS.stopTimer();
      this.wQT.stopTimer();
      this.wQJ.setImageResource(2131232820);
      this.wQJ.setState(3);
      this.wQK.setText(2131760956);
      this.wQK.setVisibility(0);
      this.wQL.setText(2131760957);
      this.wQL.setVisibility(0);
      continue;
      this.wQL.setText(getString(2131757799, new Object[] { this.ssid }));
    }
  }
  
  public final void Nf(int paramInt)
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  protected abstract void bpf();
  
  protected abstract void dNO();
  
  protected abstract int dNP();
  
  protected final void dNR()
  {
    if (this.wQP != null)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
      Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
      this.wQP.wOT = null;
    }
  }
  
  protected final void dNV()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.wQS.startTimer(60000L);
      this.wQT.startTimer(1000L);
      Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
      j.dNq().dMZ().post(new Runnable()
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
    this.dHO = dNP();
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dHO) });
    if (this.dHO != 2)
    {
      this.wQS.startTimer(60000L);
      this.wQT.startTimer(1000L);
      if (com.tencent.mm.plugin.freewifi.model.d.axS(this.ssid))
      {
        dNW();
        return;
      }
      j.dNq().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24976);
          Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiActivateStateUI.this.ssid });
          FreeWifiActivateStateUI.this.dNO();
          AppMethodBeat.o(24976);
        }
      });
      return;
    }
    GE(this.dHO);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494731;
  }
  
  public void initView()
  {
    setBackBtn(new FreeWifiActivateStateUI.4(this));
    this.wQJ = ((FreeWifiStateView)findViewById(2131301727));
    this.wQK = ((TextView)findViewById(2131301728));
    this.wQL = ((TextView)findViewById(2131301729));
    if (this.source == 3) {
      this.wQL.setText(getString(2131763044, new Object[] { this.ssid }));
    }
    for (;;)
    {
      this.wQM = ((Button)findViewById(2131306538));
      this.wQM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24973);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (FreeWifiActivateStateUI.this.dNP() == 2) {
            FreeWifiActivateStateUI.this.finish();
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24973);
            return;
            com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
            FreeWifiActivateStateUI.this.wQQ = false;
            FreeWifiActivateStateUI.this.dNV();
          }
        }
      });
      this.wQN = ((Button)findViewById(2131302321));
      this.wQN.setOnClickListener(new FreeWifiActivateStateUI.6(this));
      return;
      this.wQL.setText(getString(2131757799, new Object[] { this.ssid }));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.wQO = getIntent().getStringExtra("free_wifi_mid");
    this.pFJ = getIntent().getStringExtra("free_wifi_url");
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
    switch (this.source)
    {
    default: 
      if (Util.isNullOrNil(this.ssid)) {
        Log.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
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
        j.dNn().add(this.wQU);
        return;
        paramBundle = j.dNn().dNN();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.wQO = paramBundle.field_mid;
          this.pFJ = paramBundle.field_url;
          Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.wQO, this.pFJ });
          break;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!Util.isNullOrNil(this.ssid)) {
          break label252;
        }
        Log.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
      }
      label252:
      paramBundle = j.dNn().aya(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
        paramBundle.field_ssid = this.ssid;
        paramBundle.field_connectState = 1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.pFJ;
      paramBundle.field_mid = this.wQO;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      if (i != 0)
      {
        j.dNn().insert(paramBundle);
        break;
      }
      j.dNn().update(paramBundle, new String[0]);
      break;
      Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.wQO, Integer.valueOf(this.source) });
      break label134;
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
  
  public void onResume()
  {
    super.onResume();
    if (!Util.isNullOrNil(this.ssid)) {
      dNV();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
 * JD-Core Version:    0.7.0.1
 */