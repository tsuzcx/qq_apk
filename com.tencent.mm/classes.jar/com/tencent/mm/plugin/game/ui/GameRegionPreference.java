package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference
  extends Preference
{
  GameRegionPreference.a lez;
  
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
    setLayoutResource(g.f.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(g.e.region_name);
    paramView = (CheckBox)paramView.findViewById(g.e.state_icon);
    if ((localTextView != null) && (paramView != null) && (this.lez != null))
    {
      localTextView.setText(f.a(this.lez));
      paramView.setChecked(this.lez.fmm);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(g.e.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(g.f.game_region_select_layout, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */