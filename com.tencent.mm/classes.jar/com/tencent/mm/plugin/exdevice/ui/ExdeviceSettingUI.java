package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ExdeviceSettingUI
  extends MMPreference
  implements g
{
  int drx = -1;
  private final String pJA = "join_rank";
  boolean pJB;
  private ProgressDialog pJC;
  private CheckBoxPreference pJD;
  private CheckBoxPreference pJE;
  private CheckBoxPreference pJF;
  private boolean pJG;
  private final String pJy = "notify_rank";
  private final String pJz = "notify_like";
  
  private void chX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.pJD;
    if ((this.drx & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.mF = bool1;
      localCheckBoxPreference = this.pJE;
      if ((this.drx & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.mF = bool1;
      localCheckBoxPreference = this.pJF;
      if ((this.drx & 0x8) != 8) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.mF = bool1;
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
    com.tencent.mm.plugin.sport.a.c.lA(38);
    az.agi().a(1044, this);
    this.pJD = ((CheckBoxPreference)getPreferenceScreen().aPN("notify_rank"));
    this.pJE = ((CheckBoxPreference)getPreferenceScreen().aPN("notify_like"));
    this.pJF = ((CheckBoxPreference)getPreferenceScreen().aPN("join_rank"));
    az.ayM();
    paramBundle = (Integer)com.tencent.mm.model.c.agA().get(397310, Integer.valueOf(0));
    ac.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.pJB = false;
      this.pJD.mF = true;
      this.pJE.mF = true;
      this.pJF.mF = true;
      getPreferenceScreen().notifyDataSetChanged();
      this.pJC = p.show(this, "", "", true, false);
    }
    for (;;)
    {
      az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.n(2, 0), 0);
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
      this.pJB = true;
      this.drx = paramBundle.intValue();
      chX();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    az.agi().b(1044, this);
    if ((this.pJC != null) && (this.pJC.isShowing())) {
      this.pJC.dismiss();
    }
    if (this.pJB)
    {
      if (!this.pJD.isChecked()) {
        break label179;
      }
      this.drx |= 0x1;
      if (!this.pJE.isChecked()) {
        break label193;
      }
      this.drx |= 0x2;
      label91:
      if (!this.pJF.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.drx |= 0x8;; this.drx &= 0xFFFFFFF7)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(397310, Integer.valueOf(this.drx));
      ac.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.drx) });
      az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.n(1, this.drx), 0);
      AppMethodBeat.o(24292);
      return;
      this.drx &= 0xFFFFFFFE;
      break;
      this.drx &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    ac.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      d.N(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.pJG = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(24294);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (com.tencent.mm.plugin.exdevice.g.a.n)paramn;
      if (paramString.opType != 2)
      {
        ac.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(24294);
        return;
      }
      if ((this.pJC != null) && (this.pJC.isShowing())) {
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
      this.pJB = true;
      if (this.drx == paramString.pBP)
      {
        ac.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.drx) });
        AppMethodBeat.o(24294);
        return;
      }
      this.drx = paramString.pBP;
      ac.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.drx) });
      az.ayM();
      com.tencent.mm.model.c.agA().set(397310, Integer.valueOf(this.drx));
      if (!this.pJG) {
        chX();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.pJC != null) && (this.pJC.isShowing())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */