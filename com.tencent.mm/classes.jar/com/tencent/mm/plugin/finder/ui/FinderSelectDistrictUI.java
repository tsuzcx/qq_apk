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
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.s.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private String sQR = "";
  private String sQS = "";
  private String sQT = "";
  private FinderLocationPreference sQU;
  private FinderLocationPreference sQV;
  
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
    this.sQR = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    p.g(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.sQS = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    p.g(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.sQT = paramBundle;
    paramBundle = getPreferenceScreen().aXe("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.sQU = ((FinderLocationPreference)paramBundle);
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.tqB = false;
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.tqA = true;
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.sQR);
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.ako(this.sQS);
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.akp(this.sQT);
    paramBundle = this.sQU;
    if (paramBundle == null) {
      p.bdF("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().aXe("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.sQV = ((FinderLocationPreference)paramBundle);
    paramBundle = a.KEX;
    paramBundle = ((FinderGlobalLocationVM)a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).tkm;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.sQV;
      if (localFinderLocationPreference == null) {
        p.bdF("currentLocationPref");
      }
      localFinderLocationPreference.tqB = true;
      localFinderLocationPreference = this.sQV;
      if (localFinderLocationPreference == null) {
        p.bdF("currentLocationPref");
      }
      String str = paramBundle.jge;
      p.g(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.sQV;
      if (localFinderLocationPreference == null) {
        p.bdF("currentLocationPref");
      }
      str = paramBundle.jfW;
      p.g(str, "it.Province");
      localFinderLocationPreference.ako(str);
      localFinderLocationPreference = this.sQV;
      if (localFinderLocationPreference == null) {
        p.bdF("currentLocationPref");
      }
      paramBundle = paramBundle.jfX;
      p.g(paramBundle, "it.City");
      localFinderLocationPreference.akp(paramBundle);
      paramBundle = this.sQV;
      if (paramBundle == null) {
        p.bdF("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.JwA);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.sQR).append(' ').append(this.sQS).append(' ').append(this.sQT);
      h.fYG();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().cT("select_current_location_title", true);
      paramBundle.getPreferenceScreen().cT("select_current_location", true);
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
          paramPreference = this.sQU;
          if (paramPreference == null) {
            p.bdF("currentDistrictPref");
          }
          paramPreference.tqA = true;
          paramPreference = this.sQV;
          if (paramPreference == null) {
            p.bdF("currentLocationPref");
          }
          paramPreference.tqA = false;
          paramPreference = this.sQU;
          if (paramPreference == null) {
            p.bdF("currentDistrictPref");
          }
          this.sQR = paramPreference.countryCode;
          paramPreference = this.sQU;
          if (paramPreference == null) {
            p.bdF("currentDistrictPref");
          }
          this.sQS = paramPreference.provinceCode;
          paramPreference = this.sQU;
          if (paramPreference == null) {
            p.bdF("currentDistrictPref");
          }
          this.sQT = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.sQU;
          if (paramPreference == null) {
            p.bdF("currentDistrictPref");
          }
          paramPreference.tqA = false;
          paramPreference = this.sQV;
          if (paramPreference == null) {
            p.bdF("currentLocationPref");
          }
          paramPreference.tqA = true;
          paramPreference = this.sQV;
          if (paramPreference == null) {
            p.bdF("currentLocationPref");
          }
          this.sQR = paramPreference.countryCode;
          paramPreference = this.sQV;
          if (paramPreference == null) {
            p.bdF("currentLocationPref");
          }
          this.sQS = paramPreference.provinceCode;
          paramPreference = this.sQV;
          if (paramPreference == null) {
            p.bdF("currentLocationPref");
          }
          this.sQT = paramPreference.cityCode;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.sQW);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.sQW.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */