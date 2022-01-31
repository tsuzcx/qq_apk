package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ExdeviceSettingUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  int bcw = -1;
  private final String jGe = "notify_rank";
  private final String jGf = "notify_like";
  private final String jGg = "join_rank";
  boolean jGh;
  private ProgressDialog jGi;
  private CheckBoxPreference jGj;
  private CheckBoxPreference jGk;
  private CheckBoxPreference jGl;
  private boolean jGm;
  
  private void aMR()
  {
    boolean bool2 = true;
    CheckBoxPreference localCheckBoxPreference = this.jGj;
    if ((this.bcw & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.rHo = bool1;
      localCheckBoxPreference = this.jGk;
      if ((this.bcw & 0x2) != 2) {
        break label85;
      }
      bool1 = true;
      label41:
      localCheckBoxPreference.rHo = bool1;
      localCheckBoxPreference = this.jGl;
      if ((this.bcw & 0x8) != 8) {
        break label90;
      }
    }
    label85:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.rHo = bool1;
      this.vdd.notifyDataSetChanged();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    y.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list"))
    {
      com.tencent.mm.br.d.x(this, "sport", ".ui.SportBlackListUI");
      return false;
    }
    this.jGm = true;
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(38);
    au.Dk().a(1044, this);
    this.jGj = ((CheckBoxPreference)this.vdd.add("notify_rank"));
    this.jGk = ((CheckBoxPreference)this.vdd.add("notify_like"));
    this.jGl = ((CheckBoxPreference)this.vdd.add("join_rank"));
    au.Hx();
    paramBundle = (Integer)c.Dz().get(397310, Integer.valueOf(0));
    y.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.jGh = false;
      this.jGj.rHo = true;
      this.jGk.rHo = true;
      this.jGl.rHo = true;
      this.vdd.notifyDataSetChanged();
      this.jGi = com.tencent.mm.ui.base.p.show(this, "", "", true, false);
    }
    for (;;)
    {
      au.Dk().a(new n(2, 0), 0);
      setMMTitle(R.l.regbyfacebook_reg_setpwd_setnow);
      setBackBtn(new ExdeviceSettingUI.1(this));
      return;
      this.jGh = true;
      this.bcw = paramBundle.intValue();
      aMR();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(1044, this);
    if ((this.jGi != null) && (this.jGi.isShowing())) {
      this.jGi.dismiss();
    }
    if (this.jGh)
    {
      if (!this.jGj.isChecked()) {
        break label167;
      }
      this.bcw |= 0x1;
      if (!this.jGk.isChecked()) {
        break label181;
      }
      this.bcw |= 0x2;
      label85:
      if (!this.jGl.isChecked()) {
        break label195;
      }
    }
    label167:
    label181:
    label195:
    for (this.bcw |= 0x8;; this.bcw &= 0xFFFFFFF7)
    {
      au.Hx();
      c.Dz().o(397310, Integer.valueOf(this.bcw));
      y.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.bcw) });
      au.Dk().a(new n(1, this.bcw), 0);
      return;
      this.bcw &= 0xFFFFFFFE;
      break;
      this.bcw &= 0xFFFFFFFD;
      break label85;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (n)paramm;
      if (paramString.opType != 2) {
        y.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
      }
      do
      {
        return;
        if ((this.jGi != null) && (this.jGi.isShowing())) {
          runOnUiThread(new ExdeviceSettingUI.2(this));
        }
        this.jGh = true;
        if (this.bcw == paramString.jyv)
        {
          y.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.bcw) });
          return;
        }
        this.bcw = paramString.jyv;
        y.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.bcw) });
        au.Hx();
        c.Dz().o(397310, Integer.valueOf(this.bcw));
      } while (this.jGm);
      aMR();
      return;
    }
    if ((this.jGi != null) && (this.jGi.isShowing())) {
      runOnUiThread(new ExdeviceSettingUI.3(this));
    }
    Toast.makeText(this, "scene error", 0).show();
    finish();
  }
  
  public final int xj()
  {
    return R.o.exdevice_setting_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */