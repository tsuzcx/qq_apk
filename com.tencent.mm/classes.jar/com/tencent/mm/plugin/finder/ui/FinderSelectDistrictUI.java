package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.r.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private String qPn = "";
  private String qPo = "";
  private String qPp = "";
  private FinderLocationPreference qPq;
  private FinderLocationPreference qPr;
  
  public int getResourceId()
  {
    return 2131951677;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(178436);
    super.onCreate(paramBundle);
    setMMTitle(2131759339);
    paramBundle = getIntent().getStringExtra("SelectedCountryCode");
    k.g(paramBundle, "intent.getStringExtra(Co…tUI.KSelectedCountryCode)");
    this.qPn = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    k.g(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.qPo = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    k.g(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.qPp = paramBundle;
    paramBundle = getPreferenceScreen().aKk("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.qPq = ((FinderLocationPreference)paramBundle);
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.raO = false;
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.raN = true;
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.qPn);
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.aad(this.qPo);
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.aae(this.qPp);
    paramBundle = this.qPq;
    if (paramBundle == null) {
      k.aPZ("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().aKk("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.qPr = ((FinderLocationPreference)paramBundle);
    paramBundle = a.LCX;
    paramBundle = ((FinderGlobalLocationVM)a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class)).LgS;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.qPr;
      if (localFinderLocationPreference == null) {
        k.aPZ("currentLocationPref");
      }
      localFinderLocationPreference.raO = true;
      localFinderLocationPreference = this.qPr;
      if (localFinderLocationPreference == null) {
        k.aPZ("currentLocationPref");
      }
      String str = paramBundle.ijV;
      k.g(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.qPr;
      if (localFinderLocationPreference == null) {
        k.aPZ("currentLocationPref");
      }
      str = paramBundle.ijN;
      k.g(str, "it.Province");
      localFinderLocationPreference.aad(str);
      localFinderLocationPreference = this.qPr;
      if (localFinderLocationPreference == null) {
        k.aPZ("currentLocationPref");
      }
      paramBundle = paramBundle.ijO;
      k.g(paramBundle, "it.City");
      localFinderLocationPreference.aae(paramBundle);
      paramBundle = this.qPr;
      if (paramBundle == null) {
        k.aPZ("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, r.b.FOB);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.qPn).append(' ').append(this.qPo).append(' ').append(this.qPp);
      h.fmz();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().cE("select_current_location_title", true);
      paramBundle.getPreferenceScreen().cE("select_current_location", true);
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(178437);
    if (paramPreference != null)
    {
      paramPreference = paramPreference.getKey();
      if (paramPreference != null) {
        break label37;
      }
    }
    for (;;)
    {
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(178437);
      return true;
      label37:
      switch (paramPreference.hashCode())
      {
      default: 
        break;
      case -2021587849: 
        if (paramPreference.equals("select_current_district"))
        {
          paramPreference = this.qPq;
          if (paramPreference == null) {
            k.aPZ("currentDistrictPref");
          }
          paramPreference.raN = true;
          paramPreference = this.qPr;
          if (paramPreference == null) {
            k.aPZ("currentLocationPref");
          }
          paramPreference.raN = false;
          paramPreference = this.qPq;
          if (paramPreference == null) {
            k.aPZ("currentDistrictPref");
          }
          this.qPn = paramPreference.countryCode;
          paramPreference = this.qPq;
          if (paramPreference == null) {
            k.aPZ("currentDistrictPref");
          }
          this.qPo = paramPreference.provinceCode;
          paramPreference = this.qPq;
          if (paramPreference == null) {
            k.aPZ("currentDistrictPref");
          }
          this.qPp = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.qPq;
          if (paramPreference == null) {
            k.aPZ("currentDistrictPref");
          }
          paramPreference.raN = false;
          paramPreference = this.qPr;
          if (paramPreference == null) {
            k.aPZ("currentLocationPref");
          }
          paramPreference.raN = true;
          paramPreference = this.qPr;
          if (paramPreference == null) {
            k.aPZ("currentLocationPref");
          }
          this.qPn = paramPreference.countryCode;
          paramPreference = this.qPr;
          if (paramPreference == null) {
            k.aPZ("currentLocationPref");
          }
          this.qPo = paramPreference.provinceCode;
          paramPreference = this.qPr;
          if (paramPreference == null) {
            k.aPZ("currentLocationPref");
          }
          this.qPp = paramPreference.cityCode;
        }
        break;
      }
    }
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
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.qPs);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.qPs.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */