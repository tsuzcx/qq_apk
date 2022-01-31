package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ai.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private ad dnp = null;
  private ImageView dpY;
  private TextView eXr;
  private TextView eXu;
  private TextView feh;
  private TextView hdh;
  com.tencent.mm.ui.base.p hdi;
  
  private void apa()
  {
    a.b.a(this.dpY, this.dnp.field_username);
    this.feh.setText(this.dnp.Bq());
    if (a.gR(this.dnp.field_type))
    {
      this.eXu.setTextColor(com.tencent.mm.ui.tools.p.hf(this.mController.uMN));
      this.eXu.setText(y.j.settings_plugins_installed);
      this.eXu.setCompoundDrawablesWithIntrinsicBounds(y.f.status_enable, 0, 0, 0);
      this.hdh.setText(y.j.settings_plugins_installed);
      this.hdh.setClickable(false);
      return;
    }
    this.eXu.setTextColor(com.tencent.mm.ui.tools.p.hg(this.mController.uMN));
    this.eXu.setText(y.j.settings_plugins_uninstalled);
    this.eXu.setCompoundDrawablesWithIntrinsicBounds(y.f.status_disable, 0, 0, 0);
    this.hdh.setText(y.j.settings_plugins_install);
    this.hdh.setClickable(true);
  }
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_open_we_run_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(y.j.app_brand_open_we_run));
    this.dpY = ((ImageView)findViewById(y.g.open_we_run_avatar_iv));
    this.feh = ((TextView)findViewById(y.g.open_we_run_nickname_tv));
    this.eXu = ((TextView)findViewById(y.g.open_we_run_status_tv));
    this.eXr = ((TextView)findViewById(y.g.open_we_run_title));
    this.hdh = ((TextView)findViewById(y.g.open_we_run_open));
    this.hdh.setOnClickListener(new AppBrandOpenWeRunSettingUI.1(this));
    setBackBtn(new AppBrandOpenWeRunSettingUI.2(this));
    paramBundle = bk.pm(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.dnp = ((j)g.r(j.class)).Fw().abl("gh_43f2581f6fd6");
    if ((this.dnp == null) || ((int)this.dnp.dBe == 0))
    {
      getString(y.j.app_tip);
      this.hdi = h.b(this, getString(y.j.app_waiting), true, null);
      this.hdi.show();
      am.a.dVy.a("gh_43f2581f6fd6", "", new AppBrandOpenWeRunSettingUI.3(this));
    }
    this.eXr.setText(getString(y.j.app_brand_open_we_run_title, new Object[] { paramBundle }));
    apa();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      g.DO().dJT.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label112;
      }
      y.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString))) {
        Toast.makeText(ae.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label112:
    ad localad;
    for (;;)
    {
      if (this.hdi != null) {
        this.hdi.dismiss();
      }
      apa();
      return;
      paramm = ((com.tencent.mm.pluginsdk.model.m)paramm).ckC();
      y.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramm });
      this.dnp = ((j)g.r(j.class)).Fw().abl("gh_43f2581f6fd6");
      localad = this.dnp;
      if ((localad != null) && (!bk.bl(paramm))) {
        break;
      }
      y.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramm + ", contact = " + localad);
      paramString = com.tencent.mm.ai.z.My().kQ(this.dnp.field_username);
      com.tencent.mm.ai.z.My().e(paramString);
      g.DP().Dz().o(327825, Boolean.valueOf(true));
      setResult(-1);
      ai.l(new AppBrandOpenWeRunSettingUI.4(this), 1500L);
    }
    if (com.tencent.mm.model.s.hj(localad.field_username))
    {
      String str = bk.pm(localad.field_username);
      paramString = com.tencent.mm.ai.f.kX(str);
      if (paramString != null) {
        paramString.field_username = paramm;
      }
      com.tencent.mm.ai.z.My().delete(str);
      localad.dq(str);
    }
    for (;;)
    {
      localad.setUsername(paramm);
      if ((int)localad.dBe == 0) {
        ((j)g.r(j.class)).Fw().W(localad);
      }
      if ((int)localad.dBe <= 0)
      {
        y.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      com.tencent.mm.model.s.q(localad);
      paramm = ((j)g.r(j.class)).Fw().abl(localad.field_username);
      if (paramString != null)
      {
        com.tencent.mm.ai.z.My().d(paramString);
        break;
      }
      paramString = com.tencent.mm.ai.f.kX(paramm.field_username);
      if ((paramString == null) || (paramString.Ls()))
      {
        y.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        am.a.dVy.V(paramm.field_username, "");
        com.tencent.mm.ag.b.ka(paramm.field_username);
        break;
      }
      if (!paramm.cud()) {
        break;
      }
      y.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramm.cCH) });
      am.a.dVy.V(paramm.field_username, "");
      com.tencent.mm.ag.b.ka(paramm.field_username);
      break;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI
 * JD-Core Version:    0.7.0.1
 */