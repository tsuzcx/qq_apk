package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.g.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ExdeviceSettingUI
  extends MMPreference
  implements i
{
  int cSx = -1;
  private final String rKQ = "notify_rank";
  private final String rKR = "notify_like";
  private final String rKS = "join_rank";
  boolean rKT;
  private ProgressDialog rKU;
  private CheckBoxPreference rKV;
  private CheckBoxPreference rKW;
  private CheckBoxPreference rKX;
  private boolean rKY;
  
  private void cMd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.rKV;
    if ((this.cSx & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.rKW;
      if ((this.cSx & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.rKX;
      if ((this.cSx & 0x8) != 8) {
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
    return 2132017209;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24291);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.pl(38);
    bg.azz().a(1044, this);
    this.rKV = ((CheckBoxPreference)getPreferenceScreen().bmg("notify_rank"));
    this.rKW = ((CheckBoxPreference)getPreferenceScreen().bmg("notify_like"));
    this.rKX = ((CheckBoxPreference)getPreferenceScreen().bmg("join_rank"));
    bg.aVF();
    paramBundle = (Integer)com.tencent.mm.model.c.azQ().get(397310, Integer.valueOf(0));
    Log.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.rKT = false;
      this.rKV.setChecked(true);
      this.rKW.setChecked(true);
      this.rKX.setChecked(true);
      getPreferenceScreen().notifyDataSetChanged();
      this.rKU = com.tencent.mm.ui.base.q.show(this, "", "", true, false);
    }
    for (;;)
    {
      bg.azz().a(new o(2, 0), 0);
      setMMTitle(2131764382);
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
      this.rKT = true;
      this.cSx = paramBundle.intValue();
      cMd();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    bg.azz().b(1044, this);
    if ((this.rKU != null) && (this.rKU.isShowing())) {
      this.rKU.dismiss();
    }
    if (this.rKT)
    {
      if (!this.rKV.isChecked()) {
        break label179;
      }
      this.cSx |= 0x1;
      if (!this.rKW.isChecked()) {
        break label193;
      }
      this.cSx |= 0x2;
      label91:
      if (!this.rKX.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.cSx |= 0x8;; this.cSx &= 0xFFFFFFF7)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(397310, Integer.valueOf(this.cSx));
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.cSx) });
      bg.azz().a(new o(1, this.cSx), 0);
      AppMethodBeat.o(24292);
      return;
      this.cSx &= 0xFFFFFFFE;
      break;
      this.cSx &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    Log.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      com.tencent.mm.br.c.V(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.rKY = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      if ((this.rKU != null) && (this.rKU.isShowing())) {
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
      this.rKT = true;
      if (this.cSx == paramString.rCV)
      {
        Log.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.cSx) });
        AppMethodBeat.o(24294);
        return;
      }
      this.cSx = paramString.rCV;
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.cSx) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(397310, Integer.valueOf(this.cSx));
      if (!this.rKY) {
        cMd();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.rKU != null) && (this.rKU.isShowing())) {
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