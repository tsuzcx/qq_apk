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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d;

public class FreeWifiSuccUI
  extends MMActivity
  implements f
{
  private String cvr;
  private String cwc;
  private Button iDz;
  private CheckBox kyz;
  private String mLh;
  private View mOE;
  private TextView mOF;
  private View mOG;
  private TextView mOH;
  private View mOI;
  private int mOJ;
  private boolean mOK = false;
  private boolean mOL = false;
  private TextView mOr;
  private int mOy;
  private String mOz;
  private String signature;
  
  private void bBG()
  {
    AppMethodBeat.i(21095);
    if (this.mOL)
    {
      AppMethodBeat.o(21095);
      return;
    }
    this.mOL = true;
    if ((this.mOK) && (!bo.isNullOrNil(this.cwc)) && ((!t.nU(this.cvr)) || (!t.nT(this.cvr))))
    {
      aw.Rc().a(1703, this);
      i locali = new i(this.cwc, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), com.tencent.mm.plugin.freewifi.m.U(getIntent()));
      aw.Rc().a(locali, 0);
    }
    l.b(d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.mOK);
    AppMethodBeat.o(21095);
  }
  
  public void finish()
  {
    AppMethodBeat.i(21091);
    super.finish();
    bBG();
    AppMethodBeat.o(21091);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969636;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21094);
    setMMTitle(2131300181);
    setBackBtnVisible(false);
    this.mOE = findViewById(2131824282);
    this.mOF = ((TextView)findViewById(2131824284));
    this.kyz = ((CheckBox)findViewById(2131824285));
    this.mOG = findViewById(2131824286);
    this.mOH = ((TextView)findViewById(2131824287));
    this.mOI = findViewById(2131824288);
    this.mOr = ((TextView)findViewById(2131824289));
    this.iDz = ((Button)findViewById(2131824291));
    this.iDz.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((bo.isNullOrNil(this.cwc)) || (bo.isNullOrNil(this.cvr)) || (bo.isNullOrNil(this.mLh)))
    {
      this.mOE.setVisibility(8);
      this.mOG.setVisibility(8);
      this.mOI.setVisibility(8);
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.freewifi.m.X(getIntent()) == 10)
      {
        String str = ac.erz.ere;
        if ((!com.tencent.mm.plugin.freewifi.m.isEmpty(str)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(ac.bH(getContext()))))
        {
          Button localButton = (Button)findViewById(2131824292);
          localButton.setText(String.format(getString(2131300180), new Object[] { ac.bH(getContext()) }));
          localButton.setOnClickListener(new FreeWifiSuccUI.4(this, str));
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(21094);
      return;
      if ((!t.nU(this.cvr)) || (!t.nT(this.cvr))) {
        break;
      }
      l.a(d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.mOE.setVisibility(8);
      this.mOG.setVisibility(8);
      this.mOI.setVisibility(0);
      this.mOr.setText(this.mLh);
      this.mOI.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.a(d.bAB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.mOI.setVisibility(8);
    this.mOE.setVisibility(0);
    if (bo.isNullOrNil(this.signature))
    {
      this.mOG.setVisibility(8);
      findViewById(2131824283).setBackgroundColor(getResources().getColor(2131690709));
      label483:
      this.mOF.setText(getString(2131300160, new Object[] { this.mLh }));
      if (this.mOJ != 1) {
        break label569;
      }
      this.kyz.setChecked(true);
    }
    for (this.mOK = true;; this.mOK = false)
    {
      this.kyz.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.mOG.setVisibility(0);
      this.mOH.setText(this.signature);
      break label483;
      label569:
      this.kyz.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21089);
    super.onCreate(paramBundle);
    this.cwc = getIntent().getStringExtra("free_wifi_appid");
    this.mLh = getIntent().getStringExtra("free_wifi_app_nickname");
    this.cvr = getIntent().getStringExtra("free_wifi_app_username");
    this.mOy = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.mOz = getIntent().getStringExtra("free_wifi_finish_url");
    this.mOJ = getIntent().getIntExtra(e.d.yVb, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.cwc, this.mLh, this.cvr, Integer.valueOf(this.mOy), this.mOz, this.signature });
    paramBundle = k.bAc();
    String str = com.tencent.mm.plugin.freewifi.m.Oy("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = at.gX(ah.getContext());
    paramBundle.bssid = at.gY(ah.getContext());
    paramBundle.coY = str;
    paramBundle.coX = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.mIC = this.cwc;
    paramBundle.kMp = com.tencent.mm.plugin.freewifi.m.U(getIntent());
    paramBundle.mIE = com.tencent.mm.plugin.freewifi.m.W(getIntent());
    paramBundle.mIF = k.b.mIR.mJq;
    paramBundle.mIG = k.b.mIR.name;
    paramBundle.cCy = com.tencent.mm.plugin.freewifi.m.X(getIntent());
    paramBundle.mIH = this.cvr;
    paramBundle.bAe().bAd();
    AppMethodBeat.o(21089);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21092);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      AppMethodBeat.o(21092);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21092);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21090);
    super.onResume();
    initView();
    AppMethodBeat.o(21090);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21093);
    ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    aw.Rc().b(1703, this);
    AppMethodBeat.o(21093);
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