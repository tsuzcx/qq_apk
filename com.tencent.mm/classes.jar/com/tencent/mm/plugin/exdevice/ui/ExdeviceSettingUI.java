package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ExdeviceSettingUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  int dEu = -1;
  private final String qtI = "notify_rank";
  private final String qtJ = "notify_like";
  private final String qtK = "join_rank";
  boolean qtL;
  private ProgressDialog qtM;
  private CheckBoxPreference qtN;
  private CheckBoxPreference qtO;
  private CheckBoxPreference qtP;
  private boolean qtQ;
  
  private void cnR()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.qtN;
    if ((this.dEu & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.qtO;
      if ((this.dEu & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.qtP;
      if ((this.dEu & 0x8) != 8) {
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
    return 2131951671;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24291);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.md(38);
    bc.ajj().a(1044, this);
    this.qtN = ((CheckBoxPreference)getPreferenceScreen().aXe("notify_rank"));
    this.qtO = ((CheckBoxPreference)getPreferenceScreen().aXe("notify_like"));
    this.qtP = ((CheckBoxPreference)getPreferenceScreen().aXe("join_rank"));
    bc.aCg();
    paramBundle = (Integer)com.tencent.mm.model.c.ajA().get(397310, Integer.valueOf(0));
    ae.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.qtL = false;
      this.qtN.setChecked(true);
      this.qtO.setChecked(true);
      this.qtP.setChecked(true);
      getPreferenceScreen().notifyDataSetChanged();
      this.qtM = p.show(this, "", "", true, false);
    }
    for (;;)
    {
      bc.ajj().a(new com.tencent.mm.plugin.exdevice.g.a.n(2, 0), 0);
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
      this.qtL = true;
      this.dEu = paramBundle.intValue();
      cnR();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    bc.ajj().b(1044, this);
    if ((this.qtM != null) && (this.qtM.isShowing())) {
      this.qtM.dismiss();
    }
    if (this.qtL)
    {
      if (!this.qtN.isChecked()) {
        break label179;
      }
      this.dEu |= 0x1;
      if (!this.qtO.isChecked()) {
        break label193;
      }
      this.dEu |= 0x2;
      label91:
      if (!this.qtP.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.dEu |= 0x8;; this.dEu &= 0xFFFFFFF7)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(397310, Integer.valueOf(this.dEu));
      ae.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.dEu) });
      bc.ajj().a(new com.tencent.mm.plugin.exdevice.g.a.n(1, this.dEu), 0);
      AppMethodBeat.o(24292);
      return;
      this.dEu &= 0xFFFFFFFE;
      break;
      this.dEu &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    ae.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      d.Q(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.qtQ = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(24294);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (com.tencent.mm.plugin.exdevice.g.a.n)paramn;
      if (paramString.opType != 2)
      {
        ae.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(24294);
        return;
      }
      if ((this.qtM != null) && (this.qtM.isShowing())) {
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
      this.qtL = true;
      if (this.dEu == paramString.qlZ)
      {
        ae.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.dEu) });
        AppMethodBeat.o(24294);
        return;
      }
      this.dEu = paramString.qlZ;
      ae.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.dEu) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(397310, Integer.valueOf(this.dEu));
      if (!this.qtQ) {
        cnR();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.qtM != null) && (this.qtM.isShowing())) {
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