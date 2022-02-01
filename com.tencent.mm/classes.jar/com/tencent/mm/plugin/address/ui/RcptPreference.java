package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.base.preference.Preference;

public class RcptPreference
  extends Preference
{
  RcptItem kuR;
  
  public RcptPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RcptPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RcptPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(20973);
    setLayoutResource(2131495538);
    AppMethodBeat.o(20973);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(20975);
    super.onBindView(paramView);
    if (this.kuR == null)
    {
      AppMethodBeat.o(20975);
      return;
    }
    ((TextView)paramView.findViewById(2131310681)).setText(this.kuR.name);
    paramView = paramView.findViewById(16908312);
    if (paramView == null)
    {
      AppMethodBeat.o(20975);
      return;
    }
    if (this.kuR.ksW)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(20975);
      return;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(20975);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(20974);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495577, localViewGroup);
    AppMethodBeat.o(20974);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.RcptPreference
 * JD-Core Version:    0.7.0.1
 */