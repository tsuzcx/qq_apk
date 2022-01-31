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
  RcptItem gMR;
  
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
    AppMethodBeat.i(16929);
    setLayoutResource(2130970179);
    AppMethodBeat.o(16929);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(16931);
    super.onBindView(paramView);
    if (this.gMR == null)
    {
      AppMethodBeat.o(16931);
      return;
    }
    ((TextView)paramView.findViewById(2131826226)).setText(this.gMR.name);
    paramView = paramView.findViewById(16908312);
    if (paramView == null)
    {
      AppMethodBeat.o(16931);
      return;
    }
    if (this.gMR.gKT)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(16931);
      return;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(16931);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(16930);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970215, localViewGroup);
    AppMethodBeat.o(16930);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.RcptPreference
 * JD-Core Version:    0.7.0.1
 */