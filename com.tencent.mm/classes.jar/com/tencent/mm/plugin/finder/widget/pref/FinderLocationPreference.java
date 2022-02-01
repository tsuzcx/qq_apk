package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cityCode", "", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "locationIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mView", "Landroid/view/View;", "provinceCode", "getProvinceCode", "setProvinceCode", "selectIV", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "showLocationIcon", "getShowLocationIcon", "setShowLocationIcon", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "updateTitle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLocationPreference
  extends Preference
{
  public boolean Bvd;
  private WeImageView HaY;
  private WeImageView HaZ;
  public boolean Hba;
  public String cityCode;
  public String countryCode;
  private View mView;
  public String provinceCode;
  
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
    setLayoutResource(e.f.mm_preference);
    AppMethodBeat.o(178503);
  }
  
  public final void aCY(String paramString)
  {
    AppMethodBeat.i(178498);
    s.u(paramString, "<set-?>");
    this.provinceCode = paramString;
    AppMethodBeat.o(178498);
  }
  
  public final void aCZ(String paramString)
  {
    AppMethodBeat.i(178499);
    s.u(paramString, "<set-?>");
    this.cityCode = paramString;
    AppMethodBeat.o(178499);
  }
  
  public final void aMl()
  {
    AppMethodBeat.i(178502);
    if (!s.p(this.countryCode, "unshow")) {
      if (((CharSequence)this.countryCode).length() != 0) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i != 0; i = 0)
    {
      setTitle((CharSequence)this.mContext.getString(e.h.finder_settings_unshow));
      AppMethodBeat.o(178502);
      return;
    }
    RegionCodeDecoder.jcF();
    String str1 = RegionCodeDecoder.getLocName(this.countryCode);
    RegionCodeDecoder.jcF();
    String str2 = RegionCodeDecoder.pL(this.countryCode, this.provinceCode);
    RegionCodeDecoder.jcF();
    String str3 = RegionCodeDecoder.bJ(this.countryCode, this.provinceCode, this.cityCode);
    if (!Util.isNullOrNil(str3))
    {
      setTitle((CharSequence)(((b)h.ax(b.class)).IF(str2) + ' ' + str3));
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
  
  public final void onBindView(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(178501);
    s.u(paramView, "view");
    super.onBindView(paramView);
    aBq(8);
    Object localObject = paramView.findViewById(e.e.state_icon);
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.HaZ = ((WeImageView)localObject);
    localObject = this.HaZ;
    if (localObject != null) {
      if (!this.Bvd) {
        break label119;
      }
    }
    label119:
    for (int i = 0;; i = 8)
    {
      ((WeImageView)localObject).setVisibility(i);
      paramView = paramView.findViewById(e.e.location_icon);
      if (paramView != null) {
        break;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178501);
      throw paramView;
    }
    this.HaY = ((WeImageView)paramView);
    paramView = this.HaY;
    if (paramView != null) {
      if (!this.Hba) {
        break label162;
      }
    }
    label162:
    for (i = j;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(178501);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(178500);
    s.u(paramViewGroup, "parent");
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(e.e.content);
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(178500);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(this.mContext, e.f.finder_location_preference_select, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(178500);
    return paramViewGroup;
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(178497);
    s.u(paramString, "<set-?>");
    this.countryCode = paramString;
    AppMethodBeat.o(178497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference
 * JD-Core Version:    0.7.0.1
 */