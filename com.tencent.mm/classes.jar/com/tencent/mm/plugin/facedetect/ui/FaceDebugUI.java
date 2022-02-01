package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bb;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public class FaceDebugUI
  extends MMPreference
{
  private View kFh;
  private CheckBoxPreference rrD = null;
  private CheckBoxPreference rrE = null;
  private CheckBoxPreference rrF = null;
  private CheckBoxPreference rrG = null;
  private CheckBoxPreference rrH = null;
  private CheckBoxPreference rrI = null;
  private f screen;
  
  private void cve()
  {
    AppMethodBeat.i(103877);
    this.screen = getPreferenceScreen();
    this.rrD = ((CheckBoxPreference)this.screen.aXe("face_debug_switch"));
    this.rrE = ((CheckBoxPreference)this.screen.aXe("face_debug_save_pic_switch"));
    this.rrF = ((CheckBoxPreference)this.screen.aXe("face_debug_save_final_switch"));
    this.rrG = ((CheckBoxPreference)this.screen.aXe("face_debug_save_lipreading_switch"));
    this.rrH = ((CheckBoxPreference)this.screen.aXe("face_debug_save_voice_switch"));
    this.rrI = ((CheckBoxPreference)this.screen.aXe("face_debug_force_upload_video"));
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(103877);
  }
  
  private void cvf()
  {
    AppMethodBeat.i(103880);
    boolean bool1 = e.cus();
    boolean bool2 = e.cuu();
    boolean bool3 = e.cuv();
    boolean bool4 = e.cuw();
    boolean bool5 = e.cux();
    boolean bool6 = e.cut();
    if (!bool1)
    {
      this.rrD.uo(false);
      this.screen.cT("face_debug_save_pic_switch", true);
      this.screen.cT("face_debug_save_final_switch", true);
      this.screen.cT("face_debug_save_lipreading_switch", true);
      this.screen.cT("face_debug_save_voice_switch", true);
      this.screen.cT("face_debug_force_upload_video", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(103880);
      return;
      this.rrD.uo(true);
      this.screen.cT("face_debug_save_pic_switch", false);
      this.screen.cT("face_debug_save_final_switch", false);
      this.screen.cT("face_debug_save_lipreading_switch", false);
      this.screen.cT("face_debug_save_voice_switch", false);
      this.screen.cT("face_debug_force_upload_video", false);
      this.rrE.uo(bool2);
      this.rrF.uo(bool3);
      this.rrG.uo(bool4);
      this.rrH.uo(bool5);
      this.rrI.uo(bool6);
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
    this.kFh = findViewById(2131302324);
    this.kFh.setBackgroundResource(2131101179);
    cve();
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
    cve();
    if ("face_debug_switch".equals(paramPreference.mKey))
    {
      e.ll(this.rrD.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_pic_switch".equals(paramPreference.mKey))
    {
      e.lm(this.rrE.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_final_switch".equals(paramPreference.mKey))
    {
      e.ln(this.rrF.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_lipreading_switch".equals(paramPreference.mKey))
    {
      e.lo(this.rrG.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_save_voice_switch".equals(paramPreference.mKey))
    {
      e.lp(this.rrH.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_force_upload_video".equals(paramPreference.mKey))
    {
      e.lq(this.rrI.isChecked());
      cvf();
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_clear_resource".equals(paramPreference.mKey))
    {
      paramf = new k(p.Eb(0));
      if (paramf.exists()) {
        paramf.delete();
      }
      paramf = new k(p.Eb(1));
      if (paramf.exists()) {
        paramf.delete();
      }
      bb.hIK.aM("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
      bb.hIK.aM("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
      AppMethodBeat.o(103881);
      return true;
    }
    if ("face_debug_check_resource".equals(paramPreference.mKey))
    {
      paramf = new k(p.Eb(0));
      paramPreference = new k(p.Eb(1));
      t.makeText(getContext(), String.format("is detect model exists: %b, is alignment model exists: %b", new Object[] { Boolean.valueOf(paramf.exists()), Boolean.valueOf(paramPreference.exists()) }), 0).show();
      ae.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[] { o.aRh(w.B(paramf.mUri)) });
      ae.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[] { o.aRh(w.B(paramPreference.mUri)) });
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
    cvf();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI
 * JD-Core Version:    0.7.0.1
 */