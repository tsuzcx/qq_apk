package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ExdeviceSettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  int bsY = -1;
  private final String lPC = "notify_rank";
  private final String lPD = "notify_like";
  private final String lPE = "join_rank";
  boolean lPF;
  private ProgressDialog lPG;
  private CheckBoxPreference lPH;
  private CheckBoxPreference lPI;
  private CheckBoxPreference lPJ;
  private boolean lPK;
  
  private void brf()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20220);
    CheckBoxPreference localCheckBoxPreference = this.lPH;
    if ((this.bsY & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.vxW = bool1;
      localCheckBoxPreference = this.lPI;
      if ((this.bsY & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.vxW = bool1;
      localCheckBoxPreference = this.lPJ;
      if ((this.bsY & 0x8) != 8) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.vxW = bool1;
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(20220);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label47;
    }
  }
  
  public int getResourceId()
  {
    return 2131165235;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20218);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.d.kS(38);
    aw.Rc().a(1044, this);
    this.lPH = ((CheckBoxPreference)getPreferenceScreen().atx("notify_rank"));
    this.lPI = ((CheckBoxPreference)getPreferenceScreen().atx("notify_like"));
    this.lPJ = ((CheckBoxPreference)getPreferenceScreen().atx("join_rank"));
    aw.aaz();
    paramBundle = (Integer)c.Ru().get(397310, Integer.valueOf(0));
    ab.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.lPF = false;
      this.lPH.vxW = true;
      this.lPI.vxW = true;
      this.lPJ.vxW = true;
      getPreferenceScreen().notifyDataSetChanged();
      this.lPG = com.tencent.mm.ui.base.p.show(this, "", "", true, false);
    }
    for (;;)
    {
      aw.Rc().a(new n(2, 0), 0);
      setMMTitle(2131302419);
      setBackBtn(new ExdeviceSettingUI.1(this));
      AppMethodBeat.o(20218);
      return;
      this.lPF = true;
      this.bsY = paramBundle.intValue();
      brf();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20219);
    super.onDestroy();
    aw.Rc().b(1044, this);
    if ((this.lPG != null) && (this.lPG.isShowing())) {
      this.lPG.dismiss();
    }
    if (this.lPF)
    {
      if (!this.lPH.isChecked()) {
        break label179;
      }
      this.bsY |= 0x1;
      if (!this.lPI.isChecked()) {
        break label193;
      }
      this.bsY |= 0x2;
      label91:
      if (!this.lPJ.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.bsY |= 0x8;; this.bsY &= 0xFFFFFFF7)
    {
      aw.aaz();
      c.Ru().set(397310, Integer.valueOf(this.bsY));
      ab.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.bsY) });
      aw.Rc().a(new n(1, this.bsY), 0);
      AppMethodBeat.o(20219);
      return;
      this.bsY &= 0xFFFFFFFE;
      break;
      this.bsY &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(20222);
    ab.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      com.tencent.mm.bq.d.H(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(20222);
      return false;
      this.lPK = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20221);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (n)paramm;
      if (paramString.opType != 2)
      {
        ab.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(20221);
        return;
      }
      if ((this.lPG != null) && (this.lPG.isShowing())) {
        runOnUiThread(new ExdeviceSettingUI.2(this));
      }
      this.lPF = true;
      if (this.bsY == paramString.lHU)
      {
        ab.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.bsY) });
        AppMethodBeat.o(20221);
        return;
      }
      this.bsY = paramString.lHU;
      ab.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.bsY) });
      aw.aaz();
      c.Ru().set(397310, Integer.valueOf(this.bsY));
      if (!this.lPK) {
        brf();
      }
      AppMethodBeat.o(20221);
      return;
    }
    if ((this.lPG != null) && (this.lPG.isShowing())) {
      runOnUiThread(new ExdeviceSettingUI.3(this));
    }
    Toast.makeText(this, "scene error", 0).show();
    finish();
    AppMethodBeat.o(20221);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */