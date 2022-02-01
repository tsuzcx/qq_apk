package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public class FaceDebugUI
  extends MMPreference
{
  private View kBS;
  private CheckBoxPreference rjA = null;
  private CheckBoxPreference rjB = null;
  private CheckBoxPreference rjC = null;
  private CheckBoxPreference rjD = null;
  private CheckBoxPreference rjE = null;
  private CheckBoxPreference rjz = null;
  private f screen;
  
  private void ctD()
  {
    AppMethodBeat.i(103877);
    this.screen = getPreferenceScreen();
    this.rjz = ((CheckBoxPreference)this.screen.aVD("face_debug_switch"));
    this.rjA = ((CheckBoxPreference)this.screen.aVD("face_debug_save_pic_switch"));
    this.rjB = ((CheckBoxPreference)this.screen.aVD("face_debug_save_final_switch"));
    this.rjC = ((CheckBoxPreference)this.screen.aVD("face_debug_save_lipreading_switch"));
    this.rjD = ((CheckBoxPreference)this.screen.aVD("face_debug_save_voice_switch"));
    this.rjE = ((CheckBoxPreference)this.screen.aVD("face_debug_force_upload_video"));
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(103877);
  }
  
  private void ctE()
  {
    AppMethodBeat.i(103880);
    boolean bool1 = com.tencent.mm.plugin.facedetect.model.e.csR();
    boolean bool2 = com.tencent.mm.plugin.facedetect.model.e.csT();
    boolean bool3 = com.tencent.mm.plugin.facedetect.model.e.csU();
    boolean bool4 = com.tencent.mm.plugin.facedetect.model.e.csV();
    boolean bool5 = com.tencent.mm.plugin.facedetect.model.e.csW();
    boolean bool6 = com.tencent.mm.plugin.facedetect.model.e.csS();
    if (!bool1)
    {
      this.rjz.xE(false);
      this.screen.cP("face_debug_save_pic_switch", true);
      this.screen.cP("face_debug_save_final_switch", true);
      this.screen.cP("face_debug_save_lipreading_switch", true);
      this.screen.cP("face_debug_save_voice_switch", true);
      this.screen.cP("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(103880);
      return;
      this.rjz.xE(true);
      this.screen.cP("face_debug_save_pic_switch", false);
      this.screen.cP("face_debug_save_final_switch", false);
      this.screen.cP("face_debug_save_lipreading_switch", false);
      this.screen.cP("face_debug_save_voice_switch", false);
      this.screen.cP("face_debug_force_upload_video", false);
      this.rjA.xE(bool2);
      this.rjB.xE(bool3);
      this.rjC.xE(bool4);
      this.rjD.xE(bool5);
      this.rjE.xE(bool6);
    }
  }
  
  public int getResourceId()
  {
    return 2131951672;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103876);
    super.onCreate(paramBundle);
    this.kBS = findViewById(2131302324);
    this.kBS.setBackgroundResource(2131101179);
    ctD();
    setMMTitle(getString(2131758703));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(103875);
        FaceDebugUI.this.finish();
        AppMethodBeat.o(103875);
        return false;
      }
    });
    AppMethodBeat.o(103876);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(103881);
    ctD();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.ll(this.rjz.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.lm(this.rjA.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.ln(this.rjB.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.lo(this.rjC.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.lp(this.rjD.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.lq(this.rjE.isChecked());
      ctE();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.DO(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new com.tencent.mm.vfs.e(p.DO(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      az.hFS.aM("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      az.hFS.aM("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.DO(0));
      paramPreference = new com.tencent.mm.vfs.e(p.DO(1));
      t.makeText(getContext(), String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      ad.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { i.aPK(q.B(paramf.mUri)) });
      ad.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { i.aPK(q.B(paramPreference.mUri)) });
      AppMethodBeat.o(103881);
      return true;
    }
    AppMethodBeat.o(103881);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(103878);
    super.onResume();
    ctE();
    AppMethodBeat.o(103878);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103879);
    super.onStop();
    AppMethodBeat.o(103879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI
 * JD-Core Version:    0.7.0.1
 */