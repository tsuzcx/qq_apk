package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.viewmodel.a;
import com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI
  extends MMPreference
{
  private String AuC = "";
  private String AuD = "";
  private String AuE = "";
  private FinderLocationPreference AuF;
  private FinderLocationPreference AuG;
  private final String TAG = "Finder.FinderSelectDistrictUI";
  private HashMap _$_findViewCache;
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288847);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288847);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288846);
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
    AppMethodBeat.o(288846);
    return localView1;
  }
  
  public int getResourceId()
  {
    return b.m.finder_location_pref;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(178436);
    super.onCreate(paramBundle);
    setMMTitle(b.j.finder_select_district_title);
    paramBundle = getIntent().getStringExtra("SelectedCountryCode");
    p.j(paramBundle, "intent.getStringExtra(Co…tUI.KSelectedCountryCode)");
    this.AuC = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    p.j(paramBundle, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
    this.AuD = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    p.j(paramBundle, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
    this.AuE = paramBundle;
    paramBundle = getPreferenceScreen().byG("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.AuF = ((FinderLocationPreference)paramBundle);
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.Bup = false;
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.xUg = true;
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.setCountryCode(this.AuC);
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.aGJ(this.AuD);
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.aGK(this.AuE);
    paramBundle = this.AuF;
    if (paramBundle == null) {
      p.bGy("currentDistrictPref");
    }
    paramBundle.updateTitle();
    paramBundle = getPreferenceScreen().byG("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.AuG = ((FinderLocationPreference)paramBundle);
    paramBundle = g.Xox;
    paramBundle = ((a)g.bD(PluginFinder.class).i(a.class)).Bgf;
    if (paramBundle != null)
    {
      FinderLocationPreference localFinderLocationPreference = this.AuG;
      if (localFinderLocationPreference == null) {
        p.bGy("currentLocationPref");
      }
      localFinderLocationPreference.Bup = true;
      localFinderLocationPreference = this.AuG;
      if (localFinderLocationPreference == null) {
        p.bGy("currentLocationPref");
      }
      String str = paramBundle.mVH;
      p.j(str, "it.Country");
      localFinderLocationPreference.setCountryCode(str);
      localFinderLocationPreference = this.AuG;
      if (localFinderLocationPreference == null) {
        p.bGy("currentLocationPref");
      }
      str = paramBundle.mVz;
      p.j(str, "it.Province");
      localFinderLocationPreference.aGJ(str);
      localFinderLocationPreference = this.AuG;
      if (localFinderLocationPreference == null) {
        p.bGy("currentLocationPref");
      }
      paramBundle = paramBundle.mVA;
      p.j(paramBundle, "it.City");
      localFinderLocationPreference.aGK(paramBundle);
      paramBundle = this.AuG;
      if (paramBundle == null) {
        p.bGy("currentLocationPref");
      }
      paramBundle.updateTitle();
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(b.j.app_finish), (MenuItem.OnMenuItemClickListener)new a(this), null, w.b.Wao);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      new StringBuilder("init location ").append(this.AuC).append(' ').append(this.AuD).append(' ').append(this.AuE);
      h.ioq();
      AppMethodBeat.o(178436);
      return;
      paramBundle = (FinderSelectDistrictUI)this;
      paramBundle.getPreferenceScreen().dz("select_current_location_title", true);
      paramBundle.getPreferenceScreen().dz("select_current_location", true);
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
          paramPreference = this.AuF;
          if (paramPreference == null) {
            p.bGy("currentDistrictPref");
          }
          paramPreference.xUg = true;
          paramPreference = this.AuG;
          if (paramPreference == null) {
            p.bGy("currentLocationPref");
          }
          paramPreference.xUg = false;
          paramPreference = this.AuF;
          if (paramPreference == null) {
            p.bGy("currentDistrictPref");
          }
          this.AuC = paramPreference.countryCode;
          paramPreference = this.AuF;
          if (paramPreference == null) {
            p.bGy("currentDistrictPref");
          }
          this.AuD = paramPreference.provinceCode;
          paramPreference = this.AuF;
          if (paramPreference == null) {
            p.bGy("currentDistrictPref");
          }
          this.AuE = paramPreference.cityCode;
        }
        break;
      case -409505634: 
        if (paramPreference.equals("select_current_location"))
        {
          paramPreference = this.AuF;
          if (paramPreference == null) {
            p.bGy("currentDistrictPref");
          }
          paramPreference.xUg = false;
          paramPreference = this.AuG;
          if (paramPreference == null) {
            p.bGy("currentLocationPref");
          }
          paramPreference.xUg = true;
          paramPreference = this.AuG;
          if (paramPreference == null) {
            p.bGy("currentLocationPref");
          }
          this.AuC = paramPreference.countryCode;
          paramPreference = this.AuG;
          if (paramPreference == null) {
            p.bGy("currentLocationPref");
          }
          this.AuD = paramPreference.provinceCode;
          paramPreference = this.AuG;
          if (paramPreference == null) {
            p.bGy("currentLocationPref");
          }
          this.AuE = paramPreference.cityCode;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178434);
      FinderSelectDistrictUI.a(this.AuH);
      AppMethodBeat.o(178434);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectDistrictUI paramFinderSelectDistrictUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178435);
      this.AuH.finish();
      AppMethodBeat.o(178435);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */