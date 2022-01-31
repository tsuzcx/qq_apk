package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference
  extends Preference
{
  GameRegionPreference.a nCu;
  
  public GameRegionPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameRegionPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameRegionPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112154);
    setLayoutResource(2130970179);
    AppMethodBeat.o(112154);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(112157);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131824745);
    paramView = (CheckBox)paramView.findViewById(2131824746);
    if ((localTextView != null) && (paramView != null) && (this.nCu != null))
    {
      localTextView.setText(e.a(this.nCu));
      paramView.setChecked(this.nCu.gDG);
    }
    AppMethodBeat.o(112157);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112156);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130969810, localViewGroup);
    AppMethodBeat.o(112156);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */