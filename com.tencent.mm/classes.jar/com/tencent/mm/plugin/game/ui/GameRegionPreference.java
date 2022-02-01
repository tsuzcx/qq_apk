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
  a xVD;
  
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
    AppMethodBeat.i(42353);
    setLayoutResource(2131495538);
    AppMethodBeat.o(42353);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(42355);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131306815);
    paramView = (CheckBox)paramView.findViewById(2131308377);
    if ((localTextView != null) && (paramView != null) && (this.xVD != null))
    {
      localTextView.setText(e.a(this.xVD));
      paramView.setChecked(this.xVD.isSelected);
    }
    AppMethodBeat.o(42355);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42354);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494941, localViewGroup);
    AppMethodBeat.o(42354);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public String fuO;
    public boolean isDefault;
    public boolean isSelected;
    public String xVE;
    public String xVF;
    public String xVG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */