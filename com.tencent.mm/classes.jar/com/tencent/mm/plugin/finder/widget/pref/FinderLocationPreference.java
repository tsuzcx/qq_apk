package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cityCode", "", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "locationIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mView", "Landroid/view/View;", "provinceCode", "getProvinceCode", "setProvinceCode", "selectIV", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "showLocationIcon", "getShowLocationIcon", "setShowLocationIcon", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "updateTitle", "plugin-finder_release"})
public final class FinderLocationPreference
  extends Preference
{
  private WeImageView Bun;
  private WeImageView Buo;
  public boolean Bup;
  public String cityCode;
  public String countryCode;
  private View mView;
  public String provinceCode;
  public boolean xUg;
  
  public FinderLocationPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.countryCode = "";
    this.provinceCode = "";
    this.cityCode = "";
  }
  
  public FinderLocationPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(178503);
    this.countryCode = "";
    this.provinceCode = "";
    this.cityCode = "";
    setLayoutResource(b.g.mm_preference);
    AppMethodBeat.o(178503);
  }
  
  public final void aGJ(String paramString)
  {
    AppMethodBeat.i(178498);
    p.k(paramString, "<set-?>");
    this.provinceCode = paramString;
    AppMethodBeat.o(178498);
  }
  
  public final void aGK(String paramString)
  {
    AppMethodBeat.i(178499);
    p.k(paramString, "<set-?>");
    this.cityCode = paramString;
    AppMethodBeat.o(178499);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(178501);
    p.k(paramView, "view");
    super.onBindView(paramView);
    auO(8);
    Object localObject = paramView.findViewById(b.f.state_icon);
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.Buo = ((WeImageView)localObject);
    localObject = this.Buo;
    if (localObject != null) {
      if (!this.xUg) {
        break label119;
      }
    }
    label119:
    for (int i = 0;; i = 8)
    {
      ((WeImageView)localObject).setVisibility(i);
      paramView = paramView.findViewById(b.f.location_icon);
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.Bun = ((WeImageView)paramView);
    paramView = this.Bun;
    if (paramView != null)
    {
      if (this.Bup) {}
      for (i = j;; i = 8)
      {
        paramView.setVisibility(i);
        AppMethodBeat.o(178501);
        return;
      }
    }
    AppMethodBeat.o(178501);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(178500);
    p.k(paramViewGroup, "parent");
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(b.f.content);
    if (localObject == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(178500);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(getContext(), b.g.finder_location_preference_select, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(178500);
    return paramViewGroup;
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(178497);
    p.k(paramString, "<set-?>");
    this.countryCode = paramString;
    AppMethodBeat.o(178497);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(178502);
    if (!p.h(this.countryCode, "unshow")) {
      if (((CharSequence)this.countryCode).length() != 0) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i != 0; i = 0)
    {
      setTitle((CharSequence)getContext().getString(b.j.finder_settings_unshow));
      AppMethodBeat.o(178502);
      return;
    }
    RegionCodeDecoder.hAC();
    String str1 = RegionCodeDecoder.bxo(this.countryCode);
    RegionCodeDecoder.hAC();
    String str2 = RegionCodeDecoder.nN(this.countryCode, this.provinceCode);
    RegionCodeDecoder.hAC();
    String str3 = RegionCodeDecoder.bm(this.countryCode, this.provinceCode, this.cityCode);
    if (!Util.isNullOrNil(str3))
    {
      setTitle((CharSequence)(((b)h.ae(b.class)).PL(str2) + " " + str3));
      AppMethodBeat.o(178502);
      return;
    }
    if (!Util.isNullOrNil(str2))
    {
      setTitle((CharSequence)(str1 + ' ' + str2));
      AppMethodBeat.o(178502);
      return;
    }
    if (!Util.isNullOrNil(str1)) {
      setTitle((CharSequence)str1);
    }
    AppMethodBeat.o(178502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference
 * JD-Core Version:    0.7.0.1
 */