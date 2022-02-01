package com.tencent.mm.plugin.appbrand.backgroundrunning.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class AppBrandAuthPreference
  extends Preference
{
  private boolean edw;
  private String kYJ;
  private TextView kYK;
  private CheckBox kYL;
  
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
    this.edw = false;
    setLayoutResource(2131495538);
    AppMethodBeat.o(44802);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(44804);
    super.onBindView(paramView);
    this.kYL = ((CheckBox)paramView.findViewById(2131298639));
    if (this.kYL != null) {
      this.kYL.setChecked(this.edw);
    }
    this.kYK = ((TextView)paramView.findViewById(2131297088));
    if ((this.kYK != null) && (!Util.isNullOrNil(this.kYJ))) {
      this.kYK.setText(this.kYJ);
    }
    alO(8);
    AppMethodBeat.o(44804);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44803);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493064, localViewGroup);
    AppMethodBeat.o(44803);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(44806);
    this.edw = paramBoolean;
    if (this.kYL != null) {
      this.kYL.setChecked(paramBoolean);
    }
    AppMethodBeat.o(44806);
  }
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(44805);
    this.kYJ = this.mContext.getString(paramInt);
    AppMethodBeat.o(44805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference
 * JD-Core Version:    0.7.0.1
 */