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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements i
{
  private ProgressDialog gtM = null;
  private View lJI;
  private FaceHeaderPreference sUm;
  private boolean sUn = false;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017264;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104053);
    int i = Util.nullAsInt(g.aAh().azQ().get(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.screen = getPreferenceScreen();
    this.sUm = ((FaceHeaderPreference)this.screen.bmg("settings_faceprint_header"));
    ((CheckBoxPreference)this.screen.bmg("settings_faceprint_title")).xZ(true);
    this.screen.notifyDataSetChanged();
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    g.azz().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
    this.screen.jdMethod_do("settings_faceprint_create", true);
    this.screen.jdMethod_do("settings_faceeprint_reset", true);
    this.screen.jdMethod_do("settings_faceprint_unlock", true);
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
        this.sUn = true;
      }
      Log.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.sUn) });
    }
    AppMethodBeat.o(104056);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104050);
    super.onCreate(paramBundle);
    setMMTitle(2131759058);
    g.azz().a(938, this);
    this.lJI = findViewById(2131304719);
    initView();
    this.lJI.setBackgroundResource(2131101424);
    p.aj(this);
    AppMethodBeat.o(104050);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104052);
    super.onDestroy();
    g.azz().b(938, this);
    if (this.gtM != null) {
      this.gtM.dismiss();
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
      paramf = (CheckBoxPreference)paramf.bmg("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.gtM != null) && (this.gtM.isShowing())) {
        this.gtM.dismiss();
      }
      paramPreference = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(paramPreference, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        g.azz().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(104054);
        return true;
        g.azz().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.aUb());
      localIntent.putExtra("k_purpose", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104054);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", z.aUb());
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
    if (this.sUn)
    {
      this.sUn = false;
      if ((this.gtM != null) && (this.gtM.isShowing())) {
        this.gtM.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      g.azz().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
    }
    AppMethodBeat.o(104051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(104055);
    Log.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.jdMethod_do("settings_faceprint_create", true);
      this.screen.jdMethod_do("settings_faceprint_unlock", true);
      this.screen.jdMethod_do("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.screen.bmg("settings_faceprint_title")).xZ(false);
      this.sUm.setTitle(getString(2131765391));
      this.screen.notifyDataSetChanged();
      if (this.gtM != null) {
        this.gtM.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
    }
    if (paramq.getType() == 938)
    {
      paramString = (com.tencent.mm.plugin.facedetect.b.q)paramq;
      if (!paramString.sQf) {
        break label494;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
      this.screen.jdMethod_do("settings_faceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.aUe();
      paramq = (CheckBoxPreference)this.screen.bmg("settings_faceprint_title");
      Log.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.sQg) });
      if (!paramString.sQg) {
        break label428;
      }
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
      paramq.xZ(true);
      this.screen.jdMethod_do("settings_faceeprint_reset", false);
      this.screen.jdMethod_do("settings_faceprint_unlock", false);
      paramInt1 = 0x400000 | paramInt1;
      this.sUm.gD(getString(2131765392), "");
      Log.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bf.iDu.aO("last_login_use_voice", String.valueOf(paramInt1));
      g.aAh().azQ().set(40, Integer.valueOf(paramInt1));
      this.screen.jdMethod_do("settings_faceprint_create", true);
      this.screen.jdMethod_do("settings_faceprint_title", false);
      this.sUm.b(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.gtM != null) {
        this.gtM.dismiss();
      }
      AppMethodBeat.o(104055);
      return;
      label428:
      Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
      paramq.xZ(false);
      this.screen.jdMethod_do("settings_faceeprint_reset", true);
      this.screen.jdMethod_do("settings_faceprint_unlock", true);
      paramInt1 = 0xFFBFFFFF & paramInt1;
      this.sUm.gD(getString(2131765391), "");
      break;
      label494:
      Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
      com.tencent.mm.plugin.report.service.h.CyF.a(11390, new Object[] { Integer.valueOf(2) });
      this.screen.jdMethod_do("settings_faceprint_create", true);
      this.screen.jdMethod_do("settings_faceprint_title", true);
      this.screen.jdMethod_do("settings_faceprint_unlock", true);
      this.screen.jdMethod_do("settings_faceeprint_reset", true);
      this.sUm.setTitle(getString(2131765387));
      this.sUm.b(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104049);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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