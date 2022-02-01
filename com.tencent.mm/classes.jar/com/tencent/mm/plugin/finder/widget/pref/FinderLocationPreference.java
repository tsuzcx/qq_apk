package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cityCode", "", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "locationIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mView", "Landroid/view/View;", "provinceCode", "getProvinceCode", "setProvinceCode", "selectIV", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "showLocationIcon", "getShowLocationIcon", "setShowLocationIcon", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "updateTitle", "plugin-finder_release"})
public final class FinderLocationPreference
  extends Preference
{
  public String cityCode;
  public String countryCode;
  private View mView;
  public String provinceCode;
  public boolean uOQ;
  private WeImageView wDF;
  private WeImageView wDG;
  public boolean wDH;
  
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
    setLayoutResource(2131495538);
    AppMethodBeat.o(178503);
  }
  
  public final void awY(String paramString)
  {
    AppMethodBeat.i(178498);
    p.h(paramString, "<set-?>");
    this.provinceCode = paramString;
    AppMethodBeat.o(178498);
  }
  
  public final void awZ(String paramString)
  {
    AppMethodBeat.i(178499);
    p.h(paramString, "<set-?>");
    this.cityCode = paramString;
    AppMethodBeat.o(178499);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(178501);
    p.h(paramView, "view");
    super.onBindView(paramView);
    alO(8);
    Object localObject = paramView.findViewById(2131308377);
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.wDG = ((WeImageView)localObject);
    localObject = this.wDG;
    if (localObject != null) {
      if (!this.uOQ) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = 8)
    {
      ((WeImageView)localObject).setVisibility(i);
      paramView = paramView.findViewById(2131303730);
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.wDF = ((WeImageView)paramView);
    paramView = this.wDF;
    if (paramView != null)
    {
      if (this.wDH) {}
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
    p.h(paramViewGroup, "parent");
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(2131299180);
    if (localObject == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(178500);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(getContext(), 2131494492, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(178500);
    return paramViewGroup;
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(178497);
    p.h(paramString, "<set-?>");
    this.countryCode = paramString;
    AppMethodBeat.o(178497);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(178502);
    if (!p.j(this.countryCode, "unshow")) {
      if (((CharSequence)this.countryCode).length() != 0) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      setTitle((CharSequence)getContext().getString(2131760563));
      AppMethodBeat.o(178502);
      return;
    }
    RegionCodeDecoder.gEm();
    String str1 = RegionCodeDecoder.getCountry(this.countryCode);
    RegionCodeDecoder.gEm();
    String str2 = RegionCodeDecoder.mV(this.countryCode, this.provinceCode);
    RegionCodeDecoder.gEm();
    String str3 = RegionCodeDecoder.br(this.countryCode, this.provinceCode, this.cityCode);
    if (!Util.isNullOrNil(str3))
    {
      setTitle((CharSequence)(((b)g.af(b.class)).It(str2) + " " + str3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference
 * JD-Core Version:    0.7.0.1
 */