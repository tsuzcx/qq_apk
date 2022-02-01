package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.g.a.o;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;

public class ExdeviceSettingUI
  extends MMPreference
  implements i
{
  int cUP = -1;
  private final String vqA = "notify_like";
  private final String vqB = "join_rank";
  boolean vqC;
  private ProgressDialog vqD;
  private CheckBoxPreference vqE;
  private CheckBoxPreference vqF;
  private CheckBoxPreference vqG;
  private boolean vqH;
  private final String vqz = "notify_rank";
  
  private void daQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.vqE;
    if ((this.cUP & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.vqF;
      if ((this.cUP & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.vqG;
      if ((this.cUP & 0x8) != 8) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.setChecked(bool1);
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
    return R.o.eXC;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24291);
    super.onCreate(paramBundle);
    d.rE(38);
    bh.aGY().a(1044, this);
    this.vqE = ((CheckBoxPreference)getPreferenceScreen().byG("notify_rank"));
    this.vqF = ((CheckBoxPreference)getPreferenceScreen().byG("notify_like"));
    this.vqG = ((CheckBoxPreference)getPreferenceScreen().byG("join_rank"));
    bh.beI();
    paramBundle = (Integer)com.tencent.mm.model.c.aHp().b(397310, Integer.valueOf(0));
    Log.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.vqC = false;
      this.vqE.setChecked(true);
      this.vqF.setChecked(true);
      this.vqG.setChecked(true);
      getPreferenceScreen().notifyDataSetChanged();
      this.vqD = s.show(this, "", "", true, false);
    }
    for (;;)
    {
      bh.aGY().a(new o(2, 0), 0);
      setMMTitle(R.l.regbyfacebook_reg_setpwd_setnow);
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
      this.vqC = true;
      this.cUP = paramBundle.intValue();
      daQ();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    bh.aGY().b(1044, this);
    if ((this.vqD != null) && (this.vqD.isShowing())) {
      this.vqD.dismiss();
    }
    if (this.vqC)
    {
      if (!this.vqE.isChecked()) {
        break label179;
      }
      this.cUP |= 0x1;
      if (!this.vqF.isChecked()) {
        break label193;
      }
      this.cUP |= 0x2;
      label91:
      if (!this.vqG.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.cUP |= 0x8;; this.cUP &= 0xFFFFFFF7)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(397310, Integer.valueOf(this.cUP));
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.cUP) });
      bh.aGY().a(new o(1, this.cUP), 0);
      AppMethodBeat.o(24292);
      return;
      this.cUP &= 0xFFFFFFFE;
      break;
      this.cUP &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    Log.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      com.tencent.mm.by.c.ad(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.vqH = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(24294);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (o)paramq;
      if (paramString.opType != 2)
      {
        Log.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(24294);
        return;
      }
      if ((this.vqD != null) && (this.vqD.isShowing())) {
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
      this.vqC = true;
      if (this.cUP == paramString.viF)
      {
        Log.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.cUP) });
        AppMethodBeat.o(24294);
        return;
      }
      this.cUP = paramString.viF;
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.cUP) });
      bh.beI();
      com.tencent.mm.model.c.aHp().i(397310, Integer.valueOf(this.cUP));
      if (!this.vqH) {
        daQ();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.vqD != null) && (this.vqD.isShowing())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */