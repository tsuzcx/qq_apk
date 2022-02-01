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
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.s.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private String rKR = "";
  private String rKS = "";
  private String rKT = "";
  private FinderLocationPreference rKU;
  private FinderLocationPreference rKV;
  
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
    this.rKR = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    k.g(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.rKS = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    k.g(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.rKT = paramBundle;
    paramBundle = getPreferenceScreen().aPN("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.rKU = ((FinderLocationPreference)paramBundle);
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.sjg = false;
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.sjf = true;
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.rKR);
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.aeS(this.rKS);
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.aeT(this.rKT);
    paramBundle = this.rKU;
    if (paramBundle == null) {
      k.aVY("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().aPN("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.rKV = ((FinderLocationPreference)paramBundle);
    paramBundle = a.IrY;
    paramBundle = ((FinderGlobalLocationVM)a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class)).sbI;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.rKV;
      if (localFinderLocationPreference == null) {
        k.aVY("currentLocationPref");
      }
      localFinderLocationPreference.sjg = true;
      localFinderLocationPreference = this.rKV;
      if (localFinderLocationPreference == null) {
        k.aVY("currentLocationPref");
      }
      String str = paramBundle.iKc;
      k.g(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.rKV;
      if (localFinderLocationPreference == null) {
        k.aVY("currentLocationPref");
      }
      str = paramBundle.iJU;
      k.g(str, "it.Province");
      localFinderLocationPreference.aeS(str);
      localFinderLocationPreference = this.rKV;
      if (localFinderLocationPreference == null) {
        k.aVY("currentLocationPref");
      }
      paramBundle = paramBundle.iJV;
      k.g(paramBundle, "it.City");
      localFinderLocationPreference.aeT(paramBundle);
      paramBundle = this.rKV;
      if (paramBundle == null) {
        k.aVY("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.Hom);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.rKR).append(' ').append(this.rKS).append(' ').append(this.rKT);
      h.fCP();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().cK("select_current_location_title", true);
      paramBundle.getPreferenceScreen().cK("select_current_location", true);
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
          paramPreference = this.rKU;
          if (paramPreference == null) {
            k.aVY("currentDistrictPref");
          }
          paramPreference.sjf = true;
          paramPreference = this.rKV;
          if (paramPreference == null) {
            k.aVY("currentLocationPref");
          }
          paramPreference.sjf = false;
          paramPreference = this.rKU;
          if (paramPreference == null) {
            k.aVY("currentDistrictPref");
          }
          this.rKR = paramPreference.countryCode;
          paramPreference = this.rKU;
          if (paramPreference == null) {
            k.aVY("currentDistrictPref");
          }
          this.rKS = paramPreference.provinceCode;
          paramPreference = this.rKU;
          if (paramPreference == null) {
            k.aVY("currentDistrictPref");
          }
          this.rKT = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.rKU;
          if (paramPreference == null) {
            k.aVY("currentDistrictPref");
          }
          paramPreference.sjf = false;
          paramPreference = this.rKV;
          if (paramPreference == null) {
            k.aVY("currentLocationPref");
          }
          paramPreference.sjf = true;
          paramPreference = this.rKV;
          if (paramPreference == null) {
            k.aVY("currentLocationPref");
          }
          this.rKR = paramPreference.countryCode;
          paramPreference = this.rKV;
          if (paramPreference == null) {
            k.aVY("currentLocationPref");
          }
          this.rKS = paramPreference.provinceCode;
          paramPreference = this.rKV;
          if (paramPreference == null) {
            k.aVY("currentLocationPref");
          }
          this.rKT = paramPreference.cityCode;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.rKW);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.rKW.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */