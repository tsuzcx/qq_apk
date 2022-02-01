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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;

public class FreeWifiSuccUI
  extends MMActivity
  implements f
{
  private String duJ;
  private String dwb;
  private Button fRF;
  private CheckBox oQO;
  private String signature;
  private int tBC;
  private String tBD;
  private View tBI;
  private TextView tBJ;
  private View tBK;
  private TextView tBL;
  private View tBM;
  private int tBN;
  private boolean tBO = false;
  private boolean tBP = false;
  private TextView tBv;
  private String tyx;
  
  private void cUZ()
  {
    AppMethodBeat.i(25155);
    if (this.tBP)
    {
      AppMethodBeat.o(25155);
      return;
    }
    this.tBP = true;
    if ((this.tBO) && (!bu.isNullOrNil(this.dwb)) && ((!x.Ao(this.duJ)) || (!x.An(this.duJ))))
    {
      bc.ajj().a(1703, this);
      i locali = new i(this.dwb, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.ap(getIntent()));
      bc.ajj().a(locali, 0);
    }
    l.d(d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.tBO);
    AppMethodBeat.o(25155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25151);
    super.finish();
    cUZ();
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
    this.tBI = findViewById(2131300281);
    this.tBJ = ((TextView)findViewById(2131300282));
    this.oQO = ((CheckBox)findViewById(2131300279));
    this.tBK = findViewById(2131300276);
    this.tBL = ((TextView)findViewById(2131300277));
    this.tBM = findViewById(2131300283);
    this.tBv = ((TextView)findViewById(2131300278));
    this.fRF = ((Button)findViewById(2131298577));
    this.fRF.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((bu.isNullOrNil(this.dwb)) || (bu.isNullOrNil(this.duJ)) || (bu.isNullOrNil(this.tyx)))
    {
      this.tBI.setVisibility(8);
      this.tBK.setVisibility(8);
      this.tBM.setVisibility(8);
    }
    for (;;)
    {
      if (m.as(getIntent()) == 10)
      {
        String str = com.tencent.mm.compatible.deviceinfo.ae.geR.gec;
        if ((!m.ef(str)) && (!m.ef(com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext()))))
        {
          Button localButton = (Button)findViewById(2131300285);
          localButton.setText(String.format(getString(2131759652), new Object[] { com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext()) }));
          localButton.setOnClickListener(new FreeWifiSuccUI.4(this, str));
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(25154);
      return;
      if ((!x.Ao(this.duJ)) || (!x.An(this.duJ))) {
        break;
      }
      l.c(d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.tBI.setVisibility(8);
      this.tBK.setVisibility(8);
      this.tBM.setVisibility(0);
      this.tBv.setText(this.tyx);
      this.tBM.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.c(d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.tBM.setVisibility(8);
    this.tBI.setVisibility(0);
    if (bu.isNullOrNil(this.signature))
    {
      this.tBK.setVisibility(8);
      findViewById(2131300280).setBackgroundColor(getResources().getColor(2131101179));
      label483:
      this.tBJ.setText(getString(2131759632, new Object[] { this.tyx }));
      if (this.tBN != 1) {
        break label569;
      }
      this.oQO.setChecked(true);
    }
    for (this.tBO = true;; this.tBO = false)
    {
      this.oQO.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.tBK.setVisibility(0);
      this.tBL.setText(this.signature);
      break label483;
      label569:
      this.oQO.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25149);
    super.onCreate(paramBundle);
    this.dwb = getIntent().getStringExtra("free_wifi_appid");
    this.tyx = getIntent().getStringExtra("free_wifi_app_nickname");
    this.duJ = getIntent().getStringExtra("free_wifi_app_username");
    this.tBC = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.tBD = getIntent().getStringExtra("free_wifi_finish_url");
    this.tBN = getIntent().getIntExtra(e.f.Jpd, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dwb, this.tyx, this.duJ, Integer.valueOf(this.tBC), this.tBD, this.signature });
    paramBundle = k.cTw();
    String str = m.akK("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = az.ja(ak.getContext());
    paramBundle.bssid = az.jb(ak.getContext());
    paramBundle.dnP = str;
    paramBundle.dnO = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.tvX = this.dwb;
    paramBundle.pfT = m.ap(getIntent());
    paramBundle.tvY = m.ar(getIntent());
    paramBundle.tvZ = k.b.twl.twK;
    paramBundle.twa = k.b.twl.name;
    paramBundle.channel = m.as(getIntent());
    paramBundle.twb = this.duJ;
    paramBundle.cTy().cTx();
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bc.ajj().b(1703, this);
    AppMethodBeat.o(25153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI
 * JD-Core Version:    0.7.0.1
 */