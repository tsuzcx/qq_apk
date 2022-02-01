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
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getResourceId", "", "initNotRecommendBtn", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNotRecommendClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
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
      k.fvU();
    }
    paramf = paramPreference.getKey();
    ad.i(this.TAG, "click ".concat(String.valueOf(paramf)));
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
              paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            break;
          }
        }
      } while (!paramf.equals("settings_like_feed_not_recommend"));
      paramf = getPreferenceScreen().aKk("settings_like_feed_not_recommend");
      if (paramf == null)
      {
        paramf = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167621);
        throw paramf;
      }
      paramf = (CheckBoxPreference)paramf;
    } while (paramf == null);
    boolean bool = paramf.isChecked();
    ad.d(this.TAG, "set if not recommend button send : %s", new Object[] { Boolean.valueOf(bool) });
    paramf = g.afB();
    k.g(paramf, "MMKernel.storage()");
    int i = paramf.afk().getInt(ae.a.Fwo, 0);
    if (bool)
    {
      i |= 0x20;
      paramf = b.qFq;
      b.la(2, 1);
    }
    for (;;)
    {
      paramf = g.afB();
      k.g(paramf, "MMKernel.storage()");
      paramf.afk().set(ae.a.Fwo, Integer.valueOf(i));
      ((m)g.ab(m.class)).yy(bool);
      break;
      i &= 0xFFFFFFDF;
      paramf = b.qFq;
      b.la(2, 2);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167620);
    super.onResume();
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    if ((((e)localObject).afk().getInt(ae.a.Fwo, 0) & 0x20) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d(this.TAG, "initNotRecommendBtn:".concat(String.valueOf(bool)));
      localObject = getPreferenceScreen().aKk("settings_like_feed_not_recommend");
      if (localObject != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    ((CheckBoxPreference)localObject).setChecked(bool);
    ((CheckBoxPreference)localObject).gah();
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(167620);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167618);
      this.qPP.finish();
      AppMethodBeat.o(167618);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */