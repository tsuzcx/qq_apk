package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ExdeviceSettingUI
  extends MMPreference
  implements g
{
  int dtM = -1;
  private final String pgo = "notify_rank";
  private final String pgp = "notify_like";
  private final String pgq = "join_rank";
  boolean pgr;
  private ProgressDialog pgs;
  private CheckBoxPreference pgt;
  private CheckBoxPreference pgu;
  private CheckBoxPreference pgv;
  private boolean pgw;
  
  private void caO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.pgt;
    if ((this.dtM & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.lG = bool1;
      localCheckBoxPreference = this.pgu;
      if ((this.dtM & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.lG = bool1;
      localCheckBoxPreference = this.pgv;
      if ((this.dtM & 0x8) != 8) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.lG = bool1;
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(24293);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label47;
    }
  }
  
  public int getResourceId()
  {
    return 2131951671;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24291);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.lI(38);
    az.aeS().a(1044, this);
    this.pgt = ((CheckBoxPreference)getPreferenceScreen().aKk("notify_rank"));
    this.pgu = ((CheckBoxPreference)getPreferenceScreen().aKk("notify_like"));
    this.pgv = ((CheckBoxPreference)getPreferenceScreen().aKk("join_rank"));
    az.arV();
    paramBundle = (Integer)com.tencent.mm.model.c.afk().get(397310, Integer.valueOf(0));
    ad.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.pgr = false;
      this.pgt.lG = true;
      this.pgu.lG = true;
      this.pgv.lG = true;
      getPreferenceScreen().notifyDataSetChanged();
      this.pgs = p.show(this, "", "", true, false);
    }
    for (;;)
    {
      az.aeS().a(new com.tencent.mm.plugin.exdevice.g.a.n(2, 0), 0);
      setMMTitle(2131762316);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(24288);
          ExdeviceSettingUI.this.finish();
          AppMethodBeat.o(24288);
          return false;
        }
      });
      AppMethodBeat.o(24291);
      return;
      this.pgr = true;
      this.dtM = paramBundle.intValue();
      caO();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    az.aeS().b(1044, this);
    if ((this.pgs != null) && (this.pgs.isShowing())) {
      this.pgs.dismiss();
    }
    if (this.pgr)
    {
      if (!this.pgt.isChecked()) {
        break label179;
      }
      this.dtM |= 0x1;
      if (!this.pgu.isChecked()) {
        break label193;
      }
      this.dtM |= 0x2;
      label91:
      if (!this.pgv.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.dtM |= 0x8;; this.dtM &= 0xFFFFFFF7)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(397310, Integer.valueOf(this.dtM));
      ad.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.dtM) });
      az.aeS().a(new com.tencent.mm.plugin.exdevice.g.a.n(1, this.dtM), 0);
      AppMethodBeat.o(24292);
      return;
      this.dtM &= 0xFFFFFFFE;
      break;
      this.dtM &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    ad.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      d.O(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.pgw = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(24294);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (com.tencent.mm.plugin.exdevice.g.a.n)paramn;
      if (paramString.opType != 2)
      {
        ad.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(24294);
        return;
      }
      if ((this.pgs != null) && (this.pgs.isShowing())) {
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24289);
            ExdeviceSettingUI.a(ExdeviceSettingUI.this).dismiss();
            AppMethodBeat.o(24289);
          }
        });
      }
      this.pgr = true;
      if (this.dtM == paramString.oYE)
      {
        ad.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.dtM) });
        AppMethodBeat.o(24294);
        return;
      }
      this.dtM = paramString.oYE;
      ad.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.dtM) });
      az.arV();
      com.tencent.mm.model.c.afk().set(397310, Integer.valueOf(this.dtM));
      if (!this.pgw) {
        caO();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.pgs != null) && (this.pgs.isShowing())) {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24290);
          ExdeviceSettingUI.a(ExdeviceSettingUI.this).dismiss();
          AppMethodBeat.o(24290);
        }
      });
    }
    Toast.makeText(this, "scene error", 0).show();
    finish();
    AppMethodBeat.o(24294);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */