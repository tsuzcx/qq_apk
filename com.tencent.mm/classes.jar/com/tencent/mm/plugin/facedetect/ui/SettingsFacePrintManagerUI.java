package com.tencent.mm.plugin.facedetect.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.a.k;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private ProgressDialog lzP = null;
  private View rootView;
  private com.tencent.mm.ui.base.preference.f screen;
  private FaceHeaderPreference zWu;
  private boolean zWv = false;
  
  public int getResourceId()
  {
    return a.k.settings_face_print;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104053);
    int i = Util.nullAsInt(com.tencent.mm.kernel.h.baE().ban().d(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.screen = getPreferenceScreen();
    this.zWu = ((FaceHeaderPreference)this.screen.bAi("settings_faceprint_header"));
    ((CheckBoxPreference)this.screen.bAi("settings_faceprint_title")).Hy(true);
    this.screen.notifyDataSetChanged();
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(a.i.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.h.aZW().a(new r(3), 0);
    this.screen.eh("settings_faceprint_create", true);
    this.screen.eh("settings_faceeprint_reset", true);
    this.screen.eh("settings_faceprint_unlock", true);
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
        this.zWv = true;
      }
      Log.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.zWv) });
    }
    AppMethodBeat.o(104056);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104050);
    super.onCreate(paramBundle);
    setMMTitle(a.i.face_lock_title);
    com.tencent.mm.kernel.h.aZW().a(938, this);
    this.rootView = findViewById(a.e.mm_preference_list_content);
    initView();
    this.rootView.setBackgroundResource(a.b.white);
    com.tencent.mm.plugin.facedetect.model.k.at(this);
    AppMethodBeat.o(104050);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104052);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(938, this);
    if (this.lzP != null) {
      this.lzP.dismiss();
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
      paramf = (CheckBoxPreference)paramf.bAi("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.lzP != null) && (this.lzP.isShowing())) {
        this.lzP.dismiss();
      }
      paramPreference = getContext();
      getString(a.i.app_tip);
      this.lzP = com.tencent.mm.ui.base.k.a(paramPreference, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        com.tencent.mm.kernel.h.aZW().a(new r(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(104054);
        return true;
        com.tencent.mm.kernel.h.aZW().a(new r(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.bAP());
      localIntent.putExtra("k_purpose", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104054);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.bAP());
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
    if (this.zWv)
    {
      this.zWv = false;
      if ((this.lzP != null) && (this.lzP.isShowing())) {
        this.lzP.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.i.app_tip);
      this.lzP = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      com.tencent.mm.kernel.h.aZW().a(new r(1), 0);
    }
    AppMethodBeat.o(104051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(104055);
    Log.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.eh("settings_faceprint_create", true);
      this.screen.eh("settings_faceprint_unlock", true);
      this.screen.eh("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.screen.bAi("settings_faceprint_title")).Hy(false);
      this.zWu.setTitle(getString(a.i.settings_faceprint_off));
      this.screen.notifyDataSetChanged();
      if (this.lzP != null) {
        this.lzP.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
    }
    if (paramp.getType() == 938)
    {
      paramString = (r)paramp;
      if (!paramString.zSk) {
        break label494;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
      this.screen.eh("settings_faceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.bAU();
      paramp = (CheckBoxPreference)this.screen.bAi("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.zSl) });
      if (!paramString.zSl) {
        break label428;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
      paramp.Hy(true);
      this.screen.eh("settings_faceeprint_reset", false);
      this.screen.eh("settings_faceprint_unlock", false);
      paramInt1 = 0x400000 | paramInt1;
      this.zWu.hA(getString(a.i.settings_faceprint_on), "");
      Log.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bg.okT.bc("last_login_use_voice", String.valueOf(paramInt1));
      com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(paramInt1));
      this.screen.eh("settings_faceprint_create", true);
      this.screen.eh("settings_faceprint_title", false);
      this.zWu.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.lzP != null) {
        this.lzP.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
      label428:
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
      paramp.Hy(false);
      this.screen.eh("settings_faceeprint_reset", true);
      this.screen.eh("settings_faceprint_unlock", true);
      paramInt1 = 0xFFBFFFFF & paramInt1;
      this.zWu.hA(getString(a.i.settings_faceprint_off), "");
      break;
      label494:
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
      com.tencent.mm.plugin.report.service.h.OAn.b(11390, new Object[] { Integer.valueOf(2) });
      this.screen.eh("settings_faceprint_create", true);
      this.screen.eh("settings_faceprint_title", true);
      this.screen.eh("settings_faceprint_unlock", true);
      this.screen.eh("settings_faceeprint_reset", true);
      this.zWu.setTitle(getString(a.i.settings_face_title));
      this.zWu.c(new SettingsFacePrintManagerUI.5(this));
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI
 * JD-Core Version:    0.7.0.1
 */