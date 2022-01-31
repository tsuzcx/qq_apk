package com.tencent.mm.plugin.facedetect.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.a.j;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;

public class SettingsFacePrintManagerUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private FaceHeaderPreference jSH;
  private boolean jSI = false;
  private View jdj;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_faceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.add("settings_faceprint_title");
      y.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + paramf.isChecked());
      if ((this.dnm != null) && (this.dnm.isShowing())) {
        this.dnm.dismiss();
      }
      paramPreference = this.mController.uMN;
      getString(a.i.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(paramPreference, getString(a.i.app_waiting), true, new SettingsFacePrintManagerUI.4(this));
      if (paramf.isChecked()) {
        g.Dk().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
      }
      for (;;)
      {
        return true;
        g.Dk().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
      }
    }
    if (paramPreference.equals("settings_faceprint_unlock"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", com.tencent.mm.model.q.Gm());
      localIntent.putExtra("k_purpose", 2);
      startActivity(localIntent);
      return true;
    }
    if (paramPreference.equals("settings_faceeprint_reset"))
    {
      localIntent.setClass(this, FaceDetectUI.class);
      localIntent.putExtra("k_need_signature", true);
      localIntent.putExtra("k_user_name", com.tencent.mm.model.q.Gm());
      localIntent.putExtra("k_purpose", 1);
      startActivityForResult(localIntent, 1);
      return true;
    }
    return false;
  }
  
  public final void initView()
  {
    int i = bk.e(g.DP().Dz().get(40, Integer.valueOf(0)), 0);
    y.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + i + " " + (i & 0x400000));
    this.dnn = this.vdd;
    this.jSH = ((FaceHeaderPreference)this.dnn.add("settings_faceprint_header"));
    ((CheckBoxPreference)this.dnn.add("settings_faceprint_title")).nd(true);
    this.dnn.notifyDataSetChanged();
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    g.Dk().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
    this.dnn.bJ("settings_faceprint_create", true);
    this.dnn.bJ("settings_faceeprint_reset", true);
    this.dnn.bJ("settings_faceprint_unlock", true);
    setBackBtn(new SettingsFacePrintManagerUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("err_code", 10) == 0)) {
        this.jSI = true;
      }
      y.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[] { Boolean.valueOf(this.jSI) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.face_lock_title);
    g.Dk().a(938, this);
    this.jdj = findViewById(a.e.mm_preference_list_content);
    initView();
    this.jdj.setBackgroundResource(a.b.white);
    o.y(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(938, this);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 1)) {}
    do
    {
      return;
      y.d("MicroMsg.FaceSettingsManagerUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults0[%d] grantResults1[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0));
    y.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
    finish();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jSI)
    {
      this.jSI = false;
      if ((this.dnm != null) && (this.dnm.isShowing())) {
        this.dnm.dismiss();
      }
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(a.i.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(a.i.app_waiting), true, new SettingsFacePrintManagerUI.1(this));
      y.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
      g.Dk().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.dnn.bJ("settings_faceprint_create", true);
      this.dnn.bJ("settings_faceprint_unlock", true);
      this.dnn.bJ("settings_faceeprint_reset", true);
      ((CheckBoxPreference)this.dnn.add("settings_faceprint_title")).nd(false);
      this.jSH.setTitle(getString(a.i.settings_faceprint_off));
      this.dnn.notifyDataSetChanged();
      if (this.dnm != null) {
        this.dnm.dismiss();
      }
    }
    label404:
    label584:
    for (;;)
    {
      return;
      if (paramm.getType() == 938)
      {
        paramString = (com.tencent.mm.plugin.facedetect.b.q)paramm;
        if (!paramString.jNc) {
          break label468;
        }
        y.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
        this.dnn.bJ("settings_faceprint_unlock", false);
        this.dnn.notifyDataSetChanged();
        paramInt1 = com.tencent.mm.model.q.Gp();
        paramm = (CheckBoxPreference)this.dnn.add("settings_faceprint_title");
        y.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[] { Boolean.valueOf(paramString.jNd) });
        if (!paramString.jNd) {
          break label404;
        }
        y.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
        paramm.nd(true);
        this.dnn.bJ("settings_faceeprint_reset", false);
        this.dnn.bJ("settings_faceprint_unlock", false);
        paramInt1 = 0x400000 | paramInt1;
        this.jSH.cY(getString(a.i.settings_faceprint_on), "");
        y.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
        at.dVC.Y("last_login_use_voice", String.valueOf(paramInt1));
        g.DP().Dz().o(40, Integer.valueOf(paramInt1));
        this.dnn.bJ("settings_faceprint_create", true);
        this.dnn.bJ("settings_faceprint_title", false);
        this.jSH.c(null);
        this.dnn.notifyDataSetChanged();
      }
      for (;;)
      {
        if (this.dnm == null) {
          break label584;
        }
        this.dnm.dismiss();
        return;
        y.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
        paramm.nd(false);
        this.dnn.bJ("settings_faceeprint_reset", true);
        this.dnn.bJ("settings_faceprint_unlock", true);
        paramInt1 = 0xFFBFFFFF & paramInt1;
        this.jSH.cY(getString(a.i.settings_faceprint_off), "");
        break;
        label468:
        y.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11390, new Object[] { Integer.valueOf(2) });
        this.dnn.bJ("settings_faceprint_create", true);
        this.dnn.bJ("settings_faceprint_title", true);
        this.dnn.bJ("settings_faceprint_unlock", true);
        this.dnn.bJ("settings_faceeprint_reset", true);
        this.jSH.setTitle(getString(a.i.settings_face_title));
        this.jSH.c(new SettingsFacePrintManagerUI.5(this));
        this.dnn.notifyDataSetChanged();
      }
    }
  }
  
  public final int xj()
  {
    return a.j.settings_face_print;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI
 * JD-Core Version:    0.7.0.1
 */