package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
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
  private View jGG;
  private CheckBoxPreference pRc = null;
  private CheckBoxPreference pRd = null;
  private CheckBoxPreference pRe = null;
  private CheckBoxPreference pRf = null;
  private CheckBoxPreference pRg = null;
  private CheckBoxPreference pRh = null;
  private f screen;
  
  private void cgr()
  {
    AppMethodBeat.i(103877);
    this.screen = getPreferenceScreen();
    this.pRc = ((CheckBoxPreference)this.screen.aKk("face_debug_switch"));
    this.pRd = ((CheckBoxPreference)this.screen.aKk("face_debug_save_pic_switch"));
    this.pRe = ((CheckBoxPreference)this.screen.aKk("face_debug_save_final_switch"));
    this.pRf = ((CheckBoxPreference)this.screen.aKk("face_debug_save_lipreading_switch"));
    this.pRg = ((CheckBoxPreference)this.screen.aKk("face_debug_save_voice_switch"));
    this.pRh = ((CheckBoxPreference)this.screen.aKk("face_debug_force_upload_video"));
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(103877);
  }
  
  private void cgs()
  {
    AppMethodBeat.i(103880);
    boolean bool1 = com.tencent.mm.plugin.facedetect.model.e.cfF();
    boolean bool2 = com.tencent.mm.plugin.facedetect.model.e.cfH();
    boolean bool3 = com.tencent.mm.plugin.facedetect.model.e.cfI();
    boolean bool4 = com.tencent.mm.plugin.facedetect.model.e.cfJ();
    boolean bool5 = com.tencent.mm.plugin.facedetect.model.e.cfK();
    boolean bool6 = com.tencent.mm.plugin.facedetect.model.e.cfG();
    if (!bool1)
    {
      this.pRc.vP(false);
      this.screen.cE("face_debug_save_pic_switch", true);
      this.screen.cE("face_debug_save_final_switch", true);
      this.screen.cE("face_debug_save_lipreading_switch", true);
      this.screen.cE("face_debug_save_voice_switch", true);
      this.screen.cE("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(103880);
      return;
      this.pRc.vP(true);
      this.screen.cE("face_debug_save_pic_switch", false);
      this.screen.cE("face_debug_save_final_switch", false);
      this.screen.cE("face_debug_save_lipreading_switch", false);
      this.screen.cE("face_debug_save_voice_switch", false);
      this.screen.cE("face_debug_force_upload_video", false);
      this.pRd.vP(bool2);
      this.pRe.vP(bool3);
      this.pRf.vP(bool4);
      this.pRg.vP(bool5);
      this.pRh.vP(bool6);
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
    this.jGG = findViewById(2131302324);
    this.jGG.setBackgroundResource(2131101179);
    cgr();
    setMMTitle(getString(2131758703));
    setBackBtn(new FaceDebugUI.1(this));
    AppMethodBeat.o(103876);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(103881);
    cgr();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.ko(this.pRc.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kp(this.pRd.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kq(this.pRe.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kr(this.pRf.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.ks(this.pRg.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kt(this.pRh.isChecked());
      cgs();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.Cb(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new com.tencent.mm.vfs.e(p.Cb(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      ay.gNa.aD("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      ay.gNa.aD("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.Cb(0));
      paramPreference = new com.tencent.mm.vfs.e(p.Cb(1));
      t.makeText(getContext(), String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      ad.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { i.aEN(q.B(paramf.mUri)) });
      ad.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { i.aEN(q.B(paramPreference.mUri)) });
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
    cgs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI
 * JD-Core Version:    0.7.0.1
 */