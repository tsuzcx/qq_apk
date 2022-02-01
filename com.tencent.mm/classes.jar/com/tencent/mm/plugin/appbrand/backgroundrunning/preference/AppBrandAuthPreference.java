package com.tencent.mm.plugin.appbrand.backgroundrunning.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;

public class AppBrandAuthPreference
  extends Preference
{
  private boolean dyf;
  private TextView jyA;
  private CheckBox jyB;
  private String jyz;
  
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
    this.dyf = false;
    setLayoutResource(2131494804);
    AppMethodBeat.o(44802);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(44804);
    super.onBindView(paramView);
    this.jyB = ((CheckBox)paramView.findViewById(2131298255));
    if (this.jyB != null) {
      this.jyB.setChecked(this.dyf);
    }
    this.jyA = ((TextView)paramView.findViewById(2131296969));
    if ((this.jyA != null) && (!bs.isNullOrNil(this.jyz))) {
      this.jyA.setText(this.jyz);
    }
    aam(8);
    AppMethodBeat.o(44804);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44803);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493025, localViewGroup);
    AppMethodBeat.o(44803);
    return paramViewGroup;
  }
  
  public final void rE(int paramInt)
  {
    AppMethodBeat.i(44805);
    this.jyz = this.mContext.getString(paramInt);
    AppMethodBeat.o(44805);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(44806);
    this.dyf = paramBoolean;
    if (this.jyB != null) {
      this.jyB.setChecked(paramBoolean);
    }
    AppMethodBeat.o(44806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference
 * JD-Core Version:    0.7.0.1
 */