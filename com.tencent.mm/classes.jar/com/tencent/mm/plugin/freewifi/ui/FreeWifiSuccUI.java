package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;

public class FreeWifiSuccUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String appUserName;
  private String dNI;
  private Button gwO;
  private CheckBox qeC;
  private String signature;
  private String wPA;
  private int wSD;
  private String wSE;
  private View wSJ;
  private TextView wSK;
  private View wSL;
  private TextView wSM;
  private View wSN;
  private int wSO;
  private boolean wSP = false;
  private boolean wSQ = false;
  private TextView wSw;
  
  private void dOi()
  {
    AppMethodBeat.i(25155);
    if (this.wSQ)
    {
      AppMethodBeat.o(25155);
      return;
    }
    this.wSQ = true;
    if ((this.wSP) && (!Util.isNullOrNil(this.dNI)) && ((!ab.IT(this.appUserName)) || (!ab.IS(this.appUserName))))
    {
      bg.azz().a(1703, this);
      com.tencent.mm.plugin.freewifi.model.i locali = new com.tencent.mm.plugin.freewifi.model.i(this.dNI, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.aw(getIntent()));
      bg.azz().a(locali, 0);
    }
    l.c(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.wSP);
    AppMethodBeat.o(25155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25151);
    super.finish();
    dOi();
    AppMethodBeat.o(25151);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25154);
    setMMTitle(2131760974);
    setBackBtnVisible(false);
    this.wSJ = findViewById(2131301760);
    this.wSK = ((TextView)findViewById(2131301761));
    this.qeC = ((CheckBox)findViewById(2131301758));
    this.wSL = findViewById(2131301755);
    this.wSM = ((TextView)findViewById(2131301756));
    this.wSN = findViewById(2131301762);
    this.wSw = ((TextView)findViewById(2131301757));
    this.gwO = ((Button)findViewById(2131299014));
    this.gwO.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((Util.isNullOrNil(this.dNI)) || (Util.isNullOrNil(this.appUserName)) || (Util.isNullOrNil(this.wPA)))
    {
      this.wSJ.setVisibility(8);
      this.wSL.setVisibility(8);
      this.wSN.setVisibility(8);
    }
    for (;;)
    {
      if (m.az(getIntent()) == 10)
      {
        String str = ae.gKy.gJB;
        if ((!m.eP(str)) && (!m.eP(ae.cu(getContext()))))
        {
          Button localButton = (Button)findViewById(2131301764);
          localButton.setText(String.format(getString(2131760973), new Object[] { ae.cu(getContext()) }));
          localButton.setOnClickListener(new FreeWifiSuccUI.4(this, str));
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(25154);
      return;
      if ((!ab.IT(this.appUserName)) || (!ab.IS(this.appUserName))) {
        break;
      }
      l.b(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.wSJ.setVisibility(8);
      this.wSL.setVisibility(8);
      this.wSN.setVisibility(0);
      this.wSw.setText(this.wPA);
      this.wSN.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.b(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.wSN.setVisibility(8);
    this.wSJ.setVisibility(0);
    if (Util.isNullOrNil(this.signature))
    {
      this.wSL.setVisibility(8);
      findViewById(2131301759).setBackgroundColor(getResources().getColor(2131101424));
      label483:
      this.wSK.setText(getString(2131760953, new Object[] { this.wPA }));
      if (this.wSO != 1) {
        break label569;
      }
      this.qeC.setChecked(true);
    }
    for (this.wSP = true;; this.wSP = false)
    {
      this.qeC.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.wSL.setVisibility(0);
      this.wSM.setText(this.signature);
      break label483;
      label569:
      this.qeC.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25149);
    super.onCreate(paramBundle);
    this.dNI = getIntent().getStringExtra("free_wifi_appid");
    this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
    this.appUserName = getIntent().getStringExtra("free_wifi_app_username");
    this.wSD = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.wSE = getIntent().getStringExtra("free_wifi_finish_url");
    this.wSO = getIntent().getIntExtra(e.h.Ozc, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dNI, this.wPA, this.appUserName, Integer.valueOf(this.wSD), this.wSE, this.signature });
    paramBundle = k.dMF();
    String str = m.axO("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    paramBundle.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    paramBundle.dFe = str;
    paramBundle.dFd = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.wNb = this.dNI;
    paramBundle.quX = m.aw(getIntent());
    paramBundle.wNc = m.ay(getIntent());
    paramBundle.wNd = k.b.wNp.wNO;
    paramBundle.wNe = k.b.wNp.name;
    paramBundle.channel = m.az(getIntent());
    paramBundle.wNf = this.appUserName;
    paramBundle.dMH().dMG();
    AppMethodBeat.o(25149);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25152);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      AppMethodBeat.o(25152);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25152);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25150);
    super.onResume();
    initView();
    AppMethodBeat.o(25150);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25153);
    Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bg.azz().b(1703, this);
    AppMethodBeat.o(25153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI
 * JD-Core Version:    0.7.0.1
 */