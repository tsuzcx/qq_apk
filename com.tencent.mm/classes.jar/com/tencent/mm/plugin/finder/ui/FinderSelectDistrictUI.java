package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.t.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private HashMap _$_findViewCache;
  private String vNK = "";
  private String vNL = "";
  private String vNM = "";
  private FinderLocationPreference vNN;
  private FinderLocationPreference vNO;
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252651);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252651);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252650);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(252650);
    return localView1;
  }
  
  public int getResourceId()
  {
    return 2132017218;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(178436);
    super.onCreate(paramBundle);
    setMMTitle(2131760530);
    paramBundle = getIntent().getStringExtra("SelectedCountryCode");
    p.g(paramBundle, "intent.getStringExtra(Co…tUI.KSelectedCountryCode)");
    this.vNK = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    p.g(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.vNL = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    p.g(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.vNM = paramBundle;
    paramBundle = getPreferenceScreen().bmg("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.vNN = ((FinderLocationPreference)paramBundle);
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.wDH = false;
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.uOQ = true;
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.vNK);
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.awY(this.vNL);
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.awZ(this.vNM);
    paramBundle = this.vNN;
    if (paramBundle == null) {
      p.btv("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().bmg("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.vNO = ((FinderLocationPreference)paramBundle);
    paramBundle = a.PRN;
    paramBundle = ((FinderGlobalLocationVM)a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.vNO;
      if (localFinderLocationPreference == null) {
        p.btv("currentLocationPref");
      }
      localFinderLocationPreference.wDH = true;
      localFinderLocationPreference = this.vNO;
      if (localFinderLocationPreference == null) {
        p.btv("currentLocationPref");
      }
      String str = paramBundle.keh;
      p.g(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.vNO;
      if (localFinderLocationPreference == null) {
        p.btv("currentLocationPref");
      }
      str = paramBundle.kdZ;
      p.g(str, "it.Province");
      localFinderLocationPreference.awY(str);
      localFinderLocationPreference = this.vNO;
      if (localFinderLocationPreference == null) {
        p.btv("currentLocationPref");
      }
      paramBundle = paramBundle.kea;
      p.g(paramBundle, "it.City");
      localFinderLocationPreference.awZ(paramBundle);
      paramBundle = this.vNO;
      if (paramBundle == null) {
        p.btv("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(2131755858), (MenuItem.OnMenuItemClickListener)new a(this), null, t.b.OGU);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.vNK).append(' ').append(this.vNL).append(' ').append(this.vNM);
      h.hkS();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().jdMethod_do("select_current_location_title", true);
      paramBundle.getPreferenceScreen().jdMethod_do("select_current_location", true);
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
          paramPreference = this.vNN;
          if (paramPreference == null) {
            p.btv("currentDistrictPref");
          }
          paramPreference.uOQ = true;
          paramPreference = this.vNO;
          if (paramPreference == null) {
            p.btv("currentLocationPref");
          }
          paramPreference.uOQ = false;
          paramPreference = this.vNN;
          if (paramPreference == null) {
            p.btv("currentDistrictPref");
          }
          this.vNK = paramPreference.countryCode;
          paramPreference = this.vNN;
          if (paramPreference == null) {
            p.btv("currentDistrictPref");
          }
          this.vNL = paramPreference.provinceCode;
          paramPreference = this.vNN;
          if (paramPreference == null) {
            p.btv("currentDistrictPref");
          }
          this.vNM = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.vNN;
          if (paramPreference == null) {
            p.btv("currentDistrictPref");
          }
          paramPreference.uOQ = false;
          paramPreference = this.vNO;
          if (paramPreference == null) {
            p.btv("currentLocationPref");
          }
          paramPreference.uOQ = true;
          paramPreference = this.vNO;
          if (paramPreference == null) {
            p.btv("currentLocationPref");
          }
          this.vNK = paramPreference.countryCode;
          paramPreference = this.vNO;
          if (paramPreference == null) {
            p.btv("currentLocationPref");
          }
          this.vNL = paramPreference.provinceCode;
          paramPreference = this.vNO;
          if (paramPreference == null) {
            p.btv("currentLocationPref");
          }
          this.vNM = paramPreference.cityCode;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.vNP);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.vNP.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */