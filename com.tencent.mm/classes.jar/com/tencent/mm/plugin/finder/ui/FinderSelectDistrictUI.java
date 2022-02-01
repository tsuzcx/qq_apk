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
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.s.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private String sFS = "";
  private String sFT = "";
  private String sFU = "";
  private FinderLocationPreference sFV;
  private FinderLocationPreference sFW;
  
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
    p.g(paramBundle, "intent.getStringExtra(Co…tUI.KSelectedCountryCode)");
    this.sFS = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    p.g(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.sFT = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    p.g(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.sFU = paramBundle;
    paramBundle = getPreferenceScreen().aVD("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.sFV = ((FinderLocationPreference)paramBundle);
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.tfI = false;
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.tfH = true;
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.sFS);
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.ajq(this.sFT);
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.ajr(this.sFU);
    paramBundle = this.sFV;
    if (paramBundle == null) {
      p.bcb("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().aVD("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.sFW = ((FinderLocationPreference)paramBundle);
    paramBundle = a.KiD;
    paramBundle = ((FinderGlobalLocationVM)a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).sYY;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.sFW;
      if (localFinderLocationPreference == null) {
        p.bcb("currentLocationPref");
      }
      localFinderLocationPreference.tfI = true;
      localFinderLocationPreference = this.sFW;
      if (localFinderLocationPreference == null) {
        p.bcb("currentLocationPref");
      }
      String str = paramBundle.jdl;
      p.g(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.sFW;
      if (localFinderLocationPreference == null) {
        p.bcb("currentLocationPref");
      }
      str = paramBundle.jdd;
      p.g(str, "it.Province");
      localFinderLocationPreference.ajq(str);
      localFinderLocationPreference = this.sFW;
      if (localFinderLocationPreference == null) {
        p.bcb("currentLocationPref");
      }
      paramBundle = paramBundle.jde;
      p.g(paramBundle, "it.City");
      localFinderLocationPreference.ajr(paramBundle);
      paramBundle = this.sFW;
      if (paramBundle == null) {
        p.bcb("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.JbS);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.sFS).append(' ').append(this.sFT).append(' ').append(this.sFU);
      h.fUh();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().cP("select_current_location_title", true);
      paramBundle.getPreferenceScreen().cP("select_current_location", true);
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
          paramPreference = this.sFV;
          if (paramPreference == null) {
            p.bcb("currentDistrictPref");
          }
          paramPreference.tfH = true;
          paramPreference = this.sFW;
          if (paramPreference == null) {
            p.bcb("currentLocationPref");
          }
          paramPreference.tfH = false;
          paramPreference = this.sFV;
          if (paramPreference == null) {
            p.bcb("currentDistrictPref");
          }
          this.sFS = paramPreference.countryCode;
          paramPreference = this.sFV;
          if (paramPreference == null) {
            p.bcb("currentDistrictPref");
          }
          this.sFT = paramPreference.provinceCode;
          paramPreference = this.sFV;
          if (paramPreference == null) {
            p.bcb("currentDistrictPref");
          }
          this.sFU = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.sFV;
          if (paramPreference == null) {
            p.bcb("currentDistrictPref");
          }
          paramPreference.tfH = false;
          paramPreference = this.sFW;
          if (paramPreference == null) {
            p.bcb("currentLocationPref");
          }
          paramPreference.tfH = true;
          paramPreference = this.sFW;
          if (paramPreference == null) {
            p.bcb("currentLocationPref");
          }
          this.sFS = paramPreference.countryCode;
          paramPreference = this.sFW;
          if (paramPreference == null) {
            p.bcb("currentLocationPref");
          }
          this.sFT = paramPreference.provinceCode;
          paramPreference = this.sFW;
          if (paramPreference == null) {
            p.bcb("currentLocationPref");
          }
          this.sFU = paramPreference.cityCode;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.sFX);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.sFX.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */