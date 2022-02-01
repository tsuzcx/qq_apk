package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getResourceId", "", "initNotRecommendBtn", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNotRecommendClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
public final class FinderSettingPrivacyUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSettingPrivacyUI";
  
  public final int getResourceId()
  {
    return 2131951681;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167619);
    super.onCreate(paramBundle);
    setMMTitle(2131759308);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(167619);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167621);
    if (paramPreference == null) {
      k.fOy();
    }
    paramf = paramPreference.getKey();
    ac.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(167621);
          return true;
          switch (paramf.hashCode())
          {
          default: 
            break;
          case 541151233: 
            if (paramf.equals("settings_blacklist"))
            {
              paramf = new Intent();
              paramf.setClass((Context)this, FinderBlackListUI.class);
              paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            break;
          }
        }
      } while (!paramf.equals("settings_like_feed_not_recommend"));
      paramf = getPreferenceScreen().aPN("settings_like_feed_not_recommend");
      if (paramf == null)
      {
        paramf = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167621);
        throw paramf;
      }
      paramf = (CheckBoxPreference)paramf;
    } while (paramf == null);
    boolean bool = paramf.isChecked();
    ac.d(this.TAG, "set if not recommend button send : %s", new Object[] { Boolean.valueOf(bool) });
    paramf = g.agR();
    k.g(paramf, "MMKernel.storage()");
    int i = paramf.agA().getInt(ah.a.GUq, 0);
    if (bool)
    {
      i |= 0x20;
      paramf = d.rxr;
      d.fy(2, 1);
    }
    for (;;)
    {
      paramf = g.agR();
      k.g(paramf, "MMKernel.storage()");
      paramf.agA().set(ah.a.GUq, Integer.valueOf(i));
      ((h)g.ab(h.class)).lr(bool);
      break;
      i &= 0xFFFFFFDF;
      paramf = d.rxr;
      d.fy(2, 2);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167620);
    super.onResume();
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    if ((((e)localObject).agA().getInt(ah.a.GUq, 0) & 0x20) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d(this.TAG, "initNotRecommendBtn:".concat(String.valueOf(bool)));
      localObject = getPreferenceScreen().aPN("settings_like_feed_not_recommend");
      if (localObject != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    ((CheckBoxPreference)localObject).setChecked(bool);
    ((CheckBoxPreference)localObject).fjt();
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(167620);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167618);
      this.rLE.finish();
      AppMethodBeat.o(167618);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */