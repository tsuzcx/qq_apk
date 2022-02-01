package com.tencent.mm.plugin.appbrand.backgroundrunning.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class AppBrandAuthPreference
  extends Preference
{
  private boolean dAt;
  private String iYi;
  private TextView iYj;
  private CheckBox iYk;
  
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
    this.dAt = false;
    setLayoutResource(2131494804);
    AppMethodBeat.o(44802);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(44804);
    super.onBindView(paramView);
    this.iYk = ((CheckBox)paramView.findViewById(2131298255));
    if (this.iYk != null) {
      this.iYk.setChecked(this.dAt);
    }
    this.iYj = ((TextView)paramView.findViewById(2131296969));
    if ((this.iYj != null) && (!bt.isNullOrNil(this.iYi))) {
      this.iYj.setText(this.iYi);
    }
    Yb(8);
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
  
  public final void qR(int paramInt)
  {
    AppMethodBeat.i(44805);
    this.iYi = this.mContext.getString(paramInt);
    AppMethodBeat.o(44805);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(44806);
    this.dAt = paramBoolean;
    if (this.iYk != null) {
      this.iYk.setChecked(paramBoolean);
    }
    AppMethodBeat.o(44806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference
 * JD-Core Version:    0.7.0.1
 */