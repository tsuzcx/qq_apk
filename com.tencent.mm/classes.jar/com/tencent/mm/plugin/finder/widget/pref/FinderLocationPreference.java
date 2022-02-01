package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cityCode", "", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "locationIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mView", "Landroid/view/View;", "provinceCode", "getProvinceCode", "setProvinceCode", "selectIV", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "showLocationIcon", "getShowLocationIcon", "setShowLocationIcon", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "updateTitle", "plugin-finder_release"})
public final class FinderLocationPreference
  extends Preference
{
  public String cityCode;
  public String countryCode;
  private View mView;
  public String provinceCode;
  private WeImageView sjd;
  private WeImageView sje;
  public boolean sjf;
  public boolean sjg;
  
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
    setLayoutResource(2131494804);
    AppMethodBeat.o(178503);
  }
  
  public final void aeS(String paramString)
  {
    AppMethodBeat.i(178498);
    k.h(paramString, "<set-?>");
    this.provinceCode = paramString;
    AppMethodBeat.o(178498);
  }
  
  public final void aeT(String paramString)
  {
    AppMethodBeat.i(178499);
    k.h(paramString, "<set-?>");
    this.cityCode = paramString;
    AppMethodBeat.o(178499);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(178501);
    k.h(paramView, "view");
    super.onBindView(paramView);
    aam(8);
    Object localObject = paramView.findViewById(2131305186);
    if (localObject == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.sje = ((WeImageView)localObject);
    localObject = this.sje;
    if (localObject != null) {
      if (!this.sjf) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = 8)
    {
      ((WeImageView)localObject).setVisibility(i);
      paramView = paramView.findViewById(2131301524);
      if (paramView != null) {
        break;
      }
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.sjd = ((WeImageView)paramView);
    paramView = this.sjd;
    if (paramView != null)
    {
      if (this.sjg) {}
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
    k.h(paramViewGroup, "parent");
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(2131298739);
    if (localObject == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(178500);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(getContext(), 2131494061, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(178500);
    return paramViewGroup;
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(178497);
    k.h(paramString, "<set-?>");
    this.countryCode = paramString;
    AppMethodBeat.o(178497);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(178502);
    if (!k.g(this.countryCode, "unshow")) {
      if (((CharSequence)this.countryCode).length() != 0) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      setTitle((CharSequence)getContext().getString(2131759353));
      AppMethodBeat.o(178502);
      return;
    }
    RegionCodeDecoder.fcs();
    String str1 = RegionCodeDecoder.getCountry(this.countryCode);
    RegionCodeDecoder.fcs();
    String str2 = RegionCodeDecoder.lC(this.countryCode, this.provinceCode);
    RegionCodeDecoder.fcs();
    String str3 = RegionCodeDecoder.aX(this.countryCode, this.provinceCode, this.cityCode);
    if (!bs.isNullOrNil(str3))
    {
      setTitle((CharSequence)(((b)g.ab(b.class)).wm(str2) + " " + str3));
      AppMethodBeat.o(178502);
      return;
    }
    if (!bs.isNullOrNil(str2))
    {
      setTitle((CharSequence)(str1 + ' ' + str2));
      AppMethodBeat.o(178502);
      return;
    }
    if (!bs.isNullOrNil(str1)) {
      setTitle((CharSequence)str1);
    }
    AppMethodBeat.o(178502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference
 * JD-Core Version:    0.7.0.1
 */