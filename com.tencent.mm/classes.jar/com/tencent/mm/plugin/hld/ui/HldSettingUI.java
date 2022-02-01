package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.z;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getForceOrientation", "", "getResourceId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldSettingUI
  extends MMPreference
{
  public static final HldSettingUI.a JxS;
  
  static
  {
    AppMethodBeat.i(312298);
    JxS = new HldSettingUI.a((byte)0);
    AppMethodBeat.o(312298);
  }
  
  private static final void a(HldSettingUI paramHldSettingUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(312288);
    kotlin.g.b.s.u(paramHldSettingUI, "this$0");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    Log.i("WxIme.ContactWidgetWxIme", "clear personal dict");
    paramMenuItem = n.JvW;
    if (!n.fNa()) {
      n.fMJ();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      paramMenuItem = com.tencent.mm.plugin.hld.f.f.Jyn;
      paramMenuItem = com.tencent.mm.plugin.hld.f.f.fOi();
      boolean bool2 = y.ew(paramMenuItem, true);
      Object localObject = l.JyV;
      localObject = l.fPk();
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).putBoolean("ime_local_user_dict_load_finish", false);
      }
      localObject = l.JyV;
      localObject = l.fPk();
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).putBoolean("ime_phone_contact_data_load_finish", false);
      }
      localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      ((Intent)localObject).putExtra("ime_finalize", true);
      c.n((Intent)localObject, "hld");
      Log.i("WxIme.WxEngineMgr", "clearUserDictPath " + bool1 + ' ' + paramMenuItem + ' ' + bool2);
      z.a(null, (CharSequence)paramHldSettingUI.getContext().getResources().getString(a.j.ime_clear_user_dict_finish), (Context)paramHldSettingUI.getContext(), 0, null);
      AppMethodBeat.o(312288);
      return;
    }
  }
  
  private static final void a(HldSettingUI paramHldSettingUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(312280);
    kotlin.g.b.s.u(paramHldSettingUI, "this$0");
    params.a(0, paramHldSettingUI.getContext().getResources().getColor(a.c.red_text_color), (CharSequence)paramHldSettingUI.getContext().getString(a.j.ime_setting_clear_title));
    AppMethodBeat.o(312280);
  }
  
  private static final boolean a(HldSettingUI paramHldSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312269);
    kotlin.g.b.s.u(paramHldSettingUI, "this$0");
    paramHldSettingUI.finish();
    AppMethodBeat.o(312269);
    return true;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_setting;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312333);
    k localk = k.JvH;
    k.rO(System.currentTimeMillis());
    super.onCreate(paramBundle);
    setMMTitle(a.j.welab_name_hld_setting);
    setBackBtn(new HldSettingUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(312333);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(312351);
    kotlin.g.b.s.u(paramf, "screen");
    kotlin.g.b.s.u(paramPreference, "pref");
    paramPreference = paramPreference.mKey;
    paramf = paramPreference;
    if (paramPreference == null) {
      paramf = "";
    }
    switch (paramf.hashCode())
    {
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(312351);
      return true;
      if (paramf.equals("settings_safety"))
      {
        paramPreference = new Intent((Context)getContext(), HldModeSettingUI.class);
        paramf = getContext();
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf.startActivity((Intent)paramPreference.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if (paramf.equals("settings_keyboard"))
        {
          paramPreference = new Intent((Context)getContext(), HldKeyboardSettingUI.class);
          paramf = getContext();
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          if (paramf.equals("settings_clear_personal_dict"))
          {
            Log.i("WxIme.HldSettingUI", "click KEY_CLEAR_PERSONAL_DICT");
            paramf = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, true);
            paramf.h((CharSequence)getContext().getString(a.j.ime_setting_clear_personal_dict_desc), 17, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 14));
            paramf.Vtg = new HldSettingUI..ExternalSyntheticLambda1(this);
            paramf.GAC = new HldSettingUI..ExternalSyntheticLambda2(this);
            paramf.dDn();
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldSettingUI
 * JD-Core Version:    0.7.0.1
 */