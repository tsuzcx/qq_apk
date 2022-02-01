package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.y.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderSelectDistrictUI
  extends MMPreference
{
  private String FTK = "";
  private String FTL = "";
  private String FTM = "";
  private FinderLocationPreference FTN;
  private FinderLocationPreference FTO;
  private final String TAG = "Finder.FinderSelectDistrictUI";
  
  private static final boolean a(FinderSelectDistrictUI paramFinderSelectDistrictUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346673);
    s.u(paramFinderSelectDistrictUI, "this$0");
    new StringBuilder("complete location ").append(paramFinderSelectDistrictUI.FTK).append(' ').append(paramFinderSelectDistrictUI.FTL).append(' ').append(paramFinderSelectDistrictUI.FTM);
    h.jXD();
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Country", paramFinderSelectDistrictUI.FTK);
    paramMenuItem.putExtra("Contact_Province", paramFinderSelectDistrictUI.FTL);
    paramMenuItem.putExtra("Contact_City", paramFinderSelectDistrictUI.FTM);
    paramFinderSelectDistrictUI.setResult(-1, paramMenuItem);
    paramFinderSelectDistrictUI.finish();
    AppMethodBeat.o(346673);
    return true;
  }
  
  private static final boolean b(FinderSelectDistrictUI paramFinderSelectDistrictUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346680);
    s.u(paramFinderSelectDistrictUI, "this$0");
    paramFinderSelectDistrictUI.finish();
    AppMethodBeat.o(346680);
    return true;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getResourceId()
  {
    return e.k.finder_location_pref;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(178436);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_select_district_title);
    paramBundle = getIntent().getStringExtra("SelectedCountryCode");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(Co…I.KSelectedCountryCode)!!");
    this.FTK = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedProvinceCode");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(Co….KSelectedProvinceCode)!!");
    this.FTL = paramBundle;
    paramBundle = getIntent().getStringExtra("SelectedCityCode");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(Co…ctUI.KSelectedCityCode)!!");
    this.FTM = paramBundle;
    paramBundle = getPreferenceScreen().bAi("select_current_district");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.FTN = ((FinderLocationPreference)paramBundle);
    Object localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.Hba = false;
    localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.Bvd = true;
    localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.setCountryCode(this.FTK);
    localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.aCY(this.FTL);
    localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.aCZ(this.FTM);
    localObject = this.FTN;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("currentDistrictPref");
      paramBundle = null;
    }
    paramBundle.aMl();
    paramBundle = getPreferenceScreen().bAi("select_current_location");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
      AppMethodBeat.o(178436);
      throw paramBundle;
    }
    this.FTO = ((FinderLocationPreference)paramBundle);
    paramBundle = k.aeZF;
    cig localcig = ((b)k.cn(PluginFinder.class).q(b.class)).GJZ;
    if (localcig == null) {}
    for (paramBundle = null;; paramBundle = ah.aiuX)
    {
      if (paramBundle == null)
      {
        paramBundle = (FinderSelectDistrictUI)this;
        paramBundle.getPreferenceScreen().eh("select_current_location_title", true);
        paramBundle.getPreferenceScreen().eh("select_current_location", true);
      }
      getPreferenceScreen().notifyDataSetChanged();
      addTextOptionMenu(0, getString(e.h.app_finish), new FinderSelectDistrictUI..ExternalSyntheticLambda0(this), null, y.b.adEJ);
      setBackBtn(new FinderSelectDistrictUI..ExternalSyntheticLambda1(this));
      new StringBuilder("init location ").append(this.FTK).append(' ').append(this.FTL).append(' ').append(this.FTM);
      h.jXD();
      AppMethodBeat.o(178436);
      return;
      localObject = this.FTO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("currentLocationPref");
        paramBundle = null;
      }
      paramBundle.Hba = true;
      localObject = this.FTO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("currentLocationPref");
        paramBundle = null;
      }
      localObject = localcig.pSo;
      s.s(localObject, "it.Country");
      paramBundle.setCountryCode((String)localObject);
      localObject = this.FTO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("currentLocationPref");
        paramBundle = null;
      }
      localObject = localcig.pSg;
      s.s(localObject, "it.Province");
      paramBundle.aCY((String)localObject);
      localObject = this.FTO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("currentLocationPref");
        paramBundle = null;
      }
      localObject = localcig.pSh;
      s.s(localObject, "it.City");
      paramBundle.aCZ((String)localObject);
      localObject = this.FTO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("currentLocationPref");
        paramBundle = null;
      }
      paramBundle.aMl();
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    FinderLocationPreference localFinderLocationPreference2 = null;
    FinderLocationPreference localFinderLocationPreference1 = null;
    AppMethodBeat.i(178437);
    if (paramPreference != null)
    {
      paramPreference = paramPreference.mKey;
      if (!s.p(paramPreference, "select_current_district")) {
        break label185;
      }
      localFinderLocationPreference2 = this.FTN;
      paramPreference = localFinderLocationPreference2;
      if (localFinderLocationPreference2 == null)
      {
        s.bIx("currentDistrictPref");
        paramPreference = null;
      }
      paramPreference.Bvd = true;
      localFinderLocationPreference2 = this.FTO;
      paramPreference = localFinderLocationPreference2;
      if (localFinderLocationPreference2 == null)
      {
        s.bIx("currentLocationPref");
        paramPreference = null;
      }
      paramPreference.Bvd = false;
      localFinderLocationPreference2 = this.FTN;
      paramPreference = localFinderLocationPreference2;
      if (localFinderLocationPreference2 == null)
      {
        s.bIx("currentDistrictPref");
        paramPreference = null;
      }
      this.FTK = paramPreference.countryCode;
      localFinderLocationPreference2 = this.FTN;
      paramPreference = localFinderLocationPreference2;
      if (localFinderLocationPreference2 == null)
      {
        s.bIx("currentDistrictPref");
        paramPreference = null;
      }
      this.FTL = paramPreference.provinceCode;
      paramPreference = this.FTN;
      if (paramPreference != null) {
        break label182;
      }
      s.bIx("currentDistrictPref");
      paramPreference = localFinderLocationPreference1;
      this.FTM = paramPreference.cityCode;
    }
    label182:
    label185:
    while (!s.p(paramPreference, "select_current_location")) {
      for (;;)
      {
        if (paramf != null) {
          paramf.notifyDataSetChanged();
        }
        AppMethodBeat.o(178437);
        return true;
      }
    }
    localFinderLocationPreference1 = this.FTN;
    paramPreference = localFinderLocationPreference1;
    if (localFinderLocationPreference1 == null)
    {
      s.bIx("currentDistrictPref");
      paramPreference = null;
    }
    paramPreference.Bvd = false;
    localFinderLocationPreference1 = this.FTO;
    paramPreference = localFinderLocationPreference1;
    if (localFinderLocationPreference1 == null)
    {
      s.bIx("currentLocationPref");
      paramPreference = null;
    }
    paramPreference.Bvd = true;
    localFinderLocationPreference1 = this.FTO;
    paramPreference = localFinderLocationPreference1;
    if (localFinderLocationPreference1 == null)
    {
      s.bIx("currentLocationPref");
      paramPreference = null;
    }
    this.FTK = paramPreference.countryCode;
    localFinderLocationPreference1 = this.FTO;
    paramPreference = localFinderLocationPreference1;
    if (localFinderLocationPreference1 == null)
    {
      s.bIx("currentLocationPref");
      paramPreference = null;
    }
    this.FTL = paramPreference.provinceCode;
    paramPreference = this.FTO;
    if (paramPreference == null)
    {
      s.bIx("currentLocationPref");
      paramPreference = localFinderLocationPreference2;
    }
    for (;;)
    {
      this.FTM = paramPreference.cityCode;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */