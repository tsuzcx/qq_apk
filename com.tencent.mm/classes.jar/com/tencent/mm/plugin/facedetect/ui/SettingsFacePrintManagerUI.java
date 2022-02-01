package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.a.k;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements i
{
  private ProgressDialog iXX = null;
  private View oFW;
  private com.tencent.mm.ui.base.preference.f screen;
  private FaceHeaderPreference wAj;
  private boolean wAk = false;
  
  public int getResourceId()
  {
    return a.k.settings_face_print;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104053);
    int i = Util.nullAsInt(com.tencent.mm.kernel.h.aHG().aHp().b(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.screen = getPreferenceScreen();
    this.wAj = ((FaceHeaderPreference)this.screen.byG("settings_faceprint_header"));
    ((CheckBoxPreference)this.screen.byG("settings_faceprint_title")).BT(true);
    this.screen.notifyDataSetChanged();
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(a.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.h.aGY().a(new r(3), 0);
    this.screen.dz("settings_faceprint_create", true);
    this.screen.dz("settings_faceeprint_reset", true);
    this.screen.dz("settings_faceprint_unlock", true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(104048);
        SettingsFacePrintManagerUI.this.finish();
        AppMethodBeat.o(104048);
        return true;
      }
    });
    AppMethodBeat.o(104053);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104056);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("err_code", 10) == 0)) {
        this.wAk = true;
      }
      Log.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.wAk) });
    }
    AppMethodBeat.o(104056);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104050);
    super.onCreate(paramBundle);
    setMMTitle(a.i.face_lock_title);
    com.tencent.mm.kernel.h.aGY().a(938, this);
    this.oFW = findViewById(a.e.mm_preference_list_content);
    initView();
    this.oFW.setBackgroundResource(a.b.white);
    p.ak(this);
    AppMethodBeat.o(104050);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104052);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(938, this);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    AppMethodBeat.o(104052);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(104054);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_faceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.byG("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.iXX != null) && (this.iXX.isShowing())) {
        this.iXX.dismiss();
      }
      paramPreference = getContext();
      getString(a.i.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(paramPreference, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        com.tencent.mm.kernel.h.aGY().a(new r(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(104054);
        return true;
        com.tencent.mm.kernel.h.aGY().a(new r(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.bdc());
      localIntent.putExtra("k_purpose", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104054);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.bdc());
      localIntent.putExtra("k_purpose", 1);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(104054);
      return true;
    }
    AppMethodBeat.o(104054);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104057);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(104057);
      return;
    }
    Log.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104057);
      return;
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0))
      {
        Log.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
        finish();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104051);
    super.onResume();
    if (this.wAk)
    {
      this.wAk = false;
      if ((this.iXX != null) && (this.iXX.isShowing())) {
        this.iXX.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.i.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      com.tencent.mm.kernel.h.aGY().a(new r(1), 0);
    }
    AppMethodBeat.o(104051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(104055);
    Log.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.dz("settings_faceprint_create", true);
      this.screen.dz("settings_faceprint_unlock", true);
      this.screen.dz("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.screen.byG("settings_faceprint_title")).BT(false);
      this.wAj.setTitle(getString(a.i.settings_faceprint_off));
      this.screen.notifyDataSetChanged();
      if (this.iXX != null) {
        this.iXX.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
    }
    if (paramq.getType() == 938)
    {
      paramString = (r)paramq;
      if (!paramString.wwd) {
        break label494;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
      this.screen.dz("settings_faceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.bdf();
      paramq = (CheckBoxPreference)this.screen.byG("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.wwe) });
      if (!paramString.wwe) {
        break label428;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
      paramq.BT(true);
      this.screen.dz("settings_faceeprint_reset", false);
      this.screen.dz("settings_faceprint_unlock", false);
      paramInt1 = 0x400000 | paramInt1;
      this.wAj.gR(getString(a.i.settings_faceprint_on), "");
      Log.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bg.ltv.aS("last_login_use_voice", String.valueOf(paramInt1));
      com.tencent.mm.kernel.h.aHG().aHp().i(40, Integer.valueOf(paramInt1));
      this.screen.dz("settings_faceprint_create", true);
      this.screen.dz("settings_faceprint_title", false);
      this.wAj.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.iXX != null) {
        this.iXX.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
      label428:
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
      paramq.BT(false);
      this.screen.dz("settings_faceeprint_reset", true);
      this.screen.dz("settings_faceprint_unlock", true);
      paramInt1 = 0xFFBFFFFF & paramInt1;
      this.wAj.gR(getString(a.i.settings_faceprint_off), "");
      break;
      label494:
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
      com.tencent.mm.plugin.report.service.h.IzE.a(11390, new Object[] { Integer.valueOf(2) });
      this.screen.dz("settings_faceprint_create", true);
      this.screen.dz("settings_faceprint_title", true);
      this.screen.dz("settings_faceprint_unlock", true);
      this.screen.dz("settings_faceeprint_reset", true);
      this.wAj.setTitle(getString(a.i.settings_face_title));
      this.wAj.c(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104049);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          SettingsFacePrintManagerUI.a(SettingsFacePrintManagerUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104049);
        }
      });
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI
 * JD-Core Version:    0.7.0.1
 */