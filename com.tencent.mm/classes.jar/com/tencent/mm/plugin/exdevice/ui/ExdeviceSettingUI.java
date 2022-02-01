package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ExdeviceSettingUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  int dDp = -1;
  private final String qnd = "notify_rank";
  private final String qne = "notify_like";
  private final String qnf = "join_rank";
  boolean qng;
  private ProgressDialog qnh;
  private CheckBoxPreference qni;
  private CheckBoxPreference qnj;
  private CheckBoxPreference qnk;
  private boolean qnl;
  
  private void cmB()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.qni;
    if ((this.dDp & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.oB = bool1;
      localCheckBoxPreference = this.qnj;
      if ((this.dDp & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.oB = bool1;
      localCheckBoxPreference = this.qnk;
      if ((this.dDp & 0x8) != 8) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.oB = bool1;
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
    com.tencent.mm.plugin.sport.a.c.ma(38);
    ba.aiU().a(1044, this);
    this.qni = ((CheckBoxPreference)getPreferenceScreen().aVD("notify_rank"));
    this.qnj = ((CheckBoxPreference)getPreferenceScreen().aVD("notify_like"));
    this.qnk = ((CheckBoxPreference)getPreferenceScreen().aVD("join_rank"));
    ba.aBQ();
    paramBundle = (Integer)com.tencent.mm.model.c.ajl().get(397310, Integer.valueOf(0));
    ad.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.qng = false;
      this.qni.oB = true;
      this.qnj.oB = true;
      this.qnk.oB = true;
      getPreferenceScreen().notifyDataSetChanged();
      this.qnh = p.show(this, "", "", true, false);
    }
    for (;;)
    {
      ba.aiU().a(new com.tencent.mm.plugin.exdevice.g.a.n(2, 0), 0);
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
      this.qng = true;
      this.dDp = paramBundle.intValue();
      cmB();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    ba.aiU().b(1044, this);
    if ((this.qnh != null) && (this.qnh.isShowing())) {
      this.qnh.dismiss();
    }
    if (this.qng)
    {
      if (!this.qni.isChecked()) {
        break label179;
      }
      this.dDp |= 0x1;
      if (!this.qnj.isChecked()) {
        break label193;
      }
      this.dDp |= 0x2;
      label91:
      if (!this.qnk.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.dDp |= 0x8;; this.dDp &= 0xFFFFFFF7)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(397310, Integer.valueOf(this.dDp));
      ad.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.dDp) });
      ba.aiU().a(new com.tencent.mm.plugin.exdevice.g.a.n(1, this.dDp), 0);
      AppMethodBeat.o(24292);
      return;
      this.dDp &= 0xFFFFFFFE;
      break;
      this.dDp &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    ad.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      d.Q(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.qnl = true;
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
      if ((this.qnh != null) && (this.qnh.isShowing())) {
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
      this.qng = true;
      if (this.dDp == paramString.qfu)
      {
        ad.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.dDp) });
        AppMethodBeat.o(24294);
        return;
      }
      this.dDp = paramString.qfu;
      ad.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.dDp) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(397310, Integer.valueOf(this.dDp));
      if (!this.qnl) {
        cmB();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.qnh != null) && (this.qnh.isShowing())) {
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