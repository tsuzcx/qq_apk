package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import java.io.File;

public class FaceDebugUI
  extends MMPreference
{
  private View iDS;
  private CheckBoxPreference mkr = null;
  private CheckBoxPreference mks = null;
  private CheckBoxPreference mkt = null;
  private CheckBoxPreference mku = null;
  private CheckBoxPreference mkv = null;
  private CheckBoxPreference mkw = null;
  private f screen;
  
  private void buX()
  {
    AppMethodBeat.i(358);
    this.screen = getPreferenceScreen();
    this.mkr = ((CheckBoxPreference)this.screen.atx("face_debug_switch"));
    this.mks = ((CheckBoxPreference)this.screen.atx("face_debug_save_pic_switch"));
    this.mkt = ((CheckBoxPreference)this.screen.atx("face_debug_save_final_switch"));
    this.mku = ((CheckBoxPreference)this.screen.atx("face_debug_save_lipreading_switch"));
    this.mkv = ((CheckBoxPreference)this.screen.atx("face_debug_save_voice_switch"));
    this.mkw = ((CheckBoxPreference)this.screen.atx("face_debug_force_upload_video"));
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(358);
  }
  
  private void buY()
  {
    AppMethodBeat.i(361);
    boolean bool1 = e.bul();
    boolean bool2 = e.bun();
    boolean bool3 = e.buo();
    boolean bool4 = e.bup();
    boolean bool5 = e.buq();
    boolean bool6 = e.bum();
    if (!bool1)
    {
      this.mkr.qH(false);
      this.screen.cl("face_debug_save_pic_switch", true);
      this.screen.cl("face_debug_save_final_switch", true);
      this.screen.cl("face_debug_save_lipreading_switch", true);
      this.screen.cl("face_debug_save_voice_switch", true);
      this.screen.cl("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(361);
      return;
      this.mkr.qH(true);
      this.screen.cl("face_debug_save_pic_switch", false);
      this.screen.cl("face_debug_save_final_switch", false);
      this.screen.cl("face_debug_save_lipreading_switch", false);
      this.screen.cl("face_debug_save_voice_switch", false);
      this.screen.cl("face_debug_force_upload_video", false);
      this.mks.qH(bool2);
      this.mkt.qH(bool3);
      this.mku.qH(bool4);
      this.mkv.qH(bool5);
      this.mkw.qH(bool6);
    }
  }
  
  public int getResourceId()
  {
    return 2131165236;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(357);
    super.onCreate(paramBundle);
    this.iDS = findViewById(2131826247);
    this.iDS.setBackgroundResource(2131690709);
    buX();
    setMMTitle(getString(2131299546));
    setBackBtn(new FaceDebugUI.1(this));
    AppMethodBeat.o(357);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(362);
    buX();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      e.hl(this.mkr.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      e.hm(this.mks.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      e.hn(this.mkt.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      e.ho(this.mku.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      e.hp(this.mkv.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      e.hq(this.mkw.isChecked());
      buY();
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new File(p.vJ(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new File(p.vJ(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      av.flM.ao("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      av.flM.ao("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      AppMethodBeat.o(362);
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new File(p.vJ(0));
      paramPreference = new File(p.vJ(1));
      t.makeText(getContext(), String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      ab.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { g.r(paramf) });
      ab.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { g.r(paramPreference) });
      AppMethodBeat.o(362);
      return true;
    }
    AppMethodBeat.o(362);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(359);
    super.onResume();
    buY();
    AppMethodBeat.o(359);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(360);
    super.onStop();
    AppMethodBeat.o(360);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI
 * JD-Core Version:    0.7.0.1
 */