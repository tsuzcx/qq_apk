package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ac;
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
  private View khe;
  private CheckBoxPreference qzK = null;
  private CheckBoxPreference qzL = null;
  private CheckBoxPreference qzM = null;
  private CheckBoxPreference qzN = null;
  private CheckBoxPreference qzO = null;
  private CheckBoxPreference qzP = null;
  private f screen;
  
  private void cnY()
  {
    AppMethodBeat.i(103877);
    this.screen = getPreferenceScreen();
    this.qzK = ((CheckBoxPreference)this.screen.aPN("face_debug_switch"));
    this.qzL = ((CheckBoxPreference)this.screen.aPN("face_debug_save_pic_switch"));
    this.qzM = ((CheckBoxPreference)this.screen.aPN("face_debug_save_final_switch"));
    this.qzN = ((CheckBoxPreference)this.screen.aPN("face_debug_save_lipreading_switch"));
    this.qzO = ((CheckBoxPreference)this.screen.aPN("face_debug_save_voice_switch"));
    this.qzP = ((CheckBoxPreference)this.screen.aPN("face_debug_force_upload_video"));
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(103877);
  }
  
  private void cnZ()
  {
    AppMethodBeat.i(103880);
    boolean bool1 = com.tencent.mm.plugin.facedetect.model.e.cnm();
    boolean bool2 = com.tencent.mm.plugin.facedetect.model.e.cno();
    boolean bool3 = com.tencent.mm.plugin.facedetect.model.e.cnp();
    boolean bool4 = com.tencent.mm.plugin.facedetect.model.e.cnq();
    boolean bool5 = com.tencent.mm.plugin.facedetect.model.e.cnr();
    boolean bool6 = com.tencent.mm.plugin.facedetect.model.e.cnn();
    if (!bool1)
    {
      this.qzK.wT(false);
      this.screen.cK("face_debug_save_pic_switch", true);
      this.screen.cK("face_debug_save_final_switch", true);
      this.screen.cK("face_debug_save_lipreading_switch", true);
      this.screen.cK("face_debug_save_voice_switch", true);
      this.screen.cK("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(103880);
      return;
      this.qzK.wT(true);
      this.screen.cK("face_debug_save_pic_switch", false);
      this.screen.cK("face_debug_save_final_switch", false);
      this.screen.cK("face_debug_save_lipreading_switch", false);
      this.screen.cK("face_debug_save_voice_switch", false);
      this.screen.cK("face_debug_force_upload_video", false);
      this.qzL.wT(bool2);
      this.qzM.wT(bool3);
      this.qzN.wT(bool4);
      this.qzO.wT(bool5);
      this.qzP.wT(bool6);
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
    this.khe = findViewById(2131302324);
    this.khe.setBackgroundResource(2131101179);
    cnY();
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
    cnY();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kS(this.qzK.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kT(this.qzL.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kU(this.qzM.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kV(this.qzN.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kW(this.qzO.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.facedetect.model.e.kX(this.qzP.isChecked());
      cnZ();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.CW(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new com.tencent.mm.vfs.e(p.CW(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      ay.hnA.aL("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      ay.hnA.aL("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new com.tencent.mm.vfs.e(p.CW(0));
      paramPreference = new com.tencent.mm.vfs.e(p.CW(1));
      t.makeText(getContext(), String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      ac.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { i.aKe(q.B(paramf.mUri)) });
      ac.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { i.aKe(q.B(paramPreference.mUri)) });
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
    cnZ();
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