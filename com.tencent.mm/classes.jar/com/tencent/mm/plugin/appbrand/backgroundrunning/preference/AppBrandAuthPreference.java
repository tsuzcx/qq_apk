package com.tencent.mm.plugin.appbrand.backgroundrunning.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class AppBrandAuthPreference
  extends Preference
{
  private boolean idG;
  public String qSG;
  private TextView qSH;
  private CheckBox qSI;
  
  public AppBrandAuthPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBrandAuthPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppBrandAuthPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(44802);
    this.idG = false;
    setLayoutResource(ba.g.mm_preference);
    AppMethodBeat.o(44802);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(44804);
    super.onBindView(paramView);
    this.qSI = ((CheckBox)paramView.findViewById(ba.f.checkbox));
    if (this.qSI != null) {
      this.qSI.setChecked(this.idG);
    }
    this.qSH = ((TextView)paramView.findViewById(ba.f.authSummary));
    if ((this.qSH != null) && (!Util.isNullOrNil(this.qSG))) {
      this.qSH.setText(this.qSG);
    }
    aBq(8);
    AppMethodBeat.o(44804);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44803);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(ba.f.content);
    localViewGroup.removeAllViews();
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(ba.g.app_brand_preference_auth, localViewGroup);
    AppMethodBeat.o(44803);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(44806);
    this.idG = paramBoolean;
    if (this.qSI != null) {
      this.qSI.setChecked(paramBoolean);
    }
    AppMethodBeat.o(44806);
  }
  
  public final void zB(int paramInt)
  {
    AppMethodBeat.i(44805);
    this.qSG = this.mContext.getString(paramInt);
    AppMethodBeat.o(44805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference
 * JD-Core Version:    0.7.0.1
 */