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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.ba;
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
  implements f
{
  private String dtE;
  private String duW;
  private Button fPz;
  private CheckBox oKm;
  private String signature;
  private String tnF;
  private TextView tqE;
  private int tqL;
  private String tqM;
  private View tqR;
  private TextView tqS;
  private View tqT;
  private TextView tqU;
  private View tqV;
  private int tqW;
  private boolean tqX = false;
  private boolean tqY = false;
  
  private void cSu()
  {
    AppMethodBeat.i(25155);
    if (this.tqY)
    {
      AppMethodBeat.o(25155);
      return;
    }
    this.tqY = true;
    if ((this.tqX) && (!bt.isNullOrNil(this.duW)) && ((!w.zE(this.dtE)) || (!w.zD(this.dtE))))
    {
      ba.aiU().a(1703, this);
      i locali = new i(this.duW, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.ao(getIntent()));
      ba.aiU().a(locali, 0);
    }
    l.d(d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.tqX);
    AppMethodBeat.o(25155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25151);
    super.finish();
    cSu();
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
    this.tqR = findViewById(2131300281);
    this.tqS = ((TextView)findViewById(2131300282));
    this.oKm = ((CheckBox)findViewById(2131300279));
    this.tqT = findViewById(2131300276);
    this.tqU = ((TextView)findViewById(2131300277));
    this.tqV = findViewById(2131300283);
    this.tqE = ((TextView)findViewById(2131300278));
    this.fPz = ((Button)findViewById(2131298577));
    this.fPz.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((bt.isNullOrNil(this.duW)) || (bt.isNullOrNil(this.dtE)) || (bt.isNullOrNil(this.tnF)))
    {
      this.tqR.setVisibility(8);
      this.tqT.setVisibility(8);
      this.tqV.setVisibility(8);
    }
    for (;;)
    {
      if (m.ar(getIntent()) == 10)
      {
        String str = ae.gcJ.gbU;
        if ((!m.ea(str)) && (!m.ea(ae.bX(getContext()))))
        {
          Button localButton = (Button)findViewById(2131300285);
          localButton.setText(String.format(getString(2131759652), new Object[] { ae.bX(getContext()) }));
          localButton.setOnClickListener(new FreeWifiSuccUI.4(this, str));
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(25154);
      return;
      if ((!w.zE(this.dtE)) || (!w.zD(this.dtE))) {
        break;
      }
      l.c(d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.tqR.setVisibility(8);
      this.tqT.setVisibility(8);
      this.tqV.setVisibility(0);
      this.tqE.setText(this.tnF);
      this.tqV.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.c(d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.tqV.setVisibility(8);
    this.tqR.setVisibility(0);
    if (bt.isNullOrNil(this.signature))
    {
      this.tqT.setVisibility(8);
      findViewById(2131300280).setBackgroundColor(getResources().getColor(2131101179));
      label483:
      this.tqS.setText(getString(2131759632, new Object[] { this.tnF }));
      if (this.tqW != 1) {
        break label569;
      }
      this.oKm.setChecked(true);
    }
    for (this.tqX = true;; this.tqX = false)
    {
      this.oKm.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.tqT.setVisibility(0);
      this.tqU.setText(this.signature);
      break label483;
      label569:
      this.oKm.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25149);
    super.onCreate(paramBundle);
    this.duW = getIntent().getStringExtra("free_wifi_appid");
    this.tnF = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dtE = getIntent().getStringExtra("free_wifi_app_username");
    this.tqL = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.tqM = getIntent().getStringExtra("free_wifi_finish_url");
    this.tqW = getIntent().getIntExtra(e.f.IUv, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.duW, this.tnF, this.dtE, Integer.valueOf(this.tqL), this.tqM, this.signature });
    paramBundle = k.cQR();
    String str = m.ajM("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = ay.iV(aj.getContext());
    paramBundle.bssid = ay.iW(aj.getContext());
    paramBundle.dmN = str;
    paramBundle.dmM = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.tlf = this.duW;
    paramBundle.oZp = m.ao(getIntent());
    paramBundle.tlg = m.aq(getIntent());
    paramBundle.tlh = k.b.tlt.tlS;
    paramBundle.tli = k.b.tlt.name;
    paramBundle.channel = m.ar(getIntent());
    paramBundle.tlj = this.dtE;
    paramBundle.cQT().cQS();
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
    ba.aiU().b(1703, this);
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