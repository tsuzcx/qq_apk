package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.g.a.o;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;

public class ExdeviceSettingUI
  extends MMPreference
  implements h
{
  int eQp = -1;
  private final String yCQ = "notify_rank";
  private final String yCR = "notify_like";
  private final String yCS = "join_rank";
  boolean yCT;
  private ProgressDialog yCU;
  private CheckBoxPreference yCV;
  private CheckBoxPreference yCW;
  private CheckBoxPreference yCX;
  private boolean yCY;
  
  private void dHk()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24293);
    CheckBoxPreference localCheckBoxPreference = this.yCV;
    if ((this.eQp & 0x1) == 1)
    {
      bool1 = true;
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.yCW;
      if ((this.eQp & 0x2) != 2) {
        break label97;
      }
      bool1 = true;
      label47:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = this.yCX;
      if ((this.eQp & 0x8) != 8) {
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
    return R.o.hbd;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24291);
    super.onCreate(paramBundle);
    d.rG(38);
    bh.aZW().a(1044, this);
    this.yCV = ((CheckBoxPreference)getPreferenceScreen().bAi("notify_rank"));
    this.yCW = ((CheckBoxPreference)getPreferenceScreen().bAi("notify_like"));
    this.yCX = ((CheckBoxPreference)getPreferenceScreen().bAi("join_rank"));
    bh.bCz();
    paramBundle = (Integer)com.tencent.mm.model.c.ban().d(397310, Integer.valueOf(0));
    Log.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[] { paramBundle });
    if ((paramBundle == null) || (paramBundle.intValue() == 0))
    {
      this.yCT = false;
      this.yCV.setChecked(true);
      this.yCW.setChecked(true);
      this.yCX.setChecked(true);
      getPreferenceScreen().notifyDataSetChanged();
      this.yCU = w.show(this, "", "", true, false);
    }
    for (;;)
    {
      bh.aZW().a(new o(2, 0), 0);
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
      this.yCT = true;
      this.eQp = paramBundle.intValue();
      dHk();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24292);
    super.onDestroy();
    bh.aZW().b(1044, this);
    if ((this.yCU != null) && (this.yCU.isShowing())) {
      this.yCU.dismiss();
    }
    if (this.yCT)
    {
      if (!this.yCV.isChecked()) {
        break label179;
      }
      this.eQp |= 0x1;
      if (!this.yCW.isChecked()) {
        break label193;
      }
      this.eQp |= 0x2;
      label91:
      if (!this.yCX.isChecked()) {
        break label207;
      }
    }
    label179:
    label193:
    label207:
    for (this.eQp |= 0x8;; this.eQp &= 0xFFFFFFF7)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(397310, Integer.valueOf(this.eQp));
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[] { Integer.valueOf(this.eQp) });
      bh.aZW().a(new o(1, this.eQp), 0);
      AppMethodBeat.o(24292);
      return;
      this.eQp &= 0xFFFFFFFE;
      break;
      this.eQp &= 0xFFFFFFFD;
      break label91;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24295);
    Log.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equals("black_contact_list")) {
      com.tencent.mm.br.c.ai(this, "sport", ".ui.SportBlackListUI");
    }
    for (;;)
    {
      AppMethodBeat.o(24295);
      return false;
      this.yCY = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(24294);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
      paramString = (o)paramp;
      if (paramString.opType != 2)
      {
        Log.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[] { Integer.valueOf(paramString.opType) });
        AppMethodBeat.o(24294);
        return;
      }
      if ((this.yCU != null) && (this.yCU.isShowing())) {
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
      this.yCT = true;
      if (this.eQp == paramString.yuE)
      {
        Log.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[] { Integer.valueOf(this.eQp) });
        AppMethodBeat.o(24294);
        return;
      }
      this.eQp = paramString.yuE;
      Log.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[] { Integer.valueOf(this.eQp) });
      bh.bCz();
      com.tencent.mm.model.c.ban().B(397310, Integer.valueOf(this.eQp));
      if (!this.yCY) {
        dHk();
      }
      AppMethodBeat.o(24294);
      return;
    }
    if ((this.yCU != null) && (this.yCU.isShowing())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI
 * JD-Core Version:    0.7.0.1
 */