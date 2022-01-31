package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.a.j;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.File;

public class FaceDebugUI
  extends MMPreference
{
  private f dnn;
  private CheckBoxPreference jQb = null;
  private CheckBoxPreference jQc = null;
  private CheckBoxPreference jQd = null;
  private CheckBoxPreference jQe = null;
  private CheckBoxPreference jQf = null;
  private CheckBoxPreference jQg = null;
  private View jdj;
  
  private void aOT()
  {
    this.dnn = this.vdd;
    this.jQb = ((CheckBoxPreference)this.dnn.add("face_debug_switch"));
    this.jQc = ((CheckBoxPreference)this.dnn.add("face_debug_save_pic_switch"));
    this.jQd = ((CheckBoxPreference)this.dnn.add("face_debug_save_final_switch"));
    this.jQe = ((CheckBoxPreference)this.dnn.add("face_debug_save_lipreading_switch"));
    this.jQf = ((CheckBoxPreference)this.dnn.add("face_debug_save_voice_switch"));
    this.jQg = ((CheckBoxPreference)this.dnn.add("face_debug_force_upload_video"));
    this.dnn.notifyDataSetChanged();
  }
  
  private void aOU()
  {
    boolean bool1 = e.aOi();
    boolean bool2 = e.aOk();
    boolean bool3 = e.aOl();
    boolean bool4 = e.aOm();
    boolean bool5 = e.aOn();
    boolean bool6 = e.aOj();
    if (!bool1)
    {
      this.jQb.nd(false);
      this.dnn.bJ("face_debug_save_pic_switch", true);
      this.dnn.bJ("face_debug_save_final_switch", true);
      this.dnn.bJ("face_debug_save_lipreading_switch", true);
      this.dnn.bJ("face_debug_save_voice_switch", true);
      this.dnn.bJ("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      this.jQb.nd(true);
      this.dnn.bJ("face_debug_save_pic_switch", false);
      this.dnn.bJ("face_debug_save_final_switch", false);
      this.dnn.bJ("face_debug_save_lipreading_switch", false);
      this.dnn.bJ("face_debug_save_voice_switch", false);
      this.dnn.bJ("face_debug_force_upload_video", false);
      this.jQc.nd(bool2);
      this.jQd.nd(bool3);
      this.jQe.nd(bool4);
      this.jQf.nd(bool5);
      this.jQg.nd(bool6);
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    aOT();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      e.fI(this.jQb.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      e.fJ(this.jQc.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      e.fK(this.jQd.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      e.fL(this.jQe.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      e.fM(this.jQf.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      e.fN(this.jQg.isChecked());
      aOU();
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new File(o.qO(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new File(o.qO(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      at.dVC.Y("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      at.dVC.Y("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new File(o.qO(0));
      paramPreference = new File(o.qO(1));
      com.tencent.mm.ui.base.s.makeText(this.mController.uMN, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      y.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { g.m(paramf) });
      y.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { g.m(paramPreference) });
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdj = findViewById(a.e.mm_preference_list_content);
    this.jdj.setBackgroundResource(a.b.white);
    aOT();
    setMMTitle(getString(a.i.face_debug_name));
    setBackBtn(new FaceDebugUI.1(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    aOU();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public final int xj()
  {
    return a.j.face_debug_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI
 * JD-Core Version:    0.7.0.1
 */