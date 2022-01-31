package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;

public class FreeWifiSuccUI
  extends MMActivity
  implements f
{
  private String bNZ;
  private String bOL;
  private CheckBox ixw;
  private String kpv;
  private TextView ksC;
  private int ksJ;
  private String ksK;
  private View ksP;
  private TextView ksQ;
  private View ksR;
  private TextView ksS;
  private View ksT;
  private Button ksU;
  private int ksV;
  private boolean ksW = false;
  private boolean ksX = false;
  private String signature;
  
  private void aVh()
  {
    if (this.ksX) {
      return;
    }
    this.ksX = true;
    if ((this.ksW) && (!bk.bl(this.bOL)) && ((!com.tencent.mm.model.s.hl(this.bNZ)) || (!com.tencent.mm.model.s.hk(this.bNZ))))
    {
      au.Dk().a(1703, this);
      i locali = new i(this.bOL, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), com.tencent.mm.plugin.freewifi.m.B(getIntent()));
      au.Dk().a(locali, 0);
    }
    l.b(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.ksW);
  }
  
  public void finish()
  {
    super.finish();
    aVh();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_succ_page;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.free_wifi_title);
    mT(false);
    this.ksP = findViewById(R.h.free_wifi_succ_follow_outter);
    this.ksQ = ((TextView)findViewById(R.h.free_wifi_succ_follow_title_tv));
    this.ixw = ((CheckBox)findViewById(R.h.free_wifi_succ_follow_cb));
    this.ksR = findViewById(R.h.free_wifi_succ_appdesc_outter);
    this.ksS = ((TextView)findViewById(R.h.free_wifi_succ_appdesc_tv));
    this.ksT = findViewById(R.h.free_wifi_succ_profile_outter);
    this.ksC = ((TextView)findViewById(R.h.free_wifi_succ_appname_tv));
    this.ksU = ((Button)findViewById(R.h.connect_wifi_finish_btn));
    this.ksU.setOnClickListener(new FreeWifiSuccUI.1(this));
    if ((bk.bl(this.bOL)) || (bk.bl(this.bNZ)) || (bk.bl(this.kpv)))
    {
      this.ksP.setVisibility(8);
      this.ksR.setVisibility(8);
      this.ksT.setVisibility(8);
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.freewifi.m.E(getIntent()) == 10)
      {
        final String str = q.dyi.dyE;
        if ((!com.tencent.mm.plugin.freewifi.m.isEmpty(str)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(q.bc(this.mController.uMN))))
        {
          Button localButton = (Button)findViewById(R.h.free_wifi_succui_manufacturer_link);
          localButton.setText(String.format(getString(R.l.free_wifi_succ_manu_wording), new Object[] { q.bc(this.mController.uMN) }));
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", str);
              com.tencent.mm.br.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
          });
          localButton.setVisibility(0);
        }
      }
      return;
      if ((!com.tencent.mm.model.s.hl(this.bNZ)) || (!com.tencent.mm.model.s.hk(this.bNZ))) {
        break;
      }
      l.a(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.ksP.setVisibility(8);
      this.ksR.setVisibility(8);
      this.ksT.setVisibility(0);
      this.ksC.setText(this.kpv);
      this.ksT.setOnClickListener(new FreeWifiSuccUI.2(this));
    }
    l.a(com.tencent.mm.plugin.freewifi.model.d.aTZ(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.ksT.setVisibility(8);
    this.ksP.setVisibility(0);
    if (bk.bl(this.signature))
    {
      this.ksR.setVisibility(8);
      findViewById(R.h.free_wifi_succ_follow_item).setBackgroundColor(getResources().getColor(R.e.white));
      label477:
      this.ksQ.setText(getString(R.l.free_wifi_follow_tips, new Object[] { this.kpv }));
      if (this.ksV != 1) {
        break label563;
      }
      this.ixw.setChecked(true);
    }
    for (this.ksW = true;; this.ksW = false)
    {
      this.ixw.setOnCheckedChangeListener(new FreeWifiSuccUI.3(this));
      break;
      this.ksR.setVisibility(0);
      this.ksS.setText(this.signature);
      break label477;
      label563:
      this.ixw.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bOL = getIntent().getStringExtra("free_wifi_appid");
    this.kpv = getIntent().getStringExtra("free_wifi_app_nickname");
    this.bNZ = getIntent().getStringExtra("free_wifi_app_username");
    this.ksJ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.ksK = getIntent().getStringExtra("free_wifi_finish_url");
    this.ksV = getIntent().getIntExtra(e.c.uHQ, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    y.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.bOL, this.kpv, this.bNZ, Integer.valueOf(this.ksJ), this.ksK, this.signature });
    WifiInfo localWifiInfo = com.tencent.mm.plugin.freewifi.model.d.aTY();
    k.a locala = k.aTx();
    String str = localWifiInfo.getMacAddress();
    paramBundle = str;
    if (Build.VERSION.SDK_INT > 22) {
      if (str != null)
      {
        paramBundle = str;
        if (!str.equals("02:00:00:00:00:00")) {}
      }
      else
      {
        paramBundle = com.tencent.mm.plugin.freewifi.m.aTC();
      }
    }
    if (localWifiInfo != null)
    {
      locala.ssid = com.tencent.mm.plugin.freewifi.m.Dm(localWifiInfo.getSSID());
      locala.bssid = localWifiInfo.getBSSID();
      locala.bHJ = paramBundle;
    }
    locala.bHI = getIntent().getStringExtra("free_wifi_ap_key");
    locala.kmQ = this.bOL;
    locala.iGw = com.tencent.mm.plugin.freewifi.m.B(getIntent());
    locala.kmR = com.tencent.mm.plugin.freewifi.m.D(getIntent());
    locala.kmS = k.b.kne.knD;
    locala.kmT = k.b.kne.name;
    locala.bUR = com.tencent.mm.plugin.freewifi.m.E(getIntent());
    locala.kmU = this.bNZ;
    locala.aTz().aTy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    au.Dk().b(1703, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI
 * JD-Core Version:    0.7.0.1
 */