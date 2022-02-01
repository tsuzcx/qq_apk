package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getForceOrientation", "", "getResourceId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-hld_release"})
public final class HldSettingUI
  extends MMPreference
{
  public static final a DGs;
  
  static
  {
    AppMethodBeat.i(217380);
    DGs = new a((byte)0);
    AppMethodBeat.o(217380);
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
    AppMethodBeat.i(217373);
    k localk = k.DDb;
    k.NW(System.currentTimeMillis());
    super.onCreate(paramBundle);
    setMMTitle(a.j.welab_name_hld_setting);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(217373);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(217377);
    p.k(paramf, "screen");
    p.k(paramPreference, "pref");
    paramPreference = paramPreference.getKey();
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
      AppMethodBeat.o(217377);
      return true;
      if (paramf.equals("settings_safety"))
      {
        paramPreference = new Intent((Context)getContext(), HldModeSettingUI.class);
        paramf = getContext();
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf.startActivity((Intent)paramPreference.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if (paramf.equals("settings_keyboard"))
        {
          paramPreference = new Intent((Context)getContext(), HldKeyboardSettingUI.class);
          paramf = getContext();
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/hld/ui/HldSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          if (paramf.equals("settings_clear_personal_dict"))
          {
            Log.i("WxIme.HldSettingUI", "click KEY_CLEAR_PERSONAL_DICT");
            paramf = new e((Context)getContext(), 1, true);
            paramf.j((CharSequence)getContext().getString(a.j.ime_setting_clear_personal_dict_desc), 17, com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 14));
            paramf.a((q.f)new c(this));
            paramf.a((q.g)new d(this));
            paramf.eik();
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldSettingUI$Companion;", "", "()V", "KEY_CLEAR_PERSONAL_DICT", "", "KEY_KEYBOAR", "KEY_SAFETY", "TAG", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(HldSettingUI paramHldSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(209413);
      this.DGt.finish();
      AppMethodBeat.o(209413);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements q.f
  {
    c(HldSettingUI paramHldSettingUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(211550);
      AppCompatActivity localAppCompatActivity = this.DGt.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.a(0, localAppCompatActivity.getResources().getColor(a.c.red_text_color), (CharSequence)this.DGt.getContext().getString(a.j.ime_setting_clear_title));
      AppMethodBeat.o(211550);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class d
    implements q.g
  {
    d(HldSettingUI paramHldSettingUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(211836);
      p.k(paramMenuItem, "menuItem");
      Log.i("WxIme.ContactWidgetWxIme", "clear personal dict");
      paramMenuItem = n.DEn;
      if (!n.eEX()) {
        n.eEG();
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramMenuItem = com.tencent.mm.plugin.hld.f.f.DGX;
        paramMenuItem = com.tencent.mm.plugin.hld.f.f.eGu();
        boolean bool2 = u.deleteDir(paramMenuItem);
        Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = com.tencent.mm.plugin.hld.f.l.eHB();
        if (localObject != null) {
          ((MultiProcessMMKV)localObject).putBoolean("ime_local_user_dict_load_finish", false);
        }
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = com.tencent.mm.plugin.hld.f.l.eHB();
        if (localObject != null) {
          ((MultiProcessMMKV)localObject).putBoolean("ime_phone_contact_data_load_finish", false);
        }
        localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
        ((Intent)localObject).putExtra("ime_finalize", true);
        c.l((Intent)localObject, "hld");
        Log.i("WxIme.WxEngineMgr", "clearUserDictPath " + bool1 + ' ' + paramMenuItem + ' ' + bool2);
        paramMenuItem = this.DGt.getContext();
        p.j(paramMenuItem, "context");
        v.a((CharSequence)paramMenuItem.getResources().getString(a.j.ime_clear_user_dict_finish), (Context)this.DGt.getContext(), 0, null);
        AppMethodBeat.o(211836);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldSettingUI
 * JD-Core Version:    0.7.0.1
 */