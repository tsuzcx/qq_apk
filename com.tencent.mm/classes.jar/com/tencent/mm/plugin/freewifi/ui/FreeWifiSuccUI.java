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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;

public class FreeWifiSuccUI
  extends MMActivity
  implements g
{
  private String dkB;
  private String dlB;
  private Button fsF;
  private CheckBox nDS;
  private String ril;
  private View rlA;
  private int rlB;
  private boolean rlC = false;
  private boolean rlD = false;
  private TextView rlj;
  private int rlq;
  private String rlr;
  private View rlw;
  private TextView rlx;
  private View rly;
  private TextView rlz;
  private String signature;
  
  private void cwT()
  {
    AppMethodBeat.i(25155);
    if (this.rlD)
    {
      AppMethodBeat.o(25155);
      return;
    }
    this.rlD = true;
    if ((this.rlC) && (!bt.isNullOrNil(this.dlB)) && ((!w.sE(this.dkB)) || (!w.sD(this.dkB))))
    {
      az.aeS().a(1703, this);
      i locali = new i(this.dlB, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.ai(getIntent()));
      az.aeS().a(locali, 0);
    }
    l.d(d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.rlC);
    AppMethodBeat.o(25155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25151);
    super.finish();
    cwT();
    AppMethodBeat.o(25151);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494178;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25154);
    setMMTitle(2131759653);
    setBackBtnVisible(false);
    this.rlw = findViewById(2131300281);
    this.rlx = ((TextView)findViewById(2131300282));
    this.nDS = ((CheckBox)findViewById(2131300279));
    this.rly = findViewById(2131300276);
    this.rlz = ((TextView)findViewById(2131300277));
    this.rlA = findViewById(2131300283);
    this.rlj = ((TextView)findViewById(2131300278));
    this.fsF = ((Button)findViewById(2131298577));
    this.fsF.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((bt.isNullOrNil(this.dlB)) || (bt.isNullOrNil(this.dkB)) || (bt.isNullOrNil(this.ril)))
    {
      this.rlw.setVisibility(8);
      this.rly.setVisibility(8);
      this.rlA.setVisibility(8);
    }
    for (;;)
    {
      if (m.al(getIntent()) == 10)
      {
        String str = ae.fFB.fEN;
        if ((!m.dq(str)) && (!m.dq(ae.bW(getContext()))))
        {
          Button localButton = (Button)findViewById(2131300285);
          localButton.setText(String.format(getString(2131759652), new Object[] { ae.bW(getContext()) }));
          localButton.setOnClickListener(new FreeWifiSuccUI.4(this, str));
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(25154);
      return;
      if ((!w.sE(this.dkB)) || (!w.sD(this.dkB))) {
        break;
      }
      l.c(d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.rlw.setVisibility(8);
      this.rly.setVisibility(8);
      this.rlA.setVisibility(0);
      this.rlj.setText(this.ril);
      this.rlA.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.c(d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.rlA.setVisibility(8);
    this.rlw.setVisibility(0);
    if (bt.isNullOrNil(this.signature))
    {
      this.rly.setVisibility(8);
      findViewById(2131300280).setBackgroundColor(getResources().getColor(2131101179));
      label483:
      this.rlx.setText(getString(2131759632, new Object[] { this.ril }));
      if (this.rlB != 1) {
        break label569;
      }
      this.nDS.setChecked(true);
    }
    for (this.rlC = true;; this.rlC = false)
    {
      this.nDS.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.rly.setVisibility(0);
      this.rlz.setText(this.signature);
      break label483;
      label569:
      this.nDS.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25149);
    super.onCreate(paramBundle);
    this.dlB = getIntent().getStringExtra("free_wifi_appid");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dkB = getIntent().getStringExtra("free_wifi_app_username");
    this.rlq = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.rlr = getIntent().getStringExtra("free_wifi_finish_url");
    this.rlB = getIntent().getIntExtra(e.f.FHX, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dlB, this.ril, this.dkB, Integer.valueOf(this.rlq), this.rlr, this.signature });
    paramBundle = k.cvq();
    String str = m.aaw("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = ay.iA(aj.getContext());
    paramBundle.bssid = ay.iB(aj.getContext());
    paramBundle.ddV = str;
    paramBundle.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.rfK = this.dlB;
    paramBundle.nSA = m.ai(getIntent());
    paramBundle.rfL = m.ak(getIntent());
    paramBundle.rfM = k.b.rfY.rgx;
    paramBundle.rfN = k.b.rfY.name;
    paramBundle.channel = m.al(getIntent());
    paramBundle.rfO = this.dkB;
    paramBundle.cvs().cvr();
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25153);
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.aeS().b(1703, this);
    AppMethodBeat.o(25153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI
 * JD-Core Version:    0.7.0.1
 */