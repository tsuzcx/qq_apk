package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f;

public class FreeWifiSuccUI
  extends MMActivity
  implements g
{
  private String dia;
  private String djj;
  private Button fwm;
  private CheckBox ogT;
  private String signature;
  private String sre;
  private TextView suc;
  private int suj;
  private String suk;
  private View suq;
  private TextView sur;
  private View sus;
  private TextView sut;
  private View suu;
  private int suv;
  private boolean suw = false;
  private boolean sux = false;
  
  private void cKf()
  {
    AppMethodBeat.i(25155);
    if (this.sux)
    {
      AppMethodBeat.o(25155);
      return;
    }
    this.sux = true;
    if ((this.suw) && (!bs.isNullOrNil(this.djj)) && ((!w.wH(this.dia)) || (!w.wG(this.dia))))
    {
      az.agi().a(1703, this);
      i locali = new i(this.djj, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.aj(getIntent()));
      az.agi().a(locali, 0);
    }
    l.d(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.suw);
    AppMethodBeat.o(25155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25151);
    super.finish();
    cKf();
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
    this.suq = findViewById(2131300281);
    this.sur = ((TextView)findViewById(2131300282));
    this.ogT = ((CheckBox)findViewById(2131300279));
    this.sus = findViewById(2131300276);
    this.sut = ((TextView)findViewById(2131300277));
    this.suu = findViewById(2131300283);
    this.suc = ((TextView)findViewById(2131300278));
    this.fwm = ((Button)findViewById(2131298577));
    this.fwm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25145);
        FreeWifiSuccUI.this.finish();
        FreeWifiSuccUI.a(FreeWifiSuccUI.this);
        AppMethodBeat.o(25145);
      }
    });
    if ((bs.isNullOrNil(this.djj)) || (bs.isNullOrNil(this.dia)) || (bs.isNullOrNil(this.sre)))
    {
      this.suq.setVisibility(8);
      this.sus.setVisibility(8);
      this.suu.setVisibility(8);
    }
    for (;;)
    {
      if (m.am(getIntent()) == 10)
      {
        final String str = ae.fJi.fIu;
        if ((!m.cX(str)) && (!m.cX(ae.bZ(getContext()))))
        {
          Button localButton = (Button)findViewById(2131300285);
          localButton.setText(String.format(getString(2131759652), new Object[] { ae.bZ(getContext()) }));
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25148);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", str);
              com.tencent.mm.br.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
              AppMethodBeat.o(25148);
            }
          });
          localButton.setVisibility(0);
        }
      }
      AppMethodBeat.o(25154);
      return;
      if ((!w.wH(this.dia)) || (!w.wG(this.dia))) {
        break;
      }
      l.c(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
      this.suq.setVisibility(8);
      this.sus.setVisibility(8);
      this.suu.setVisibility(0);
      this.suc.setText(this.sre);
      this.suu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25146);
          if (!bs.isNullOrNil(FreeWifiSuccUI.b(FreeWifiSuccUI.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", FreeWifiSuccUI.b(FreeWifiSuccUI.this));
            com.tencent.mm.br.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
          AppMethodBeat.o(25146);
        }
      });
    }
    l.c(com.tencent.mm.plugin.freewifi.model.d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
    this.suu.setVisibility(8);
    this.suq.setVisibility(0);
    if (bs.isNullOrNil(this.signature))
    {
      this.sus.setVisibility(8);
      findViewById(2131300280).setBackgroundColor(getResources().getColor(2131101179));
      label483:
      this.sur.setText(getString(2131759632, new Object[] { this.sre }));
      if (this.suv != 1) {
        break label569;
      }
      this.ogT.setChecked(true);
    }
    for (this.suw = true;; this.suw = false)
    {
      this.ogT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25147);
          if (paramAnonymousBoolean)
          {
            FreeWifiSuccUI.a(FreeWifiSuccUI.this, true);
            AppMethodBeat.o(25147);
            return;
          }
          FreeWifiSuccUI.a(FreeWifiSuccUI.this, false);
          AppMethodBeat.o(25147);
        }
      });
      break;
      this.sus.setVisibility(0);
      this.sut.setText(this.signature);
      break label483;
      label569:
      this.ogT.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25149);
    super.onCreate(paramBundle);
    this.djj = getIntent().getStringExtra("free_wifi_appid");
    this.sre = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dia = getIntent().getStringExtra("free_wifi_app_username");
    this.suj = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.suk = getIntent().getStringExtra("free_wifi_finish_url");
    this.suv = getIntent().getIntExtra(e.f.Hhf, 0);
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    ac.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.djj, this.sre, this.dia, Integer.valueOf(this.suj), this.suk, this.signature });
    paramBundle = k.cIC();
    String str = m.afo("MicroMsg.FreeWifi.FreeWifiSuccUI");
    paramBundle.ssid = ax.iL(ai.getContext());
    paramBundle.bssid = ax.iM(ai.getContext());
    paramBundle.dbr = str;
    paramBundle.dbq = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.soC = this.djj;
    paramBundle.ovU = m.aj(getIntent());
    paramBundle.soD = m.al(getIntent());
    paramBundle.soE = k.b.soQ.spp;
    paramBundle.soF = k.b.soQ.name;
    paramBundle.channel = m.am(getIntent());
    paramBundle.soG = this.dia;
    paramBundle.cIE().cID();
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
    ac.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.agi().b(1703, this);
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