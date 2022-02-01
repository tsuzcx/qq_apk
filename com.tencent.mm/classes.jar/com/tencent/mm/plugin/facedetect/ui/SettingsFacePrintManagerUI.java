package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private View khe;
  private FaceHeaderPreference qCt;
  private boolean qCu = false;
  private f screen;
  
  public int getResourceId()
  {
    return 2131951719;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104053);
    int i = bs.l(com.tencent.mm.kernel.g.agR().agA().get(40, Integer.valueOf(0)), 0);
    ac.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.screen = getPreferenceScreen();
    this.qCt = ((FaceHeaderPreference)this.screen.aPN("settings_faceprint_header"));
    ((CheckBoxPreference)this.screen.aPN("settings_faceprint_title")).wT(true);
    this.screen.notifyDataSetChanged();
    if ((this.fts != null) && (this.fts.isShowing())) {
      this.fts.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
    this.screen.cK("settings_faceprint_create", true);
    this.screen.cK("settings_faceeprint_reset", true);
    this.screen.cK("settings_faceprint_unlock", true);
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
        this.qCu = true;
      }
      ac.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.qCu) });
    }
    AppMethodBeat.o(104056);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104050);
    super.onCreate(paramBundle);
    setMMTitle(2131758740);
    com.tencent.mm.kernel.g.agi().a(938, this);
    this.khe = findViewById(2131302324);
    initView();
    this.khe.setBackgroundResource(2131101179);
    p.al(this);
    AppMethodBeat.o(104050);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104052);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(938, this);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    AppMethodBeat.o(104052);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(104054);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_faceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.aPN("settings_faceprint_title");
      ac.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.fts != null) && (this.fts.isShowing())) {
        this.fts.dismiss();
      }
      paramPreference = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(paramPreference, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(104054);
        return true;
        com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", u.axz());
      localIntent.putExtra("k_purpose", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104054);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", u.axz());
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
      ac.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(104057);
      return;
    }
    ac.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104057);
      return;
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0))
      {
        ac.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
        finish();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104051);
    super.onResume();
    if (this.qCu)
    {
      this.qCu = false;
      if ((this.fts != null) && (this.fts.isShowing())) {
        this.fts.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      ac.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
    }
    AppMethodBeat.o(104051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(104055);
    ac.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.cK("settings_faceprint_create", true);
      this.screen.cK("settings_faceprint_unlock", true);
      this.screen.cK("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.screen.aPN("settings_faceprint_title")).wT(false);
      this.qCt.setTitle(getString(2131763222));
      this.screen.notifyDataSetChanged();
      if (this.fts != null) {
        this.fts.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
    }
    if (paramn.getType() == 938)
    {
      paramString = (com.tencent.mm.plugin.facedetect.b.q)paramn;
      if (!paramString.qwH) {
        break label494;
      }
      ac.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
      this.screen.cK("settings_faceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = u.axC();
      paramn = (CheckBoxPreference)this.screen.aPN("settings_faceprint_title");
      ac.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.qwI) });
      if (!paramString.qwI) {
        break label428;
      }
      ac.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
      paramn.wT(true);
      this.screen.cK("settings_faceeprint_reset", false);
      this.screen.cK("settings_faceprint_unlock", false);
      paramInt1 = 0x400000 | paramInt1;
      this.qCt.fX(getString(2131763223), "");
      ac.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      ay.hnA.aL("last_login_use_voice", String.valueOf(paramInt1));
      com.tencent.mm.kernel.g.agR().agA().set(40, Integer.valueOf(paramInt1));
      this.screen.cK("settings_faceprint_create", true);
      this.screen.cK("settings_faceprint_title", false);
      this.qCt.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.fts != null) {
        this.fts.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
      label428:
      ac.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
      paramn.wT(false);
      this.screen.cK("settings_faceeprint_reset", true);
      this.screen.cK("settings_faceprint_unlock", true);
      paramInt1 = 0xFFBFFFFF & paramInt1;
      this.qCt.fX(getString(2131763222), "");
      break;
      label494:
      ac.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
      com.tencent.mm.plugin.report.service.h.wUl.f(11390, new Object[] { Integer.valueOf(2) });
      this.screen.cK("settings_faceprint_create", true);
      this.screen.cK("settings_faceprint_title", true);
      this.screen.cK("settings_faceprint_unlock", true);
      this.screen.cK("settings_faceeprint_reset", true);
      this.qCt.setTitle(getString(2131763218));
      this.qCt.c(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104049);
          SettingsFacePrintManagerUI.a(SettingsFacePrintManagerUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI
 * JD-Core Version:    0.7.0.1
 */