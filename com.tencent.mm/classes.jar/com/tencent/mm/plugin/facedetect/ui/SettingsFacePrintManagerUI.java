package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.facedetect.b.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private View iDS;
  private FaceHeaderPreference mnd;
  private boolean mne = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131165275;
  }
  
  public void initView()
  {
    AppMethodBeat.i(534);
    int i = bo.f(g.RL().Ru().get(40, Integer.valueOf(0)), 0);
    ab.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.screen = getPreferenceScreen();
    this.mnd = ((FaceHeaderPreference)this.screen.atx("settings_faceprint_header"));
    ((CheckBoxPreference)this.screen.atx("settings_faceprint_title")).qH(true);
    this.screen.notifyDataSetChanged();
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131297112), true, new SettingsFacePrintManagerUI.2(this));
    g.Rc().a(new q(3), 0);
    this.screen.cl("settings_faceprint_create", true);
    this.screen.cl("settings_faceeprint_reset", true);
    this.screen.cl("settings_faceprint_unlock", true);
    setBackBtn(new SettingsFacePrintManagerUI.3(this));
    AppMethodBeat.o(534);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(537);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("err_code", 10) == 0)) {
        this.mne = true;
      }
      ab.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.mne) });
    }
    AppMethodBeat.o(537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(531);
    super.onCreate(paramBundle);
    setMMTitle(2131299583);
    g.Rc().a(938, this);
    this.iDS = findViewById(2131826247);
    initView();
    this.iDS.setBackgroundResource(2131690709);
    com.tencent.mm.plugin.facedetect.model.p.S(this);
    AppMethodBeat.o(531);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(533);
    super.onDestroy();
    g.Rc().b(938, this);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(533);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(535);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_faceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.atx("settings_faceprint_title");
      ab.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.eeN != null) && (this.eeN.isShowing())) {
        this.eeN.dismiss();
      }
      paramPreference = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(paramPreference, getString(2131297112), true, new SettingsFacePrintManagerUI.4(this));
      if (paramf.isChecked()) {
        g.Rc().a(new q(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(535);
        return true;
        g.Rc().a(new q(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", r.Zq());
      localIntent.putExtra("k_purpose", 2);
      startActivity(localIntent);
      AppMethodBeat.o(535);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", r.Zq());
      localIntent.putExtra("k_purpose", 1);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(535);
      return true;
    }
    AppMethodBeat.o(535);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(538);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(538);
      return;
    }
    ab.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(538);
      return;
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0))
      {
        ab.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
        finish();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(532);
    super.onResume();
    if (this.mne)
    {
      this.mne = false;
      if ((this.eeN != null) && (this.eeN.isShowing())) {
        this.eeN.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131297112), true, new SettingsFacePrintManagerUI.1(this));
      ab.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      g.Rc().a(new q(1), 0);
    }
    AppMethodBeat.o(532);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(536);
    ab.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.cl("settings_faceprint_create", true);
      this.screen.cl("settings_faceprint_unlock", true);
      this.screen.cl("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.screen.atx("settings_faceprint_title")).qH(false);
      this.mnd.setTitle(getString(2131303253));
      this.screen.notifyDataSetChanged();
      if (this.eeN != null) {
        this.eeN.dismiss();
      }
      AppMethodBeat.o(536);
      return;
    }
    if (paramm.getType() == 938)
    {
      paramString = (q)paramm;
      if (!paramString.mhl) {
        break label484;
      }
      ab.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
      this.screen.cl("settings_faceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = r.Zt();
      paramm = (CheckBoxPreference)this.screen.atx("settings_faceprint_title");
      ab.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.mhm) });
      if (!paramString.mhm) {
        break label420;
      }
      ab.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
      paramm.qH(true);
      this.screen.cl("settings_faceeprint_reset", false);
      this.screen.cl("settings_faceprint_unlock", false);
      paramInt1 = 0x400000 | paramInt1;
      this.mnd.en(getString(2131303254), "");
      ab.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      av.flM.ao("last_login_use_voice", String.valueOf(paramInt1));
      g.RL().Ru().set(40, Integer.valueOf(paramInt1));
      this.screen.cl("settings_faceprint_create", true);
      this.screen.cl("settings_faceprint_title", false);
      this.mnd.a(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.eeN != null) {
        this.eeN.dismiss();
      }
      AppMethodBeat.o(536);
      return;
      label420:
      ab.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
      paramm.qH(false);
      this.screen.cl("settings_faceeprint_reset", true);
      this.screen.cl("settings_faceprint_unlock", true);
      paramInt1 = 0xFFBFFFFF & paramInt1;
      this.mnd.en(getString(2131303253), "");
      break;
      label484:
      ab.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
      com.tencent.mm.plugin.report.service.h.qsU.e(11390, new Object[] { Integer.valueOf(2) });
      this.screen.cl("settings_faceprint_create", true);
      this.screen.cl("settings_faceprint_title", true);
      this.screen.cl("settings_faceprint_unlock", true);
      this.screen.cl("settings_faceeprint_reset", true);
      this.mnd.setTitle(getString(2131303249));
      this.mnd.a(new SettingsFacePrintManagerUI.5(this));
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI
 * JD-Core Version:    0.7.0.1
 */